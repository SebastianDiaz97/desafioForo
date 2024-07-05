package com.example.DesafioForo.domain.usuario.DTO;

import com.example.DesafioForo.domain.perfil.DTO.DatosListadoPerfil;

import java.util.Set;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        String email,
        Set<DatosListadoPerfil> perfiles
) {

}
