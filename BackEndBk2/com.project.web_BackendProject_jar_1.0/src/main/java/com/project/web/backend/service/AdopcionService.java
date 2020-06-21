package com.project.web.backend.service;

import com.project.web.backend.entity.*;
import com.project.web.backend.repository.AdopcionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AdopcionService {
    @Autowired
    AdopcionRepository adopcionRepository;
    @Autowired
    AdoptanteService adoptanteService;

    public void guardar(Adopcion adopcion){
        adopcionRepository.save(adopcion);
    }    
    
    public List<Adopcion> obtenerHistorial(String usuario){
        Adoptante adp = adoptanteService.getByDNI(usuario).get();
        List<Adopcion> lista = adopcionRepository.findByAdpID(adp.getAdpID());
        return lista;
    }
    
}
