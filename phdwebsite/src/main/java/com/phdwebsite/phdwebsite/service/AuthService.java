/*package com.phdwebsite.phdwebsite.service;

import com.phdwebsite.phdwebsite.models.User;
import com.phdwebsite.phdwebsite.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    
    @Autowired
    private UsersRepository userRepository;

    

    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Hash the password
        userRepository.save(user);
    }


    // Method to validate user credentials
    public boolean validateUser(String username, String password) {
        User user = findByUsername(username);
        if (user != null) {
            return passwordEncoder.matches(password, user.getPassword()); // Compare hashed passwords
        }
        return false;
    }

    public User authenticate(String username, String password) {
        User user = findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user; // Return user if credentials are valid
        }
        return null; // Return null if credentials are invalid
    }

    public List<User> findAllUsers() {
        return userRepository.findAll(); // Get all users from the database
    }*/

