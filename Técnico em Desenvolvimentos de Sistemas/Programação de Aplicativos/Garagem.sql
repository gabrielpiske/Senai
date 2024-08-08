CREATE SCHEMA `garagem` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `garagem`.`car` (
  `placa` CHAR(7) NOT NULL,
  PRIMARY KEY (`placa`),
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC) VISIBLE)
COMMENT = 'Essa tabela armazena dados de veículos';

ALTER TABLE `garagem`.`car` 
ADD COLUMN `fabricante` INT NOT NULL AFTER `placa`;

CREATE TABLE `garagem`.`manufactory` (
    `codigo` INT NOT NULL AUTO_INCREMENT,
    `fabricante` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`codigo`)
);

ALTER TABLE `garagem`.`car` 
ADD INDEX `fabricante_fk_idx` (`fabricante` ASC) ;
;
ALTER TABLE `garagem`.`car` 
ADD CONSTRAINT `fabricante_fk`
  FOREIGN KEY (`fabricante`)
  REFERENCES `garagem`.`manufactory` (`codigo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Honda');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Chevrolet');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Fiat');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Renault');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Chery');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Kia');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('VM');
INSERT INTO `garagem`.`manufactory` (`fabricante`) VALUES ('Hyundai');

INSERT INTO `garagem`.`car` (`placa`, `fabricante`) VALUES ('GPY 1B77', '4');
