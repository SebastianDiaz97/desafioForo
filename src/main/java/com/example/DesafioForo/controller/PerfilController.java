package com.example.DesafioForo.controller;

import com.example.DesafioForo.domain.perfil.DTO.DatosListadoPerfil;
import com.example.DesafioForo.domain.perfil.DTO.DatosRegistroPerfil;
import com.example.DesafioForo.domain.perfil.PerfilService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilService service;

//    @GetMapping
//    public ResponseEntity prueba(){
//        return ResponseEntity.ok("jio");
//    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoPerfil>> obtenerPerfiles(Pageable paginacion){
        return ResponseEntity.ok(service.listarPerfiles(paginacion));
    }

    @PostMapping
    @Transactional
    public ResponseEntity crearPerfiles(@RequestBody @Valid DatosRegistroPerfil datos) {
        var response = service.savePerfil(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarPerfil(@PathVariable Long id) {
        service.eliminarPerfil(id);
        return ResponseEntity.noContent().build();
    }
}
