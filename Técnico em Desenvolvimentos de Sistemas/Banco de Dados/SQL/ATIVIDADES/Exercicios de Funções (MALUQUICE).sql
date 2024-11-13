# 1) Selecionar os nomes dos empregados cujo salário é superior à média salarial de todos os empregados
select nm_empregado
	from empregado
    where salario > (select avg(salario) from empregado);

# 2) Selecionar os empregados cujo salário esta acima da média salarial do seu própria departamento
select D.NM_DEPARTAMENTO, E.NM_EMPREGADO, E.SALARIO, (select avg(e2.salario)
		from empregado e2
        where e2.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO) 'Média por Departamento '
	from empregado e join departamento d on e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    where e.salario > (
		select avg(e2.salario)
		from empregado e2
        where e2.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO
    );

# 3) Selecionar todas as funções distintas desenpenhadas pelos empregados, sem repetições
select distinct funcao
	from empregado;

# 4) Selecionar o nome do empregado e a quantidadede de anos trabalhados na empresa
select nm_empregado, timestampdiff(year, data_contratacao, curdate()) 'Anos Trabalhados'
	from empregado;

# 5) Selecionar o nome do departamento e o total de dias de trabalho de todos os funcionarios do departamento
select d.nm_departamento, sum(coalesce(datediff(curdate(), e.data_contratacao), 0)) 'Anos Trabalhados'
	from empregado e right join departamento d on e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    group by d.ID_DEPARTAMENTO, d.NM_DEPARTAMENTO;

# 6) Selecionar o nome do empregado, o nome do líder, a data de contratação do empregado e do líder (no formato dd/mm/yy)
# e a diferença entre as datas de contratação do líder e do empregado em anos, meses e dias.
select e.nm_empregado, l.nm_empregado 'Líder', 
date_format(e.data_contratacao, '%d/%m/%Y') 'Contratação Empregado',
date_format(l.data_contratacao, '%d/%m/%Y') 'Contratação Líder',
COALESCE(ABS(timestampdiff(year, e.data_contratacao, l.data_contratacao)), 0) 'Diferença em Anos',
COALESCE(ABS(timestampdiff(month, e.data_contratacao, l.data_contratacao)), 0)%12 'Diferença em meses',
COALESCE(ABS(datediff(e.data_contratacao, l .data_contratacao)), 0)%30 'Diferença em Dias'
	from empregado e left join empregado l on e.LIDER = l.ID_EMPREGADO;

# 7) Selecionar uma sring com duas primeiras letras do nome do empregado, seguidas pelo caractere "*" juntamento com nome
# do departamento, função, e o nome do líder abreviado para as três primeiras letras seguidas do caractere "*"
select CONCAT(LEFT(e.nm_empregado, 2), '*', d.nm_departamento, 
           ', ', e.funcao, 
           ', ', LEFT(l.nm_empregado, 3), '*') 'Formatado'
	from empregado e join departamento d on e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    left join empregado l on e.lider = l.ID_EMPREGADO;

# 8) Selecionar o nome do empregado, o nome do departamento e a classificação da grade salarial de cada empregado,
# substituindo o ID_GRADE_SALARIAL por descrições textuais: 1- Ruim, 2- Abaixo da Média, 3- Mediano, 4- Acima da Média, 5 - Execelente
select e.nm_empregado, d.nm_departamento,
	case g.id_grade_salarial
		when 1 then 'Ruim'
        when 2 then 'Abaixo da Média'
		when 3 then 'Mediano'
        when 4 then 'Acima da Média'
        when 5 then 'Execelente'
	end 'Classificação'
    from empregado e 
    join departamento d on e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO, grade_salarial g 
    where e.salario between g.MENOR_SALARIO and g.MAIOR_SALARIO;

# 9) Recuperar o nome de cada departamento e a porcentagem de participação no pagamento total da empresa, considerando a soma dos salários
# e comissões dos empregados de cada departamento
select d.nm_departamento 'Nome do Departamento ', 
	replace(concat(cast(round(sum(e.salario + coalesce(e.comissao, 0)) / (
		select sum(e2.salario + coalesce(e2.comissao, 0))
			from empregado e2
    ) * 100,2) as char ),'%'),'.',',') 'Porcentagem'
    from empregado e right join departamento d on e.ID_DEPARTAMENTO = d.ID_DEPARTAMENTO
    group by d.NM_DEPARTAMENTO
    order by d.NM_DEPARTAMENTO;

# 10) Selecionar os empregados que são lideres, juntamente com a quantidade de subordinados, a data de contratação do líder 
# (no formato dd/mm/yyyy), e a soma dos salários e comissões de todos os seus subordinados, 
# utilizando apelidos nas colunas para identificação
SELECT l.NM_EMPREGADO 'Líderes', COUNT(e.ID_EMPREGADO) 'Nº Contratados', DATE_FORMAT(l.DATA_CONTRATACAO, '%d/%m/%Y') 'Data de Contratação',
	SUM(e.SALARIO + COALESCE(e.COMISSAO, 0))'Soma'
	FROM empregado e, empregado l
	WHERE e.lider = l.ID_EMPREGADO
	GROUP BY l.ID_EMPREGADO;