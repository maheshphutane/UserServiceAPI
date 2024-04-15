package com.example.userserviceapi.services;

import com.example.userserviceapi.dtos.LoginReqDTO;
import com.example.userserviceapi.dtos.SignUpReqDTO;
import com.example.userserviceapi.models.Token;
import com.example.userserviceapi.models.User;
import com.example.userserviceapi.repositories.TokenRepository;
import com.example.userserviceapi.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ResponseEntity<Token> login(LoginReqDTO loginReqDTO) {
        String email = loginReqDTO.getEmail();
        String password = loginReqDTO.getPassword();
        Optional<User> userOptional = userRepository.findUserByEmail(email);
        if(userOptional.isEmpty())
            return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);

        User user = userOptional.get();
        if(!bCryptPasswordEncoder.matches(password, user.getHashedPass())){
            return new ResponseEntity<Token>(HttpStatus.NOT_FOUND);
        }

        LocalDate currentDate = LocalDate.now();

        // Get the date 30 days later
        LocalDate date30DaysLater = currentDate.plusDays(30);

        Token token = new Token();
        token.setExpiryAt(Date.from(date30DaysLater.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        token.setUser(user);
        token.setValue(RandomStringUtils.randomAlphanumeric(128));

        Token t = tokenRepository.save(token);

        return new ResponseEntity<Token>(t,HttpStatus.OK);
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

    public ResponseEntity<Void> logout(String value){
        Token token = tokenRepository.findTokenByValueAndDeleted(value,false);
        if(token==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        token.setDeleted(true);
        tokenRepository.save(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<User> validate(String token) {
        Token t = tokenRepository.findTokenByValueAndDeletedAndExpiryAtGreaterThan(token,false,new Date());
        if(t==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(t.getUser(),HttpStatus.OK);
    }
}
