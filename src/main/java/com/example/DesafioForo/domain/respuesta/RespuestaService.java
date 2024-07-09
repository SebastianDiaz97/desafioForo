package com.example.DesafioForo.domain.respuesta;

import com.example.DesafioForo.domain.respuesta.DTO.DatosListadoRespuesta;
import com.example.DesafioForo.domain.respuesta.DTO.DatosModificarRespuesta;
import com.example.DesafioForo.domain.respuesta.DTO.DatosRegistroRespuesta;
import com.example.DesafioForo.domain.topico.TopicoRepository;
import com.example.DesafioForo.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosListadoRespuesta crearRespuesta(DatosRegistroRespuesta datos) {
        var usuario = usuarioRepository.getReferenceById(datos.idAutor());
        var topico = topicoRepository.getReferenceById(datos.idTopico());
        var mensaje = datos.mensaje();
        var respuesta = new Respuesta(mensaje, usuario, topico);
        respuestaRepository.save(respuesta);
        var listado = new DatosListadoRespuesta(respuesta);
        return listado;
    }

    public Page<DatosListadoRespuesta> listarRespuesta(Pageable paginacion) {
        return respuestaRepository.findByActivoTrue(paginacion).map(DatosListadoRespuesta::new);
    }

    public DatosListadoRespuesta buscarRespuesta(Long id) {
        return new DatosListadoRespuesta(respuestaRepository.findByIdAndActivoTrue(id));
    }

    public DatosListadoRespuesta modificarRespuesta(DatosModificarRespuesta datos) {
        var respuesta = respuestaRepository.getReferenceById(datos.id());
        respuesta.modificarMensaje(datos.mensaje());
        return new DatosListadoRespuesta(respuesta);
    }

    public void eliminarRespuesta(Long id) {
        var respuesta = respuestaRepository.getReferenceById(id);
        respuesta.modificarActivo();
    }
}
