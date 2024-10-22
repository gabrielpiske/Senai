-- Nome: Gabriel Schweder Piske
-- Versão do Apache NetBeans: 19
-- Versão do JDK: JDK 20


---------  Executar o script abaixo para criação do banco

-- Criação Banco
create schema bancocarro;
use bancocarro;

-- Criação Tabela
CREATE TABLE `carro` (
  `cod_carro` int NOT NULL AUTO_INCREMENT,
  `desc_carro` varchar(100) NOT NULL,
  `pot_carro` int NOT NULL,
  `cor_carro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_carro`)
)


---------  Execute caso queira ja deixar o banco pré populado


INSERT INTO carro (desc_carro, pot_carro, cor_carro)
VALUES
  ('Fusca 1970', 60, 'Azul'),
  ('Chevette 1983', 75, 'Preto'),
  ('Civic 2021', 150, 'Prata'),
  ('Gol 2005', 80, 'Vermelho'),
  ('Palio 2009', 85, 'Branco'),
  ('Uno 1997', 65, 'Verde'),
  ('HB20 2018', 120, 'Cinza'),
  ('Fiesta 2013', 95, 'Amarelo'),
  ('Astra 2004', 110, 'Preto'),
  ('Kwid 2022', 70, 'Azul');