package com.act.playground.spring_crud;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloContoller {
    @GetMapping("/")
    
    public String hello(){
        return "hello, TIG";
    }
    
}
