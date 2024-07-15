package com.act.playground.spring_crud.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.playground.spring_crud.model.User;
import com.act.playground.spring_crud.response.GeneralResponse;
import com.act.playground.spring_crud.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    // public ResponseEntity <User> registerUser(@RequestBody User user) {
    // User registeredUser=userService.registerUser(user);

    public ResponseEntity<GeneralResponse> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.registerUser(user.getEmail(),user.getFullname(),user.getPhone(),user.getPassword()), HttpStatus.OK);
    }

    @GetMapping("/allUser")
    public ResponseEntity<List<User>> getAlluser() {
        List<User> allUser = userService.getAlluser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<GeneralResponse> getUserByIde(@PathVariable long id) {
        Optional<GeneralResponse> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("update/{id}")
    public ResponseEntity<GeneralResponse> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        GeneralResponse user = userService.updatedUser(id, updatedUser);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<GeneralResponse> deleteUser(@PathVariable Long id) {     
        return new ResponseEntity <>(userService.deleteUser(id),HttpStatus.OK);

    }

}
