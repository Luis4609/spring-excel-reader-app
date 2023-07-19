package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class QualityExcel {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String urlFile;

    private Date uploadAt;

    private String uploadByUser;

    public QualityExcel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Date getUploadAt() {
        return uploadAt;
    }

    public void setUploadAt(Date uploadAt) {
        this.uploadAt = uploadAt;
    }

    public String getUploadByUser() {
        return uploadByUser;
    }

    public void setUploadByUser(String uploadByUser) {
        this.uploadByUser = uploadByUser;
    }

    @Override
    public String toString() {
        return "ExcelFileHistoric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", urlFile='" + urlFile + '\'' +
                ", uploadAt=" + uploadAt +
                ", uploadByUser='" + uploadByUser + '\'' +
                '}';
    }
}
