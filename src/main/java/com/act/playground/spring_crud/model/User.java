package com.act.playground.spring_crud.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    
    @Column(name = "fullname",nullable = false)
    private String fullname;

    @Column(name = "password",nullable = false)
    private String password;
    
    @Column(name = "phone",nullable = false,unique = true)
    private String phone;


    //getter and setter method

    public User() {
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }

    
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public String getFullname(){
        return fullname;
    }


    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }

    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return password;
    }

}
