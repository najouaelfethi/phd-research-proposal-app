package com.phdwebsite.phdwebsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phdwebsite.phdwebsite.models.Proposal;
import com.phdwebsite.phdwebsite.service.ProposalService;

@Controller
@RequestMapping("/admin")
public class ProposalAdminController {

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/propositions")
    public String showPropositions(Model model) {
        List<Proposal> proposals = proposalService.getAllProposals();
        model.addAttribute("proposals", proposals);
        return "admin/propositions/list"; 
    }
    
    @GetMapping("propositions/{id}")
    public String viewProposal(@PathVariable Long id, Model model) {
        Proposal proposal = proposalService.getProposalById(id); // Use the updated method
        model.addAttribute("proposal", proposal);
        return "admin/propositions/details"; // Adjust the view name as needed
    }
}

