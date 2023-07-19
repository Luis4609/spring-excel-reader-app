package com.example.demo.service;

import com.example.demo.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public void getTypes() {

        fileRepository.findAll();
    }

    public void uploadFile(MultipartFile file) {

    }

    public void readExcelFile(File file) {

    }

    public void saveExcelDataIntoDB() {

    }


}
