package com.example.mvc_spring_boot.controllers;

import com.example.mvc_spring_boot.entity.User;
import com.example.mvc_spring_boot.repository.UserRepository;
import com.example.mvc_spring_boot.service.UserService;
import jakarta.validation.Valid;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mauricio
 */

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    // contrutor desnecessário agora com @Autowired
    //public UserController(UserRepository userRepository) {
    //    this.userRepository = userRepository;
    //}
    
    @GetMapping("/list")
    public String getUsers(Model model){
        model.addAttribute("usersList", this.userService.findAll());
        return "users";
    }
    
    @GetMapping
    public String getUser(Model model){
        model.addAttribute("user", new User());
        return "user";
    }
        
    // Formulário preenchido (editar)
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User u = userService.findById(id);
        model.addAttribute("user", u);
        return "user"; // mesma página do cadastro, mas com dados preenchidos
    }
    
    @PostMapping("/save")
    public String submitUser(
        @Valid @ModelAttribute("user") User user,
        BindingResult result,
        Model model) {

    if (result.hasErrors()) {
        return "user"; // volta para o formulário exibindo erros
    }

    userService.add(user);
    return "redirect:/user/list";
}
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/user/list";
    }
    
}
