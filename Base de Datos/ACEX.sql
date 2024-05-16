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
CREATE SCHEMA IF NOT EXISTS `acex` DEFAULT CHARACTER SET utf8mb4 ;
USE `acex` ;

-- -----------------------------------------------------
-- Table `acex`.`departamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`departamento` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_jefe` INT(10) UNSIGNED NULL DEFAULT NULL,
  `codigo` CHAR(3) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo`),
  INDEX `fk_departamento_profesor_idx` (`id_jefe`),
  CONSTRAINT `fk_departamento_profesor`
    FOREIGN KEY (`id_jefe`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_departamento` INT(10) UNSIGNED NOT NULL,
  `dni` CHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL DEFAULT 'password',
  `perfil` ENUM('SUPERUSUARIO', 'ADMINISTRADOR', 'GRUPO DIRECTIVO', 'PROFESOR') NOT NULL DEFAULT 'PROFESOR',
  `activo` TINYINT(4) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `dni_UNIQUE` (`dni`),
  UNIQUE INDEX `email_UNIQUE` (`email`),
  INDEX `fk_profesor_departamento_idx` (`id_departamento`),
  CONSTRAINT `fk_profesor_departamento`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `acex`.`departamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 247
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`actividad_solicitada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`actividad_solicitada` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_solicitante` INT(10) UNSIGNED NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `comentario_actividad` VARCHAR(100) NULL DEFAULT NULL,
  `tipo` ENUM('EXTRAESCOLAR', 'COMPLEMENTARIA') NOT NULL,
  `prevista` TINYINT(4) NOT NULL,
  `estado` ENUM('SOLICITADA', 'ACEPTADA', 'DENEGADA', 'REALIZADA') NOT NULL,
  `comentario_estado` VARCHAR(100) NULL DEFAULT NULL,
  `transporte` TINYINT(4) NOT NULL,
  `alojamiento` TINYINT(4) NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_actividad_solicitada_profesor_idx` (`id_solicitante`),
  CONSTRAINT `fk_actividad_solicitada_profesor`
    FOREIGN KEY (`id_solicitante`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`actividad_aprobada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`actividad_aprobada` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_solicitante` INT(11) NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `comentario_actividad` VARCHAR(100) NULL DEFAULT NULL,
  `tipo` ENUM('EXTRAESCOLAR', 'COMPLEMENTARIA') NOT NULL,
  `prevista` TINYINT(4) NOT NULL,
  `estado` ENUM('SOLICITADA', 'ACEPTADA', 'DENEGADA', 'REALIZADA') NOT NULL,
  `comentario_estado` VARCHAR(100) NULL DEFAULT NULL,
  `transporte` TINYINT(4) NOT NULL,
  `alojamiento` TINYINT(4) NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  `fecha_inicio` DATE NULL DEFAULT NULL,
  `fecha_fin` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_actividad_aprobada_actividad_solicitada_idx` (`id`),
  CONSTRAINT `fk_actividad_aprobada_actividad_solicitada`
    FOREIGN KEY (`id`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`alojamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`alojamiento` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `comentario` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`alojamiento_utilizado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`alojamiento_utilizado` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_actividad` INT(10) UNSIGNED NOT NULL,
  `id_alojamiento` INT(10) UNSIGNED NOT NULL,
  `importe` DECIMAL(6,2) NOT NULL DEFAULT 0.00,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_alojamiento_utilizado_actividad_solicitada_idx` (`id_actividad`),
  INDEX `fk_alojamiento_utilizado_alojamiento_idx` (`id_alojamiento`),
  CONSTRAINT `fk_alojamiento_utilizado_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alojamiento_utilizado_alojamiento`
    FOREIGN KEY (`id_alojamiento`)
    REFERENCES `acex`.`alojamiento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `codigo` CHAR(5) NOT NULL,
  `etapa` ENUM('ESO', 'BACHILLERATO', 'FPB', 'FPGM', 'FPGS', 'FPCE') NOT NULL,
  `activo` TINYINT(4) NOT NULL DEFAULT 0,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`curso_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`curso_participante` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_curso` INT(10) UNSIGNED NOT NULL,
  `id_actividad` INT(10) UNSIGNED NOT NULL,
  `num_alumnos` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_curso_participante_curso_idx` (`id_curso`),
  INDEX `fk_curso_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_curso_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_participante_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `acex`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`grupo` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_curso` INT(10) UNSIGNED NOT NULL,
  `codigo` CHAR(8) NOT NULL,
  `activo` TINYINT(4) NOT NULL,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo`),
  INDEX `fk_grupo_curso_idx` (`id_curso`),
  CONSTRAINT `fk_grupo_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `acex`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`grupo_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`grupo_participante` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_grupo` INT(10) UNSIGNED NOT NULL,
  `id_actividad` INT(10) UNSIGNED NOT NULL,
  `num_alumnos` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_grupo_participante_grupo_idx` (`id_grupo`),
  INDEX `fk_grupo_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_grupo_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_participante_grupo`
    FOREIGN KEY (`id_grupo`)
    REFERENCES `acex`.`grupo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`imagen`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`imagen` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_actividad` INT(10) UNSIGNED NOT NULL,
  `url` VARCHAR(100) NOT NULL,
  `descripcion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_imagen_actividad_aprobada_idx` (`id_actividad`),
  CONSTRAINT `fk_imagen_actividad_aprobada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_aprobada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`profesor_participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor_participante` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_profesor` INT(10) UNSIGNED NOT NULL,
  `id_actividad` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_profesor_participante_profesor_idx` (`id_profesor`),
  INDEX `fk_profesor_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_profesor_participante_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesor_participante_profesor`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`profesor_responsable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`profesor_responsable` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_profesor` INT(10) UNSIGNED NOT NULL,
  `id_actividad` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_profesor_responsable_profesor_idx` (`id_profesor`),
  INDEX `fk_profesor_responsable_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_profesor_responsable_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profesor_responsable_profesor`
    FOREIGN KEY (`id_profesor`)
    REFERENCES `acex`.`profesor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`transporte`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`transporte` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `acex`.`transporte_utilizado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `acex`.`transporte_utilizado` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_actividad` INT(10) UNSIGNED NOT NULL,
  `id_transporte` INT(10) UNSIGNED NOT NULL,
  `importe` DECIMAL(6,2) NOT NULL DEFAULT 0.00,
  `comentario` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id`),
  INDEX `fk_transporte_utilizado_actividad_solicitada_idx` (`id_actividad`),
  INDEX `fk_transporte_utilizado_transporte_idx` (`id_transporte`),
  CONSTRAINT `fk_transporte_utilizado_actividad_solicitada`
    FOREIGN KEY (`id_actividad`)
    REFERENCES `acex`.`actividad_solicitada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transporte_utilizado_transporte`
    FOREIGN KEY (`id_transporte`)
    REFERENCES `acex`.`transporte` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

