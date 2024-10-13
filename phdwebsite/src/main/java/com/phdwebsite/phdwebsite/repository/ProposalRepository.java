package com.phdwebsite.phdwebsite.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.phdwebsite.phdwebsite.models.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    //by title
	List<Proposal> findByTitleContainingIgnoreCase(String keyword);

    @Query("SELECT p FROM Proposal p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Proposal> searchByTitle(@Param("keyword") String keyword);
    
    //by discipline
	List<Proposal> findByDisciplineName(String disciplineName);
}

