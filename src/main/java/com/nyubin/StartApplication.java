package com.nyubin;

import com.nyubin.model.Book;
import com.nyubin.model.Customer;
import com.nyubin.repository.CustomerRepository;
import com.nyubin.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// https://spring.io/guides/gs/relational-data-access/
// https://docs.spring.io/spring/docs/current/spring-framework-reference/data-access.html#jdbc
@SpringBootApplication
public class StartApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("bookRepositoryImpl")              // Test JdbcTemplate
//    @Qualifier("namedParameterJdbcBookRepository")  // Test NamedParameterJdbcTemplate
    private BookRepository bookRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Bean
    public LobHandler lobHandler() {
        return new DefaultLobHandler();
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");

        startCustomerApp();

    }

    // Tested with H2 database
    void startCustomerApp() {

        jdbcTemplate.execute("DROP TABLE CUSTOMER IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE CUSTOMER(" +
                "id SERIAL, name VARCHAR(255), age NUMERIC(2), created_date timestamp)");

        List<Customer> list = Arrays.asList(
                new Customer("Customer A", 19),
                new Customer("Customer B", 20),
                new Customer("Customer C", 21),
                new Customer("Customer D", 22)
        );

        list.forEach(x -> {
            log.info("Saving...{}", x.getName());
            customerRepository.save(x);
        });

        log.info("[FIND_BY_ID]");
        log.info("{}", customerRepository.findByCustomerId(1L));
        log.info("{}", customerRepository.findByCustomerId2(2L));
        log.info("{}", customerRepository.findByCustomerId3(3L));

        log.info("[FIND_ALL]");
        log.info("{}", customerRepository.findAll());
        log.info("{}", customerRepository.findAll2());
        log.info("{}", customerRepository.findAll3());
        log.info("{}", customerRepository.findAll4());

        log.info("[FIND_NAME_BY_ID]");
        log.info("{}", customerRepository.findCustomerNameById(4L));

        log.info("[COUNT]");
        log.info("{}", customerRepository.count());

    }

    void startBookApp() {

        log.info("Creating tables for testing...");

        jdbcTemplate.execute("DROP TABLE books IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE books(" +
                "id SERIAL, name VARCHAR(255), price NUMERIC(15, 2))");

        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", new BigDecimal("46.32")),
                new Book("Mkyong in Java", new BigDecimal("1.99")),
                new Book("Getting Clojure", new BigDecimal("37.3")),
                new Book("Head First Android Development", new BigDecimal("41.19"))
        );

        log.info("[SAVE]");
        books.forEach(book -> {
            log.info("Saving...{}", book.getName());
            bookRepository.save(book);
        });

        // count
        log.info("[COUNT] Total books: {}", bookRepository.count());

        // find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());

        // find by id
        log.info("[FIND_BY_ID] :2L");
        Book book = bookRepository.findById(2L).orElseThrow(IllegalArgumentException::new);
        log.info("{}", book);

        // find by name (like) and price
        log.info("[FIND_BY_NAME_AND_PRICE] : like '%Java%' and price <= 10");
        log.info("{}", bookRepository.findByNameAndPrice("Java", new BigDecimal(10)));

        // get name (string) by id
        log.info("[GET_NAME_BY_ID] :1L = {}", bookRepository.findNameById(1L));

        // update
        log.info("[UPDATE] :2L :99.99");
        book.setPrice(new BigDecimal("99.99"));
        log.info("rows affected: {}", bookRepository.update(book));

        // delete
        log.info("[DELETE] :3L");
        log.info("rows affected: {}", bookRepository.deleteById(3L));

        // find all
        log.info("[FIND_ALL] {}", bookRepository.findAll());

    }

    // Tested with PostgreSQL bytea, it should works in other database binary type
    void startInsertImageWithPostgreSQL() {

        jdbcTemplate.execute("DROP TABLE book_image");

        jdbcTemplate.execute("CREATE TABLE book_image(" +
                "id SERIAL, book_id integer, filename varchar(255), blob_image bytea)");

        // save an image into database
        bookRepository.saveImage(1L, new File("D:\\java-logo.png"));
        bookRepository.saveImage(1L, new File("D:\\abc.jpg"));

        // get images from database
        List<Map<String, InputStream>> images = bookRepository.findImageByBookId(1L);

        String fileOutput = "D:\\output\\";
        try {
            Files.createDirectories(Paths.get(fileOutput));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map<String, InputStream> image : images) {
            // filename, image_in_stream
            image.forEach((k, v) -> {
                try {
                    Files.copy(v, Paths.get(fileOutput + k));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println("Done");

    }

    void startLargeResultSet() {

        // if large data, it may prompts java.lang.OutOfMemoryError: Java heap space
        /*List<Book> list = bookRepository.findAll();

        for (Book book : list) {
            //process it
        }*/

        // try RowCallbackHandler for large data
        jdbcTemplate.query("select * from books", new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                while (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    // process it
                }
            }
        });

    }


}