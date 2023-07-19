package com.example.demo.service;

import com.example.demo.model.FileVolumetry;
import com.example.demo.repository.FileVolumetryRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
public class ReaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReaderService.class);

    private static final String FILE = "C:\\Users\\T006848\\Documents\\DOC\\files\\cm-caso-de-uso.xlsx";
    private static final String FILE_VOLUMETRY = "volumetrias-interfaces.xlsx";

    @Autowired
    private FileVolumetryRepository fileVolumetryRepository;

    public void readExcelFile() throws FileNotFoundException {

        try {
            //get excel file
//            FileInputStream fileInputStream = new FileInputStream(new File(FILE));
            FileInputStream fileInputStream = new FileInputStream(new File(FILE_VOLUMETRY));

            ////Create Workbook instance holding reference to .xlsx file
            Workbook workbook = new XSSFWorkbook(fileInputStream);

            //Get first/desired sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
//                LOGGER.info("ROWS DATA : {}", row);
                fileVolumetryRepository.save((FileVolumetry) row);

                row.forEach(cell ->LOGGER.info(cell.getStringCellValue()));
            }

            LOGGER.info("{} -- {}", sheet.getColumnWidth(0), sheet.getRow(0).getCell(0));
            LOGGER.info("{}", sheet.getColumnWidth(2));

        } catch (Exception e) {

            LOGGER.error(String.valueOf(e));
        }
    }

    public void writeExcelDB(){

    }
}
