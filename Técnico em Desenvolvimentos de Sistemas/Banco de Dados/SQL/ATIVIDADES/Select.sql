-- 1 Recuperar a localização do departamento de vendas
SELECT LOCALIZACAO
	FROM DEPARTAMENTO
    WHERE NM_DEPARTAMENTO = 'VENDAS';
    
-- 2 Recuperar todos os empregados que exercem a função de Analista
SELECT NM_EMPREGADO, FUNCAO
	FROM EMPREGADO
	WHERE FUNCAO = 'ANALISTA';
    
-- 3 Recuperar o nome, salário e a comissão dos empregado (que possuem comissão) ou seja que não sejam nulos, ordenados pelo maior salario
SELECT NM_EMPREGADO, SALARIO, COMISSAO
	FROM EMPREGADO
    WHERE COMISSAO IS NOT NULL
    ORDER BY SALARIO DESC;
    
-- 4 Recuperar o nome, a atividade de contratação dos empregados que trabalham no departamento 20 e recebem mais de R$1.000,00
SELECT NM_EMPREGADO, FUNCAO, DATA_CONTRATACAO
	FROM EMPREGADO
    WHERE ID_DEPARTAMENTO = 20 AND SALARIO > 1000;
    
-- 5 Recuperar os dados dos empregados que são gerentes com apelidos amigaveis
SELECT  ID_EMPREGADO AS IDENTIFICADOR, NM_EMPREGADO AS NOME_DO_EMPREGADO, FUNCAO AS FUNÇÃO, LIDER 
AS LIDER_DO_EMPREGADO, DATA_CONTRATACAO AS DATA_CONTRATAÇÃO, SALARIO AS SALÁRIO, COMISSAO AS COMISSÃO, ID_DEPARTAMENTO AS IDENTIFICADOR_DEPARTAMENTO
	FROM EMPREGADO
    WHERE FUNCAO = 'GERENTE';

-- 6 Recuperar os dados dos empregados que possuem a letra 'A' no nome
SELECT ID_EMPREGADO, NM_EMPREGADO, FUNCAO, LIDER, DATA_CONTRATACAO, SALARIO, COMISSAO, ID_DEPARTAMENTO
	FROM EMPREGADO
    WHERE NM_EMPREGADO LIKE '%A%';
    
-- 7 Recuperar o nome e o numero do departamento de todos os empregados que trabalham nos departamento 10 e 30 por ordem alfabetica de nome do empregado
SELECT NM_EMPREGADO, ID_DEPARTAMENTO
	FROM EMPREGADO
    WHERE ID_DEPARTAMENTO IN (10,30)
    ORDER BY NM_EMPREGADO;
    
-- 8 Recuperar as informações dos empregados que foram contratados no ano de 1982
SELECT ID_EMPREGADO, NM_EMPREGADO, FUNCAO, LIDER, DATA_CONTRATACAO, SALARIO, COMISSAO, ID_DEPARTAMENTO
	FROM EMPREGADO
    WHERE DATA_CONTRATACAO LIKE '1982______';
    
-- 9 Recuperar todos os empregados com comissão maior ou igual a R$ 500,00 por ordem alfabética de nome do empregado
SELECT NM_EMPREGADO, COMISSAO
	FROM EMPREGADO
    WHERE COMISSAO >= 500
    ORDER BY NM_EMPREGADO;
    
-- 10 Recuperar empregados que tem salario inferior a R$ 1.300 ordenados pelo salario
SELECT NM_EMPREGADO, SALARIO
	FROM EMPREGADO
    WHERE SALARIO < 1300
    ORDER BY SALARIO DESC;