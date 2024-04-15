package com.example.userserviceapi.repositories;

import com.example.userserviceapi.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findTokenByValueAndDeletedAndExpiryAtGreaterThan(String value, boolean isDeleted, Date expiryAt);
    Token save(Token token);

    Token findTokenByValueAndDeleted(String value, boolean isDeleted);
}
