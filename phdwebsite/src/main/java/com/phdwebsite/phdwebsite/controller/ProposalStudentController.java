package com.phdwebsite.phdwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phdwebsite.phdwebsite.models.Proposal;
import com.phdwebsite.phdwebsite.service.ProposalService;

@Controller
@RequestMapping("/student")
public class ProposalStudentController {

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/propositions")
    public String showPropositions(@RequestParam(required = false) String disciplineName, Model model) {
        List<Proposal> proposals;
        
        if (disciplineName != null && !disciplineName.isEmpty()) {
            proposals = proposalService.findByDisciplineName(disciplineName); // Filter by discipline name
        } else {
            proposals = proposalService.getAllProposals(); // Return all proposals if no discipline name is provided
        }

        model.addAttribute("proposals", proposals);
        model.addAttribute("name", disciplineName); // Maintain entered discipline name in view
        return "student/propositions/list"; 
    }

    @GetMapping("/propositions/{id}")
    public String viewProposal(@PathVariable Long id, Model model) {
        Proposal proposal = proposalService.getProposalById(id);
        model.addAttribute("proposal", proposal);
        return "student/propositions/details"; 
    }
}
