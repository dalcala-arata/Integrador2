package com.project.web.backend.controller;

import com.project.web.backend.DTO.Mensaje;
import com.project.web.backend.entity.Adopcion;
import com.project.web.backend.entity.Mascota;
import com.project.web.backend.service.AdopcionService;
import com.project.web.backend.service.MascotaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/mascotas/")
@CrossOrigin("*")
public class AdopcionController {
    @Autowired
    MascotaService mascotaService;    
    @Autowired
    AdopcionService adopcionService;
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("adopcion/nuevo")
    public ResponseEntity<?> create(@RequestBody Adopcion adopcion){
//        if(StringUtils.isBlank(mascota.getActividad()))
//            return new ResponseEntity(new Mensaje("La actividad es obligatoria"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(mascota.getDescripcion()))
//            return new ResponseEntity(new Mensaje("Descripción es obligatorio"), HttpStatus.BAD_REQUEST);
//        if((Integer)mascota.getEdad()== null || mascota.getEdad()==0)
//            return new ResponseEntity(new Mensaje("Descripción es obligatorio"), HttpStatus.BAD_REQUEST);  
        Mascota mas = mascotaService.obtenerPorId(adopcion.getMasID());
        mas.setMasEstado("A");
        mascotaService.actualizar(mas);
        adopcionService.guardar(adopcion);
        return new ResponseEntity(new Mensaje("Mascota guardada"),HttpStatus.OK);    
    }
    @PreAuthorize("hasRole('USER')") 
    @GetMapping("adopcion/historial/{id}")
    public ResponseEntity<List<Adopcion>> getHistorial(@PathVariable String id){
        List<Adopcion> lista = adopcionService.obtenerHistorial(id);
        return new ResponseEntity<List<Adopcion>>(lista,HttpStatus.OK);
    }    
    
}
