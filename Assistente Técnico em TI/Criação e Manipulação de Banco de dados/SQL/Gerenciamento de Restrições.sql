create table departamento(
    id_departamento int,
    nm_departamento varchar(45),
    localizao varchar(20));
    
    TRUNCATE TABLE DEPARTAMENTO;
	SELECT * FROM DEPARTAMENTO;    

    INSERT INTO departamento VALUES (10, 'CONTÁBIL','NEW YORK');
    INSERT INTO departamento VALUES (20, 'PESQUISA E DESENVOLVIMENTO','DALLAS');
    INSERT INTO departamento VALUES (30, 'VENDAS','CHICAGO');
    INSERT INTO departamento VALUES (40, 'OPERAÇÕES','BOSTON');
    
    desc departamento;
    ALTER TABLE departamento
		ADD CONSTRAINT departamento_none_uk UNIQUE (nm_departamento);
        
	desc departamento;
	ALTER TABLE departamento
		ADD CONSTRAINT departamento_id_departamento_pk PRIMARY KEY (id_departamento);

CREATE TABLE empregado(
    id_empregado int,
    nm_empregado varchar(45) NOT NULL,
    funcao varchar(45),
    lider int,
    data_contratacao date,
    salario decimal(10,2),
    comissao decimal(10,2),
    id_departamento int NOT NULL);
    
    TRUNCATE TABLE EMPREGADO;
	SELECT * FROM EMPREGADO;
    
    INSERT INTO empregado VALUES (7369, 'SMITH','ESCRITURÁRIO','7902','1980-12-17','800.00',NULL,'20');
    INSERT INTO empregado VALUES (7499, 'ALLEN','VENDEDOR','7698','1981-02-20','1600.00','300.00','30');
	INSERT INTO empregado VALUES (7521, 'WARD','VENDEDOR','7698','1981-02-22','1250.00','500.OO','30');
	INSERT INTO empregado VALUES (7566, 'JONES','GERENTE','7839','1981-07-02','2975.00',NULL,'20');
    INSERT INTO empregado VALUES (7654, 'MARTIN','VENDEDOR','7698','1981-09-28','1250.00','1400.00','30');
	INSERT INTO empregado VALUES (7698, 'BLAKE','GERENTE','7839','1981-05-01','2850.00',NULL,'30');
    INSERT INTO empregado VALUES (7782, 'CLARK','GERENTE','7839','1981-06-09','2490.00',NULL,'10');
    INSERT INTO empregado VALUES (7588, 'SCOTT','ANALISTA','7566','1982-12-09','3000.00',NULL,'20');
    INSERT INTO empregado VALUES (7839, 'KING','PRESIDENTE',NULL,'1981-11-17','5000.00',NULL,'10');
    INSERT INTO empregado VALUES (7844, 'TURNER','VENDEDOR','7698','1981-09-08','1500.00','0.00','30');
    INSERT INTO empregado VALUES (7876, 'ADAMS','ESCRITURÁRIO','7788','1983-01-12','1100.00',NULL,'20');
    INSERT INTO empregado VALUES (7900, 'JAMES','ESCRITURÁRIO','7698','1981-12-03','950.00',NULL,'30');
    INSERT INTO empregado VALUES (7902, 'FORD','ANALISTA','7566','1981-12-03','3000.00',NULL,'20');
    INSERT INTO empregado VALUES (7934, 'MILLER','ESCRITURÁRIO','7782','1982-01-23','1300.00',NULL,'10');
   
    desc empregado;
    ALTER TABLE empregado
		modify nm_empregado VARCHAR(45) NOT NULL;
        
	alter table empregado
		modify id_departamento int not null;
        
	alter table empregado
		add constraint
        primary key (id_empregado);
        
	alter table empregado
		add constraint empregado_id_empregado_pk 
        foreign key (id_departamento)
        references departamento (id_departamento);

CREATE TABLE grade_salarial(
    id_grade_salarial int,
    menor_salario decimal(10,2),
    maior_salario decimal(10,2));
    
	TRUNCATE TABLE grade_salarial;
	SELECT * FROM grade_salarial; 

    INSERT INTO grade_salarial VALUES (1, 700, 1200);
    INSERT INTO grade_salarial VALUES (2,1201.00,1400.00);
    INSERT INTO grade_salarial VALUES (3,1401.00,2000.00);
    INSERT INTO grade_salarial VALUES (4,2001.00,3000.00);
    INSERT INTO grade_salarial VALUES (5,3001.00,9999.00);