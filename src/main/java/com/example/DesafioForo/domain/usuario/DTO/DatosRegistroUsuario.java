package com.example.DesafioForo.domain.usuario.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record DatosRegistroUsuario(
        @NotBlank String nombre,
        @NotBlank @Email String email,
        @NotBlank String contrasena,
        @NotNull Set<Long> idsPerfil
) {
}
