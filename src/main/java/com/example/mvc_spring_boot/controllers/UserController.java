package com.example.mvc_spring_boot.controllers;

import com.example.mvc_spring_boot.entity.User;
import com.example.mvc_spring_boot.repository.UserRepository;
import com.example.mvc_spring_boot.service.UserService;
import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping
    @RequestMapping("/user")
    public String getUser(Model model){
        model.addAttribute("user", new User());
        return "user";
    }
    
    @PostMapping("/user")
    public String submitUser(@ModelAttribute User user, Model model){
        User u = new User(user.getNome(), user.getEmail());
        userService.add(u);

        model.addAttribute("usersList", this.userService.findAll());        
        return "users";
    }
    
}
