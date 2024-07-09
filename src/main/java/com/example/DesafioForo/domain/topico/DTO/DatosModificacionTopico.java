package com.example.DesafioForo.domain.topico.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosModificacionTopico(
    @NotNull Long id,
    @NotBlank String mensaje

) {
}
