package com.example.DesafioForo.controller;

import com.example.DesafioForo.domain.usuario.DTO.DatosAutenticacionUsuario;
import com.example.DesafioForo.domain.usuario.Usuario;
import com.example.DesafioForo.infra.security.DatosJWT;
import com.example.DesafioForo.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datos) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.clave());
        var autenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) autenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWT(jwtToken));
    }

}
