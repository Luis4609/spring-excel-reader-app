package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * The type File controller.
 */
@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * Get app possible Excel files types, that a USER can upload to the APP.
     */
    @GetMapping("/list")
    public void getFilesTypes(){

        fileService.getTypes();

    }

    /**
     * Upload file.
     *
     * @param file the file
     */
    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("file") MultipartFile file) {

        fileService.uploadFile(file);
    }
}
