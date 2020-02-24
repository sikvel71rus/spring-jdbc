package com.nyubin.repository;

import com.nyubin.model.User;
import org.springframework.data.repository.CrudRepository;

import java.security.acl.LastOwnerException;

public interface UserRepo extends CrudRepository<User, LastOwnerException> {
}
