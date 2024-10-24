#1) Recuperar o nome, o número do empregado e o nome do departamento de todos os empregados;
SELECT e.nm_empregado, e.id_empregado, d.nm_departamento
	FROM empregado e, departamento d
    WHERE e.id_departamento = d.id_departamento;

#2) Recuperar o nome e a localização dos departamentos e o nome, a atividade e o salário dos empregados que trabalham em NEW YORK;
SELECT d.nm_departamento, d.localizacao, e.nm_empregado, e.funcao, e.salario
	FROM empregado e, departamento d
    WHERE e.id_departamento = d.id_departamento AND d.localizacao LIKE 'NEW YORK';

#3) Recuperar o nome do empregado, o nome do departamento e a localização de todos os empregados que recebem comissão;
SELECT e.nm_empregado, d.nm_departamento, d.localizacao
	FROM empregado e, departamento d
    WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO AND e.COMISSAO IS NOT NULL;

#4) Recuperar o nome, salário e data de contratação de todos os empregados que trabalham no departamento de Pesquisa e Desenvolvimento, ordenados pelo maior salário.
SELECT e.nm_empregado, e.salario, e.data_contratacao
	FROM empregado e
    LEFT JOIN departamento d ON e.id_departamento = d.id_departamento
    WHERE d.nm_departamento LIKE 'PESQUISA E DESENVOLVIMENTO'
    ORDER BY e.salario DESC;

#5) Recuperar todos os dados dos empregados que trabalham em Chicago e não tem comissão.
SELECT e.* FROM empregado e, departamento d
	WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO AND d.localizacao LIKE 'CHICAGO' AND e.comissao IS NULL;

#6) Recuperar o número e o nome dos empregados, o número e o nome do departamento dos empregados que recebam na faixa de R$ 1.000 e R$ 2.300.
SELECT e.id_empregado, e.nm_empregado, d.id_departamento, d.nm_departamento
	FROM empregado e, departamento d
    WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO AND e.salario BETWEEN 1000 AND 2300;

#7) Recuperar o nome e a função do empregado, o nome do departamento, o salário do empregado e a grade salarial (ID_GRADE_SALARIAL) de todos os empregados;
SELECT e.nm_empregado, e.funcao, d.nm_departamento, e.salario, g.id_grade_salarial
	FROM empregado e, departamento d, grade_salarial g
    WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO AND e.salario BETWEEN g.menor_salario AND g.maior_salario;

#8) Recuperar o nome e o número do empregado junto com o nome e o número do líder; coloque um apelido nas colunas ID Empregado, Nome Empregado, ID Líder e Nome Líder;
SELECT e.nm_empregado "Nome Empregado", e.id_empregado "Identificador Empregado", l.nm_empregado "Nome Líder", l.id_empregado "Identificador Líder"
	FROM empregado e
    LEFT JOIN empregado l ON e.lider = l.id_empregado;

#9) Recuperar o nome do empregado, o nome do departamento e a classificação salarial.
SELECT e.nm_empregado, d.nm_departamento, g.id_grade_salarial
	FROM empregado e, departamento d, grade_salarial g
    WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO AND e.salario BETWEEN g.menor_salario and g.maior_salario;

#10) Recuperar nome, salário e data de contratação do empregado, o nome do departamento que o funcionário trabalha e o nome, o salário e data de contratação do líder, ordenados pelo
# nome do funcionário. Utilize apelidos para as colunas para facilitar a leitura.
SELECT e.nm_empregado "Nome Empregado", e.salario "Salario Empregado", e.data_contratacao "Data Contratação", d.nm_departamento "Nome Departamento", l.nm_empregado "Nome Líder",
		l.salario "Salário Líder", l.data_contratacao "Data Contratação Líder"
	FROM departamento d, empregado e
    LEFT JOIN empregado l ON e.lider = l.id_empregado
    WHERE e.id_departamento = d.id_departamento
    ORDER BY e.nm_empregado;