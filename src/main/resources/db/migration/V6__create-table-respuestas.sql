create table respuestas(
    id bigint not null auto_increment,
    mensaje varchar(255) not null,
    fechaCreacion datetime not null,
    autor bigint not null,
    topico bigint not null,

    primary key(id),

    constraint fk_respuestas_autor foreign key(autor) references usuarios(id),
    constraint fk_respuestas_topico foreign key(topico) references topicos(id)
);