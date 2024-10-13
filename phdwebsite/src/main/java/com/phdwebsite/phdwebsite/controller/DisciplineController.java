package com.phdwebsite.phdwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phdwebsite.phdwebsite.models.Discipline;
import com.phdwebsite.phdwebsite.service.DisciplineService;
import com.phdwebsite.phdwebsite.service.SpecializationService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/disciplines")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;
    
    @Autowired
    private SpecializationService specializationService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        return "disciplines/list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Discipline discipline) {
        disciplineService.save(discipline);
        return "redirect:/disciplines";
    }
    
    @GetMapping("/add")
    public String showAddDisciplineForm(Model model) {
        return "addDiscipline"; // Make sure this matches the name of your new HTML file
    }

    @PostMapping("/delete/{id}")
    public void deleteDiscipline(@PathVariable Long id) {
    	specializationService.deleteByDisciplineId(id);
        disciplineService.deleteDiscipline(id);
        //return "redirect:/disciplines";
    }
}

