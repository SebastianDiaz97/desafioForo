package com.example.DesafioForo.domain.curso;

import com.example.DesafioForo.domain.curso.DTO.DatosListadoCursos;
import com.example.DesafioForo.domain.curso.DTO.DatosModificarCurso;
import com.example.DesafioForo.domain.curso.DTO.DatosRegistroCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public DatosListadoCursos crearCurso(DatosRegistroCurso datos) {
        var curso = new Curso(datos.nombre(), datos.categoria());
        repository.save(curso);
        return new DatosListadoCursos(curso.getId(), curso.getNombre(), curso.getCategoria());
    }

    public Page<DatosListadoCursos> listarCursos(Pageable paginacion) {
        return repository.findByActivoTrue(paginacion).map(DatosListadoCursos::new);

    }

    public DatosListadoCursos buscarCurso(Long id) {
        var response = repository.findByIdAndActivoTrue(id);
        return new DatosListadoCursos(response);
    }

    public DatosListadoCursos modificarCurso(DatosModificarCurso datos) {
        var curso = repository.getReferenceById(datos.id());
        curso.modificarNombre(datos.nombre());
        return new DatosListadoCursos(curso);
    }

    public void eliminarCurso(Long id) {
        var curso = repository.getReferenceById(id);
        curso.eliminar();
    }
}
