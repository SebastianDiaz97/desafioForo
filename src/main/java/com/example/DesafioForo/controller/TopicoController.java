package com.example.DesafioForo.controller;

import com.example.DesafioForo.domain.topico.DTO.DatosModificacionTopico;
import com.example.DesafioForo.domain.topico.DTO.DatosRegistroTopico;
import com.example.DesafioForo.domain.topico.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity crearTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        var response = service.crearTopico(datos);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity listarTopicos(Pageable paginacion){
        return ResponseEntity.ok(service.listarTopico(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTopico(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarTopico(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity modificarTopico(@RequestBody DatosModificacionTopico datos) {
        return ResponseEntity.ok(service.modificarTopico(datos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        service.eliminarTopico(id);
        return ResponseEntity.noContent().build();
    }
}
