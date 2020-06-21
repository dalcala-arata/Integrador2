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
    private String masFoto;
    @NotBlank
    private String masEstado;
    @NotBlank
    private Integer volID;

    
    public Mascota() {
    }

    public Mascota(Integer masID, String masNombre, String masSexo, String masTamano, Integer masEdad, String masTpPelo, String masActiv, String masDesc, String masFoto, String masEstado, Integer volID) {
        this.masID = masID;
        this.masNombre = masNombre;
        this.masSexo = masSexo;
        this.masTamano = masTamano;
        this.masEdad = masEdad;
        this.masTpPelo = masTpPelo;
        this.masActiv = masActiv;
        this.masDesc = masDesc;
        this.masFoto = masFoto;
        this.masEstado = masEstado;
        this.volID = volID;
    }

    public String getMasEstado() {
        return masEstado;
    }

    public void setMasEstado(String masEstado) {
        this.masEstado = masEstado;
    }



    public Integer getMasID() {
        return masID;
    }

    public void setMasID(Integer masID) {
        this.masID = masID;
    }

    public String getMasNombre() {
        return masNombre;
    }

    public void setMasNombre(String masNombre) {
        this.masNombre = masNombre;
    }

    public String getMasSexo() {
        return masSexo;
    }

    public void setMasSexo(String masSexo) {
        this.masSexo = masSexo;
    }

    public String getMasTamano() {
        return masTamano;
    }

    public void setMasTamano(String masTamano) {
        this.masTamano = masTamano;
    }

    public Integer getMasEdad() {
        return masEdad;
    }

    public void setMasEdad(Integer masEdad) {
        this.masEdad = masEdad;
    }

    public String getMasTpPelo() {
        return masTpPelo;
    }

    public void setMasTpPelo(String masTpPelo) {
        this.masTpPelo = masTpPelo;
    }

    public String getMasActiv() {
        return masActiv;
    }

    public void setMasActiv(String masActiv) {
        this.masActiv = masActiv;
    }

    public String getMasDesc() {
        return masDesc;
    }

    public void setMasDesc(String masDesc) {
        this.masDesc = masDesc;
    }

    public String getMasFoto() {
        return masFoto;
    }

    public void setMasFoto(String masFoto) {
        this.masFoto = masFoto;
    }

    public Integer getVolID() {
        return volID;
    }

    public void setVolID(Integer volID) {
        this.volID = volID;
    }


    
    
}
