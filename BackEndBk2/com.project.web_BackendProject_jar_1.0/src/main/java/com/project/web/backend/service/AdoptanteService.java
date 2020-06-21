package com.project.web.backend.service;

import com.project.web.backend.entity.Adoptante;
import com.project.web.backend.entity.Foto;
import com.project.web.backend.repository.AdoptanteRepository;
import com.project.web.backend.repository.FotoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdoptanteService {
    @Autowired
    AdoptanteRepository adoptanteRepository;
   
    
    public Optional<Adoptante> getByDNI(String nombre){
        return adoptanteRepository.findByadpDNI(nombre);
    }
    
    public boolean existePorUsuario(String nombre){
        return adoptanteRepository.existsByadpDNI(nombre);
    }
    
    public boolean existePorEmail(String email){
        return adoptanteRepository.existsByadpCorreo(email);
    }
    
    public void guardar(Adoptante adoptante){
        adoptanteRepository.save(adoptante);
    }

    
}
