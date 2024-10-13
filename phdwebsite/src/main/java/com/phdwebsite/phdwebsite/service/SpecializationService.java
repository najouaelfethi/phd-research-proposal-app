package com.phdwebsite.phdwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phdwebsite.phdwebsite.models.Specialization;
import com.phdwebsite.phdwebsite.repository.SpecializationRepository;

import jakarta.transaction.Transactional;

@Service
public class SpecializationService {
    @Autowired
    private SpecializationRepository specializationRepository;

    public List<Specialization> findAll() {
        return specializationRepository.findAll();
    }

    public Specialization save(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public void delete(Long id) {
        specializationRepository.deleteById(id);
    }
    
    public Specialization findById(Long id) {
        return specializationRepository.findById(id).orElse(null);
    }
    
    @Transactional
    public void deleteByDisciplineId(Long disciplineId) {
        specializationRepository.deleteByDisciplineId(disciplineId);
    }


}

