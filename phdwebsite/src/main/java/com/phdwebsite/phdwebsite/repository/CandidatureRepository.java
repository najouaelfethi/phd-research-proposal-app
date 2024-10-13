package com.phdwebsite.phdwebsite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.phdwebsite.phdwebsite.models.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
	
}
