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
  `id_jefe` INT UNSIGNED NULL DEFAULT NULL,
  `codigo` CHAR(3) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo`),
  INDEX `fk_departamento_profesor_idx` (`id_jefe`),
  CONSTRAINT `fk_departamento_profesor`
    FOREIGN KEY (`id_jefe`)
    REFERENCES `acex`.`profesor` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
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
  `perfil` ENUM('PROFESOR', 'GRUPO_DIRECTIVO', 'ADMINISTRADOR', 'SUPERUSUARIO') NOT NULL DEFAULT 'PROFESOR',
  `activo` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni`),
  UNIQUE INDEX `email_UNIQUE` (`email`),
  INDEX `fk_profesor_departamento_idx` (`id_departamento`),
  CONSTRAINT `fk_profesor_departamento`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `acex`.`departamento` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 247
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
  `tipo` ENUM('EXTRAESCOLAR', 'COMPLEMENTARIA') NOT NULL,
  `prevista` TINYINT NOT NULL,
  `estado` ENUM('SOLICITADA', 'ACEPTADA', 'DENEGADA', 'REALIZADA') NOT NULL,
  `comentario_estado` TEXT NULL DEFAULT NULL,
  `transporte` TINYINT NOT NULL,
  `alojamiento` TINYINT NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_actividad_solicitada_profesor_idx` (`id_solicitante`),
  CONSTRAINT `fk_actividad_solicitada_profesor`
    FOREIGN KEY (`id_solicitante`)
    REFERENCES `acex`.`profesor` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
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
  `tipo` ENUM('EXTRAESCOLAR', 'COMPLEMENTARIA') NOT NULL,
  `prevista` TINYINT NOT NULL,
  `estado` ENUM('SOLICITADA', 'ACEPTADA', 'DENEGADA', 'REALIZADA') NOT NULL,
  `comentario_estado` TEXT NULL DEFAULT NULL,
  `transporte` TINYINT NOT NULL,
  `alojamiento` TINYINT NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  `fecha_inicio` DATE NULL DEFAULT NULL,
  `fecha_fin` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_actividad_aprobada_actividad_solicitada_idx` (`id`),
  CONSTRAINT `fk_actividad_aprobada_actividad_solicitada`
    FOREIGN KEY (`id`)
    REFERENCES `acex`.`actividad_solicitada` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`alojamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`alojamiento` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`alojamiento_utilizado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`alojamiento_utilizado` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_alojamiento` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  `importe` DECIMAL(6,2) NOT NULL,
  `comentario` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_alojamiento_utilizado_actividad_solicitada_idx` (`id_actividad`),
  INDEX `fk_alojamiento_utilizado_alojamiento_idx` (`id_alojamiento`),
  CONSTRAINT `fk_alojamiento_utilizado_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`),
  CONSTRAINT `fk_alojamiento_utilizado_alojamiento`
    FOREIGN KEY (`id_alojamiento`)
    REFERENCES `acex`.`alojamiento` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `codigo` CHAR(5) NOT NULL,
  `etapa` ENUM('ESO', 'BACHILLERATO', 'FPB', 'FPGM', 'FPGS', 'FPCE') NOT NULL,
  `descripcion` TEXT NULL DEFAULT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`curso_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso_participante` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_curso` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  `num_alumnos` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_curso_participante_curso_idx` (`id_curso`),
  INDEX `fk_curso_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_curso_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`),
  CONSTRAINT `fk_curso_participante_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `acex`.`curso` (`id`))
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
  `num_alumnos` INT NOT NULL,
  `activo` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo`),
  INDEX `fk_grupo_curso_idx` (`id_curso`),
  CONSTRAINT `fk_grupo_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `acex`.`curso` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`grupo_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`grupo_participante` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_grupo` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  `num_alumnos` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_grupo_participante_grupo_idx` (`id_grupo`),
  INDEX `fk_grupo_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_grupo_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`),
  CONSTRAINT `fk_grupo_participante_grupo`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `acex`.`grupo` (`id`))
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
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_imagen_actividad_aprobada_idx` (`id_actividad`),
  CONSTRAINT `fk_imagen_actividad_aprobada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_aprobada` (`id`))
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
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_profesor_participante_profesor_idx` (`id_profesor`),
  INDEX `fk_profesor_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_profesor_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`),
  CONSTRAINT `fk_profesor_participante_profesor`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id`))
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
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_profesor_responsable_profesor_idx` (`id_profesor`),
  INDEX `fk_profesor_responsable_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_profesor_responsable_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`),
  CONSTRAINT `fk_profesor_responsable_profesor`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`transporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`transporte` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `acex`.`transporte_utilizado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`transporte_utilizado` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_transporte` INT UNSIGNED NOT NULL,
  `id_actividad` INT UNSIGNED NOT NULL,
  `importe` DECIMAL(6,2) NOT NULL,
  `comentario` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_transporte_utilizado_actividad_solicitada_idx` (`id_actividad`),
  INDEX `fk_transporte_utilizado_transporte_idx` (`id_transporte`),
  CONSTRAINT `fk_transporte_utilizado_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`),
  CONSTRAINT `fk_transporte_utilizado_transporte`
    FOREIGN KEY (`id_transporte`)
    REFERENCES `acex`.`transporte` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `acex`;

DELIMITER $$
USE `acex`$$
CREATE DEFINER=`root`@`localhost` TRIGGER `trigger_update` AFTER UPDATE ON `actividad_solicitada` FOR EACH ROW BEGIN

IF (old.estado = 'SOLICITADA' AND new.estado = 'ACEPTADA') THEN
    INSERT INTO acex.actividad_aprobada(id, id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, hora_inicio, hora_fin, fecha_inicio, fecha_fin)
    VALUES(new.id, new.id_solicitante,new.titulo,new.comentario_actividad, new.tipo, new.prevista, new.estado, new.comentario_estado, new.transporte, new.alojamiento, new.hora_inicio, new.hora_fin, new.fecha_inicio, new.fecha_fin);

ELSEIF (old.estado = 'ACEPTADA' AND new.estado = 'SOLICITADA') THEN
	DELETE FROM acex.actividad_aprobada WHERE id = old.id;

ELSE
    UPDATE acex.actividad_aprobada SET 
        titulo = new.titulo,
        comentario_actividad = new.comentario_actividad,
        tipo = new.tipo,
        prevista = new.prevista,
        estado = new.estado,
        comentario_estado = new.comentario_estado,
        transporte = new.transporte,
        alojamiento = new.alojamiento,
        hora_inicio = new.hora_inicio,
        hora_fin = new.hora_fin,
        fecha_inicio = new.fecha_inicio,
        fecha_fin = new.fecha_fin
    WHERE id = new.id;

END IF;

END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
