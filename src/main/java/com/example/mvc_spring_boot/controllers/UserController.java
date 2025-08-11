package com.example.mvc_spring_boot.controllers;

import com.example.mvc_spring_boot.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mauricio
 */

@Controller
public class UserController {
    
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("usersList", this.userRepository.findAll());
        return "users";
    }
}
