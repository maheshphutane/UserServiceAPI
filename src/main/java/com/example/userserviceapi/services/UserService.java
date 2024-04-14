package com.example.userserviceapi.services;

import com.example.userserviceapi.dtos.LoginReqDTO;
import com.example.userserviceapi.dtos.SignUpReqDTO;
import com.example.userserviceapi.models.User;
import com.example.userserviceapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<User> login(LoginReqDTO loginReqDTO) {
        String email = loginReqDTO.getEmail();
        String password = loginReqDTO.getPassword();
        User user = userRepository.getUserByEmailAndHashedPass(email,password);
        if(user==null)
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    public User signup(SignUpReqDTO signUpReqDTO) {
        User user = User.builder()
                .username(signUpReqDTO.getName())
                .email(signUpReqDTO.getEmail())
                .hashedPass(bCryptPasswordEncoder.encode(signUpReqDTO.getPassword()))
                .isEmailVerified(false)
                .rolesList(new ArrayList<>())
                .build();
        user.setCreatedAt(new Date());
        return userRepository.save(user);
    }
}
