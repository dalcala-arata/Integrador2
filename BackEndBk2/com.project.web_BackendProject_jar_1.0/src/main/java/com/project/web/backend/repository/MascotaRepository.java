package com.project.web.backend.repository;
import com.project.web.backend.entity.Mascota;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Integer>{
    Optional<Mascota> findByMasNombre(String nm);
    boolean existsByMasNombre(String nm);
}
