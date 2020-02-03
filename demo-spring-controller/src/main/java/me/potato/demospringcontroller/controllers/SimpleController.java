package me.potato.demospringcontroller.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.potato.demospringcontroller.models.User;

@RestController
@RequestMapping("/users")
public class SimpleController {

    Map<String, User> users = new HashMap<>();

    @PostMapping
    public User createUser(@RequestBody final User user) {
        users.put(user.getUserId(), user);
        return users.get(user.getUserId());
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable final String userId) {
        final User aUser = users.get(userId);
        return aUser;
    }
}