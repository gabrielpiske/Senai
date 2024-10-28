CREATE DATABASE dbproduto;
USE dbProduto;

CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `preco` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `pedido` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_Pedido` date NOT NULL,
  `id_Produto` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_idPedido_fk` (`id_Produto`),
  CONSTRAINT `produto_idPedido_fk` FOREIGN KEY (`id_Produto`) REFERENCES `produto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;