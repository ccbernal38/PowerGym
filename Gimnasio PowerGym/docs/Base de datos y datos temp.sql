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
INSERT INTO `duracion` VALUES (1,'Días'),(2,'Semanas'),(3,'Meses'),(4,'Años');
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
INSERT INTO `membresia` VALUES (1,'Silver nuevo',30,20000,8,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 18:49:04','2017-09-15 16:37:27'),(2,'Plata',30,30000,5,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 18:52:59','2017-09-18 12:00:18'),(3,'Luneta',30,50000,3,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 18:57:19','2017-09-18 14:11:11'),(4,'ëlite',20,60000,1,1,0,0,1,NULL,'2017-09-14 19:21:43','2017-09-18 14:13:02'),(5,'Profesional',30,80000,7,1,0,1,1,'2017-09-30 00:00:00','2017-09-14 21:30:30','2017-09-18 14:21:34');
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
INSERT INTO `socio` VALUES (4,'1094940706','Cristian Daniel','Cruz Muñoz','1994-09-12','315660135','criscruz1806@gmail.com','1','�\��\�\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342�\�\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0cd\"\0\"\0�\�\0\0\0\0\0\0\0\0\0\0\0	\n�\�\0�\0\0\0}\0!1AQa\"q2���#B��R\��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz�����������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\������������\�\0\0\0\0\0\0\0\0	\n�\�\0�\0\0w\0!1AQaq\"2�B����	#3R�br\�\n$4\�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz������������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�����������\�\0\0\0\0?\0��(��>��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��\�\�<M�\�J�/��LdD>g?�\�\�ғijʌ%7h����\�����A♶h�]\�\�\�\�.#_\\�\��\�Z\�\0$�\�ד\�f}\�\��+\Z�\0\�k���\�\����X\�X��By���{���\�\���%��\�Sӣ�֞��3\n��\�_��ܛĺ��6\�_^�\�\�#\�\n��\��\0�|4����[G*�y\�\�?�&ɯt\�|g\�\�,��\�`.?�#\�6}\\\��k�����E�a�\�\�YXF?M\��W�QXK7���O(��\��3F�y\�\�xn\��Ǐ\0��\'��=�lg�\�w�W\�\�\�+�u=R\�\�c F\Zf�����h��\�\�ֹ6V\�\�\�\�OC���\�N?JƸ��\0�.IݫH�\�4T\�\�+���uf�gd0t!�\�Z\�\�\�r�}�\�7d}\�M�+~��κ{/�\��\�hbv��y�ݏһ\�+R_k��\�u\�\r\�\��\�TmF�ԇ��`z�+\�U���6T\�G5\�\�\�b�Ɠ�ݭQ��\�c�ޅ�D\�Q�B���+R�d\�J҆29`:�9����&\�\�\�ޫ!��\��\�h�%r�\��\�\�T�Q���	t\r\Zt\�6�a\"\�8{d#��Ek\�\�BG�\�!T`/\�\\�>��Ko�+�\n�T2(\�,H\��H\�\�\\�Jr[3)P�-\�㙗\�׃\'\�d�ƔK�-�~�V\��^;�\�o�\�p\�\�g�z\�6_5X�\�6\�\�\0��D\��\�\��t�w\��\�j\�[]Y�<��\�s�\0�׈\�Z*\�]Ni\�\�y}�z��ͺL���뗐J[?\����i�k�ֿg\�i�c\��Y\�Q(B9�F�\0����}KE}9���E\�v�?R��\�8�>��N\�Z��x89k�\��u\�-��\�$�\�\�n?x��\���q?̎\Z�Kޜ��\�k\�^ ��մ{�UBH�=>q����_~\�r�\�]}dW\�?�^�\"�ɥ\�gr\�?h��\�d�I\�\'\�\r}Ey���\�\�Z͛ڹ\�\�]>�~�M\�\�Z~�c�\���nb8��pq\�p}�淌\�-�\�\�\�գ�Q^\�\�\�\�Y�?�\�c\�a\"	w.8�\��\0�k\��=\'Pѯ\Z\�R��\�q��\\�\�#\�pyU�(����EQEPEQEPEQEPEQEPEQEPEQEPEQEPEQEPEQEPEQEPEQE\�\�v\�\\\\̐\�\�\�\�րJ� ���\�\�\��\�;[H$�y8Գ1���mw\�:O�b\�r�e`�摾��\�\�W⟊rK\�Zh\0Ɯ�v\�\�o����}�y��\�s;\�<�,�r\�\�Y���k��%-\"{\\�S��h�u�\0�C]����\�\�\�\�\�ZDp�\0,Q�[���\�\0�\'\�\�|\\\�w]>6\���w�N�5\�\Z}��g���V\�ь$Q.\�Q\�+�\��\'\�ڞ\�t\���lx\�\�\��\�߇\�k�wi��fc�\�rI�\�\\���\�\�\�ҡN�妬y?��h�G�u�\���v0|�1\n����\�\�+\�-�`��H-�HbA�D\\\0*Z(��*M��(��(��(��(��(��(��(�%��\0�2�/\��)�H\�\�QEQE2B�(��(��(��(��(��\�\��e\�\�\�\�\�o2�x؃��\�Z��՘Vn��i^!�k=Z\���dPppy�\�֕\�~��,{m�A��>\��\��%\�}\rz���\�j\�kwas\�\r\�\�\�\��c\�|�W��kQ\�\�֛u$�;O=t#\�[»ZKS\�\�e�\�=\�|�\0\�?\�\��e\�\�p9?b�b~��\�I\�+\�u]#P\�\�\�\�\�洺��\�ʸ=q�\�8<�+\�*\��\'��_i\�g�\�\�:�U\�\�!�9����	�N�֊Zj�,o��\�\�2}	?)\���\�8���\�%%txuhΔ�f�|7Ez���\n\���o��3Rҗ����\�(\�:r=�\0f���(��\�(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��x\�\�\�0�h6ϩ:\�b\����z�IE]�R�:�P��\n(��\�\��G\�w�i\�\��&�\�-�\�g��\�?J\���4\�\�yגn��\�\���\�=\��\�CĞ,ԼOu�\��[��ݼg\�Os\�N���jz�엗Ӽ\�����\�Uj\�Y\�N�\�\���a\�3\�]�\0\�\�����\Z\�\�K�&5#θa������\�$}S\�O��/��?\�\�7\�Ky*�\��\�a\�;�]�\��3\�Z\\zv�j��\��Q\���\���Ӣ�(�O@(��(��\0(��(��\0(��(��\�\0f�6��(��J*e�c��*Q\��\�r\�J=nQET���Q\�G\�N��\��B�(��~�\0\�L��B�z�?�;��뿇�\n(��\�V���\�?*�C���4\�ie7��EU\n*i-���2=ECA\�)+ŅQEQLaEQEPEQEPEQ]烾$\�h[,�?2�N\0*�\�HG�9\��\�:�q���3�Fc\�5t!��\�>	Yx�\�\�<>\"�\�\�^H��\�=�z\�99�E}Oa�Zjvq\�\�\�$����\��{cȫ5�w��Y�xV�Ml\�e��\�[1�d\��\�8�}\�|A���N[\�>]\�\�\�l��0\�k��U?S\�1x)a\���s\�GM�\�/\�\�-������r\�\�=\�����g\��Z_��³��P�O\�\�\�|\�}��?��&x�\����u�4\�^\�\�2�\�\\������J(��8�j(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(�S\��0�\�(\n��:�%;M\�\�\�\��52���4�JUf��\n(��\�Û�kY�Z-\"ف��{���\�\�~[\�>9�ð+&Y5I�\�@�7���O|Fy幝\�F�Y����\'�4\\\\Muq%\�č$\�1gv9,Oz��\�\���L$0в߫-�.�]u\�{彽W�E��w\�f#�W\�\�����~��\�\�V\�Y@�\�¡Q\0\0JM7M�\�4�l,`H-�P��0\0j�(��:(��(��(��(��(��*Xb\�w7A�\�gR�iǚAEQ%�<-YUUQ�Z)�-lD\�v\n(��(��\0��(��(\0��(��(\0��(��(\0��(��Z��+�\�j\�	\��aEVC�#a�M�I\�Y��\rf2�b�0E3ԡ]U^aERQE\�(��(��(��(��(��|?\�\�\r\�}b�#�#?vE�?\�ʢ�\�wB�T�,�\n\��i\�3\��#\���`H9�u4M\�\rt�W\�>�������|ı1��oC�zׯ��7\�;\�\�\�}hw�,G\�ȝ����}�k6Z���a&�d�\�Xv#��]Ԫ�=Ϛ\�\�\�	^?>�o��?\�ri��D0\�)@�e_\��\�XU�����x\�\��X]�˄\�|\�>8��Q_\���\�f}+S�˸�㏺\�)\��\0X\��*�Q[&eQEQ@QEQ@QEQ@QES%�8!y�p�ƥ��\�(�h\0��|0\�q<p\�I,�FK18\0Z\��\'�-|7�I}pw7݊ y���=�|��\�WZ��5�\�癷1\�=\0�\0qZ�2�<�&֚`XYÔ���^\�G�\��\�\�םZ�;�\�����C�_��mxC·�1�\ZM�\�\�,�ȉV?\�\�\�־\��\�t�\0h��V�\�!P2~�\�}\�\��k��W\��\� :�\�v���a��x\�w�QE�\�QEQ@QEQ@QEQ@QNE\�\�\n�\0\0\�TV\�-\�SPx\�ڼ�\�[ ��(��)�aEQEPEQEPEQEPEQEPEQEPEQUo!ܞ`�_�Z����NnRAEV5�c�\�e�<S)�\�i����(��)�QEQE\0QEQE\0QEWS\�\�\�][2e���\�?OG\���r\�S�qwDT�\Z�p�\�+\�>+�9�\�\Z�j������q�\0-=Q��\�q\��\�_V\�4wG<.�E\"�GS�\�FA��/�^/�d_\�8�ܓi#�ԧ\���\�W�ס	���\�q4%B��>�m��	\�h捊:8\�+�\�A�W�|x�u�\�.\�\�\�ao�A۴��\�}�x�\'�h��*\��(��(��(��(��(��\�⧉��\�@���p\�\�\�S�\�S]áh�:����\�_\�1\�\�\�\�7��\�\�\�\\��\�r\�ޤ\�6\"�*\�]O[*\��I�Yl�?�^\���cP�oj0��%,Շ\r\'Foà\�\�}y7�����\�G����.\�ȽK~5�Ή�\�h\Z5��b�-\��\�\'ϩ��(��\�>�Т�(��(\0��(��(\0��(��(\0��(��tc2(���>T\�QEqF\�\�R\�E3\�[��\n(��(��QEQ@QEQ@QEQ@QEQ@QEQ@QEQ@QT��\�W�\�\�:Ҽ]\�\��k6�=l$�O\�(��(��g@QEQE\0QEQE\0QEQE\0QE\�\�x�Y#fGBYN#��W�|L�\'��w.\��ȿwr��\���\�G?�\�_9\�Q\�?\r��)%|Y\\�\'���\��\�\�>���K\�\�\�ή-7[\�[C{i5�\�k$3!GF\0�`�\r|i����\'\�\�:xV6R-����=�\�#�\�\����kϾ/�)|_\�\�Z�jV \�l@����?�g�}EWy�\�4QEQE\0QEQT�]F#J�\�\'�\0Wor3��a��Ɔ\�\�rvAEE\�n5\�n\�J��\�e�x\�2y?@9�+\��+��\�Z�Z,��y6Y\�~\0�\0\�\�Ҽ榻����k�\�t\�9�ϩ\'&��.r\�g\�ᨪ4�5\��\�\�\���\0f\�\�|Su%�\��\�?3~\'�½Ҩ\�\�]���\�閨XV$\�\0U\�(���p��(��(\0��(��(\0��(��(\0��(� �Tu-��\�C�)zQV���g�QEQE\0QEQE\0QEQE\0QEQW,��\�A�kn�\�c\n?\�\0QES��v�w�M\�\�DH\�s¯\�\�Q��.8\�ɨK\��\��=Mu0\��K1�q�EQ�*�B\�EVf�\��]*<\�K;4�?@;\n�X�妣4Q�7 e]F>��kn��(����#xex\�R���؊mt>1��Ϛ�:?Q��B�\�͌(��d\�08�\0d\�Mk����\ZȦ�G�ւ�(��(�v�QEQ@QEQ@QEQ@QEQ@!���zZ+\�>���k\�\�o+f\�\�?�L|���I\�]�|��\�\\�\��u��Ž\��<�<\r\�\�?�c�L\�е\�F|\�>g0�\�;l�>D�\�\�\�\�,(E����N8Oο�Ϡ\�j��\�\�W����s<H\r\�������O\�N�+\�j(��\�\�\n(����z��L�\�c|5\�y���z\�[��\rzE|�\�\�S�W\�7άZ(\���\�\'۷ư\�Jзs\�\�\��J齣�W�~\�\Z\Z��\�5\�\�\�Z|{!%x�_�>�A�\0��\�k\�\��\0оi\�ȫ=�n\�#�ﻟp�G\�\\\�Q^y�\'�\�EQE\0QEQE\0QEQE\0QEQE\0QET���**|\'�U\�\�\�\�(���ES>|(���[��\�D˷\�yh[\\T\�I\�X\�t��Oa�v�\�ŝ���\�*\�\��\�iT�tC����(�MW~�e\�\�\�*\�~\�%<X8�\0y\���Z��\"\'��Q^g��y1\�5�#�\�$��֭�ø�\��\�\�b@?S�\�]��P�\�QE\�G\�}&�\�˵0\�)\�#\�\�Z\0\0\0\0\0�_\�G���`��(��(\0��(��k�\�H\�e��\0��(�K\�Q\�+)=�\��2�\�6z�p�j\�!��-�ӵsr�QE\������֔\�?\�ɡ�fQEQE3�(��(��\0(��(��\0(��(��\0(��(��\0(���\�\�_KxKX�\���l\�\�\�\�z�\�L����Mz\���W)�\�\�1s\�\�_�\0d�kl<�+w<\�җ=n�k�\�#�����<>|/\�=SIۈ���q�<�\�y=pPk\�\��\���\�<��+\��\�\�mfb{��\0M�\�\�QEw8xEQT�k�\��{\�\���<- � ~&�ffgvv$��{��/�\�d�d����!�w����T�䏣ɩڔ�\��E�M}g]�\�#ݺ\�\�8AQ�70�k\�h\�\�t\0$H����3\�n����F\�BF\�8\�9p6�Յ}qEQ\\ǰQEQE\0QEQE\0QEQE\0QEQE\0QE\��d\\Nx�(�iR(Դ��UGROA^\�\�\�\�V�J,��?y1 �/��tҹˊ\�F�uհ��+\�\�\�u(���{I�\�s�GQ�\�\n�6Ut(�2���\�\���4�n\�\�G\�\�n��\�\���~N6<(\�\�(��\��\�\�|�����WQX��\���\\rɿ��$�\0Zث[=(��(� ��(��(\0��*�\��\��\�AS\��\�\���\�(��(��C\n(��k(te`\n����Q@Q^M�Z�-B\�\�\��nTg�\��Tp[\�u0�\�IEQ�[�3�kK(Mb}\�\�\n\��M���׌�<��O�#�\0���-��\n(���F\�\�\�$�xd�L}\�\\q\���Z���7uvE.��$r3ָ?\Z�b mR\�1���\���\�\�N\�;p��q�\n(��:(��\�\n(��(��\n(��(��\n(��(��\n(��(��\n(��\��j\'M��;\'��\���x��+��\�#\�*KãR;Ҝ]�ȩ88��\\\�mk?�L*l\�]�0\�v�=\�\��w\�^�\�;\��IQ^9�h\�[�b������K\�{��\�\�\ZȿFΊ�Ϗj\�\��\"���\�K��9�%�������\���Ҭ��\0������\0٫\�+���?�\�\�b\"�E?R\����\�\����|yp\�G�~\�V���D�܊(����\�\�\�\�㿳������$\�߰�\n�?�5\�TQE�\�QEQE\0QEQE\0QEQE\0QEQE\0QEt��[�\�\�2�#K�q��H�^�+�p\�$�OW�e]\��z�k\r�1m\��QEy\�\�1�Z\�̐\�\�Ԇ?\�^�\\ǉ�ɯ����G�%>s(\�Uʞ};Ӗ\�]�QE\�\�@-�\��t�5O\�b���d�QEQ@QEQ@QU.�֏�j\n�\��h�\0v��\�V�EQERQEQE\0QE\��\�?�\�_B\�LZ\��\�~W�\�\�P�\�I��G\��s\�X[��+��!H5��D\�i6q:�u�+u\"�Q�QW*+�\�\�[yRT(\�B1R\�L6\n(��\ZDh�x\�\�)*~��S]�\�{;�ʴ�A�\�CR{\�`��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��+\�\�\0]=\�t�\\\�F/���QX�ei<*�\�w��\����\Zn�G\�b�\�Zk͟�R��M���\�D0�\�\���\��j+�������\�@3YE#`u9e\��;Ep_$�<w��F��\�O��R�/�\��j\�W;^uO��[�V�\�#ؾ\�\"�S��\�d�g9�\0�� +\�k��9�\�6���Lr7���\�\�ET�QEQ@QEQ@QEQ@QEQ@QZZ����\�^6v#\���\���\r{����R\n��Gq_>\�m\�O\r:�\������2c�w\��\\]�7��D�\r\�QE\�V}���jr�Vw�M&\�\��;��\n\��ef�QEQE\n(��(��\n(��(��\n(��]�\�\�=\��\��\�AI����(��(�0��(��(\0��(��(\0��(��\�K�hW7���dC=X�?.��Cw\�\�\�6f�Yx\�,\���\�\�<E\����\�]�yE�\�\���M�T0�k@��+\Z�(�z�EQEPEQEPEQEPEQEPEQEPEWI\��i�\��2\rҖ����J+�I\nQT�ь�FN\��?�^\Z�W�7-����ћ�h��\\�d�Bs��t��+�������k���\�\Zy~;\�\�s���8\�\�1Q?��a�\���/\�\��@\��\0\nt�#\�q��\Z\�\�\�~Le�M��\0\�\� \��us�kШ��*M(��(��(��(��(��(��(��(��(��(��(�\�\�/Y98Y\�o���H�g���\�7WBU��\�k\��\�\�\�t\�k\�\�&�9\�c�G\�r+H>���\���?�QEj�(�<���(��(\0��(��(\0��*�\��\��\�AS\��\�\���\�(��(��C\n(��(��\n(����݋\r*\�\�yQ3�8�j\�r?o�Ϣ\�h�繓��\��]�\ZR�<\�B�(�2\�h���\�\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��+B\�\�K�є\0\�\��\n(�.iz\��~\'�s\�\�Y�*\�\"�\�\"�\�\�\���\�Q]\�(^4w ��\�~��\0�\�^��\�f��]\��d-\�l�\0\��\�\�\�+M���6\Z\��9\�\�\�n>�\0�\����鐭�k\�\�\�?f�Cv��i�?��)ǧ\�\n��W�\�EVgXQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEW�|8\�<\�:}5\�\�m���\��*�:\����\�.�oyϖ\�@��\�\�\�lU/kI\�nQE{}\�\�IcY#`\�\�2�\�A\�N���\n(��|q<��[\�4\�r;F\�\�\�CB�\�QEO���\��\0�\n>�s�\0<��\�V�\�Ѐ%R�\�r*\�\�۷IW�\�P����\�t\n(���4�ǐ�#\�\�Qd_\��}ƺ&��_�q�\0���MV\�1��1�Q�n�>�j�M�\n(��?�o�\��>�\�T�V�Yy���J)\�\�²�	��\�sk\�\n(��(�����(�&���\�	U1[)}2>���\0�z��a�h\�\\<\�!�ï\�^6IbY�$��{\�g�����\n(���(�zEQEPEQEPEQEPEQEPEQEPEQEPEW�|.\�mu/\�Op\���i\�\��\�\�]/\�U���\0CN\�H��\�@�Q]�\�ϗ\�W����S\�\�> �\���\n\r>3�g�]����7�^�U\�ðe�1\��̚+;\�ݙ�\�v�j2m\�\0>\���\��f�����\�-N\���dA�\��\���r\�U�s\�\�*sPq\�\�\�\�\�S�\'�\�,K\0��n\0�d!�麾������\0ax�D\�NGt�\�\0��\�ƾܢ�(�s\�\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(����+�(I\�%	�\�\�V<`�\0	=��/J�*��mƺ��	�ҭ�e\�\�J�ˣ<�V͹\�߰QE\�VN�\�]/ZU�5��\���;��j\��%	A\�J\�(��(��	\n(��]�\�\�=\��\��\�AI�\�`��(��BB�\�@�OjC\n(������\�\�\�.eX�A�f8�\�g\��v�\Z;R/.C�/տ¼�V\�/���˹�Pr���A�i\\ꥅ��z ��*߉��\�u\0\�mb\�ħ��c\�k�)�b��PQEQE(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(���3�kx�M�(]%�|�:\�-�\0��BWv��\'\�)�#;*��\�K\\\�\�k��Z΢���KfX����U��N�dt\�i\�L�^h\�\��AF\\\�Z4W������rm�\�\�#W�>���[��eRO;Y��(�\�( A����C��\�7\�!��\�t<�����+\�>.i>F�i�Ơ%\�~T�}z��\Z\�\���S(�\�Y���\�+\�\�k�\�Oi\Z�\�\�In�.I\�a��_\�\�_����\�7R��\��8��3p�b2ޯ8��+��c\�h��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��PJ�e$r\�^��\�)�\�71);�=z�\Z�-?�A���\�?���\�f	8\�\�EWG������*\�K�\�uo��f���K��Q[\�_\�GҪ�ѧ\�qY��ԚJ.R���(��z\�R}\�q�;����\�`�6\n��x=k��[\�?���\0�\��)�o�K\� ��+���)�QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEW�� \��\�\�+�E\�)g\�9\�\���\0\�C~u\�U\�\�t���6	]v\�z\�\�9\�x_\�h�ZЍ\�p\�5y(5\�\�⿴n�m|3�h�\�\�����.8hӷ��T�\�U�\��\�=��\�[؁kRpJ�\�]ď��ʊ(��\�O>��(�ƺ)\�|-wk\Z\��$��\�d~5\�QJI5f]9�sS�\�+��o\�c\�?iړ>\�r�M\�N����R��f�\��{�ax�u�qms��p8\0�W�9�1\\\�yR���>ҕER\nqٟ#������\�K^u�cſ��\�)\�\�}�\�\�m\�%�+u\�\�\�>��E��(�hQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE\�Z��m\�!U~�-E#\�� �[>D\�r	o`GN��\�\�zE�\�&X@\���k�%(�a��Ω�m�QE�\�]照�-k ��\�+��9\�\�}�D�T\��\�\�H\�fQEGEn\�L��#ȁ��\0|�JM\�Si+���*�r\�9�\0�]��v�\0\�Mz���c\\5\�\�\��#\�~��ѻ\�t\�\�2]>{8\�\�Q�\�\�\�G�l��kS8\�!Ni\�QE|\�Et>0�\�\��\��`�o�L��\��\�~�\�V\r4\�\�~�\��QEQEQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEi�H�]׬�\��<�\0v�?�\�\�QD�B�D�#E\n�:\08��\����.u\�Ѓ&`�\��~f�}��N�p�o\��\�ο=^E�3��ǈ�𯃵-a\�\�DD�?4��t\�#���Yd�g�Wg�س��\'�M{w\�\�\�w�\��b\���\���8?\�FO�N=\�ׇQEV\�QEQE\0QEr�=��\�\�xSu\�e�X� ~`W�\�\�\�\�_|5���5ͼ{l�	�0\�ľ\��=��rbi��{�F\'z�\�\�O�\��M�u\� ��?+~�\�M}��C)�Gz����\�\�Od\�M�ON\�̱�\0{�0z��޸\�(��\�x�J(��(��\n(��(��\n(��(��\���\�!K����r����P;sUJn\�F5�ӡz�\�(��\�*զ�}~\�m-&�\�\�B@��\�\�w��M8�k<��\�>s�t��\�UE\n�G\0�+�\'��\�V\�b����Q^Ii\�\rv\�H��S\�Y9��5�k�\�7z�U�<~��\0J�\n+x\�)�3Ω�b��K\��(�b\��:\r�7�,\�w�S�\0�\�\��=*\�\r:\��!\�\�ִ(��8GdqOZ�\�6�aEV��(\\��TV�s�\�b�\\uS�\�F���FE)�Eu`��)\�\�E,efDt\�dT��u�aC��\��T�}\nr\�\�(���ii��U�Pǔ\�I�5�r\�1YU��@\�\"���\�w�W\�_zn\n;	Tr��QEr�*��q\�Z\�\'\�?�$�6\�QEajM�Ù#I#街#�a\�xcD�ϙ�[�z�]��\0\�kQZ�\�Vqw�h(��\�~h\�d\��0\�_p�FZƺ�kr�\�j?��W��F����\�uC2\�\�\�_\�P��+Ǯ��\�\�&�G�B���JÚm\�1\�\�㪺�#^�Q\\Z\�\�\�\�\��\��\�0�k	`\�\�gu<\�k����QE\��W�\�^\0\�o�\�}���ùs�\���W�\�\�r#�PѾ|�S\��j\�Bt�{�G\�gمQYTQEdvQEQ@QEQ@QE]\�4��kV�ӭFf�p���;�\�I�U*�o����k�Q\�{��\�0���o���]8s\�\�>*��I˯OP���\�\��\Z�\�.\�\�\�H�7@��I���_1�z�\��θ���5������n�\��\�ש<dW�i\��^�oaj�`�1\Z2@\�q\��\'\�ժ(�D�F\�wg�ꚕα�\�j7��\�\�C#�p	=z\��\n�EQE(��(��\0(��++\�Z!\�g\�\��.7F���:7�\�Mj\�I�ՙQ�����\n\�𗉯<#\�KMbɛt-�	#?yO\�~�ՉE|\�cq�\�\�eu�x\\����Uz�����ٲ�Ա�7�\����1\�\�;z����6�7	X��&*8�|\�~�\�\��e\�=\�V\�\�[\\��9\�z�\�A\��_)�\Z��|%�ejR�\0Ģ񱹏H�\�z�:�\�}Ve�FA袊+3�Z(��(��\n(��t=4\�\�խ�\�\�#��[��\�cEDP��\0@+ξ\Zi��/5^D(}\�\'�ν�<-n\�\�\�U�\��5�6QEQEu�8QEQE\0QEQE\0QEV��6\�\�D򼏥eԐ\�\�J$^H\�\�JJ註0��+N�\�\�M�xߠ��s�H\�\�䞴\�\"��\�QEZ\��`�Q\�o2\�\�~�\\�J�����+���K�VD<�\�\��q\�\�0\�O�Z�\��[R�0G��W�Q�*S�\n(��(�����(��(\0��(��(\0��(�o\�cV\�.!�Py�z\�\�2?\Z٢����eӨ\�\�N;���+\��+S\�vپ ���nA�\�\�:˯J\�\���MN*KfQEQE\"��(��*֝�]jڌ6q.&m����@$�\n��\�QEfk�����k�SQ�Go<�}\0�\'\�En�\�\�\�ub�XX��.\\zvP}[�\�\'�}ikh�\Z\0��0�\n\��Ǉ��3�\�ao�?ޚ\\s#��\�\�{[\�J�\"�>_���4\�lr|x�\n�wS�^��8\�\�{ǒ|\�\�2I$Ҽ��<�ř\�\�=I=\�nx\�\�W�2�%ƯzH\��\�r\"�t_\�}\�\�Ұh��+S�(��(��\0(��(��\0(��(��\0(��+\�~#�+\�Rɮi��9\�\�J?ձ�!�\�\�\�}��MtY�\�20!��A���ՙх\�\�S�?0����QY��º\���F\��<8�ͽ\�c\�\�\�\�r;\�\"\�2:�\�\�pA5�\�\�x����\������\�l��M�=��>��=�\�k͔\\]���kB�\��>���k\�Ÿ�\�\"\�5\�U58\�l31��\0\�^��de��*kKg���\�?�4�����\�[I]�Q^�\���^\���37�\��\�+��E\�\nD��G���!X�|\rj��IM�aEQEUQEQ@QEQ@QEQ@QEQ@QU�?\��ER\��J����(��(��(��(��(��(��(��(��(��(��(�9��c��\��G!���\�3�W^�\�?��^g/,����	�#�/Z��\�eUy�\�v\�(��(��U����bp\0$\�9\�TsM�4\�,q ,\�\�\0\nX\�ydX\�VwbUFI\'�\�~\0�P�ŋ\\݅mN\�@�����{�P=2s���SW\�cPe\�P���\���\�^�]ti[ޑ\�\�\�\�Sۯ��W0\�\�\�sq\"\�H]݈@\�M|��[\�L�:\�\�\�ѝ4kF>B�5�y�}8\��\��\�ߋ⩟DѤ)�\��\0����/�$��(��\�\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��$i,m�����2���|?�Fi5-)\ZM8�\�V��W߷Z��FA\�+:�\�ՙӅ\�O>h\�\��Y!�%�\�9�#��R:{\Z�S\�?\�8���A�\��0�\\c\�7\�{z�h��k��%�\��S��ZS�Ԋ\�|g�\�\�i50夳^�OO�/J\��k`�.�u*p\�\0`�9a��rң%U&{��u9\�\�8=mo=t>�\0��q�c��\��\�[o��9d�\�?\�����&\�\�\�h\�m�I`�C$�r�pk���+\�>D��(��(��(��(��(��(��(��(��(��(��(�\�\�Ң�n?\��ELAEQEPEQEPEQEPEQEPEQEPET7�\�ye=��٣d?B1^$m��:�=�~�\'ּ=}{\�k�\r:\�\�g�T(\��$��z�\�\�F\�4{�-eN\r\�k��E�\�/i>\�\�\�5k�\��x�\�\�I\���5\�C�$0\�\�K#DA�\��\0\�{W��&�#\�ueW\�\�p������kO����-\�̷:�.\Zl|�\�O垧\�8�¢�k#Lna\�?wKn�\�\�\�m>\�K�\�\�\�%,�Hp�\0\�$�b�`���zo\�.���ã#a\�\�\Z\�Ϣ�w�+\�/\�MS\�W\rl��4�o\�\�)\�Ltg�=�\�{\�\Z\�(��+��B�(��(��(��(��(��(��(��(��(��(��(��(��(��(��(��\\\�\�\�^H�\�+rH}��\��*\�\0WM\�/k\�\r�\�w����$\r�ȁ�m*{d�F\�\�#&��+��7�B�)S\�\���Zmo\�L�$P\�}k:\�M�IhN�\'\��\0�ִS\�e(v>\��\�m\����\�͸��Gݸr���q��[���Gd`\�pEz���<\��q\�x�U�~�p��O\�s��\ny\�\�\�\0F� �Au`�*\�ϧ\�{\��7��\0�-ĚF��\��\�v\�L\�{�X\r\�+�5\�\�EPEQEPEQEPEQEPEUk���\�QT�\�Ң� ��(��(\0��(��(\0��(��(\0��(��(\0��(��rN�!��q\�/o�\�:��k�Ơ5\�7��s�_^�\���rH����M4V\�I<�Pƥ\�G`��I$�\0w�+\�\��3\�$�).���w(��l\�a��n��\02\� \�\�|\�\�_�!��G��,�\�l\�i`\��b1��\'8 �ۜVm�����@,|\�V~��c\�o\�X[\�0\��\�?y�\�\'�\�&�\�Y6ٴR�ǰ|@�\�\�.�\�\�[\�\�M\����q�a\� �\�T�\�\"�q\�5�K[�7\Z�\�\�ԙ$�g#�:�OEQ��Q\�T(��(�0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��*9`�p�B?³�\�$Nap\��\��ҵh��Bi=ɭn\�,n#���Hf������:{\���Z�\��h�]j\�5xUv\�#��*�.\�\0�,I\�n\�\��W<\�Ѷ\��\�c8�����\�dB����d\Z�&���\�\�I�NA��\�Z�r>\�\�~\Z��\��0ZjB\��_�kv�[\�\�\\�F1\'=88\�+\�b�It\"�}\�\'�<1\ZťkW@�Q!r$�m\�j0*	=�O���*ܚl\�2��\0;|��a�\0ת\�\�p�\�8\��r\�8�\�D84}�E|��\�W�\�n��[�-\"\0�L\�cL�\�[y違\�מ;�7㧁/\�Y���Esl\�\�`|\�\�\�1\�:\�\�2�Eea� �cKL�\�(�\�躭\�[\�\�Ɵy:���\�\�$`�$)\'#�zҢ�(��(�\�\�Ң�n?\��ELAEQEPEQE&\�2,a�v裩�\n��\�\�J[\��\�\\l\�\�A�\�\�Rm\"�[\n+���߄\�le��\�:sA7�gYXd\�\�I\�\�{\���\�Ӽ���\�u�U�e8�\�27r��z�Q\�sU\�H�9�y�9\�c�>�?���\�6p\���\�\�\�\�\�w\�@~��\�����\�&�+h$�yR(cR\�#�UE$�z\0;\�\�Z\�\��]�\�\�\�-l#p�T�<\�c#\����\�Q��=s\���\0�\�<\�WU��!ݑZC�=�\0x(�p8p+\�\�k��Dl\���\�8\�zÚӷ\�\�޺�w\�\�$ϩ�1[T96h���ϊ~7�[\�\�$vr��z�\�\�C�@A\\�����\�Pk\�<e�\�~)�m�\��\�Ә�\�@p]~a�=[*\�#\�gh�6��i�tU�E%wys�3z�ɦ\�EQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE2Hb�,h\�ve�{Y1������P�\�3�fS\�+KK�&��y\�\�Z�헝�7\��o\�q�q���(�\�V$��#o\�\�\�\�Z\�d��\\bO�tQEK��\�E8E\�Tt�į\ZY^����P��\"\�_=pNxY2\��\�v�V�g:\��J\��\0\�QEg^\�w�0o\��\������;ǝ�\�\'���Rr�sh҇dh\�|L�|��>���\���b\�\�G�#�g][_�\��\0\�\�Ew\Zn�ky�A,�;��<�CW\�K�X��m�s����l\�E]\�8\�\'c\�5O��2]b\�\�\�ڢչ`�<�=���v�\\\�u+羼\�nf�|o�\�;�\'\�\0�(��*�(UT\0\0�QA%b\�Y�$��{\�QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE�\�',9,12,1994,'\0��\�*\�s\\�A7	�q��U�\�)��U�)7\�-X�5\�\�$\�h����(��\��\�\��\�xW�\r�B0,��(�^C-\�-��:7\�W�v\�p\�J\�CE#�{P(<�bt2B,\�\�_	��Ӥb�i�T/̈́\�K��ٹ�O\�S9p\�h0�\�b\�\�\�i\�tIL�C.R����,x�\�_r�\�6\�\��)h\�G϶2�\�vyW\�<\�\�ދf\�<\��Mׯe�t\��M�-k\�\�G\�w3H�*Mlz\�j������?]2�\�Yͩ���uN�\n�id�^\�\�_���1����O@�@%z�\�\�\�new�\�\�3覎0[\�ң\�\�\��X��n\�?Sd%\�{0c��qQ\�q\�URSR��3a\�[\�L�1�SUK\�\�\�Έ��B�\�\�(�J�72��ʷ���\�Z\�\�t�|\�Ǧ��\�\�\�o\0�\�*\�s\\�A7	�qp�U�\�\�\�\�Lyݸ��n�Q\�Z��?)޾�P�E�!:\�a�᎝&��GJ�6Yb\���\�\'�叧�\�\��!\�[v8x]Qq�rlf��V6cP\�%̓��J\�L2zC\�S�A�\�[��~R�\�3�3)g�\�P{ܙ�]��zuf������\���\�\\�fnǊ�=�i\"\�	��\Ze[S�9>`��?\nd�[߮��\�If6o4�Q\�:�VؐԶ\�s�q�G\�a���_�mO$\�\�)�B�z��bƠz�@�h`�\�&\�Bi\r�^�\�\�\�\�\�Q���r)_��J.z\�m���U6\���\\D�\�&]D��\�i\r+m�S\n\��\�~B��\�Z\�\Z�\�\�\�R\��\�\�I�\�\�|X�\�457�_~JbWM\�\"��:���\�@�r*\Z�o\0��\�*\�s\\�A7	�qp�U�\�\�\�\�Hx繏����\��FG��}�~\\�\�\�eؑ\�i�\�A��)H,\����uN^��dB\�\�ȧ����\�i\�a����\�\�j�H�Hr�w}\�:��\�L&!\�?�Aa\�Y\�Y\�\�@\r��r\�\�E�圩�^\'���Q�\�_���\�sb9:�E�=*\���-�AeՖ���X�J\�\�F��\�a\�?��\'\�\�\������#0\�\�$\�{\�\�\�k\�7\n@�D��:�o-05*;wN�\\\0yr˫1<i}\�\�3�}���^\��G\�t�\�\02-\�Z#�x\� �Ĝw\�\0>\�\�ߛ�\�F��6\�c+\�\�T��E%)/��Ƶ��ಸצ���҉�\��s\�B(\�RF3���DS	�)�Qyfe�TǢ?N0A뼬(\�U\�L��!�uy\�o\0\�\�*\�s\\�A7	�q��U��\�D\�ꄀ�\�{;(\'(�KB\�,7\�\\\��oY\�׀@���\�/\�\�b\�b6��9pL�+0+V1�$\�2�EM\�\�/j|=a\nn�X�{\�\�j�1\�o����\�\��ɉ�Y�p�m\0\0F�\�O\�$�\�\�i5xa\�\���ܗ���\\\��\�@r2G��#s�\�+on�i\�\�P�\�K��-p5\�p�\n�W\�&�%�\\\�\�0%�T�\�R\�\�L\�\Z���`MGXV����p�,Ρ{��\�\�\�\��cɱ�/\�i\�5�*�q\�u���\�FK\�\�r^�5E�7�/\�\�\�#=���%\"��M\�\��TM!\���tg��)pϤTN�p\��e\�jj\�C)b�\�~{�JK1�RU\�\0\�\�\�\�nɯ_\�S+��\�\�M\�\\\�oOY\�~� �0��o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2017-08-28 20:02:08','2017-09-12 21:47:57',NULL,'1234'),(5,'1094925466','Christian Camilo','Bernal Rojas','1992-09-02','3153946037','Bernal_9219@hotmail.com','1','�\��\�\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342�\�\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0dd\"\0\"\0�\�\0\0\0\0\0\0\0\0\0\0\0	\n�\�\0�\0\0\0}\0!1AQa\"q2���#B��R\��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz�����������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\������������\�\0\0\0\0\0\0\0\0	\n�\�\0�\0\0w\0!1AQaq\"2�B����	#3R�br\�\n$4\�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz������������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�����������\�\0\0\0\0?\0��(��>��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(���\�\�\�\�?2\�d�}X��zҔ�W4��\�m\�V���j\�!��F�q{?XP��\�z(�8���j�\�FJ\�Bҟ\�ʿ�_\�X7~ Ԯ�\Z\�Ƈ�b�G\�\����\�(\�\���\���wR˫OW��3��l�\�\�\�^�\�:�:z	��t�B~\���\�\�:�\�\�\Z=/gQ�:��\��\�? ?E\�\\^[Z�\�<q�3\0*˟\�ZdY\�L\�O�\�p��$�I=\�%xո������;\�S_l�3I����\�\�\�:U\�\�\�	�p�R\�]\��\�\Z�\rŵ����\��\'D\��⾯�4�5�$TEUQ���WW7�\�\"/\�\���j��.\�_\�	�B��\Z+Ω�\�g�G�\��:c�\�\�h�?\��\0�I�[R�(ގ\�\��37�\�]-�\�\�\�\�3\�\�\�\'���\���[���ĺ�g�+\�5�\0\n�뺡97�~�Es�n&[ԗ\�\�V�\�+\�<��?�:���=\�\�?�|~�v?���/��\�gc��\�v�U�\��2\��:�\�9<A�G�_Hq�\�\�Y\���6�\�WZ�����O�W\�r��\��1�E�Ƙ@���\�y�\�?	|w�\��բ\�\�\�3\��ma�»J+i<W��ɸW�h\��\n��oT�6\�\�\��9S�\�s4V�̱pڣ���fr\�P��G�\\|�\�V=&kr�+\�I�\�\\�\�\�\�\�\�\"ac�\�Hz��T~T��\�Wm��[�}���\0���µ-�E�]\��i>\\~\'��Z+����\�i|�\�\�[F_\r\��f��6\�p\�\�z\�\�\�.#x\��\0\�W��%�Ί\���\���{B\'Ͼ�\�}�Ez겺�V�� \�ה[\�\\\�6\�y\��\�\�g\�[�~2��\�8\�\�\�7\�\�\�^�!�=*\�\��_\��U2ʑ��\0\�9b�	^)�x\�C�G*}4\���W����\�\"\���K\�\0��\�W?\�\'�}\�y��g\rj�D��\�e�	3\��1ݓ��\�]\��c\�]6�\�y2\��\��zV�{t�ӭjrMy|\�Λ�Տ�h��\�\�<e\����h�?h�&P>��\�\�1\�\\\rQEj@QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE#:�v\n�d�p\0QE>e��8 �\�F\n���f\'�\0u4�^��\�\�/2\�U@z\��z\��O*n�Oۡ��\�;\�)<�\�\�e�F�\�Vc���v}J�\�Cޗ~���OO�\�~�M\�2��=\�}k\�W\�c\�t��\�\�Pa#�f<(\��5\���\�oZ��\�\�?2\��0��\�\�a\�=T\�\�\Z^��\�|v\Z]�6���ء@�\�\�}I\�\�C�x�yr�)\�\'�ۖ?�A�\�=4�\�Hd�G�\�Vc�Q\�_+�\�\�ĻՕ�\0/��iP�IZ�\�~\�\Zm�K�ݛ����݊B�V\��\��ױ\�]��d�zm����r�AE��\�\�V袊(�S`��(��(\0��(��(\0��(��(\0��*\'�ƛN�i�h���(��(\0��(��(\0��(��(\0��(�?\\�\�H\�Lc�Y�̿�o³��)՝)sSv~D\����\�W⿆>��u9b�a�\0����<rH\�5\�Q]��\�+\�Gq��)���O\�\����\Z\�ҼAy����\�q\�\'<�\�_G�\��\�J��\��\�yX��=i}\�\�~2�\�?�ҳ�\��\0,�\�{\�\�~�O�����\0�\�?	�;\�e�\�\���y\�\�2\�b�q\�\��\0\"�\"�\�\�5�MV<����M\�/��zЯ��Vb�t\�\"p�,���\�\�x\�\�\�\�k����\�Gm�\�\��E\'\�{7���\�G5\�\�EU�QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQYZƹ�щ.|�秹���W�B�Gd��NU%\�vQ]\�Ï�\Z��o��u��b{\�>����\�:��\�\�5}6\�͸|g\�\�\�ڸmW\\�\��.\0~X������ww=\�\�Oq!w>���A_�g1M\�\�;w��\0#\�0�Q������	�;Y��\r\�\�+�,\�\�p�\�\�ۿN8���\�\���,\�(�ՙq%��\�㐃�_sܞ1\��ú_��\�\"\�-퓜Yۻ1\�I�?ʵ(��+\�;(��(��(��(��(��(��(��(��(��(\�3@QQ?\�4\���\���\�sE]�HQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE�\�H��\�\�2�]��ⴟm��BK\�f\������WEv`�հ�\��\�3\n�xV��A{ek�\�\�g{oŴ˶H�P\�\�Ѓ_:|H�q�����c�\�\�e��$���C\�\�\�\�t�\�\�\�*+ר�A�,�m�\�{^���\�=��U\�G\"M\�FV�+\��8�X\�sC~���،4\�J\�۹��\��6�&�\�Y��Q\�k|���;�\�=�\���׮\��ݥŅ\�֗p\�\�.RH�\\20\��QE\�s�\�EQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQEd\�\�iV�L5̃\�_Os\�YW�\n\�J�\�N��IF;���\�|7��\�^o2\ZՇڮ�Q\Z�{�OP5\�u4\�\�0�\�L8�z��Yd�V�W.\�rY�I�I^iZI��\�1\�i���cSR\�H���\��\\.4#e�V\\�W�\�\����d�B��$���a�	�Oo�O�,4�M*\�h\�a]�\�\Z\�T})llmt\�,l�H-`AQ �UX��(�<\�\n(��(��\n(��(��\n(��(��\n(��*9\�\�#$\�Gs\\�\�d���Z�\0|�?\�]Xl\\C���T�\Z{�Q]�0[.\�T\�d\�x�ȷ��?\�ns�#\�\�ݙ��,ri�\�P\�\�\�Z���\�\�.O\�\�(��қ\\��8�F=^�FI\�\�Y]�\0\�bj:+ӧB�?�)Ҝ��\n(��1S�H>��ũ^C�gr=\��uV��ӄդ�%&�aEV\�> �`O\n��S�Zv���\�\����*+��UB�¹_��13���Q]\�\�\�j�6�\n�\���\��=+~\�S��\n\�?�\�\�ּ\\N]Z���\�\�u\�=6aEU\�(��\r��(��(��(��(��(��(��(���zM*Q�����\�+�څz�**�ݚ\"�8ԋ���^q�G\�e��,Z�\�c�\�a_\�͌	�����ҽ���f�\��\'����^{\�\�u�����6���\�\�?�z\n��F�29W\�e��c)�-$�_\�C\��XiP��\��/\�.���\�o�䷺�\�I��Uz�\�\�\�\���m��\0h鈉�ڡ��(�_�\�\�\����\�#\�	��\�y �\'�hأ\�\�U����ԴQEw�\�(��(��\0(��(��\0(��(��\0(��(��\�\�\�\�\���\�\0���\�\�k˨mm�ig�\�8\�A�\�N\0䚫�\�1i�m<����ٽ+ή����y\�m\�9\���oY\�T�/�!N\"S\�z�MgW�\���\�\�\��\�~\�}&\�ay|O���\�\��\�Đi6?\"��\�r2�\�,}}\0\�Hu���\rO�֋m�鐈�m\�j�\�{�\�I�wៀ\��ᄵ`��܁%\�\�>��@�� ~\'�\�iEQ^9\�QEQE\0QEQE\0QEQE\0QEOP\�\"��s�\�~\���\0�S]ܥ��\�\'E\�=O�qw72]\�4Ҝ�~@zW��`~�.i�+��9�\��j\�p��)n\�&��̙�{\�}*\n(���c\�dy��\�(��(�QEQE\0QEQE\0QEQE\0QER�A\�RQ@Q[\�f���.���!\����᫢ѵ:��V̊>R�W��e\�)֤�\�S�]�vAEV�Q^\�QEQE\0QEQE\0QEQE\0QE\��[]�;��rߺs��?\�}>��j+�	��\Z���#*\�cZ\n��?�\�\��n��d	�\�\� �\0����}@��}\�\�V�u�\�So;f\�\�\'ﯯ\�\��\0�[\��E%V3\�*ҕ)�Kt|Ez�Ə�c\�\Z\�\�4\�\�ڃ����o/S���\��r|��(��3\n(��(��\n(��(��\n(��\�<Y��ӡoF��\��\�]�|�u��/\�Q��\�W�K+\�3\�#w%��\�\�\�g�\�eO\��z\�O�\'��\��\�\�%��½��~��o\�|��-=Xu=OÕ�/j�xb\�\�+�\�m�(��4���r\��t�$��Ɵam�\�\�\�q���X�A�*�\0S(���\�\�,\�EQE\0QEQE\0QEQE\0QEQE#0U,z�@Q\\ψ.̷B\�O\�_v5�O�C4\�+uv,\Ze}�\Z��J4\�CƩ>y9QEU\�;G�\�_m��H�~�>��[�QEQ���/���\�׸=\�\�\�¶\���@\�w��\�!�C���΂�(�+���=H�\�i��S\'���\�\'ݳ�_�J?�>A{@��+\�(�_�\�\�L�[B��*�iz{�5���Ŀ\�K��(�(��6_\r\�gu�/��\�\�eςl�\�\�Kz6C�\�\�c�QE\�\�[w�ԬT����\\��k��`\n(��|R�2��p\�r)�Ri5f=��(�\�VxU���\�\�e\�bѓ\�m\�\���5�_��\�\��\�S�4S\n(��(��,(��(��\0(��(��\0(��(��\0(���ey-�\�w0��pz\�\Z��;�\�⹈\�$\\�oQ^Q]?�5O\"\�%o\�\�s{?�\��+\�\��\�Ư���e�?�;}ǝ�\���9\�����z\�\�>�ѵ&\�\�6\�y������W\�� \�\�<7�^\�������\��\�èa\�A{_v׊�\�>�\�Ѣ�M�D\�\�(�\�($��\��&$��WoEW\��UQEQ@QEUmB\�ll&�l|��s\�~u3��\\��b\�\�]B�+g\�^�\�>+\�tXI\�`�ê \�\��PO\�\\����_D?��\�{��\0�z�\�\�\�\�;v%��\�\�k�\\^\"X�ҫ.�\�>��%J��\�}	�?x<i>�\�W1�w���\�r�)\�鹁?@�\�U\r��6pZZı[�\Z\�j8EQ�����(�sP��(��(\0��(��(\0��(��(\0��(��ͷO�9\�\"o\�V*���\0 ۟�\��iE^�W�&\n(���(��\��B�(��\Z����E�m���!��W�\�V�PƱƣ\n�0V\�mV\�H��A��(?\\d�\�5r�J\�2waEQES$(��(��\0(���q���\�QT�\�\���U#e�QEQE�(��+^�\�:�M=��w`g#��\�\�޷��q�Q^<\�\�\�\n��z�I[�,�X5\�J	THG�\��\0*ì\�QEnxt�\�\�\n�n\��\�\\}�\��|�g��/�\�O\r�4QEQEp�QEQ@QEQ@QEQ@QE9�utb��GPi�P�\0�������\�\�%�\�dh\�\�UԌG����KK�]KN�\�p:�\�a\��\�r��_��\�s�\�7��a\��ʻj�-\�}k\Z�}����|�*���\�ӡ���/?��]�˼\�\�F�\0��Q��	\�dڹ��K���\�l�Mo�XAr\�0��I�9��\�\�ʹQE\�s�QEr�1���\�O_\�?�ֺ��m^\��\��\�K\�_�G�<�\0찼�y;|���[K��3\�\���\�Ϫ��eG�+s\�p\�\�`�Mx%}��\�@�\0�k\����2�@%�ȑ�v\�N?\n�EWßBu4QEQE\0QEQE\0QEQE\0QEQE\0QEWR�\0�m\��s?ʭU]K�A�?�\��\0*҇�cꉟ\�(�&�(��<P��+\�4��m��\�<(\��\�b��\�M}�]p֧\�ݟ�:�𮖵[5fQEQE1QEQ@QT�?׷\���*�\��{~ʢ�l�\n(��(��QER;mFoA�\0(���\��mx��1(?���\�՝F�\rBk�26q\�:�b�Vl���+oÿ\�.>��kz�|;��\�\�ַ�\�3O��|�#\�\�\rQEQ^y�QEQE\0QEQE\0QEQE\0QEQE\0QE-�\�\�\�Eqߍ\�½V	�\�\�\�$P\��\"����\0^}�G�	�د��?��+\�{\�VT_\�\�\�\�~G��R�EУ�iV�\�}�]gȼ�\�r1�1��\���a>��]\�\�@-Ŭ\���\�\�O\�+\�j�W\�������F4a�͜\0�b��\���\��Q_^xg�QEOU���s88eC����My�v�0�\�\�b�e���\�\�⸊�>%S�U��\��WZN]\�\�xD#�֍�:�{�2�\�\Z�\��\0��W۵�\�뤋�\�j.�[3��;��:����(�\0�(��(��(��(��(��(��(��(��(��\�_�\r��\0�g�U\�Fw�,N\0��\�H���F�;�x\��`\�~_�����v[��Z4\�g�\n(��n��\��\0\�7�5�Q9I\n�`��yi\�\�\Z�Ӏ\�\�w��\��\rX�T�QEv\�?\�\������Ω\�m��c����>f\�.{�W+D����\n(��(����(��(��(�W\�\���UKq���\�QR6[QEQH�(��7��?\�?ʟE\0QEx\�\���I�O�I\�]�\�	\�:+��h�B�\�1)v\"4o�\0\�8\�\�j-��\n(��|;��\�\�ַ��[4R\�`\�@?�e\�Y��\�.Lm\�\��W\�f�*�n�\�~Gv\Z�m\�\�(���EW�vQEQ@QEQ@QEQ@QEQ@QEt~\r��W�$\�3�\�Ñ�n�r�iW?d\�mg\�T,�q\�\�L\�V\n��\�B�g�u�q��� � ��41\�k]Y#]6\�nr~\�R|��\0�\�\�\��ΐ5\�\�z`�d�k9<�n�`��`��J�(�\�ϕ> ��+��ۯ\�\�\�	\�ğ��su�\�i<\�zq\�����\�E~s�\���ʏ\�\�v�\�\�#\�B+\��O�mӄ^\�u/⸼X?\��\0�\r{ey\��\�5��Q�\�\Z\�I�o��\�?E\�QE\�t�QEQ@QEQ@QEQ@QEQ@QZz$\"K\�!\�\�#\�ɮ��47N;\��m\�\�d�K�\�\�ǋ�m\�aEQ^��\�\�^\�#I�\�\��@�\"\���K���B\�\�\�;~\�3���җC�=B�(�ފ(�$(��(��\0(��(��\0(���q���\�QT�\�\���U#e�QEQE�(��(��\0(��\�<i}��\�؂+Cê@����MT�rK.�#�\'��U\���Oj���&�h���X`�iuQE�P^F%��{\�#\�*zl�؞�55b��C��MQ\\\�Q_{AEQEPEQEPEQEPEQEPEQEPEW�\�Ln,m\�=d�\\�#4U\r9�\����@+�1W\�xi�J0�t�\�|�X�Ԕ{6|%\�=t�j�j}\�Kɠ^s\�9_\�Et�\0��\�\�ƽ\Z�9?���h�/Y}�\�\��\0��?#��Vu[S�\'��\�\�j�~m�|\�d�\�\�}]%h%\�}9�\�\�\�\r<9\�f\�91�\�\��5uU�\�	\�?��]2\�����EQYQEQE\0QEQE\0QEQE\0QEQE\0QE_\�\�\�\'�\�ǵt�łA\�\�\�Ca�\�2\�`��2x\r_C�ca���\�\�h6�\�QEi\�H7B\�\�\�\�\��B�(��(��(��(��(��(��(�W\�\���UKq���\�QR6[QEQH�(��(��(��(��(��\�\�\"�~ya�~5,�D�y~<\�%\�ٺ�<�tW��\�!F��~���tP�\�$\��EUj(��D��(��(��(��(��(��(��(��(��(��(��(���ϻC#��0���S<�\0 i�\�\����C\��t��\��\0^�ʿ�%��\�`�u�\�)>���\0e��~\�\�\�=���\0�l�W\'�\0!��\��\0\�\�z���\�V\�y\�g\����\�ej�^l�j>��o����\0�m���Z۬I\��?�\���lN:g\�\\\��QEfXQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE��K���\�\�G\�9�\0\Z\�k���ȹ�_\�\'\�]x ����9^j.�g��\0L�qдԻ�QEQ^\�\�QEQE\0QEQE\0QER��\0^߇�[��\��*���\�(��(��@QEQE\0QE\�]���\�\�\�OY����\"X\�\�66���)�\Zя4\�\n(��(����\�\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(����\0\�\Zo��o�h��c\Z4���\��\n\�_�e\�t��\�^�\��w��=?��Q�\0\�\�h��ѭ���#\�K�\�Yh�s]O/\\���ϟ\�Yշ⸼�q��zF��?�bW\�c�Ɋ�7��E��5�${w\�k�y�\���m���\�?�Z\�\�˾\0_�υ�A���̉?��z�QEr��QEQ@QEQ@QEQ@QEQ@QEQ@QEt�Uǟb�?2|��\��W1Z\ZEבw��\�\'\�ڽ,�\�q\n�KO�9qt�\�\�\n(��J(��\��B�(����g�c>ӎ8\�P\�Mo�=��(�/\��\0������\�_�\��<c�\�U�\�G�D[\'I�5QQPɡ+�o�����\�\��\0���\0|�\0�\��k�\�\�|�${\�y5\�H�\�*�\�sM�׶aEQs�\�mn�\��GoS\�ֲ*Y\�f�}\�HX��\�QVqo\�GD���(��(�((��+���λrʿ(�+^��\�3�7��~�\��\�^��;��\�l(��(����(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(���/	E\�\����vo\�Ҋ��\�\�hVi\��\�\�E~���&\Z�|�\�|�\"\\\�d�\��gǛϵ|T���\�o==P?�\�E`|P\�?��\'x�\�m�h9�\0�x��\0d���g$�����#��\�k��U�����\�N�Z\�\�\�s\�\\�\��\0�\'�~���O��]�W��u-\�\���\�>G�\�5\�rX�\0\��׽\�ɿ�a�|N���P��ؒx\�\�~5��QEx\�xQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE\�\�\�uGa\�(���~�\�fF�U�BJٳ\��%\��\0���b���\�QT\�>��O/�i�S۰QE�E69T�S\�\Zu{�����QEQE1QTn?׷\���:�\��{~ʢ�l�\n(��(��QE#2��b\0I�\��\�\�g{�\0uk\"\��[��/e+\�\�\�T�+-e\��ΊXyOW�\n(���\�\�3d}\�\�G��\�Q_+V��\�\�[�ҌTU�QEQE�AEQEPEQEPEQEPEQEPEQEPEQNE.\�2X\�\nmi�z\�\�:\��W�	�\0w�\�ZQ�\�ԍ5դEIrE˰Tw\�km-\�\�(���\�\0&��/\�Ϊ4����)i��ʪN3\�\�\�1?�zDQ,0�I�QB��\�}�bI+#䛹�\��\�ڎ�s}pA�\�V�B2\�I?���\�Q]@.m&��H�1^^\�ѻ#2�\�k\�k��-�\�u�X$߼S\��\�|\�a��²\���\0_�\�eUm)S}K�&�&��i��#2Y\�G8\�v�8�q���\�\�\�Hn�\�IȲF\�)�5�-}s�G\�?ۿ\r�\��\\i�l\�\��\�?\r�G�\�=Q_ {��QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE$3\�\�\�O�zڇW#��?\�/�V\�V\�\��)>Y�\�\�pc\"�AEWE\�}\�>��S\�-R$�\�0���@\�\��{�\�(��׸�\0^߇򨙂��\0{\�s\\L\�-#��\�$\�\�r\�B�(�\�y\Z�ܱ�\�۹�(\r�Nr�U��\0��\�Maf\�\���|<W�AEUj(��<�(��(��(��(��(��(��(��(��(��(��(��(��(��(��(���\�\�{��8U�\����딯I�\�شH�<�\�o��\0\�b�����\�)=��\�Ƨ%w\n��\�O\\TӴm\n��V��g\�P��q\�w?��^\�_|\\��$uI\�B����89���:��\��Z�QE}��\�EQX,��F��\n>x\'�\�����M�5�\'�\�QԫPk��X�2����cZ5*�k�W�~\��&�\��D\�\�V�`\�i�,��\�=\�\�=�\��}���+�yX�U\�\����*\���\�\�\�l�\�m�}Gc�Uz�\�pp���G\�FJI4}�EcxS\�x�\��v�o�-\�!�\�\�\�\��0#�(����QEQ@QEQ@QEQ@QEQ@QEQ@QEQ@Q@\�V\�k\���N\�\�\��\�T��\0���u�y\�I�\�\�\�7�\�*�ܗZ�I+sZǑ�\�\�\�\�\�QEq�V�\�}g�1y�?�>N��^��[�\�JJ\�(��(�����\��A\�\�>��q�m(�j�\��~5\�\��VW\�]\�q9?�O\�W\��1aqb`�<�+.rs\�\�Yc0uk\�\�\��\0\�S\�S�D\�QE\�T��sXܽ�\�m�\"=G�A_(��+4{I����(��(�QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE{H�:���2���\0\�Mz�r�\r\���Y/�~i~D�\0tu�\�򮢾\�\"\��7;\�Z���\��\�Ʒ=^U�9��>&_	xSՃp�yv����T\�	\���&�l��<X/�\�O[HL6Ϲ���\���s\��ϥx�QE{G\0QEQE\0QE\�x�N�!K�\�\�O�Lzv?��>�RX�h�)28!�\�+\��;\�o\�|�Q��/c_\�/gQb#����\0�{�f#�>\�\�#\�g�=N\�r\�+�g�\�\�(2�*3�\0>��u|eyq�_A{i+Cso\"\��\�X�?\Z�W�\�-��\�5�6��<���\�ʔ}\��D{j�Q_8z�GEQEPEQEPEQEfg�\�z���=Z�\��:�aJ<\�vAEUjP	8&�\�\�`O��>�*\�F��\"*�{�8j���%\��\0�\�yus�Q\�	��(��\�K;�\��:ir��꿭kQ^�.\�C\�n_;~_\�p\�7�/�\�(����\\c\�\�\�\�\�L�\��\0,�}ɫ4W�O+�\��i����\�<n\"{\��_�QE\�賉,\�=\�\��{V�r�u\�ٯ�\����\�WSV\�\�\�jQEB�\0M���乍\0�J\��?\�W\�\�~ \��)\ZM�䍆f���\0\�oZ#wc,N)a���(��\��\�z�%��噡|l���f\0u��룍\"@������\0W�\�Z�Ƒ�\�yl\�t<�\�;�\�k۴\�\��+��C�%��\��\�N���\�s`3b\�\�O�QV���\0I4��\�ϳi�R�<\�/\�\��?\Z��\��\�QErڜɨ\�\�;.A8\\�QҨ5�G�\��5b�ή\rWY\�M�k��Uh|2h(���\�_\�\�Tmi(\��\ZТ���?��}�\�\�k��\�?U�AEVS#/\�R>��Z���A�q^]~�֌\�\��k��\�y\�\�\�~ࢊ+6���]ѿUYJ6`׃��b0����\�\�\�=J�U�\0�(���+�\�\n(��(��\n(��(��\n(����\�ɨ_EkWl\�;�ʫWs\�(\�ڛ\�W\�0��O��_�Wv]�x�\�7~�>*��M˯@�ox�\�\�~�֮�R\�\"Ȅ\�\�s§\�\��\�[5�\�\�������d\re�HZ\�{�`��\0%{rXv\�C\n[��ƻQ*�@)�Q_�$��>]�\�\�$���\����\��72�ҹ\�\�rO\�j�QES\0��(��(\0��(�\�?\�V[\�\\\�E���!\�V\��\"�+\�t��.�IS��wA^��\�\��~\'^ˍP+\�zD\�\�\'\�bz\�W�\�^QEt�(Ѽ�M��~\�\�\�@���\���j�:\�\�g��\�O�⻟SB�kAN\'\�\�� �\"��/�?Ƨb�\�fm�O��,@��\0y@\����N}��(�����(��(��(��a�\�N�\�[\�8��G�yO�V�}\�aU,/�{\�_�O���1�\�\�ȶ�QEQE\�`QEQE\0QEQE\0QEWM�\\��\�r~t�Z���azl�v\�\�e\�=�R��*.\�(��\�\�/�\���\��\�z\�	 Fve��\�G \�%�摤s�c�k��k\�K��0�F�\n\����;�EW3�:�\�����\�z��6�s�Ʌ�u��Z�=�j6\����\�kZTW<��V�+w\n(��d@\����A\�qZ\�\�\�5e9�>D��\0�>\�Y�\�\�knHe�\��\�=k2��l\�fs�\n(��(��\�(��(��\0(��(��\0(��*�\�{�\�:���)��lfbhJ�\��\�z��X\�t\n(��h�`U���Ⓙ0i�f}�i����(��)(��(������\�;xWt�p8\�ɤ�bm%vQT5�f\�\��5֭�L!��B�1�\0�$\�ܑZ\Z�u]@\��\�>���ƽ\0�\0\0�T\��贻���9v��w5r��+��%?�\��_#\��oR\�e�\�|W�\�x=���Z�46K�*q̄\�=%GC_���\�\�Y\�嘜�}k��o|m\�{�f�l�Al�bڠ�$�ܒp3\\�QEzG QEQE\0QEQE\0QEQE\0QE\�#Ich\�P\�\���\�\�ގ�U\�˖�s�\��z�:�\�\�\�g�t܍��q\�^ng�GJ\�Il�\0OC�	�t\'~�rkK��\�n\�&xn q$R!\�#�G\�_^|.��m\�\��Y�P.�\�v�t���B~=�=_\�|3���\�W�NA\�wV�\�+\�\����>�s\�\��F\�\� 0�\0j�_V�\�M\�j\�K	\�qR��>좹?\0��L�\�/,Ȇ� \�ћ-U<\��� �\�QE$	\�Ή\�y�9\�F;���S�\�QEmZG\�Zƽ��\�\�Q_�R��S�8\�_q�S����P��(��+B�(��(��(��(��(��(��(����#�OR\��\��\�O\\��\�7���\0v2ߙ�\0\�U\�\�839[\r/�\�QEs�\�\�\�?�wu�\�wo��\�\r]C�\'�ƽ?P��)�QEf{aEQEPEQEPEQEPEQEPEV}\�m��\�f�����V�8�U�\�qC\�\�f�\�_��	�\�}_i��\�\�QEQ@�,\�\n(�$($�\0\�J�]��%��\0rMz�41�\�y\�\0n�7���\�U<7\�߲��Oߑ�\�#\�{�\���z���+t������\�\���\0��\�F\�4V�\�4\�$QF�\�݂��\�OA_\'|_��|o�-��κ%��+\'h��e#\�\n8$񸁽�\�\�ך_xzs����\�\��>H��\0`z�\0\�|\�-EQ_DyaEQEPEQEPEQEPEQEPEQEPET�p_\�5�\�nF����\����>�>\�\�\�H�\rz=Eqm\r\�\r\�6�^^e�C\�5��ل\�ʃ��5|9\�=O\�\Z��pa��\��\�Ƚчu>���\0\�\�^\0���x�J�H��%i�v�>��˞�����*���j\Z���\�IkwnI#8?C\�Bu�-��bn�-\�E]\�|?6�\�,Y�\�?{�}ƣ\�\���\0x\��\�05!�ƝUn]~\�\�\�\�b��x\�^g�\�\���\�H\�ӵ��\"q�Ld�\��\�\Z�ʽEWߟ.QEQE\0QEQE\0QEQE\0QEQE\0QE\�x��\�8�\�j�\��\0Z\�\��\�\�.O`B�J+J{�^o+PK��\00��+2�]=�\�\�\�����+���Fm\�T�#�5s\�\�\�%�\�/ ��*�QY@QEQE\0QEQE\0QEQE\0QEQE\0QEG:�k2�\�>+I�nŴ���Q_#ĸv\�N�V�O��\�\�\�\�R�\��jQT�}cO\�t��-R\�;[8s\�!\�{ԓ\�I\�T  ($��z\�;ῲ��Pg\�g�=Ͽ�����xr-0	\�\�-ׯd�{�\��^U�{&�b�\�v�����\���\�\�\�rH�F�Hꑠ,\�\�@\�I����.|b:\�\�\�\�\r\�˦r�Wk���\0a}\��\0N�{\�w\��\�\Z;i�g�e�)\�	ė$t/��\�zw9\�aEQ_FyAEQEPEQEPEQEPEQEPEQEPEQEPEQEPER@ �A�[�P�P�9�~\�[tR��7Pz�\n�Ѻ�1WS�`pA��Y�G\�=sD�Hu\�\�\��\�yIi�\������H\�Y��-Ʋ�b�#�\�RWUuc\��\�\�㨬+�2{\\�<\�\��o�\�Z)�2pkc\�\�^\��G����^GujX��`�\�=#���_\n\�>#ռ5~��M\�ֳ)\�\�\�w �p2\r}\r\����n�q\r��-\�N��\�-\�m��I8ݸ\�*3�\�N\�*�QVA\�Tw����]Y\\\�sn�\�,2F���A�OEWk�Eb�q \��\�b�[�.�\�ee��.H9�ИQE\��\0hY�\0\�\�_�У�B\��~b�\0��s_\�7\��\�ߘ�\0\Z?�o�\�ݿ1�4Y\n\�(��\��,�\0\�\�/�\�T\�\"J�у)\�A\�\�\'��}�\0>\����N�\�\�\�E\�\�G\�C\ZaEU��Q�\�Z\�\�c�G�0��\�\�\�1?�iOs\�\�e\�Az�QL��\�\�M\��d#�\�\\�t~l\�Ξ�\�?�\�s\�\�\�\�lB]\�\n(��\�\'���ʪè&���\�I\�wH\�S��V\'҅QZ?k��\0�\��\����쟝c��\��y\�Q���\�1L�(���\��\0\�d�\�D�%]\���q�k\�_�\��b��\�d�ݖE\�K���R\0��*\�Q@QE$�\\\�#�6�\�e>���-?\�j���\�n�%<�\��z\�\�i6W1\��w\�19ԯ�ο�\�\ZL\��\�\�# f�}�\�\�\�cĪ\�:Z�\0gXr\�b^@@1\�+�� ��\rci�UƢ�\0�b\r!\�>���\�?L�\�c+\n\��\�#\�o���[TT@��T\0\0��e\�4\�\�\�+�c־!�d\�|\"\�i�r�欝�f$ \���Ӱ�J���|K\�wŷ	&��M<q�b��\�L�I�y<�`\0\0\�wy$gvfv$�1\�\'\�\�h��(QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEJ\�K��%�\�\��{�qޱ\�4��ʾjv)\������ml\'΋\�9��\'�]Px\�E*�1\�2:�2}M{��h=+Po\�[q�σ��AhOS\��\�� cvNO\�+\�+���\�\�\�\�9�%c\�\��b��Д\��1\�\�QT�܇\��\�J\�4\�r\�ot\�\�n�\�|M��\0\�a\�[d�E]��4\�[Q\�.R\�N��\�t\�\�!r��8#�GW��{\�\�t�Z��S�R�|\�Ċ���	c�\�\�\�\�J*\�\�]\�9&\"\�\�9\�\�֪2�1VR�:�0ER�d4\��E\�\�\�\�MDA�\r֙3�2H�\�q�1\�\�E\�}9��G�5���\�֬\�\�q�4,��9�\�a�ӧ=)(��b6袊+\�u�<\�ڋ\��\��߇J�*\����\�8�.f�,�\�;��\�Wfpf8omF\�u���Q\\%u�-�\�l�0Ē�\�\�v\�ְ��?�^�a����\�\�W_W7\�\�\�p�\�~�(��(��\��(��*x,��q\�\�\�\��\�\�ғin4�\�(�n�\�m�\��\�+x\�\�*\�\�d�$\n\�uϊ�\�|��Ւ{�T7�n73���xV\��=�\�\�AEm[�f\�\\�8Gq��~�ֵ\�=cզq��<g\�;}sP\�.��o�\�Q^��\��\�;Ǡi&`��f�$\\|�� ��\�\�Ӟ<�\�?<Y\�Dx�uYE�����\n��\�ܠ$\��?�\�)oiqv�m\�i|\���e\�U\�$\�-?��\0κE�\"�Q�\n0:�ɳE��<G�/��\0SW�N�[�\�Hm�3�w\�I\��W���\�A-��i�3&�\�\�\0��	\�g\nx�g>A$�,�$�\�\�r\�\�$�sM����Ej�;�\0_Z��)Y���\�\�$����\�\�F,�HrI$���\Z�EQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QES]E\�\�}\�PJ�Ѱdb�:pEUw\�l\�9h���U]�KVl�*�@\���(�m�X,�����\�z=�\�\�\�i�vHnAb\0\'�ׁϵt�_\Z<yad��kfEL\�\�%s��Y�\'��J(��\�H\�\�*��\�95�\\�ڊ+9JW\�Q\�xs\��\'�H\�\�\�ndPs4�2�rz�`�\�Һ�[� �?c\�?\�ԟ�]V,V\�Y\�2 r\��>�f/\�0�\�QS)\���фTH�k�G[�\�dk]<������3|L\�D.�\0f�\��\0�O�袺[?\�\\Z��$\�9�:�*�~ӑp\�4�՜\��\�V�ʹ�\�h���\�\�\�\�\�Y\�w1Al��c�*��p3��rs\�\\\��\�\�_5\��\���\�R?N��?�h��Eci+h����\�\�V���\�u\�\'�\��\�V�\�\�^Bw�9$��T袊(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(���\�',9,2,1992,'\0�~\�*\�s\\�A7	�q�U�ܐ+p#��eӮyOf&�1�\�<g`O>\��3�w�\\\�ѩ\��I���\�=Տ�\�\0\Z\�K�\�V7P�k�\�m\�%ׄ����eǨ���&Ȭ�\'�Ս�\�=�\���\�N\�J(JD�N�uƧ��z\�\�k�B�����P8���_3��Hg�F\�\n�\�Cя�\\2�\��K2�7#sճ�\�~3Ə\�H��d��[\0~Ŵ��e�Kxg+hq��\�rWs�O�V��9\�	#e\�\��^U{u�i\"7\�0^�5�\�$k�y1q�-D\�~��c��oQ<\r�/���ҊM�GC:T�n�cH��J\�qRoerm�V<b��4��O٣��8߇��VC���7��x\Z�����d�\���g�\����0>\�2�\\y70%��\���\�^\��K���ro\0��\�*\�s\\�A7	�q0�U��Z˝^S)rH\�\�Y��D�N1�F?.\'x\n�l�#\�\Z�ՙ�t1�1ѹ\�8#\\\���\�Ii)\�DB�ټ �@`\�\�\�v[�ԇ�\�1k��0\�co��/Q�sC\rII\�<+U�\0y�#l6\�v�]�D1���\Z\����Qi\��\�uά���\�;X��K\�}�8�P�(��\Z��\�z�\�\� \�!>�=\'#\���& \�kVWs�A�Xsi��O�LPȆ\�m�s{/h�Үѧn\�\�\�\�\nIU\�\�\ndz\�(_]!�<r�\�\�)\n1P%\�m\r�\�\�ȆR�j�hAL\�J9�듸\�nޱ\�]\n��\���x��}Vp�ߦ.l ���\'{\�t�\�\�\�p\��?J��o\�\�/��2ͫ\�\��v}~�O:l�\�\�GEdw\�]�o\0��\�*\�s\\�A7	�q��U�\\2*��E��\�}Gˍn�\�p&�uC\�9���P,�\"ץ�e\�4ߑ\�`S\�₆i�|�;��#|��!K\�\�*��V�\�\�\�Ab%ˏR�\�\��\�\n\�eMpF\Z\�|V@�p6t�h� (G��}`V\��G=\�\�;1\�\�6|<m�S\�QT\�\�J�FN�c\�x3\Zx��T\Z\�/\0e�Bu\�(\'I~p�EY\�M�\"#:\�\����o\���\n�	\���x\�\n\� |�q!�\����E|\�_��ݼGX�\��v\�E�W5-�7�<\\@ܸ\nt\���=Fb��\�\�b6A+z\��$\�cK\�\"D\��|�#@n�x\0�]\�@\�-�6~�c\�7�P8\�\'SY+j���?q��\�E�����{��\�\��\�c1�Ȁ\�<4��Qpsơ\�\�\�L�\�\'K?FOk\\o\0\�w\�*\�s\\�A7	�qp�U�\�DY+:�^}���\�\�\�4ԴKd7y��@�\�`����t0�Ueg7��fW\�F��\�Uj\�\�)�*�S���Cvy\�v�d�qҍ�\\u&qV\�\�\�`\"\��h��s�\���:�j��\�ǅP=8�R�(5Z�\�\�\�J�|��`��H\�׻\\�\�\�4y���\�]\n�Ǫ�\�1s\�<5�t\�fha�E��]����\�BF��[r\�O\�Ӌ\�p�/J\�9\�f��\rҏt�ް�p\�9��#�\�	�9u\�n\��E�7xI����k���]y/\�\�	�gb/��P\�(\�n���T\�Yj�Q	F��\�Z\�\�Q\�u\�\�\�c/5\�ڣ�1���I��\�<lL�M��\�U&�xLWj�g�H	0Y\�4��\��\�\�\�cC\�6o\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2017-08-28 20:05:48','2017-09-02 03:59:45',NULL,'4321'),(6,'1094916671','Estefania','Arango Centeno','1990-09-03','310000000','estefa@gmail.com','0','�\��\�\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342�\�\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0dc\"\0\"\0�\�\0\0\0\0\0\0\0\0\0\0\0	\n�\�\0�\0\0\0}\0!1AQa\"q2���#B��R\��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz�����������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\������������\�\0\0\0\0\0\0\0\0	\n�\�\0�\0\0w\0!1AQaq\"2�B����	#3R�br\�\n$4\�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz������������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�����������\�\0\0\0\0?\0��(��>��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��\�ּU�h\nE�\�i.2!O�C�\0>��M\�(��|=\�\�x�u�G\�\'�\�ˍ��8$�\�\�\�\�\�\�	\�\��`�\�\\�͏e��\�uO\�z\�\��\\J�\� \�S���o<��\�\���dc\�$\��V��\��\�\\��z\n�}ᧄ<;嵎�nf�8�a\�?>\�^����\��Q\�ޭl�\n#y�>��\"�k\�\�4vww,;�#S��J�z+e��\�v>I\�<\�]y�\�4KˀWpaU#\�\'�\�#�|�m�Ǿ�\�O��w\�\�\�{mQ\��UUQ*��\0`K^�w�T�?d\�m!��\�!�\�Ǹ��♳��(A\�	�A�>�\�R�\�;#\�l?f��N�\��$\�-\�\n?2Mt��\0\0<\rđ_\�u�\��\n�\Z+��\�&�;����\��\�\n��+���sQ\�ܸ�F�\�\�`8�~xl�ݹ\��\��\0�\Z�\�Ƹ_i\�u��\��뭢�\�)�?�\��\0�.O񧧋�I\�뚁�\0z\���\�=Mr��r��|�\�/��\0\�8�\��]\�yF\�:x�\0u6�\0#]u\�\��\'Ű��Ջ�\��\�\��%sZֿ<A\n�\�mcpV1�����y�.�@�\���;��6x�\�;�~�5�}�8xvi$k=[Q�\�l�/\�	�\�\�\�a��\�f\��\"x�9h%s�;�u\Zw\�?\�[54�F\�rx���Z�ڊ\�\�\����u?\�\�_��v��Xݱ?rEh�^k�\�~�\�C\�\�Z\�į�I\0�`9�+\�\n+\�覎x�XdI#a�t`A\�S\�\�\rSP\�\�2\�^\�[9\��d+�c��\�i?��B��A�y9lyR~`m�\0\�ka��\�V>�)!���$S�V �M��u�\�!�ǪiV�Hf�n�\�޼�\����w�MP�\�\�6\�7\��\0\���\0����\�4O��ֶ�����\0�WXOɾ\���\�]]`\�\��]\���\�g�|0Y\�Ǟ\�<�Pd\\\�?^�\��\�QER\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(����j6zU�\�\�\\$\'Ws�S\�(\0����闺��V:u��7R��K�ϭZ��\�G�\���\�s�-�\�H~��G\�\�(��y�\�D\rim\�\�����\��}\�J�\�v�˻f9,NI5\�O޲)\"�t��\'�<cr\"\�l��\�uħdk��1\��g��e��(-\�\Z���g��+��\�\�\�\�NH��o���\�\�\�\�\��\0\n��\0�\���\�_���\��\�a�\�\����w\��b��ff,Ė\'$�\�4�WTb��\�~�\��eƶ\�V��q�A\��{�\�\�^�okoi�\���tH\�(��h��(�QEQE\0QEQE\0QEQE\0QE	\�h��4R\0��(��(\0��(��(\0��(��(\0��(��@�\�҉kve�_�v�\�ê�W;E&�Vb�]J��V ��+��g\�\n��<�hl��\�\�V�+���C�\�=+���\�\�tmsll4\�\��I�\�s�\���:�\�\�\�\�|/�W�\�H�\�\�\��\�\�7��9\�\�<?X��\�|�\'���X��lG?h�S��^��3�\�\�y�}�ʮ�YC+FA\�><�-���e�ӑt\�L�\�\�_�V\�~e\�;�x\�\�+\�J+\��(ҼMk\�i\�u��I��>�\�\�2=\�f�Ziْ|�Enx�\�:τu�\�\�d,�\�o�o\�ס\�XtQE�(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��(���\�?#\�̚f�\�%�\0+$�V\�\�\�˿�T`\�\�(��O\�\�+�\������2�\�<�\�\�_O¶�Y\�}?\��\�\�Ku==\����\�|C����\�j�<\�xHǢ��}k>y溝\�W�Y����>�\�u\�N���iX\�<�\�Z�\�\�qlc#λ�|�\�A�\�\�+\�oxD�E��O�^Ṓ\�Ec��{u<S[\�n�e�\�\�e�\�Gmm\�G�n�(��QEQE\0QEQE\0QEQE2Y\�7J\�G�&\�Յ�QE>�ȟZ\�G�\0��onf��6=�g���5�=(��\�?�\"/�\�\n�\�ڃ��?\\\��\�K�4Xu\�(��\���?떞��ݕ�W5E%��T?��\�EWSEsQ\�,_rF_`j\�:��Īz�\rmdĬg*[Q[4T^Cp>F���x5=u\�JJ\�Ŧ�aEQES\0��(��(\0��(��(\0��*{+ۭ:\�;�9\�\�3��6�\�\����\�i\�Ɏ\����?ݎc\��\�?�=1����t\�֢j\�v��\�\"Ӟ\�U��\�\��\\t��\�J��\�O�\�\�	����^�J?1P�<>��׮:\�\�\�t��\�Q\�2��d_X\�^1\�o�Ri\�V��H\�\��خO/�z�\�=\�1\�ȒƲF\����!�\�A�	\�pvd4|E}	�K\��ʓ\��,�/=�1��\�\�~=rOϲF�H\�Ȍ���+GPE:�(��QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQ^w�\�_\�Q���\�>\�뉥^|�=��G��*rv@Q^���\�d�-�]cU��G��Ua���oq�O���\�\��>�6.>\��(\��\0���ާ�ק�I$��\�\�\Z+ф�i��!o<>!�t�;�\�`\�S�\����\�����6�\��qF0��\0��,h��aUF\0���(��aEQEPEQEPEQE��\�eɆ\�tf���Z����\'dQEX�\�V\���a�5�$�L\�\�b\�{�e\�U�*�S�\�v\n(��(��,(��(��\0(��(��\0(��(��\0(��:���k��d$�e��q�5�E\\*J�d\�*J\�(��\�\�\�E�OB)\�\�Z^=��\��[\�J�FT׫F���\�:�\��QE�(�� (��(��\0(��(��\0(��+���\�����\�N\�in\�+u6\���\�?\�\n��EIY�+ž.|\"�Y�]{A�c�E\�ЯP?�����\�_W\�$sD�\�\��WS��� �\���\0�^;mt\�u9I\�do\�\�\��=\��\0\���\�\�^\�^}Jn̖�|$o��\�\"1VF*GPGcM��>2|\'\Z���#\�-�\�\"]\�6�2�\�������(��AEQEPEQEPEQEPEQECYխt=*}B\��\�\�\��Q\�O%}U�G�׵{m2\�3%\�\�@=I��\���4��쭨\�!S\��\�\���O\�ׁ\�,�J�\�\��9,\�\�%�\�I��ֱu�\�\�\���e<(\�\�G����iS\�^e�c��e\��x�a`c\�m�{�I\�G�G�>\�������aoci\�ob8\�T\0\0��\��g�\�\�\�}*\�r\�(\�\�\'��tQE�(��(��(��(��(��*��ȵ�g|�ޔ����+� ��*��}�\�Dy�2?�cR�Y�\'$��i+īQԗ3;\�dQEQEfPQEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEU�+�m.���\��\�Z*�\'̅$��\n(���C\0A\�<�KY�U\�A�s\�\�´\�ڥQT��8gW`��(��*\�\n(��(��\n(��(��\n(���\�\�5�<=�L|\������fO�\�\�\�`�ӣ�\�%�\�$BYN\n�ЃQ8)�14#*�u�0AW\�?~\Zc\�?�4�O\�f9���n�{�\0�<���A}e�c=�\�k$��DeF:+\��+��\'��\�:yH�؎\�q��\�=�?0k��:Qqvd\�]�ďO\�Ki���\�\�i!\�\��S��+���(�EQEPEQEPEQ^�/\�\'Y\��k!66lA�\�I:�:\�ֽ\����<\�+{w�� \�����\"�����\�) ���xh�?�$��b��\��<\�Oׯ�W��,�cx\�\�V��6\�Mvq\�\�x^��1Ͻ}�I)k�4P�=\0\�QEWaC袊(��\0(��(��\0(��(��\0(��+�\�n<벀����\�޷n%�-\���H�\�(I$�\�5Í�d���Ў�\n(��(��Ө(��(��\0(��(��\0(��(��\0(��(��\0(��(��[\�\�W6WW�D\�oj\���q���(��QE\0QEQE\0QE>9\Z)E\�5\�F\�H\�ף�\�+gI�}�Fz���5ۂ��\�\�¼t�QE�EW�r�QEQ@QEQ@QEQ@Q[^��נ\�\"�$\��\0~3\�}{�p+\�+[�om\"���I\�7H\�5�z\�\�/n�_\\\��.e�\�q\�\��\0fV��|E;�dKG�\'�Px\�\�\�\�mU��y��\��;\�s�g5�ʹ\�wR\�\\!�h\\\�\"��\���\�n��<\�:�x�\��=\�	v@$,���q�à\�\�h��\�$�\Z(��(��\n(��(�[\��tO\n\\4o�\�\��,F\�\��S�\�v@Q]�\�\��\0\�W\�\�)�,M����E\�S���y��A�\0	���\'\�i\�m�Ш<�\�r~���f�+ԊQVE�C|�w�\"\��{��\��\0��p����28�;ף\�*�\"�(UQ�\0���(��(��(��(��(��(��(��(��fM�A��~k�5\��\0P�\�\�X�\�b\�곲���(��(�cP��(��(\0��(��(\0��(��(\0��(��UR\�A,N\0$\�ET�\�\�^\\\�moI4�z�k\��oZ\�\��D�k5\�g\�2���\�\�>�����E�j��c�BE�\�g�X��\0ُ\�8�������Q_0\�ZMa{=�\�h$1��z7\�}\�j0\�P�\�q\�$����\0�לէtEQES\0��(��K\�+ٖ�U�\�{�\�kEڢd\�W�\n(��\Z(����(��(��\0(��(��\0(��(��\0(��*ޙ�O�\�v\����ky��\�c\�z�T��\��\�}\�\���\�\�\�\�c*��o\�a�pA\�5�E}K�\�Pj�]��lن\�0\�\�=A� �*\�yo�\�u���\�\�bL?\�g�!8a\� �\0��z�y�#\�&�g����u�j\�Zm\�e.-�h\�R\���=ES�j��|(�v�k\�+t�\�\��� ��F +\�h��*\0(��+\�~+\�n�2X#f+��7�	�6��״]\�\�eg=\�\�AH\�vU?ʾb���P\�./f9�\�V��\�NMt\�ys\r}1�;�tX�b�\\�G�/��\'\"4��\'5�e����p\�»��E�������\�zDz��\�* �m`X�\��9\�EWif�QEQ@QEQ@QEQ@QEQ@QX�\��\�\�5�[\Z\��\0�o���z��_\�gm/�QEQ\\\�EQE\��K\�Χ\�e[�Oش\�\�g\\��\�/�\�\�Cv\�QEq�W\�ZW\�oiJ?\�^�r�]�3?���WI�c\�\�\�5�H�\�Ts�\�QE|�E}W6��\\�\�\�e�\0~o\�)m��>у[X\�BGC*�\�Q\�\�EW\�\ZG��\�i\�\�\�$G�[L\n �=׬xS\����J\�\\0�\�I�c�\0tz���Wd�\0}���R\�\�AEQET\0QECZ\�`\�4{�:ㄙp�u}+\�-F\�\�K\�\'��M��\�Q\�z\�ӕ�|I�\�l�\0�\�c\�\���s,c��\��U�\�aEW�\�E�QEMi�\0��\0�*\Z�b7^\�=�WO\�^��\�(���(�p�(��(��(��(��(��(��(��(��(��kA�5���#�@%�\�c<7B\Z�`�A�E|�_E|>\���a#8i`_�Ɏ\�8�+��5ˉ�\�%��\�\�\r��<	�Y,a�3, aבϧ\�\�\�+\����\�f��\0�\�-^\�Q\��\�	q�Q�\�\�9�t�QErrTQEq��/�x2xհ�r,��\��R?\Z�j��wۯ4\�<�L\�\�q\�?��/�C�\�\�}�gD]o\�f��0\�\�ue\�;G\�_`\�\��\0�V�wk��c�\�8��s�\0|\�\�QE�(��(��(��(��(��(��(��(��(��f=\�A��0?�J���\�/>\�H���Z\�\�Y��\�\�O*�1��Ի�T�`��)�QEq�Q]\�\�O\'�����v�j\�(zM\']�A�?P;׽*�(UT\0\0�\��%4_	\�\�j�\\B�/�vo\�\��\�ɻ�);���(��)QEQE\0QEg�\�o��ӟ\�\�\�jM��(��(��(��(��(�$��\�6��MgH��/q�g�(�\�\��\�\��)�9�o\�8�\�K\�d,w=�\��\0��\�\�\�\�ZF](� ��Rn�-\�T\�7�}\�p�^[K�\�Y]q�Z\ZL[-\�C\�\�\�?ɮ\�,y�#:�\�aEV�Q^�\�QEQE\0QEQE\0QEQE\0QEQE\0QE\��\05<I�\�N\�\�[�װ\�\�\�\�\�~U\�\��8���t�\�V9\�@\�\����\�YՍ\�ИW\��\0���\�\�\�:\�q\0��[K&yf�ǰ\�_DW��r\�N��\��D�^[9\�X\�(\�Ț�\Z�(�8�\�(��\�e\�ڼsx�\�`X\��\�\'�&�\n\��=\�\��S�Ϝ���i�\�@�1YU\�AZ)���\�\�\�\�3���\�̲�+����\�\��u\�\�|6�k�\��\�c}���\�w����(��aEQEPEQEPEQEPEQEPEU\�K�Y\�!�����Ǣ�s�W�\���Zy\�nd�<�Տz\�>Y�����ܡbC霓���\Z�|uW)�tF\�Օ(���\�G���_\�\�-k!-u�M���\�\�\�}�__[2��V��FA\�\�2�Pd�K�\0*�r\�dN\�\'��?��rF]Έˣ\n(��d\0\0\0`�R\�EA�QEQE\0QEQE\0QE��\0}���N�\�SM�6\n(��(��\n(��(��\n(��(��\n(���\����X�a�\�G�5\�~.�\�z\�r٩[)�E\�\���\0/ƽb��_h�~�|ѯ��Щ\��\�\�]8Z��EّR<\�\n(��~�(�x\�\n(��(���QEQ@QEQ@QEQ@QEYӮ\�\�S��O�o2J8\�\�U��AY*ӓV�a!!\'��?�ֽ#*�u�0AW\�4Vw�\�k�\r\�s�ޒ\�\'?R�\�^[Vd\0\�Z:�k\�=R\�+�P`\�Q_4\�Jg��S���9�9�袽SC\��o\��6�Gk{ ~�UQB��\0\0�QE\0QEQE\0QEQE\0QEQE\0QEQE\0QE\�N��Uc\�?�ƻ\��\0\�P\� [K�%��?\���R+׫\�\�Fՙ\��(��(��\�((��(��\0(��(��\0(��(��\0(��\��\�SM�?\�o��ԛQEQ@QEQ@QEQ@QEf��A�5n�\�\��R?�iW�V�\�JM9\\y�G%s\�E9\'���\�Z1\�\�Lݢ\�QE\�tQE}\�QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE}��c?�4�8\�\"��\��\�C��\�_���\0ѯEy����>,��l��<Ak�~\�\�cw\�\�\�EY��1�W\��\0�\��\0�-\�QEz��\�TTs5ō�\�\0i#W t\��袊(\0��(��(\0��(��(\0��(��(\0��(����\�b����m�L�\�\'\�i]\�(��ƽ�i\��\�ب��샂=\�\�|#�^\�\�\�;OHm\��N\�R_s��O�J�j+swgw*���(��4\�\���\���\�\�ʩ\�2\��!s��ӯ����\�V3�m�f�%�\��d���W\�5�V\"J\�(��(��D�QEQ@QEQ@QY\��\�\�i�\��\��4ړ`��(��(\0��(��(\0��(������m��넷�p]\�p2{U�򏋺�y\�x\�\"1��G�\�_\�w\�N*\�aEWS��F���n\��}>>X�\�\�\�\0�}�\��]z�X\�S��3�����{Ve�W+�Q]4R,\�,�цi���HZ)#?\�r?\Zүr��\�pN<�h(��(��А��(��(\0��(��(\0��(��(\0��(��(\0��+\�_��O���k�\0�^�w\�u+��\0Kc�\�#\Z+ͩ�6|m�{�J���\0]��\0E�ߋL⧈9�\0H�EW�\���V��\�1\�\�ϳU+\���d�1�\�\��\0}�\��5`W�t�g\�~�[\�\�(\�\�-�\r�\��kb���\�|,\�\�[&(�\�F+���\�(��(��(��(��(��(��(��(��k\0�;0��^�#5��N2?k:���H�;I0��+���+\�;(��������-o3�\��p;\��?\\\�\�\��?�I�ǈ�r,.q����?�4�����\n(�����Y]�V�)k# ��(��U�p�y��(����� �����\0\n?�\������\0\n\�\�\�\�\�\�(��\�_\�\�\�k�:�$�&\�\��\'�\r�����\�K\�L\�\��(��稫z��V�^TL\��wA�\08���Vv5N\�\�(��(��C\n(�����\�\�k��	(]\���n\�uIu�f\�Q�\�\�!`?�:�\n�O�~\'\Z��{�\��O\�^[Z�[Q�QEQVEV�����\�Z՟�Ƕݜ��x��kB��2�$p\�w�\n(��(�� (��(��\0(��(��\0(��(��\0(��(��\0\�=(\0����smcq8\�b��g�5���m���4x\�{H\�\�Xn?Ίձ�[kD9X\"X�\�\n\0��W�\�\�\�ω�oz����۩\0�҃��1~TV=\�\�\�\�\\]\��瑤o��\�Ex�ū?���;�.m���\0h�\�/\�\\{\�7H\�\��\�	�M�q�濭x\�z]\��[J~\�z�\\�/P�b���ʁ\�Py�A�d���\0gMW\�4�\�H^ڒ	=\n�\0\"k\�\�(��\�aEQEPEQEPEQEPEQEPEW=�Y�i˨�Ӝ�c\�Tk��$�6�\�U��\�/l\�\�m��?u�k\�\�\��4v:\�T\�\�\�QEV��+�\�(���8V�?\�se\�\�W=G��\'\�\����Y��A �\�Ez\�>\'����͇��^�\��	?��\�֢Q\�\��(����)A\�E-AEV����\�q��h+R�\�ҫ2�\�#\�kh\�iY�J�z���+����\�B0�^\�\�\\��J\���v<&��U\�DTp\�v(�I#\�+H\�,\�$\�h��:B�(��\Zx�\�F\�����#<\���\�?_΢��l�7[��\�Ra�Ş#��\�Z����R�[\�ɚY\�9fo�����o�(�f�K��i��I���\'�4\�(�@(��*[x\Z\�a\Z�\'\�Sb�\�F�$\����[E�y\'\�7�ta\�:�\�c:�9W�QE,h�ƨ�\n��E\� ��(��(\0��(��(\0��(��(\0��(��(\0��(�Yh��K�+�^\�7�������\�~i�\0j� �\�q��P?\"ߕLݢؘW+�+T�\��s�ݬ\�>\�\�\�\�\��\0(ߚ\�\�h�c\��\�\�\�\�{r�?6\�\�?L\�Ҋ(�0�\�*(���c�kxKR�Q�1�w/\�\�~5�}W_7x�I�\��E��]���\��\0q�_\�\��,��Q:\�#\��7\��6\0\�\r\����\r�\�Bk\�\�etWF�29W�5�o\�\�|<\�\�\�\�}�bq˧��k�(���ʊ(��(��(��(��(��(��(��(��(��_�\'��H\�\r\��f�3l�F=��T\�\'�\�\��\n(��:(��\�\n(��(��\n(��\���5-3Q�\�n	���d�\�愱\0>����^\�d\�\�\��\0��F�\0�\�?�b\�\������\�{�$QE\\��Y\�F�(`\�jH\n(��?\�o��ӟ�c}MI��5\n(��\\\�\�h6�渋{\\u(2Fz�ֽ\0+\��0�\0\�\�c�\0^��;U\�j$\�(�<yY\ZI�\�噎I>�\�h��((��(��\0(��\�\�a����\�V�S\�6(=	�\\�j�J�lp\�w�\n(��(�� (��(��\0(��(��\0(��(��\0(��(��\0(��+\�>\�f\�×:��\ry6Тp��\\~\�\��J�F��v\n�:�z\n�C\�FЬ�\�\���\n�\�\��G�9?�s\�eh۹,+\�\�^\Z��#ӣuh�\�g\0�$o��϶\��{P��MӮoguX���b\�`����\�V]s^�\�&gg����\�H�	��hQE\�I�EQ^]�E\�\r��r�\��\�yS�\���Q�:ƙ��\�i\��\�e3�\�=�\�\�WN\\�Lh+\�go���{\�\�6\�x�t\0\�1x#�\�t�W�U\�U�\���=RՊ\�m(�p\�\�:��\�\��k\�**k�Y�o&��B�B\�Ob\rC^�g\�4V~����hV:����\��0G<|օQE\0QEQE\0QEQE\0QEQE\0QEGU�ʱa�\\\�z����ܬ@�����\0\"�\�ϖ�4�\�QY�QEx\�hQEQE[�\�.��R=���_\�Nu,\�QEk\��6h\�����Z�V�~\�t��\�B\��\�i%��%UQ�ʜ�H\�ڽ�d�]NU� ��\�N昜%l:���p��)\�QEI\�QEQE\0QE\�_\�a��\0�O���\�kƾ#4z��䌱_��¬�?\����;UEٛ\���+Iƚ�AEW�QW&\�g��E�\0g�\�T\���\�R�7i�QEQA�QE��\���#����ҵk���ɻ��g\�k��W>jv\�q֍�p��(��+�\�(��(��\0(��(��\0(��(��\0(��(��\0(���QK3U$�\0+��]�Wű\�I\�{\�1 \�D�\�\��\05\�u\�|5\�?�<)��۫\�\�ɑ\�R>E���,k��>���C<�\�\��\�\�\�a��֤\�\r�\��\�pz{dW\�U\�|[�[x�\�wRG!k;?�ku\�\���2FI\�#�p�QE���(��(��(� ��\�\�o}�~\�|Gq�\��\�� c���3���m2\rcI�ӮFb�\n�\�{\�\�_6\�\�eƏ�\\i�K�hi���#�\�<��\����\��\�4\\�R�`�=�c�\��\�8��\�\�׿W��F�u�j��������H�t\����ƾ\��-<Y\�=b\����޸\�\�yT袊\�(ڢ�(��(\0��(��(\0��(��(\0��(�V\�O6\�W�c]Ud\�\�<G~��eQ�y3��O�\�9\�#|>\�(��Ʈ�@�y�k�f1;V\�θ\�S�z�\r|<\�4\0�J���s\�J�)�\0ez�&�\��\��]��(�$ּ\'��Z\�\�\�\�Z��{O)��?����ߓ�\�\�O_\�N��\\܃��m��\���\0Ƴ+;\����\r�|<b�z�\�\�(��+ּ+y�\�Z19h\�\�o��\�y-w_o\��ŏ�\�?F�\0\�h9s�>\�̾˿\�QEw4QEƅQEQ@QL�E��\��@+�o.^��{��\�H\��9�\\��\0\�|/s���\��\0\��\0��^9ME�Ҵ%Q�\�(��+O@\�t�_U[\rR3�\�l�dm��\�ߑ����)\�\��J�F\�]ea؎��\�ע�Sp}B�(�_|,\�t\�\�i���n9ڣ���\�ϵp�F�H\�Ȍ���0A��ޏ�.��Zޮ?z�����5C\�\�<I�\�O�-\�,���\�4\���\�8\�tQE|\�],\�[\�\�(&��O�5?�LGڬ3\�\�c\��\0�?��{\�@�8��\�5\�\�_�\�+\�QE=Q^�\�QEQE\0QEQE\0QEQE\0QE\�xç\�~&�u���\�B���\'\�ڹ�\0\�=\0��<\�\�ƒ�/�q-\�\�d�\0��ԟZʴ�#\�&¼\�\����<,V�m\�o��\0̠�ol÷z����m\�y\�X\�A�f\�|k�/\�r�\�ų\�	\��LV�I�L�ǹ�c<\�SEW�A\�QEQE\0QEQE\0QEW�|O����5�H�wh��P9�?�^O\�>\�\�4UBN.\��K௏�\��\�\�dƛ~�Ibq�~=;�&����R�\�>\"�?�Q�}��.�n\0B�J�Q��\�\�ץ)+�Ͽ��\�]2�\� \�K^9�O\�W���<?�\�gQ�@ �\�L\�ӓ\�8לc��(�QEQE\0QEQE\0QE�\�ɯ^�ĥ�X2�\�\�\���V���ӭV\�\��\�;�\'\��\�?�셟�m\�yɕ���\�W���\�Tk�:i\�\�(��+\��\0\����[H<���\�\'�\�!^�S\�)�ǹ\�#�\�)\�e\�=�&{n�AEWEP}\�QEV��o��\�II\�3yo�F\��\�Y4t�έ5Rf�QE{�CE��\�ѭn��t�\0\�\�\Z�A�\�\�\�\'	n��(��($\0I8�B�(�5���y�֚z7��\��M\�����5\�@\�\�\�\�r�Hv�8_\�\nϪ>\�	G\�ь�(��(�\�\n(��#ᮥ�\�\�Mv��o60�x?�?:\�+\�<��\�{G-�\�o%����p\n�zL�l֏�\�s-��QE\�D�6�EWFea�G��2�K_\�\r9�\'D?\�\�G�?ʽ>�\�\�-��qh�\�4l�=�:ִ+:S�\��e`��+���thݑ\�N�4�� QEQE\0QEQE\0QEQEmx[\�w>(֣��\�|\�M��\�u?^�z�I]�(��\�\�:��/�^\�=��%�\�\�\�?\�z�\�_����n\�F~\�h�\0\�\���(\�?E\��ǡ\�U[O��\�\� ���GoE�Ԟ��5f�ړs�\�l�?~\�l|)�͉�_�\�S\���\���g���u��\�:�������9ws\��\0A\�«\�ET(��(��\0(��(��\0(��(��\0(����i�ڮ�=�\�bKy�k��Pyھz�_�.�/�5�\�x-\�\�\��Gq����/_\�l�G���\�eO) �ѷf�*��\�iص�\�7zF�o�X\��][�x\�C����\Z|A��\�村\�6\�-\� ���\�=�O\�>7�o\r��Q���\�c�#\�\�\�\�Xw�h��5��Ú�\�^ǂ9�A�d_QYu\�&��(���\�\r\�7\�\Z*^Y�K��ܟ�6�\0\n\�h��)�(��)ѣI\"���\0��֧�-�\�\�=><dy\�\�{/?ҦR\�}�+���+ح�[kX`O�*��h��j�;B�(���ėm�\r\�ʉ6/\�x��\�\��\"\�O��?�\�6\�W��X�NI\��\��W�\����(���(>�(��(��\0(��\�~_\�\�Oc\�5�\��\0Oλj�jٺ\�\�،�\�?\�<~�\n�\��Ψ{<O:\�Z�\0�QEV�5\�\�\r]H�J<���_\�\'�\��O�:���\�i\�~X\����\�\�Aǀ�\�q�E�\�QEp\�QEQ�EQEPER�20e$09v5\�:uؿ\�-�פ\�+�	��Z�����i�\�DNZ\�V���\��\0B�)3\�\�iޔg\��aEWSER>l(���oZ��\���X�2�Ѿo\�X�\�|F���A�q,?PH�X�>�����E�rV�\n(��(��QEQEMiiqw��-4�\�D$\�EGX\�,4\r*}KR�X-`]\�\����>�&��\�j��66P��6\�A�ϠI\�_D�K\��ђ\� �p�k��\�G�\0\�\�MP�7�\��I1Yu)\�yҁ\�\�)��� z\n\�k��^m\�6W����\0\�\�\�z�\�1)8\�,}\���\�W\�4�}���C>�v\�b,Dg��\�\�\�\'�\�\0\Z�~\"^x�Z�6�4\�-��\��\�\�ܟ�N;\�EQX(��(��\0(��(��\0(��(��\0(��(��\0(��(��\0(��\���l|K���\�r9�U�ѷ��\0�\�^#�\��\0��kz�C�\�>YW\�{��\���Qմ�-oN�\��,/��\���\"��U\�N�L\��Ǌ5?	k\�Z\\\�%S�!��B+\��B\�|u���\�$7Ʌ��f����=A���������\�\�:�Z��p�\\\�rOQ\�}E|\�Eu^.�5�\0�&3.nt\�?%�\�\��\�A\�\�|d���>�\�\�\�\�?\�qŧ\�\�\�B\�\�[嘎\�����g\�h���p��\'����\'\�o�\�\\\�v\�!ݨ^Ϗ��\�s�\0�\�8�j2e�{\�(���Z(��|\�\n(��\�\Z\���\�S(83:\�?<�\�\Z�\�\�~!\�b`~�4�}\0��\�>\�$�ɄO�o���(��(��(��(��(��{Ú����m99�.\�?\�~�\Z�\Z\�>\�]\�ƞ\��\�<\��\0\�O\�A\�\�Xk�\�[\�_�_\�\�(��\�e�!�呂�)f\'�k\�5K\�\��K�\�\�f���\�?�^�\�\�O\�x�-\�yC�ޭ�q�ב\�G��Q�%U�\�(��(��g�QEQE\0QE\�|2�\�\���?yVUBA�b�\Z\�|s�ۮp&G��Y�3�|4ו�\�B�(�_��*O�\n(����f-:\��\���y\�z�\�X|\�F�\�S�G�\�\�\�]\�\�\��QEV��\�\�Gė\�\�O�q�%n1\�\���ں\�KVfQ\\��|{��\'Lk�\�k�Ȇ\�H.\����N��Z�a�\�\�\�YY@�\�J\�Q��Rx\�^	�5��m�\��S�bI�D\�L��\�W<)\�\�;�-ǝv\�\�:\�\�zo\�]pխؖ͢\�O��N�Ƒ6��N�C\Z��X����|��\�M�\0�uN�o�BO\�\�s�\0�6:���\0x�W�Ψ\�Z��]��\�ڣ|�\�S\�\�k���(�QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QEQE\0QE2X��&�X\�H\�a�\�CB+\�<[�/�=\�\�5��\0�\0C�\�\�\�U\�r����G�E�7d�ee8*GB\r{w\�ߎ�\Zrå��uŲ��\�(���;�g\�ӓ^E|�4\�N�\�\�*���2�BJ\��ŋK�q��E��?ֽ+\�^\�|M�d;.\0\�\\E�\���ƹ\���\�Y\�7�ȳ��6\�0\�x>\���\�\�S�\�\�ړ\\\�޺v�e�YG{�\�\�sm \�I\�5j�#�u\�^y�M\�X\�߂O�7\�^Cӑ\�+\�?�wмA:\�j�&傅w|\�\�[s��r9<}\�\�:QEyY\�4S!�+�c�H�P\�\������\��כ��m�\�Q\�p̒¹J\��t�o�\�xR�?\�5�A�\�rai�$QEQE`QEQE\0QEU�6��\�F\�\�3��1���Fj�(�E\�\�(�o\�	�\� }��\�\�I\�\�?\n\�)\����\�}*Q�N; ��(��(4\n(��(��\n(��\�\�g�6��͜�L�2�+>��Q\�\�\�\�PL\�\�\�EW\�TS\"�KH�u\�0�i�\'Q\\�\0���|%{����\�\��W�W�\�:\\�ޗwaj�\�,e71¡8�\'�\�:㱩<-�\�J\�6\\݁~�a$��F\�_\�rx\�\�`\�Sw\�sVj\�H̨������N\0\�x\�\�ׇ<(��S}y\�\�m�O���s\�p\�z���|�\�\�\�\�-%�\�l4\��4,~q\�\�?�\�5\���i�k�]棾\�O8a��%\�\�{�l^զiV:5�\�\�\�\�o��^\�ԓ\�>\�QN�IOs\�[���\�O\�Vm3\�\�oo�\�N	�\�=ǩ=��\�q_8꺾��j_\�wr]]I�����v���TQEVb\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��\�t�y�\�~\��T|���b�\�4ۘ�̉�\Z1�\�u���\�QYʔdi\Z��\��O\�7�<:�6�\�\�v絘\��g�А�ds��W�xK��\����$��:~�О��\�/����Oa_3Q_5\�y�\���\�>>��*�}!�x{Hև�L4�go�\0�\���#��\��	!lq���\0�0@�\ra*[g�\�+��T\�\�\�~\�}�gyog\rݬ�X&@\�\�##\���\�\�ž �̛�mZ\�\�g;����9R\n�=��\�\�G�iV��\�-�\�\\�*�j+�\�>��\�q[5��O޷p\��\0��ߥsw6WVR�\�eB����Z\�\�U\n\�Ú~��J��m㧂5o-&��N��\0�\�\"\0�\0�.W��\�N\�4�^!.��\�]�\�`�_�\Z��(�t袊(��\0(���\'�\���m:O���4ڣ�\�QEQE\n(��)�\�$\�(\�\��Q�]�\��\0j-��\�Qծ1\�\�\'�{ԯN��I%\��\��\�\�3%\�\�P�-#��q��\�h\��k�\�HA\�Y�6q\�\�\�3EzƗ�bM��mQ�3�����c��\�G�/�tM�m�G$������\�~�V���\�_=\�S\���>�wT��Ҿ~\�i\"U�\�42���k\�\�\�^��\�yo�~%x�\��\�P\�\'\�O�<ʏ���\�|=\r\����4p�-o\�a�h�\�\�&�;}���u؇\n:w\�yϧҵ���J1>J�yNM��<[�\�2\�C#\�:�l\�\���YH\�f#�\';u�	�O\�_x�9��\�ج�\�\�l�26� ��A�$���\�)�Ƒ H\�Q��0:�+CY\�ܻ�f\'$��i(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��(��\n(��l��ј\�Et=U�A�(��\ntr<R	#vG^C)��V=߄|={�?G�Ϭq�?�\�n~xfs���\0�S7�͚(��U�;�Df��4�Y\�\�\�>�n�sg\�-E1��gQ�6Etv?�yf0��7C��\�!�\0\�@�\0&�+#S�]�\�XKqΡ�q�dB9 v�\�X\�H��\�F~f_�\�iW��U�d��{L��|aq{\�i,�NO�\��\'�\�k��[ׯ\�y%�\�AV�\���\�\�Ec���%��\�I�X��u\��g�\�\�p\�7\�\��Ig9\�>�QT���z�\�\'��\�?5�l\Zu��.|\�U\���㯊t��m\���H��\�\�q�t��袺H>xb\'\��`ݒ|�\0|�kb\��^��<Z-�a\�\�̃�bEVъ�\�\�\��U�\�\�\�\�\�^\�\�\�nc)ŕ�#\�Cl2?\�k����\�mN3ω/���!a��V���~]��0G�\��\�T\�QVp6ެ\�n\�n�\�3^\\\�q)\�4�\��5QEP ��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��(��(\0��+�\�',9,3,1990,'\0��\�*\�s\\�A7	�q�U�\���{u�*6[\�\�\�݇ǓIf(-2K���\�\�\����îʤ5l˭P\�#\0\��\�{\�(7�\�\\L\�l�9_䆵�>sᴀc\'0�Ƨ?b_�m���$\�\'\�\Z ~���=�~Z\�\��A��ń)M��0�L�\�s,��r\�ɿ)ߍt �\�\��\�q�d5���7w�\��,\�F�HEC!)�s-&9\�&Hc�\�v�$��1\�\n[�P�U���k���DѸ1S��Vm���0Q\�\�?�\�\�2��Yy2\r\�QY0,\��i!n��\�\�0\�2]\��o\�m�\�\�A���\Z\�r�\�F�e\��\Z���Z��D�cQ_��%\�ZD�\�\�R�\�f�O��WE�/D\�iT\�L\�\�\�\��&�\�}kԘ��^i\�1m��B��\�2LP~_�=�!�\nф0/o\0�~\�*\�s\\�A7	�q��U��\�\�x�כO��xNe�\�$�砫�\�|�AHN\�r��V\�0`��_W\Z#��Ŵ�-\�#/��Z$c\n\�\�)`\�\�\�:�ُ\�[C\�o\�ZK*0+�V\�ZE��\�z0\�YN,�e�\�Nq����\�q\�8�G\�\�;:pt�\������\�\��\�\��ō���1\�܏��\�4tQ���Js\�دĺ<�7\Z\\^�c)�\��\���?\��zT��!�V�u3�+z�)\�Y�G��H�\���u�)_p\��\�\�\�5 \�P_:^u <\�ˏ^�^��O@��\�6\r\�\�a�˖#\��8���}\�\�	*k/U�7)���bV�*+\nQ\��O\'��\�P�15�8a\�\�@p\�\�*����\�\�~\��Ï�k\�\�>K�=OB)u\��D\�Ro\0��\�*\�s\\�A7	�q�U���C�uT	�[L�\��]\'0\�|c\�ză���\�)*�A\�\�f��O�\�Bn�Q\0KK_�\�ոԏ\� �Cd\�\�\�m\03�\��Վ�\�}��k\�֗%\�\�\�S�H\Z��@Ցaf�\�gˇ\r`\�)\�A�\rq�z��0K?%ó�:ȥ\�ao=-�̮\'��j�(@�\��c�v\n��r��X!uyϻV-.�\�\"|�D+1;X�\�N\'W�\�8�K�]��\����>8$U�2� �\�!]4\���ڑ\�{Ԅq\�U%qP\�s]2X^!�w\�\Z{\�?\�ϕ�(\��sP\�B\\��\�\�{0\r~[7_\�x�\�3J4s7��⹋��z�OW\��=�`u.��\�ݬ�H\�\�\�\�r´��\Zν&$:\�h\\	���\�pc���\�_G�?��&���\�c\��Do\0\�\�*\�s\\�A7	�q0�U�&�%�0�ލ;��N\��B\r�n\�J�\�M\�3\Z��\�\�bt\�5\�\�]vD\�dS\�CpMLJ\� �c\�iF\�����(�\�]}`>\\�EG*��\�#\':>Nr8G\�o�;\�ח�}�Ѣ�6k��4�,�V\�}\�\�F�\�źǵ���\�\�1w���N�bw�0^5&��+tɹwA�}+�܆ۓ�z\�\�\�L\0F��.[g\��9,�w{�?���\�QB\n寇\�\r5<B����\�q\�w@��Y��RM�ߋ\�Ih\�RZ��$A�ʕ1\�/\���\Z.Hv/\�T#r�\�! }ʽx�z��\�\�*@����\���\�\�Z \\\���@r�S:N?E(\�]\��e����G\'=��$j��n\Z\�\�K\�ԁz\�}C�Ư̆f����B0n���T�rgo\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0','2017-08-28 20:08:15','2017-09-02 03:59:56',NULL,'1230');
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
