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
  `fecha` date DEFAULT NULL,
  `cantidad` decimal(10,0) DEFAULT NULL,
  `Socio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Socio_id`),
  KEY `fk_Entrada_Socio1_idx` (`Socio_id`),
  CONSTRAINT `fk_Entrada_Socio1` FOREIGN KEY (`Socio_id`) REFERENCES `socio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencia`
--

LOCK TABLES `asistencia` WRITE;
/*!40000 ALTER TABLE `asistencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencia` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diasemana`
--

LOCK TABLES `diasemana` WRITE;
/*!40000 ALTER TABLE `diasemana` DISABLE KEYS */;
/*!40000 ALTER TABLE `diasemana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entrenador`
--

DROP TABLE IF EXISTS `entrenador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `entrenador` (
  `id` int(11) NOT NULL,
  `primerNombre` varchar(45) DEFAULT NULL,
  `segundoNombre` varchar(45) DEFAULT NULL,
  `primerApellido` varchar(45) DEFAULT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `genero` int(11) DEFAULT NULL,
  `identificacion` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrenador`
--

LOCK TABLES `entrenador` WRITE;
/*!40000 ALTER TABLE `entrenador` DISABLE KEYS */;
/*!40000 ALTER TABLE `entrenador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `horaInicio` date DEFAULT NULL,
  `horaFin` date DEFAULT NULL,
  `Membresia_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`Membresia_id`),
  KEY `fk_Horario_Membresia1_idx` (`Membresia_id`),
  CONSTRAINT `fk_Horario_Membresia1` FOREIGN KEY (`Membresia_id`) REFERENCES `membresia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membresia`
--

LOCK TABLES `membresia` WRITE;
/*!40000 ALTER TABLE `membresia` DISABLE KEYS */;
/*!40000 ALTER TABLE `membresia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membresia_has_diassemana`
--

DROP TABLE IF EXISTS `membresia_has_diassemana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membresia_has_diassemana` (
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
-- Dumping data for table `membresia_has_diassemana`
--

LOCK TABLES `membresia_has_diassemana` WRITE;
/*!40000 ALTER TABLE `membresia_has_diassemana` DISABLE KEYS */;
/*!40000 ALTER TABLE `membresia_has_diassemana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `membresiasocio`
--

DROP TABLE IF EXISTS `membresiasocio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membresiasocio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Socio_id` int(11) NOT NULL,
  `Membresia_id` int(11) NOT NULL,
  `Pago_id` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `activa` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Socio_has_Membresia_Membresia1_idx` (`Membresia_id`),
  KEY `fk_Socio_has_Membresia_Socio_idx` (`Socio_id`),
  KEY `fk_Socio_has_Membresia_Pago1_idx` (`Pago_id`),
  CONSTRAINT `fk_Socio_has_Membresia_Membresia1` FOREIGN KEY (`Membresia_id`) REFERENCES `membresia` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_has_Membresia_Pago1` FOREIGN KEY (`Pago_id`) REFERENCES `pago` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Socio_has_Membresia_Socio` FOREIGN KEY (`Socio_id`) REFERENCES `socio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membresiasocio`
--

LOCK TABLES `membresiasocio` WRITE;
/*!40000 ALTER TABLE `membresiasocio` DISABLE KEYS */;
/*!40000 ALTER TABLE `membresiasocio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pago` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` decimal(45,0) DEFAULT NULL,
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
-- Table structure for table `socio`
--

DROP TABLE IF EXISTS `socio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(45) DEFAULT NULL,
  `primerNombre` varchar(45) DEFAULT NULL,
  `segundoNombre` varchar(45) DEFAULT NULL,
  `primerApellido` varchar(45) DEFAULT NULL,
  `segundoApellido` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `correoElectronico` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `foto` blob,
  `mesNacimiento` int(11) DEFAULT NULL,
  `diaNacimiento` int(11) DEFAULT NULL,
  `anioNacimiento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socio`
--

LOCK TABLES `socio` WRITE;
/*!40000 ALTER TABLE `socio` DISABLE KEYS */;
INSERT INTO `socio` VALUES (1,'1094925466','christian','camilo','bernal','rojas','2017-07-08',NULL,NULL,NULL,NULL,7,NULL,NULL),(2,'1094940706','Cristian','Daniel','Cruz',NULL,'2017-08-04',NULL,NULL,NULL,NULL,8,NULL,NULL),(3,'1094916671','Estefania','','Arango','Centeno','2017-07-01',NULL,NULL,NULL,NULL,7,NULL,NULL),(4,'1234','Francisco','José','Fermin','De la Cruz','1992-07-07','0000000','Perez@hotmail.com','-1','�\��\�\0JFIF\0\0\0\0\0\0�\�\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342�\�\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0\0�\0�\"\0�\�\0\0\0\0\0\0\0\0\0\0\0	\n�\�\0�\0\0\0}\0!1AQa\"q2���#B��R\��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz�����������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\������������\�\0\0\0\0\0\0\0\0	\n�\�\0�\0\0w\0!1AQaq\"2�B����	#3R�br\�\n$4\�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz������������������������������������\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�\�����������\�\0\0\0?\0�cɥʓ \�+ǎ��CLZ�z\�\"\�\�\���\�*�C%SR\n�jE\�Ld�\�*@j5\"�R1@\n\0�8i(4��ڞb�\r<\Zb\�G���&�\ZqM4\�\�\�\r0��:R5.y�@Xc\n��Sڣn0��G4�1R\��ʰ�TGҥ�zS\�3Q��\�y�:���@��Bs@\�aM8��\� �d\�j@r*�T\�P2@zS��Lޞ�C�8�\�38��� 9dS�;u\0R`PM4�wN*6ǥ.I��.#\'�Q�\�H£#�h,:�\�Ό\�\'/��\0=���\�\�u�P��\�F>q\�+�\�ȗ\�;�~U�9\"\"\�\nyR\rk2\�  \�jh�Q�hᚕ\"��}*eC\�Z\0U�\�\�8]\�ʥ���;�9�@?\�4\�0i\�$U�t���\�Ÿ�n\0���]\�֯����~`M&+�,)\�8)\�k.��wf}���T�L�#�秔X�Riمю\�\�\�#ҡ<wR�\�\n�\0�-Z�D��\�\�ܰ?\�0Q����\�̎gm	֦�	�+Gqr��.�2ce���\0���aE>F\�\��$v3\�q2I�\����[��Ia�\��X��ݏҔ\�\�:�d�?\�\Z�y\�-<?�\�	�.?�6<R\�\�\�\�o\�U�\��&�񥢑��:��& )&��#l�28�\0����\�R�;8�%T!I\�O�NzO�n��V��Է*�\��\�\�^�x?\�\�V\"68_c�\0\��}�[�O,i\�\��هqQ&�\�fb\r6�� �\0\�2G\�R.��\�l��f�1[F\�H�O1s�\�D�g*\�?�\0 h��&-. �\'\�H�e4�[�A\�{�\��9�f\�T#̖(�\�\�\���V�A\��H�@��\0f\�A��i�.\0�د������\��F	�\��؏#�&��J\�5\�Ňa�\n\�\�ԭ�~\�/�s�Ui]!\�L\�[a�\�s\�!A�*h\�U97���?J\�mN\��\�i\'\��\���S\�X\n�.���y\Z�<{�\�\��5^\�Nf\�!{\�\��f��K��\"{a�ȵ��Ɋ#>\������~\�-\"��\ZA�܊^\�#�S6\�\�tVRs�\�O?��\�W#�=%P;ȡ\�\\\�j7l�5\�6�m�\�i�\�vI$��\�ٟ�\���G\�$t\�\�B\�Q!ϼ\��	�]\�I>Z�q�-r��7Op\������\��O���\�(�\�K��?\�x�Q���:�\0}P��n�Ψ�\��\��s��\�R8\0jq�O֗��)a\�sj]N�&>\�p��k\�D5K��\�_B\\�\0]����s�Vݷ\0R�\���\�ԭ��,\��\0\��RK��`X�>��\�3Y\�H\�\��=���x�P9q��in\�3Ɂ\�w?�Z�o\�J�\rֳ\�k`\�Or\�\�\'��LG���\0Z���J�}\�.	��x�\�\�QCӃ���$�����W��P�c��ԨХ�\�N���E�6nI��8����\���q\�>ձ�0!e)erD`�woÊ���9\�Q3ᴚQ�! u=�\���X[$`~v��!C&�\�~��q�\�U\�˩\�p\�/\�GZiu+�\Z�1���E�]Y2ѷ�6mȊGO:|��2?:��\�%�?\������m\�\rn��\�enrટ�l\n�ÍW\0Ȱ\�~���h��#\'.\�\�\�lIĐ1\�cs�\ZDT�ŴRG\�\�0?\��\�n�y���O/�\0�Q��g��	`r;I\0�`\�\�b\�]\�c��{�ʲ�K��i\�\�C)o\�>Q�\0���\��2\r�Rz\�#��\�Ry)\�#_I�?Q�?*N�)T}�\�)6# 8\�}Ǩ�\0�\�Z\�d�2b`bc�_��~G\��To��v\0cl\�d�\�\'ٺ��\�\�T�I\�k\Z穀ѩEU�\n�kRK7�\�k9\�z��G�\�H���Vn-nm\'�8R6��5G�,\����֢\�YϽ9y\�P�\�9������\�\�jT\'Ң_�\�ҬEǽ\"�#BH�r\�L\�\'\�B��\�\���N�$Qq:�(*�˟J�\� �і8\�9��0P���\�߯<��\0]k_VaR�DY�\�l\�\��\�\�z���\��tC\�_\�\�nԌ\�-\�a�?�y}ּ\�wr\�@\�7,~��\0ʤ��\\�\�WV\�i�\�\�\�3\"�{v�zf�Q�\�\�}	\�\�X\�Df����Ub�2)p}\���\�{�\�:^�����OO0|\�\�G\'������Y\��T*w��oRO��t����\�k?�o�w�\�\�<�s\���RV!\�}RzU9�\\�>#\�j�\�(�7\�\�\� ��\��\Z\�e�0\�9�9\�V�\'b�\�ɪ\n�79�2w�\n�UdfQ�:�)��3�T+l��n\�\�\���B)�\�,=\�2���W�Oʛ(\�U|���\�\�Xw�;�\Z0Ty��l�\�\��\0�ۥg]iې<Ep\�u�9\��{z\�ҮCyϴ�V9+�$��\0eoq�\0֫;yb��\"0�0��\�I\�=ʌ\�]\�\�>\'\'�\�!��\�\�۟�G�+��I���\�:OLz\�X��\r\\�F\�z��R,F��\�[�>�.�.�D��\�Y�v\�#�(̎p���a�O�\�\�����7^~�T\�vMY\�hf��X�E\�\�|qO尅Y�\�\��?\�\�\��mZMR\�\�b\�yv\�NA�T\�&�ψ�6�BV\0\�C�W\�\�㚭eh$�\'�]�]\��r7�ˑx\�EuV����c\�[Piw ��@�����\ZL\�l$��R\�\���\��^\��m2\��^\�9\0?\�\��k��\�t[�g0\�#rQ@�Uji�\�h�/U�\�\�w��g�����>1]r\�\��J�dPvO�}G\�^e�xz΅C!��\�\�Rh9����\'\�\�\�9\00�p~��	\�ؚ��Uϣ\�~*�\�\�+8 �T\�q���1 ����V%�g�T�AH\n�\rgLrx�Ҹ \�	\�+=_�\�pV۶ԑ�?�\�އ�ӥ	X\n�$��<ܜ�&�v���R95\".3��\\�\�D\�\�=1Wb�Nz\Z��qWm�n\0T�\�\��R!%\��	�F3\�s�g\�\�?`��^q�H\�\�B����U�	\�\�G<�)8\�\0�\0Y?\�h|\"�,&�5c�\�s��~5\�Ihr\�w�\���^����\�Q����e8�d�D�\�gs��\0\0I\�\r>\�5�ߊ����n�5,7�з$1��F\�G�C$5\�_�]��\����\�Z�\�4�6��s\�)\�2¥�f\�r4W��\�_ ����x�}�Q��L���\�\���\�6\�ޮ[\�|�J�\\���\�?2$���t#�P��+�u#(\��\�a/�\�k�8Ĳ�\�#8�\�t��8�ψ\�-\n\�\�\'0�RO=��kL��&��~��\�C�y�\�Ud�\�\\\�뛏UY5�zJ\0餸\\}\�Te�\�ҹ�\�\�<VM]��hv[�U�\�ް�S\��9�\�=�+�\�\�zS\�r��Ta�\�ӗ$��\�gB\'�\Z�n�3ϭS� �\�]�ǚ�ԗs\��;]&8\���\�A\\�\�Y��\�c%\�;\��\��5\�iј�ؐ�n��N�\�%�.\�h�Ql#���\�	`	�\����\�\\�qɷ#ģ\�|\�\�A���{TpG�\��j\�۬�p�-إ��}���<�Jr3�%�9��-\"\�D6[Ҫ^�om�)FOzzX�X�zE>�D��\�.�\�>㚋U��\�U��w�ʮH���î�\\�<6r3]m琚��6$�+>\�dv\��\�\�Y\�Su\�Ǜy\�0\�\�I$r9���\�\�\�c4la�#=��Ws&��x�����pG������y<�t(6YS�\�U&B�\�s\ZF�\�]@\�L��	�Gӽf\�1�\�]<\�-\�\�Wv3��<W�\�3l\�\�D\�5+\�ѝ<\�[c*۞\�\�\�\\��\0��C�\�\�ptE�\\i\'\0�\�+ks+��T\�̝CV{{��\�	�nw\�<�\�|�����\0\\W��\�\�\�\�*Ѯ71Cm\\�ČU\��e\�\�ᴘ\��i\���irK�s#�7^X\�;q\�L��h\�\�˅`J\���k�\n�T\�ɱ�94\��)�d�M�B�帱\�9;ds�\��h\�a\�g&�f���{\r��c=�\�Y��\�$ҭ[|1��X[\�c\�\�Bİ?�vV\�\r���İ+0�:�J9��\�',7,7,1992);
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-08 12:59:25
