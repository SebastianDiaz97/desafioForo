package com.example.DesafioForo.domain.respuesta.DTO;

import com.example.DesafioForo.domain.respuesta.Respuesta;
import com.example.DesafioForo.domain.topico.DTO.DatosListadoTopicos;
import com.example.DesafioForo.domain.usuario.DTO.DatosListadoMinUsuario;

import java.time.LocalDateTime;

public record DatosListadoRespuesta(
        Long id,
        String mensaje,
        LocalDateTime fechaCreacion,
        DatosListadoTopicos topico,
        DatosListadoMinUsuario autor
) {
    public DatosListadoRespuesta(Respuesta respuesta){
        this(respuesta.getId(), respuesta.getMensaje(), respuesta.getFechaCreacion(),
                new DatosListadoTopicos(respuesta.getTopico()), new DatosListadoMinUsuario(respuesta.getAutor()));
    }
}
