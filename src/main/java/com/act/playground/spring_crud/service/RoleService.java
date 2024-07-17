package com.act.playground.spring_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.act.playground.spring_crud.Repository.RoleRepository;
import com.act.playground.spring_crud.dto.PermissionDTO;
import com.act.playground.spring_crud.model.Role;
import com.act.playground.spring_crud.response.GeneralResponse;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    public GeneralResponse createRole(PermissionDTO permissionDTO){
        Role role=new Role();
        role.setName(permissionDTO.getName());
        role.setCanCreateAdmin(permissionDTO.canCreateAdmin());
        role.setCanUpdateAdmin(permissionDTO.canUpdateAdmin());
        role.setCanDeleteAdmin(permissionDTO.canDeleteAdmin());
        role.setCanReadAdmin(permissionDTO.canReadAdmin());

        role.setCanCreateRole(permissionDTO.canCreateRole());
        role.setCanUpdateRole(permissionDTO.canUpdateRole());
        role.setCanDeleteRole(permissionDTO.canDeleteRole());
        role.setCanReadRole(permissionDTO.canReadRole());

        role.setCanCreateUser(permissionDTO.canCreateUser());
        role.setCanUpdateUser(permissionDTO.canUpdateUser());
        role.setCanDeleteUser(permissionDTO.canDeleteUser());
        role.setCanReadUser(permissionDTO.canReadUser());

        role.setCanCreateTeacher(permissionDTO.canCreateTeacher());
        role.setCanUpdateTeacher(permissionDTO.canUpdateTeacher());
        role.setCanDeleteTeacher(permissionDTO.canDeleteTeacher());
        role.setCanReadTeacher(permissionDTO.canReadTeacher());

       Role createdRole=  roleRepository.save(role);
       return new GeneralResponse("role Successfully Created", true,createdRole);
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
