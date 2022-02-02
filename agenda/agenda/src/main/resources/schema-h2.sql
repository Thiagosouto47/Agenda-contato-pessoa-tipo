create table pessoa(id bigint auto_increment, nome varchar(100), cpf varchar(20), rg varchar(15), sexo varchar(1));
create table contato(id bigint auto_increment, descr_contato varchar(50), pessoa_id integer, tipo_id integer);
create table tipo(id bigint auto_increment, tipo_contato varchar(30));

Alter table contato add constraint fk_pessoa foreign key(pessoa_id)
references pessoa(pessoa_id);

Alter table contato add constraint fk_contato foreign key(tipo_id)
references tipo(tipo_id);