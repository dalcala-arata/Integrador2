package com.project.web.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ftId;
    private String  ftRuta;

    public Foto() {
    }

    public Foto(Integer ftId, String ftRuta) {
        this.ftId = ftId;
        this.ftRuta = ftRuta;
    }

    public Integer getFtId() {
        return ftId;
    }

    public void setFtId(Integer ftId) {
        this.ftId = ftId;
    }

    public String getFtRuta() {
        return ftRuta;
    }

    public void setFtRuta(String ftRuta) {
        this.ftRuta = ftRuta;
    }
    
}
