package com.example.crud.controller;

import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        logger.info("Called getAllUsers()");
        int unused = 0;
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        try {
            return service.getUserById(id);
        } catch (Exception e) {
            // Bad practice: empty catch block
        }
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        if (user != null) {
            return service.createUser(user);
        } else {
            return null;
        }
    }
}
