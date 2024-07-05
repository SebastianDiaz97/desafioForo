create table usuarioperfil(
    usuario_id bigint,
    perfil_id bigint,

    primary key(usuario_id, perfil_id),

    constraint fk_usuarioperfil_usuario_id foreign key(usuario_id) references usuarios(id),
    constraint fk_usuarioperfil_perfil_id foreign key(perfil_id) references perfiles(id)
)