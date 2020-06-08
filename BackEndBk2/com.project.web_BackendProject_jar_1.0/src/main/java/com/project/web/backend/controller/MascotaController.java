package com.project.web.backend.controller;
import org.apache.commons.lang3.StringUtils;
import com.project.web.backend.DTO.Mensaje;
import com.project.web.backend.entity.Mascota;
import com.project.web.backend.service.MascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/mascotas/")
//@C    rossOrigin("*")
public class MascotaController {
    @Autowired
    MascotaService mascotaService;
    
    @GetMapping("lista")
    public ResponseEntity<List<Mascota>> getLista(){
        List<Mascota> lista = mascotaService.obtenerTodos();
        return new ResponseEntity<List<Mascota>>(lista,HttpStatus.OK);
    }
    
    @GetMapping("detalle/{id}")
    public ResponseEntity<Mascota> getOne(@PathVariable Integer id){
        if(!mascotaService.existePorId(id))
            return new ResponseEntity(new Mensaje("No existe esa mascota"),HttpStatus.NOT_FOUND);
        Mascota mascota = mascotaService.obtenerPorId(id).get();
        return new ResponseEntity<Mascota>(mascota,HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("nuevo")
    public ResponseEntity<?> create(@RequestBody Mascota mascota){
        if(StringUtils.isBlank(mascota.getmasNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(mascota.getActividad()))
//            return new ResponseEntity(new Mensaje("La actividad es obligatoria"), HttpStatus.BAD_REQUEST);
//        if(StringUtils.isBlank(mascota.getDescripcion()))
//            return new ResponseEntity(new Mensaje("Descripción es obligatorio"), HttpStatus.BAD_REQUEST);
//        if((Integer)mascota.getEdad()== null || mascota.getEdad()==0)
//            return new ResponseEntity(new Mensaje("Descripción es obligatorio"), HttpStatus.BAD_REQUEST);        
        mascotaService.guardar(mascota);
        return new ResponseEntity(new Mensaje("Mascota guardada"),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@RequestBody Mascota mascota, @PathVariable("id") Integer id){
//        if(!productoService.existePorId(id))
//            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
//        if(StringUtils.isBlank(producto.getNombreProducto()))
//            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if((Integer)producto.getPrecio() == null || producto.getPrecio()==0)
//            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(productoService.existePorNombre(producto.getNombreProducto()) &&
//                productoService.obtenerPorNombre(producto.getNombreProducto()).get().getId() != id)
//            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Mascota masUpdate = mascotaService.obtenerPorId(id).get();
        masUpdate.setmasNombre(mascota.getmasNombre());
        masUpdate.setmasTamano(mascota.getmasTamano());
        mascotaService.guardar(masUpdate);
        return new ResponseEntity(new Mensaje("Mascota actualizada"), HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(!mascotaService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe esa mascota"), HttpStatus.NOT_FOUND);
        mascotaService.borrar(id);
        return new ResponseEntity(new Mensaje("mascota eliminado"), HttpStatus.OK);
    }    
    
}


