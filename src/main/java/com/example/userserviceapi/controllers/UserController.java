package com.example.userserviceapi.controllers;

import com.example.userserviceapi.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @GetMapping("")
    public List<User> getAllUsers(){
        return null;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        return null;
    }

    @GetMapping()
    public List<User> limitUsersBy(@RequestParam String limit){
        return null;
    }

    @GetMapping()
    public List<User> sortUsersBy(@RequestParam String sort){
        return null;
    }

    @PostMapping()
    public User addUser(@RequestBody User user){
        return null;
    }
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id,@RequestBody User user){
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id){
        return null;
    }

}
