package com.act.playground.spring_crud.service;

import java.util.List;
import java.util.Optional;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.act.playground.spring_crud.Repository.UserRepository;
import com.act.playground.spring_crud.model.User;
import com.act.playground.spring_crud.response.GeneralResponse;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    

    public GeneralResponse registerUser(User user){
        try {
            if (userRepository.existsByEmail(user.getEmail())) {
                return new GeneralResponse("user already exist", false,user);    
            }
          
           // User user = new User();
           String hashPassword= this.passwordEncoder.encode(user.getPassword());
            user.setEmail(user.getEmail());
            user.setFullname(user.getFullname());
            user.setPassword(hashPassword);
            user.setPhone(user.getPhone());
           User registerdUser= userRepository.save(user);
            return new GeneralResponse("User registered successfully", true,registerdUser);
        } catch (Exception e) {
            return new GeneralResponse(e.getMessage(), false);
        }
    }

    public List<User> getAlluser(){
        return userRepository.findAll();
    }

    public Optional<GeneralResponse> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return Optional.of(new GeneralResponse("User found: " + user.getFullname() + ", email: " + user.getEmail() +",Phone: "+user.getPhone(), true, user));
        } else {
            return Optional.of(new GeneralResponse("User not found with id: " + id, false));
        }
    }

    public GeneralResponse deleteUser(Long id){
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (userOptional.isPresent()) {
             User user = userOptional.get();
            userRepository.delete(user);
            return new GeneralResponse("User deleted successfully", true);
             } else {
             return new GeneralResponse("User not found with id: " + id, false);
             }
        } catch (Exception e) {
            return new GeneralResponse(e.getMessage(), false);
        }

    }

    public GeneralResponse updatedUser(Long id,User updatedUser){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String hashPassword = this.passwordEncoder.encode(updatedUser.getPassword());
    
            user.setEmail(updatedUser.getEmail());
            user.setFullname(updatedUser.getFullname());
            user.setPassword(hashPassword);
            user.setPhone(updatedUser.getPhone());
    
            User savedUser = userRepository.save(user);
            return new GeneralResponse("User updated successfully ", true,savedUser);
        } else {
            return new GeneralResponse("User not found with id: " + id, false);
        }

    }
}