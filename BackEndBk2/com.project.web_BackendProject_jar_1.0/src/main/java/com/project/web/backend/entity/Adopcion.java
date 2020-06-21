package com.project.web.backend.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Adopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer adoID;
    @NotNull
    private String adoEstado;
    @NotNull
    private Integer adpID;
    @NotNull
    private Date adoFecha;
    @NotNull
    private Integer masID;
    @NotNull
    private Integer accID;
    @NotNull
    private String adoDireccion;
    @NotNull
    private String adoDistrito;
    @NotNull
    private String adoProvincia;
    @NotNull
    private String adoNro;

    public Adopcion() {
    }

    public Adopcion(Integer adoID, String adoEstado, Integer adpID, Date adoFecha, Integer masID, Integer accID, String adoDireccion, String adoDistrito, String adoProvincia, String adoNro) {
        this.adoID = adoID;
        this.adoEstado = adoEstado;
        this.adpID = adpID;
        this.adoFecha = adoFecha;
        this.masID = masID;
        this.accID = accID;
        this.adoDireccion = adoDireccion;
        this.adoDistrito = adoDistrito;
        this.adoProvincia = adoProvincia;
        this.adoNro = adoNro;
    }

    public Integer getAdoID() {
        return adoID;
    }

    public void setAdoID(Integer adoID) {
        this.adoID = adoID;
    }

    public String getAdoEstado() {
        return adoEstado;
    }

    public void setAdoEstado(String adoEstado) {
        this.adoEstado = adoEstado;
    }

    public Integer getAdpID() {
        return adpID;
    }

    public void setAdpID(Integer adpID) {
        this.adpID = adpID;
    }

    public Date getAdoFecha() {
        return adoFecha;
    }

    public void setAdoFecha(Date adoFecha) {
        this.adoFecha = adoFecha;
    }

    public Integer getMasID() {
        return masID;
    }

    public void setMasID(Integer masID) {
        this.masID = masID;
    }

    public Integer getAccID() {
        return accID;
    }

    public void setAccID(Integer accID) {
        this.accID = accID;
    }

    public String getAdoDireccion() {
        return adoDireccion;
    }

    public void setAdoDireccion(String adoDireccion) {
        this.adoDireccion = adoDireccion;
    }

    public String getAdoDistrito() {
        return adoDistrito;
    }

    public void setAdoDistrito(String adoDistrito) {
        this.adoDistrito = adoDistrito;
    }

    public String getAdoProvincia() {
        return adoProvincia;
    }

    public void setAdoProvincia(String adoProvincia) {
        this.adoProvincia = adoProvincia;
    }

    public String getAdoNro() {
        return adoNro;
    }

    public void setAdoNro(String adoNro) {
        this.adoNro = adoNro;
    }
    
    
}
