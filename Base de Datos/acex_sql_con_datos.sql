CREATE DATABASE  IF NOT EXISTS `acex` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `acex`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: acex
-- ------------------------------------------------------
-- Server version	8.4.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad_aprobada`
--

DROP TABLE IF EXISTS `actividad_aprobada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad_aprobada` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_solicitante` int NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `comentario_actividad` text,
  `tipo` enum('EXTRAESCOLAR','COMPLEMENTARIA') NOT NULL,
  `prevista` tinyint NOT NULL,
  `estado` enum('SOLICITADA','ACEPTADA','DENEGADA','REALIZADA') NOT NULL,
  `comentario_estado` text,
  `transporte` tinyint NOT NULL,
  `alojamiento` tinyint NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_actividad_aprobada_actividad_solicitada_idx` (`id`),
  CONSTRAINT `fk_actividad_aprobada_actividad_solicitada` FOREIGN KEY (`id`) REFERENCES `actividad_solicitada` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_aprobada`
--

LOCK TABLES `actividad_aprobada` WRITE;
/*!40000 ALTER TABLE `actividad_aprobada` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad_aprobada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad_solicitada`
--

DROP TABLE IF EXISTS `actividad_solicitada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad_solicitada` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_solicitante` int unsigned NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `comentario_actividad` text,
  `tipo` enum('EXTRAESCOLAR','COMPLEMENTARIA') NOT NULL,
  `prevista` tinyint NOT NULL,
  `estado` enum('SOLICITADA','ACEPTADA','DENEGADA','REALIZADA') NOT NULL,
  `comentario_estado` text,
  `transporte` tinyint NOT NULL,
  `alojamiento` tinyint NOT NULL,
  `hora_inicio` time NOT NULL,
  `hora_fin` time NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_actividad_solicitada_profesor_idx` (`id_solicitante`),
  CONSTRAINT `fk_actividad_solicitada_profesor` FOREIGN KEY (`id_solicitante`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_solicitada`
--

LOCK TABLES `actividad_solicitada` WRITE;
/*!40000 ALTER TABLE `actividad_solicitada` DISABLE KEYS */;
INSERT INTO `actividad_solicitada` VALUES (2,1,'Viaje a Madrid','Viaje a Madrid, fin de curso.','EXTRAESCOLAR',1,'SOLICITADA',NULL,1,1,'09:00:00','20:00:00','2024-06-01','2024-06-30');
/*!40000 ALTER TABLE `actividad_solicitada` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_update` AFTER UPDATE ON `actividad_solicitada` FOR EACH ROW BEGIN

if(old.estado = 'SOLICITADA' and new.estado = 'ACEPTADA') then

INSERT INTO acex.actividad_aprobada(id, id_solicitante, titulo, comentario_actividad, tipo, prevista, estado, comentario_estado, transporte, alojamiento, hora_inicio, hora_fin, fecha_inicio, fecha_fin)
VALUES(new.id, new.id_solicitante,new.titulo,new.comentario_actividad, new.tipo, new.prevista, new.estado, new.comentario_estado, new.transporte, new.alojamiento, new.hora_inicio, new.hora_fin, new.fecha_inicio, new.fecha_fin);

END IF;

if(old.estado = 'ACEPTADA') then
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

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `alojamiento`
--

DROP TABLE IF EXISTS `alojamiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alojamiento` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamiento`
--

LOCK TABLES `alojamiento` WRITE;
/*!40000 ALTER TABLE `alojamiento` DISABLE KEYS */;
INSERT INTO `alojamiento` VALUES (1,'Hotel Madrid');
/*!40000 ALTER TABLE `alojamiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alojamiento_utilizado`
--

DROP TABLE IF EXISTS `alojamiento_utilizado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alojamiento_utilizado` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_alojamiento` int unsigned NOT NULL,
  `id_actividad` int unsigned NOT NULL,
  `importe` decimal(6,2) NOT NULL,
  `comentario` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_alojamiento_utilizado_actividad_solicitada_idx` (`id_actividad`),
  KEY `fk_alojamiento_utilizado_alojamiento_idx` (`id_alojamiento`),
  CONSTRAINT `fk_alojamiento_utilizado_actividad_solicitada` FOREIGN KEY (`id_actividad`) REFERENCES `actividad_solicitada` (`id`),
  CONSTRAINT `fk_alojamiento_utilizado_alojamiento` FOREIGN KEY (`id_alojamiento`) REFERENCES `alojamiento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamiento_utilizado`
--

LOCK TABLES `alojamiento_utilizado` WRITE;
/*!40000 ALTER TABLE `alojamiento_utilizado` DISABLE KEYS */;
INSERT INTO `alojamiento_utilizado` VALUES (1,1,2,50.00,NULL);
/*!40000 ALTER TABLE `alojamiento_utilizado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `codigo` char(5) NOT NULL,
  `etapa` enum('ESO','BACHILLERATO','FPB','FPGM','FPGS','FPCE') NOT NULL,
  `descripcion` text,
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'ESO1','ESO','Educación Secundaria Obligatoria - 1º',1),(2,'ESO2','ESO','Educación Secundaria Obligatoria - 2º',1),(3,'ESO3','ESO','Educación Secundaria Obligatoria - 3º',1),(4,'ESO4','ESO','Educación Secundaria Obligatoria - 4º',1),(5,'BCH1','BACHILLERATO','Bachillerato 1º',1),(6,'BCH2','BACHILLERATO','Bachillerato 2º',1),(7,'FM1','FPGM','Fabricación y montaje - 1º',1),(8,'FM2','FPGM','Fabricación y montaje - 2º',1),(9,'MV1','FPGM','Mantenimiento de Vehículos - 1º',1),(10,'MV2','FPGM','Mantenimiento de Vehículos - 2º',1),(11,'CAR1','FPGM','Carrocería - 1º',1),(12,'CAR2','FPGM','Carrocería - 2º',1),(13,'EVA1','FPGM','Electromecánica de Vehículos Automóviles - 1º',1),(14,'EVA2','FPGM','Electromecánica de Vehículos Automóviles - 2º',1),(15,'SMR1','FPGM','Sistemas Microinformáticos y Redes - 1º',1),(16,'SMR2','FPGM','Sistemas Microinformáticos y Redes - 2º',1),(17,'AF1','FPGS','Administración y Finanzas - 1º',1),(18,'AF2','FPGS','Administración y Finanzas - 2º',1),(19,'DAM1','FPGS','Desarrollo de Aplicaciones Multiplataforma - 1º',1),(20,'DAM2','FPGS','Desarrollo de Aplicaciones Multiplataforma - 2º',1),(21,'DAW1','FPGS','Desarrollo de Aplicaciones Web - 1º',1),(22,'DAW2','FPGS','Desarrollo de Aplicaciones Web - 2º',1),(23,'DFM1','FPGS','Diseño en Fabricación Mecánica - 1º',1),(24,'DFM2','FPGS','Diseño en Fabricación Mecánica - 2º',1);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso_participante`
--

DROP TABLE IF EXISTS `curso_participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_participante` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_curso` int unsigned NOT NULL,
  `id_actividad` int unsigned NOT NULL,
  `num_alumnos` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_curso_participante_curso_idx` (`id_curso`),
  KEY `fk_curso_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_curso_participante_actividad_solicitada` FOREIGN KEY (`id_actividad`) REFERENCES `actividad_solicitada` (`id`),
  CONSTRAINT `fk_curso_participante_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_participante`
--

LOCK TABLES `curso_participante` WRITE;
/*!40000 ALTER TABLE `curso_participante` DISABLE KEYS */;
INSERT INTO `curso_participante` VALUES (1,6,2,42);
/*!40000 ALTER TABLE `curso_participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_jefe` int unsigned DEFAULT NULL,
  `codigo` char(3) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_departamento_profesor_idx` (`id_jefe`),
  CONSTRAINT `fk_departamento_profesor` FOREIGN KEY (`id_jefe`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,NULL,'BG','Biología y Geología'),(2,NULL,'DIB','Dibujo'),(3,NULL,'ECO','Economía'),(4,NULL,'EF','Educación Física'),(5,NULL,'FIL','Filosofía'),(6,NULL,'FQ','Física y Química'),(7,NULL,'FRA','Francés'),(8,NULL,'GH','Geografía e Historia'),(9,NULL,'ING','Inglés'),(10,NULL,'LAT','Latín'),(11,NULL,'LEN','Lengua Castellana y Literatura'),(12,NULL,'MAT','Matemáticas'),(13,NULL,'MUS','Música'),(14,NULL,'TEC','Tecnología'),(15,NULL,'AG','Administración y Gestión'),(16,NULL,'FOL','Formación y Orientación Laboral'),(17,NULL,'INF','Informática y Comunicaciones'),(18,NULL,'FM','Fabricación Mecánica'),(19,NULL,'TMV','Transporte y Mantenimiento de Vehículos');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_curso` int unsigned NOT NULL,
  `codigo` char(8) NOT NULL,
  `num_alumnos` int NOT NULL,
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `fk_grupo_curso_idx` (`id_curso`),
  CONSTRAINT `fk_grupo_curso` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,1,'ESO1A',22,1),(2,1,'ESO1B',21,1),(3,1,'ESO1C',20,1),(4,1,'ESO1D',22,1),(5,2,'ESO2A',19,1),(6,2,'ESO2B',21,1),(7,2,'ESO2C',20,1),(8,2,'ESO2D',19,1),(9,3,'ESO3A',25,1),(10,3,'ESO3B',24,1),(11,3,'ESO3C',25,1),(12,4,'ESO4A',19,1),(13,4,'ESO4B',18,1),(14,4,'ESO4C',18,1),(15,4,'ESO4D',17,1),(16,5,'BCH1HCS',21,1),(17,5,'BCH1CT',22,1),(18,6,'BCH2HCS',20,1),(19,6,'BDH2CT',19,1),(20,7,'FM1',24,1),(21,8,'FM2',18,1),(22,9,'MV1',25,1),(23,10,'MV2',15,1),(24,11,'CAR1',25,1),(25,12,'CAR2',16,1),(26,13,'EVA1',24,1),(27,14,'EVA2',14,1),(28,15,'SMR1',28,1),(29,16,'SMR2',19,1),(30,17,'AF1',24,1),(31,18,'AF2',25,1),(32,19,'DAM1',28,1),(33,20,'DAM2',35,1),(34,21,'DAW1',24,1),(35,22,'DAW2',18,1),(36,23,'DFM1',16,1),(37,24,'DFM2',9,1);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_participante`
--

DROP TABLE IF EXISTS `grupo_participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo_participante` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_grupo` int unsigned NOT NULL,
  `id_actividad` int unsigned NOT NULL,
  `num_alumnos` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_grupo_participante_grupo_idx` (`id_grupo`),
  KEY `fk_grupo_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_grupo_participante_actividad_solicitada` FOREIGN KEY (`id_actividad`) REFERENCES `actividad_solicitada` (`id`),
  CONSTRAINT `fk_grupo_participante_grupo` FOREIGN KEY (`id_grupo`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_participante`
--

LOCK TABLES `grupo_participante` WRITE;
/*!40000 ALTER TABLE `grupo_participante` DISABLE KEYS */;
INSERT INTO `grupo_participante` VALUES (1,18,2,20),(2,19,2,22);
/*!40000 ALTER TABLE `grupo_participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagen`
--

DROP TABLE IF EXISTS `imagen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imagen` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_actividad` int unsigned NOT NULL,
  `url` text NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_imagen_actividad_aprobada_idx` (`id_actividad`),
  CONSTRAINT `fk_imagen_actividad_aprobada` FOREIGN KEY (`id_actividad`) REFERENCES `actividad_aprobada` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagen`
--

LOCK TABLES `imagen` WRITE;
/*!40000 ALTER TABLE `imagen` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_departamento` int unsigned NOT NULL,
  `dni` char(9) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` text NOT NULL,
  `perfil` enum('PROFESOR','GRUPO_DIRECTIVO','ADMINISTRADOR','SUPERUSUARIO') NOT NULL DEFAULT 'PROFESOR',
  `activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_profesor_departamento_idx` (`id_departamento`),
  CONSTRAINT `fk_profesor_departamento` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=247 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,17,'12345678A','Miguel','Gutiérrez Caso','superusuario@email.com','myPassword','SUPERUSUARIO',1);
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_participante`
--

DROP TABLE IF EXISTS `profesor_participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor_participante` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_profesor` int unsigned NOT NULL,
  `id_actividad` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_profesor_participante_profesor_idx` (`id_profesor`),
  KEY `fk_profesor_participante_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_profesor_participante_actividad_solicitada` FOREIGN KEY (`id_actividad`) REFERENCES `actividad_solicitada` (`id`),
  CONSTRAINT `fk_profesor_participante_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_participante`
--

LOCK TABLES `profesor_participante` WRITE;
/*!40000 ALTER TABLE `profesor_participante` DISABLE KEYS */;
INSERT INTO `profesor_participante` VALUES (1,1,2);
/*!40000 ALTER TABLE `profesor_participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor_responsable`
--

DROP TABLE IF EXISTS `profesor_responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor_responsable` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_profesor` int unsigned NOT NULL,
  `id_actividad` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_profesor_responsable_profesor_idx` (`id_profesor`),
  KEY `fk_profesor_responsable_actividad_solicitada_idx` (`id_actividad`),
  CONSTRAINT `fk_profesor_responsable_actividad_solicitada` FOREIGN KEY (`id_actividad`) REFERENCES `actividad_solicitada` (`id`),
  CONSTRAINT `fk_profesor_responsable_profesor` FOREIGN KEY (`id_profesor`) REFERENCES `profesor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor_responsable`
--

LOCK TABLES `profesor_responsable` WRITE;
/*!40000 ALTER TABLE `profesor_responsable` DISABLE KEYS */;
INSERT INTO `profesor_responsable` VALUES (1,1,2);
/*!40000 ALTER TABLE `profesor_responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transporte`
--

DROP TABLE IF EXISTS `transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transporte` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte`
--

LOCK TABLES `transporte` WRITE;
/*!40000 ALTER TABLE `transporte` DISABLE KEYS */;
INSERT INTO `transporte` VALUES (1,'Caminando'),(2,'Bicicleta'),(3,'Autobús'),(4,'Taxi'),(5,'Tren'),(6,'Barco'),(7,'Avión');
/*!40000 ALTER TABLE `transporte` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transporte_utilizado`
--

DROP TABLE IF EXISTS `transporte_utilizado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transporte_utilizado` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `id_transporte` int unsigned NOT NULL,
  `id_actividad` int unsigned NOT NULL,
  `importe` decimal(6,2) NOT NULL,
  `comentario` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_transporte_utilizado_actividad_solicitada_idx` (`id_actividad`),
  KEY `fk_transporte_utilizado_transporte_idx` (`id_transporte`),
  CONSTRAINT `fk_transporte_utilizado_actividad_solicitada` FOREIGN KEY (`id_actividad`) REFERENCES `actividad_solicitada` (`id`),
  CONSTRAINT `fk_transporte_utilizado_transporte` FOREIGN KEY (`id_transporte`) REFERENCES `transporte` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte_utilizado`
--

LOCK TABLES `transporte_utilizado` WRITE;
/*!40000 ALTER TABLE `transporte_utilizado` DISABLE KEYS */;
INSERT INTO `transporte_utilizado` VALUES (1,5,2,40.00,'Torrelavega - Chamartín'),(2,5,2,35.00,'Chamartín-Torrelavega');
/*!40000 ALTER TABLE `transporte_utilizado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'acex'
--

--
-- Dumping routines for database 'acex'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-21 18:48:21
