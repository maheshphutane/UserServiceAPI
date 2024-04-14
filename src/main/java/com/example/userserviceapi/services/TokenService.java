package com.example.userserviceapi.services;

import com.example.userserviceapi.dtos.LogoutReqDTO;
import com.example.userserviceapi.models.Token;
import com.example.userserviceapi.repositories.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    public ResponseEntity<Void> logout(LogoutReqDTO logoutReqDTO) {
        Token t = tokenRepository.findTokenByValue(logoutReqDTO.getValue());
        if(t==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            tokenRepository.deleteTokenByValue(logoutReqDTO.getValue());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
