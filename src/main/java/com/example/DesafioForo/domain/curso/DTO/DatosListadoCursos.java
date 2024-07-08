package com.example.DesafioForo.domain.curso.DTO;

import com.example.DesafioForo.domain.curso.Categoria;
import com.example.DesafioForo.domain.curso.Curso;

public record DatosListadoCursos(
        Long id,
        String nombre,
        Categoria categoria
) {
    public DatosListadoCursos(Curso curso) { this( curso.getId(),curso.getNombre(),curso.getCategoria()); }
}
