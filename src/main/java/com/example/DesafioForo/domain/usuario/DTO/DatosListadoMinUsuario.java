package com.example.DesafioForo.domain.usuario.DTO;

import com.example.DesafioForo.domain.usuario.Usuario;

public record DatosListadoMinUsuario(
        Long id,
        String nombre
) {
    public DatosListadoMinUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNombre());}
}
