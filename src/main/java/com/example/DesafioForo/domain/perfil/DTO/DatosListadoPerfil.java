package com.example.DesafioForo.domain.perfil.DTO;

import com.example.DesafioForo.domain.perfil.Perfil;

public record DatosListadoPerfil(
        Long id,
        String nombre
) {
    public DatosListadoPerfil(Perfil perfil) {
        this(perfil.getId(), perfil.getNombre());
    }
}
