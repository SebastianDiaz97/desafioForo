package com.example.DesafioForo.domain.perfil.DTO;

import jakarta.validation.constraints.NotNull;

public record DatosEliminarPerfil(
        @NotNull Long id
) {
}
