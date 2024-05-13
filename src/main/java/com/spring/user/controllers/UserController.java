package com.spring.user.controllers;

import com.spring.user.entities.User;

import com.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    private ResponseEntity<User> createUser(@RequestBody User user)
    {

     User user1=userService.saveUser(user);
     return  new ResponseEntity<>(user1,HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    private  ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        User user= userService.getUser(userId);
        return  ResponseEntity.ok(user);

    }
    @GetMapping()
    private  ResponseEntity<List<User>> getAllUser()
    {
        List<User> users= userService.getAllUser();
        return  ResponseEntity.ok(users);

    }
}
