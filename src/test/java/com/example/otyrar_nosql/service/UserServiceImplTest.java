package com.example.otyrar_nosql.service;

import com.example.otyrar_nosql.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public  void checkMethodOfUserRepository()
    {
        String id = "63f376e7f9980f60b222227e";
        User user = userService.findUserById(id);
        System.out.println(user.getName());
    }
}
