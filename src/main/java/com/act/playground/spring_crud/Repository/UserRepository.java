package com.act.playground.spring_crud.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.act.playground.spring_crud.model.User;




public interface UserRepository extends JpaRepository<User, Long>{
   boolean existsByEmail(String email);
   User findByEmail(String email);

} 
