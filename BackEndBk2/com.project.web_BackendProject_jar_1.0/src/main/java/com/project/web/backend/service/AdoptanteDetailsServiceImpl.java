package com.project.web.backend.service;

import com.project.web.backend.entity.Adoptante;
import com.project.web.backend.security.AdoptantePrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdoptanteDetailsServiceImpl implements UserDetailsService{
    @Autowired
    AdoptanteService adoptanteService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Adoptante adoptante = adoptanteService.getByDNI(nombreUsuario).get();
        return AdoptantePrincipal.build(adoptante);
    }
}
