package com.example.DesafioForo.controller;

import com.example.DesafioForo.domain.respuesta.DTO.DatosModificarRespuesta;
import com.example.DesafioForo.domain.respuesta.DTO.DatosRegistroRespuesta;
import com.example.DesafioForo.domain.respuesta.RespuestaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaService service;

    @PostMapping
    @Transactional
    public ResponseEntity ingresarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datos) {
        var response = service.crearRespuesta(datos);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity listarRespuestas(Pageable paginacion){
        return ResponseEntity.ok(service.listarRespuesta(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarRespuesta(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarRespuesta(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity modificarRespuesta(@RequestBody DatosModificarRespuesta datos) {
        return ResponseEntity.ok(service.modificarRespuesta(datos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarRespuesta(@PathVariable Long id) {
        service.eliminarRespuesta(id);
        return ResponseEntity.noContent().build();
    }
}
