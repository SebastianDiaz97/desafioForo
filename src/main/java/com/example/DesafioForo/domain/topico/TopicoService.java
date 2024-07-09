package com.example.DesafioForo.domain.topico;

import com.example.DesafioForo.domain.curso.CursoRepository;
import com.example.DesafioForo.domain.topico.DTO.DatosListadoTopicos;
import com.example.DesafioForo.domain.topico.DTO.DatosModificacionTopico;
import com.example.DesafioForo.domain.topico.DTO.DatosRegistroTopico;
import com.example.DesafioForo.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    public Object crearTopico(DatosRegistroTopico datos) {
        var usuario = usuarioRepository.getReferenceById(datos.idAutor());
        var curso = cursoRepository.getReferenceById(datos.idCurso());
        var topico = new Topico(datos, usuario, curso);
        topicoRepository.save(topico);
        return new DatosListadoTopicos(topico);
    }

    public Page<DatosListadoTopicos> listarTopico(Pageable paginacion) {
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopicos::new);
    }

    public DatosListadoTopicos buscarTopico(Long id) {
        var topico = topicoRepository.findByIdAndActivoTrue(id);
        return new DatosListadoTopicos(topico);
    }

    public DatosListadoTopicos modificarTopico(DatosModificacionTopico datos) {
        var topico = topicoRepository.getReferenceById(datos.id());
        topico.modificarMensaje(datos.mensaje());
        return new DatosListadoTopicos(topico);
    }

    public void eliminarTopico(Long id) {
        var topico = topicoRepository.getReferenceById(id);
        topico.modificarActivo();
    }
}
