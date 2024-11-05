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
            CONCAT('Empregado', i),                        -- Nome: Empregado1, Empregado2, ...
            CASE                                          -- Cargo aleatório
                WHEN i % 4 = 0 THEN 'Analista'
                WHEN i % 4 = 1 THEN 'Gerente'
                WHEN i % 4 = 2 THEN 'Desenvolvedor'
                ELSE 'Escriturário'
            END,
            ROUND(RAND() * (5000 - 1000) + 1000, 2),      -- Salário entre 1000 e 5000
            DATE_ADD('2000-01-01', INTERVAL RAND()*7000 DAY) -- Data aleatória entre 2000 e anos recentes
        );
        SET i = i + 1;
    END WHILE;
END //

DELIMITER ;

-- Passo 4: Executar a função para inserir os registros
CALL PopularEmpregadoTeste();
