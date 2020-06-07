package com.project.web.backend.service;

import com.project.web.backend.entity.Mascota;
import com.project.web.backend.repository.MascotaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MascotaService {
    @Autowired
    MascotaRepository mascotaRepository;
    public List<Mascota> obtenerTodos(){
        List<Mascota> lista = mascotaRepository.findAll();
        return lista;
    }
    
    public Optional<Mascota> obtenerPorId(Integer id){
        return mascotaRepository.findById(id);
    }
    
    public Optional<Mascota> obtenerPorNombre(String nombre){
        return mascotaRepository.findByMasNombre(nombre);
    }
    public void guardar(Mascota mascota){
        mascotaRepository.save(mascota);
    }
    
    public void borrar(Integer id){
        mascotaRepository.deleteById(id);
    }
    public boolean existePorNombre(String nombre){
        return mascotaRepository.existsByMasNombre(nombre);
    }   
    public boolean existePorId(Integer id){
        return mascotaRepository.existsById(id);
    }
    
}
