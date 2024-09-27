-- Cria database
create database exemploTecnico;

-- Força o uso dela
use exemploTecnico;

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
	id_empregado int,
	nm_empregado varchar(45) not null,
    funcao varchar(45) not null,
    data_contratacao date not null,
    salario decimal(10,2) not null,
    comissao decimal(10,2),
    id_departamento int,
    lider int,
    constraint empregado_id_empregado_pk
    primary key empregado(id_empregado),
    constraint empregado_lider_fk
    foreign key (lider) references empregado(id_empregado),
    constraint empregado_id_departamento_fk
    foreign key (id_departamento) references departamento(id_departamento)
);

-- Inserir Dados na Tabela Departamento
insert into departamento (id_departamento, nm_departamento, localizacao)
	values (50, 'Desenvolvimento', 'Detroit'),
		   (60, "Web-Design", "Timbo"),
           (70, "Suporte", "Detroit");
insert into departamento values (80, "RH", "IndaHell");

-- Inserir Dados na tabela Empregado
insert into empregado values (1, "Hermano", "Professor", "2014-03-02", "1000", null, 60, null);
insert into empregado values (2, "Gerson", "Professor", "2019-05-01", "1500", null, 60, null);
insert into empregado values (3, "Gustavo", "Professor", "2021-10-01", "500", null, 70, 1);
insert into empregado (id_empregado, nm_empregado, funcao, data_contratacao, salario, comissao, id_departamento)
	values (4, "Sabrina", "Atendimento", "2023-12-1", 400,100,70);

-- Utilizando UPDATE
update empregado set nm_empregado = "Hemano Roepke"
	where id_empregado = 1;

-- Exibir dados
select * from departamento;
select * from empregado;

delete from departamento where id_departamento = 80;

-- UTILIZAR ROLLBACK PRA ARRUMAR POSSIVEIS ERROS
#rollback;
-- COMMIT PRA COMITAR E AÍ NÃO TEM VOLTA
#commit;