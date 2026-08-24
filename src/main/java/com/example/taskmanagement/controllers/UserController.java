package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.User;
import com.example.taskmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String search) {
        List<User> users = userService.findAllUsers();
        
        if (search != null && !search.trim().isEmpty()) {
            users = users.stream()
                    .filter(user -> user.getUsername().toLowerCase().contains(search.toLowerCase()))
                    .collect(Collectors.toList());
        }
        
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User user) {
        if(userService.updateUser(id,user)==null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable long id) {
        User user=userService.deleteUser(id);
        if(user==null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(user);
        }
    }
}
