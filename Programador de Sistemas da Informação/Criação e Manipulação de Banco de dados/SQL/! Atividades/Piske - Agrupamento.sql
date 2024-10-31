#1) Recuperar o número de empregados que exercem a função de Analista.
SELECT count(funcao) "Quantidade"
	FROM empregado
    WHERE funcao LIKE 'analista'
    GROUP by funcao;
    
#2) Exibir o menor e o maior salário entre os empregados, assim como a média e a soma de todos os salários de todos os empregados. Coloque apelidos nas colunas Máximo, Mínimo, Soma e Média, respectivamente.
SELECT min(salario) "Menor Salário", max(salario) "Maior Salário", avg(salario) "Média Salário", sum(salario) "Soma Salário"
	FROM empregado;

#3) Exibir o menor e o maior salário dentre os empregados, assim como a média e a soma de todos os salários de todos os empregados agrupados por função.
SELECT min(salario) "Minimo", max(salario) "Máximo", avg(salario) "Média", sum(salario) "Soma"
	FROM empregado
    GROUP BY funcao;

#4) Exibir o nome e o número de empregados com o mesmo cargo.
SELECT funcao, count(funcao) "Qtde empregados"
	FROM empregado
    GROUP BY funcao;

#5) Exibir o nome do departamento, o nome do local, o número de empregados e o salário médio de todos os empregados que atuam no departamento.
SELECT d.nm_departamento "Nome do Departamento", d.localizacao, count(e.funcao) "Qtde Empregados", avg(e.salario) "Média salarios"
	FROM empregado e, departamento d
    WHERE d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    GROUP BY d.ID_DEPARTAMENTO;

#6) Recuperar o nome do departamento onde o salário médio for superior a R$ 2.500.
SELECT d.NM_DEPARTAMENTO
	FROM empregado e RIGHT JOIN departamento d ON e.id_departamento = d.id_departamento
	GROUP BY NM_DEPARTAMENTO
	HAVING AVG(COALESCE(salario,0)) > 2500;

#7) Exibir o nome do departamento e o local onde o número de empregados for igual ou menor a 5 (deve listar o departamento que não tem ninguém).
SELECT d.nm_departamento, d.localizacao
	FROM empregado e RIGHT JOIN departamento d ON e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    GROUP BY d.NM_DEPARTAMENTO, d.LOCALIZACAO
	HAVING COALESCE(COUNT(e.ID_EMPREGADO), 0) <= 5;

#8) Recuperar o nome e a quantidade de liderados que o funcionário possui.
SELECT l.nm_empregado, count(e.lider) 'Qtde Liderados'
	FROM empregado e, empregado l
    WHERE e.lider = l.ID_empregado
    GROUP BY e.lider;

#9) Recuperar o nome do departamento, salário mínimo, salário máximo do departamento
SELECT d.nm_departamento 'Nome Departamento', COALESCE(min(e.salario), 0) 'Salário Minímo', COALESCE(max(e.salario), 0) 'Sálario Maximo'
	FROM departamento d LEFT JOIN empregado e ON e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    GROUP BY d.NM_DEPARTAMENTO;

#10) Recuperar a quantidade de cada grade salarial por departamento.
SELECT d.nm_departamento 'Nome Departamento', count(e.id_empregado) 'Qtde Empregados', g.id_grade_salarial 'ID Grade Salarial'
	FROM empregado e, departamento d, grade_salarial g
    WHERE e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO AND e.salario BETWEEN g.MENOR_SALARIO AND g.MAIOR_SALARIO
    GROUP BY g.ID_GRADE_SALARIAL, d.ID_DEPARTAMENTO
    ORDER BY d.NM_DEPARTAMENTO;