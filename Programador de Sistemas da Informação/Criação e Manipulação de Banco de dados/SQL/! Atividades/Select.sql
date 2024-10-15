#1) recuperar a localização do departamento de operações;
SELECT localizacao 
	FROM DEPARTAMENTO 
    WHERE nm_departamento like 'operações';

#2) recuperar todos os empregados que exercem a função de escriturário;
SELECT nm_empregado 
	FROM EMPREGADO
    WHERE FUNCAO like 'ESCRITURÁRIO';

#3) recuperar o nome, o salário e a comissão dos empregados (que possuem comissão), ordenados pelo maior salário;
SELECT nm_empregado, salario, comissao 
	FROM EMPREGADO 
    WHERE comissao is not null 
    ORDER BY salario DESC;

#4) recuperar o nome, a atividade e a data de contratação dos empregados que trabalham no departamento 20 e recebem mais de R$ 1.000;
SELECT nm_empregado, funcao, data_contratacao
	FROM EMPREGADO
    WHERE id_departamento = 20 AND salario > 1000;

#5) recuperar os empregados que são gerentes;
SELECT nm_empregado
	FROM EMPREGADO
    WHERE funcao like 'gerente';

#6) recuperar as informações dos empregados que possuem a letra o; no nome;
SELECT id_empregado, nm_empregado, funcao, lider, data_contratacao, salario, comissao, id_departamento
	FROM EMPREGADO
    WHERE NM_EMPREGADO like '%o%';

#7) recuperar o nome e o número do departamento de todos os empregados que trabalham nos departamentos 10 e 30 por ordem alfabética de nome do empregado;
SELECT NM_EMPREGADO, ID_DEPARTAMENTO
	FROM EMPREGADO
    WHERE ID_DEPARTAMENTO IN (10,30)
    ORDER BY NM_EMPREGADO;

#8) recuperar as informações dos empregados que foram contratados no ano de 1981.
SELECT id_empregado, nm_empregado, funcao, lider, data_contratacao, salario, comissao, id_departamento
	FROM EMPREGADO
    WHERE data_contratacao like '1981______';

#9) recuperar todos os empregados com comissão maior ou igual a 1000 por ordem alfabética de nome do empregado;
SELECT nm_empregado
	FROM empregado
    WHERE comissao >= 1000
    ORDER BY NM_EMPREGADO;

#10) recuperar empregados que tem salário inferior a R$ 1.300 ordenados pelo salário;
SELECT nm_empregado
	FROM empregado
    WHERE salario < 1300
    ORDER BY salario;