package com.example.DesafioForo.domain.curso.DTO;

import com.example.DesafioForo.domain.curso.Categoria;
import jakarta.validation.constraints.NotBlank;

public record DatosRegistroCurso(
        @NotBlank String nombre,
        @NotBlank Categoria categoria
) {

}
