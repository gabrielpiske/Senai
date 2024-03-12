use selecaobasica;

#somente para dados numéricos, pois o retorno delas sempre será um valor numérico.
#Veja o exemplo onde é recuperado a média salarial e a soma de
#todos os salários entre os empregados que são vendedores:
SELECT AVG(salario) 'Média de Salario Vendedor', 
	SUM(salario) 'Soma dos salarios'
	FROM empregado
	WHERE funcao = 'VENDEDOR';
    

#podem ser utilizadas para qualquer tipo de
#dado. O exemplo a seguir ilustra a sentença SQL para recuperar a data
#em que o primeiro empregado foi contratado e a data de
#contratação do empregado mais recente:
SELECT MIN(data_contratacao), 
	MAX(data_contratacao)
	FROM empregado;
    
SELECT MIN(salario), MAX(salario)
	FROM empregado
	WHERE funcao = 'VENDEDOR';
    
    
#retorna o número de linhas (registros) em uma
#tabela ou conjunto de dados restringidos pela condição da cláusula
#WHERE. O exemplo abaixo exibe o número de empregados vinculados
#ao departamento 30:
SELECT COUNT(*)
	FROM empregado
	WHERE id_departamento = 30;
#recebendo como parâmetro uma coluna. Dessa forma, apenas as linhas que
#apresentarem um valor para a coluna COMISSAO serão
#consideradas. Veja:
SELECT COUNT(comissao)
	FROM empregado
	WHERE id_departamento = 30;
    
    
#é necessário utilizar uma função que transforme, em tempo real, o valor nulo da coluna que foi
#passada como parâmetro em um valor válido que não interfira no
#cálculo (neste caso, zero).
SELECT AVG(COALESCE(COMISSAO,0))
	FROM empregado;
    


#Todas as colunas na lista SELECT que não estejam em funções de grupo devem estar na cláusula GROUP BY. Veja o exemplo abaixo,
#que corresponde ao comando ilustrado no cenário recente onde se deseja exibir o valor médio dos empregados por departamento de lotação:
SELECT id_departamento, AVG(salario)
	FROM empregado
	GROUP BY id_departamento;
    
    
#O exemplo a seguir corresponde ao cenário apresentado no slide
#anterior. Observe a presença das duas colunas na cláusula SELECT e
#também na cláusula GROUP BY:
SELECT id_departamento, funcao,
	count(*), SUM(salario)
	FROM empregado
	GROUP BY id_departamento, funcao;
    
    
    
#Use a cláusula HAVING para restringir grupos. Neste caso:
#– as linhas são agrupadas;
#– a função de grupo é aplicada;
#– os grupos que correspondem à cláusula HAVING são exibidos.
SELECT id_departamento, MAX(salario)
	FROM empregado
	GROUP BY id_departamento
	HAVING MAX(salario) > 2900;
#Com a cláusula HAVING temos o comando SELECT completo.
SELECT funcao, SUM(salario) TOTAL
	FROM empregado
	WHERE funcao not like "VENDEDOR%"
	GROUP BY funcao
	HAVING SUM(salario) > 5000
	ORDER BY SUM(salario);
#O exemplo exibe a função e o salário mensal total para cada
#função, com uma folha de pagamento total excedendo R$ 5.000. o
#exemplo exclui vendedores e classifica a lista pelo salário mensal total.



# QUESTÕES

#1) Exibir o menor e o maior salário entre os empregados, assim como a média e a soma de
#todos os salários de todos os empregados. Coloque um apelido nas colunas Máximo, Mínimo,
#Soma e Média, respectivamente.
SELECT max(salario) 'Máximo',
    MIN(salario) 'Mínimo',
	sum(salario) 'Soma',
    avg(salario) 'Média'
	FROM empregado;


#2) Exibir o menor e o maior salário dentre os empregados, assim como a média e a soma de
#todos os salários de todos os empregados agrupados por função.
SELECT  MIN(salario), MAX(salario), FUNCAO,
	AVG(salario),
    SUM(salario)
	FROM empregado
    GROUP BY funcao;


#3) Exibir o nome e o número de empregados com o mesmo cargo.
SELECT NM_EMPREGADO, ID_EMPREGADO,
	count(NM_EMPREGADO)
	FROM empregado
    group by funcao;


#4) Recuperar o número de empregados que exercem a função de gerente.
SELECT funcao, count(*) Contagem
	FROM empregado
	WHERE funcao = 'GERENTE';


#5) Exibir o nome do departamento, o nome do local, o número de empregados e o salário
#médio de todos os empregados que atuam no departamento.
SELECT d.nm_departamento, d.localizacao, 
	count(NM_EMPREGADO),
    avg(salario)
	FROM departamento d, empregado e WHERE d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    GROUP BY d.NM_DEPARTAMENTO, d.LOCALIZACAO;
    


#6) Recuperar o nome do departamento onde o salário médio for superior a R$ 2.000.
SELECT d.nm_departamento,
	AVG(salario) salario
    FROM departamento d, empregado e WHERE d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    HAVING MAX(salario) > 2000;


#7) Exibir o nome do departamento e o local onde o número de empregados for igual ou
#superior a 5 (cinco).
SELECT d.nm_departamento, d.localizacao,
	COUNT(NM_EMPREGADO)
	FROM departamento d
	JOIN empregado e ON d.id_departamento = e.id_departamento
	GROUP BY d.nm_departamento, d.localizacao
	HAVING COUNT(NM_EMPREGADO) >= 5;


#8) Recuperar o nome e a quantidade de liderados que o funcionário possui.
SELECT e.nm_empregado,
	count(l.id_empregado)
    FROM empregado e left join empregado l on e.lider = l.ID_EMPREGADO
    group by nm_empregado;


#9) Recuperar o nome do departamento, salário mínimo, salário máximo do departamento.
SELECT d.nm_departamento 'Departamento',
	MIN(e.salario) 'Salario Mínimo',
	MAX(e.salario) 'Salario Máximo'
	FROM departamento d
	JOIN empregado e ON d.id_departamento = e.id_departamento
	GROUP BY d.nm_departamento;


#10) Recuperar a quantidade de cada grade salarial por departamento.
SELECT d.nm_departamento,
       gs.ID_GRADE,
       COUNT(e.NM_EMPREGADO) AS 'Quantidade de Empregados'
	   FROM departamento d
       JOIN empregado e ON d.id_departamento = e.id_departamento
       JOIN grade_salarial gs ON e.salario BETWEEN gs.MENOR_SALARIO AND gs.MAIOR_SALARIO
	   GROUP BY d.nm_departamento, gs.id_grade;
