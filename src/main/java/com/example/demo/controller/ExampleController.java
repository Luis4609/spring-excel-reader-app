package com.example.demo.controller;

import com.example.demo.model.Example;
import com.example.demo.repository.ExampleRepository;
import com.example.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/v1/example")
public class ExampleController {

    @Autowired
    private ExampleRepository exampleRepository;

    @Autowired
    private ReaderService readerService;

    @PostMapping("/")
    public String saveExample() {

        return "The new example has been created with ID: " + exampleRepository.save();
    }

    @GetMapping("/")
    public List<Example> getAllExamples() {

        return exampleRepository.getAll();
    }

    @GetMapping("/{id}")
    public Example getExampleById(@PathVariable Integer id) {

        return exampleRepository.getById(id);
    }

    @GetMapping("/file")
    public String readExcelFile(){
        try {
            readerService.readExcelFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
        return "File reader";
    }
}
