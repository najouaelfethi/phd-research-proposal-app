package com.phdwebsite.phdwebsite.controller;

import com.phdwebsite.phdwebsite.models.Proposal;
import com.phdwebsite.phdwebsite.service.ProposalService;
import com.phdwebsite.phdwebsite.service.DisciplineService;
import com.phdwebsite.phdwebsite.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProposalController {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private SpecializationService specializationService;

    @GetMapping("/propositions")
    public String listPropositions(@RequestParam(required = false) String keyword,Model model) {
        List<Proposal> proposals = proposalService.getAllProposals(); 
        if (keyword != null && !keyword.isEmpty()) {
            proposals = proposalService.findProposalsByKeyword(keyword); // Implement this method in your service
        } else {
            proposals = proposalService.getAllProposals(); 
        }
        
        model.addAttribute("proposals", proposals);
        model.addAttribute("disciplines", disciplineService.findAll());
        model.addAttribute("specializations", specializationService.findAll());
        model.addAttribute("keyword", keyword);
        return "professor/propositions/list"; 
    }

    @GetMapping("/propositions/add")
    public String showAddForm(Model model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        model.addAttribute("specializations", specializationService.findAll());
        return "professor/propositions/add"; 
    }

    @PostMapping("/propositions/add")
    public String addProposal(@ModelAttribute Proposal proposal) {
        proposalService.saveProposal(proposal);
        return "redirect:/professor/propositions";
    }

    @GetMapping("propositions/{id}")
    public String viewProposal(@PathVariable Long id, Model model) {
        Proposal proposal = proposalService.getProposalById(id); 
        model.addAttribute("proposal", proposal);
        return "/professor/propositions/details"; 
    }

    @PostMapping("/propositions/delete/{id}")
    public String deleteProposal(@PathVariable Long id) {
        proposalService.deleteProposal(id); 
        return "redirect:/professor/propositions";
    }

    @GetMapping("/propositions/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Proposal proposal = proposalService.getProposalById(id); 
        model.addAttribute("proposal", proposal);
        model.addAttribute("disciplines", disciplineService.findAll());
        model.addAttribute("specializations", specializationService.findAll());
        return "professor/propositions/edit"; // view name 
    }

    @PostMapping("/propositions/edit")
    public String editProposal(@ModelAttribute Proposal proposal) {
        proposalService.saveProposal(proposal); 
        return "redirect:/professor/propositions";
    }
    
    

}
