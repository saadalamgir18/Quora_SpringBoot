package com.backend.Quora.controller;

import com.backend.Quora.Services.UserService;
import com.backend.Quora.Services.UserServiceImpl;
import com.backend.Quora.models.User;
import com.backend.Quora.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {
//    CustomResponse customResponse;
    UserService userService;
    UserController(UserService userService){
        this.userService = userService;
//        this.customResponse = customResponse;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser= userService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        System.out.println("hitting users");
        List<User> users = userService.findAll();

        return ResponseEntity.ok(users);
    }
    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable UUID userId){
        System.out.println("hitting users");
        Optional<User> user = userService.findById(userId);
        if (user.isEmpty()){
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(user);
    }


}
