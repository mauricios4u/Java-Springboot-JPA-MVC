package com.example.mvc_spring_boot.config;

import com.example.mvc_spring_boot.StatusRole;
import com.example.mvc_spring_boot.entity.Role;
import com.example.mvc_spring_boot.entity.User;
import com.example.mvc_spring_boot.repository.RoleRepository;
import com.example.mvc_spring_boot.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mauricio
 */
@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); 
        List<Role> roles = roleRepository.findAll();
        if(roles.isEmpty()){
            createRole("Admin");
            createRole("Professor");
            createRole("Aluno");
        }
        
        List<User> usuarios = userRepository.findAll();
        if(usuarios.isEmpty()){
            createUser("Maurício", "mauricio.quednau@gmail.com");
            createUser("Sites4u", "mauricio@sites4u.com.br");
        }
        
        //List<User> users = userRepository.findByNomeLike("Mau");
        //System.out.println(users.get(0).getNome());
        User u = userRepository.findByNome("Maurício");
        System.out.println(u.getNome());
        
    }
    
    public void createUser(String name, String email){
        User u = new User(name, email);
        userRepository.save(u);
    }
    
    public void createRole(String name){
        Role r = new Role(name);
        r.setStatus(StatusRole.ATIVO);
        roleRepository.save(r);
    }
    
    
    
}
