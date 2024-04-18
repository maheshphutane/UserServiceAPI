package com.example.userserviceapi.security.services;

import com.example.userserviceapi.models.User;
import com.example.userserviceapi.repositories.UserRepository;
import com.example.userserviceapi.security.models.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(username);
        if(user.isEmpty())
            throw new UsernameNotFoundException("User not found");


        return new CustomUserDetails(user.get());
    }
}
