package com.project.web.backend.security;

import com.project.web.backend.entity.Adoptante;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AdoptantePrincipal implements UserDetails{
    private Integer id;
    private String nombre;
    private String nombreUsuario;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public AdoptantePrincipal(Integer id, String nombre, String nombreUsuario, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    
    public static AdoptantePrincipal build(Adoptante adoptante){
        List<GrantedAuthority> authorities = 
                adoptante.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name())).collect(Collectors.toList());
        return new AdoptantePrincipal(adoptante.getAdpID(),adoptante.getAdpNombre(),adoptante.getAdpDNI(),adoptante.getAdpCorreo(),adoptante.getAdpContra(),authorities);
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    

    public String getEmail() {
        return email;
    }
    
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    
    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    
}
