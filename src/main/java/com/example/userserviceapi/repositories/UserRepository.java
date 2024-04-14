package com.example.userserviceapi.repositories;

import com.example.userserviceapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email = :email and u.hashedPass = :hashedPass")
    User getUserByEmailAndHashedPass(@Param("email") String email, @Param("hashedPass") String hashedPass);
    User save(User user);
}
