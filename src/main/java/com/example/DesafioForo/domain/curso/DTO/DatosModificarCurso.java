package com.example.DesafioForo.domain.curso.DTO;

import jakarta.validation.constraints.NotNull;

public record DatosModificarCurso (
        @NotNull Long id,
        String nombre
) {
}
