package com.phdwebsite.phdwebsite.repository;

import com.phdwebsite.phdwebsite.models.Candidature;
import com.phdwebsite.phdwebsite.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findByCandidat(Candidature candidat);
}
