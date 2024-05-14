package com.example.userserviceapi.controllers;

import com.example.userserviceapi.dtos.LoginReqDTO;
import com.example.userserviceapi.dtos.LogoutReqDTO;
import com.example.userserviceapi.dtos.SignUpReqDTO;
import com.example.userserviceapi.dtos.UserDTO;
import com.example.userserviceapi.models.Token;
import com.example.userserviceapi.models.User;
import com.example.userserviceapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String sayHello(){
        return "<h1>Hello World!</h1>";
    }
    @PostMapping("/login")
    public ResponseEntity<Token> login(@RequestBody LoginReqDTO loginReqDTO){
        return userService.login(loginReqDTO);
    }
    @PostMapping("/signup")
    public User signUp(@RequestBody SignUpReqDTO signUpReqDTO){
        return userService.signup(signUpReqDTO);
    }
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutReqDTO logoutReqDTO){
        return userService.logout(logoutReqDTO.getValue());
    }
    @GetMapping("/validate/{token}")
    public UserDTO validate(@PathVariable String token){
        return userService.validate(token);
    }
}
