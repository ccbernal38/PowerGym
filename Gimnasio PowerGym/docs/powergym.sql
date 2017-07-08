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
INSERT INTO `socio` VALUES (1,'1094925466','christian','camilo','bernal','rojas','2017-07-08',NULL,NULL,NULL,NULL,7,NULL,NULL),(2,'1094940706','Cristian','Daniel','Cruz',NULL,'2017-08-04',NULL,NULL,NULL,NULL,8,NULL,NULL),(3,'1094916671','Estefania','','Arango','Centeno','2017-07-01',NULL,NULL,NULL,NULL,7,NULL,NULL),(4,'1234','Francisco','Jos√©','Fermin','De la Cruz','1992-07-07','0000000','Perez@hotmail.com','-1','ˇ\ÿˇ\‡\0JFIF\0\0\0\0\0\0ˇ\€\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ˇ\€\0C			\r\r2!!22222222222222222222222222222222222222222222222222ˇ¿\0\0ê\0∞\"\0ˇ\ƒ\0\0\0\0\0\0\0\0\0\0\0	\nˇ\ƒ\0µ\0\0\0}\0!1AQa\"q2Åë°#B±¡R\—$3brÇ	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzÉÑÖÜáàâäíìîïñóòôö¢£§•¶ß®©™≤≥¥µ∂∑∏π∫\¬\√\ƒ\≈\∆\«\»\…\ \“\”\‘\’\÷\◊\ÿ\Ÿ\⁄\·\‚\„\‰\Â\Ê\Á\Ë\È\ÍÒÚÛÙıˆ˜¯˘˙ˇ\ƒ\0\0\0\0\0\0\0\0	\nˇ\ƒ\0µ\0\0w\0!1AQaq\"2ÅBë°±¡	#3Rbr\—\n$4\·%Ò\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzÇÉÑÖÜáàâäíìîïñóòôö¢£§•¶ß®©™≤≥¥µ∂∑∏π∫\¬\√\ƒ\≈\∆\«\»\…\ \“\”\‘\’\÷\◊\ÿ\Ÿ\⁄\‚\„\‰\Â\Ê\Á\Ë\È\ÍÚÛÙıˆ˜¯˘˙ˇ\⁄\0\0\0?\0Ûc…• ì \–+«éîÒèCLZëz\“\"\‡\‘\…Ù®\◊*öC%SR\nçjE\ÎLd´\Ó*@j5\"•R1@\n\0•8i(4áÅ⁄ûbò\r<\Zb\ÔGîπ§&Ä\ZqM4\Ì\‘\Œ\r0∞ù:R5.y¶@Xc\nå˙S⁄£n0±ÜG4™1R\Õç ∞¡TG“•âzS\∆3Qéî\‡y©:ı©≠@¶•Bs@\—aM8öÑ\’ †d\Íj@r*©T\‰P2@zS≥ìLﬁû†C¡8•\Õ38ª©Å 9dSç;u\0R`PM4öwN*6«•.I¶ö.#\'ÉQ±\ÕH¬£#öh,:˛\ﬂŒå\Œ\'/ıˇ\0=æïê\Î\ÕuóPÉ∂\ÂF>q\Í+˙\”»ó\Â;£~UÖ9\"\"\ \nyR\rk2\«  \œjh§Qûh·öï\"ö®}*eC\«Z\0U©\›\‚ñ8]\œ •æÇ¨;Ä9Ç@?\‹4\»0i\√$U¯t´©ø\’≈∏˙n\0˛¶ß]\Â÷Øì˛˙ú~`M&+£,)\≈8)\≈k.ïúwf}Ñ¿¯T£L∑#´ÁßîX°RiŸÖ—é\“\Ì\Ê∑#“°<wR˜\›\nˇ\0°-ZèDàê\—\€‹∞?\√0Q˙Ü¶¢\≈Ãégm	÷¶é	Ò+Gqrë≠.ì2ce•âˇ\0ñ®˛aE>F\Á\‰ûı$v3\Œq2I˛\‚ì¸´ª[∞òIaÄ\Á˛XáÚ›è“î\È\◊:ıd¶?\Ã\Z•y\Œ-<?®\»	í.?æ6<R\«\·\€\Ÿo\ÓUΩ\ ë&∫Ò•¢ë˛ù:üˆ& )&≤≤#l˜28ˇ\0¶ìì¸\ÕRÇ;8¯%T!I\ÃO˜NzO®n¨¿Vâø‘∑*∏\œ˘\‰\÷^üx?\„\ﬁV\"68_cˇ\0\Î˝}≥[∞O,i\Â\…ÛŸáqQ&Ü\„fb\r6¡∏ ˇ\0\◊2G\ÈR.õÚ\ﬁl†˘fÑ1[F\‡ØHêO1s¸\ÍDíg*\∆?ˇ\0 h≤≥&-. ¨\'\‘H°e4∞[˛A\‡{â\»˝9´f\ÊT#Ãñ(¡\Ó\ \√˘äVºA\“˘Hı@áˇ\0f\ÕA®ëiì.\0ÇÿØ§™ı¿´ë\ÈÚF	à\€¿ÿè#ı&™çJ\”5\‹≈áaÛ\n\‘\≈‘≠≤~\”/∞s˝Ui]!\⁄L\‘[a˚\ÎÖs\Í!A˝*h\ÏU97∑Ùê?J\«mN\—Ú\Ài\'\—¡\ÁÚì˙S\◊X\nÄ.õÒü¸y\Zó<{è\Ÿ\…Ù5^\€Nf\›!{\Â\…˛fû£Kãä\"{a¨»µã§…ä#>\Í˛Çü˝±~\«-\"è˜\ZA¸‹ä^\÷#ˆS6\„\„tVRs˝\»O?ê©\“W#˛=%P;»°\Î\\\„j7l§5\√6Ωmü\Õi¢\‚vI$çâ\ÎŸü˚\ÁΩ¥G\Ï$t\¬\ÊB\€Q!œº\È˝	©]\ÓïI>Z˛q˘-råÛ7Op\ÿ˛¸¨ô®\Ã∂Oíôı\⁄(ˆ\Î±K˚ù?\€xõQ∑çΩ:ˇ\0}P∂•nØŒ®•\ÿÚ\œÚs¸´\»R8\0jqºO÷ó∑Ú)a\◊sj]N¿&>\◊p˛ßk\ÕD5Kß˝\Í_B\\ˇ\0]ïïÇ¿söV›∑\0Rˆ\Ô∞˛Ø\Â∂‘≠Ç∂,\Î†ˇ\0\Ìá˘RK´å`X¿>åø\÷3Y\€H\Îú\”ö=ºáıxúP9qûïin\Ó3…Å\ﬂw?üZÉo\ÕJÉ\r÷≥\Êk`\ÂOr\ﬂ\⁄\'è¥LGºÑˇ\0Zà™ûJÇ}\≈.	†éx§\‰\ QC”É¿©ó$ı¶°¯©W©§P†cúú‘®–•±\ÕNâÉäEé6nI´ô8¶≥±ñ\‰¸äq\◊>’±î0!e)erD`˚wo√ä®¡≥9\‘Q3·¥öQÚ! u=á\‘ÙçX[$`~vêå!C&π\‡~¶üq®\¬U\ÕÀ©\„p\¬/\—GZiu+Ä\Zé1¯ı´Eå]Y2—∑ä6m»äGO:|˛à2?:É˜\À%†?\Ï˘ß˘ö±m\·\rn˚à\Ïßenr‡™ü°l\nø√çW\0»∞\¬~°øïh¢˙#\'.\Ï\∆\ﬂlIƒê1\«cs˘\ZDTÛ≈¥RG\ﬁ\›0?\œæ\ﬂnïyºåüO/ˇ\0ØQßÇgÖ∑	`r;I\0˛`\”\Âb\Ê]\Ãcê≥{≤ ≤˛K¡˝i\‚\€C)o\Ó>Qˇ\0¸£Û≠ø\Ï∏2\r¥Rz\Â#è£\‰Ry)\Âû#_Iì?Qê?*N™)T}ë\‹)6# 8\∆}«®©\0ı\ÎZ\ÎdÇ2b`bc˜_çè~G\Á˘ToßÆv\0cl\„dÑ\Ì\'Ÿ∫Éı\œ\–T∫I\Ïk\ZÔ©î—©EUë\nûkRK7Ñ\„k9\⁄zÅ˝G∏\‚™Hª∫åVn-nm\'™8R6ØΩ5G•,\ŸÒ®É˜§÷¢\ËYœΩ9y\ÔP´\…9©ïÚÜâÄ\È\ŒjT\'“¢_ª\«“¨E«Ω\"â#BH´r\√L\⁄\'\ BΩÒù\«\–Ù∫Nò$Qq:ü(*ÅÀüJì\ƒ µ—ñ8\‰9∏ê0PúàÄ\ÎﬂØ<üˇ\0]k_VaRØDY∫\‘l\Ï\‡ô\Ë∂\Ízë˝Û\‹˚tC\Ìë_\·\Ón‘å\·-\‚aû?•y}÷º\◊wr\Œ@\ÿ7,~æˇ\0 §∂Ò\\∂\÷WV\ÈiΩ\¬\„\Ì3\"∫{v˝zf∂Qπ\œ\Ã}	\·\ÔX\‹Dfºæ∂∂Ubç2)p}\œÚ˙\◊{¶\È:^ûπ±∑ÖOO0|\Ã\‡G\'ıØê°Òñ£íY\ƒ˛T*wºñoRO∑•tû¯ë¶\Àk?óoπw®\›\«<ûs\…¸ÖRV!\Í}RzU9Ò\\Ü>#\ÿjñ\Ìì(û7\⁄\œ\» Ú†\Ì¯\Z\Îeê0\»9Ù9\ÎVµ\'bÑ\ÿ…™\nø79™2w†\nÉUdfQê:π)ˆ™3äT+lêçn\‰\‰\…˙ØB)°\Ó,=\ƒ2†¥ΩWøO õ(\ÎU|˜Å˜\∆\ÂXw¨;ó\Z0Ty±ılë\Ó≠\ﬂˇ\0Ø€•g]i€ê<Ep\ﬂu∫9\Ë∫{z\È“ÆCyœ¥äV9+ú$áˇ\0eoqˇ\0÷´;ybüª\"0˚0ı˜\ÔI\≈= å\‹]\—\‚≥>\'\'˘\‘!±å\“\Œ€üµGí+ôùIñï∑\«:OLz\’Xõ¶\r\\çF\ﬁzöÜR,F£∑\Á[∫>ò.•.¸Dúª\ÂY∂v\Õ#¢(Ãép¢ªòaãO≤\⁄\ƒ¢ùõ£7^~ïT\·vMY\Ÿhf¯ÉXèE\“\‰õ|qOÂ∞ÖYÄ\Ÿ\«Û?\Á\€\ƒımZMR\Á\Ãb\‰Çyv\‹NA¯T\ﬁ&Òœàµ6ûBV\0\ƒC˜W\ﬂ\‹„ö≠eh$¡\'ì]©]\ŸÑr7£Àëx\⁄EuVñê°†c\Î[Piw ãÚ@®ˆ∫ö™\ZL\‹l$ˆ©R\“\‡ëà\€ÚØ^\–Ùm2\ ˙^\⁄9\0?\«\»¸k™º\”t[´g0\È∞#rQ@˛Ujiâ\—hΩ/UΩ\—\Ów£∫gÉÉä˙¿>1]r\œ\ÏÚJ¶dPvOˆ}G\Î^e™xzŒÖC!∏¨\Ô\ÍRh9¥∑úè\'\Ÿ\€\ÿ9\00¸p~ô•	\›ÿöîúUœ£\‰~*å\œ\€+8 ÛT\Êqû¢∂1 ô™å≠V%êg≠TíAH\n≥\rgLrx´“∏ \’	\Õ+=_±\‘pV€∂‘ëΩ?∫\ﬁﬁá∑”•	X\n´$ÇÄ<‹ú±&ïvìûµR95\".3Åë\\å\ÎD\—\‡∞=1WbùNz\Z®†qWmîn\0T≤\—\’¯R!%\ÃÛ∂	âF3\Ís˛g\«\◊?`ù¯^qîH\Ó\ŒBì˙ü¿Uè	\ƒ\ G<ò)8\Ï\0ˇ\0Y?\‰h|\"Ñ,&û5c˝\–s˘å~5\”Ihr\’wë\‚˘´^¿ë∑ö\»Qπ¿≠¶e8ådÅDï\≈gs´¥\0\0I\‚∫\r>\‚5¿ﬂäÛÙö˚n¯5,7˜–∑$1®ˆF\Í∫GØC$5\…_≠]Çˆ\›£∏ï\ÊZ˛\‰4¢6¶ôs\‚)\À2¬•èf\œr4W¥é\Á°_ îìı¡xå}óQ∂πL§†\„\‘É˙\‘6\⁄ﬁÆ[\Ê|èJã\\ªñ˛\ ?2$ç≥∏t#˙P©µ+äu#(\ÿ˜\Îa/Ù\Àkµ8ƒ≤ú\„#8¶\ÀtıØ8œà\“-\n\ﬁ\€\'0®RO=≥˝kL¯ñ&˚≤~ïΩ\ŒC™yÄ\ÔUd∏\Î\\\ÀÎõèUY5§zJ\0È§∏\\}\·Teª\Î“π˜\÷\„<VM]Òå˝hv[°Uö\„ﬁ∞üS\…¿9¶\Á=ç+å\ƒ\∆zS\”réºTaπ\‡”ó$úö\ÊgB\'å\Zøn3œ≠Sã ı\Õ]¥«ö˙‘ós\—¸;]&8\‹â˜\‰A\\Ø\≈Y§ä\Ÿc%\√;\ÁÖ¡\„Û5\⁄i—òÙÿêån§˝N¯\◊%Ò.\Óh¥Ql#ç°ô\’	`	ì\«˝Û˙\◊\\¢q…∑#ƒ£\»|\’\ËAâëí{TpG≤\È¡j\⁄€¨Æpµ-ÿ•ôû}Åîı<èJr3á%≤9Æû-\"\ƒD6[“™^¡omü)FOzzX•XzE>®DÅ∞\ƒ.ä\Á>„öãU∞ö\€U∫Çw˘ ÆHëöõ√Æê\\ó<6r3]mÁêöÄû6$ü+>\‹dv\»¸\«\„Y\ﬂSu\¬«õy\◊0\Œ\»I$r9ˆ≠ñ\Ê\‚\ c4la¡#=±˙Ws&ô∞xºôìÉÇpG˝ıä©©õy<´t(6YSß\ÁU&BÉ\Ís\ZFô\Ë≤]@\∆L¸¨	˘G”Ωf\‹1≤\÷]<\ﬂ-\·ó\·Wv3è°<W†\Ë3l\“\ÂD\–5+\…—ù<\Î[c*€û\«\È\Ì\\µˇ\0Ü¸C©\ﬂ\œptEé\\i\'\0ˆ\Œ+ks+£õT\ÏÃùCV{{êñ\”	ìnw\«<Òå\÷|˙Öı¡ˇ\0\\Wìä\Ëè\√\ﬂ\…*—Æ71Cm\\üƒåU\’¯e\‚\Á·¥ò\„˜i\‚˛åirK∞s#é7^X\ﬂ;q\ÔLä˙h\‰ç\ŸÀÖ`J\Áá¶kª\nºT\À…±ã94\«˙)®d¯MØBÖÂ∏±\⁄9;dsÅ\ﬂ¯h\‰a\Ãg&´f¸≠≥{\rı±c=ç\ﬁY∞ì\Â$“≠[|1æéX[\Àc\–\ŸBƒ∞?ÖvV\⁄\rÖï™ƒ∞+0í:öJ9èˇ\Ÿ',7,7,1992);
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
