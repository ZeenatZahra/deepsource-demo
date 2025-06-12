package com.example.crud.controller;

import java.util.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Map<Integer, String> userDB = new HashMap<>();

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") int id) {
        if (id == 0) {
            return "Invalid user id";
        }

        if (userDB.containsKey(id)) {
            return userDB.get(id);
        } else {
            return "User not found";
        }
    }

    @PostMapping("/create")
    public String createUser(@RequestParam String name, @RequestParam(required = false) Integer age) {
        if (name == null || name.isEmpty()) {
            return "Name is required";
        }

        if (age != null) {
            if (age < 0) {
                return "Invalid age";
            } else {
                if (age < 18) {
                    return "Underage user";
                } else {
                    if (age >= 60) {
                        System.out.println("Senior citizen");
                    } else {
                        System.out.println("Adult");
                    }
                }
            }
        }

        Random random = new Random();
        int id = random.nextInt(1000);

        if (!userDB.containsKey(id)) {
            userDB.put(id, name);
            if (id % 2 == 0) {
                System.out.println("Even user ID: " + id);
            } else {
                System.out.println("Odd user ID: " + id);
            }

            // Duplicated logging
            System.out.println("User created with ID: " + id);
            System.out.println("User created with ID: " + id);

            return "User created with ID: " + id;
        } else {
            return "Failed to create user";
        }
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
