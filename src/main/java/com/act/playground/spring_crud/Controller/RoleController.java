package com.act.playground.spring_crud.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.playground.spring_crud.dto.PermissionDTO;
import com.act.playground.spring_crud.response.GeneralResponse;
import com.act.playground.spring_crud.service.RoleService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    
    @PostMapping("/createRole")
    public ResponseEntity <GeneralResponse> createRole(@RequestBody PermissionDTO PermissionDTO) {

         return new ResponseEntity<>(roleService.createRole(PermissionDTO),HttpStatus.OK);
    }

}
