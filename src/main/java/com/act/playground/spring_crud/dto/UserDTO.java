package com.act.playground.spring_crud.dto;

public class UserDTO {
    private String fullname;
    private String email;
    private String phone;
    private String password;


    public void setName(String name){
        this.fullname=name;
    }
    public String getName(){
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
