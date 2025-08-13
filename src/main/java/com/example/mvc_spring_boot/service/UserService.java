package com.example.mvc_spring_boot.service;

import java.util.List;
import com.example.mvc_spring_boot.entity.User;
import com.example.mvc_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mauricio
 */

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
