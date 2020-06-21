package com.project.web.backend.repository;

import com.project.web.backend.entity.Foto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto,Integer>{
    Optional<Foto> findFirstByftId(Integer nm);
}
