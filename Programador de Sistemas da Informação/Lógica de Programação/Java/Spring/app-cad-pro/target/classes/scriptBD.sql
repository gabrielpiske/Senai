CREATE SCHEMA IF NOT EXISTS productbd;
USE productbd;

CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `descricao` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  `quantidade` int NOT NULL,
  `categoria` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fornecedor` varchar(244) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `imagem` longblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;