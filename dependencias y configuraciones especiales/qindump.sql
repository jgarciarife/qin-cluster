-- MySQL dump 10.13  Distrib 5.5.24, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: qintomcat
-- ------------------------------------------------------
-- Server version	5.5.24-0ubuntu0.12.04.1

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `padron` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `padron` (`padron`),
  KEY `FKABAED504EF37BA43` (`id`),
  CONSTRAINT `FKABAED504EF37BA43` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES ('80001',15),('80002',16),('80003',17),('80004',18),('80005',19),('80006',20),('80007',21),('80008',22),('80009',23),('80010',24);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno_materia`
--

DROP TABLE IF EXISTS `alumno_materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno_materia` (
  `alumno_id` bigint(20) NOT NULL,
  `materia_id` bigint(20) NOT NULL,
  UNIQUE KEY `alumno_id` (`alumno_id`,`materia_id`),
  KEY `FK1DCACFAA13D0E594` (`materia_id`),
  KEY `FK1DCACFAAC3184200` (`alumno_id`),
  CONSTRAINT `FK1DCACFAA13D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`),
  CONSTRAINT `FK1DCACFAAC3184200` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno_materia`
--

LOCK TABLES `alumno_materia` WRITE;
/*!40000 ALTER TABLE `alumno_materia` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno_materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consigna`
--

DROP TABLE IF EXISTS `consigna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consigna` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `consigna` varchar(255) NOT NULL,
  `orden` int(11) NOT NULL,
  `puntaje` double NOT NULL,
  `trabajo_practico_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`,`trabajo_practico_id`),
  KEY `FKDE22FA0290D51443` (`trabajo_practico_id`),
  CONSTRAINT `FKDE22FA0290D51443` FOREIGN KEY (`trabajo_practico_id`) REFERENCES `trabajo_practico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consigna`
--

LOCK TABLES `consigna` WRITE;
/*!40000 ALTER TABLE `consigna` DISABLE KEYS */;
INSERT INTO `consigna` VALUES (27,'Consigna1',0,10,29),(28,'Consigna1',0,10,30),(29,'Consigna1',0,10,31),(30,'Consigna1',0,10,32),(31,'Consigna1',0,10,33),(32,'Consigna1',0,10,34),(33,'Consigna1',0,10,35),(34,'Consigna1',0,10,36),(35,'Consigna1',0,10,37),(36,'Consigna1',0,10,38),(37,'Consigna1',0,10,39),(38,'Consigna1',0,10,40),(39,'Consigna1',0,10,41),(40,'Consigna1',0,10,42),(41,'Consigna1',0,10,43),(42,'Consigna1',0,10,44),(43,'Consigna1',0,10,45),(44,'Consigna1',0,10,46),(45,'Consigna1',0,10,47),(46,'Consigna1',0,10,48);
/*!40000 ALTER TABLE `consigna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correccion`
--

DROP TABLE IF EXISTS `correccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `correccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `correccion` varchar(255) NOT NULL,
  `puntaje` double NOT NULL,
  `dictamen_id` bigint(20) DEFAULT NULL,
  `respuesta_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dictamen_id` (`dictamen_id`,`respuesta_id`),
  KEY `FK44DA650F2EA8FD34` (`respuesta_id`),
  KEY `FK44DA650F720C6720` (`dictamen_id`),
  CONSTRAINT `FK44DA650F2EA8FD34` FOREIGN KEY (`respuesta_id`) REFERENCES `respuesta` (`id`),
  CONSTRAINT `FK44DA650F720C6720` FOREIGN KEY (`dictamen_id`) REFERENCES `dictamen` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correccion`
--

LOCK TABLES `correccion` WRITE;
/*!40000 ALTER TABLE `correccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `correccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictamen`
--

DROP TABLE IF EXISTS `dictamen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dictamen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dictamen` varchar(255) NOT NULL,
  `puntaje` double NOT NULL,
  `resolucion_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resolucion_id` (`resolucion_id`),
  KEY `FKF5E3FE8B56134460` (`resolucion_id`),
  CONSTRAINT `FKF5E3FE8B56134460` FOREIGN KEY (`resolucion_id`) REFERENCES `resolucion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictamen`
--

LOCK TABLES `dictamen` WRITE;
/*!40000 ALTER TABLE `dictamen` DISABLE KEYS */;
/*!40000 ALTER TABLE `dictamen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docente` (
  `matricula` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`),
  KEY `FK6CFBBE12EF37BA43` (`id`),
  CONSTRAINT `FK6CFBBE12EF37BA43` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES ('123',25),('124',26);
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `materia_id` bigint(20) DEFAULT NULL,
  `resolucion_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resolucion_id` (`resolucion_id`),
  KEY `FK5E10C6913D0E594` (`materia_id`),
  KEY `FK5E10C6956134460` (`resolucion_id`),
  CONSTRAINT `FK5E10C6913D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`),
  CONSTRAINT `FK5E10C6956134460` FOREIGN KEY (`resolucion_id`) REFERENCES `resolucion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,9,1);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo_alumno`
--

DROP TABLE IF EXISTS `grupo_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo_alumno` (
  `grupo_id` bigint(20) NOT NULL,
  `alumno_id` bigint(20) NOT NULL,
  UNIQUE KEY `grupo_id` (`grupo_id`,`alumno_id`),
  KEY `FK4193AD9A58A29D94` (`grupo_id`),
  KEY `FK4193AD9AC3184200` (`alumno_id`),
  CONSTRAINT `FK4193AD9A58A29D94` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`),
  CONSTRAINT `FK4193AD9AC3184200` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo_alumno`
--

LOCK TABLES `grupo_alumno` WRITE;
/*!40000 ALTER TABLE `grupo_alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo_alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materia` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `anio` bigint(20) NOT NULL,
  `carrera` varchar(255) NOT NULL,
  `codigo` varchar(255) NOT NULL,
  `cuatrimestre` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `docente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `anio` (`anio`,`cuatrimestre`,`carrera`),
  KEY `FK321F97E5E7AB9A74` (`docente_id`),
  CONSTRAINT `FK321F97E5E7AB9A74` FOREIGN KEY (`docente_id`) REFERENCES `docente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (9,2010,'75','75.25',1,'Calidad',NULL),(10,2010,'73','75.26',1,'Taller',NULL),(11,2010,'74','75.27',1,'Analisis',NULL),(12,2010,'76','75.28',1,'Algebra',NULL),(13,2010,'77','75.29',1,'Arquitectura',NULL),(14,2010,'78','75.30',1,'Administracion',NULL),(15,2010,'79','75.31',1,'Tecnicas de Diseño',NULL);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resolucion`
--

DROP TABLE IF EXISTS `resolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resolucion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trabajo_practico_id` bigint(20) DEFAULT NULL,
  `codigo_resolucion_compartida` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA099BE5D90D51443` (`trabajo_practico_id`),
  CONSTRAINT `FKA099BE5D90D51443` FOREIGN KEY (`trabajo_practico_id`) REFERENCES `trabajo_practico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resolucion`
--

LOCK TABLES `resolucion` WRITE;
/*!40000 ALTER TABLE `resolucion` DISABLE KEYS */;
INSERT INTO `resolucion` VALUES (1,29,'23');
/*!40000 ALTER TABLE `resolucion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta`
--

DROP TABLE IF EXISTS `respuesta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `respuesta` varchar(255) NOT NULL,
  `consigna_id` bigint(20) DEFAULT NULL,
  `resolucion_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resolucion_id` (`resolucion_id`,`consigna_id`),
  KEY `FK8B7BEBC056134460` (`resolucion_id`),
  KEY `FK8B7BEBC0139C9FC0` (`consigna_id`),
  CONSTRAINT `FK8B7BEBC0139C9FC0` FOREIGN KEY (`consigna_id`) REFERENCES `consigna` (`id`),
  CONSTRAINT `FK8B7BEBC056134460` FOREIGN KEY (`resolucion_id`) REFERENCES `resolucion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta`
--

LOCK TABLES `respuesta` WRITE;
/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajo_practico`
--

DROP TABLE IF EXISTS `trabajo_practico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajo_practico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `materia_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B78289D13D0E594` (`materia_id`),
  CONSTRAINT `FK4B78289D13D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajo_practico`
--

LOCK TABLES `trabajo_practico` WRITE;
/*!40000 ALTER TABLE `trabajo_practico` DISABLE KEYS */;
INSERT INTO `trabajo_practico` VALUES (29,'Tp1',9),(30,'Tp2',10),(31,'Tp3',11),(32,'Tp4',12),(33,'Tp5',13),(34,'Tp6',14),(35,'Tp7',15),(36,'Tp8',14),(37,'Tp9',9),(38,'Tp10',14),(39,'Tp11',11),(40,'Tp12',9),(41,'Tp13',15),(42,'Tp14',9),(43,'Tp15',9),(44,'Tp16',15),(45,'Tp17',9),(46,'Tp18',15),(47,'Tp19',10),(48,'Tp20',9);
/*!40000 ALTER TABLE `trabajo_practico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `contrasenia_usuario` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (15,'apellido','123','al1','alumno1'),(16,'apellido','123','al2','alumno2'),(17,'apellido','123','al3','alumno3'),(18,'apellido','123','al4','alumno4'),(19,'apellido','123','al5','alumno5'),(20,'apellido','123','al6','alumno6'),(21,'apellido','123','al7','alumno7'),(22,'apellido','123','al8','alumno8'),(23,'apellido','123','al9','alumno9'),(24,'apellido','123','al10','alumno10'),(25,'apellido','123','do1','docente1'),(26,'apellido','123','do2','docente2');
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

-- Dump completed on 2012-07-04 13:34:11
