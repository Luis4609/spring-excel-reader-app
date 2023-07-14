package com.example.demo.controller;


import com.example.demo.repository.FileVolumetryRepository;
import com.example.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/v1/file")
public class FileVolumetryController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("")
    public String getFileVolumetries(){

        try {
            readerService.readExcelFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "pepe";
    }
}
