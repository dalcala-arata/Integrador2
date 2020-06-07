package com.project.web.backend.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Adoptante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Integer adpID;
    @NotNull
    private String adpNombre;
    @NotNull
    private String adpApellido;
    @NotNull
    private Integer adpEdad;
    @NotNull
    @Column(unique = true)
    private String adpDNI;
    @NotNull
    private String adpCelu;
    @NotNull
    @Column(unique = true)
    private String adpCorreo;
    @NotNull
    private Date adpFechaNac;
    @NotNull
    private String adpFoto;
    @NotNull
    private String adpContra;
    
    @NotNull
    @ManyToMany
    @JoinTable(name = "adoptante_rol",joinColumns=@JoinColumn(name="AdpID"),inverseJoinColumns=@JoinColumn(name="RolID"))
    private Set<Rol> roles = new HashSet<>();
    
    public Adoptante() {
    }

    public Adoptante(@NotNull String adpNombre,@NotNull String adpApellido,@NotNull Integer adpEdad,@NotNull String adpDNI,@NotNull String adpCelu,@NotNull String adpCorreo,@NotNull Date adpFechaNac,@NotNull String adpFoto,@NotNull String adpContra) {
        this.adpNombre = adpNombre;
        this.adpApellido = adpApellido;
        this.adpEdad = adpEdad;
        this.adpDNI = adpDNI;
        this.adpCelu = adpCelu;
        this.adpCorreo = adpCorreo;
        this.adpFechaNac = adpFechaNac;
        this.adpFoto = adpFoto;
        this.adpContra = adpContra;
    }
 

    public Integer getAdpID() {
        return adpID;
    }

    public void setAdpID(Integer adpID) {
        this.adpID = adpID;
    }

    public String getAdpNombre() {
        return adpNombre;
    }

    public void setAdpNombre(String adpNombre) {
        this.adpNombre = adpNombre;
    }

    public String getAdpApellido() {
        return adpApellido;
    }

    public void setAdpApellido(String adpApellido) {
        this.adpApellido = adpApellido;
    }

    public Integer getAdpEdad() {
        return adpEdad;
    }

    public void setAdpEdad(Integer adpEdad) {
        this.adpEdad = adpEdad;
    }

    public String getAdpDNI() {
        return adpDNI;
    }

    public void setAdpDNI(String adpDNI) {
        this.adpDNI = adpDNI;
    }

    public String getAdpCelu() {
        return adpCelu;
    }

    public void setAdpCelu(String adpCelu) {
        this.adpCelu = adpCelu;
    }

    public String getAdpCorreo() {
        return adpCorreo;
    }

    public void setAdpCorreo(String adpCorreo) {
        this.adpCorreo = adpCorreo;
    }

    public Date getAdpFechaNac() {
        return adpFechaNac;
    }

    public void setAdpFechaNac(Date adpFechaNac) {
        this.adpFechaNac = adpFechaNac;
    }

    public String getAdpFoto() {
        return adpFoto;
    }

    public void setAdpFoto(String adpFoto) {
        this.adpFoto = adpFoto;
    }

    public String getAdpContra() {
        return adpContra;
    }

    public void setAdpContra(String adpContra) {
        this.adpContra = adpContra;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
    
    
}
