package com.example.DesafioForo.domain.usuario.DTO;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(@NotBlank String email, @NotBlank String clave) {
}
