package com.example.userserviceapi.repositories;

import com.example.userserviceapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    Optional<User> findById(Long id);
    List<User> findDistinctTopN(long limit);
    List<User> findUsersSortedById(String sortOrder);
    void deleteById(Long id);
}
