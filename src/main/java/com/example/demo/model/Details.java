package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Details implements Serializable {

    @Id
    private Integer id;

    private String reference;

    private Integer year;

    private Date date;

    public Details() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", year=" + year +
                ", date=" + date +
                '}';
    }
}
