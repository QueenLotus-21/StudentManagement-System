package com.act.playground.spring_crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.act.playground.spring_crud.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
  Role findByName(String name);
}
