package com.example.userserviceapi.services;

import com.example.userserviceapi.models.User;
import com.example.userserviceapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new RuntimeException("User Not Found");
        }else{
            return optionalUser.get();
        }
    }

    public List<User> limitUsersBy(long limit){
        return userRepository.findDistinctTopN(limit);
    }

    public List<User> sortUsersBy(String sortOrder){
        return userRepository.findUsersSortedById(sortOrder);
    }
}
