package com.act.playground.spring_crud.dto;

import io.micrometer.common.lang.NonNull;

public class PermissionDTO {
    
@NonNull
 private String name;
 private boolean canCreateUser=false;
 private boolean canDeleteUser=false;
 private boolean canUpdateUser=false;
 private boolean canReadUser=false;


 private boolean canCreateAdmin=false;
 private boolean canDeleteAdmin=false;
 private boolean canUpdateAdmin=false;
 private boolean canReadAdmin=false;

 
 private boolean canCreateRole=false;
  private boolean canDeleteRole=false;
 private boolean canUpdateRole=false;
  private boolean canReadRole=false;


 private boolean canCreateTeacher=false;
 private boolean canDeleteTeacher=false;
 private boolean canUpdateTeacher=false;
 private boolean canReadTeacher=false;
 



public PermissionDTO(String name, boolean canCreateUser, boolean canDeleteUser, boolean canUpdateUser,
        boolean canReadUser, boolean canCreateAdmin, boolean canDeleteAdmin, boolean canUpdateAdmin,
        boolean canReadAdmin, boolean canCreateRole, boolean canDeleteRole, boolean canUpdateRole, boolean canReadRole,
        boolean canCreateTeacher, boolean canDeleteTeacher, boolean canUpdateTeacher, boolean canReadTeacher) {
    this.name = name;
    this.canCreateUser = canCreateUser;
    this.canDeleteUser = canDeleteUser;
    this.canUpdateUser = canUpdateUser;
    this.canReadUser = canReadUser;
    this.canCreateAdmin = canCreateAdmin;
    this.canDeleteAdmin = canDeleteAdmin;
    this.canUpdateAdmin = canUpdateAdmin;
    this.canReadAdmin = canReadAdmin;
    this.canCreateRole = canCreateRole;
    this.canDeleteRole = canDeleteRole;
    this.canUpdateRole = canUpdateRole;
    this.canReadRole = canReadRole;
    this.canCreateTeacher = canCreateTeacher;
    this.canDeleteTeacher = canDeleteTeacher;
    this.canUpdateTeacher = canUpdateTeacher;
    this.canReadTeacher = canReadTeacher;
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
