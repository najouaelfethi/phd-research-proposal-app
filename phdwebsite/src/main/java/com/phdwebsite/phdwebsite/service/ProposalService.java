package com.phdwebsite.phdwebsite.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phdwebsite.phdwebsite.models.Proposal;
import com.phdwebsite.phdwebsite.repository.ProposalRepository;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    public Proposal getProposalById(Long id) {
        return proposalRepository.findById(id).orElse(null);
    }

    public Proposal saveProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    public void deleteProposal(Long id) {
        proposalRepository.deleteById(id);
    }
    
    public List<Proposal> findProposalsByKeyword(String keyword) {
        return proposalRepository.findByTitleContainingIgnoreCase(keyword); 
    }
    
    public List<Proposal> findByDisciplineName(String disciplineName) {
        return proposalRepository.findByDisciplineName(disciplineName); 
    }
    
    public Proposal findById(Long id) {
        return proposalRepository.findById(id).orElse(null);
    }



}

