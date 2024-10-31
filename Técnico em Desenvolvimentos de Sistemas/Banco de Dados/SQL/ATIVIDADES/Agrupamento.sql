# 1- selecione o menor e o maior salario, além da média e da soma de todos os salarios dos empregados.
#utilize apelidos nas colunas, denominando como "maximo", "minimo", "soma" e "media"
SELECT min(salario) "Minimo", max(salario) "Máximo", avg(salario) "Média", sum(salario) "Soma"
	FROM empregado;
    
# 2- Selecione o menor e o maior salario, além da média e a soma dos salários, agrupando os resultados por função dos empregados
SELECT min(salario) "Menor Salário", max(salario) "Maior Salário", avg(salario) "Média Salário", sum(salario) "Soma Salário"
	FROM empregado
    GROUP BY funcao;
    
# 3- Selecione o nome do cargo e o número total de empregados que ocupam o mesmo cargo
SELECT funcao, count(funcao)
	FROM empregado
    GROUP BY funcao;
    
# 4- Selecione o nome e o número total de empregados que exercem a função de gerente
SELECT funcao, count(funcao) "Quantidade"
	FROM empregado
    WHERE funcao LIKE 'gerente'
    GROUP by funcao;
    
# 5- Selecione o nome do departamento, o nome da localização, o número de empregados e o salario médio dos empregados que atuam no departamento
SELECT d.nm_departamento, d.localizacao, count(e.funcao) "Qtde Empregados", avg(e.salario) "Média salarios"
	FROM empregado e, departamento d
    WHERE d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    GROUP BY d.ID_DEPARTAMENTO;
    
# 6- Selecione o nome dos departamentos onde o salario média dos empregados é superior a R$ 2.000,00
SELECT d.NM_DEPARTAMENTO
	FROM empregado e RIGHT JOIN departamento d ON e.id_departamento = d.id_departamento
	GROUP BY NM_DEPARTAMENTO
	HAVING AVG(COALESCE(salario,0)) > 2000;

# 7- Selecione o nome do departamento e sua localização onde o número de empregados seja igual ou superior a 5
SELECT d.nm_departamento, d.localizacao
	FROM empregado e RIGHT JOIN departamento d ON e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    GROUP BY d.NM_DEPARTAMENTO, d.LOCALIZACAO
    HAVING count(e.ID_EMPREGADO) >= 5;
    
# 8- Selecione o nome do funcionario e quantidade de liderados que ele possui
SELECT l.nm_empregado, count(e.lider) 'Qtde Liderados'
	FROM empregado e, empregado l
    WHERE e.lider = l.ID_empregado
    GROUP BY e.lider;
    
# 9- Selecione o nome do departamento, o salário mínimo e o salário maximo dos empregados em cada departamento
SELECT d.nm_departamento, COALESCE(min(e.salario), 0) 'Salário Minimo', COALESCE(max(e.salario), 0) 'Salario Maximo'
	FROM departamento d LEFT JOIN empregado e ON  e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    GROUP BY d.NM_DEPARTAMENTO;
    
# 10- Selecione a quantidade de empregados em cada faixa salarial, agrupando por departamento
SELECT count(e.id_empregado) 'Qtde de Empregados', g.id_grade_salarial
	FROM empregado e, grade_salarial g, departamento d
    WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN g.MENOR_SALARIO AND g.MAIOR_SALARIO
    GROUP BY g.ID_GRADE_SALARIAL, d.ID_DEPARTAMENTO;