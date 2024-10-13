package com.phdwebsite.phdwebsite.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Proposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    private String description;
    private String requiredSkills;
    private String researchObjectives;
    private String status; // "Open" or "Closed"
    private int numberOfApplications;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Discipline getDiscipline() {
		return discipline;
	}
	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public String getResearchObjectives() {
		return researchObjectives;
	}
	public void setResearchObjectives(String researchObjectives) {
		this.researchObjectives = researchObjectives;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumberOfApplications() {
		return numberOfApplications;
	}
	public void setNumberOfApplications(int numberOfApplications) {
		this.numberOfApplications = numberOfApplications;
	}

}

