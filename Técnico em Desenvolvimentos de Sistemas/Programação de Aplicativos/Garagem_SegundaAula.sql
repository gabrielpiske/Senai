CREATE SCHEMA `garagem` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `car` (
  `placa` char(7) COLLATE utf8_unicode_ci NOT NULL,
  `fabricante` int(11) NOT NULL,
  `ano` int(2) NOT NULL,
  `cor` int(2) NOT NULL,
  `modelo` int(2) NOT NULL,
  PRIMARY KEY (`placa`),
  UNIQUE KEY `placa_UNIQUE` (`placa`),
  KEY `fabricante_fk_idx` (`fabricante`),
  KEY `ano_fk_idx` (`ano`),
  KEY `cor_fk_idx` (`cor`),
  KEY `modelo_fk_idx` (`modelo`),
  CONSTRAINT `ano_fk` FOREIGN KEY (`ano`) REFERENCES `ano` (`id_ano`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `cor_fk` FOREIGN KEY (`cor`) REFERENCES `cor` (`id_cor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fabricante_fk` FOREIGN KEY (`fabricante`) REFERENCES `manufactory` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `modelo_fk` FOREIGN KEY (`modelo`) REFERENCES `manufactory` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='Essa tabela armazena dados de veículos';

CREATE TABLE `manufactory` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `modelo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
  
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Honda');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Chevrolet');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Fiat');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Renault');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Chery');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Kia');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('VM');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Hyundai');

INSERT INTO `garagem`.`car` (`placa`, `fabricante`) VALUES ('GPY 1B77', '4');

## Segunda Aula - Criação de Relações

CREATE TABLE `ano` (
  `id_ano` int(11) NOT NULL AUTO_INCREMENT,
  `ano` int(4) NOT NULL,
  PRIMARY KEY (`id_ano`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2021');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2022');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2023');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2024');
INSERT INTO `garagem`.`ano` (`ano`) VALUES ('2025');

CREATE TABLE `cor` (
  `id_cor` int(11) NOT NULL AUTO_INCREMENT,
  `cor` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_cor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `garagem`.`cor` (`cor`) VALUES ('branco');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('azul');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('amarelo');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('verde');
INSERT INTO `garagem`.`cor` (`cor`) VALUES ('vermelho');


UPDATE `garagem`.`manufactory` SET `modelo` = 'civic' WHERE (`codigo` = '1');
UPDATE `garagem`.`manufactory` SET `modelo` = 'punto' WHERE (`codigo` = '3');
UPDATE `garagem`.`manufactory` SET `modelo` = 'logan' WHERE (`codigo` = '4');
UPDATE `garagem`.`manufactory` SET `modelo` = 'cerrato' WHERE (`codigo` = '6');
UPDATE `garagem`.`manufactory` SET `modelo` = 'i30' WHERE (`codigo` = '8');
UPDATE `garagem`.`manufactory` SET `modelo` = 'golf' WHERE (`codigo` = '7');
UPDATE `garagem`.`manufactory` SET `modelo` = 'astra' WHERE (`codigo` = '2');
UPDATE `garagem`.`manufactory` SET `modelo` = 'tiggo' WHERE (`codigo` = '5');
