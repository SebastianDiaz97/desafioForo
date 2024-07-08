package com.example.DesafioForo.domain.usuario.DTO;

import com.example.DesafioForo.domain.perfil.DTO.DatosListadoPerfil;
import com.example.DesafioForo.domain.usuario.Usuario;

import java.util.Set;
import java.util.stream.Collectors;

public record DatosListadoUsuario(
        Long id,
        String nombre,
        String email,
        Set<DatosListadoPerfil> perfiles
) {
    public DatosListadoUsuario (Usuario usuario) {
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail(), usuario.getPerfil().stream().map(DatosListadoPerfil::new).collect(Collectors.toSet()));
    }
}
