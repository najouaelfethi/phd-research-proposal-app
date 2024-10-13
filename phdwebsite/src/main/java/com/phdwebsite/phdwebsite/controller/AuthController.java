package com.phdwebsite.phdwebsite.controller;


import com.phdwebsite.phdwebsite.models.Proposal;
import com.phdwebsite.phdwebsite.models.User;
import com.phdwebsite.phdwebsite.service.ProposalService;
import com.phdwebsite.phdwebsite.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    //@Autowired
    //private AuthService authService;
    
    @Autowired
    private UserService userService;

    @GetMapping("/roleSelection")
    public String roleSelection() {
        return "roleSelection";
    }
    
    @GetMapping("/userManagment")
    public String userManagment() {
    	return "userManagment";
    }
    
    
    @GetMapping("/addUserForm")
    public String addUserForm() {
    	return "addUserForm";
    }
    
    @GetMapping("/adminDashboard")//alll users
    public ModelAndView adminDashboard() {//get all users
    	List<User> list = userService.getAllUsers();
        //adminDashboard=list users
    	return new ModelAndView("adminDashboard","user",list);
    }
    
    @PostMapping("/saveUser")
    public String addUser(@ModelAttribute User u) {
    	userService.save(u);
    	return "redirect:/adminDashboard";
    }
    
    @RequestMapping("/userEdit/{id}")
    public String userEdit(@PathVariable("id") Long id, Model model) {
    	User u = userService.getUserById(id);
    	model.addAttribute("user",u);
    	return "userEdit";
    }
    
}

