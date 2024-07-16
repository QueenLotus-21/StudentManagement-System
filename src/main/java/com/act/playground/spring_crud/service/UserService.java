package com.act.playground.spring_crud.service;

import java.util.List;
import java.util.Optional;  
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.act.playground.spring_crud.Repository.UserRepository;
import com.act.playground.spring_crud.Token.JwtUtil;
import com.act.playground.spring_crud.model.User;
import com.act.playground.spring_crud.response.GeneralResponse;

import ch.qos.logback.core.util.StringUtil;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    
    
    public GeneralResponse registerUser(String email,String fullname,String phone,String password){
        try {
            
            if (userRepository.existsByEmail(email)) {
                return new GeneralResponse("user already existed", false);    
            }
            
            boolean username=StringUtil.isNullOrEmpty(fullname);
            boolean emailV=StringUtil.isNullOrEmpty(email);
            boolean phoneV=StringUtil.isNullOrEmpty(phone);
            boolean passwordV=StringUtil.isNullOrEmpty(password);
            if(username || emailV || phoneV || passwordV){
                return new GeneralResponse("please provide all fields", false);
            }
            if (password.length() <8) {
                return new GeneralResponse("password must be atleast 8 character", false);
            }

            if ((phone.length()) != 10) {
                return new GeneralResponse("Invalid phone number digit", false);
            }
            if (!(phone.startsWith("09") || phone.startsWith("07"))) {
                return new GeneralResponse("Phone number must start with 09 or 07", false);
            }

           User user = new User();
           String hashPassword= this.passwordEncoder.encode(password);
            user.setEmail(email );
            user.setFullname(fullname);
            user.setPassword(hashPassword);
            user.setPhone(phone);
            
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
    private boolean isUserDetailsChanged(Optional<User> existingUserOptional, User userUpdateRequest) {
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            boolean isPasswordUpdated = !this.passwordEncoder.matches(userUpdateRequest.getPassword(), existingUser.getPassword());
            return !existingUser.getFullname().equals(userUpdateRequest.getFullname())
                    || !existingUser.getEmail().equals(userUpdateRequest.getEmail())
                    || !existingUser.getPhone().equals(userUpdateRequest.getPhone())
                    || isPasswordUpdated;
        } else {
            return true; 
        }
    }

    public GeneralResponse updatedUser(Long id,User updatedUser){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            
                if ((updatedUser.getPassword()).length() < 8) {
                    return new GeneralResponse("password must be atleast 8 character", false);
                }
                if ((updatedUser.getPhone()).length() != 10) {
                    return new GeneralResponse("phone number must be 10 digit", false);
                }
                if (!(updatedUser.getPhone().startsWith("09") || updatedUser.getPhone().startsWith("07"))) {
                    return new GeneralResponse("phone number must starts with 09 or 07", false);
                }

            if (isUserDetailsChanged(userOptional,updatedUser)) {
                String hashPassword = this.passwordEncoder.encode(updatedUser.getPassword());
    
                user.setEmail(updatedUser.getEmail());
                user.setFullname(updatedUser.getFullname());
                user.setPassword(hashPassword);
                user.setPhone(updatedUser.getPhone());   
                User savedUser = userRepository.save(user);
                return new GeneralResponse("User updated successfully ", true,savedUser);
            }
            else{
                return new GeneralResponse("there is no user details change ", false);
            }
            
        } else {
            return new GeneralResponse("User not found with id: " + id, false);
        }
    }
   
    public  GeneralResponse login(String email,String password ,HttpServletResponse response){
      if ( userRepository.existsByEmail(email)) {
        try {
            User user= userRepository.findByEmail(email);
            boolean isValid=email.equalsIgnoreCase(user.getEmail()) 
            && passwordEncoder.matches(password,user.getPassword());

            if (isValid) {
                String jwtToken=JwtUtil.generateToken(user);
                setAuthorizationHeader(response, jwtToken);
                return new GeneralResponse(jwtToken, true);    
            } 
            else{
                return new GeneralResponse("Access Denied,Invalid Credencial", false);
            }

            
        } catch (Exception e) {
            return new GeneralResponse(e.getMessage(), false);
        }
      
      }
      else{
        return new GeneralResponse("User not found", false);
      }
        
    }
    public void setAuthorizationHeader(HttpServletResponse response, String jwtToken) {
        if (jwtToken != null) {
            response.setHeader("Authorization", "Bearer " + jwtToken);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
     
}