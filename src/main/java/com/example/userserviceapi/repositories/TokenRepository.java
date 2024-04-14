package com.example.userserviceapi.repositories;

import com.example.userserviceapi.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
    Token findTokenByValue(String value);
    Token deleteTokenByValue(String value);
}
