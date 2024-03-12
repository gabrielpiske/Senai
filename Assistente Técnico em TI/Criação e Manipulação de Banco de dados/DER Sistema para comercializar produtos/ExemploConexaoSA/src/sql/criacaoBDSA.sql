-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema divulgacaoSA
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema divulgacaoSA
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `divulgacaoSA` DEFAULT CHARACTER SET utf8 COLLATE utf8_swedish_ci ;
USE `divulgacaoSA` ;

-- -----------------------------------------------------
-- Table `divulgacaoSA`.`Divulgador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `divulgacaoSA`.`Divulgador` (
  `idDivulgador` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(16) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `nivel` INT NOT NULL,
  PRIMARY KEY (`idDivulgador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `divulgacaoSA`.`Anuncio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `divulgacaoSA`.`Anuncio` (
  `idAnuncio` INT NOT NULL AUTO_INCREMENT,
  `data` DATE NOT NULL,
  `produto` VARCHAR(45) NOT NULL,
  `descricao` TEXT NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  `data_ultimo_status` DATE NOT NULL,
  `Divulgador_idDivulgador` INT NOT NULL,
  PRIMARY KEY (`idAnuncio`),
CONSTRAINT `fk_Anuncio_Divulgador1`
    FOREIGN KEY (`Divulgador_idDivulgador`)
    REFERENCES `divulgacaoSA`.`Divulgador` (`idDivulgador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `divulgacaoSA`.`Imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `divulgacaoSA`.`Imagem` (
  `idImagem` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `Anuncio_idAnuncio` INT NOT NULL,
  PRIMARY KEY (`idImagem`),
  CONSTRAINT `fk_Imagem_Anuncio1`
    FOREIGN KEY (`Anuncio_idAnuncio`)
    REFERENCES `divulgacaoSA`.`Anuncio` (`idAnuncio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT * FROM DIVULGADOR;