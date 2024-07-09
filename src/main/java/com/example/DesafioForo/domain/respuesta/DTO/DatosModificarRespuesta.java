package com.example.DesafioForo.domain.respuesta.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosModificarRespuesta(
        @NotNull Long id,
        @NotBlank String mensaje
) {
}
