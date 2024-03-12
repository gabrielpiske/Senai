CREATE TABLE empregado (
	id_empregado int,
	nm_empregado varchar(45),
    funcao varchar(45),
    data_contratacao date,
    salario decimal(10,2),
    comissao decimal(10,2),
    id_departamento int,
    lider int);
    
CREATE TABLE departamento (
	id_departamento int not null,
	nm_departamento varchar(30),
    localizacao varchar(30));

CREATE TABLE grade_salarial (
	id_grade_salarial int not null,
	menor_salario decimal(10,2),
    maior_salario decimal(10,2));

CREATE TABLE departamento30
	AS
	SELECT id_empregado, nm_empregado, salario,data_contratacao
	FROM empregado
	WHERE id_departamento = 30;

    desc departamento30;
    
alter table departamento30
	add tarefa varchar(9);
    
alter table departamento30
	modify tarefa varchar(15);
    
alter table departamento30
	drop column tarefa;
    
