# 1- Selecione o nome, o número de indetificação e o nome do departamento de todos os empregados.
SELECT e.nm_empregado, e.id_empregado, d.nm_departamento
	FROM empregado e, departamento d
    WHERE e.id_departamento = d.id_departamento;
    
# 2- Selecione o nome e a localização dos departamentos, junto com o nome, a atividade realizada e o salário dos empregados
# que trabalham na cidade de Nova York
SELECT d.nm_departamento, d.localizacao, e.nm_empregado, e.funcao, e.salario
	FROM empregado e, departamento d
    WHERE e.id_departamento = d.id_departamento AND d.localizacao LIKE 'NEW YORK';
    
# 3- Selecione o nome do empregado, o nome do departamento e a localização de todos os empregado que recebem comissão.
SELECT e.nm_empregado, d.nm_departamento, d.localizacao
	FROM empregado e, departamento d
    WHERE e.id_departamento = d.id_departamento AND e.comissao IS NOT NULL;
    
# 4- Selecione o nome do empregado, a função desempenhada, o nome do departamento, o sálario e a grade salarial de todos os empregados
SELECT e.nm_empregado, e.funcao, d.nm_departamento, e.salario, g.id_grade_salarial
	FROM empregado e, departamento d, grade_salarial g
    WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN g.menor_salario and g.maior_salario;

# 5- Selecione o nome e o numero do empregado, juntamente com o nome e o número do líder. Utilize apelidos para as colunas
# como "Empregado", "Nome Empregado", "Código Líder" e "Nome Líder"
SELECT e.nm_empregado "Nome Empregado", e.id_empregado "Identificador Empregado", l.nm_empregado "Nome Líder", l.id_empregado "Código Líder"
	FROM empregado e
    LEFT JOIN empregado l ON e.lider = l.id_empregado;
   
# 6- Selecione o nome do empregado, o nome do departamento e sua classificação salarial
SELECT e.nm_empregado, d.nm_departamento, g.id_grade_salarial
	FROM empregado e, departamento d, grade_salarial g
    WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN g.menor_salario and g.maior_salario;
   
# 7- Selecione o nome, salário e data de contratação dos empregados que trabalham no departamento de Pesquisa e Desenvolvimento, ordenando
# os resultados pelo salário em ordem decrescente.
select * from departamento;
SELECT e.nm_empregado, e.salario, e.data_contratacao
	FROM empregado e
    left join departamento d ON e.id_departamento = d.id_departamento
    WHERE d.nm_departamento LIKE 'PESQUISA E DESENVOLVIMENTO'
    ORDER BY e.salario desc;
    
# 8- Selecione todos os dados dos empregados que trabalham em chicago e não recebem comissão
SELECT e.* FROM empregado e, departamento D
	WHERE e.id_departamento = d.id_departamento AND d.localizacao LIKE 'CHICAGO' AND e.comissao IS NULL;

# 9-  Selecione o número e o nome dos empregados, assim como o número e o nome do departamento dos empregados cujo salário está entre R$1.500 e R$3.000
SELECT e.id_empregado, e.nm_empregado, d.id_departamento, d.nm_departamento
	FROM empregado e, departamento d
    WHERE e.id_departamento = d.id_departamento AND e.salario BETWEEN 1500 AND 3000;
    
# 10- Selecione o nome, salário e data de contratação do empregado, além do departamento em que ele trabalha. Também selecione o nome, salário
# e data de contratação do líder, ordenando pelos nomes dos funcionarios. Utilize apelidos nas colunas para facilitar a leitura
SELECT e.nm_empregado "Nome Empregado", e.salario "Salario Empregado", e.data_contratacao "Data Contratação Empregado", 
	d.nm_departamento "Nome Departamento", l.nm_empregado "Nome do Líder", l.salario "Salário do Líder", l.data_contratacao "Data Contratação Líder"
	FROM departamento d, empregado e LEFT JOIN empregado l ON e.lider = l.id_empregado
    WHERE e.id_departamento = d.id_departamento
    ORDER BY e.nm_empregado;