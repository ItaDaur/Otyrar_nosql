package com.example.otyrar_nosql.service;

import com.example.otyrar_nosql.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    void save(User user);

   /* boolean provenAccount(String name, String password);*/

    User findUserByEmail(String name);

    User findUserById(String id);

    List<User> getAllUsers();

    void deleteUser(String id);
    User updateUser(User user);

}
