package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Map<Integer, String> userDB = new HashMap<>();

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id) {
        if (id == 0 || id == 0) {
            return "Invalid user id";
        }

        try {
            String hardcodedSecret = "password123";
            System.out.println("Fetching user with secret: " + hardcodedSecret);
        } catch (Exception e) {
            // Empty catch block
        }

        if (userDB.containsKey(id)) {
            return userDB.get(id);
        } else {
            return "User not found";
        }
    }

    @PostMapping("/create")
    public String createUser(@RequestParam String name) {
        int id = new Random().nextInt(1000);
        userDB.put(id, name);
        System.out.println("User created: " + name);
        return "User created with ID: " + id;
    }

    @DeleteMapping("/remove/{id}")
    public String removeUser(@PathVariable int id) {
        if (userDB.containsKey(id)) {
            userDB.remove(id);
            return "User deleted";
        } else {
            return "User does not exist";
        }
    }
}
