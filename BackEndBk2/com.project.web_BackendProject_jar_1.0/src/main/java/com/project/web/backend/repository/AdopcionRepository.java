package com.project.web.backend.repository;

import com.project.web.backend.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface AdopcionRepository extends JpaRepository<Adopcion,Integer>{
    List<Adopcion> findByAdpID(Integer id);
}
