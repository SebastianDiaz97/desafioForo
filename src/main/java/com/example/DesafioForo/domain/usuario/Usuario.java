package com.example.DesafioForo.domain.usuario;

import com.example.DesafioForo.domain.perfil.Perfil;
import com.example.DesafioForo.domain.usuario.DTO.DatosModificacionUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String contrasena;
    private Boolean activo = true;

    @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
    @JoinTable(
            name = "usuarioperfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id"))
    private Set<Perfil> perfil;

    public Usuario(String nombre, String email, String contrasena, Set<Perfil> perfil) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.perfil = perfil;
    }

    public void modificarDatos(DatosModificacionUsuario datos, String clave, Set<Perfil> perfil) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }
        if (datos.contrasena() != null) {
            this.contrasena = clave;
        }
        if (datos.idsPerfil() != null) {
            this.perfil = perfil;
        }
    }

    public void desactivarPerfil(){
        this.activo = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfil.stream()
                .map(p -> new SimpleGrantedAuthority(p.getNombre()))
                .collect(Collectors.toList());
   //     return List.of(new SimpleGrantedAuthority());
    }

    @Override
    public String getPassword() {
        return contrasena;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
