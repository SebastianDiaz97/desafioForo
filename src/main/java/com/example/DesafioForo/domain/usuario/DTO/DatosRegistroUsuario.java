package com.example.DesafioForo.domain.usuario.DTO;

import java.util.Set;

public record DatosRegistroUsuario(
        String nombre,
        String email,
        String contrasena,
        Set<Long> idsPerfil
) {
}
