package com.example.mvc_spring_boot.controllers;

import com.example.mvc_spring_boot.repository.UserRepository;
import com.example.mvc_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Mauricio
 */

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;

    // contrutor desnecessário agora com @Autowired
    //public UserController(UserRepository userRepository) {
    //    this.userRepository = userRepository;
    //}
    
    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("usersList", this.userService.findAll());
        return "users";
    }
}
