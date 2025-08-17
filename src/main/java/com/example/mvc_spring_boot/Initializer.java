package com.example.mvc_spring_boot;

import com.example.mvc_spring_boot.repository.RoleRepository;
import com.example.mvc_spring_boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 *
 * @author Mauricio
 */
public class Initializer implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        
    }
    
}
