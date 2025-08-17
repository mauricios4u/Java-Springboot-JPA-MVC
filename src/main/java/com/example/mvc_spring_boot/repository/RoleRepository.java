package com.example.mvc_spring_boot.repository;

import com.example.mvc_spring_boot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mauricio
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    
    
    
}
