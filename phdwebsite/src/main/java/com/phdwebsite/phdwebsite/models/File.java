package com.phdwebsite.phdwebsite.models;

import jakarta.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_type")
    private String fileType;

    @Lob
    @Column(name = "file_data")
    private byte[] fileData;

    @ManyToOne
    @JoinColumn(name = "candidature_id", nullable = false)
    private Candidature candidat;

    public File() {
    }

    public File(String fileName, String fileType, byte[] fileData, Candidature candidat ) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.fileData = fileData;
        this.candidat = candidat;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public Candidature getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidature candidat) {
		this.candidat = candidat;
	}
    
}

    