USE `acex`;

DELIMITER $$
USE `acex`$$
CREATE
DEFINER=``@``
TRIGGER `acex`.`trigger_update`
AFTER UPDATE ON `acex`.`actividad_solicitada`
FOR EACH ROW
BEGIN

if(old.estado = 'SOLICITADA' and new.estado = 'APROBADA') then

INSERT INTO acex.actividad_aprobada(id, id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, hora_inicio, hora_fin, fecha_inicio, fecha_fin)
VALUES(new.id, new.id_solicitante,new.titulo,new.comentario_actividad, new.tipo, new.prevista, new.estado, new.comentario_estado, new.transporte, new.alojamiento, new.hora_inicio, new.hora_fin, new.fecha_inicio, new.fecha_fin);

END IF;

if(old.estado = 'APROBADA') then
update acex.actividad_aprobada set 
    acex.actividad_aprobada.titulo = new.titulo,
    acex.actividad_aprobada.comentario_actividad = new.comentario_actividad,
    acex.actividad_aprobada.tipo = new.tipo,
    acex.actividad_aprobada.prevista = new.prevista,
    acex.actividad_aprobada.estado = new.estado,
    acex.actividad_aprobada.comentario_estado = new.comentario_estado,
    acex.actividad_aprobada.transporte = new.transporte,
    acex.actividad_aprobada.alojamiento = new.alojamiento,
    acex.actividad_aprobada.hora_inicio = new.hora_inicio,
    acex.actividad_aprobada.hora_fin = new.hora_fin,
    acex.actividad_aprobada.fecha_inicio = new.fecha_inicio,
    acex.actividad_aprobada.fecha_fin = new.fecha_fin
    where acex.actividad_aprobada.id = new.id;
END IF;

END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
