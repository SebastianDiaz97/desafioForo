package com.example.DesafioForo.domain.perfil;

import com.example.DesafioForo.domain.perfil.DTO.DatosListadoPerfil;
import com.example.DesafioForo.domain.perfil.DTO.DatosRegistroPerfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PerfilService {
    @Autowired
    private PerfilRepository repository;

    public DatosListadoPerfil savePerfil(DatosRegistroPerfil dato) {
        var perfil = new Perfil(dato.nombre());
        repository.save(perfil);
        return new DatosListadoPerfil(perfil);
    }

    public Page<DatosListadoPerfil> listarPerfiles(Pageable paginacion){
        return repository.findByActivoTrue(paginacion).map(DatosListadoPerfil::new);
    }

    public void eliminarPerfil(Long id) {
        var perfil = repository.getReferenceById(id);
        perfil.desactivarPerfil();
    }

    public DatosListadoPerfil modificarPerfil(DatosListadoPerfil datos) {
        var perfil = repository.getReferenceById(datos.id());
        perfil.modificarPerfil(datos);
        return new DatosListadoPerfil(perfil);
    }

    public DatosListadoPerfil buscarPerfil(Long id) {
        var datos = repository.findByIdAndActivoTrue(id);
        return new DatosListadoPerfil(datos);
    }

}
