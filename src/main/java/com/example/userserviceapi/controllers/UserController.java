package com.example.userserviceapi.controllers;

import com.example.userserviceapi.dtos.LoginReqDTO;
import com.example.userserviceapi.dtos.LogoutReqDTO;
import com.example.userserviceapi.dtos.SignUpReqDTO;
import com.example.userserviceapi.models.User;
import com.example.userserviceapi.services.TokenService;
import com.example.userserviceapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginReqDTO loginReqDTO){
        return userService.login(loginReqDTO);
    }
    @PostMapping("/signup")
    public User signUp(@RequestBody SignUpReqDTO signUpReqDTO){
        return userService.signup(signUpReqDTO);
    }
    @DeleteMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutReqDTO logoutReqDTO){
        return tokenService.logout(logoutReqDTO);
    }
}
