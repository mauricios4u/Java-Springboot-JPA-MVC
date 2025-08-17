package com.example.mvc_spring_boot.service;

import java.util.List;
import com.example.mvc_spring_boot.entity.User;
import com.example.mvc_spring_boot.repository.UserRepository;
import java.util.Optional;
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
    
    public List<User> search(String name){
        return userRepository.findByNomeLike(name);
    }
    
    public User findById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }
    
    public boolean add(User user){
        if(user.getNome() == "" || user.getEmail() == ""){
            return false;
        }
        
        userRepository.save(user);
        return true;
    }
    
    public void save(User user){
        userRepository.save(user);
    }
    
    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
