package com.example.demo.utils;

import com.example.demo.model.FileVolumetry;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CustomExcelOperations {

    private final String FILE = "C:\\Users\\luism\\Documents\\GitHub\\spring-excel-reader-app\\src\\main\\resources\\volumetrias-interfaces.xlsx";

    public List<FileVolumetry> excelToList() {


        try {
            Workbook workbook = null;
            try {
                workbook = new XSSFWorkbook(new File(FILE));
            } catch (IOException | InvalidFormatException e) {
                throw new RuntimeException(e);
            }

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<FileVolumetry> fileVolumetries = new ArrayList<>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                FileVolumetry fileVolumetry = new FileVolumetry();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0 -> fileVolumetry.setId((long) currentCell.getNumericCellValue());
                        case 1 -> fileVolumetry.setBatchInterface(currentCell.getStringCellValue());
                        case 2 -> fileVolumetry.setPeriodicity(currentCell.getStringCellValue());
                        case 3 -> fileVolumetry.setRegisterNumber(currentCell.getStringCellValue());
                        case 4 -> fileVolumetry.setRegisterSize(currentCell.getStringCellValue());
                        default -> throw new IllegalStateException("Unexpected value: " + cellIdx);
                    }

                    cellIdx++;
                }

                fileVolumetries.add(fileVolumetry);
            }

            //TODO CALL REPOSITORY saveAllAndFlush

            workbook.close();

            return fileVolumetries;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    private void excelObjectToEntity() {

    }

    private void getExcel() {

    }

}
