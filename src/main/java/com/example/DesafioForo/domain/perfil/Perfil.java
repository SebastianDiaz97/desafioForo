package com.example.DesafioForo.domain.perfil;

import com.example.DesafioForo.domain.perfil.DTO.DatosListadoPerfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Boolean activo = true;

    public Perfil(String nombre) {
        this.nombre = nombre;
    }

    public void desactivarPerfil(){
        this.activo = false;
    }

    public Perfil(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void modificarPerfil(DatosListadoPerfil datos) {
        this.nombre = datos.nombre();
    }
//    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
//    @JoinTable(name = "usuarioperfil", joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
//    private Set<Usuario> usuario;
}
