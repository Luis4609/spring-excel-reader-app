package com.example.demo.repository;

import com.example.demo.model.FileVolumetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileVolumetryRepository extends JpaRepository<FileVolumetry, Long> {

    Optional<FileVolumetry> findById(Long id);

}
