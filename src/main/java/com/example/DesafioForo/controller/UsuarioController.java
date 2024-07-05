package com.example.DesafioForo.controller;

import com.example.DesafioForo.domain.usuario.DTO.DatosRegistroUsuario;
import com.example.DesafioForo.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity RegistrarUsuarios(@RequestBody @Valid DatosRegistroUsuario datos) {

        var response = service.registrarUsuario(datos);
        return ResponseEntity.ok(response);
    }
}
