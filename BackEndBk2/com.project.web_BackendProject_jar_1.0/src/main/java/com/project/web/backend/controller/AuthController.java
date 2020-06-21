package com.project.web.backend.controller;

import com.project.web.backend.DTO.JwtDTO;
import com.project.web.backend.DTO.LoginUsuario;
import com.project.web.backend.DTO.Mensaje;
import com.project.web.backend.DTO.NuevoUsuario;
import com.project.web.backend.entity.Adoptante;
import com.project.web.backend.entity.Foto;
import com.project.web.backend.entity.Rol;
import com.project.web.backend.enums.RolNombre;
import com.project.web.backend.security.JwtProvider;
import com.project.web.backend.service.AdoptanteService;
import com.project.web.backend.service.RolService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    AdoptanteService adoptanteService;
    
    @Autowired
    RolService rolService;
    
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Campos vacíos o email inválido"), HttpStatus.BAD_REQUEST);
        if(adoptanteService.existePorUsuario(nuevoUsuario.getDni()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe "), HttpStatus.BAD_REQUEST);
        if(adoptanteService.existePorEmail(nuevoUsuario.getEmail()))
            return new ResponseEntity(new Mensaje("ese email ya existe "), HttpStatus.BAD_REQUEST);
        
        Adoptante adoptante = new Adoptante(nuevoUsuario.getNombre(),nuevoUsuario.getApellido(),nuevoUsuario.getEdad(),
        nuevoUsuario.getDni(),nuevoUsuario.getCelu(),nuevoUsuario.getEmail(),nuevoUsuario.getFechanacimiento(),nuevoUsuario.getFoto(),
         passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<String> rolesStr = nuevoUsuario.getRoles();
        Set<Rol> roles = new HashSet<>();
        for(String rol : rolesStr){
            switch(rol){
                case "admin":
                    Rol rolAdmin = rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get();
                    roles.add(rolAdmin);
                    break;
                default:
                    Rol rolUser = rolService.getByRolNombre(RolNombre.ROLE_USER).get();
                    roles.add(rolUser);
            }
        }
        adoptante.setRoles(roles);
        adoptanteService.guardar(adoptante);
        
        return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("campos vacíos o email inválido"),HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails adoptanteDetails = (UserDetails) authentication.getPrincipal();
        JwtDTO jwtDTO = new JwtDTO(jwt,adoptanteDetails.getUsername(),adoptanteDetails.getAuthorities());
        return new ResponseEntity<JwtDTO>(jwtDTO,HttpStatus.OK);
    }
//    @PreAuthorize("hasRole('USER')")
//    @PostMapping("/user/{dni}")
//    public ResponseEntity getFoto(@PathVariable String dni){
////        if(!mascotaService.existePorId(id))
////            return new ResponseEntity(new Mensaje("No existe esa mascota"),HttpStatus.NOT_FOUND);
//        Adoptante adp = adoptanteService.getByDNI(dni).get();
//        return new ResponseEntity(adp,HttpStatus.OK);
//    }    
    
//    @PreAuthorize("hasRole('USER')")
//    @GetMapping("/user/{dni}")
//    public ResponseEntity<Adoptante> getFoto(@PathVariable String dni){
////        if(!mascotaService.existePorId(id))
////            return new ResponseEntity(new Mensaje("No existe esa mascota"),HttpStatus.NOT_FOUND);
//        Adoptante adp = adoptanteService.getByDNI(dni).get();
//        return new ResponseEntity<Adoptante>(adp,HttpStatus.OK);
//    }      

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/{usuario}")
    public ResponseEntity getFoto(@PathVariable String usuario){
//        if(!mascotaService.existePorId(id))
//            return new ResponseEntity(new Mensaje("No existe esa mascota"),HttpStatus.NOT_FOUND);
        Adoptante adp = adoptanteService.getByDNI(usuario).get();
        return new ResponseEntity(adp,HttpStatus.OK);
    }       
    
}


