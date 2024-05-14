-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema acex
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema acex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `acex` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `acex` ;

-- -----------------------------------------------------
-- Table `acex`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`departamento` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_jefe` INT UNSIGNED NULL,
  `codigo` CHAR(3) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_departamento_profesor_idx` (`id_jefe` ASC) INVISIBLE,
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  CONSTRAINT `fk_departamento_profesor`
    FOREIGN KEY (`id_jefe`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_departamento` INT UNSIGNED NOT NULL,
  `dni` CHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` TEXT NOT NULL,
  `perfil` ENUM('Profesor', 'Grupo_Directivo', 'Administrador', 'Superusuario') NOT NULL DEFAULT 'Profesor',
  `activo` TINYINT NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_profesor_departamento_idx` (`id_departamento` ASC) VISIBLE,
  CONSTRAINT `fk_profesor_departamento`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `acex`.`departamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`actividad_solicitada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`actividad_solicitada` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_solicitante` INT UNSIGNED NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `comentario_actividad` TEXT NULL DEFAULT NULL,
  `tipo` ENUM('Extraescolar', 'Complementaria') NOT NULL,
  `prevista` TINYINT NOT NULL,
  `estado` ENUM('Solicitada', 'Aceptada', 'Denegada', 'Realizada') NOT NULL,
  `comentario_estado` TEXT NULL DEFAULT NULL,
  `transporte` TINYINT NOT NULL,
  `alojamiento` TINYINT NOT NULL,
  `inicio` DATETIME NOT NULL,
  `fin` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_actividad_solicitada_profesor_idx` (`id_solicitante` ASC) VISIBLE,
  CONSTRAINT `fk_actividad_solicitada_profesor`
    FOREIGN KEY (`id_solicitante`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`actividad_aprobada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`actividad_aprobada` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_solicitante` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `comentario_actividad` TEXT NULL DEFAULT NULL,
  `tipo` ENUM('Extraescolar', 'Complementaria') NOT NULL,
  `prevista` TINYINT NOT NULL,
  `estado` ENUM('Solicitada', 'Aceptada', 'Denegada', 'Realizada') NOT NULL,
  `comentario_estado` TEXT NULL DEFAULT NULL,
  `transporte` TINYINT NOT NULL,
  `alojamiento` TINYINT NOT NULL,
  `inicio` DATETIME NOT NULL,
  `fin` DATETIME NOT NULL,
  INDEX `fk_actividad_aprobada_actividad_solicitada_idx` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_actividad_aprobada_actividad_solicitada`
    FOREIGN KEY (`id`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`alojamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`alojamiento` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_actividad` INT UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `importe` DECIMAL(6,2) NOT NULL,
  `comentario` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_alojamiento_actividad_solicitada_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_alojamiento_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `codigo` CHAR(5) NOT NULL,
  `etapa` ENUM('ESO', 'Bachillerato', 'FPB', 'FPGM', 'FPGS', 'FPCE') NOT NULL,
  `num_alumnos` INT NULL DEFAULT NULL,
  `activo` TINYINT NOT NULL DEFAULT '1',
  `descripcion` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`curso_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso_participante` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_curso` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_curso_participante_curso_idx` (`id_curso` ASC) VISIBLE,
  INDEX `fk_curso_participante_actividad_solicitada_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_curso_participante_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `acex`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`grupo` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_curso` INT UNSIGNED NOT NULL,
  `codigo` CHAR(8) NOT NULL,
  `num_alumnos` INT NULL DEFAULT NULL,
  `activo` TINYINT NOT NULL DEFAULT '1',
  `descripcion` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_grupo_curso_idx` (`id_curso` ASC) VISIBLE,
  CONSTRAINT `fk_grupo_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `acex`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`grupo_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`grupo_participante` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_grupo` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_grupo_participante_grupo_idx` (`id_grupo` ASC) VISIBLE,
  INDEX `fk_grupo_participante_actividad_solicitada_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_grupo_participante_grupo`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `acex`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`imagen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`imagen` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_actividad` INT UNSIGNED NOT NULL,
  `url` TEXT NOT NULL,
  `descripcion` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_imagen_actividad_aprobada_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_imagen_actividad_aprobada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_aprobada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`profesor_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor_participante` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_profesor` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_profesor_participante_profesor_idx` (`id_profesor` ASC) VISIBLE,
  INDEX `fk_profesor_participante_actividad_solicitada_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_profesor_participante_profesor`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesor_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`profesor_responsable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor_responsable` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_profesor` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_profesor_responsable_profesor_idx` (`id_profesor` ASC) VISIBLE,
  INDEX `fk_profesor_responsable_actividad_solicitada_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_profesor_responsable_profesor`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesor_responsable_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`transporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`transporte` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_actividad` INT UNSIGNED NOT NULL,
  `tipo` ENUM('Caminando', 'Bicicleta', 'Autobus', 'Taxi', 'Tren', 'Barco', 'Avion') NOT NULL,
  `importe` DECIMAL(6,2) NOT NULL,
  `comentario` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_transporte_actividad_solicitada_idx` (`id_actividad` ASC) VISIBLE,
  CONSTRAINT `fk_transporte_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
