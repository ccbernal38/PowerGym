CREATE DATABASE  IF NOT EXISTS `powergym` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `powergym`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: powergym
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `asistencia`
--

DROP TABLE IF EXISTS `asistencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Socio_id` int(11) NOT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_Entrada_Socio1_idx` (`Socio_id`),
  CONSTRAINT `fk_Entrada_Socio1` FOREIGN KEY (`Socio_id`) REFERENCES `socio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
INSERT INTO `asistencia` VALUES (1,5,'2017-09-02 01:55:53','2017-09-02 01:55:53'),(2,5,'2017-09-02 01:55:53','2017-09-02 01:55:53'),(3,5,'2017-09-02 01:55:53','2017-09-02 01:55:53');
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caja`
--

DROP TABLE IF EXISTS `caja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `caja` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fechaApertura` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `fechaCierre` timestamp NULL DEFAULT NULL,
  `saldoInicial` int(11) DEFAULT NULL,
  `saldoFinal` int(11) DEFAULT NULL,
  `usuario_id_apertura` int(11) DEFAULT NULL,
  `usuario_id_cierre` int(11) DEFAULT NULL,
  `estado` int(1) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `totalEgresos` int(11) DEFAULT '0',
  `totalMembresias` int(11) DEFAULT '0',
  `totalVisitas` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_caja_usuario_idx` (`usuario_id_apertura`),
  KEY `fk_caja_usuario1_idx` (`usuario_id_cierre`),
  CONSTRAINT `fk_caja_usuario` FOREIGN KEY (`usuario_id_apertura`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_caja_usuario1` FOREIGN KEY (`usuario_id_cierre`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caja`
--

LOCK TABLES `caja` WRITE;
/*!40000 ALTER TABLE `caja` DISABLE KEYS */;
INSERT INTO `caja` VALUES (6,'2017-09-02 05:00:00','2017-09-02 05:00:00',0,0,1,1,0,'2017-09-02 11:13:19','2017-09-19 23:24:19',0,0,0),(13,'2017-09-14 05:00:00','2017-09-14 05:00:00',0,0,1,2,0,'2017-09-14 16:10:34','2017-09-19 23:24:19',0,0,0),(14,'2017-09-15 05:00:00','2017-09-15 05:00:00',0,0,1,1,0,'2017-09-15 11:15:07','2017-09-19 23:24:45',0,0,0),(16,'2017-09-19 22:33:52','2017-09-19 22:33:52',0,0,1,1,0,'2017-09-19 17:33:52','2017-09-19 23:24:35',0,0,0),(17,'2017-09-19 22:35:04','2017-09-19 22:35:04',0,0,1,1,0,'2017-09-19 17:35:04','2017-09-19 23:24:35',0,0,0),(18,'2017-09-19 22:36:09','2017-09-19 05:00:00',0,-30000,1,1,0,'2017-09-19 17:36:09','2017-09-19 23:24:02',130000,0,100000),(20,'2017-09-20 04:21:12','2017-09-19 05:00:00',0,0,1,1,0,'2017-09-19 23:21:12','2017-09-19 23:24:19',0,0,0),(21,'2017-09-20 04:22:12','2017-09-20 04:22:16',0,0,1,1,0,'2017-09-19 23:22:12','2017-09-19 23:24:19',0,0,0),(22,'2017-09-20 04:23:13','2017-09-20 04:23:18',0,0,1,1,0,'2017-09-19 23:23:13','2017-09-19 23:23:18',0,0,0),(23,'2017-09-20 04:45:31',NULL,0,NULL,1,NULL,1,'2017-09-19 23:45:31','2017-09-19 23:45:31',0,0,0),(24,'2017-09-20 05:01:33',NULL,0,NULL,1,NULL,1,'2017-09-20 00:01:33','2017-09-20 00:01:33',0,0,0);
/*!40000 ALTER TABLE `caja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diasemana`
--

DROP TABLE IF EXISTS `diasemana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diasemana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diasemana`
--

LOCK TABLES `diasemana` WRITE;
/*!40000 ALTER TABLE `diasemana` DISABLE KEYS */;
INSERT INTO `diasemana` VALUES (1,'Lunes'),(2,'Martes'),(3,'Miercoles'),(4,'Jueves'),(5,'Viernes'),(6,'Sabado'),(7,'Domingo');
/*!40000 ALTER TABLE `diasemana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `duracion`
--

DROP TABLE IF EXISTS `duracion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `duracion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `duracion`
--

LOCK TABLES `duracion` WRITE;
/*!40000 ALTER TABLE `duracion` DISABLE KEYS */;
INSERT INTO `duracion` VALUES (1,'DÃ­as'),(2,'Semanas'),(3,'Meses'),(4,'AÃ±os');
/*!40000 ALTER TABLE `duracion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paga` varchar(45) DEFAULT NULL,
  `socio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_factura_socio1_idx` (`socio_id`),
  CONSTRAINT `fk_factura_socio1` FOREIGN KEY (`socio_id`) REFERENCES `socio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `horaInicio` timestamp(1) NULL DEFAULT NULL,
  `horaFin` timestamp(1) NULL DEFAULT NULL,
  `Membresia_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Horario_Membresia1_idx` (`Membresia_id`),
  CONSTRAINT `fk_Horario_Membresia1` FOREIGN KEY (`Membresia_id`) REFERENCES `membresia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
INSERT INTO `horario` VALUES (1,'1970-01-01 05:00:00.0','1970-01-01 05:00:00.0',1),(2,'1970-01-01 05:00:00.0','1970-01-01 05:00:00.0',2),(3,'1970-01-01 05:00:00.0','1970-01-01 05:00:00.0',2),(4,'1970-01-01 05:00:00.0','1970-01-01 05:00:00.0',2),(5,'1970-01-01 05:00:00.0','1970-01-01 05:00:00.0',2);
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membresia`
--

DROP TABLE IF EXISTS `membresia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membresia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `duracion` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `visitasxdia` int(11) DEFAULT NULL,
  `duracion_id` int(11) NOT NULL,
  `renovar` tinyint(4) DEFAULT '0',
  `promocional` tinyint(4) DEFAULT '0',
  `estado` tinyint(4) DEFAULT '1',
  `fechaFinalizacion` datetime DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_membresia_duracion1_idx` (`duracion_id`),
  CONSTRAINT `fk_membresia_duracion1` FOREIGN KEY (`duracion_id`) REFERENCES `duracion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membresia`
--

LOCK TABLES `membresia` WRITE;
/*!40000 ALTER TABLE `membresia` DISABLE KEYS */;
INSERT INTO `membresia` VALUES (1,'Silver nuevo',30,20000,8,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 18:49:04','2017-09-15 16:37:27'),(2,'Plata',30,30000,5,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 18:52:59','2017-09-18 12:00:18'),(3,'Luneta',30,50000,3,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 18:57:19','2017-09-18 14:11:11'),(4,'Ã«lite',20,60000,1,1,0,0,1,NULL,'2017-09-14 19:21:43','2017-09-18 14:13:02'),(5,'Profesional',30,80000,7,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 21:30:30','2017-09-18 14:21:34');
/*!40000 ALTER TABLE `membresia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membresia_diasemana`
--

DROP TABLE IF EXISTS `membresia_diasemana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membresia_diasemana` (
  `Membresia_id` int(11) NOT NULL,
  `DiasSemana_id` int(11) NOT NULL,
  PRIMARY KEY (`Membresia_id`,`DiasSemana_id`),
  KEY `fk_Membresia_has_DiasSemana_DiasSemana1_idx` (`DiasSemana_id`),
  KEY `fk_Membresia_has_DiasSemana_Membresia1_idx` (`Membresia_id`),
  CONSTRAINT `fk_Membresia_has_DiasSemana_DiasSemana1` FOREIGN KEY (`DiasSemana_id`) REFERENCES `diasemana` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Membresia_has_DiasSemana_Membresia1` FOREIGN KEY (`Membresia_id`) REFERENCES `membresia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membresia_diasemana`
--

LOCK TABLES `membresia_diasemana` WRITE;
/*!40000 ALTER TABLE `membresia_diasemana` DISABLE KEYS */;
INSERT INTO `membresia_diasemana` VALUES (2,1),(2,2),(2,3),(4,1),(4,2),(4,3),(4,4),(4,5),(4,6),(4,7);
/*!40000 ALTER TABLE `membresia_diasemana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membresia_socio`
--

DROP TABLE IF EXISTS `membresia_socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membresia_socio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Socio_id` int(11) NOT NULL,
  `Membresia_id` int(11) NOT NULL,
  `Pago_id` int(11) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `activa` tinyint(4) DEFAULT NULL,
  `valor` int(100) DEFAULT '0',
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `descuento` int(11) DEFAULT '0',
  `caja_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Socio_has_Membresia_Membresia1_idx` (`Membresia_id`),
  KEY `fk_Socio_has_Membresia_Socio_idx` (`Socio_id`),
  KEY `fk_Socio_has_Membresia_Pago1_idx` (`Pago_id`),
  KEY `fk_membresia_socio_caja1_idx` (`caja_id`),
  CONSTRAINT `fk_Socio_has_Membresia_Membresia1` FOREIGN KEY (`Membresia_id`) REFERENCES `membresia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_has_Membresia_Pago1` FOREIGN KEY (`Pago_id`) REFERENCES `pago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_has_Membresia_Socio` FOREIGN KEY (`Socio_id`) REFERENCES `socio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_membresia_socio_caja1` FOREIGN KEY (`caja_id`) REFERENCES `caja` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membresia_socio`
--

LOCK TABLES `membresia_socio` WRITE;
/*!40000 ALTER TABLE `membresia_socio` DISABLE KEYS */;
INSERT INTO `membresia_socio` VALUES (3,4,1,NULL,'2017-09-15',NULL,1,28000,'2017-09-15 16:07:54','2017-09-15 16:11:23',0,0),(4,5,1,NULL,'2017-09-15',NULL,1,40000,'2017-08-15 16:11:57','2017-09-15 16:41:32',10000,0);
/*!40000 ALTER TABLE `membresia_socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimiento`
--

DROP TABLE IF EXISTS `movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movimiento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `concepto` varchar(45) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `caja_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Movimiento_caja1_idx` (`caja_id`),
  CONSTRAINT `fk_Movimiento_caja1` FOREIGN KEY (`caja_id`) REFERENCES `caja` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimiento`
--

LOCK TABLES `movimiento` WRITE;
/*!40000 ALTER TABLE `movimiento` DISABLE KEYS */;
INSERT INTO `movimiento` VALUES (1,'Pago a proveedores	',15000,1,'2017-09-02 11:47:25','2017-09-02 11:47:25',6),(2,'Pago prueba	',10000,0,'2017-09-02 11:48:43','2017-09-02 11:48:43',6),(3,'Proveedor	',10000,0,'2017-09-14 16:17:16','2017-09-14 16:17:16',13),(6,'pago a proveedores	',120000,1,'2017-09-14 18:24:19','2017-09-14 18:24:19',13),(7,'Almuerzo		',1000000,1,'2017-09-14 21:43:25','2017-09-14 21:43:25',13),(8,'Pago a proveedores',50000,1,'2017-09-19 20:26:29','2017-09-19 20:26:29',18),(9,'Pago a provee',80000,1,'2017-09-19 20:29:02','2017-09-19 20:29:02',18);
/*!40000 ALTER TABLE `movimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` int(11) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
INSERT INTO `permiso` VALUES (1,'Creacion de socios','2017-09-02 09:32:52','2017-09-12 20:53:46'),(2,'Creacion de membresias','2017-09-02 09:32:52','2017-09-12 20:53:47');
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisoasignado`
--

DROP TABLE IF EXISTS `permisoasignado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisoasignado` (
  `usuario_id` int(11) NOT NULL,
  `permiso_id` int(11) NOT NULL,
  PRIMARY KEY (`usuario_id`,`permiso_id`),
  KEY `fk_permisoAsignado_permiso1_idx` (`permiso_id`),
  CONSTRAINT `fk_permisoAsignado_permiso1` FOREIGN KEY (`permiso_id`) REFERENCES `permiso` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_permisoAsignado_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisoasignado`
--

LOCK TABLES `permisoasignado` WRITE;
/*!40000 ALTER TABLE `permisoasignado` DISABLE KEYS */;
INSERT INTO `permisoasignado` VALUES (13,2),(14,2),(17,2);
/*!40000 ALTER TABLE `permisoasignado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Entrenador');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolasignado`
--

DROP TABLE IF EXISTS `rolasignado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolasignado` (
  `usuario_id` int(11) NOT NULL,
  `rol_id` int(11) NOT NULL,
  PRIMARY KEY (`usuario_id`,`rol_id`),
  KEY `fk_usuario_has_rol_rol1_idx` (`rol_id`),
  KEY `fk_usuario_has_rol_usuario1_idx` (`usuario_id`),
  CONSTRAINT `fk_usuario_has_rol_rol1` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_rol_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolasignado`
--

LOCK TABLES `rolasignado` WRITE;
/*!40000 ALTER TABLE `rolasignado` DISABLE KEYS */;
INSERT INTO `rolasignado` VALUES (1,2);
/*!40000 ALTER TABLE `rolasignado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `foto` blob,
  `mesNacimiento` int(11) DEFAULT NULL,
  `diaNacimiento` int(11) DEFAULT NULL,
  `anioNacimiento` int(11) DEFAULT NULL,
  `huella` blob,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estado` int(11) DEFAULT NULL,
  `codigo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (4,'1094940706','Cristian Daniel','Cruz MuÃ±oz','1994-09-12','315660135','criscruz1806@gmail.com','1','ÿ\Øÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0cd\"\0\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0\0?\0÷ú(¢€>¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š\É\Ö<M£\èJ´/£LdD>g?ğ\Ï\ãÒ“ijÊŒ%7h«°¢Š\İğ÷ƒ¼Aâ™¶hú]\Å\Ê\ç\æ”.#_\\±\ãğ\ëZ\Ô\0$œ\Ô×“\ëf}\Ñ\èö+\Zÿ\0\Ïk“¹¿\Ì\×©ø‹X\ÖX›ıBy”œù{°Ÿ÷\È\ãô¬%‰Š\ÛSÓ£”Ö³÷3\nŠú\Ã_³Ü›Äº©õ6\Ö_^…\È\ç#\Ğ\nõ­\áÿ\0…|4«ı™£[G*Œy\î»\ä?ğ&É¯t\Ô|g\á\İ,•¸\Õ`.?‚#\æ6}\\\àık–¾ø¿§E‘a¦\Ü\ÜYXF?M\ÇùWQXK7¶‡£O(¡Š\ìù3Føy\â\íxn\ÓôÇ\0ù’\'–¸=Álgğ\ÍwúW\ì\å\â+u=R\Æ\Äc F\Zfşƒõ¯¦h®ú\ï\âÖ¹6V\Ú\Ú\Î\İOC±‡\âN?JÆ¸ñÿ\0Š.Iİ«Hƒ\Ò4T\Ç\ä+š¢²uf÷gd0t!´\ãZ\ì\ã\á»r}ª\ê7d}\åM±+~„Îº{/‚\Ş²\ähbvõyôİÒ»\ê+R_k³¬\Öu\Î\r\Ë\ãò\ÍTmFùÔ‡½¸`zƒ+\ëU¨©»6T\à¶G5\Ã\ß\ÛbğÆ“‘İ­Q¿˜\æ´cğŞ…D\ÓQ‡B¶¨ı+RŠd\ÓJÒ†29`:–9¥şò&\İ\Ü\èŞ«!¢—\ïş\Êh‰%rª\é¶…\Ê\ÙTõQüª	t\r\Zt\Ù6“a\"\ç8{d#õ£Ek\Å\âŸBG­\ê!T`/\Ú\\€>™­Ko‰+¶\n£T2(\í,H\ÙüH\Ï\ë\\¥Jr[3)P¥-\â¾ã™—\á×ƒ\'\ÜdğÆ”K’-”~ V\çÁ^;¸\Òoù\áp\ê\Ğg¥z\é6_5X˜\í6\Ò\á\0Áò‹D\Äú\ä\î¥tºw\Åı\çj\ß[]Y¹<¶ˆ\Ôsÿ\0×ˆ\ÑZ*\Ó]Ni\å\Øy}›z©şÍºL±“¥ë—J[?\é¬Š iıkŠÖ¿g\Ïişc\éóY\êQ(B9Fÿ\0€·øõ}KE}9¥ø“E\Öv?R·\Û8Œ>öN\éZ•òx89k£\Ñüu\â- ·\Ô$–\Ç\în?x˜¹\ä¡¬q?Ì\Z¹KŞœ¾ó\ák\Â^ ğó¸Õ´{»UBHñ’™=>qòşµ_~\Ér®\Ù]}dW\â?„^ñ\"»É¥\Çgr\Ù?h³ı\ÛdI\å\'\ê\r}Ey‰ñ‚\Ê\à¤ZÍ›Ú¹\à\Í]>¥~ğM\Õ\èZ~§cª\Û‹¸nb8ù¢pq\Æp}±æ·Œ\ã-™\æ\Ö\ÃÕ£ñ«Q^\Ñ\â\Ù\ãY°?‡\ïc\Ôa\"	w.8À\î±ÿ\0¾k\Èõ=\'PÑ¯\Z\ÓR³\Öqü¡\\Œ\ã#\ÔpyUª(¢¬À§EQEPEQEPEQEPEQEPEQEPEQEPEQEPEQEPEQEPEQEPEQE\Í\Ìv\Ò\\\\Ì\Ã\Ë\È\í€Ö€Jú ¢Šš\Ö\Ò\âú\ê;[H$y8Ô³1ö¥¬mw\Å:O‡b\İr¤e`æ‘¾ƒ·\Ô\àWâŸŠrK\æZh\0Æœƒv\ã\æo÷ôú}…y¬ó\Ës;\Í<¯,®r\Î\ìY˜ú’k–¦%-\"{\\¦S÷«h»uÿ\0€C]…¼¯ø\Æ\ï\É\Ñ\ìZDpÿ\0,Qı[úšõ\ß\0ü\'\Ê\Ô|\\\Äw]>6\éşûwúN§5\ï\Z}¦—g´V\ÖÑŒ$Q.\ÕQ\ì+¶\×ş\'\êÚ\èt\áıŸlx\Ê\Ê\Ãı\îß‡\æk‡wi»±fc’\ÌrI¦\Ñ\\’œ¤\î\Ù\îÒ¡NŠå¦¬y?ƒ¾hšG—u¯\Éı©v0|’1\nŸ÷‹¸\çƒ\è+\×-­`³·H-¡HbA…D\\\0*Z(¢Š*M‚Š(¢Š( Š(¢Š( Š(¢Š( Š(¨%ûÿ\0…2Ÿ/\ßü)•H\É\îQEQE2BŠ(¢Š( Š(¢Š( Š(¢¬\Ø\êše\Ò\Ü\Ø\Ü\Ëo2ôxØƒô÷\ÕZŠ¤Õ˜Vn³ i^!²k=Z\Æ¸ødPppy±\äÖ•\ê~ø½,{müAš½>\Õ€\ßğ%\è}\rz©\Ùj\Ökwas\Ä\r\Ñ\Ğ\ç\Ğúc\Í|³WôkQ\Ğ\ïÖ›u$ô;O=t#\ë[Â»ZKS\Ì\Äe”\ç­=\à|ÿ\0\ã?\Ù\çıe\ç„\îp9?b¹b~¿\ÎI\ê+\Ãu]#P\Ğ\ï\ä±\Ô\ìæ´ºŒü\ÑÊ¸=q‘\ê8<+\ï*\Äñ\'„´_i\íg«\Ø\Å:U\È\Ã!õ9¾¡¢¸	üN°ÖŠZj,o›€\Ù\Ä2}	?)\ëÁü\É8®úº\ã%%txuhÎ”¹f¬|7Ez—ş\n\êşóo´¯3RÒ—œ™£\í(\ê:r=ø\0f¼¶Š(¢¨\È(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢¹x\â\Û\Ã0›h6Ï©:\åb\íşó‡z™IE]šR¥:²P‚»\n(®û\á¿\ÂıG\Çw¢i\Ú\èñ¶&¹\Ç-ş\Êg©÷\è?J\ÔñŠ4\ï\Ùy×’n™‡\î­\Ğüò\è=\Ïó\â¼CÄ,Ô¼Ou¾\íö[©ıİ¼g\äOs\îN•—¨jz­ì——Ó¼\×³·òƒ\ØUj\à«Y\ÏN‡\Ó\àòøa\×3\Ö]ÿ\0\È\Ãğ‚µŸ\Z\ê‚\ÏK·&5#Î¸aû¸‡¹õô\Ó$}S\àO†š/­?\Ñ\ã7\î Ky*\ç¾ \Ïa\è;ó]ƒ\áı3\ÃZ\\zv“j–ö\ÑôQ\Ôû“\ÜûšÓ¢Š(¬O@(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢”\Ç\0f6–¬(¢ŠJ*e·c÷*Q\Ùú\Ğr\ÏJ=nQET¢®„Q\ÑG\åN Á\æ¤BŠ(¬™~ÿ\0\áL­šBªz¨?…;‘õë¿‡ñ\n(¢±\è­V·‰º\Æ?*±C÷¯4\îie7¾EU\n*i-¤’2=ECA\Ó)+Å…QEQLaEQEPEQEPEQ]çƒ¾$\Şh[,µ?2óN\0*œ\æHGû9\ê¸ş\í‚:Šq“‹º3«Fc\Ë5t!õ\ä>	Yx‡\Í\Õ<>\"²\Ô\Î^H±ˆ\ç=óŒz\ç¿99ÁE}Oa¨Zjvq\İ\Ø\Ü$öò«¡\Èú{cÈ«5ów…¼Y¨xVüMl\Şe³‘\ç[1ùd\Ğú\æ8¯}\Ğ|A§øN[\İ>]\É\Ñ\ãlŒú0\ìkºU?S\ç1x)a\İ÷s\à­GM½\Ò/\å±\Ô-¤·¹‰¶¼r\ï\î=\àöªµög\Ä‡Z_ôÂ³ ‡PO\Ù\î\Ğ|\È}¨ö?¡Á&x›\Âú·„u‰4\Í^\Ü\Å2ı\×\\”‘¼§¸­J(¢µ8Œj(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(®S\Æş0‹\Ã(\n¾¥:Ÿ%;M\ç\Û\Ó\Ôş52’Š»4¥JUf¡«\n(®ó\áÃ›¿kY‘Z-\"ÙºŸ{¿–¿\í\Ğ~[\Ç>9‹Ã°+&Y5I\Ô@ñ7¿ üO|Fyå¹\çF’Y³»œ–\'¹4\\\\Muq%\ÅÄ$\Ò1gv9,Oz¼\ê•\Ùõ˜L$0Ğ²ß«-ü.ø]u\ã{å½½W‡E…¾w\èf#øW\Û\Ôşœ‘õ~Ÿ§\Ú\éV\ÙY@\ÛÂ¡Q\0\0JM7M´\Ò4øl,`H-¡P¨Š0\0jŠ(¢³:ÂŠ(¢Š( Š(¢Š( Š(¢Š*Xb\Üw7Aú\ĞgR¤iÇšAEQ%ù<-YUUQŠZ)-lD\ê½v\n(¢Š(¢ƒ\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(ªóZ¤™+ò·\èj\Å	\ÊñaEVC£#aƒM­I\áY“†\rf2”b¬0E3Ô¡]U^aERQE\ÍÂŠ(¢Š( Š(¢Š( Š(¢µ|?\â\ï\r\ê‰}bø#‰#?vEô?\çŠÊ¢„\ÚwB”T—,¶\n\æüi\à½3\Æú#\éú„`H9‚u4M\ê\rt”W\Ó>ñ‰´µ½²|Ä±1ù¢oCız×¯™ü7\â;\Ï\ê\É}hw»,G\îÈÁş‡µ}£k6Zö—¡a&ød\İXv#üñ]Ôªó«=Ïš\Æ\à\İ	^?>ño„µ?\ërišœD0\æ)@ùe_\ïğ\íXUö¿ü§x\ç\ÃòX]®Ë„\í®|\Ñ>8úQ_\ëú¡\áf}+S‡Ë¸„ãº\ã³)\îÿ\0X\à‚*ıQ[&eQEQ@QEQ@QEQ@QES%–8!y¥p‘Æ¥˜\à(’h\0¢Š|0\Éq<p\ÃI,ŒFK18\0Z\Ëñ\'ˆ-|7¤I}pw7İŠ y‘ûñ=…|÷©\êWZ¾£5õ\ä›ç™·1\ì=\0ô\0qZş2ñ<¾&Öš`XYÃ”¶Œö^\ìG©\ëù\Õ\Î×Z¯;²\Øú¬¿¨Cš_ş¬mxCÂ·ş1ñ\ZM‚\à¿\Í,¸È‰V?\á\ë\éÖ¾\Ìğ\ç‡tÿ\0h–úV›\È!P2~ó\ì}\É\Éük™øW\à¼\á¤ :­\Øvş‡²aüòx\Íw”QE‰\è…QEQ@QEQ@QEQ@QNE\Ş\à\n¸\0\0\ĞTV\ë…-\ëSPx\ØÚ¼ó\å[ ¢Š(¢Š)œaEQEPEQEPEQEPEQEPEQEPEQUo!Ü`¯_¥Z ŒŒ”NnRAEV5ùcò\åeô<S)\Úi« ¢Š(¢Š)€QEQE\0QEQE\0QEWS\à\Ë\á][2eôû‚\â?OG\ãõ„r\ÔS‹qwDT§\Z‘p–\Ì+\Ï>+ü9‹\Ç\Z›jªš½¢–·qÿ\0-=Q½\èq\î¡\Ñ_V\Ã4wG<.²E\"‡GS\ÊFAúò/…^/òd_\ß8òÜ“i#Ô§\Ğõù\äW®×¡	©«£\åq4%B£ƒ>šm§’	\ãhæŠ:8\Ã+‚\ìA¦W¿|xøu\Ş.\Ò\â\àao¢AÛ´˜ö\è}°xÁ\'Àh¢Š*\ÌŠ(¢Š( Š(¢Š( Š(¢¼\Çâ§‰ü¨\×@´‡p\è\Ë\ÕSñ\êS]î»«Ã¡h·:Œüˆ—\å_\ï1\à\Ä\×\Î7·“\ê\Ó\Ş\\¾ù\ær\îŞ¤\×6\"§*\å]O[*\ÂûIûYl¿?ø^\ßğÀcP¿oj0¶·%,Õ‡\r\'FoÃ \ë\Î}y7†´¯øŠ\ËG´½¹.\îÈ½K~5öÎ‰£\Úh\Z5®—b-\í£ \Ç\'Ï©÷¨(¢Š\á>”Ğ¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Štc2(÷ ™>T\ØQEqF\Õ\ĞR\ÑE3\ç[»»\n(¢Š(¢QEQ@QEQ@QEQ@QEQ@QEQ@QEQ@QT¯“\æWõ\à\Õ:Ò¼]\Ö\äúk6š=l$¯O\Ğ(¢Š(¢Šg@QEQE\0QEQE\0QEQE\0QE\è\äx¤Y#fGBYN#¡ôW‚|L¾\'ğüw.\ËöÈ¿wrƒû\Ãø±\èG?˜\í_9\×Q\à?\rø’)%|Y\\À\'€¤ğ\ßğ\Ï\Ó>µ­òK\È\â\Çá½µ-7[\İ[C{i5­\Äk$3!GF\0†`‚\r|iñÁ’ø\'\Å\×:xV6R-¤‡ø£=³\Ï#¡\ï\Ğ÷¯´kÏ¾/ø)|_\à\éZƒjV \Íl@ù›™?øgµ}EWyó\È4QEQE\0QEQTõ]F#Jº\Ô\'ÿ\0Wor3÷aøœÆ†\í¨\ÒrvAEE\Òn5\İn\ËJµ\êe‰x\Î2y?@9ü+\Êş+øƒ\íZ”Z,˜­y6Y\à~\0ÿ\0\ã\ÇÒ¼æ¦»º–úòk©\Ût\Ó9‘Ï©\'&¡¯.r\ç“g\Ùá¨ª4•5\Ğ÷\Ï\Ù\ãÁÿ\0f\Ó\î|Su%¹\Ì¹\í?3~\'Â½Ò¨\è\Ú]¾‹¢\Ùé–¨XV$\Ï\0U\ê(¢Šƒp¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(© ”Tu-¿ú\ÏÂƒCµ)zQV¨¢Šg€QEQE\0QEQE\0QEQE\0QEQW,´»\İA±knò\ïc\n?\Å\0QES«ºv•wªM\å\ÛDH\æsÂ¯\Ô\×Q¦ø.8\ÊÉ¨K\æù\åñ=Mu0\Ã¼K1¬q¯EQ€*”B\áEVf\áû]*<\àK;4Œ?@;\nXğå¦£4Q¤7 e]F>‡üknŠ«(¢Šñù#xex\äR®„«ØŠmt>1´úÏš£:?QÁşB¹\êÍŒ(¢Šd\Ã08ÿ\0d\ÖMk¿ú¶ú\ZÈ¦GıÖ‚Š(¢Š(¦v…QEQ@QEQ@QEQ@QEQ@!”‚‚zZ+\ß>øƒûk\Â\éo+f\ê\Ã?©L|ùÀI\ï]¥|õğ\ï\\ş\Äñu¶öÅ½\×ú<¹<\r\Ç\å?ƒcŸL\×Ğµ\ßF|\Ñ>g0¡\ì«;lõ>Dø\Ë\á\á\Í,(E–£›˜N8OÎ¿™Ï \Üjóºú\ç\ãW…‡ˆüs<H\r\æş“«÷—¦O\ÊN®+\äj(¢Š\Ô\á\n(¢Šó‹zÁƒL´\Òc|5\Ëy²€z\ì[Ÿø\rzE|ı\ã\íSûW\Æ7Î¬Z(\ìñó\Ğ\'Û·Æ°\ÄJĞ·s\Ò\Ê\èûJé½£¨W³~\Ï\Z\Z‡‰\ï5\Ù\ã\ÌZ|{!%xó_¸>¡Aÿ\0¾«\Æk\ë\ï‚ú\0Ğ¾i\ìÈ«=ön\ä#¾ï»Ÿp»G\á\\\ÕQ^yõ\' \ÑEQE\0QEQE\0QEQE\0QEQE\0QET°­ü**|\'­U\Õ\é\Ë\Ğ(¢Š¹ES>|(¢Šš[‹\ŞDË·\ïyh[\\T\ÃI\ÔX\átû¢Oa…vŸ\ãÅô¸û\Ò*\ç\èø\×iT£tC‚Š(¯MW~še\ß\ã\æ*\Ì~\×%<X8ÿ\0y\Õ™¯Z¢Ÿ\"\'…Q^g€µy1\æ5¼#¾\ç$ş€Ö­·Ã¸\êı\Û\Õb@?SŸ\å]½ùP¹\ØQE\ÎG\á}&Á\×Ëµ0\İ)\Ü#\Ç\éZ\0\0\0\0\0«_\ëGûµ‹`¢Š(¢Š(\0¢Š(¢Škº\ÇH\ìe˜\0 Š(®K\ÇQ\æ+)=¯\çğ®2º\ë6zŒpÁj\í!‰-·ÓµsrQE\×ûô¬ŠÖ”\â?\ìšÉ¡fQEQE3´(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢ŠÁ\È\ë_KxKXş\İğ½…ùl\Ê\Ñ\ì—\×zğ\ßL‘Ÿ¡óMz\×Á­W)¨\é\İ1s\Ç\Ñ_ÿ\0dıkl<­+w<\ìÒ—=n¨k¢\É#Œ«õñ<>|/\ã=SIÛˆ¡˜˜q’<¶\åy=pPk\í\êù\ßö\Ğ<«ı+\Ä¡\Ä\Êmfb{™\0Mõ\ê\ÔQEw8xEQTõkõ\Òô{\Ë\æÁû<- ¹ ~&¾ffgvv$³’{š÷/Š\ßdğd±†º•!½wıõ¯®T½ä£É©Ú”§\İşEıM}g]°\Ó#İº\î\â8AQ’70ık\î»h\Ö\Öt\0$H¨ Šù3\àn—ı¥ñF\ÆBF\Û8\ä¹9p6Õ…}qEQ\\Ç°QEQE\0QEQE\0QEQE\0QEQE\0QE\èòd\\Nx–(iR(Ô´ÁUGROA^\Ç\á¿\Ú\èVˆJ,—¬?y1 ú/ ştÒ¹ËŠ\ÄFŒuÕ°¢Š+\Í\ä\Ñu(´õ¾{I±\çsGQø\Õ\n÷6Ut(À2°Á¡\ã\Úşœ4½n\æ\ÕG\î\Ãnı\Ó\Èüº~N6<(\Ê\ì(¢Š\î¼—\á\æ|¬›ôúWQXşƒ\ìş±\\rÉ¿şú$ÿ\0ZØ«[=ÂŠ(¢Š(¦ ¢Š(¢Š(\0¢Š*¥\×ú\Ñş\íAS\İ­\î\Ô™ª\Ø(¢Š(¢ŠC\n(¢Šk(te`\n°Á¸§Q@Q^M¨Z›-B\â\Ø\ç÷nTg¸\íúTp[\Íu0Š\ÚIEQ“[¾3·kK(Mb}\Ç\È\n\ÖğM’¥”×Œ¿<±Oû#ÿ\0¯üª-­Š\n(¢¸F\Ö\â\Ñ$ŠxdL}\Ö\\q\ëô¬Z÷†Š7uvE. …$r3Ö¸?\Zøb mR\Æ1÷ñ¨À\çø€\í\ïN\Ö;p•£qõ\n(¢¸:(¢ƒ\Ñ\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š\éşj\'Mñ¾šù;\'³°\ßòüx©ü+˜§\Å#\Ã*KÃ£R;Òœ]È©88¾¡\\\Æmk?µL*l\Ô]£0\åv¶=\Ê\îw\Õ^ú\Ö;\ë‹IQ^9£h\Ù[¡b¾­¢ ³ºK\Û{¸¿\Õ\Ï\ZÈ¿FÎŠôÏj\Î\Ìø\"Šö\ÒKû‹9†%·•¢÷”•\æ®¸Ò¬Áÿ\0’°ü€ÿ\0Ù«\Ë+»ø³?›\â\Èb\"µE?R\Ì¨®¼\Ú\Îõõ¹|yp\ĞG¹~\ÍV¯µıD§ÜŠ(¾¤±ø\ê\×\Ğ\Õã¿³•¡‡À·÷$\ßß°¹\nŠ?™5\ìTQE‘\ÚQEQE\0QEQE\0QEQE\0QEQE\0QEt¾´[¯\Â\Ì2°#KqÀıH¯^¯+øp\ê$•OW¶e]\Ê¥z¥k\r1m\ÖùQEy\ß\Ä1«Z\ÊÌ\í\éÔ†?\ã^‰\\Ç‰´É¯õ£ŠG‰%>s(\ÈUÊ};Ó–\Ç]˜QE\Ğ\Ú@-¬\à€tŠ5O\Èb¦¢Šd…QEQ@QEQ@QU.¿Ö÷j\n\ëıhÿ\0v ¤\ÍVÁEQERQEQE\0QE\Çø\ê?–\Ê_B\êLZ\Üğ\ä~W‡\ì\×P·\æIşµG\Åös\ŞX[­¼+¬¹!H5­¥D\Ği6q:•u…+u\"—Q…QW*+˜\ê\Ö[yRT(\ßB1R\ÑL6\n(¢¼\ZDh¤x\Û\ï)*~¢›S]º\É{;©Ê´ŒAö\ÍCR{\ë`¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š+\è\Ï\0]=\çt™\\\ä¬F/Á ıQX¿ei<*“\Äw£\éµõ¢½\ZnğG\Éb£\ËZkÍŸüR°Mø¯\ÛD0†\è\Ê»€\çõj+¥ı ­’‰›\Ñ@3YE#`u9e\Ïş;Ep_$ó<w¨‚F£õ\ÍOõ®Rº/¸\ê¤ùj\ä W;^uOŸ[…V¡\ä¿#Ø¾\Â\"øS§°\Îdšg9ÿ\0®„ +\Òk†ø9‹\á6‚¤‚Lr7ò¹şµ\Ü\ÑET…QEQ@QEQ@QEQ@QEQ@QZZ¥ı“®\Ú^6v#\áñı\ÓÁı\r{‚²º†R\n‘Gq_>\×m\áO\r:°\Ô÷µºñª2c„w\Ëù\\]7†•D§\r\ĞQE\é´V}¹¦jrùVw±M&\İ\Ûó;¨­\n\Ğñef¬QEQE\n(¢Š(¢€\n(¢Š(¢€\n(¢ª]­\î\Ô=\×ú\Ñş\íAIš­‚Š(¢Š(¤0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¬¯\êK¥hW7€‘—dC=Xğ?.¿…Cw\â\İ\Ò6f½Yx\Ù,\Äúú\ë\Î<E\âõûÀ\ì¾]¼yEœ\ã\ÜûšMT0òœ“k@¢Š+\ZŠ(¤zÁEQEPEQEPEQEPEQEPEQEPEWI\áıi´\ë„2\rÒ–ù”ÀJ+I\nQT¦ÑŒ¨FN\ìó?ˆ^\ZWñ7-±ª„«Ñ›üh®·\\‰d½Bsş¬túš+§ñÂ•ñ®ªÁó³ù€kŸ®Ÿ\â\Zy~;\Ô\Æs–¿8\Ô\×1Q?‰›a\èÁù/\È\Çø@\êÿ\0\nt§#\Éqø‰\Z\í\ë\Ï~LeøM£‚\0\Ø\Ó \ÇıusıkĞ¨¢Š*MÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(­\Ï\Ş/Y98Y\ÊoøÀıH¯g¯Ÿ‘\Ú7WBU”‚\ìk\İô\Ë\Õ\Ôt\Ëk\Ä\Æ&Œ9\ÇcG\àr+H>‡™\Ó÷£?QEjŠ(«< ¢Š(¢Š(\0¢Š(¢Š(\0¢Š*¥\×ú\Ñş\íAS\İ­\î\Ô™ª\Ø(¢Š(¢ŠC\n(¢Š(¢€\n(¢Š§ªİ‹\r*\ê\èœyQ3®8ıj\år?oşÏ¢\Çh§ç¹“‘ş\Êò]´\ZR<\ÔBŠ(¯2\Îh¢Š“\Ü\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š+B\Æ\ÎKˆÑ”\0\Ø\äû\n(±.iz\Ïü~\'ıs\Ì\ÑY*\Ô\"´\Õ\"\Ã\ä\Âş\ÓQ]\Å(^4w şú\Ü~«ÿ\0²\×^“ñ†\×f©¦]\ãıd-\İlÿ\0\ìõ\æ\Ô\ë+M“€—6\Z\Ëò9\Ù\î\ín>¼\0ü\Ö÷²¡é­ık\Õ\ë\Â?f­Cv›¯i§?»š)Ç§\Ì\nŸıW»\ÑEVgXQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEW¦|8\Õ<\í:}5\Û\ç·mñö¯\äô*ó:\Ôğö¬\Ú.µoyÏ–\Ù@î‡¯øş\â\ì\ÎlU/kI\ÅnQE{}\Ø\äIcY#`\È\à2°\èA\ïN­›\n(¢Š|q<¯±[\Ó4\Êr;F\á\Ô\á‡CBó\äQEOöŸù\çÿ\0\n>Ásÿ\0<¿ñ\áV¢\ÔĞ€%R§\Ôr*\Ò\İÛ·IWñ\â·P¦ú˜¹\Ít\n(¢°®4»Ç‡#\Ş\ãQd_\Ïü}Æº&»¶_½qÿ\0Š‚MV\Î1ş¸1ôQšn•>¬jµM’\n(¢±?²o¿\ç‡ş>¿\ãT«V÷Yy‘£J)\à±\êÂ²«	¨§\îsk\Ş\n(¢Š(¢ °¢Š(¯&ñ¦¥ı¡\â	U1[)}2>ñüÿ\0•zˆõa£h\Ó\\<\æ!¬Ã¯\á^6IbY‰$œ’{\Òg¡‚§«›\n(¢’Š(¤zEQEPEQEPEQEPEQEPEQEPEQEPEW®|.\Ğmu/\ÜOp\ÒŒ£i\Æ\Äõ\Ô\Ñ]/\ÃU¶ğ“\0CN\ÒHùõ\Ş@ıQ]ô\à¹Ï—\ÅWŸ¶•ŸS\æ\ï> ¼\Óü¼\n\r>3óg‚]ı¢¹7²^üU\ÕÃ°e·1Â˜\ìÌš+;\âİ™›\Ãv·j2m\î\0>\ÊÀ\æ¼f¾‹ñ†Ÿı§\á-N\Ø·’dAş\Òü\Ãõó¥r\âU§s\Ù\Ê*sPq\ì\Í\ß\Ù\ãSû\'\î,K\0·¶n\0õd!‡éº¾£¯ˆü«ÿ\0ax÷D\ÔNGtŠ\äœ\0ò·\èÆ¾Ü¢Š(®s\Ö\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢½Àş+Š(I\Ô%	´\â\ŞV<`ÿ\0	=½¿/Jô*ùòºmÆº†	¿Ò­¾e\ìŸ\èJ¸Ë£<¼VÍ¹\Óß°QE\ë´VN‘\â]/ZUû5À°\Éò¸ü;ş­j\Ğò%	A\ÚJ\Ì(¢Š(¢Š	\n(¢ª]­\î\Ô=\×ú\Ñş\íAIš\Ç`¢Š(¢ŠBB‚\Ì@’OjC\n(¢–¢¹º‚\Î\İ\î.eX¢A–f8¹\İg\Æúvœ\Z;R/.Cò/Õ¿Â¼óV\×/õ©¼Ë¹‰Pr±¯¿Aıi\\ê¥…œõz ¢Š*ß‰õö\×u\0\Èmb\ÊÄ§©õc\îkŠ)¬b¢¹PQEQE(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢µ¼3§kxŸM±(]%|À:\ì-ÿ\0ƒBWv¤£\'\Ğ)‚#;*Œ“\íK\\\×\ÄkûÀZÎ¢²ˆ¥KfX˜Œşñ¾U™ôNƒdt\ßi\ÖL»^h\Ñ\ÇûAF\\\ÑZ4W¦••“rm³\ã\ê#Wñ>«¨«[«¹eRO;Y‰¦(¬\Ê( A¨¯šüC¦\Ä7\Ö!˜„\Ït<©üˆ¯¥+\È>.i>F«iªÆ %\Ä~T„}zõğ\Z\Ã\ÆıS(«\ÉYÁı¯\Ğ+\í\Ïk«\âOi\Z\à\ÒIn«.I\åaùƒ_\×\Ñ_³ˆ¼\í7Rğô\Òğ8¹€3pÀb2Ş¯8¢Š+€úc\İh¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢ŠPJ°e$r\í^»¥\ê—)§\Û71);ù=zò\Zõ-?şA¶¿õ\Å?ª‰\çf	8\Æ\áEWG«ğùŒûò*\ÚKƒ\äuo¡®fŠ»K¦ºQ[\×_\ëGÒª´Ñ§\ŞqY„“ÔšJ.R‚Š(«¯z\ÜR}\Íqş;¹™´¨\Ì`­6\nƒ€x=k£®[\Ç?ò¶ÿ\0®\ßû)¤o‡K\Ú ¢Š+„¢Š)¸QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEW¢ü \Òş\Ó\â+E\Ó)g\Õ9\è\ïÀÿ\0\ÇC~u\çU\ï\ßtƒ¥ø6	]v\Íz\Æ\á²9\Úx_\ÃhşZĞ\æp\æ5y(5\Õ\èâ¿´nºm|3§h±\È\Ê÷³ù².8hÓ·ıôTş\íUò\Æ\â=ğ‰\Ã[ØkRpJı\ã]Äø®ÊŠ(®ó\æO>¢Š(®Æº)\×|-wk\Z\î$ºö\äd~5\ĞQJI5f]9ºsS\è+«øo\âc\á?iÚ“>\ÛrşM\ÆN–üûğ®RŠùfŠ\éü{¡ax¢uqmsûøp8\0Wğ9ü1\\\ÅyR‹‹³>Ò•ER\nqÙŸ#«¢ºœ«ƒ\íK^uğcÅ¿ğ“ø\Ş)\ä\İ}§\â\Úm\Ç%€+u\É\È\Ç>¹¯E¢Š(¤hQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE\êZüƒm\ëŠ!U~ø-E#\Öõ ’[>D\Èr	o`GNıø\ë\êzE•\è&X@\ï§üık¢%(óa§Î©­m¸QEÀ\Ñ]ç…§-k •º\ß+‡ò¬9\í\æ¶}“Dñ·£T\Ê\è\åH\ËfQEGEn\ÓL¼½#ÈŠÿ\0|ğ¿JM\ìSi+°¢Š*¥r\Ş9ÿ\0]·ıvÿ\0\ÙMz•Ÿ…c\\5\Ü\Å\Ï÷#\à~şªÑ»\Ğt\Ë\İ2]>{8\Ú\ŞQ†\ç\Ø\ç®G­l°òkS8\ã!Ni\îQE|\ÃEt>0ğ´\Ş\Õş\Êò‰`”o‚LŒ•\Ïñ\Ä~µ\ÏV\r4\ì\Ï~Œ\â¥˜QEQEQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEiøH“]×¬ô\Øò<ù\0vÂƒ–?€\×\ÓQDB‘D#E\nª:\08¼¿\á‡ü¸.u\éĞƒ&`·\Èş~f}š½N»pğ´o\Üù\ÜÎ¿=^E´3ŸñÇˆ£ğ¯ƒµ-a\È\ßDD§?4‡…t\É#šøYdg–Wg‘Ø³»–\'’M{w\í\â\áw©\Úøb\ÙÁ\×÷÷8?\ÆFO¦N=\Ô×‡QEV\çšQEQE\0QEr¼=ı½\á\ÇxSu\åe‡Xş ~`W‚\×\Ô\Õ\á_|5ı…¯5Í¼{l¯	’0\ßÄ¾\Üò=µrbiı´{¹F\'zù\ç\ÂOø\ÒMºu\î ºğ?+~÷\ìM}„¬C)Gzø¾«ø\ã‘\âOd\ŞMON\ãÌ±ÿ\0{0zœóŞ¸\ê(¢¸\ÏxõJ(¢Š(¢€\n(¢Š(¢€\n(¢Š(®¯\Ãş¼\Ö!K»‰µ£r¤Œ»P;sUJn\ÑF5«Ó¡z\È(¢Š\å*Õ¦›}~\Ûm-&Ÿ\×\ËB@ú\Õ\ëšwƒ´M8¶k<ƒø\î>sùt€­\ÕUE\nªG\0€+²\'ö™\ãV\Ïb´¥ú…Q^Ii\à\rv\çH¡¶S\ŞY9ü—5¹kğ\É7z“UŠ<~¤ÿ\0Jô\n+x\á)¯3Î©œb§³K\ÑÂŠ(®b\ÛÀ:\r¾7Á,\äw–Sÿ\0²\âµ\íô=*\Ó\r:\Õş!\Ï\çÖ´(­•8GdqOZ§\Å6şaEV†—(\\ÁÀTV•sñ\Èb‘\\uSš\ŞF—FE)­Eu`¢Š)\Õ\ÑE,efDt\îdT•›u’aCÀû\ÇúT¥}\nr\å\Ô(¢Š«ii¥öU¶PÇ”\ÜIğ5¶r\Ó1YU”@\È\"·´û\Ñw‰W\ï_zn\n;	Trø˜QErŠ*–©q\äZ\Ï\'\Ê?­$®6\ì®QEajMıÃ™#I#è¡—#a\ÜxcDºÏ™¦[‚z”]‡ÿ\0\ÅkQZ¸\ÅîŒ£Vqw‹h(¢Š\ä®~h\Ód\Â÷0\Û_pıFZÆºøkr¼\Új?´¨Wõ¯F¢³–›\èuC2\Ä\Ã\í_\×P¢Š+Ç®ü®\Ù\ä›&™GñBÁóøJÃšm\ä1\Í\Æãªº#^ûQ\\Z\Û\İ\Ç\å\ÜÁ\Éı\Ù0ık	`\×\Ùgu<\îkø‘¿ QE\à”Wª\ê^\0\Òoš\×}œ§¦Ã¹sş\éş„WŸ\ëš\îƒr#ºPÑ¾|¹S\î·øj\å©Btõ{¶G\ígÙ…QYTQEdvQEQ@QEQ@QE]\Ò4»kV¶Ó­Ff¸p€Š;“\ìIúU*öo„şûƒk·Q\â{‘²\Ü0û±÷oøı½]8s\Ê\Ç>*º¡IË¯OP¬ø‚\×\Âş\Z½\Ö.\Û\Û\ÆH«7@£¶IÀõ±_1üzñ\×öÎ¸¾±˜5–ù‚n˜\Èş\ï×©<dW i\Öú^oaj»`‚1\Z2@\îq\Üõ\'\ÔÕª(¯DùF\Ûwg“êš•Î±ª\İj7¾\â\æC#p	=z\ĞÀ\n©EQE(¢Š(¢Š\0(¢Š++\ÄZ!\Ñg\Ó\çÀ.7Føû:7ù\ìMj\ÑI¤Õ™Q“„”£º\n\Ûğ—‰¯<#\âKMbÉ›t-‰	#?yO\Ô~ Õ‰E|\Ãcq¦\ß\Ïeux\\£¯¿øUzö¯ˆşşÙ²şÔ±‹7ö\Ëóªõš1\Û\ê;zôô¯¯6­7	Xúü&*8Š|\Ë~§\İ\Ú·e\â=\×V\Ó\ä[\\¦õ9\äzƒ\èA\ã£_)ü\Zø|%¬ejRÿ\0Ä¢ñ±¹H‹\èzğ:ñ\Í}Ve¤FAè¢Š+3¨Z(¢Š(¢€\n(¢´t=4\ê\ÚÕ­–\Ù\ç#²[ô½\ÅcEDPª \0@+Î¾\Ziû®/5^D(}\Ï\'ùÎ½½<-n\ç\É\çUù\ëû5´6QEQEu8QEQE\0QEQE\0QEV¦›6\è\ÌDò¼¥eÔ\Ê\ĞJ$^H\í\ëJJè¨»0¢Š+Nö\ë\ÉMˆxß ¬Šs»H\å\Øä´\Ú\"¬•\ØQEZ\ãı`úQ\ïo2\É\ä~´\\¬JŠ¨¢Š+«·¸K˜VD<£\Ğ\Ö©q\ç\Ş0\åO”ZŠ\Öò[Rû0G¿­W¨Q³*Sº\n(¢Š(¢¬€¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¬o\écV\Ğ.!™Py±z\î\â2?\ZÙ¢”¢¤šeÓ¨\é\ÍN; ¢Š+\çú+S\ÄvÙ¾ ¼¶„nAş\É\ä:Ë¯J\Î\Ìû˜MN*KfQEQE\"‚Š(¢Š*Ö§]jÚŒ6q.&m¨£ùŸ@$ú\n´•\ØQEfkúõ‡†´kSQ˜Go<ò}\0÷\'\êEnø\Â\Ï\âub‘XXÁ‰.\\zvP}[§\Ó\'µ}ikh©\Z\0ªª0€\n\ÉğÇ‡­¼3¢\Åaoó?Şš\\s#§\é\Ø{[\ßJŸ\"ó>_Šöõ4\Ùlr|x\nğ»‹wSª^ƒª8\å\Î{Ç’|\×\È2I$Ò¼²»<Å™\Ø\ä±=I=\Ínx\Ç\ÅW¾2ñ%Æ¯zH\ßò\Ãr\"Œt_\ê}\É\éÒ°h¢Š+SŒ(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š+\È~#ø+\ìRÉ®i±£9\Í\ÌJ?Õ±ş!ş\É\ï\è}½MtY‘\Ô20!•†A†¢¤Õ™Ñ…\Ä\ËS?0¯¡¾üQY£‹Âº\äø™F\Û‡<8òÍ½\Çc\ß\ë\×\çšr;\Å\"\É2:\Ê\ÊpA5ò\İ\İxóÀ¯¡\Êú–œ…ô\×l²M¹=û>‡ğ=‰\ákÍ”\\]™õ´kB´\àô>ı¢¼k\áÅ¸õ\è\"\Ğ5\ÙU58\×l31À¸\0\è^£ñde¢Š*kKg¼½‚\Ú?¿4‹ú“Š\Í[I]…Q^½\à«°ø^\Ô‡›37¾\îŸø\î+ ¦E\Ã\nDƒŠG ú÷!X¤|\rj­IMõaEQEUQEQ@QEQ@QEQ@QEQ@QU®?\Ö¥ER\Ü¬JŠ˜‚Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¯9ø“c²ò\ÎùG!‰¾ \ä3ùW^¹\ã«?µø^g/,£óÁı	¯#¯/Z§\ÖeUyğ\Év\Ğ(¢Š(¢•U‚ª–bp\0$\×9\éTsM´4\Ò,q ,\Î\Ç\0\nX\ãydX\ãVwbUFI\' \ï~\0ğPğÅ‹\\İ…mN\á@“ˆ—®À{óŒŸP=2s¾øûSW\ÕcPe\ÌP‘ş \çı¯\å^‰]ti[Ş‘\à\æ\Ş\İSÛ¯˜—W0\Ù\Ú\Ësq\"\ÇH]İˆ@\ä’M|“ñ[\âL¾:\Õ\Ö\ŞÑ4kF>B5ºy„}8\çô\Î¿\Åß‹â©ŸDÑ¤)£\Äÿ\0¼–û/ó¯$¢Š(®“\É\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢›$i,mˆ¯‚¬¬2 ŠñŸ|?“Fi5-)\ZM8ü\ÏVƒüWß·ZöŠFA\ê+:”\ÔÕ™Ó…\ÅO>h\í\ÕŠY!•%‰\Ú9ƒ#©ÁR:{\ZúS\á?\Æ8µ•ƒAñ\É¢0\\c\Ø7\è{zšh¯–k¥ğ%Ÿ\ÚüS•ZSøÔŠ\ì|gğ\Ó\Ìi50å¤³^÷OO÷/J\Ïøk`ñ.£u*p\â\0`‚9aú­rÒ£%U&{˜œu9\à\ç8=mo=t>ÿ\0¢¾qøcñ½ô\á\â©[o»ñ9dô\ê?\Úüûšú&\Ú\æ\Ëh\îm¥I`•C$ˆr¬pk¾¢Š+\Õ>D–Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(ª\×\ëÒ¢©n?\Ö¥ELAEQEPEQEPEQEPEQEPEQEPET7–\ëye=³ıÙ£d?B1^$m¯Œ:¬=¯~¯\'Ö¼=}{\ãk»\r:\Ù\æ–góT(\àÁ$€zš\â\ÆF\é4{™-eN\r\ékıÁE‘\â/i>\Ò\ä\Ô5k¸\à…x\Ì\çœI\àôô5\ÍC—$0\Æ\ÒK#DA’\Äğ\0\Í{W€¾&Œ#\ÕueW\Ô\Ìp‘‘ø·òıkOÁ¾²ğº-\ÔÌ·:›.\Zl|±\ç¨Oå§\Û8®Â¢•k#Lna\í?wKnı\Í\Ë\Ëm>\ÒK«\É\ã‚\Ş%,òHpª\0\É$úb¾`ø­ñzo\É.¢³Ã£#a\ä\Î\Z\çÏ¢ûwı+\â/\ÅMS\ÇW\rl›­4„o\İ\Û)\æLtgõ=ñ\Ğ{\à\Z\à(¢Š+ òBŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢©\\\é\Ñ\Ê^H‚\Ç+rH}ıñ\Æ*\í\0WM\á/k\Ş\r¾\éw¬±«$\rñÈ·m*{dF\Ü\Ø#&¹š+Ÿ’7†B’)S\Û\ĞûZmo\ËL…$P\Ê}k:\ãM‘IhNõ\'\îÿ\0óÖ´S\îe(v>\Ãğ\Åm\Ç²Ÿ°\êÍ¸ı†Gİ¸r¯€qÁù[Œò¾Gd`\ÊpEz÷¾<\êúq\ØxU²~òp€O\Ìs¼›\ny\É\Æ\à\0FŠ Au`Š*\ÌÏ§\è®{\Âş7ğÿ\0Œ-ÄšF¡“\Üö\Îv\ÍL\å{€X\r\Ã+5\Ğ\ÑEPEQEPEQEPEQEPEUkõƒ\éQT·\ëÒ¢¦ ¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢rNû!¤q\Ô/o©\è:µ±k¢Æ 5\Ù7üós·_^ş\Üô©rH¸Á°¦M4V\ĞI<ò¤PÆ¥\ŞG`ªªI$ô\0w®+\Å\ß¼3\á$–).–òùw(¶·l\ía‘‡n‹†\02\Ã \í\Å|\ë\ã_‹!ñ„óGö‰,ô\Öl\Çi`\ÈÀb1¸ğ§\'8 •ÛœVm¥”÷§÷@,|\æV~¿ıc\Ío\ÚX[\Ù0\Æ¸\ä?yñ\Ó\'ó\ã§&¬\ÑY6Ù´RÇ°|@ø\ç¦\è©.Ÿ\á\Æ[\Û\â¥M\Ğû¶q•a\Î ı\ŞTü\ã\"¾q\Õ5­K[¹7\Z•\í\ÅÔ™$¤g#€:’OEQ¸Q\éT(¢Š(¤0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š*9`ŠpˆB?Â³¥\Ó$Nap\ã†\éùÒµh¦›Bi=É­n\î,n#¸µHfƒ¤‘±¬:{\Øö¯Zğ§\í¯hğ]j\Ù5xUv\Ç#¿—*ô.\Ü\0¨,I\Én\Õ\ãôW<\èÑ¶\Ù”\ä€c8ôõ¤®\ÑdB¡”õd\Z«&›œ¦\è\ÎIùNAüô\ÅZŸr>\Ç\Ù~\Zø­\á¼0ZjB\Şò_»kv¾[\ä¶\Õ\\ò…F1\'=88\í+\àb¬It\"º}\â\'‹<1\ZÅ¥kW@¨Q!r$m\Çj0*	=ñO©¬š*Üšl\è2Œ²\0;|¤Ÿaÿ\0×ª\ï\Èpğ\È8\Éùr\â8ª\æD84}¯E|ñ¢ş\ÒW‚\ãn»¢[¼-\"\0öL\ÈcLü\Ç[yé•\é×;ı7ã§/\íšYµ‹°Esl\Å\Ø`|\Ã\Ë\Ü1\Î:\çƒ\Å2ŠEea• cKL“\Ò(¬\Ûèº­\Ë[\é\ÚÆŸy:¦öŠ\Ş\å$`¹$)\'#ŸzÒ¢Š( Š(ª\×\ëÒ¢©n?\Ö¥ELAEQEPEQE&\å2,avè£©ú\n³\Ü\ÛJ[\È¶\Ò\\l\Û\îAÁ\Ç\ĞRm\"”[\n+¼ñß„\ìle¼›\Ä:sA7˜gYXd\ã\î¦I\ë\Ø{\×­ş\ĞÓ¼ø´ø\îu‘U¢e8¥\Î27rÀz¯Q\èsU\è­H´9›y‘9\åc²>§?«ğ\é6p\à˜¼\Ö\ã\æ—\æ\äw\Ç@~‚¥\Í©¾§«\Ó&š+h$yR(cR\ï#°UE$’z\0;\×\ÍZ\ç\í¯]‰\ã\Ñ\ì-l#p¾T<\Éc#\äü­œ\áQšó=s\Åúÿ\0ˆ\î<\íWU¹¸!İ‘ZC¶=ÿ\0x(şp8p+\Ş\Şk¢¾Dl\ê¢\ã8\ÎzÃšÓ·\Ğ\ÇŞº“w\ê\ã$Ï©ü1[T96h¢‘ôÏŠ~7ø[\Ã\é$vr¶©zŒ\É\åC”@A\\„‚¡\ÇPk\Å<eñ£\Ä~)óm­\äş\ÎÓ˜‘\ä@p]~a‡=[*\Ø#\îœgh¯6¢›itUE%wys³3z±É¦\ÑEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE2Hb˜,h\àve¡{Y1˜±€•¥P‘\Ş3”fS\ê+KKñ&·¢y\ß\ÙZµí—7\ìó²o\Æqœq“ùš(¬\íV$µ‰#o\Ê\İ\É\éZ\çd¿¹\\bOütQEK“¾\çE8E\ÇTtšÄ¯\ZY^´±ø—P‘˜\"\æ_=pNxY2\ã¨ü\ÍvüVñ«g:\×şJ\Ãÿ\0\ÄQEg^\êw‹0o\áş\è÷ö¨­õ;Ç¦\È\'Ÿ”…Rr—shÒ‡dh\Ù|Lñ|°³>¯’ñ\í·ûb\ã\âG‹#·g][_³\Åÿ\0\Ä\ÑEw\ZnŸky¦A,ñ³;’—<ŸCW\×K±Xü³m®sûÁ¿õl\ÑE]\Û8\ä­\'c\Ì5Oˆ2]b\é\×\ÄÚ¢î¶Õ¹`£<ğ£€=€À®v÷\\\Õu+ç¾¼\Ônfº|o™\ä;›\'\è\0ü(¢­*ª(UT\0\0´QA%b\ÌY‰$œ’{\ÒQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEÿ\Ù',9,12,1994,'\0ø\È*\ãs\\ÀA7	«q°¯U’\ä)ÁŸU¸)7\Ş-X°5\Å\è$\â³hõüú­(¹Œ\Şõ\â\Şò\áxWº\r§B0,ıƒ(µ^C-\â-:7\ÎWv\İp\èJ\éCE#£{P(<úbt2B,\È\Æ_	¹ùÓ¤b–i‡T/Í„\ÎK›´Ù¹óO\ÒS9p\Ïh0ü\Òb\à\çƒ\æi\ítIL§C.R®´”©,x„\Ù_r \ä6\Û\èÀ)h\ÈGÏ¶2š\âvyW\å<\ì\İŞ‹f\Ş<\Ù‘M×¯eıt\ÌMó-k\Å\ÃG\Ów3H—*Mlz\äjõö•€«?]2Œ\åYÍ©ü“şuNø\nòid«^\Ç\ê_”1Š­O@…@%z\É\ë\ÙnewÁ\ç\Ù3è¦0[\ÉÒ£\Ë\Ş\İÂ€ªXŠ¬n\â?Sd%\×{0c©ºqQ\Äq\êURSR¿‡3a\é³[\ÒL1˜SUK\È\Ş\ßÎˆù¦B‡\Ğ\Æ(–Jƒ72ŠÊ·œ¥¹\åZ\ç\êt›|\ÕÇ¦ıò\à\î\Óo\0ø\È*\ãs\\ÀA7	«qp“U’\ä\è\í\ÄLyİ¸‡‹n¶Q\æZ¦¼?)Ş¾ PEø!:\×a¯á&÷­GJö6Yb\Ûñò\Ø\'ˆå§­\Ü\Öô!\Ö[v8x]Qq¥rlf¸üV6cP\Ê%ÍƒùòJ\ÚL2zC\ÅS³Aœ\Ì[ñ„Šğ~R€\â3ù3)g\ï¶P{Ü™]£ zufû‹ô–˜„\Äù½\î\\±fnÇŠñ±=€i\"\Ö	ÿÀ\Ze[S¨9>`¼½?\ndô[ß®•õ\ÍIf6o4úQ\Ö:†VØÔ¶\åsªqŠG\×ašŠó´_óŠmO$\Â\Ê)±B­z«–bÆ z¦@ğh`‚\é&\ŞBi\r¶^ò\Å\Ñ\Ø\Ö\ĞQ” ²r)_¾ J.z\ïmüÀU6\é¦¬\\D–\Æ&]Dø•\ái\r+móS\n\ã€\Ù~B½´\ÄZ\Ì\Z¾\Ñ\Ú\ÇR\ÙÀ\æ\ÖI›\Ø\Ï|X¡\Ñ457£_~JbWM\Ò\" ò:‰¿\Í@­r*\Z¼o\0ø€\È*\ãs\\ÀA7	«qp“U’\ä\è\Å\ÇHxç¹´…š‰\ÊùFG°…}‡~\\º\Ô\í›eØ‘\ài±\ÃA½ş)H,\Ë©ş¦uN^–ªdB\Å\ÃÈ§ºş¾¢\Úi\ßaŠ¸•Á\Æ\Ãj•Hó„Hr”w}\á:•–\é«L&!\Õ?²Aa\ÕY\×Y\ìµ\É@\rü²r\ä\íE™åœ©ƒ^\'‡¸÷Q¬\Í_·³\âsb9:ƒE°=*\í¼ø-ˆAeÕ–¹ƒXõJ\å™\ÖFğ±ğ\Õa\Õ?½ı\'\ç\â\ÎõŒÿ¥¨#0\Ü\Â$\é{\ë\ê†\Îk\ë7\n@‹D…š:¾o-05*;wN™\\\0yrË«1<i}\ë\ì3¾}º¤ğ^\ÛÀG\İt\ãµ\02-\ëZ#§x\à –Äœw\à\0>\Â\Åß›ú\àFº”6\âŠc+\ê\æT‚“E%)/ÀƒÆµóà²¸×¦ˆ®Ò‰¾\åğs\ÈB(\äŒRF3œôDS	­)¤Qyfe¾TÇ¢?N0Aë¼¬(\ÛU\ïL½‚!uy\Âo\0\è\È*\ãs\\ÀA7	«q°¬U’Œ\ßD\æˆê„€ù\Ê{;(\'(”KB\Õ,7\Ò\\\ÙûoY\Í×€@ó¨¦™\è§/\ë\ëb\Êb6“µ9pLŠ+0+V1©$\Ï2¡EM\Ä\é¿/j|=a\nnÁX›{\Î\àj¤1\áo¿ªˆ\Ò\Ë¼É‰Yôpºm\0\0Fª\ĞO\È$¢\ä\íi5xa\Ù\ÑõøÜ—¯ı•\\\Íü\Ü@r2G–©#sµ\Õ+on i\ç›\ØP\ÏKƒõ-p5\Çp°\n…W\á€&ö%‡îŒŸ\\\Â\à0%T¾\ËR\à\ÒL\â\Z†´ö`MGXVÁ¨†¡p¨,Î¡{´‡\Í\ï\Ä\Ê÷cÉ±©/\ãi\İ5Ÿ*œq\ïu‘˜—\éFK\ï‡\Ër^Œ5E7—/\Ó\å\à#=‹%\"³òM\à\éƒTM!\ĞÂ‡Š…tg³ø)pÏ¤TN p\Ïúe\åjj\ÚC)b€\Ò~{•JK1©RU\Û\0\â\Ş\ï\ÈnÉ¯_\ÙS+«˜\Ë\á£M\á»\\\ÕoOY\é¨~ »0• o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2017-08-28 20:02:08','2017-09-12 21:47:57',NULL,'1234'),(5,'1094925466','Christian Camilo','Bernal Rojas','1992-09-02','3153946037','Bernal_9219@hotmail.com','1','ÿ\Øÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0dd\"\0\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0\0?\0÷ú(¢€>¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š†\æ\î\Ş\Î?2\âd}XõúzÒ””W4\Òm\ÙV j\Ş!¼šFŸq{?XP¾\ìz(÷8©¨®jó\ÆFJ\ÚBÒŸ\ï¿Ê¿—_\åX7~ Ô®ò\Z\àÆ‡øbùG\ç\×õ¯\á(\é\Ìü¿\Ïü®wRË«OW¢ó3¨¯lğ\ß\ì\ç¬^›\Ä:”:z	··t¿B~\èú‚\Õ\ë:Á\ï\è\Z=/gQ:üù\Äû\í? ?E\Ş\\^[ZŒ\Ï<qû3\0*ËŸ\ÅZdY\ÒL\ØOñ\Åp„–$’I=\Í%xÕ¸¼¿‡¿ò;\á•S_lù3Iğö³®\É\å\é:U\å\é\Î	‚p¿R\ã]\æ•ğ\Ç\Z\rÅµœ§½\ÕÀ\'D\İúâ¾¯4†5$TEUQ€°§WW7Œ\Ï\"/\Å\ßúıj”.\Ô_\î¬	ôB™¬\Z+Î©›\ãg½Gò\Óò:c\Ã\ÇhŸ?\éÿ\0³Iù[Rñ(Ş\Ú\×ù37ş\Ë]-§\ì\ï\à\è3\Ü\ê\×\'‡ñ\Ôõ¯[¢µ›Äº³gı+\Ú5ÿ\0\nˆëº¡97²~Es¼n&[Ô—\Ş\ÍV’\Ú+\î<ú‚?¡:‘‡ñ=\Ü\Ç?€|~•v?„¾/†­\Şgcù–\Ív”U§\Öõ2\çı:Á\Í9<A«GŒ_Hqı\ì\çY\Ï÷6š\ÅWZ©¿½ƒ£OùW\Ür‰ğ\ÏÁ1 EğÆ˜@şô\æyª\×?	|w¿\ÌğÕ¢\ï\ë\å3\ÇùmaÂ»J+i<W«©É¸Wöh\×ú\n¹oT6\Ú\İ\Çû9Sü\Ís4VğÌ±pÚ£ù»şfr\ÂP–ñGœ\\|ğ\èV=&krŠ+\ÉI÷\Ó\\õ\ï\ì\İ\á\É\"ac¬\êHz¼¹T~Tşµ\íWm­[ı}¤±ÿ\0¸Á¿Âµ-¼E¥]\íi>\\~\'ŠóZ+º–Š‡\Çi|¿\È\ç[F_\r\Ñóf§û6\ëp\à\éz\å…\Ø\î.#x\áÿ\0\ÌW«ü%ñÎŠ\çğı\ÄñÀ{B\'Ï¾–\ê}•Ezê²º†V§¡ \Ò×”[\Ş\\\Ú6\ëy\äˆ÷\Ø\Äg\ë[¶~2¾‡\ê8\î\×\î7\é\Ç\é^­!¡=*\Å\Çñ_\çøU2Ê‘øÿ\0\à9b’	^)£x\äC†G*}4\Êû·Wğö¯\Â\"\Õô»K\Ô\0…ó\âW?\İ\'}\Åy‡ˆg\rj“D»¹\ÒeÀ	3\Åù1İ“ş÷\á]\Õ‘c\â]6û\çy2\à—\åızV½{t«Ó­jrMy|\éÎ›´Õ˜h®û\Ä\ß<e\á­ò¶ı¡h£?h°&P>«€\ã\Î1\ï\\\rQEj@QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE#:¢v\n d’p\0QE>e¹8 ‰\åšF\n‘¢–f\' \0u4µ^òú\Ú\Â/2\æU@z\Ôız\çõO*n‹OÛ¡™‡\è;\×)<ò\Ü\ÊešF‘\ÏVcšùüv}J\áCŞ—~Ÿğ­OO–\Î~õM\â2µü=\á}k\ÅW\ßc\Ñtù®\å\ŞPa#¡f<(\àõ5\ëıŸ\îoZ‡‹\İ\í¡?2\éñ0ó¶\Ã\îa\Ï=T\×\Ğ\Z^“§\èš|v\Z]œ6–±ıØ¡@£\ë\î}I\ä\×C¨xºyr–)\å\'÷Û–?‡Aú\×=4ò\ÜHdšG‘\ÏVc“Q\Ñ_+‰\Æ\×Ä»Õ•ÿ\0/¸öiP§IZñ\ß~\Ï\ZmKŸİ›ùúı–İŠB¿V\á›ğ\Ûø×±\éº]†d–zm•½²r±AE¹À\ï\ïVè¢Š(®S`¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š*\'ûÆ›N¼iµh¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(­?\\¿\ÓH\ÌLcşY¿Ì¿ıoÂ³¨­)Õ)sSv~D\Îš´•\ĞWâ¿†>ñ†ùu9b¼aÿ\0–¿»—<rH\áº5\ØQ]ş›\â»+\ÜGqş)şñùO\ã\Ûñ­úò\Z\ÖÒ¼Ay¥¼\Ûq\Ö\'<¡\í_G‚\â½\ÌJù¯\Õ—\ÜyXŒ±=i}\Ç\Ê~2ø\â?ºÒ³¬\Øÿ\0,‰\Ğ{\Ç\Î~ªO©¼²¾ÿ\0®\Ç?	¼;\ãe’\á\âûªy\Ö\ê2\Çbôq\Ó\Ğğ\0\"½\"Š\Ï\Ó5‹MV<Àø´M\Ã/øzĞ¯§§Vb§t\Ï\"p”,•™ñ\å\Õx\Ó\á\î¿\àk½š¥¶\ëGm°\Ş\ÃóE\'\Æ{7ƒƒÁ\ÆG5\Ê\ÑEU’QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQYZÆ¹•Ñ‰.|±ç§¹ö¬«W§B¥Gd‹§NU%\ËvQ]\çÃ†\ZŸo„§u¦b{\Â>÷ûú·\è:À\Ú\Ô5}6\ßÍ¸|g\î¨\ê\ÇÚ¸mW\\¹\Õ«.\0~X”ñøúš§ww=\í\ÃOq!w>½½…A_™g1M\Â\ì;wõÿ\0#\è0¸Q÷¥¬¿­Œ	ø;Yñ¦«ö\r\Û\Ì+ƒ,\Ï\Äp©\î\ÍÛ¿N8¾¨ğ\Â\İÀ,\Ñ(¼Õ™q%ô«\Èãƒø_sÜ1\ÒøÃº_…ôˆ´\Í\"\Ñ-í“œYÛ»1\êIõ?Êµ(¢Š+\Ç;ÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š(\è3@QQ?\Ş4\Ú«±\ÚÁ±\èsE]¬HQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEø\å’H‘\Ô\ä2œ]–‹â´Ÿm¾¢BK\Ñf\Æ¾¾‡ôúWEv`ñÕ°“\æ¦ô\êº3\nøxV¤A{ek¨\Ù\Ëg{oÅ´Ë¶H¥P\Ê\ÃĞƒ_:|Høq¥ùš¯„c’\ê\Èe¥°$´±¹C\Õ\×\Û\ïtû\Ù\ã\é*+×¨®Añ,–m®\É{^º´\â=¿ıU\İG\"M\ÉFV‚+\íğ8úX\ÈsC~«±óØŒ4\èJ\ÒÛ¹ğõ\Åƒ6¾&Š\ãYğüQ\Ûk|¼‚;³\ß=•\Ï÷º×®\áóİ¥Å…\ÜÖ—p\É\Ä.RH¤\\20\ê§QE\Üs\ÑEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQEd\ëš\ÊiVøL5Ìƒ\ä_Os\íYW¯\n\İJ\ÉNœªIF;°¢Š\ï¾|7ºñ\î²^o2\ZÕ‡Ú®Q\Z´{úOP5\İu4\È\Ì0\×L8zŸğ®YdV–W.\ìrYI¢I^iZI³±\Ë1\îi•ğ†cSR\ïH­—õ\Ôú\\.4#e¿V\\øWğ®\ë\Ç¢şıdƒBñ$ƒ†¸aü	ıOo¯O«,4ûM*\Âh\í­a]±\Å\Z\áT})llmt\Ë,l H-`AQ ÀUX¢Š(¯<\ê\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š*9\çŠ\Ú#$\ÎGs\\õ\ïˆd”´Zÿ\0|õ?\á]Xl\\C÷úT«\Z{…Q]÷0[.\é¥T\ç­d\Üx’È·‰¤?\Şns#\Ê\åİ™˜õ,riµ\îP\É\è\ÃZ™ı\È\ã.O\á\Ğ(¢ŠÒ›\\¾›8F=^µFI\å˜\æY]ÿ\0\Şbj:+Ó§B•?‚)Òœ¥»\n(¢”1SH>¢¬Å©^C÷gr=\îşuVŠ©Ó„Õ¤®%&¶aEV\Ô> `O\n°õSƒZvú¥¥\Î\Êğ¿¹*+‚¶UB§Â¹_‘¼13ú…Q]\Í\É\Új—6˜\nû\Óû\Èü=+~\ËS‚÷\n\É?¸\ß\ÓÖ¼\\N]Z‡½º\î\Êu\ã=6aEU\Ú(¢¸\r‚Š(¢Š( Š(¢Š( Š(¢Š( Š(¢¶´zM*Q¤½£™»\î+ŠÚ…z”**”İš\"¥8Ô‹Œ–^qñG\áeŸ,Zö\Éc·\×a_\İÍŒ	Àşş‡·Ò½Šõ¸f\â–\'Œ«†Ÿ^{\á\íu´¹ü™‰6’›¾\Ã\ê?­z\n²ºF¬29W\Şeøøc)ó-$·_\×C\æñXiP\İ‚/\ì.ô»ù\ìo­ä·º\ÊIƒ¤Uzú\Ë\â\ß\Âøüm¦ÿ\0héˆ‰®Ú¡òú(¹_ù\æ\Ç\×û¤ñ\Î#\å	¡–\Úy \'ŠhØ£\Æ\êU•Á„Ô´QEwœ\Ã(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢š\î±\Æ\Î\ì\Äö†\í«\0¢Š–\Ú\ÚkË¨mm¢ig™\Ö8\ãA’\ìN\0äš«©\ê1i–m<œˆ½Ù½+Î®®¥¼¹y\æm\Ò9\ÉööoY\ÕT½/’!N\"S\ØzıMgWÁ\æù“\Å\Õ\åƒ÷\Ş~\ä}&\ìay|Oú±»\à¯\ßø\ßÄi6?\"Ÿ\âr2°\Æ,}}\0\îHu¯²ô\rOğÖ‹m¤éˆ­m\×j\ì{³\äI®wáŸ€\íüá„µ`©Ü%\ì\Ê>óö@º¹ ~\'Œ\×iEQ^9\ÜQEQE\0QEQE\0QEQE\0QEOP\Ô\"°‡sü\Î~\ê§ÿ\0­S]Ü¥³\Í\'E\è=O¥qw72]\Ü4Òœ³~@zW¥—`~±.iü+ñò9«\Ööj\Ëp¢Š)n\ï&½—Ì™²{\Ğ}*\n(¯ªŒc\Ëdy­¶\îÂŠ(¢Š(ªQEQE\0QEQE\0QEQE\0QER‚A\ÜRQ@Q[\Úf±¸ˆ.›‹!\ïõ­ºá«¢Ñµ:ıšVÌŠ>RˆW™e\ê)Ö¤´\ê¿S»]¿vAEV½Q^\ØQEQE\0QEQE\0QEQE\0QE\Ôø[]û;®Ÿrßºsû¦?\Â}>†¹j+§	Š\Zª«ø#*\ÔcZ\nñ?´\í\åñnûd	›\è\× ÿ\0–ƒı¥}@õû}\ë\ÔV†uŸ\íSo;f\æ\É\'ï¯¯\×\×ÿ\0¯[\ÕúE%V3\æ*Ò•)¸Kt|EzÆ‡c\Â\Z\è\Õ4\è‚\èÚƒ’ˆ‹o/S ’¾\Ùùr|ºŠ(¢·3\n(¢Š(¢€\n(¢Š(¢€\n(¢Š\å<YªôÓ¡oF”\Ñ¯\å]¥|šu„·/\ÉQ…­\ØW›K+\Í3\Ë#w%˜\ä\×\Ïgø\ïeO\êğz\ËOø\'©–\áù\å\í%²üÂ½÷ö~ğöo\ê|«º-=Xu=OÃ•ğ/jòxb\ç\Æ+±\Ñm÷(™ó4€«ˆr\íùtõ$õöÆŸam¥\é\Ö\Öq­­£X¢Aü*£\0S(¢Šø\Ã\Ş,\ÑEQE\0QEQE\0QEQE\0QEQE#0U,z“@Q\\Ïˆ.Ì·B\İO\É_v5OšC4\Ï+uv,\Ze}¾\ZŠ£J4\×CÆ©>y9QEU\í;G¿\Õ_m»HÁ~Š>¤ñ[QEQ¢»›/‡„€\××¸=\Ò\Ï\êÂ¶\íü¢@\ëw˜ú\É!şC«•“Î‚Š(¯+¢½=H‹\îi¶¿S\'õ«§\Ù\'İ³·_¤J?¥>A{@¢Š+\Å(¯_\Ê\ÔLÀ[B§–*»iz{Œ5±úÄ¿\áK”¤ÂŠ(¯(¢½6_\r\égu’/º¿\È\ÖeÏ‚l¤\Û\ÜKz6Cú\Ò\åc¸QE\Â\Ñ[wşÔ¬Tº ¸Œ\\‘õk¡¥`\n(¢Š|R´2¤¨p\Êr)”Ri5f=‚Š(®\ÚVxUû®ú\Ê\Ğe\ßbÑ“\Ìm\Ç\Ğóş5«_ˆ¥\ìª\Ê™\ëS—4S\n(¢Š(¢±,(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š±ey-…\äw0Ÿpz\Ü\Zôû;¨\ï¬â¹ˆ\å$\\oQ^Q]?„5O\"\å¬%o\İ\Ìs{?§\ãı+\İ\Èñ\ŞÆ¯±›÷eø?ø;}Ç˜\áı¤9\ãºüŒ¯øz\Ç\Å>¼Ñµ&\Ş\å6\îyª²ûƒƒøW\Äş \Ğ\ï<7¯^\èú‚…¹´\Æø\èÃ¨a\ìA{_v×Šş\Ğ>ş\ÓÑ¢ñM”D\İ\Ø(\è($¼ğ\ßğ&$Ÿ”WoEW\ÚóUQEQ@QEUmB\íll&¹l|‹s\Ø~u3š„\\¥²b\ä\Ò]BŠ+g\Â^›\Å>+\ÓtXI\ê`®Ãª \å\ÛğPO\á\\—Šõ´_D?»ƒ\ï{±ÿ\0ñ®zœ\î\Ò\È\Ò;v%˜\ä\Ókó\\^\"XšÒ«.¿\Ò>²…%Jš‚\è}	û?x<i>—\ÄW1w©ü°\är)\ãé¹?@µ\ìU\r­¬6pZZÄ±[Á\Z\Åj8EQ€°¦¢Š(®sP¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(ª÷Í·O¹9\Æ\"o\åV*®¥ÿ\0 ÛŸú\æ•iE^¤Wš&\n(¢¸š(¢¾\èñBŠ(®£Â\Z»›»°Eœm€£ƒ!ôúW¤\ÃVğ¬PÆ±Æ£\nª0V\ÒmV\ËH´·A€‘(?\\dŸ\Ï5rµJ\Æ2waEQES$(¢Š(¢Š\0(¢Š¥qş½¿\åQT·\ë\ÛğşU#e°QEQE€(¢Š+^ğ\ä:”M=º¬w`g#€ş\Ç\ßŞ·¨£q…Q^<\ê\È\ì\n²œzƒI[,·X5\éJ	THG¹\àÿ\0*Ã¬\ÆQEnxt\×\Û\nn\Ö‡\Ö\\}ú\Öõ|gşõ/—\äO\rü4QEQEp…QEQ@QEQ@QEQ@QE9£utb¬¤GPi´P´\0¨®­ ½´š\Ö\æ%–\Şdh\å\ÆUÔŒG¡¥¢½KK¿]KN†\åp:\áa\Ô\Õr¸Ÿ_˜®\ä±sò\Ê7 ôa\×óÊ»jı-\Å}k\Z}Ÿªş®|¾*±ª\ãÓ¡ñü/?ƒ¼]¢Ë¼\Ç\î‚Fÿ\0–‘Q³€	\ÇdÚ¹úúKöŠğ¨¼\ĞlüMoó¬XAr\Ã0¹ùIú9Àô\Ğ\×Í´QE\Üs…QEr¾1¼À‚\ÉO_\Ş?òÖºªóm^\ïíº­\ÄÀ\åK\í_÷G¼<ÿ\0ì°¼‹y;|º[K·3\è\ï³†\ÃÏªøšeG‹+s\îp\Ò\Ë`üMx%}­ğ\ã@ÿ\0„k\áş§2˜@%œÈ‘şv\èN?\n£EWÃŸBu4QEQE\0QEQE\0QEQE\0QEQE\0QEWRÿ\0m\Ïıs?Ê­U]KşA·?õ\Ìÿ\0*Ò‡ñcê‰Ÿ\ÂÂŠ(®&Š(¯º<P¢Š+\Û4ùºm¬€\ä<(\Ùõ\Èb¹¯\êM}¢]pÖ§\ËİŸ¼:ğ®–µ[5fQEQE1QEQ@QT®?×·\áüª*–\ãı{~Ê¢¤l¶\n(¢Š(¢QER;mFoAš\0(¢Šó\ï¸mxü1(?©şµ\ÏÕFñµ\rBk§26q\è:ùb«Vl ¢Š+oÃ¿\ë.>‹ıkz°|;ş²\ã\è¿Ö·«\å3O÷©|¿#\Ó\Ã\rQEQ^y¸QEQE\0QEQE\0QEQE\0QEQE\0QE-µ\Ã\Ú\İEqß\ÃÂ½V	’\â\æŒ\å$P\Ëô\"¼–»ÿ\0^}£Gò	­Ø¯üò?¨ü+\è¸{\ËVT_\Ú\×\æ¿\à~G—šR¼EĞ£­iVú\î‡}¥]gÈ¼\ár1•1‘\ã¨÷ğ¾£a>•ª]\é\×@-Å¬\Ï €\Ê\ÅO\ê+\ïjùW\ãöı“ñûF4a©Íœ\0¾bü\à»\ÖıQ_^xg•QEOU¹û•s88eC´úÀıMy¥v¾0Ÿ\Ë\Ób„e“Ÿ \ãŠ\â«â¸Š·>%SşUø¿\éşWZN]\Ù\ÑxD#ñÖ¥:Š{•2©\ï\Zü\Ïÿ\0«WÛµó\ìë¤‹¿\Şj.™[3´ú;ş:¾Ÿ¢Š(¯\0ôÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢ª\ê_ò\r¹ÿ\0®gùU\ÄFw£,N\0®Š\×H¶Š³F“;›x\Èú`\×~_ƒ©ˆ¨œv[³ŸZ4\ãg»\n(¢¼nŠõ\Ûÿ\0\é7ğ²5œQ9I\n„`¿yi\Ó\æ\Z©Ó€\Ì\Şw“ø\çö\rXòT®QEv\ß?\ã\Â÷şº¯ò®Î©\éšm¾•c­º€ª>f\Ç.{“W+D¬Œ›»\n(¢Š(¢˜‚Š(¢Š( Š(ªW\ë\ÛğşUKqş½¿\åQR6[QEQHŠ(¢™7ú™?\İ?ÊŸE\0QEx\í\Ğø³IO¾I\à]°\Î	\Ú:+¸­h·Bú\î1)v\"4oº\0\ã8\ï\Îj-­Š\n(¢²|;ş²\ã\è¿Ö·« [4R\Ö`\í@?•e\ßYı™\Ã.Lm\Ó\ØúW\Ïf¸*Šnº\Õ~Gv\Z¬m\É\Ô(¢Š§EWˆvQEQ@QEQ@QEQ@QEQ@QEt~\rºòµW·$\í3\êÃ‘ún®r®iW?d\Õmg\ÜT,ƒq\İ\èL\×V\n·±\ÄB§gøuüqö”¥ ¯ ı¢41\àk]Y#]6\ènr~\ìR|§ÿ\0ò\ë\×\ëŸñÎ5\ï\ëz`‰d’k9<¥n`“ò`¦½JŠ(¯\ÑÏ•> ¢Š+Œñ”Û¯\í\á\Ï	\ïÄŸşµsu¯\âi<\Ízq\Ù¨ü‡ø\ÖE~s™\Ôö˜Ê\Î\ßv‡\Ô\á#\ËB+\ÈúOömÓ„^\Öu/â¸¼X?\Ğÿ\0£\r{ey\×À\Û5µøQ¥\È\Z\âI¥o¯˜\Ê?E\è´QE\Ât…QEQ@QEQ@QEQ@QEQ@QZz$\"K\Ã!\ê\×#\êÉ®†±47N;\á­m\×\ØdñKš\ë\ÎÇ‹Œm\ÖaEQ^º·\Ä\ç^\Ë#Iø\ì\Ïó¯@®\"\Ú‘ñK†¶˜B\Ì\Ë\æ;~\æ3«Ò—C=BŠ(®ŞŠ(ª$(¢Š(¢Š\0(¢Š(¢Š\0(¢Š¥qş½¿\åQT·\ë\ÛğşU#e°QEQE€(¢Š(¢Š\0(¢Š\ç<i}¤À\çØ‚+CÃª@³û™ıMTñrK.Š#†\'‘šU\á“Oj» «&…h®¬ŒX`iuQE£P^F%´‘{\ã#\ê*zl„Ø˜55b¥³C‹³MQ\\\ÅQ_{AEQEPEQEPEQEPEQEPEQEPEW«\ÙLn,m\æ=d‰\\ş#4U\r9“\Ãö„@+ù1W\éxiûJ0ŸtŸ\à|XòÔ”{6|%\â=tŸjºj}\ËKÉ ^s\Â9_\éEtÿ\0­’\Ó\âÆ½\Z’9?‰ş¬h®/Y}ú\Í\áÿ\0¦¬?#Š£Vu[Sº\'©™\Ï\êjµ~mˆ|\Õdü\ß\æ}]%h%\ä}9ğ\Ò\Û\ìŸ\r<9\Üf\Â91Ÿ\ï\ßû5uU…\à¥	\à?¢ô]2\Øûôµ»EQYQEQE\0QEQE\0QEQE\0QEQE\0QE_\Ñ\ç\ß\'‰\ßÇµtµÅ‚A\È\à\×Caª\Ç2\ç`’2x\r_C“caº»‘\æ\ãh6ù\âQEi\ÑH7B\Ğ\Ò\×\Ñ\ÜóBŠ(¢Š( Š(¢Š( Š(¢Š( Š(ªW\ë\ÛğşUKqş½¿\åQR6[QEQHŠ(¢Š( Š(¢Š( Š(¢ª\ß\Ê\"³~ya´~5,—D¹y~<\Ö%\åÙº—<„tW˜\ã!F“Š~óş®tP¤\ç$\ŞÁEUj(¢¾DõŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(®ûÁÏ»C#û³0ış´S<ÿ\0 i¿\ë\á¿ô¢¿C\Ëğtı˜\Åÿ\0^§Ê¿´%°ƒ\â`u\Æ)>…—ÿ\0e¢­~\Ñ\Ã\ì=ô¨ÿ\0ôl´W\'ÿ\0!¯ú\êÿ\0\Ì\Õzµ©®\ÍV\íy\âg\ëşñªµù\íej’^lúj>…ğoüˆşÿ\0°m¿şŠZÛ¬I\æü?ğ\ä™¶—lN:g\Ê\\\ÖıQEfXQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE§¢K²ô¡\è\êG\â9ÿ\0\Z\èk¶—È¹_\î°\'\é]x Œ•õ9^j.Ÿgùÿ\0LòqĞ´Ô»…QEQ^\Ù\ÂQEQE\0QEQE\0QER¸ÿ\0^ß‡ò¨ª[õ\íø*Š‘²\Ø(¢Š(¢Š@QEQE\0QE\ä]¤­ş\Î\ã\ÅOYº¼¸\"X\ä\×66¯²¡)ù\ZÑ4\Ò\n(¢²(¢Šø“\×\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢»¿ÿ\0\È\Zoúøoıh£Ác\Z4¿õğ\ßú\n\Ñ_¡e\îtı˜\Æ^§\Ì´wü”=?şÁQÿ\0\è\Ùh¦şÑ­Ÿˆ–#\ÓKŒ\äYh®s]O/\\»¯ŸÏŸ\ëYÕ·â¸¼½q›şzF­ı?¥bW\Âc¡ÉŠ©7ùŸE†—5¿${w\Âk¡yğ³\Ãòƒ÷m¼¯û\á™?öZ\ì\ëË¾\0_›Ï…ñAŸøó»šÌ‰?ö¥zQEr›…QEQ@QEQ@QEQ@QEQ@QEQ@QEtúUÇŸb™?2|‡ğ\éúW1Z\ZE×‘w±\É\'\ëÚ½,«\ìq\nûKOò9qtù\é\éº\n(¢ºJ(¢¾\ÈñBŠ(¢¦¶…g—c>Ó8\ëP\ÑMo¨=‚Š(­/\ì¥ÿ\0§şù¥ş\Ê_ù\êïš­¡<c‡\íU…\ÕGñD[\'I˜5QQPÉ¡+¹o´Ÿöúô\ß\ìÿ\0Ÿƒÿ\0|ÿ\0õ\éòk‘\Æ\Å|–${\Õy5\éHı\Ü*¾\ìsMû×¶aEQs£\Åmnòµ\ÉùGoS\éÖ²*Y\îf¹}\ÓHXö‡\áQVqo\İGD’÷ÂŠ(¢Š(¨((¢Š+Ÿ¿›Î»rÊ¿(ü+^ú³\Û3ó7õ®~¼\ëğ\Ñ^¯ô;°\Şl(¢Š(¢Šùó¸(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Šô/	E\å\è·üôvo\×ÒŠ· \Ã\ähVi\ëû\ëŸ\ëE~‚‡&\Zœ|—\ä|®\"\\\Õdü\ÙògÇ›Ïµ|T¼‡ñ\ëo==P?ş\ÏE`|P\Ô?´ş\'x†\ãm¼h9ÿ\0¦xÿ\0d¢°üg$´œ¡ş#ùš\åk¼ñU¿¢³\ÌNúZ\à\ë\ãs\ê\\˜\Æÿ\0™\'ú~‡»—Oš‚]Wıšu-\Ö\Úş–\Ì>GŠ\â5\îrXÿ\0\ã©ù×½\×É¿µa¦|N¶P·–Ø’x\Ç\ê€~5õ•QEx\çxQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE\Ò\é·\ëuGa\ç(Á¾õ~¸\ÅfF¬U‡BJÙ³\Öú%\Ğÿ\0¨şb¾››\ÂQT\ë»>ııO/ƒióSÛ°QEµE69T†S\Ü\Zu{©¦®¬QEQE1QTn?×·\áüª:–\ãı{~Ê¢¤l¶\n(¢Š(¢QE#2¢–b\0Iª\×ğ\Û\äg{ÿ\0uk\"\æò[“ó/e+\Î\Å\æT¨+-e\ÛüÎŠXyOW¢\n(¢–ö\ë\í3d}\Å\áGõª\ÔQ_+V¤ª\Í\Î[³ÒŒTUQEQE™AEQEPEQEPEQEPEQEPEQEPEQNE.\êŠ2X\à\nmiøz\ß\í:\í¢öWó	ÿ\0wŸ\éZQ¦\êÔ5Õ¤EIrEË°Tw\Çkm-\Ä\Ì(»±\è\0&¤®/\âÎª4…úôÀ)i­şÊªN3\æ‘\Ç\Ğ1?…zDQ,0¤I÷QB \âŠ}úbI+#ä›¹ñ\åõ\äÚ¡s}pA\æVšB2\ÌI?©¢«\ÑQ]@.m&ºH…1^^\èÑ»#2œ\èk\Õk€ñ-§\Ùu™X$ß¼S\×õ\Í|\ßaù©Â²\é£ùÿ\0_‰\ëeUm)S}Kú&©&‰¯iú¬#2Y\ÜG8\Æv°8üqŠû®\Ú\æ\ËHn­\ÜIÈ²F\ã£)ò5ğ-}sğG\Ä?Û¿\r¬\á‘÷\\i¬l\ä\Éş\å?\r…Gü\Ö=Q_ {‡£QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE$3\Ë\î‰\ÙO·zÚ‡W#‰“?\í/øV\ëV\ë\èò)>Y«\é§\êpc\"›AEWE\ä}\É>‡ƒS\×-R$ò\Æ0’º@\Õ\ïó{§\Ø(¢Š×¸ÿ\0^ß‡ò¨™‚Œ±\0{\Ös\\L\ç-#õ¨\É$\äœ\Ñr\ÔBŠ(«\Ïy\ZıÜ±¬\ëÛ¹˜(\rµNrU®ÿ\0ƒñ®\ÎMaf\Ó\íù£|<W´AEUj(¢¾<ôÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢º¿\Ú\æ{›²8U¯\Ôòüë”¯Iğ\íŸØ´HŒ<ƒ\Ìo©ÿ\0\ëb½œŠ‡µ\Å)=£¯\èÆ§%w\nğ\ÚO\\TÓ´m\n––V¼”g\æP ¢q\èw?ıó^\ï_|\\ñü$uI\ÒBöö¯ö89ƒ‚:‚û\Ø½Z´QE}Áó\ÇEQX,²ûFš·\n>x\'ı\ÓÁş•¿M–5š\'‰\ÆQÔ«PkŸ‡XŠ2¤ú¯øcZ5*Šk W­~\Ïş&ş\Èñ¼šD\Î\ÛV‹`\Ïi“,Ÿ˜\Ş=\É\äµ=\Üú}õ½í¬†+‹yX¤U\Ô\äÀŠòª*\Åõ£\Ø\Ş\Ílù\Ìm€}GcùUzü\Öpp“Œ·G\ÖFJI4}ñEcxS\Äx§\Âúvµo´-\Ô!\Î\Ç\è\ëø0#ğ­š(¢Š‘…QEQ@QEQ@QEQ@QEQ@QEQ@QEQ@Q@\ëV\ëk\ÃşûN\Û\Ë\Äı\ÏTŒÿ\0¹öşu­y\á›Iò\Ö\ì\Ğ7 \å*úÜ—ZI+sZÇ‘‹\Å\Ó\ç\ä\ìQEqôV•\æ‡}g–1yˆ?Š>Nµ›^«‹[™\ÆJJ\è(¢Š(¢¦·µ\éöA\È\Ù>´­q·mÂŠ(¨jµ\ßğ~5\Õ\ÙøVW\Ã]\Êq9?ŸO\çW\îü1aqb`‰<¹+.rs\ï\íYc0uk\á\å\ïÿ\0\äS\ÅS…D\ØQE\ç”T÷–sXÜ½½\Âm‘\"=GµA_(¸·+4{I¦®‚Š(¢Š(©QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE{H±:†©¾2…²ÿ\0\îMz…rş\r\Óü«Y/~i~Dÿ\0tuü\Ïò®¢¾\ß\"\Âû7;\ŞZüºŸ\Ìù\ìÆ·=^U²9Ÿˆ>&_	xSÕƒp‘yvÀ÷•¾T\ã¾	\Éö¾&¯lı¢<X/µ\ËO[HL6Ï¹¡™‡\Êû¨s\Ç÷Ï¥xQE{G\0QEQE\0QE\Ìx»Nó!Kø\×\æO’Lzv?Ÿó®>½RX’h)28!\î+\Íõ;\Óo\ä·|Qñ/c_\Ä/gQb#´·õÿ\0‚{¹f#š>\É\î¿#\ÜgŸ=N\çÂ—r\â+²g³\É\é(2ş*3ÿ\0>µôu|eyq§_A{i+Cso\"\Ë‹\ÕX‚?\ZûWÀ\Ş-¶ñ¯„\í5ˆ6¬<»˜”\çÊ”}\åşD{jQ_8z§GEQEPEQEPEQEfg¾\êzõ­=Zó\ä¥³:•aJ<\ÓvAEUjP	8&µ\ã\Ó`O½—>ı*\ÒF‘Œ\"*ı{ô8j¼õ«%\Åÿ\0—\âyusŠQ\Ò	¿À(¢Š\ÄK;‡\é¯:irŸ¾ê¿­kQ^µ.\ÂC\ãn_;~_\æp\Ï7¯/†\È(¢Š º\\c\ï\È\Ç\é\ÅL¶\Ëÿ\0,ò}É«4W£O+Á\Óøi¯¿™\Ë<n\"{\Íş_QE\Ğè³‰,\Ä=\â\àö{V•rúu\ÏÙ¯‰\Â•¾•\ÔWSV\Ñ\Å\İjQEBÿ\0M°¹ä¹\0³J\Ò©?\ãW\ë\Ï~ \ëó)\ZM¾ä†f“ûÿ\0\ìoZ#wc,N)a©ºŒ(¢Š\Òğ\ìz¯%Áå™¡|l—Œ¯f\0uüŠë£\"@‘¢¢Š£\0W„\éZÆ‘¨\Åyl\Øt<\Ì;ƒ\ìkÛ´\ë\èõ+®£C¨%ª\àû\ÕNŠ§ğ\ìs`3b\â\ÕO‰QV©…‰\0I4µ‘\âÏ³işRœ<\ß/\á\ßü?\Z”®\Îö\ì®QErÚœÉ¨\ß\Ë;.A8\\öQÒ¨5œG¦\áô5bŠÎ®\rWY\ÓMúk÷“Uh|2h(¢Š¦\Ö_\İ\ÌTmi(\èú\ZĞ¢¼ú¼?‚ŸÂœ}ù\Ü\ê†k‰\í?UşAEVS#/\ŞR>¢›ZõÁõAøq^]~’ÖŒ\ï\ëşkü\Úy\Ì\å\ä~à¢Š+6Š¶ö]Ñ¿UYJ6`×ƒŠÀb0¯÷±²\ï\Ó\ï=JªUÿ\0†ÂŠ(¤¢Š+Œ\è\n(¢Š(¢€\n(¢Š(¢€\n(¢Š³§\ÙÉ¨_EkWl\è;ŸÊ«Ws\á(\ÚÚ›\éW\Î0€öOş¿_ÀWv]ƒxª\ê7~‡>*º£MË¯@¬oxŠ\Û\Â~¿Ö®°R\Ú\"È„\ã\ÌsÂ§\â\Äö\ë[5ó\Ç\Ï®µ®§†¬d\re¦HZ\á†{Œ`ø\0%{rXv\ÑC\n[ÀÆ»Q*@)ôQ_¡$’²>]»\ê\Ï$¿¾¸\Ôõ›û\É—72´Ò¹\Ü\ÌrO\æj½QES\0¢Š(¢Š(\0¢Š(¬\é?\ÚV[\â\\\ÜE’˜ş!\ÜV\Å\"„+\Ót§³.•ISšœwA^ğ\Ç\çÁ~\'^ËP+\ÎzD\ß\Ã\'\áœbz\àWœ\Ñ^QEt¾(Ñ¼‰Mıº~\é\Ï\ï@şõú\çõ®j¿:\Å\ág…ª\éO§â»ŸSB´kAN\'\ß\à‚ ô\"Šñ/?Æ§b\Õfm¶Oôó,@«ÿ\0y@\ãıŸ÷N}¶Š(¢¹‚Š(¢Š( Š(©­aó\îN§\é[\İ8¥G…yO”V}\çaU,/´{\Ï_—OóùŸ1š\Ö\ç¯È¶ˆQEQE\ï`QEQE\0QEQE\0QEWM¦\\ı¢\Ír~tùZ¹š·azl¤v\Æ\åe\Æ=ûR’º*.\Ì(¢Š\×\Õ/ş\Í—ı\ëû\äz\×	â€‡Fveƒ®\ÒG \æ·%‘æ‘¤s–c’kñk\ãK‰½0şFª\n\Í¸ù³Í¾ÁEW3¤:¬\Ô“ÁõÁ\Åz‘©6s–É…øuş¿Zó­=¶j6\çşšú\×kZTW<üV§+w\n(¢½d@\èÁ•†A\ÅqZ\Í\ç\Û5e9>Dúÿ\0>\ÏY–\Ò\ÂknHeı\Ùş\á=k2±Œl\Ïfsº\n(¢Š(¢¬\Ì(¢Š(¢Š\0(¢Š(¢Š\0(¢Š*½\Ü{£\Ş:¯ò«Œ)¡®lfbhJ“\ê¿†\Øz®X\Ít\n(¢²h¥`UŠ â’¿0i§f}¢i« ¢Š(¢Š)(¢Š(¢¦µ¶–ò\æ;xWtp8\ÅÉ¤·bm%vQT5­f\Ç\Ãú5Ö­©L!´¶Bò1ı\0õ$\àÜ‘Z\Z’u]@\ìñ\á¥>£°üÆ½\0 \0\0€T\Òôè´»¶’9vşów5r¾û+À¬%?‰\ïş_#\æñ˜ŸoR\ëe±\É|Wñ\âxÂ’=¼ƒûZô46KÁ*qÌ„\Ê=%GC_»´\Î\ìY\Øå˜œ’}k ñ¯‹o|m\â{fğlòAlˆbÚ ş$“Ü’p3\\õQEzG QEQE\0QEQE\0QEQE\0QE\Ù#Ich\äP\È\Ã§¡\ç\ÚŞúU\×Ë–·s˜\Ûúzô:‚\î\Ò\Ûg‚tÜùq\ï^ng—GJ\ÛIlÿ\0OC¯	Št\'~rkK»‹\Èn\í&xn q$R!\Ã#G\ã_^|.øm\ã\Í‹YµP. \ïvótş‡B~=­=_\Ô|3¬Áª\éW¨NA\êwVÁ\î+\Ë\è«ú®•>•s\å\ÉóF\Ü\Ç 0ÿ\0j¡_V”\éM\Âj\ÍK	\ÆqR‹º>ì¢¹?\0øûLñ\îˆ/,È†ò \êÑ›-U<\à÷ö \ÖQE$	\æÎ‰\êy¥9\ÉF;°””S“\èQEmZG\åZÆ½ñ“ø\Ô\ÔQ_ªR¦©S8\ì’_qñS›œœŸP¢Š(¢Š+BŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢¹¾#´OR\Çò\Çø\×O\\‡‹\ß7–ñÿ\0v2ß™ÿ\0\ëU\Ã\â839[\r/—\æQEsğ¶\É\ã\î°?­wuÀ\×wo…û\Ê\r]Cƒ\'—Æ½?P¢Š)ôQEf{aEQEPEQEPEQEPEQEPEV}\Úmœ\Äf «·«”Vô8ªUù\ÖqC\Ø\ãf–\Ï_¿ş	õ\Ù}_i‡‹\í§\ÜQEQ@¯,\í\n(¤$($\0\ä“Jª]‚¨%‰À\0rMz‡41¥\Ûy\Ó\0n¥7ûû¿\ãU<7\áß²½¼Oß‘˜\ã#\î{Ÿ\åüºzúü›+t­ˆ¬½î‹·Ÿ©\á\ãñœÿ\0»†\İF\Í4Vğ\É4\Ò$QF¥\İİ‚ª¨\ä’OA_\'|_ø”|o¬-†Îº%‹Ÿ+\'h“e#\Ó\n8$ñ¸½ñ\â\Ø×š_xzsı˜¶\ê\íş>Hşÿ\0`zÿ\0\Ğ|\Ş-EQ_DyaEQEPEQEPEQEPEQEPEQEPET–p_\Û5½\ÂnFüÁõõ\çú®‘>•>\Ù\è›\îHü\rz=Eqm\r\Ü\r\è6ƒ^^e–C\í5³ıÙ„\ÅÊƒ¶ñ5|9\â=OÂš\Ü\Z¶“pa¹ˆ\àƒ\ÊÈ½Ñ‡u>ŸˆÁ\0\×\×^\0ø‡¥x÷Jó­H‚ş%i²v£>£ûË‡óÁ¯Œ*ö‘¬j\Z©¥¥\İIkwnI#8?C\êBu¯-«ºbn¹-\ÙE]\Ö|?6š\Í,Y–\×?{º}Æ£\Ò\Ó»ÿ\0x\ãò¯š\Ë05!˜ÆUn]~\í¿\Ô\Æ\âbğ’”úx\Ñ^gğ\×\âş›\ãH\âÓµ¸\"qÁLd÷\ï´ó\éœ\ZôÊ½EWßŸ.QEQE\0QEQE\0QEQE\0QEQE\0QE\Äx©÷\ë8ş\äj¿\Ìÿ\0Z\í\ë€ñ\ï\×.O`BşJ+J{^o+PK»ÿ\00¢Š+2»]=·\é\Ö\çş™¨ı+Š®¿Fm\ÚT£#õ5s\Ø\à\Ê%û\Ù/ ¢Š*ıQY@QEQE\0QEQE\0QEQE\0QEQE\0QEG:ï…‡¶k2µ\ë>+I®nÅ´´’ÀQ_#Ä¸v\çN¤V¯Oòü\Ù\ï\ä\ÕRŒ\àújQTµ}cO\Ğt¹õ-R\î;[8s\Ë!\à{Ô“\ØI\àT  ($“€z\í¼;á¿²¼½Pg\ëgø=Ï¿òúô³¡xr-0	\ç\Û-×¯dú{û\Öõ^U“{&«b½\Ñvõóü‡Œ\Çóş\î–\İ\ËrH‘FòHê‘ ,\Ì\Ç@\êIô¯šş.|b:\ê\Í\á\ï\r\ÌË¦r—WkÁ¹ÿ\0a}\Ôÿ\0NŸ{\âw\Åû\ï\Z;išg›e¡)\å	Ä—$t/ƒ\Ñzw9\ãaEQ_FyAEQEPEQEPEQEPEQEPEQEPEQEPEQEPER@ ğA¬[½P³P£9ò»~\á[tR²¿7Pz«\nÑºº1WS•`pAõ¯YğG\Ç=sD»Hu\é¤\Ô\ì—\ÍyIi\ÛòõÀƒH\ìY˜ù-Æ²•b¬#‚\äRWUuc\Úü\ë‡\ìã¨¬+½2{\\¶<\È\Çñ¯o¨\íZ)÷2pkc\î\í^\ÒüG¦®¡¤^GujX¦ô`\Ä=#¡¡£_\n\è>#Õ¼5~·ºM\ìÖ³)\ä\Æ\Äw ğp2\r}\r\àŸšnµq\r‡ˆ-\ÓNº•\Â-\Ämû‚I8İ¸\å*3–\îN\Ğ*•QVA\ì”Tw¶º…ª]Y\\\Ãsnù\Ù,2FÁÁÁA…OEWkûEb­q \à‚\Õb¹[.õ\îee€•.H9´Ğ˜QE\Ğÿ\0hYÿ\0\Ï\Ì_÷Ğ£ûB\Ïş~bÿ\0¾…s_\Ù7\ßó\îß˜ÿ\0\Z?²o¿\çİ¿1ş4Y\n\ì(¢Š\é´,ÿ\0\ç\æ/û\èT\é\"JÑƒ)\èA\à\×\'ı“}ÿ\0>\íùñ®“N‰\á\Ó\áE\Ú\êG\ãC\ZaEUªóQü\ÍZ\í¿\é«có¯G¯0™ü\É\ä\ï1?­iOs\Æ\Îe\îAz…QL®§\Ã\í»M\Ç÷d#ù\ë\\µt~l\ÛÎ\æ?ú\Õs\Ø\á\Ê\ålB]\Ó\n(¢¶\ê\'¸…«ÊªÃ¨&¥¬‹\ÛI\å»wH\ÉSŒûV\'Ò…QZ?k·ÿ\0\Éù\Ñö»ùìŸcı‚\ëşy\ÌQö¯ù\ä1LŠ(­µ\Ûÿ\0\Ïdü\êD‘%]\ÈÁ†qk\ì_ó\Èşb´ô\èd†İ–E\ÚK“ÀR\0¢Š*\İQ@QE$ó\\\Ê#‚6‘\Ïe>¾‚º-?\Ãj¸’ø\în¢%<©\ïşz\Ô\Êi6W1\âøw\Â19Ô¯”Î¿ò\í\ZL\à\à\ä# f¾}ñ\ß\Æ\ícÄª\Ö:Zÿ\0gXr\Ëb^@@1\ã+÷¸ ‘\rciúUÆ¢ÿ\0»b\r!\è>¦º\í?L¶\Óc+\n\í÷\ä#\æoş·µ[TT@ˆ¡T\0\0¥¬e\ï4\å\Ğ\Ş+—cÖ¾!üd\Ó|\"\Óiúr¥æ¬˜f$ \à©Á‘Ó°òJ•¯›|K\ãwÅ·	&¯¨M<q’b‰›\äL’I¦y<ú`\0\0\Ãwy$gvfv$³1\É\'\Ô\Óh¢Š(QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEJ\ëK·¹%±\å\È‰{ŸqŞ±\î4›˜Ê¾jv)\Éü«¥¢šml\'Î‹\Ã9ñ„\'–]Px\ÊE*®1\Ã2:2}M{¯„h=+Po\â[q§Ïƒ›˜AhOS\Êò\Ëü cvNO\Ê+\æŠ+Œ¢º\É\ì\í\î9–%c\ë\Ğşb³¦Ğ”\äÁ1\Ñ\ÆQT§Ü‡\Ğû\ËJ\Ö4\ír\Åot\Ë\Èn­\Û|M§\0\ía\Õ[dE]¯ƒ4\í[Q\Ò.R\çN½\Öt\Î\É!r¬¹8#¦GW¥ø{\ã\ïŠt£Zˆ‡S¶RŠ|\åÄŠ‹Á†	cı\æ\İ\ë\ëœJ*\ä\Ú]\Ü9&\"\ã\Õ9\Ï\áÖª2²1VR¬:‚0ER’d4\ÑõE\ä\Ú\í\áMDA¥\rÖ™3†2H£\Æqó1\È\ÇE\ê}9®ûGñ‡5õ·ş\ÌÖ¬\î\ãqŠ4,­·9ı\Ûa»Ó§=)(¢Šb6è¢Š+\Ïu<\éÚ‹\Äò›\æŒûß‡Jô*\ÈñŸö\í8º.f‡,¸\î;ó\éWfpf8omF\ëu¯ù…Q\\%uš-Ÿ\Ùlƒ0Ä’ü\Ç\Øv\çÖ°´‹?¶^¨aû´ù›\ß\ĞW_W7\Ğ\à\Êpû\Ö~ˆ(¢Š(¢Š\ÌöÂŠ(¢Š*x,®®q\ä\Û\È\àœ\Ç\çÒ“in4›\Ø(¨n®\í¬m\æò\â+x\å™\Â*\ä\àd$\n\äuÏŠ¾\Ğ|ô¸Õ’{ˆT7‘n73ƒºxV\àö=ˆ\ë\ÅAEm[øf\î\\8Gq÷˜~Öµ\í¼=cÕ¦qƒ—<g\è;}sP\ê.…ªo©\ÚQ^¯ş\Ñö\Ñ;Ç i&`¬¥f»$\\|À¨ ©¡\É\éÓ<£\Ä?<Y\âDx¯uYE»¡¡\n¹\ÈÜ $\âÀ?\Ç)oiqvûm\ái|\Ôô½e\áU\ï$\Ï-?©ÿ\0ÎºE\"…QÀ\n0:¡É³E¨<Gñ/Âóÿ\0SW¸N°[\îHm¬3÷w\ÕI\ÈºW‡ø»\ãîµ¬A-i°3&\Û\Í\0	\Ãg\nxÁg>A$,$\Î\ìr\Ì\Ç$ŸsM¨­í¡µˆEjˆ;ÿ\0_Z–Š)Y¾¿»\Ô\ï$»½¸’\â\âF,òHrI$“ú’\Z­EQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QES]E\Ú\ê}\ÍPJÑ°db¬:pEUw\Ól\ä9h»•şU]ôKVlƒ*@\ÃúŠ(©m«X,™³¦ø»\Äz=³\Û\éº\æ¡i¹vHnAb\0\'ƒ×Ïµt–_\Z<yad–±kfEL\á\ç…%s“Y\'¯§J(¬»\ËH\í\ä*…ˆ\Î95\\ƒÚŠ+9JW\ÜQ\Ûxs\ã‹\'±H\î\ã\ÓndPs42³rz…`¾\ÜÒºø[ş À?c\Ó?\ïÔŸü]V,V\ÑY\É2Â r\Çü>•f/\Ş0¹\ÇQS)\Êû™Ñ„TH¿kñG[\İdk]<‘¿¯ûõ3|L\ÖD.ÿ\0f°\Èÿ\0«O÷è¢º[?\Ú\\Z¤¯$\á›9†:ı*ô~Ó‘p\Ñ4‡Õœ\çô\ÅVœÍ´›\èh¢­±\å\Ú\Ï\Æ\ïY\ëw1Al°†cû* €p3œrs\ï\\\Í÷\Å\ß_5\Ùñ\ÜÀ–\îR?N ü?h¢®Eci+h•—£ü\ê\ÅV–˜º\Õu\Ù\'’\æú\âV\Ë\Ê^Bw±9$úóTè¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢¿ÿ\Ù',9,2,1992,'\0ø~\È*\ãs\\ÀA7	«qğ›U’Ü+p#Œ¦eÓ®yOf&ğ1”\Ì<g`O>\Äõ3’w˜\\\ëÑ©\Ì¿I§\â=Õ³\Ê\0\Z\ëKº\éV7P§k‘\Òm\Ç%×„°©´±eÇ¨üÁ&È¬\'¢Õ\Ô=÷\Öô \ÓN\ÚJ(JD¡N™uÆ§ÿ…z\Ï\Ík·B³‘±ŒùP8• °_3´‹HgªF\Ù\n¨\ÒCÑ²\\2¦\Õ K2¢7#sÕ³Š\â~3Æ\ÂHùÁd†±[\0~Å´²¦eƒKxg+hq¼\ïrWsŠO¨V§9\é	#e\á\ÊÁ^U{u§i\"7\ê0^½5ö\Ú$k™y1q…-D\í~ŒµcøˆoQ<\rƒ/—¶¤ÒŠMšGC:TªnµcHŒõJ\êqRoermV<bµ4®‚OÙ£¸£8ß‡›ñVCú ‡7ôŸx\Zş…Á¿d†\Ïş‹g›\ìò÷0>\í§2¹\\y70%…¢\Ùü\Ä^\éñK§ûro\0ø\È*\ãs\\ÀA7	«q0–U’¨ZË^S)rH\ã\áY¯DN1¨F?.\'x\n¢lÁ#\á\ZõÕ™‰t11Ñ¹\è8#\\\Õûğ\ÜIi)\ÛDBƒÙ¼ ô@`\á\Ã\âv[ºÔ‡œ\í1kğ0\äco»ƒ/QÀsC\rII\ã<+U¬\0y¿#l6\İv¦]‹D1„ €\Z\Ğÿ¯°Qi\å‡\ÜuÎ¬™²–\Ù;X¶€K\Ù}‚8øPÁ(·œ\Z‡²\âzü\Ä\â \Ñ!>û=\'#\ãõ´& \ãkVWsšAÁXsiõóOµLPÈ†\î‡m¨s{/h¸Ò®Ñ§n\Ó\Â\í\×\nIU\Ö\Ğ\ndz\É(_]!¶<r•\ì\Â)\n1P%\åm\r¦\å\å¢È†R–jˆhAL\ãJ9¼ë“¸\ènŞ±\Ğ]\n·—\ìüøx¾ò}Vp÷ß¦.l ¥²€\'{\èt›\Ø\æ¶\îp\ìõ?J¤¼o\æ\Ø/¡2Í«\Ó\Şşv}~€O:l÷\Ã\áGEdw\í]™o\0ø\È*\ãs\\ÀA7	«q°•U’\\2*š¸Eöÿ\Ö}GËn·\Şp&’uC\Û9“÷P,¹\"×¥­e\ì4ß‘\Ù`S\äâ‚†iˆ|³;·˜#|¸!K\è–\ë*Œ—Vû\ß\Ô\ÕAb%ËRø\È\àƒ\Æ\n\ç¸eMpF\Z\Ú|V@®p6tÿh¶ (G÷„}`V\ÓŠG=\å\Â;1\Ğ\ê6|<mS\ÂQT\ä\ÑJ¶FN‡c\Éx3\Zx—T\Z\é…/\0e…Bu\è(\'I~p‚EY\ËM÷\"#:\Ã\ëñ’o\ïüœ\n²	\Æñûx\ç\n\ç |‚q!¾\â›ı·E|\Ú_³Áİ¼GXø\äµûv\æE²W5-ı7ƒ<\\@Ü¸\nt\Ú¡Š=Fb™œ\à®\Ìb6A+z\Ôú$\îcK\Î\"D\îû|½#@n¥x\0¿]\İ@\ì-—6~’c\İ7‹P8\ç\'SY+j¯¡?q¬˜\ŞE±¦£—–{´µ\à\áÁ\ßc1ôÈ€\Ã<4¼®QpsÆ¡\ì\É\ÖLµ\å\'K?FOk\\o\0\èw\È*\ãs\\ÀA7	«qp–U’\ÔDY+:Œ^}ú–‰\ï\Ã\Ï4Ô´Kd7yœ³@¸\ÆÂ“`ôÁˆôt0¶Ueg7¥¤fW\ÍF¶¶\ŞUj\ê¼\ì)±*ŒS¦€Cvy\æv™d“qÒ‘\\u&qV\ê\ã\Â`\"\ïôh¿ósı\Äı…:újü€\ËÇ…P=8öR¨(5Z‰\Ş\î\ïJô|Šˆ`š•H\ß×»\\˜\Ş\É4y¥¬·\ì]\nÇªú\Ï1s\î<5øt\ìfha§E³ò]«§š\áBF«©[r\ÛO\áÓ‹\×pÀ/J\Ì9\Âfş«\rÒt©Ş° p\Õ9ƒñ#‡\Ô	©9u\ïn\Ù…E·7xI¼Š§œk†ú]y/\ï±\í–	gb/¬®P\Ğ(\ìnœœ¦T\ËYj•Q	Fö—\ïZ\Ì\éQ\Êu\Æ\Ï\éc/5\ÚÚ£1§±£I‹ö\à<lL»M©¥\ÇU& xLWj¿gøH	0Y\Ø4´…\Óó\Õ\Ù\ÕcC\É6o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2017-08-28 20:05:48','2017-09-02 03:59:45',NULL,'4321'),(6,'1094916671','Estefania','Arango Centeno','1990-09-03','310000000','estefa@gmail.com','0','ÿ\Øÿ\Û\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ÿ\Û\0C			\r\r2!!22222222222222222222222222222222222222222222222222ÿÀ\0dc\"\0\"\0ÿ\Ä\0\0\0\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0\0}\0!1AQa\"q2‘¡#B±ÁR\Ñğ$3br‚	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\á\â\ã\ä\å\æ\ç\è\é\êñòóôõö÷øùúÿ\Ä\0\0\0\0\0\0\0\0	\nÿ\Ä\0µ\0\0w\0!1AQaq\"2B‘¡±Á	#3Rğbr\Ñ\n$4\á%ñ\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz‚ƒ„…†‡ˆ‰Š’“”•–—˜™š¢£¤¥¦§¨©ª²³´µ¶·¸¹º\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\â\ã\ä\å\æ\ç\è\é\êòóôõö÷øùúÿ\Ú\0\0\0\0?\0÷ú(¢€>¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š\ÆÖ¼U£h\nEı\ìi.2!OšCÿ\0>§šM\è€(¢·|=\à\ßxªu‹G\Ó\'¸\àË±¯8$±\ãŒ\Ö\Í\äš\Ç\Æ	\ä\İ`±\Ó\\Íeøš\áuO\ëz\Î\á©\\J\Ö \ÛSşù¥o<ú\Æ\ïıœdc\Ş$\Õ¯V·³\ëÁ\è\\„z\nõ}á§„<;åµ‹nf8a\æ?>\í^÷¨ø»\ÃúQ\ÅŞ­l¬\n#yŒ>ª¹\"¹k\ï‹\Ú4vww,;¶#SøòJñz+e†Š\Üv>I\Ò<\â]y€\Ó4KË€WpaU#\×\'»\Í#ö|ñmşÇ¾š\ËO—w\Î\å\Ü{mQ\×ñ¯©UUQ*¨À\0`K^‘wñ‹T“?d\Óm!§š\Í!–\ÚÇ¸øâ™³²ö(A\í	ıA®>Š\ÑR‚\è;#\Âl?f»‰N£\â‰$\î-\à\n?2Mt¶ÿ\0\0<\rÄ‘_\Üu’\èı\nõ\Z+ —\Ç&›;µ›¡Ÿ\î¿\È\n®ş+ñœsQ\îÜ¸şF±\èª\ä`8ˆ~xlğİ¹\Ç÷\å‘ÿ\0›\Zµ\ÃÆ¸_i\Äuù¢\İüë­¢´\á)ñ?ò\Ôÿ\0ğ.Oñ§§‹üI\Êëšÿ\0z\á›ùš\Å=Mr®Àr¿ğ­|Œ\Â/¥ÿ\0\à8¨\äø]\àyF\Ã:xÿ\0u6ÿ\0#]u\Õ\Ãñ\'Å°ª¨Õ‹¨\ìğ\Æ\Äş%sZÖ¿<A\nª\ÏmcpV1²±ü›¥yõ.œ@±\æ÷ü;»6x‹\â;—~ƒ5}û8xvi$k=[Q¶\î£l/\è	ü\ë\Ù\è¯a²ø\Ïf\äı\"x†9h%sô;u\Zw\Ä?\ê[54‚F\Ùrxú±ùZùÚŠ\Í\á\àöšu?\Ù\Ã_·v«Xİ±?rEhˆ^k…\Ö~ø\ËC\Ş\×Z\ÃÄ¯°I\0ó`9ı+\í\n+\êè¦x–XdI#a•t`A\ÄS\ë\å›\rSP\Ò\å2\Ø^\Ü[9\à˜d+Ÿcµ\Üi?µ«B©©Aüy9lyR~`mÿ\0\Çka¤¶\ÔV>’)!•£•$S†V úM¯¹u¯\è!ˆÇªiV·HfŒn÷\×Ş¼»\Ä³¦wºMPš\Å\Î6\Ç7\ïÿ\0\íøÿ\0õıºŠ\å4Oˆ¾Ö¶ »ûÁÿ\0–WXOÉ¾\éüó\í]]`\â\ã£ó]\Ùø“\ág‹|0Y\î´Ç\Ü<ûPd\\\ã?^ƒ\Óõ\ÆQER\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š«¨j6zU›\İ\ß\\$\'WsúS\ì(\0¢Šµ¦é—º½üV:u¬·7R©K’Ï­Z¬ø\ÇGğ\Ú¼¸\ßs-¢\ÃH~£øG\×\ç(ø§y¾\×D\rim\Ğ\Üõ¯ôş\èı}\ÇJó\Çv‘Ë»f9,NI5\ÕOŞ²)\"­tğ\'ˆ<cr\"\Òl™£\çuÄ§dk¿1\ëøg¨¯eğÀ(-\Ä\ZŠg—‡+‹\ì\ç¹\é\ÇNH÷¯o³²¶\Ó\í’\Ú\Ò\à…\0\n‘®\0À\Çô®\Ï_ø™­\êû\á´a§\Û\á„şğw\ëùb¸¶ff,Ä–\'$“\É4”WTb£¢\å~ø\áıeÆ¶\ÇV»”qˆA\çø{ö\ë\é^­okoiŠ\Ú¡ŒtH\Ğ(€©h¢Š(ªQEQE\0QEQE\0QEQE\0QE	\êh õ4R\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(®‹@ñ¾»\áÒ‰kve¶_ùvŸ\çÃªşW;E&“Vb•]J²†V Œ‚+ƒñg\Â\nø¬<¯hl¯˜\ç\íV¿+‘÷‡CÀ\Ç=+½¢½\ï\Ãtmsll4\ë\ÃÀI›\äsş\Ëôü:ñš\í«\ä\ê\ë|/ñWğ\ÙH\å€\ã\ìò·\İ\ì7ğı9\Õ\Í<?X‰£\ä|ñ\'„™¥X¿´lG?h¶S‘õ^¾½3À\É\Åyõ}üÊ®¥YC+FA\æ><ø-¡ø¥e½Ó‘t\íL‚\Å\â_’V\Î~e\Î;x\í\Î+\èJ+\Ãş(Ò¼Mk\çi\×uûğI…‘>«\é\î2=\ëf¹ZiÙ’|ŸEnx›\Â:Ï„u³\Õ\íd,«\Ìoôo\é×¡\ïXtQE€(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢¼û\Ç?#\ÑÌšf’\Ë%ÿ\0+$½V\é\î\ßË¿¥T`\ä\ì€(¢½O\á\Â+Ÿ\Í§«¬–ú2\Ø<ş\Ã\Ğ_OÂ¶¼Y\ã}?\Âğ˜\Û\ì¹Ku==\Øö©¯\×|C¨øŠø\İj–<\ìxHÇ¢ò}k>yæº\çW–Y³»œ–>¤\Ôu\ßN’‡©iX\ç<ğ\çZñ\Õ\éqlc#Î»|«\ÏAı\ã\ì+\êoxDğE€ƒO^á¹’\êEc{u<S[\Ún™e£\Ø\Çe§\ÛGmm\ÂGÀnŠ(¢µQEQE\0QEQE\0QEQE2Y\â7J\áG½&\ÒÕ…®QE>ŠÈŸZ\çGÿ\0ğ¬ùonfûó6=¹gŒ§µ5=ÂŠ(®‘\å?¿\"/û\Ä\nˆ\ßÚƒş½?\\\Åƒ\ÇK¢4Xu\Ü(¢Š\èõ±?ë–·¿İ•üW5E%—T?«®\áEWSEsQ\Ï,_rF_`j\ä:´«Äªz\rmdÄ¬g*[Q[4T^Cp>Fù¿ºx5=u\ÆJJ\èÅ¦´aEQES\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š*{+Û­:\î;»9\ä‚\â3•’6Á\ì\Şø™®\Ñi\ÚÉ\Şø©?İc\ïı\Ö?‘=1À¯¢¢t\ÔÖ¢j\æv· \é\"Ó\ÃU´\æ\İÁ\\t÷ı\ÔJù—\âOÁ\Ë\ï	´š–’^óJ?1P¿<>¹õ×®:\ç\×\ÕtŒª\èQ\Ô2°Ád_X\Ñ^1\ào‰Ri\ŞV—®H\Ò\ÙıØ®O/³z¯\ê=\Æ1\ì±È’Æ²F\êñ¸¬§!\èA®	\Ópvd4|E}	ñK\àšÊ“\ë¾Œ,ƒ/=1÷“\ß\Ô~=rOÏ²FñH\ÑÈŒ„«+GPE:Š(¨´QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQ^wñ\Ç_\ÙQ¾¥\È>\Üë‰¥^|•=‡ûGôı*rv@Q^­ğ‹\ád-º]cU‰—G…¾Uaş½‡oqşO¡­ñ\â\Ùš>‹6.>\ì÷(\Õÿ\0²§ûŞ§·×§‘I$œ“\Ô\Ò\Z+Ñ„‘işü!o<>!ñt¥;­\íœ`\İSş\Çş…ô\ëôµ½¼6–\é¬qF0ª½\0§¢,h¨ŠaUF\0‚–Š(¢¬aEQEPEQEPEQE‹¨\êeÉ†\Âtfş•Z±§²¡\'dQEX½\ÕV\Çû·aş5‹$²L\å\äb\Ì{še\äU­*S²\Ôv\n(¢Š(¢²,(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š:µ£k©¼d$ùeş÷qş5E\\*Jñd\Ê*J\Ì(¢Š\é\Ñ\ÖEŒOB)\Õ\ÏZ^=«ñ\Ê«[\ÑJ“FT×«Fºª¼\Î:”\ÜQEú(¢· (¢Š(¢Š\0(¢Š(¢Š\0(¢Š+½ğ\äğü©¦\êN\Òin\ß+u6\ä÷«\ê?\Ü\nŠ™EIYˆ+Å¾.|\"YŠ]{A‰c¿E\ÌĞ¯P?‘÷ü¯´\Ñ_W\Ç$sD’\Ä\êñº†WSÀô ÷\êğÿ\0‡^;mt\Òu9I\Ódo\İ\È\Çş=\Øÿ\0\ì¤õô\ë\ë^\á^}JnÌ–¬|$o¯¨\É\"1VF*GPGcM¯¤>2|\'\Z¼¾#\Ğ-¿\Ó\"]\×6ñ¯2¨\î¨§˜ù¾Š(¢ AEQEPEQEPEQEPEQECYÕ­t=*}B\íö\Å\ç\ØöQ\îO%}UıG¼×µ{m2\Â3%\Ä\î@=Iö…\ã¿§†4°–ì­¨\Ü!S\ÎÁ\İ\Èô½O\Ğ×\Ë,“Jò\Ê\ìò9,\Ì\Ç%‰\êI«ºÖ±u®\ê\Ó\ê™e<(\è‹\ÙG°¬úôiS\ä^e¥c¨øe\àx…a`c\Ómş{©I\ÆG÷G©>\İ§ö…¾™aoci\Åob8\ÑT\0\0ƒŠ\Çğg„\ì¼\á\Ë}*\Ír\Í(\Ê\ç©\'üıtQE¨ÂŠ(¢Š( Š(¢Š( Š(¢Š*µõÈµ¶g|ğ£Ş”¤¢®Á+» ¢Š*–«}Œ\ÛDyş2?•cR’Y‰\'$œ’i+Ä«QÔ—3;\ádQEQEfPQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEU«+³m.ú¶û\Ãú\ÕZ*£\'Ì…$š³\n(¢º€C\0A\È<ƒKYšU\ÎA·s\È\åÂ´\ëÚ¥QTŠ’8gW`¢Š(¢Š*\É\n(¢Š(¢€\n(¢Š(¢€\n(¢Šõ\ï…\Ş5ó‘<=©L|\Å³‘¿ˆùfO¨\í\í\Ç`Ó£‘\á•%‰\Ù$BYN\n‘ĞƒQ8)«14#*ºu¬0AW\Í?~\Zc\Ş?‰4ˆO\Øf9ºŒõnˆ{ÿ\0Ÿ<‘ô½A}e£c=•\Ôk$¡DeF:+\êú+–ğ\'Š—\Å:yHöØ\åqŒ\Î=?0k©¯:Qqvd\Ñ]‡ÄO\àKiµŒ\ä\Éi!\î™\éõSÁò+¢Š(¤EQEPEQEPEQ^ñ/\Å\'Y\Ö›k!66lAÁ\âI:ü:\ÇÖ½\â‰‡¼<\Â+{w˜  \à¯÷›ğó\"¼º°ôş\Ó) ¯¦¾xhú?ü$—ñbúõ\ÑÁ<\ÇO×¯óWü,ğcx\Ï\ÆVöò¡6\ÄMvq\Æ\Ğx^‡®1Ï½}I)k¶4Pª=\0\àQEWaCè¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š+\Õn<ë²€ü‘ü£\ëŞ·n%ò-\ä“ûªHú\×(I$“\É5Ã©d º›Ğ·\n(¢Š(¢¼Ó¨(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢­[\é\×W6WW‘D\Íoj\Êı—qÀ Š(ª´QE\0QEQE\0QE>9\Z)E\ê§5\ÒF\âH\Õ×£Š\æ+gI—}»Fz¡ıù5Û‚¤\ã\ÜÂ¼t¸QE¡EW¤r…QEQ@QEQ@QEQ@Q[^ñş× \Ô\"£$\Ñÿ\0~3\Ô}{p+\é+[¨om\"º¶I\È7H\È5òz\ç\Â/n_\\\Éó.e´\Ïq\Õ\×ÿ\0fVô®|E;®dKGñ\'ÁPx\×\Â\Ó\ÚmU¼ˆy–ò\ãÀ;\ã§sŒg5ñµÍ´\ÖwR\Û\\!h\\\Ç\"ªÀ\àŠû\ê¾nı <\Ö:¢x¦\Îû=\Ñ	v@$,˜ıqÃ \ë\Õh¢Š\â$ñ\Z(¢Š(¢€\n(¢Š(®[\â¸tO\n\\4o¶\æ\çı,F\á\ÉüSŠ\æv@Q]—\Â\ïÿ\0\ÂW\ã\Ë)ú,Mö‹Œ÷E\çS­yüAÿ\0	‰§–\'\İi\îmñĞ¨<·\âr~˜ô®fŠ+ÔŠQVEŸC|ğwü\"\ŞŠ{˜¶\êÿ\0¾—pù”º½28ü;×£\Ò*ª\"¢(UQ€\0À–Š(¢˜ÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¬ıfM¶A¾À~k¶5\Æÿ\0P¿\ï\åXõ\äb\İê³²Š´Š(¢Š(®cP¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢ŠUR\ÌA,N\0$\ĞET–\Ö\Ó^\\\ÅmoI4¬z’k\ŞôoZ\é\Ş“D—k5\Ìg\í2œ»£\é\Æ>•ğûÁEˆjš”cûBEı\ÜgşX©ÿ\0Ù\è8õ®ö³”¯°Q_0\ŞZMa{=¤\ë¶h$1¸÷z7\Å}\Ûj0\ëP¯\î®q\Ø$ƒøÿ\0×œÕ§tEQES\0¢Š(«úK\íº+Ù–¨U‹\Û{÷\ÅkEÚ¢d\ÔW‹\n(¢º\Z(¢½£€(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š*Ş™¨O¤\êv\×ö­¶ky¯¡\Çc\ìz­T¢\Ä“\â}\×\Äş¾\Ñ\î\Ô\îc*”o\áapA\Ç5­E}K¥\êPjú]¶¡lÙ†\â0\ë\ê=A÷ ı*\åyoÁ\İu¦µ»\Ğ\æbL?\égœ!8a\ì ÿ\0Àz•yµ#\Ë&ˆgÁš®™u£j\×Zm\äe.-¥h\äR\ä¼ö=ES¯jı¡|(ºv¹k\â+t÷\î¦\Çüõ ú’F +\Åh¢Š*\0(¢Š+\Ä~+\ënñ2X#f+öœ7¶	ı6À×´]\Ü\Çeg=\Ô\ÇAH\ävU?Ê¾b¿¼—P\Ô./f9–\âV•ñ\êNMt\á£ys\r}1û;øtXøbó\\‘G/–‡\'\"4ö÷\'5óe­´·—p\ÚÂ»¥šE«úšû›\ÃzDz†´\í* Ám`Xğ\Ä9\éïš¯EWif¥QEQ@QEQ@QEQ@QEQ@QXº\ßú\è¿\İ5•[\Z\âÿ\0¨o÷‡ò¬zññ_\Ågm/QEQ\\\æEQE\ÙøK\áÎ§\âe[¹OØ´\ã\Òg\\´Ÿ\î/©\ã\ëCv\ìQEq”W\ÑZW\ÃoiJ?\â^·r²]Ÿ3?ğ»úWIc\íŠ\Î\Ş5ôH”\ĞTs‘\ÎQE|£E}W6“§\\¯\Ó\íeÿ\0~o\æ)mô½>Ñƒ[X\ÛBGC*¿\ÈQ\Î\áEW\Î\ZGƒµ\İi\×\ì\Ö$Gş[L\n ¹=×¬xS\áı‡‡J\İ\\0»\ÔIùcÿ\0tzûõúWdÿ\0}¾¦›R\ä\ÙAEQET\0QECZ\Ò`\×4{:ã„™p«u}+\ç-F\Â\ãK\Ô\'±ºM“À\åQ\ìz\×Ó•À|Iğ‘\Õlÿ\0µ\ìc\Í\åºşõs,cú\åøUÁ\ØaEWŒ\ÑE¨QEMiÿ\0ÿ\0¾*\Z±b7^\Ä=óWO\ã^¢—\ÂÂŠ(®†Š(¯póÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(­kAñ5†¡’#@%À\Îc<7B\Zú`ÀAE|Ÿ_E|>\Õµ¼a#8i`_³É\Å8÷+´ş5Ë‰\Ò%œ\Ä\Ï\r¯Š<	©Y,a®3, a×‘Ï§\×\Å\İ+\ïúø·\âf…ÿ\0÷\Ä-^\ÍQ\Ö˜\Í	q‚Qù\ã\Û9…tôQErrTQEq¿µ/°x2xÕ°÷r,ôû\ÇôR?\ZğjõŒwÛ¯4\Í<¹L\Ã\×q\Ú?ô¯/¯C­\Ö\Ç}ğgD]o\âfš’0\Ú\îºue\È;G\ï_`\×\Ïÿ\0³V”wkº»c\Õ8ú³sÿ\0|\×\ĞQE°ÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¬ıf=\ÖA‡ğ0?‡JÀ®®\â/>\ŞH¿¼¸Z\å\ã†Y¥ò\â\ŞOîª’*ó1±´Ô»T»`¢Š)”QEq…Q]\ç\ÃO\'ˆµ¿¿v›j\Ø(zM\']¿AÁ?P;×½*ª(UT\0\0‰\àı%4_	\é\Öj»\\B¯/©vo\Ô\ãğ­\ÊÉ»³);°¢Š(¢Š)QEQE\0QEg¿\ßo©¦ÓŸ\ï·\Ô\ÓjM‚Š(¢Š( Š(¢Š( Š(¯$ø\à6¶’MgH„˜/qõg»(ş\ï¨\íô\é\æµõ)¯9ño\Ã8¯\ŞK\íd,w=±\áÿ\0³ı\Ó\í\Ó\éZF]ÂŠ(¯ «úRnº-\ÙT\Ô7º}\æpğ^[Kˆ\ÛY]qƒZ\ZL[-\ÚC\Õ\Ï\è?É®\Ì,yª#:®\ĞaEV…Q^¹\ÄQEQE\0QEQE\0QEQE\0QEQE\0QE\êÿ\05<I©\éN\í\È[˜×°\Ç\Ê\ç\ë\Ê~U\å\Õü8¿ûtò\ÌV9\Ë@\Ø\ï¸£şú\ÛYÕ\àĞ˜W\Îÿ\0´‰\å\ß\é:\äq\0²«[K&yf¨Ç°\İ_DW›ür\ÒN§ğ\ÊòD…^[9\áX\ã(\ÃÈšú\ZŠ(¯8ƒ\äŠ(¢¼\âe\ßÚ¼sx \å`X\â÷\È\'õ&¹\n\Õñ=\Ç\ÚüSªÏœ†»—iö\Ü@ı1YU\êAZ)«ş\é\â\Ï\á”3˜¶½\İÌ²–+‚À£\ã\åşu\ê\Ë|6³k†\Ş\Óc}‰¯û\Ãwõ®¦Š(¢¨aEQEPEQEPEQEPEQEPEU\íK›Y\Õ!±ƒ†òÇ¢¯sùW³\èº Zy\énd“<‡Õz\ã>Y©’şõ€Ü¡bCéœ“ü–½\Z¼|uW)òtF\ÔÕ•ÂŠ(¯ø\àG³¸—_\Ò\á-k!-uõMıñş\É\ï\è}__[2«©V”ŒFA\ä\Ş2øPd’Kÿ\0*‚r\ÏdN\Ø\'ô?‡¥rF]ÎˆË£\n(¢½d\0\0\0`€R\ÑEA˜QEQE\0QEQE\0QEÿ\0}¾¦›N¾\ßSM©6\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢£\Ş¨ˆ’Xœa‘\ÔG¸5\å~.ğ\Ôz\ÌrÙ©[)¸E\ë\å°şÿ\0/Æ½b°ü_h·~¼|Ñ¯š§Ğ©\Ïò\Ï\ç]8Z®EÙ‘R<\Ñ\n(¢¼~Š(¯x\á\n(¢Š(¢…QEQ@QEQ@QEQ@QEYÓ®\Ú\ÃS´¼O½o2J8\î¤\éU¨ AY*Ó“Vğ­a!!\'´‘?„Ö½#*ºu¬0AW\Ö4Vw‡\æk\r\és·Ş’\Î\'?R€\Ñ^[Vd\0\ÑZ:ük\â=R\İ+¹P`\äQ_4\ÜJg¸–Sœ»–9÷9¨è¢½SC\íıo\áı6ŒGk{ ~‘UQBªŒ\0\0´QE\0QEQE\0QEQE\0QEQE\0QEQE\0QE\éŸN–Uc\ë‚?úÆ»\Êò\0\ëP\é [K‰%ğò—?\ß¯õR+×«\Ã\ÆFÕ™\Ñ„(¢Š(¢Š\å((¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š\Ï¾\ßSM§?\ßo©¦Ô›QEQ@QEQ@QEQ@QEfø†A‡5n†\Ù\×óR?­iWñV\×JM9\\y÷G%s\ÈE9\'óÀü\ëZ1\æ©\æLİ¢\ØQE\ætQE}\ÂQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE}ğşc?4—8\â\"œ²\Å¥\ÃCŸ‡\Ú_ıµÿ\0Ñ¯Ey“ø™›>,øl–Ÿ<Akµ~\Ø\Ìcw\Í\Û\ëEYøº1ñW\Äÿ\0\ëÿ\0 -\àQEz†‡\ÙTTs5Å¼\î\0i#W t\É©è¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š«¨\Êb±”¤mL¥\Ë\'\Ği]\Ø(¢ŠÆ½½i\îü\ÈØ¨Œşìƒ‚=\ë\×|#ñ^\Æ\â\Ò;OHm\îûN\ÒR_sºO§Jñj+Â›swgw*µ‚Š(¯©4\ï\èú¼\í¨\Û\ÜÊ©\æ2\Äù!sŒšÓ¯›¼¬\ÆV3»m†fò%ô\ÚüdûƒøW\Ò5‹V\"J\Ì(¢Š(¢ŠD…QEQ@QEQ@QY\ï÷\Û\êi´\çû\íõ4Ú“`¢Š(¢Š(\0¢Š(¢Š(\0¢Š(ª·ú•—mö‹ë„·‡p]\îp2{Uªò‹º¸y\ì´x\Û\"1ö‰G¹\È_\Ów\çN*\ìaEWS«üFğş™n\Æ¡}>>X \ä\î\İ\0ı}«\Æõ]zûX\ÖS»“3ò¨û¨½”{Ve´W+ºQ]4R,\Ñ,‹Ñ†iõ›¤HZ)#?\Âr?\ZÒ¯r”ù\à¤pN<²h(¢Š(¢ŠĞ¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š+\è_†òO´¿ûkÿ\0£^Šw\Ãu+ğÿ\0Kc‰\ç#\Z+Í©ñ³6|mñ{şJ¶¿ÿ\0]—ÿ\0E­ß‹Lâ§ˆ9ÿ\0HòEW„\êıŸV¼€\ç1\Î\éÏ³U+\Æö¿dñ®­1º\à\Éÿ\0}ü\ßû5`W¥t™g\Ö~º[\ß\è—(\Ê\Ë-„\r•\é÷kb¸ƒ÷\ë¨|,\Ğ\İ[&(š\ã¡F+ü€®\âŠ(¢˜ÂŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢¨k\0›;0«õ^ú#5”¨N2?k:«š›H¨;I0¢Š+˜¢Š+\Ã;ÂŠ(¢¾ğˆ‡ˆ¼-o3¾\ë¸“p;\îñ?\\\×\Î\Õü?ñIğÇˆ¦r,.qÀôŸğ?¡4¤®‰’º\n(¢¾Œ¢‘Y]£V‚)k# ¢Š(¢ŠUÁp¦y Š(¤¢µ¿³ şüŸ˜ÿ\0\n?²\àşüŸ˜ÿ\0\n\×\Ø\È\Ï\Ú\Ä(¢Š\æ_\ï·\Ô\Ók¢:±$™&\ç\Ü…\'ö\r¯üô›ó\áK\ØL\Ó\ÛÀ(¢Šç¨«z´V—^TL\Ì‚wAÿ\08ª•“Vv5N\ê\è(¢Š(¢ŠC\n(¢¡¼»†\Æ\Îk»‡	(]\Øö¾n\ÖuIuf\ëQ›\ï\Ï!`?º:ø\nôOŠ~\'\Z¤{¢\â©ıO\á^[ZÁ[Q…QEQVEV÷¦ú\ëZÕŸ¤Ç¶İœ¾xúòkB½Œ2µ$p\Õw›\n(¢Š(¢· (¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢€\0\É=(\0¢Š‚òsmcq8\Æbœg§5ô¯ƒm…¯ƒ4x\Ç{H\ä\éXn?ÎŠÕ±µ[kD9X\"X”\ã\n\0ş”W–\İ\İ\ÌÏ‰¼ozúµÛ©\0÷Òƒœ1~TV=\å\Ë\Ş\ß\\]\É÷ç‘¤o«Ÿ\çEx¿Å«?³ø¶;€.m•‰ÿ\0h¿\È/\ç\\{\Æ7H\Ó\ïÀ\æ	ŒMôqŸæ¿­x\íz]\à‹[J~\Îz“\\ø/P°b¸´¼Ê\ÔPyüA¯d¯˜ÿ\0gMW\ì¾4½\ÓH^Ú’	=\nÿ\0\"k\é\Ê(¢Š\ÔaEQEPEQEPEQEPEQEPEW=©Y›iË¨ıÓœc\éTk¬–$š6\ÆUºŠ\ç/l\Ş\Îm§”?u½k\Ê\Ä\áù4v:\éT\æ\Ñ\îQEV¢Š+\Ø(¢Šõï…¾8V?\êse\â\ÎW=Güó\'\×\Óòô¯Y¯’A ‚\èEz\ï>\'«ˆ´¯Í‡û±^±\àú	?ø¯\ÏÖ¢Q\êŒ\å¨(¢Šõš)A\èE-AEV•ú…\Ìqh+Rõ\ÎÒ«2ı\Ö#\èkh\ÖiY™J’z ¢Š+¢ªš¬\ÊB0’^\Ê\ë\\ô³J\ìÁ¤v<&¢¢U\ßDTp\ëvÂŠ(§I#\Í+H\ç,\Ç$\Óh¢°:BŠ(¢¹\Zx¶\é¤F\Êú„Àˆ#<\ãı£\ì?_Î¢ñlü7[Á¶\ãRaòÅ#÷ğ\êZñûû­Rú[\ËÉšY\å9foóÀöªŒo¸ÂŠ(¨fšK‰iI³³–\'©4\Ê(­@(¢Š*[x\Z\æa\Zş\'\ĞSb‰\ç”Fƒ$\Öı­²[Eµy\'\ï7­ta\è:\ïc:•9W˜QE,h±Æ¨£\n£E\ë­ ¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(­Yhø«Kµ+¹^\å7¯ªƒ–ı¬Š\ï~iÿ\0jñ» í³\Üq¹¾P?\"ß•Lİ¢Ø˜W+ñ+Tş\Çøs®İ¬\Â>\Ê\Ñ\Æ\Ù\Üÿ\0(ßš\ê«\Çhc\ì´\Ò\Ñ\ã\ß{r¡?6\Ô\ç?L\â½ÒŠ(¯0ƒ\æ*(¢°üc¦kxKR´Q—1w/\Ì\ãŒ~5ó…}W_7x·Iş\ÅñEı]±¬…\âÿ\0q¹_\Ğ\ãğ®¼,·‰Q:\ë#\Ãş7\Ñõ6\0\Ç\r\Êù€œ\r„\á¿Bk\í\åetWF¬29WÀ5öo\Â\Ï|<\Ò\ï\Ë\Ï}bqË§½°kŠ(®²ÊŠ(¢Š( Š(¢Š( Š(¢Š( Š(¢Š( Š(¢«_À\'³‘H\ä\r\Ëõf™3l‚F=“úT\Í\'˜\â\ìô\n(¢¹:(¢¼\Ğ\n(¢Š(¢€\n(¢½\á÷5-3Q²\Ñn	º±d…\Ûæ„±\0>œôü±^\ì¬d\×\Ë\Şÿ\0‘³Fÿ\0¯\è?ôb\×\ÒÁŠœƒŠ\Î{‘$QE\\¢¡Y\ÇF÷(`\İjH\n(¢¨?\ßo©¦ÓŸıc}MIö©5\n(¢›\\\Ä\ßh6Àæ¸‹{\\u(2FzñÖ½\0+\Æş0ÿ\0\È\Ãcÿ\0^Ÿû;U\Åj$\îÂŠ(¯<yY\ZI\Øå™I>¤\Óh¢µ((¢Š(¢Š\0(¢Š\Ù\Òa”™\ĞV…S\Ó6(=	­\\¯j‚Jœlp\Ôw“\n(¢Š(¢µ (¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š+\Û>\éf\×Ã—:ƒ©\ry6Ğ¢pıô\\~\â±\ÆóJ‘F¥¤v\nª:’z\núC\ÓFĞ¬´\ä\Ûş\n£\è\ÍüGñ9?s\âehÛ¹,+\å\Ú^\ZŸ#Ó£uh´\Øg\0‚$o™Ï¶\Úú{P½‹MÓ®oguX ¤b\í´`õ¯†µ\íV]s^¾\Õ&ggº™¤ù\ÎHğ	ö…hQE\ÄIEQ^]ñE\ß\rµrŸ\èó\èySù\îˆ¯Qª:Æ™³£\İi\Óñ\Äe3Œ\í=›\ê\áWN\\²Lh+\Ûgo­–¹{\á\ë‰6\Çx¾t\0\à1x#\ätúW‰U\íU¸\Ğõ«=RÕŠ\Ím(‘p\Ø\Î:Œö\È\Èük\æ**k»Y¬o&µ¸B“B\åOb\rC^™g\Ş4V~‡ªÁ®hV:¥³‡Š\ê0G<|Ö…QE\0QEQE\0QEQE\0QEQE\0QEGU—Ê±a\\\íz°µ™·Ü¬@ğƒŸ©ÿ\0\"°\ÄÏ–›4¥\ÉQY´QEx\ÇhQEQE[¶\Ó.®°R=¨ø_Â‚\áNu,\ØQEk\Ãò6h\ßõışŒZúV¾~\Òt¸ô\İB\Öõ\äi%·•%UQ…ÊœıH\ãÚ½ıd]NU€ úŠ\ÊNæ˜œ%l:‹ª­p¢Š)\ÔQEI\ÈQEQE\0QE\ã_\äa±ÿ\0¯Oı«\ÙkÆ¾#4z·‰äŒ±_²¢Â¬£?\íü’;UEÙ›\áğõ+IÆš»AEWQW&\Óg‹•Eÿ\0g¯\åT\Ïµ¸\êR7i«QEQA˜QE©£\Ëş²#şğş¿Òµk³—É»»g\èk¢¯W>jv\ìqÖ¥p¢Š(¢Š+¨\È(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢‘™QK3U$œ\0+¶ø]¢WÅ±\İI\ë{\ç1 \ãDõ\Ï\Íÿ\05\ïu\Ç|5\Ğ?±<)²¦Û«\ß\ßÉ‘\ÈR>Eü¹ö,k±¯>´ù¦C<›\ã\çŠ‘\à\Å\Òa”­Ö¤\Û\rƒ\å½\Çpz{dW\ËU\İ|[ñ[x¯\ÇwRG!k;?ôku\É\Æù2FI\Ï#®p´QE‚Š(¢Š( Š(¯ ø³\á\ão}¹~\ê|Gq\ÑÀ\àş cğ÷¯3¯§µm2\rcI¹Ó®Fb\n“\è{\î\á_6\ê\ÚeÆª\\i÷K¶hi÷ˆö#ñ®\ì<ù£\Êú™ô\ìó\ã4\\øRö`¤=™cŒ\äü\È8õÁ\ë\Ü×¿WÁºF©u¢jöº›”¸¶H„t\íøŒÆ¾\ØğŸ‰-<Y\á«=b\Ìü“ Ş¸\Æ\ÇyTè¢Š\è(Ú¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(®V\êO6\êWõc]Ud\è\Õ<G~ööeQ¿y3ğ‘ıOô\×9\Ù#|>\ì(¢ŠÆ®³@øy®k¡f1;V\çÎ¸\ì¯Súzõ\r|<\Ò4\0“J‚öøs\çJ¼)ÿ\0ez¯&º\êò\Üû]‚Š(¯$Ö¼\'£øZ\Ú\Ş\Ş\×Z„§{O)ûŠ?º£“ß“Á\æ±\ëO_\ÔN©­\\Üƒ˜÷mı\ÑÀÿ\0Æ³+;\Üû¬»\rõ|<b÷z¿\ë\È(¢Š+Ö¼+yö\ÏZ19h\×\Êoøô\Åy-w_o\ãòÅ¤\È?Fÿ\0\Ùh9sº>\ÓÌ¾Ë¿\èQEw4QEÆ…QEQ@QL–E†•\Î³@+Áo.^òú{§û\ÓH\Ò©9¯\\ñµÿ\0\Ø|/sƒ‡¸\Äÿ\0\ëÿ\0ƒ^9ME’Ò´%Qõ\Ğ(¢Š+O@\Ót½_U[\rR3²\àldm®\Ûß‘ƒ¢³)\Ñ\ÈñJ’F\Å]eaØ†™\ê×¢«Sp}BŠ(­_|,\Õt\İ\Óiı¡n9Ú£¯ü¿\áÏµp’FñH\ÑÈŒ§¬0A÷ôŞ¨.«¤ZŞ®?z€°›¡˜5C\Ä\Ò<I¶\àOŒ-\Ä,‹ø÷\Ç4\ÔûŸ\ï8\ËtQE|\ã],\æ[\Æ\ç«(&¤ñO5?³LGÚ¬3\Å\Äc\îÿ\0¼?‡ù{\Ô@‹8ş\è5\è\à_¼\Ì+\ì˜QE=Q^‘\ÌQEQE\0QEQE\0QEQE\0QE\ÓxÃ§\Ä~&‚uœ¾¸\ÏB£¢ş\'\é“Ú¹\0\É=\0¯¢<\á‘\á¯Æ’¦/®q-\É\îdÿ\0€ÔŸZÊ´ù#\æ&Â¼\ï\ãŒ‡…<,Vóm\Ôo†\0Ì õolÃ·zô‹ˆ­m\Şy\äX\âA–f\è|kñ/\Ærø\×Å³\Ş	\ØÀLVˆIÀLõÇ¹öc<\×SEWA\ÇQEQE\0QEQE\0QEWŸ|Oğ§ö¦š5‹Hówh¿½P9’?ñ^O\Ó>\Õ\è4UBN.\è½Kà¯¿\áñ\Ò\ïdÆ›~ÁIbq~=;ş&¼¶ŠùRŠ\î>\"ø?ûQû}”ñ.ºn\0BıJıQø\Õ\Ã×¥)+¢Ï¿••\Ñ]2°\È \äK^9ğO\âWööœ<?«\ÜgQµ@ ‘\ÎL\ÉÓ“\ê8×œc¢Š(ªQEQE\0QEQE\0QE»\áŸÉ¯^Ä¥¤X2¸\ê\Ù\çô¯V²±µÓ­V\Ú\Î†\èª;÷\'\Ôû\Ö?‚ì…Ÿ†m\ÉyÉ•¿Ÿ \ĞW…‹¬\êTk¢:i\Æ\È(¢Š+\Åÿ\0\Ùş¹‘[H<¤ú·\Ë\'ğ­Š\à¾!^î¸´±S\Â)•Ç¹\à#ù\×)\ée\Ô=¶&{nşAEWEP}\àQEV·†o¾Á\âII\Â3yoŸF\ãü\áY4t Î­5Rf¬QE{CE¾ş\ÒÑ­n³–tÿ\0\Ş\Ô\Z¿Aù\Ü\à\á\'	n‚Š(¢Š($\0I8‚BŠ(¯5ø•¨y—Öšz7¡‘\ÇûM\Óòõ®´5\Í@\êš\İ\İ\ær²Hvº8_\Ğ\nÏª>\Ó	G\ØÑŒŠ(¢Š( \è\n(¢½#á®¥¾\Ö\ëMvù£o60ºx?®?:\ï+\Æ<ıŸ\â{G-ˆ\åo%şÀıp\nözLùlÖ³\Äs-¥¨QE\×D–6EWFeaG¡¯2ñ„K_\í\r9´\'D?\å‘\ìGû?Ê½>«\ß\Ú-şŸqhø\Û4l™=²:Ö´+:Sº\Øò§e`¢Š+Á¨¥thİ‘\ÆNô4•ô QEQE\0QEQE\0QEQEmx[\Ãw>(Ö£±€\ìŒ|\ÓMŒˆ\Ğu?^ÀzšI]ˆ(¢¸\ïˆ\Ş:µğ/‡^\íŠ=ô¿%´\å›\×\è?\Îz·\á_„£¨n\ŞF~\Ëhÿ\0\è\àŸ¿(\ç?E\ëõÇ¡\íU[O°¶\Ò\ì ±´ˆGoEŸÔ¤÷5f¼Ú“s•\Éló¿?~\Él|)¦Í‰¦_ô\ÆS\Ñğñ\Üôúg†¾u«÷\×:ü÷·’´·9ws\Üÿ\0A\ØÂ«\ÑET(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š­¨iöÚ®Ÿ=\äbKy—k©şPyÚ¾zñ_†.¼/«5¬\Ùx-\Ø\á\×üGqı¯£«/_\Ğl¼G¥½\êeO) ûÑ·f­*¼\ÈiØµ¦\ê7zF¥o¨X\Îğ][¸x\äC‚¯¯¾\Z|A¶ñ\æ‡æ‘\ê6\à-\Ì Œƒı\à=¯O\ä>7­o\rø“Qğ¦·«¥\Ìc#\È\ì\ë\İXw¾h¢µ5ıûÃš›\Ù^Ç‚9A÷d_QYu\è&šº(û¦Š\å¼\r\ã7\Ç\Z*^Y¸K…ÜŸš6ÿ\0\n\êh¢Š)Œ(¢Š)Ñ£I\"¢Œ³\0÷¦Ö§‡-ş\Ó\â=><dy\Ê\Ä{/?Ò¦R\å‹}+°¢Š+Ø­ [kX`O»* ©h¢¾j÷;BŠ(¢¼‡Ä—mñ\r\ä¹Ê‰6/\Ñxş•\ê\×÷\"\ÏO¹¹?ò\Ê6\ÈWŠ’X’NI\äš£\áúW”\êü‚Š(¤¢Š(>œ(¢Š(¢Š\0(¢Š\ï~_\î‚\ëOc\Ê5±\àÿ\0OÎ»jòjÙº\í´\ìØŒ¶\É?\İ<~\nõ\êÎ¨{<O:\ÚZÿ\0˜QEVŒ5\ì\ß\r]H§J<”ú·_\Ó\'ğ­\ÚóO‰:—›¨\Ûi\è~X\Ì÷›§\ä\ëAÇ€£\íqE¯\ÜQEp\ÔQEQöEQEPER«20e$09v5\ï:uØ¿\Ó-®×¤\Ñ+ı	ŠğZõ¿‡÷Ÿiğ\ÂDNZ\ŞVğû\Ãÿ\0Bı)3\Ç\ÎiŞ”g\ÙşaEWSER>l(¢ŠñoZı\Äú„XÀ2™Ñ¾o\ëXõ\Ø|F·òüAÀq,?PHşX®>¾†„¹©EùrV“\n(¢Š(¢µQEQEMiiqw¥¤-4ò¶\ÔD$\ĞEGX\Ö,4\r*}KR¸X-`]\Î\íü‡©>•&§\İjº„66P´·6\ÔAüÏ I\í_DøK\Ã¾Ñ’\Ò ­pøk‰À\æGÿ\0\Ğ\êMPğ7‚\áğ¥‹I1Yu)\ÔyÒ\Â\î)ôõõ z\n\ëk†µ^m\Ä6Wñˆ´ÿ\0\è\Ó\êz”\Ë1)8\Ï,}\éù\äW\Ç4ñ}÷ŒüC>¥v\Åb,Dgˆ“\Ó\ë\Ó\'ğ\è\0\Z¿~\"^x÷Zó6˜4\Ø-­ó\Ûû\Í\êÜŸ¦N;\×EQX(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š(¢Š\0(¢Š\Éñ‡l|K¦µ\êr9UûÑ·¨ÿ\0õ\à^#ğ\İÿ\0†µkz™C“\Ê>YW\Ô{ú\ÕôQÕ´‹-oN’\Æş,/ù©\ìÀö\"¶¥U\ÃNƒL\ÙğÇŠ5?	k\êZ\\\Å%Só!û²B+\ëüB\Ò|u¤¬ö\Ò$7É…¸´fù‘±=AÁÁö¯‹ªş¬\ß\è:œZ†›pğ\\\ÄrOQ\è}E|\ÅEu^.ğ5ÿ\0†&3.nt\æ?%Â»\ì\ã±÷\èA\Ê\×|d¤®Š>ğ¢¼\Ë\á·\Å\í?\ÆqÅ§\ß\ì³\ÖB\à\Æ[å˜\éõôúûg\Óh®›Àpù¾\'ñşª\'\Óoş\Í\\\Ív\ß!İ¨^Ï¹§\æsÿ\0²\Ö8§j2eÁ{\È(¢ŠôZ(¢¾|\ë\n(¢¹\ï\Z\ÜıŸ\ÃS(83:\Æ?<Ÿ\Ğ\Zò\Ú\ï~!\Üb`~ó4„}\0ùš\à¨>\Ï$§É„O»oôıŠ(¢Š( õÂŠ(¢Š( Š(¢½{Ãš‡ö–…m99.\É?\Ş~½\Zò\Z\í>\ê]\ÕÆ\íò\Ê<\Èÿ\0\ŞO\åA\ã\çXk†\ç[\Ç_—_\ë\È(¢Š\ïe‘!‰å‘‚¢)f\'°k\Â5K\ç\ÔõK›\×\Îf°°\ì?^£\ã\İO\ìx±-\ÛyCıŞ­úqø×‘\ÓGŸ“Q´%Uõ\Ğ(¢Š(¢Šg´QEQE\0QE\ß|2º\Å\Åı¡?yVUBAşb¸\Z\é|söÛ®p&GŒşY¨3“|4×•ş\íBŠ(¯_¢Š*O\n(¢¸‰f-:\àŒ\èüy\åzŸ\ÄX|\ÏFı\ã¸SøGõ\å•\í\à]\è¥\Ø\å«ñQEV®\á\İGÄ—\â\ÓO‡qó%n1\ê\Çü“Úº\ÛKVfQ\\·|{£ø\'Lk‹\ë„k–È†\ÙH.\çœN£§Z§a§\İ\ê—\ÑYY@ó\ÜJ\ÛQ¿øRx\ï^	ğ5·…mŒ\ÓŸSbI‡D\İLö÷\ïW<)\à\í;Â–…-Çv\ã\İ:\áŸ\Øzo\ç]pÕ­Í¢Ø–\ÍOø‡NğÆ‘6£©N‘C\Z“óXúóù’|›ñ\âMÿ\0uNo¥BO\Ù\ísÿ\06:·ò¬ÿ\0xóWñÎ¨\×Z„]ºŸ\ÜÚ£|‘\ßS\ï\îk—¢Š(¬QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE2X£&ŠX\ÖH\Üa‘\ÆCB+\Ë<[ğ³™/¼=\Ó\ï5›ı\0ÿ\0Cø\Õ\ê\ÔU\ÂrƒºG†E’7d‘ee8*GB\r{w\Ãß÷\ZrÃ¥ø£uÅ²€‘\Ş(ù´;úg\éÓ“^E|±4\ÛNğ\Ï\Å*®¤2ŸBJ\ïşÅ‹Kùq÷¤Eü?Ö½+\Ä^\Ò|Múd;.\0\Â\\E€\ëø÷Æ¹\İÂ—³\ŞY\â7˜È³¢6\à0\ìx>\Üõ«\Ä\ÖS¢\Ò\ÜÚ“\\\ÇŞºv¥e«YG{§\Ü\Çsm \ÊI\È5j¾#ğŸu\ï^yúM\áX\Ïß‚Oš7\Ï^CÓ‘\è+\è?üwĞ¼A:\Újñ&å‚…w|\Æ\î[s”r9<}\ì\ã:QEyY\ë4S!š+ˆcšH¤P\è\èÁ•”Œ‚\ê§×›øúmú\äQ\ÄpÌ’Â¹J\Ûñt¾o‰\ïxRª?\×5‰A÷\Ørai¯$QEQE`QEQE\0QEU­6õô\íF\Ş\í3˜œ1£¸üFj­(©E\Å\ìÂŠ(­o\ë	ª\ë }öö\è\èI\äŸ\ä?\n\æ)\Ò¬©¦\Õ}*Q£N; ¢Š(¢Š(4\n(¢Š(¢€\n(¢Š\Ğ\Ğgû6¿§Íœ¸Lı2ı+>œŒQ\Õ\Ô\á”\äPL\ã\Í\áEW\ĞTS\"KH¿u\Ô0üiõ\'Â…Q\\ÿ\0¢ó|%{«±‡\à\ãúWW»\ê:\\úŞ—waj \É,e71Â¡8Á\'ñ\Î:ã±©<-ğ\×J\Ğ6\\İ~¸a$‹òF\Ù_\êrx\ã\ê`\ê¨Sw\îsVj\áHÌ¨¥™‚ªŒ’N\0\Âx\Ë\â×‡<(¶–S}y\Î\èm™O—†Ás\Ãp\ÜzŒ¹¾|ñ\Ç\Å\Í\Æ-%º\Èl4\Öû4,~q\Ó\æ?Ÿ\×5\çşøi¨k¾]æ£¾\ËO8a‘‰%\ìƒ\Ğ{Ÿl^Õ¦iV:5’\Ù\é\Ö\Éoœ…^\çÔ“\É>\æ®QN¥IOs\Ï[ø‡ñ\ËO\ÑVm3\Ã\Åooş\ëN	ò\â=Ç©=¸÷\èq_8êº¾¡®j_\êwr]]I÷¤óøv“ÀªTQEVb\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢³\ît‹y²\Ñ~\åıT|¿—øb²\î4Û˜ˆÌ‰\Z1Ÿ\Ìuşõ\ÒQYÊ”di\Z²‰\ÕøO\â7‰<:6ù\Ú\Ûvçµ˜\î‰úgƒĞ ds„W·xKöƒ\Ñõ¶ş$ƒû:~÷Ğ§‘\Ë/ğ÷²Oa_3Q_5\ë’yº\íûú\Ü>>›*…}!ªx{HÖ‡üL4øgoï‘µÿ\0ï¡ƒú\×©ü#´\Òõ	!lqÀ¤ÿ\0¼0@ü\ra*[gƒ\â+Š…T\â\×\Í~\ä}ñgyog\rİ¬¢X&@\è\ã¸##\éÁ©\ë\á­Å¾ ğÌ›ômZ\æ\Ğg;²„ú”9R\nõ=ö\Õ\íŠG®iV÷‘\ä-»\Ü\\‚*òj+«\Ô>ø’\Ãq[5ºOŞ·p\Ùÿ\0€ğß¥sw6WVRî­¦\ÇeB§õ¬œZ\İ\åU\n\ßÃš~ŒúJŠómã§‚5o-&½›N™ÿ\0‚\î\"\0ÿ\0.Wõ®\ëN\×4^!.›©\Ú]¡\è`™_ù\Z‚Š(¤tè¢Š(¢Š\0(¢Š¡\'ú\Çúšm:Oõõ4Ú£‰\îQEQE\n(¢Š)ñ\Å$\Ì(\Ù\ØöQ“]‡\Ãÿ\0j-ˆô‰\áQÕ®1\è\Ø\'ğ¦“{Ô¯N’½I%\êÂŠ‚\æò\Ö\Î3%\Õ\ÄP -#…­qš¿\Æh\ëók\İHA\ÂYƒ6q\î¼\Ä\×3EzÆ—ğbMÁµmQ‚3ª“‘şóc‘®\çGğ/‡tM­m§G$À®Ÿ÷õ\ç€~€VŠŒ\ç•_=\ÃS\Ò“ü>öwT“Ò¾~\×i\"U£\Ğ42¤–k\ç\è\Ü^¿÷\Õyoˆ~%x·\Äû\ÓP\Ö\'\ìOú<Ê¶¨ú\æ²|=\r\Íö‰§4p¹-o\æa…h“\×\Ó&º;}¹»uØ‡\n:w\êyÏ§Òµ¨­£J1>J¥yNM­£<[ñ§\Ã2\ÛC#\ê:„l\È\Öñ¡YH\Èf#¸\';u¯	ñO\Æ_x–9­…\çØ¬¥\à\Ãl»26• Ÿ¼A•$Œşó\Ú)±Æ‘ H\ÑQ€ª0:Š+CY\ÙÜ»±f\'$“’i(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Š(¢€\n(¢Šl‘¤Ñ˜\äEt=U†Aü(¢€\ntr<R	#vG^C)ÁV=ß„|={?G´Ï¬q„?š\â²n~xfs˜í§·ÿ\0®S7şÍš(¨”U¶;ğ¸¼Df¢ª4½Y\Ğ\é\Ş>ñn”sg\â-E1µ§gQø6Etv?¼yf0úœ7Cş›\Û!ÿ\0\Ğ@ÿ\0&Š+#Sø]¡\ÚXKqÎ¡¹q€dB9 v¹\ïX\ÛHª’\ÜF~f_ğ¢Š\çiW‡­U­dşó{Lı |aq{\Ûi,¬NO\àô\'³\×k¤ü[×¯\ày%´\ÓAVÀ\ÛŸ\ï\ÑEc§‡­%½ò\ÚIğX…u\Şøg¢\ê\ëp\×7\ë\åÀIg9\ë•>”QT’±zµ\í\'÷š\×?5ˆl\Zu¶±.|\èU\Ãøã¯Št·m\ìôœH­\Ğ\ÈqŒtùıè¢ºH>xb\'\âò`İ’|ÿ\0|€kb\ÓÀ^²<Z-±a\Ó\ÍÌƒòbEVÑŠ¶\Ç\Í\âñUù\í\Î\í\ê\Î^\ï\ã\çnc)Å•±#\ïCl2?\ï¢k¿øŸ\ãmN3Ï‰/¶“’!aş€Víµ­”~]¥´0Gœ\í‰\ÈT\ÔQVp6Ş¬\æn\ïn¯\ç3^\\\Íq)\ß4…\Ûó5QEP ¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š(¢Š(\0¢Š+ÿ\Ù',9,3,1990,'\0ø\È*\ãs\\ÀA7	«qğU’\İ–À{uµ*6[\Ø\Ö\×İ‡Ç“If(-2K¾‰»\Ù\ë\Úø¢ò¾Ã®Ê¤5lË­P\â#\0\Êş\ç{\æ(7§\Ş\\L\Úl°9_ä†µ¢>sá´€c\'0¶Æ§?b_—m¤‹˜$\ç–\'\é\Z ~œ¿§=­~Z\Ò\ÌóA¢¾Å„)M„€0óŸ‰L¸\Øs,ÿ¬r\ÕÉ¿)ßt û\ç°\åö\Äq°d5´§7w¤\Ñı,\êFñHEC!)ğs-&9\Ì&Hc¶\â¾v“$™“1\Å\n[¥P¹U´€ñk‹£±DÑ¸1Sı°Vmò’ñª0Q\Ä\Ø?ª\Æ\í2»¥Yy2\r\ÒQY0,\Õói!n´±\Ê\Ô0\ë2]\Ş‡o\êm¨\Ô\ÕA¶¸ƒ\Z\ér“\é‚Fòe\Èô\Z°ø’Zù©DˆcQ_û‘%\èZD§\Ä\ĞR„\áfùO‰ÀWEŠ/D\ÓiT\ÃL\Ë\Ø\Æ\ÚÀ&´\×}kÔ˜³ü^i\ã1mª‘B¨ù\Ù2LP~_»=©!²\nÑ„0/o\0ø~\È*\ãs\\ÀA7	«q°ªU’\å\æx¬×›O™½xNeó\ã$¡ç «ô\â|²AHN\×r—®V\ì·0`¬°_W\Z#÷™Å´ş-\Ô#/§¢Z$c\n\á\â)`\î\á\Ö:Ù\àµ[C\Ïo\âZK*0+¤V\æ°ZE„ù\Çz0\âYN,„e·\ÆNq÷±–›\Çq\Ø8„G\Õ\è;:ptœ\Îû“›“\ï­\îŸ\Æ\×ûÅ¨¢½1\èÜøõ\É4tQ««±Js\ìªØ¯Äº< 7\Z\\^¥c)²\Ñ÷\Ü?\âözT²·!›Vóu3†+zğ¦)\ÏY¤GŠH€\ì²À°u…)_p\êƒñ\ì„\à\É5 \ÖP_:^u <\ËË^^³ˆO@“Á\Ó6\r\Ò\Øa£Ë–#\è8±¦»}\ì\×	*k/Uù7)¯°bV‡*+\nQ\ÍšO\'¼¦\ëPŸ15½8a\â˜\í@p\Ş\ä*‘’·\×\å~\ÕüÃ¸k\İ\ä>KŒ=OB)u\æøD\ÇRo\0ø€\È*\ãs\\ÀA7	«qğ—U’½ûC¢uT	¶[L¾\Ûğ]\'0\Ã|c\ÂzÄƒ…‚™\í)*¹A\ç\Öfô¤Où\ÔBn¸Q\0KK_ö\ìšÕ¸Ô\Î ÿCd\É\Ò\îm\03·\Ê¢Õ†\Ö}«ûk\ÑÖ—%\Í\Ë\á¦SH\Z…ƒ@Õ‘af±\ÑgË‡\r`\Ù)\ÆA“\rq‘zûôˆ0K?%Ã³ú:È¥\Óao=-…Ì®\'©™j(@²\æòc·v\n¯…r‹—X!uyÏ»V-.\î\"|óD+1;X«\æN\'Wœ\Ğ8—Kõ]ù’\æô§›>8$U’2» Œ\Ê!]4\å÷ŠÚ‘\Û{Ô„q\äU%qP\Äs]2X^!±w\Ù\Z{\ä?\ÓÏ•¸(\îõsP\á¾B\\´¶\Ñ\Õ{0\r~[7_\Ëxù\É3J4s7‚…â¹‹®œz¯OW\ÇÁ=ª`u.ö¶\èİ¬ƒH\í\Ø\Â\ârÂ´›¾\ZÎ½&$:\Îh\\	òõ\Ñpc¹œ\è_G¶?µ&³Ÿ«\æc\ŞõDo\0\è€\È*\ãs\\ÀA7	«q0­U’&‘%„0Ş;½©N\ÒùB\rƒn\ÂJı\ÌM\É3\Z¯²\Ó\çbt\Ù5\Ö\æ]vD\ÚdS\áCpMLJ\É ­c\ÖiF\Âüû‘£(™\å]}`>\\®EG*\í‹#\':>Nr8G\Úo¦;\ê×—‚}¤Ñ¢ù6k³’4¿,V\İ}\Ğ\çFô\ØÅºÇµ»¾š\ì\î1w°±³Nbwû0^5&˜ˆ+tÉ¹wAş}+“Ü†Û“‹z\æ\É\éL\0F÷.[g\Ëô†9,úw{÷?¬ˆ‰\ÆQB\nå¯‡\ç\r5<B˜‘º\Âq\áw@½óYòÁRM¯ß‹\ŞIh\ãRZ©¸$AÿÊ•1\â/\ë†¡\Z.Hv/\ãT#rò\Ú! }Ê½x’z–¦\è\Æ*@‡–¶›\ëüº\Ú\ãZ \\\å³õ¹@r‰S:N?E(\î]\éõeœ¤‡ÀG\'=Šù$j¦n\Z\ë\İK\ÎÔz\ç™}C£Å¬Ì›fºıŒŒB0nµ­T¬rgo\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2017-08-28 20:08:15','2017-09-02 03:59:56',NULL,'1230');
/*!40000 ALTER TABLE `socio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `identificacion` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `genero` int(11) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'ccbernal38','123456','1094925466','Christian','Bernal','Bernal@powergym.com','3153946037',1,'1992-01-19','Guaduaels de la villa','2017-08-24 00:22:13','2017-09-13 22:47:17',NULL),(2,'niaac','123','12345','estefa','arango','12345','nia@hh.com',1,'1990-11-15',NULL,'2017-09-14 14:19:43','2017-09-14 14:19:43',NULL),(3,'eac','1234','123456','estefania aa','arango','123456','nia@hotmi.com',1,'1990-11-24',NULL,'2017-09-14 14:40:31','2017-09-14 14:40:31',NULL),(4,'arangoec','123456','1234','estefaniaaaa','arango','1234','nia@hot.com',1,'1990-09-20',NULL,'2017-09-14 16:19:54','2017-09-14 16:19:54',NULL),(5,'eeee','qwe','099876','e','ac','1','es@h.com',1,'1990-09-20',NULL,'2017-09-14 16:23:47','2017-09-14 16:23:47',NULL),(6,'niaaaaaeac','123456','109293','nia','acenteno','75757','nia@gg.com',1,'1990-09-15',NULL,'2017-09-14 16:26:08','2017-09-14 16:26:08',NULL),(7,'naqw','asd','9876','qwe','aaa','12345','ni',1,'1990-09-26',NULL,'2017-09-14 16:27:53','2017-09-14 16:27:53',NULL),(9,'nbf','yui','345','estefa','acen','345677','ni@h.com',1,'1990-09-01',NULL,'2017-09-14 16:30:10','2017-09-14 16:30:10',NULL),(10,'nuo','qwe','1094916671','niaara','arango','1234567','nia@hotmail.com',1,'1990-09-08',NULL,'2017-09-14 16:36:24','2017-09-14 16:36:24',NULL),(11,'eacftg','1234','3456','esnia','arango c','123','niaa@hotmail.com',1,'1990-09-30',NULL,'2017-09-14 16:42:22','2017-09-14 16:42:22',NULL),(12,'cdf','qwe','daniel','c daniel','cruz','12345','daniel@h.com',1,'1990-09-14',NULL,'2017-09-14 16:45:11','2017-09-14 16:45:11',NULL),(13,'nuyt','789','3456','eacnia','arango c','123456','nuo@hotm.com',1,'1990-09-09',NULL,'2017-09-14 16:47:16','2017-09-14 16:47:16',NULL),(14,'p','1234','12','pedro','aerty','67','ni@h.com',0,'1999-09-10',NULL,'2017-09-14 18:23:58','2017-09-14 18:23:58',NULL),(15,'vcd','qwe','1','es','asd','34','n@v.vom',0,'1990-09-02',NULL,'2017-09-14 18:32:51','2017-09-14 18:32:51',NULL),(16,'qsdv','qwe','q','sss','asdfg','123','w',0,'1990-09-15',NULL,'2017-09-14 18:41:47','2017-09-14 18:41:47',NULL),(17,'user','qwer','1094','nombre','apellido','1234567','q@h.com',0,'1990-09-16',NULL,'2017-09-14 19:32:58','2017-09-14 19:32:58',NULL),(18,'crisdanielcm','criscruz1234','1094940706','Cristian ','Cruz ','3156650135','criscruz1806@gmail.com',0,'1994-03-04',NULL,'2017-09-14 19:37:01','2017-09-14 19:37:01',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visita`
--

DROP TABLE IF EXISTS `visita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `visita` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fechaModificacion` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `socio_id` int(11) DEFAULT NULL,
  `caja_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_visita_socio_idx` (`socio_id`),
  KEY `fk_visita_caja1_idx` (`caja_id`),
  CONSTRAINT `fk_visita_caja1` FOREIGN KEY (`caja_id`) REFERENCES `caja` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_visita_socio` FOREIGN KEY (`socio_id`) REFERENCES `socio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visita`
--

LOCK TABLES `visita` WRITE;
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
INSERT INTO `visita` VALUES (9,'Christian Camilo','Bernal Rojas',4000,'2017-09-02 11:13:34','2017-09-02 11:13:34',5,6),(10,'Cristian','Cruz',5000,'2017-09-02 11:13:47','2017-09-02 11:13:47',NULL,6),(13,'Christian Camilo','Bernal Rojas',12000,'2017-09-14 23:49:22','2017-09-14 23:49:22',5,13),(14,'Christian Camilo','Bernal Rojas',100000,'2017-09-19 20:26:12','2017-09-19 20:26:12',5,18);
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'powergym'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-20 20:49:13
