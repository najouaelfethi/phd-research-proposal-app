package com.phdwebsite.phdwebsite.models;

import jakarta.persistence.*;

@Entity
@Table(name = "candidatures_students")
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //@Column(name = "fullName")
    private String fullName;
    
    //@Column(name = "email")
    private String email;
    
    private String status; 
    
    private String notification;


	//@Column(name = "cv_id")
    private Long cvId; // Store the ID of the CV file

    //@Column(name = "motivational_letter_id")
    private Long motivationalLetterId; // Store the ID of the motivational letter file

    //@Column(name = "transcripts_id")
    private Long transcriptsId; // Store the ID of the transcripts file

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;

    @ManyToOne
    @JoinColumn(name = "proposal_id")
    private Proposal proposal;

    public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCvId() {
		return cvId;
	}

	public void setCvId(Long cvId) {
		this.cvId = cvId;
	}

	public Long getMotivationalLetterId() {
		return motivationalLetterId;
	}

	public void setMotivationalLetterId(Long motivationalLetterId) {
		this.motivationalLetterId = motivationalLetterId;
	}

	public Long getTranscriptsId() {
		return transcriptsId;
	}

	public void setTranscriptsId(Long transcriptsId) {
		this.transcriptsId = transcriptsId;
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

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

    
}
