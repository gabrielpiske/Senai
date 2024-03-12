#Imagine que você queira produzir uma consulta cujo resultado
#apresente as colunas “ID_EMPREGADO”, “ID_DEPARTAMENTO” e
#“LOCALIZACAO”, conforme visualizado abaixo:

SELECT e.id_empregado, e.id_departamento, d.localizacao
	FROM empregado e, departamento d
	WHERE e.id_departamento = d.id_departamento;
    
#Comando equivalente
SELECT e.id_empregado, e.id_departamento, d.localizacao
	FROM empregado e join departamento d on
	e.id_departamento = d.id_departamento;
    
    
    
#Aliada à junção, você pode acrescentar uma condição(ões)
#adicional(is) para filtrar o resultado. Considere o exemplo abaixo,
#onde se pretende recuperar as informações do empregado “KING”.  
SELECT e.id_empregado, e.id_departamento, d.localizacao
	FROM empregado e, departamento d
	WHERE e.id_departamento = d.id_departamento AND
	e.nm_empregado = 'KING';
    
    
#left join faz junção com todos os empregados
SELECT e.nm_empregado, e.id_departamento, d.nm_departamento, d.localizacao
	FROM empregado e LEFT JOIN departamento d ON (e.id_departamento = d.id_departamento);
    
#righ join
SELECT e.nm_empregado, e.id_departamento, d.nm_departamento, d.localizacao
	FROM empregado e RIGHT JOIN departamento d ON (e.id_departamento = d.id_departamento);
    
    
#Exemplo de junção não idêntica
SELECT e.id_empregado, e.nm_empregado, g.id_grade
	FROM empregado e, grade_salarial g
	WHERE e.salario BETWEEN g.menor_salario and g.maior_salario;
    
    
#Vamos construir uma sentença SQL para recuperar o nome do
#empregado e o nome do LÍDER (que também é um empregado).
#Para isso, vamos utilizar a tabela “EMPREGADO” exercendo o papel
#do empregado e, ao mesmo tempo, exercendo o papel do LÍDER.
#Veja novamente o cenário e a sentença SQL construída:
SELECT e.nm_empregado, l.nm_empregado LIDER
	FROM empregado e, empregado l
	WHERE e.lider = l.id_empregado;
    
    
#QUESTÕES

#1) exibir o nome, o número e o nome do departamento de todos os empregados;
SELECT e.id_empregado, e.NM_EMPREGADO, e.id_departamento, d.NM_DEPARTAMENTO
	FROM empregado e join departamento d on
    e.id_departamento = d.id_departamento;
    
#2) recuperar o nome e a localização dos departamentos e o nome, a atividade e o salário dos
#empregados que trabalham em NEW YORK;
SELECT d.nm_departamento, d.localizacao, e.nm_empregado, e.funcao, e.salario
	FROM empregado e join departamento d on
    e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    WHERE LOCALIZACAO LIKE "NEW YORK";

#3) exibir o nome do empregado, o nome do departamento e a localização de todos os
#empregados que recebem comissão;

SELECT e.nm_empregado, e.nm_empregado, d.localizacao, e.comissao
	FROM empregado e join departamento d on
    e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    WHERE comissao >=0;
    
#4) recuperar o nome e a função do empregado, o nome do departamento, o salário do
#empregado e a grade salarial de todos os empregados (dica: tabela GRADE_SALARIAL);

SELECT e.nm_empregado, e.funcao, d.nm_departamento, e.salario, g.id_grade, g.MENOR_SALARIO, g.MAIOR_SALARIO
	FROM empregado e join departamento d join grade_salarial g on
    e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
	WHERE e.salario >= g.menor_salario and e.salario <= g.maior_salario;
    
#5) exibir o nome e o número do empregado junto com o nome e o número do líder; coloque
#um apelido nas colunas Empregado, Nome_Empregado, Líder e Nome_Líder;

SELECT e.nm_empregado AS Nome_Empregado, e.ID_EMPREGADO AS ID_Empregado, l.ID_EMPREGADO AS ID_Lider, l.nm_empregado AS Nome_Lider
	FROM empregado e left join empregado l
	ON e.lider = l.id_empregado;
    
#6) exibir o nome do empregado, o nome do departamento e a classificação salarial.

SELECT e.nm_empregado, d.nm_departamento, g.id_grade
	FROM empregado e JOIN departamento d JOIN grade_salarial g on
    e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
	WHERE e.salario >= g.menor_salario and e.salario <= g.maior_salario;

#7) recuperar o nome, salário e data de contratação de todos os empregados que trabalham no
#departamento de Pesquisa e Desenvolvimento, ordenados pelo maior salário.

SELECT e.nm_empregado, e.SALARIO, e.DATA_CONTRATACAO, d.NM_DEPARTAMENTO
	FROM empregado e JOIN departamento d ON
    e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    WHERE d.NM_DEPARTAMENTO LIKE "Pesquisa e Desenvolvimento";

#8) recuperar todos os dados dos empregados que trabalham em Chicago e não recebem
#comissão.

SELECT e.ID_EMPREGADO, e.NM_EMPREGADO, e.FUNCAO, e.LIDER, e.DATA_CONTRATACAO, e.SALARIO, e.COMISSAO, e.ID_DEPARTAMENTO, d.localizacao
	FROM empregado e JOIN departamento d ON
	e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    WHERE LOCALIZACAO LIKE "Chicago" AND comissao >=0;

#9) recuperar o número, nome dos empregados, o número e o nome do departamento que
#recebam na faixa de R$ 1.500 e R$ 3.000.

SELECT e.id_empregado, e.nm_empregado, d.id_departamento, d.nm_departamento, e.salario
	FROM empregado e JOIN departamento d ON
    e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    WHERE e.salario >= 1500 AND e.SALARIO <=3000;

#10) recuperar nome, salário, data de contratação do empregado, nome do departamento que o
#funcionário trabalha, nome, salário e data de contratação do líder, ordenados pelo nome do
#funcionário. Utilize apelidos para as colunas.

SELECT e.nm_empregado  nm_empregado,e.salario salario_empregado,e.DATA_CONTRATACAO data_contratação_empregado, d.nm_departamento , 
l.nm_empregado  nm_lider,l.salario salario_lider,l.DATA_CONTRATACAO data_contratação_lider
	FROM departamento d, empregado e LEFT JOIN empregado l ON (e.lider = l.id_empregado) 
    WHERE(e.id_departamento = d.id_departamento)
    ORDER BY e.nm_empregado ASC;


