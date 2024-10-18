create schema bancocarro;
use bancocarro;

CREATE TABLE `carro` (
  `cod_carro` int NOT NULL AUTO_INCREMENT,
  `desc_carro` varchar(100) NOT NULL,
  `pot_carro` int NOT NULL,
  `cor_carro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cod_carro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;