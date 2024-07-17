package com.act.playground.spring_crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {  
    
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Column(name = "name",nullable=false)
 private String name;
 @Column(name = "can_create_user")
 private boolean canCreateUser = false;
 @Column(name = "can_Delete_user")
 private boolean canDeleteUser=false;
 @Column(name = "can_Update_user")
 private boolean canUpdateUser=false;
 @Column(name = "can_Read_user")
 private boolean canReadUser=false;

 @Column(name = "can_create_Admin")
 private boolean canCreateAdmin=false;
 @Column(name = "can_Delete_Admin")
 private boolean canDeleteAdmin=false;
 @Column(name = "can_Update_Admin")
 private boolean canUpdateAdmin=false;
 @Column(name = "can_Read_Admin")
 private boolean canReadAdmin=false;

 @Column(name = "can_create_Role")
 private boolean canCreateRole=false;
 @Column(name = "can_Delete_Role")
 private boolean canDeleteRole=false;
 @Column(name = "can_Update_Role")
 private boolean canUpdateRole=false;
 @Column(name = "can_Read_Role")
 private boolean canReadRole=false;

 @Column(name = "can_create_Teacher")
 private boolean canCreateTeacher=false;
 @Column(name = "can_Delete_Teacher")
 private boolean canDeleteTeacher=false;
 @Column(name = "can_Update_Teacher")
 private boolean canUpdateTeacher=false;
 @Column(name = "can_Read_Teacher")
 private boolean canReadTeacher=false;

 public Role(){}
 


 public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public boolean canCreateUser() {
    return canCreateUser;
}
public void setCanCreateUser(boolean canCreateUser) {
    this.canCreateUser = canCreateUser;
}
public boolean canDeleteUser() {
    return canDeleteUser;
}
public void setCanDeleteUser(boolean canDeleteUser) {
    this.canDeleteUser = canDeleteUser;
}
public boolean canUpdateUser() {
    return canUpdateUser;
}
public void setCanUpdateUser(boolean canUpdateUser) {
    this.canUpdateUser = canUpdateUser;
}
public boolean canReadUser() {
    return canReadUser;
}
public void setCanReadUser(boolean canReadUser) {
    this.canReadUser = canReadUser;
}
public boolean canCreateAdmin() {
    return canCreateAdmin;
}
public void setCanCreateAdmin(boolean canCreateAdmin) {
    this.canCreateAdmin = canCreateAdmin;
}
public boolean canDeleteAdmin() {
    return canDeleteAdmin;
}
public void setCanDeleteAdmin(boolean canDeleteAdmin) {
    this.canDeleteAdmin = canDeleteAdmin;
}
public boolean canUpdateAdmin() {
    return canUpdateAdmin;
}
public void setCanUpdateAdmin(boolean canUpdateAdmin) {
    this.canUpdateAdmin = canUpdateAdmin;
}
public boolean canReadAdmin() {
    return canReadAdmin;
}
public void setCanReadAdmin(boolean canReadAdmin) {
    this.canReadAdmin = canReadAdmin;
}
public boolean canCreateRole() {
    return canCreateRole;
}
public void setCanCreateRole(boolean canCreateRole) {
    this.canCreateRole = canCreateRole;
}
public boolean canDeleteRole() {
    return canDeleteRole;
}
public void setCanDeleteRole(boolean canDeleteRole) {
    this.canDeleteRole = canDeleteRole;
}
public boolean canUpdateRole() {
    return canUpdateRole;
}
public void setCanUpdateRole(boolean canUpdateRole) {
    this.canUpdateRole = canUpdateRole;
}
public boolean canReadRole() {
    return canReadRole;
}
public void setCanReadRole(boolean canReadRole) {
    this.canReadRole = canReadRole;
}
public boolean canCreateTeacher() {
    return canCreateTeacher;
}
public void setCanCreateTeacher(boolean canCreateTeacher) {
    this.canCreateTeacher = canCreateTeacher;
}
public boolean canDeleteTeacher() {
    return canDeleteTeacher;
}
public void setCanDeleteTeacher(boolean canDeleteTeacher) {
    this.canDeleteTeacher = canDeleteTeacher;
}
public boolean canUpdateTeacher() {
    return canUpdateTeacher;
}
public void setCanUpdateTeacher(boolean canUpdateTeacher) {
    this.canUpdateTeacher = canUpdateTeacher;
}
public boolean canReadTeacher() {
    return canReadTeacher;
}
public void setCanReadTeacher(boolean canReadTeacher) {
    this.canReadTeacher = canReadTeacher;
}





 
}
