package com.phdwebsite.phdwebsite.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "discipline_id", nullable = false)
    private Discipline discipline;
    private int researchTopicCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Discipline getDiscipline() {
		return discipline;
	}
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	public int getResearchTopicCount() {
		return researchTopicCount;
	}
	public void setResearchTopicCount(int researchTopicCount) {
		this.researchTopicCount = researchTopicCount;
	}

    // Getters and Setters
    
}

