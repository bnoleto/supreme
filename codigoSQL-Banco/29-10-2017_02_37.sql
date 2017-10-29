-- MySQL Script generated by MySQL Workbench
-- Sun Oct 29 02:18:31 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdsupreme2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdsupreme2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdsupreme2` DEFAULT CHARACTER SET utf8 ;
USE `bdsupreme2` ;

-- -----------------------------------------------------
-- Table `bdsupreme2`.`t_itens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdsupreme2`.`t_itens` (
  `itm_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `itm_nome` VARCHAR(100) NOT NULL,
  `itm_descricao` VARCHAR(200) NOT NULL,
  `itm_valor` DOUBLE UNSIGNED NOT NULL,
  `itm_status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`itm_codigo`),
  UNIQUE INDEX `itm_codigo_UNIQUE` (`itm_codigo` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdsupreme2`.`t_pedidos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdsupreme2`.`t_pedidos` (
  `ped_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `ped_valor` DOUBLE NOT NULL,
  `ped_status` VARCHAR(10) NOT NULL DEFAULT 'ABERTO',
  `ped_mesa` INT NOT NULL,
  PRIMARY KEY (`ped_codigo`),
  UNIQUE INDEX `ped_codigo_UNIQUE` (`ped_codigo` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdsupreme2`.`t_pedido_itens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdsupreme2`.`t_pedido_itens` (
  `itm_codigo` INT(10) UNSIGNED NOT NULL,
  `ped_codigo` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`itm_codigo`, `ped_codigo`),
  INDEX `fk_t_pedidos_has_t_itens_t_itens1_idx` (`ped_codigo` ASC),
  INDEX `fk_t_pedidos_has_t_itens_t_pedidos1_idx` (`itm_codigo` ASC),
  CONSTRAINT `fk_t_pedidos_has_t_itens_t_pedidos1`
    FOREIGN KEY (`itm_codigo`)
    REFERENCES `bdsupreme2`.`t_pedidos` (`ped_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_pedidos_has_t_itens_t_itens1`
    FOREIGN KEY (`ped_codigo`)
    REFERENCES `bdsupreme2`.`t_itens` (`itm_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdsupreme2`.`t_contas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdsupreme2`.`t_contas` (
  `conta_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `conta_valor` DOUBLE UNSIGNED NOT NULL,
  `conta_mesa` INT UNSIGNED NOT NULL,
  `conta_status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`conta_codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdsupreme2`.`t_pedidos_contas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdsupreme2`.`t_pedidos_contas` (
  `t_pedidos_ped_codigo` INT(10) UNSIGNED NOT NULL,
  `t_contas_conta_codigo` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`t_pedidos_ped_codigo`, `t_contas_conta_codigo`),
  INDEX `fk_t_pedidos_has_t_contas_t_contas1_idx` (`t_contas_conta_codigo` ASC),
  INDEX `fk_t_pedidos_has_t_contas_t_pedidos1_idx` (`t_pedidos_ped_codigo` ASC),
  CONSTRAINT `fk_t_pedidos_has_t_contas_t_pedidos1`
    FOREIGN KEY (`t_pedidos_ped_codigo`)
    REFERENCES `bdsupreme2`.`t_pedidos` (`ped_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_pedidos_has_t_contas_t_contas1`
    FOREIGN KEY (`t_contas_conta_codigo`)
    REFERENCES `bdsupreme2`.`t_contas` (`conta_codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdsupreme2`.`t_pessoas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdsupreme2`.`t_pessoas` (
  `pes_codigo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `pes_nome` VARCHAR(100) NOT NULL,
  `pes_cpf` VARCHAR(11) NOT NULL,
  `pes_login` VARCHAR(100) NOT NULL,
  `pes_senha` VARCHAR(100) NOT NULL,
  `pes_tipo` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`pes_codigo`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
