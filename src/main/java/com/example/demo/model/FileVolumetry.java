package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class FileVolumetry implements Serializable {

    @Id
    private Long id;

    private String batchInterface;

    private String periodicity;

    private String registerNumber;

    private String registerSize;

    public FileVolumetry() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBatchInterface(String stringCellValue) {
        return batchInterface;
    }

    public void setBatchInterface(String batchInterface) {
        this.batchInterface = batchInterface;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getRegisterSize() {
        return registerSize;
    }

    public void setRegisterSize(String registerSize) {
        this.registerSize = registerSize;
    }

    @Override
    public String toString() {
        return "FileVolumetry{" +
                "id=" + id +
                ", batchInterface='" + batchInterface + '\'' +
                ", periodicity='" + periodicity + '\'' +
                ", registerNumber='" + registerNumber + '\'' +
                ", registerSize='" + registerSize + '\'' +
                '}';
    }
}
