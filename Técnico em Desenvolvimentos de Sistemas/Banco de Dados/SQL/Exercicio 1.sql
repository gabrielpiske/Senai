create table empregado(
	id_empregado int,
	nm_empregado varchar(45),
    funcao varchar(45),
    data_contratacao date,
    salario decimal(10,2),
    comissao decimal(10,2),
    id_departamento int,
    lider int
    
);
drop table empregado;
desc empregado;

create table grade_salarial(
    menor_salario decimal(10,2),
    maior_salario decimal(10,2)
);
desc grade_salarial;

create table departamento(
	nm_departamento varchar(45),
    localizacao varchar(20)
);
desc departamento;

create table departamento30
	as
		select id_empregado, nm_empregado, salario, data_contratacao
        from empregado
        where id_departamento = 30
;
desc departamento30;

alter table departamento30
	add tarefa varchar(9);
    
alter table departamento30
	modify tarefa varchar(15);
    
alter table departamento30
	drop tarefa;
    
drop table departamento30;