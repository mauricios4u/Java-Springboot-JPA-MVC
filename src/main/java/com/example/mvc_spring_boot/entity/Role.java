package com.example.mvc_spring_boot.entity;

import com.example.mvc_spring_boot.StatusRole;
import jakarta.persistence.*;


/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    @Enumerated(EnumType.STRING)
    private StatusRole status;
    
    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusRole getStatus() {
        return status;
    }

    public void setStatus(StatusRole status) {
        this.status = status;
    }
    
    
    
}
