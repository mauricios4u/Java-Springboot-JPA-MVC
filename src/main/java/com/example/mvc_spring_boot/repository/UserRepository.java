package com.example.mvc_spring_boot.repository;

import com.example.mvc_spring_boot.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mauricio
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    /* Com spring.data.jpa, ao chamar método 'findBy' + nome da coluna no banco (atributo da entidade), ele faz a query olhando para coluna respectiva */
    User findByNome(String name);
    
    List<User> findByNomeLike(String name);
    /* Métodos mágicos, customizando as queries (JPQL) */
    // @Query("select * from users where nome like %?1%")
    // List<User> findByNomeLike(String name);
    
}
