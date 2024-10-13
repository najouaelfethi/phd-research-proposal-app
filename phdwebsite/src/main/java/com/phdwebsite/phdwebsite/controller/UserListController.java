package com.phdwebsite.phdwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phdwebsite.phdwebsite.service.UserService;

@Controller
public class UserListController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		userService.deleteById(id);
		return "redirect:/adminDashboard";
	}

}
