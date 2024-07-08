package com.example.DesafioForo.domain.perfil.DTO;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroPerfil(@NotBlank String nombre) {
}
