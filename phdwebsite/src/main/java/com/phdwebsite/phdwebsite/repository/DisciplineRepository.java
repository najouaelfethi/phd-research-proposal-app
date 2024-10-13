package com.phdwebsite.phdwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phdwebsite.phdwebsite.models.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {
	
}

