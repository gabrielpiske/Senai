CREATE SCHEMA `exemploprogramador` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_cs ;
use exemploprogramador;

-- Cria tabela departamento
create table departamento(
	id_departamento int,
	nm_departamento varchar(45) not null,
    localizacao varchar(20) not null,
    constraint id_departamento_pk
    primary key (id_departamento)
);

-- Cria tabela grade salarial
create table grade_salarial(
	id_grade_salarial int,
    menor_salario decimal(10,2) not null,
    maior_salario decimal(10,2) not null,
    constraint grade_salarial_id_grade_salarial_pk
    primary key (id_grade_salarial)
);

-- Cria tabela empregado
create table empregado(
	id_empregado int primary key,
	nm_empregado varchar(45) not null,
    funcao varchar(45) not null,
    data_contratacao date not null,
    salario decimal(10,2) not null,
    comissao decimal(10,2),
    id_departamento int not null,
    lider int,
    constraint empregado_id_empregado_pk
    foreign key (lider) references empregado(id_empregado),
    constraint empregado_id_departamento_fk
    foreign key (id_departamento) references departamento(id_departamento)
);