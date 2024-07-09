package com.example.DesafioForo.domain.topico.DTO;

import com.example.DesafioForo.domain.curso.DTO.DatosListadoCursos;
import com.example.DesafioForo.domain.topico.Topico;
import com.example.DesafioForo.domain.usuario.DTO.DatosListadoMinUsuario;

import java.time.LocalDateTime;

public record DatosListadoTopicos(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        DatosListadoMinUsuario autor,
        DatosListadoCursos curso
) {
    public DatosListadoTopicos(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), new DatosListadoMinUsuario(topico.getAutor()), new DatosListadoCursos(topico.getCurso()));
    }
}
