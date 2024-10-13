package com.phdwebsite.phdwebsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phdwebsite.phdwebsite.models.Discipline;
import com.phdwebsite.phdwebsite.repository.DisciplineRepository;

@Service
public class DisciplineService {
    @Autowired
    private DisciplineRepository disciplineRepository;

    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    public Discipline save(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public void deleteDiscipline(Long id) {
        disciplineRepository.deleteById(id);
    }
    
    public Discipline findById(Long id) {
        return disciplineRepository.findById(id).orElse(null);
    }

}

