package com.project.web.backend.repository;

import com.project.web.backend.entity.Adoptante;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptanteRepository extends JpaRepository<Adoptante,Integer>{
   Optional<Adoptante> findByadpDNI(String na); 
   boolean existsByadpDNI(String na);
   boolean existsByadpCorreo(String email);
}
