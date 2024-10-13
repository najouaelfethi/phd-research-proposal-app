package com.phdwebsite.phdwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phdwebsite.phdwebsite.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByname(String name);
}
