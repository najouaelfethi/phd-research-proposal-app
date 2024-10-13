package com.phdwebsite.phdwebsite.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.phdwebsite.phdwebsite.models.Candidature;
import com.phdwebsite.phdwebsite.repository.CandidatureRepository;

import java.io.IOException;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CandidatureService {

	@Autowired
    private CandidatureRepository candidatureRepository;

	public void saveCandidature(Candidature candidature) {
        candidatureRepository.save(candidature);
    }
	
	
	//gestion candidatures
	
    public List<Candidature> findAll() {
        return candidatureRepository.findAll();
    }
	

    public void updateStatus(Long id, String status) {
        Candidature candidature = candidatureRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidature not found"));
        candidature.setStatus(status);
        candidatureRepository.save(candidature);
    }
    
    public void updateCandidature(Long id, Candidature updatedCandidature) {
        Candidature existingCandidature = candidatureRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidature not found"));

        existingCandidature.setFullName(updatedCandidature.getFullName());
        existingCandidature.setEmail(updatedCandidature.getEmail());
        //existingCandidature.setStatus(updatedCandidature.getStatus());
        
        existingCandidature.setDiscipline(updatedCandidature.getDiscipline());
        existingCandidature.setSpecialization(updatedCandidature.getSpecialization());
        existingCandidature.setProposal(updatedCandidature.getProposal());
        
        candidatureRepository.save(existingCandidature);
    }
    
    //notification
    public void notifyStudent(Long candidatureId, String message) {
        Candidature candidature = candidatureRepository.findById(candidatureId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Candidature not found"));
        candidature.setNotification(message);
        candidatureRepository.save(candidature);
    }

}
