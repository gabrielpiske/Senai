-- Criação do schema (banco de dados)
CREATE DATABASE IF NOT EXISTS teste;

-- Seleciona o banco de dados
USE teste;

-- Criação da tabela produto
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL
);

-- Criação da tabela historico_precos
CREATE TABLE historico_precos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto_id INT,
    valor DECIMAL(10, 2),
    data_fim DATETIME,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);

-- Trigger para atualizar o histórico de preços sempre que o preço for alterado
DELIMITER $$

CREATE TRIGGER atualizar_preco
AFTER UPDATE ON produto
FOR EACH ROW
BEGIN
    -- Atualiza o histórico de preços com data_fim para o preço anterior
    IF OLD.preco <> NEW.preco THEN
        UPDATE historico_precos
        SET data_fim = NOW()
        WHERE produto_id = OLD.id AND data_fim IS NULL;

        -- Insere o novo preço no histórico
        INSERT INTO historico_precos (produto_id, valor, data_fim)
        VALUES (NEW.id, NEW.preco, NULL);
    END IF;
END $$

DELIMITER ;

-- Inserir produtos de teste
INSERT INTO produto (nome, preco) VALUES ('Produto 1', 50.00);
INSERT INTO produto (nome, preco) VALUES ('Produto 2', 30.00);
INSERT INTO produto (nome, preco) VALUES ('Produto 3', 100.00);

-- Atualizando os preços para testar a trigger
UPDATE produto SET preco = 55.00 WHERE id = 1;
UPDATE produto SET preco = 35.00 WHERE id = 2;
UPDATE produto SET preco = 120.00 WHERE id = 3;


select * from produto;
select * from historico_precos;_
