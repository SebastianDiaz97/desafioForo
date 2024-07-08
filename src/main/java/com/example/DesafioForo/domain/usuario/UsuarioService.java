package com.example.DesafioForo.domain.usuario;

import com.example.DesafioForo.domain.perfil.DTO.DatosListadoPerfil;
import com.example.DesafioForo.domain.perfil.PerfilRepository;
import com.example.DesafioForo.domain.perfil.Perfil;
import com.example.DesafioForo.domain.usuario.DTO.DatosListadoUsuario;
import com.example.DesafioForo.domain.usuario.DTO.DatosModificacionUsuario;
import com.example.DesafioForo.domain.usuario.DTO.DatosRegistroUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public DatosListadoUsuario registrarUsuario(DatosRegistroUsuario datos){
        var clave = passwordEncoder.encode(datos.contrasena());
        Set<Perfil> perfil = perfilRepository.findAllById(datos.idsPerfil()).stream().collect(Collectors.toSet());
        Usuario usuario = new Usuario(datos.nombre(), datos.email(), clave, perfil);
        repository.save(usuario);
        return new DatosListadoUsuario(usuario.getId(), usuario.getNombre(), usuario.getEmail(),
                usuario.getPerfil().stream().map(DatosListadoPerfil::new).collect(Collectors.toSet()));
    }

    public Page<DatosListadoUsuario> listarUsuarios(Pageable paginacion) {
        return repository.findByActivoTrue(paginacion).map(DatosListadoUsuario::new);
    }

    public DatosListadoUsuario modificarUsuario(DatosModificacionUsuario datos) {
        var clave = passwordEncoder.encode(datos.contrasena());
        System.out.println(datos.contrasena());
        System.out.println(datos.nombre());
        System.out.println(datos.idsPerfil());
        Set<Perfil> perfil = perfilRepository.findAllById(datos.idsPerfil()).stream().collect(Collectors.toSet());
        Usuario usuario = repository.getReferenceById(datos.id());
        usuario.modificarDatos(datos, clave, perfil);
        return new DatosListadoUsuario(usuario);
    }

    public void eliminarUsuario(Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.desactivarPerfil();
    }

    public DatosListadoUsuario buscarUsuario(Long id) {
        Usuario usuario = repository.findByIdAndActivoTrue(id);
        return new DatosListadoUsuario(usuario);
    }
}
