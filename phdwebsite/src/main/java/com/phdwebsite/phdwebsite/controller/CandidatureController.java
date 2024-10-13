package com.phdwebsite.phdwebsite.controller;

import java.io.IOException;
import org.springframework.web.server.ResponseStatusException;

//import java.net.http.HttpHeaders;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.phdwebsite.phdwebsite.models.Candidature;
import com.phdwebsite.phdwebsite.models.File;
import com.phdwebsite.phdwebsite.repository.FileRepository;
import com.phdwebsite.phdwebsite.service.CandidatureService;
import com.phdwebsite.phdwebsite.service.DisciplineService;
import com.phdwebsite.phdwebsite.service.ProposalService;
import com.phdwebsite.phdwebsite.service.SpecializationService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@Controller
@RequestMapping("/candidature")
public class CandidatureController {
    
	@Autowired
	private FileRepository fileRepository;
	
    @Autowired
    private CandidatureService candidatureService;
    
    @Autowired
    private DisciplineService disciplineService;
    
    @Autowired
    private SpecializationService specializationService;
    
    @Autowired
    private ProposalService proposalService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("candidature", new Candidature());
        model.addAttribute("disciplines", disciplineService.findAll());
        model.addAttribute("specializations", specializationService.findAll());
        model.addAttribute("proposals", proposalService.getAllProposals());
        return "candidature/candidatureForm"; 
    }

    @PostMapping("/submit")
    public String submitCandidature(@ModelAttribute Candidature candidature,
                                     @RequestParam("fullName") String fullName,
                                     @RequestParam("email") String email,
                                     //@RequestParam("status") String status,
                                     @RequestParam("cv") MultipartFile cv,
                                     @RequestParam("motivationalLetter") MultipartFile motivationalLetter,
                                     @RequestParam("transcripts") MultipartFile transcripts,
                                     @RequestParam("discipline.id") Long disciplineId, 
                                     @RequestParam("specialization.id") Long specializationId,
                                     @RequestParam("proposal.id") Long proposalId) {
        try {
            candidature.setFullName(fullName);
            candidature.setEmail(email);
            
            //candidature.setStatus("Pending");
            candidature.setDiscipline(disciplineService.findById(disciplineId));
            candidature.setSpecialization(specializationService.findById(specializationId));
            candidature.setProposal(proposalService.findById(proposalId));
            
            // Save the candidature 
            candidatureService.saveCandidature(candidature);
            
            // Save the files associated with the candidature
            Long cvId = saveFile(cv, candidature);
            Long motivationalLetterId = saveFile(motivationalLetter, candidature);
            Long transcriptsId = saveFile(transcripts, candidature);
            
            // Update the candidature with file IDs
            candidature.setCvId(cvId);
            candidature.setMotivationalLetterId(motivationalLetterId);
            candidature.setTranscriptsId(transcriptsId);
            
            // Update the saved candidature to reflect the file IDs
            candidatureService.updateCandidature(candidature.getId(),candidature); 

            return "redirect:/candidature/form"; 
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            return "candidature/error"; 
        }
    }

    private Long saveFile(MultipartFile file, Candidature candidature) throws SQLException, IOException {
        if (file.isEmpty()) {
            throw new IOException("Le fichier est vide");
        }
        
        File newFile = new File();
        newFile.setFileName(file.getOriginalFilename());
        newFile.setFileType(file.getContentType());
        newFile.setFileData(file.getBytes());
        newFile.setCandidat(candidature); // Associate file with the candidature

        File savedFile = fileRepository.save(newFile);
        return savedFile.getId();
    }

    
    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        return "candidature/success"; 
    } 
    @GetMapping("/error")
    public String showErrorPage(Model model) {
        return "candidature/error"; 
    }
    
    //Gestion candidatures par professor 
    
    @GetMapping("/students")
    public String showCandidatures(Model model) {
        List<Candidature> candidatures = candidatureService.findAll();
        model.addAttribute("candidatures", candidatures);
        return "candidature/students/allCandidatures"; 
    }
    
    @GetMapping("/professor")
    public String listCandidatures(Model model) {
        List<Candidature> candidatures = candidatureService.findAll();
        model.addAttribute("candidatures", candidatures);
        return "candidature/professor/candidatures"; 
    }
    
    @PostMapping("/update/{id}")
    public String updateCandidature(@PathVariable Long id, 
                                     @RequestParam String status) {
        System.out.println("Updating candidature ID: " + id + " with status: " + status);

    	try {
            candidatureService.updateStatus(id, status);
            
            // Notify the student
            String notificationMessage = "Your application status has been updated to: " + status;
            candidatureService.notifyStudent(id, notificationMessage);
            
            return "redirect:/candidature/professor"; 
        } catch (ResponseStatusException e) {
            return "candidature/error"; 
        }
    }
    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/viewDocument/{id}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable Long id) {
        File file = fileRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"File not found"));

        ByteArrayResource resource = new ByteArrayResource(file.getFileData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .contentType(MediaType.parseMediaType(file.getFileType()))
                .body(resource);
    }


    
}
    
    