package com.example.demo.controller;

import com.example.demo.model.FileVolumetry;
import com.example.demo.service.FileVolumtryService;
import com.example.demo.service.ReaderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/file")
public class FileVolumetryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileVolumetryController.class);

    @Autowired
    private FileVolumtryService fileVolumtryService;

    @Autowired
    private ReaderService readerService;

    @GetMapping("/{id}")
    public FileVolumetry getFileVolumetries(@PathVariable Long id) {

        return fileVolumtryService.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> uploadExcelDataToDB() {

        Long init = System.currentTimeMillis();
        LOGGER.info("Starting uploadExcelDataToDB");

        fileVolumtryService.saveAll();

        Long end = System.currentTimeMillis();
        LOGGER.info("Uploaded data to Database, in {} ms", end - init);

        return new ResponseEntity<>("The excel has been processed and saved into the Database", HttpStatus.OK);
    }

}
