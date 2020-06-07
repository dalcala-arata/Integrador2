package com.project.web.backend.repository;

import com.project.web.backend.entity.Rol;
import com.project.web.backend.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolnombre);
}
