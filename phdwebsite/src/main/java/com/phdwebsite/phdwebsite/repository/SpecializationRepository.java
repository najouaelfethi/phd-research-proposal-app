package com.phdwebsite.phdwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phdwebsite.phdwebsite.models.Specialization;

@Repository
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
	void deleteByDisciplineId(Long disciplineId);
	
}

