package com.phdwebsite.phdwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phdwebsite.phdwebsite.models.Specialization;
import com.phdwebsite.phdwebsite.service.DisciplineService;
import com.phdwebsite.phdwebsite.service.SpecializationService;


@Controller
@RequestMapping("/specializations")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;
    @Autowired
    private DisciplineService disciplineService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("specializations", specializationService.findAll());
        model.addAttribute("disciplines", disciplineService.findAll());
        return "specializations/list";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Specialization specialization) {
        specializationService.save(specialization);
        return "redirect:/specializations";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        specializationService.delete(id);
        return "redirect:/specializations";
    }
}

