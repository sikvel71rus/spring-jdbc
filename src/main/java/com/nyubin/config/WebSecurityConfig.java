package com.nyubin.config;

import com.nyubin.service.UserService;
import com.nyubin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/registration","/h2-console","/login").permitAll()
//                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login")
////                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//                .and().csrf().disable();
////                .formLogin().disable();
        http
//                HTTP Basic authentication
                .httpBasic()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .clearAuthentication(true)
                .logoutSuccessUrl("/logout.done")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
//                .logoutSuccessUrl("/")
//                .authorizeRequests()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/registration","/h2-console").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login?logout")
//                .invalidateHttpSession(true)
            .and()
                .headers()
                .frameOptions()
                .disable()
            .and()
                .authorizeRequests()
                .antMatchers("/registration","/h2-console","/useranswers").permitAll();
//                .anyRequest().authenticated()
//                .antMatchers(HttpMethod.GET, "/questions/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/questions").hasRole("USER")
//                .antMatchers(HttpMethod.GET, "/useranswers/**").hasRole("USER")
//                .antMatchers(HttpMethod.POST, "/useranswers").hasRole("USER")
//            .and()
//                .csrf().disable();
//                .formLogin().disable();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("2")
//                        .password("2")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

//        @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER");
//    }
}
