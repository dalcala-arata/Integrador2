package com.project.web.backend.service;

import com.project.web.backend.entity.Foto;
import com.project.web.backend.repository.FotoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FotoService {
    @Autowired
    FotoRepository fotoRepository;    
    
    public Optional<Foto> getFoto(Integer id){
        return fotoRepository.findFirstByftId(id);
    }    
        
}
