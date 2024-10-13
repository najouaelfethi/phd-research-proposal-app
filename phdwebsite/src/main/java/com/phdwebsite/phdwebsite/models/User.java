package com.phdwebsite.phdwebsite.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    @Column(nullable = false, unique = true)
    private String username; // Unique username

    /*@Column(nullable = false)
    private String password; // Hashed password*/

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role; // User role (admin, student, professor)

    // Constructors
    public User() {}

    public User(String username, Role role) {
        this.username = username;
        //this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   /* public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }*/

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    // Role enum
    public enum Role {
        ADMIN,
        STUDENT,
        PROFESSOR;
    }
}
