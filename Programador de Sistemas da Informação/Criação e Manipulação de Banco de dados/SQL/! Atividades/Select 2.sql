#1) Selecione todos os empregados e suas funções
SELECT nm_empregado, funcao
	FROM empregado;
    
#2) Liste todos os departamentos e suas localizações
SELECT NM_DEPARTAMENTO, localizacao
	FROM departamento;

#3) Encontre todos os empregados com salário maior que 3000
SELECT nm_empregado, salario
	FROM empregado
    WHERE salario > 3000;

#4) Mostre o nome e a função dos empregados que trabalham no departamento de Vendas
SELECT nm_empregado, funcao
	FROM empregado
    WHERE ID_DEPARTAMENTO = 30;

#5) Liste os empregados contratados antes de 1982
SELECT nm_empregado, data_contratacao
	FROM empregado
    WHERE data_contratacao < '1982-01-01';

#6) Encontre o empregado que tem a maior comissão
SELECT nm_empregado, comissao
	FROM empregado
    ORDER BY comissao DESC
    LIMIT 1;
    
SELECT nm_empregado, comissao
	FROM empregado
	WHERE comissao = (SELECT MAX(comissao) FROM empregado);

#7) Liste os empregados que são gerentes
SELECT nm_empregado, funcao
	FROM empregado
    WHERE funcao LIKE "GERENTE";

#8) Mostre os empregados que não têm líder
SELECT nm_empregado, lider
	FROM empregado
    WHERE lider IS NULL;

#9) Exiba os empregados que ganham um salário dentro da faixa salarial de 1201 a 1400
SELECT nm_empregado, salario
	FROM empregado
    WHERE salario BETWEEN 1201 AND 1400;

#10) Mostre o empregado mais recente (último contratado):
SELECT nm_empregado, data_contratacao
	FROM empregado
    ORDER BY DATA_CONTRATACAO DESC
    LIMIT 1;