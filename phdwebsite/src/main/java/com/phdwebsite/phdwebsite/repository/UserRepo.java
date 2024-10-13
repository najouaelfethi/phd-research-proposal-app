package com.phdwebsite.phdwebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phdwebsite.phdwebsite.models.User;

@Repository

public interface UserRepo extends JpaRepository<User, Long> {
    // You can add custom query methods here if needed
}
