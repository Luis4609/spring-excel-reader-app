package com.example.demo.service;

import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.model.FileVolumetry;
import com.example.demo.repository.FileVolumetryRepository;
import com.example.demo.utils.CustomExcelOperations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileVolumtryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileVolumtryService.class);

    @Autowired
    private FileVolumetryRepository fileVolumetryRepository;

    @Autowired
    private CustomExcelOperations customExcelOperations;

    public void saveAll() {

        fileVolumetryRepository.saveAllAndFlush(customExcelOperations.excelToList());
    }

    public FileVolumetry findById(Long id) {

        return fileVolumetryRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }
}
