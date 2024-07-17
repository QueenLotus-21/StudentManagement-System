package com.act.playground.spring_crud.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.act.playground.spring_crud.model.Role;
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
    public ResponseEntity <GeneralResponse> createRole(@RequestBody Role role) {

         return new ResponseEntity<>(roleService.createRole(role),HttpStatus.OK);
    }
    
    // public ResponseEntity<GeneralResponse> createRole(@RequestBody Role role) {

    //     GeneralResponse GRole=roleService.createRole(role.getName(), role.canCreateAdmin(), role.canDeleteAdmin(), role.canReadAdmin(), role.canUpdateAdmin(),
    //       role.canCreateRole(), role.canDeleteRole(), role.canUpdateRole(), role.canReadRole(), 
    //       role.canCreateTeacher(), role.canDeleteTeacher(), role.canUpdateTeacher(), role.canReadTeacher(), 
    //       role.canCreateUser(), role.canDeleteUser(), role.canUpdateUser(), role.canReadUser());
    //       //List<E> permission=new ArrayList<>();
    //       //permission.add(role.isCanCreateAdmin);
    //     return new ResponseEntity<>(GRole,HttpStatus.OK);
    // }
    

}
