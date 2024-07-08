package com.example.DesafioForo.controller;

import com.example.DesafioForo.domain.curso.CursoService;
import com.example.DesafioForo.domain.curso.DTO.DatosListadoCursos;
import com.example.DesafioForo.domain.curso.DTO.DatosModificarCurso;
import com.example.DesafioForo.domain.curso.DTO.DatosRegistroCurso;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

//    @GetMapping
//    public ResponseEntity prueba(){
//        return ResponseEntity.ok("jio");
//    }

    @PostMapping
    @Transactional
    public ResponseEntity ingresarCurso(@RequestBody DatosRegistroCurso datos) {
        var response = service.crearCurso(datos);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoCursos>> listarCursos(Pageable paginacion){
        return ResponseEntity.ok(service.listarCursos(paginacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarCurso(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarCurso(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity modificarCurso(@RequestBody @Valid DatosModificarCurso datos) {
        var response = service.modificarCurso(datos);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarCurso(@PathVariable Long id) {
        service.eliminarCurso(id);
        return ResponseEntity.noContent().build();
    }
}
