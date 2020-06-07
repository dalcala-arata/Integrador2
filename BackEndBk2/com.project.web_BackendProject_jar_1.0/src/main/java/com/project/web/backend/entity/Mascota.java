package com.project.web.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer masID;
    @NotBlank
    @Column(length = 50)
    private String masNombre;
    @NotBlank
    @Column(length = 1)
    private String masSexo;
    @NotBlank
    @Column(length = 20)
    private String masTamano;
    @NotBlank
    private Integer masEdad;
    @NotBlank
    @Column(length = 20)
    private String masTpPelo;
    @NotBlank
    @Column(length = 20)
    private String masActiv;
    @NotBlank
    @Column(length = 300)
    private String masDesc;
    @NotBlank
    private Integer volID;

    
    public Mascota() {
    }

    public Mascota(String masNombre, String masSexo, String masTamano, Integer masEdad, String masTpPelo, String masActiv, String masDesc,Integer volID) {
        this.masNombre = masNombre;
        this.masSexo = masSexo;
        this.masTamano = masTamano;
        this.masEdad = masEdad;
        this.masTpPelo = masTpPelo;
        this.masActiv = masActiv;
        this.masDesc = masDesc;
        this.volID = volID;
    }

    public Integer getmasID() {
        return masID;
    }

    public void setmasID(Integer masID) {
        this.masID = masID;
    }

    public String getmasNombre() {
        return masNombre;
    }

    public void setmasNombre(String masNombre) {
        this.masNombre = masNombre;
    }

    public String getmasSexo() {
        return masSexo;
    }

    public void setmasSexo(String masSexo) {
        this.masSexo = masSexo;
    }

    public String getmasTamano() {
        return masTamano;
    }

    public void setmasTamano(String masTamano) {
        this.masTamano = masTamano;
    }

    public Integer getmasEdad() {
        return masEdad;
    }

    public void setmasEdad(Integer masEdad) {
        this.masEdad = masEdad;
    }

    public String getmasTpPelo() {
        return masTpPelo;
    }

    public void setmasTpPelo(String masTpPelo) {
        this.masTpPelo = masTpPelo;
    }

    public String getmasActiv() {
        return masActiv;
    }

    public void setmasActiv(String masActiv) {
        this.masActiv = masActiv;
    }

    public String getmasDesc() {
        return masDesc;
    }

    public void setmasDesc(String masDesc) {
        this.masDesc = masDesc;
    }

    public Integer getVolID() {
        return volID;
    }

    public void setVolID(Integer volID) {
        this.volID = volID;
    }

    
    
}
