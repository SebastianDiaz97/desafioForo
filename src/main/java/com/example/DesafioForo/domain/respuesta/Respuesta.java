package com.example.DesafioForo.domain.respuesta;

import com.example.DesafioForo.domain.topico.Topico;
import com.example.DesafioForo.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topico")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Topico topico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "autor")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario autor;

    private Boolean activo = true;

    public Respuesta(String mensaje, Usuario usuario, Topico topico) {
        this.mensaje = mensaje;
        this.autor = usuario;
        this.topico = topico;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void modificarMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void modificarActivo() {
        this.activo = false;
    }
}
