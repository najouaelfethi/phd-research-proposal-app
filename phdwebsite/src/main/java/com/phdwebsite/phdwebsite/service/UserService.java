package com.phdwebsite.phdwebsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phdwebsite.phdwebsite.models.User;
import com.phdwebsite.phdwebsite.repository.UserRepo;


@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	public void save(User u) {
		userRepo.save(u);
	}
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public void deleteById(int id) {
		userRepo.deleteById((long) id);
	}

	public User getUserById(Long id) {
        return userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
	
	

}
