create table tra_trabalho (
    tra_id bigint generated always as identity,
    tra_titulo varchar(100) not null unique,
    tra_data_hora_entrega timestamp not null,
    tra_descricao varchar(200),
    tra_usr_id bigint not null,
    tra_nota int,
    foreign key (tra_usr_id) references usr_usuario (usr_id) on delete restrict on update cascade
);

insert into tra_trabalho (tra_titulo, tra_data_hora_entrega, tra_nota, tra_usr_id)
  values ('Teste 1', current_timestamp, 6, 1),
         ('Teste 2', current_timestamp, null, 1);

grant update, delete, insert, select on all tables in schema public to spring;