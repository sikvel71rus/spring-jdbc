package com.nyubin.repository;

import com.nyubin.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.security.acl.LastOwnerException;

public interface UserRepo extends CrudRepository<User, LastOwnerException> {

    @Query("select * from users where user_name =:name")
    User findByUsername(@Param("name") String username);
}
