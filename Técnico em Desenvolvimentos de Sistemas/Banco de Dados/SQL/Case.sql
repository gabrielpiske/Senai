select *, (salario + coalesce(comissao, 0)) 'Total',
case 
	when (salario + coalesce(comissao, 0)) > 4000 then 'Ganha bem'
    when (salario + coalesce(comissao, 0))> 2500 then 'Ganha mais ou menos'
    else 'Quer esmola?'
end 'Status'
	from empregado
    order by NM_EMPREGADO;
    
    
    
select NM_DEPARTAMENTO,
case 
	when NM_DEPARTAMENTO like 'CONTÁBIL' then 'CONTADOR'
    when NM_DEPARTAMENTO like 'PESQUISA E DESENVOLVIMENTO' then 'PESQUISAMENTO'
    when NM_DEPARTAMENTO like 'VENDAS' then 'VENDEDOR DE PICOLÉ'
    when NM_DEPARTAMENTO like 'OPERAÇÕES' then 'OPERACIONAL'
    else ''
end 'Apelidinho'
	from departamento d left join empregado e on d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO;
    
    
    
select distinct E.ID_DEPARTAMENTO, NM_DEPARTAMENTO,
case 
	when NM_DEPARTAMENTO like 'CONTÁBIL' then 'CONTADOR'
    when NM_DEPARTAMENTO like 'PESQUISA E DESENVOLVIMENTO' then 'PESQUISAMENTO'
    when NM_DEPARTAMENTO like 'VENDAS' then 'VENDEDOR DE PICOLÉ'
    when NM_DEPARTAMENTO like 'OPERAÇÕES' then 'OPERACIONAL'
    else ''
end 'Apelidinho'
	from departamento d left join empregado e on d.ID_DEPARTAMENTO = e.ID_DEPARTAMENTO;