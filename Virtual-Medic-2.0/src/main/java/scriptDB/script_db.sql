-- DROP DATABASE virtualmedic_db;

CREATE DATABASE IF NOT EXISTS virtualmedic_db;

USE virtualmedic_db;

CREATE TABLE IF NOT EXISTS `pacientes` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf`)
);

CREATE TABLE IF NOT EXISTS `medicos` (
  `crm` VARCHAR(10) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `especificacao` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `estado` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`crm`)
);

CREATE TABLE IF NOT EXISTS `planoSaude` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`)
);

