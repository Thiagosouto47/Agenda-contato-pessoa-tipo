create table pessoa(id bigint auto_increment, nome varchar(60), cpf varchar(12), rg varchar(14), sexo varchar(1));
create table contato(id bigint auto_increment, descr_contato varchar(50), pessoa_id integer, tipo_id integer);
create table tipo(id bigint auto_increment, tipo_contato varchar(35));

Alter table contato add constraint fk_pessoa foreign key(pessoa_id)
references pessoa(pessoa_id);

Alter table contato add constraint fk_contato foreign key(tipo_id)
references tipo(tipo_id);
