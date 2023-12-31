package com.example.demo.repository;

import com.example.demo.model.FileVolumetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileVolumetry, Long> {
}
