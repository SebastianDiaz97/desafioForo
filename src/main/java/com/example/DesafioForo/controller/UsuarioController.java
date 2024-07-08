package com.example.DesafioForo.controller;

import com.example.DesafioForo.domain.usuario.DTO.DatosListadoUsuario;
import com.example.DesafioForo.domain.usuario.DTO.DatosModificacionUsuario;
import com.example.DesafioForo.domain.usuario.DTO.DatosRegistroUsuario;
import com.example.DesafioForo.domain.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    @Transactional
    public ResponseEntity registrarUsuario(@RequestBody @Valid DatosRegistroUsuario datos) {

        var response = service.registrarUsuario(datos);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoUsuario>> listarUsuarios(Pageable paginacion){
        return ResponseEntity.ok(service.listarUsuarios(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarUsuario(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarUsuario(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity modificarDatos(@RequestBody @Valid DatosModificacionUsuario datos) {
        var usuario = service.modificarUsuario(datos);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarUsuario(@PathVariable Long id) {
        service.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

}
