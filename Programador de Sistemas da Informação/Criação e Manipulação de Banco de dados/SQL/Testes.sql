-- Passo 1: Criar o banco de dados
CREATE DATABASE TesteDB;
USE TesteDB;

-- Passo 2: Criar a tabela para armazenar os dados
CREATE TABLE EmpregadoTeste (
    id_empregado INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    cargo VARCHAR(50),
    salario DECIMAL(10,2),
    data_contratacao DATE
);

-- Passo 3: Criar a function para popular a tabela com 10.000 registros
DELIMITER //

CREATE PROCEDURE PopularEmpregadoTeste()
BEGIN
    DECLARE i INT DEFAULT 1;
    
    WHILE i <= 1000 DO
        INSERT INTO EmpregadoTeste (nome, cargo, salario, data_contratacao)
        VALUES (
            CONCAT('Empregado', i), 
            CASE 
                WHEN i % 4 = 0 THEN 'Analista'
                WHEN i % 4 = 1 THEN 'Gerente'
                WHEN i % 4 = 2 THEN 'Desenvolvedor'
                ELSE 'Escriturário'
            END,
            ROUND(RAND() * (5000 - 1000) + 1000, 2),
            DATE_ADD('2000-01-01', INTERVAL RAND()*7000 DAY)
        );
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;
-- Execução
CALL PopularEmpregadoTeste();

-- Passo 5: Criar uma VIEW para visualizar dados agregados
CREATE VIEW ViewResumoEmpregados AS
SELECT 
    cargo,
    COUNT(id_empregado) AS total_empregados,
    AVG(salario) AS media_salarial,
    MAX(salario) AS salario_maximo,
    MIN(salario) AS salario_minimo
FROM EmpregadoTeste
GROUP BY cargo
ORDER BY cargo;
-- Execução
SELECT * FROM testedb.viewresumoempregados;

-- Passo 6: Criar INDEXES para otimizar consultas
CREATE INDEX idx_cargo ON EmpregadoTeste (cargo);

CREATE INDEX idx_data_contratacao ON EmpregadoTeste (data_contratacao);

CREATE INDEX idx_cargo_salario ON EmpregadoTeste (cargo, salario);
