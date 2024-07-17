package com.act.playground.spring_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.playground.spring_crud.Repository.RoleRepository;
import com.act.playground.spring_crud.model.Role;
import com.act.playground.spring_crud.response.GeneralResponse;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    // public GeneralResponse createRole(String name,boolean canCreateAdmin,boolean canDeleteAdmin,boolean canReadAdmin,boolean canUpdateAdmin,
    // boolean canCreateRole,boolean canDeleteRole,boolean canUpdateRole,boolean canReadRole,boolean canCreateTeacher,boolean canDeleteTeacher,
    // boolean canUpdateTeacher,boolean canReadTeacher,boolean canCreateUser,boolean canDeleteUser,boolean canUpdateUser,boolean canReadUser){
        public GeneralResponse createRole(Role role){
        // Role role=new Role();
        // role.setName(name);
        // role.setCanCreateAdmin(canCreateAdmin);
        // role.setCanDeleteAdmin(canDeleteAdmin);
        // role.setCanUpdateAdmin(canUpdateAdmin);
        // role.setCanReadAdmin(canReadAdmin);

        // role.setCanCreateRole(canCreateRole);
        // role.setCanUpdateRole(canUpdateRole);
        // role.setCanReadRole(canReadRole);
        // role.setCanDeleteRole(canDeleteRole);

        // role.setCanCreateUser(canCreateUser);
        // role.setCanUpdateUser(canUpdateUser);
        // role.setCanReadUser(canReadUser);
        // role.setCanDeleteUser(canDeleteUser);

        // role.setCanCreateTeacher(canCreateTeacher);
        // role.setCanUpdateTeacher(canUpdateRole);
        // role.setCanReadTeacher(canReadTeacher);
        // role.setCanDeleteTeacher(canDeleteTeacher);

       Role createdRole=  roleRepository.save(role);
       return new GeneralResponse("user Successfully Created", true,createdRole);
    }

    public List<Role> getAllRoles(String name){
          return roleRepository.findAll();
    }

    public Role getRole(String name){
        return roleRepository.findByName(name);
    }

    public GeneralResponse deleteRole(String name){
        Role role=roleRepository.findByName(name);
        roleRepository.delete(role);
        return new GeneralResponse("Role sucessfully deleted", true);
    }
}
