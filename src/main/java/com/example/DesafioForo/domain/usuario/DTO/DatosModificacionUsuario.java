package com.example.DesafioForo.domain.usuario.DTO;

import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record DatosModificacionUsuario(
        @NotNull Long id,
        String nombre,
        String contrasena,
        Set<Long> idsPerfil
) {
}
