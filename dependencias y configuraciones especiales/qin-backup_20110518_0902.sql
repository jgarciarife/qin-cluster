-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.54-1ubuntu4


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema qin
--

CREATE DATABASE IF NOT EXISTS qin;
USE qin;

--
-- Definition of table `qin`.`alumno`
--

DROP TABLE IF EXISTS `qin`.`alumno`;
CREATE TABLE  `qin`.`alumno` (
  `padron` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `padron` (`padron`),
  KEY `FKABAED504EF37BA43` (`id`),
  CONSTRAINT `FKABAED504EF37BA43` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`alumno`
--

/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
LOCK TABLES `alumno` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;


--
-- Definition of table `qin`.`alumno_materia`
--

DROP TABLE IF EXISTS `qin`.`alumno_materia`;
CREATE TABLE  `qin`.`alumno_materia` (
  `alumno_id` bigint(20) NOT NULL,
  `materia_id` bigint(20) NOT NULL,
  UNIQUE KEY `alumno_id` (`alumno_id`,`materia_id`),
  KEY `FK1DCACFAA13D0E594` (`materia_id`),
  KEY `FK1DCACFAAC3184200` (`alumno_id`),
  CONSTRAINT `FK1DCACFAAC3184200` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`),
  CONSTRAINT `FK1DCACFAA13D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`alumno_materia`
--

/*!40000 ALTER TABLE `alumno_materia` DISABLE KEYS */;
LOCK TABLES `alumno_materia` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `alumno_materia` ENABLE KEYS */;


--
-- Definition of table `qin`.`consigna`
--

DROP TABLE IF EXISTS `qin`.`consigna`;
CREATE TABLE  `qin`.`consigna` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `consigna` varchar(255) NOT NULL,
  `orden` int(11) NOT NULL,
  `puntaje` double NOT NULL,
  `trabajo_practico_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `trabajo_practico_id` (`trabajo_practico_id`),
  KEY `FKDE22FA0290D51443` (`trabajo_practico_id`),
  CONSTRAINT `FKDE22FA0290D51443` FOREIGN KEY (`trabajo_practico_id`) REFERENCES `trabajo_practico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`consigna`
--

/*!40000 ALTER TABLE `consigna` DISABLE KEYS */;
LOCK TABLES `consigna` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `consigna` ENABLE KEYS */;


--
-- Definition of table `qin`.`correccion`
--

DROP TABLE IF EXISTS `qin`.`correccion`;
CREATE TABLE  `qin`.`correccion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `correccion` varchar(255) NOT NULL,
  `puntaje` double NOT NULL,
  `dictamen_id` bigint(20) DEFAULT NULL,
  `respuesta_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dictamen_id` (`dictamen_id`,`respuesta_id`),
  KEY `FK44DA650F2EA8FD34` (`respuesta_id`),
  KEY `FK44DA650F720C6720` (`dictamen_id`),
  CONSTRAINT `FK44DA650F720C6720` FOREIGN KEY (`dictamen_id`) REFERENCES `dictamen` (`id`),
  CONSTRAINT `FK44DA650F2EA8FD34` FOREIGN KEY (`respuesta_id`) REFERENCES `respuesta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`correccion`
--

/*!40000 ALTER TABLE `correccion` DISABLE KEYS */;
LOCK TABLES `correccion` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `correccion` ENABLE KEYS */;


--
-- Definition of table `qin`.`dictamen`
--

DROP TABLE IF EXISTS `qin`.`dictamen`;
CREATE TABLE  `qin`.`dictamen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dictamen` varchar(255) NOT NULL,
  `puntaje` double NOT NULL,
  `resolucion_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resolucion_id` (`resolucion_id`),
  KEY `FKF5E3FE8B56134460` (`resolucion_id`),
  CONSTRAINT `FKF5E3FE8B56134460` FOREIGN KEY (`resolucion_id`) REFERENCES `resolucion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`dictamen`
--

/*!40000 ALTER TABLE `dictamen` DISABLE KEYS */;
LOCK TABLES `dictamen` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `dictamen` ENABLE KEYS */;


--
-- Definition of table `qin`.`docente`
--

DROP TABLE IF EXISTS `qin`.`docente`;
CREATE TABLE  `qin`.`docente` (
  `matricula` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`),
  KEY `FK6CFBBE12EF37BA43` (`id`),
  CONSTRAINT `FK6CFBBE12EF37BA43` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`docente`
--

/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
LOCK TABLES `docente` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;


--
-- Definition of table `qin`.`grupo`
--

DROP TABLE IF EXISTS `qin`.`grupo`;
CREATE TABLE  `qin`.`grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `materia_id` bigint(20) DEFAULT NULL,
  `resolucion_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resolucion_id` (`resolucion_id`),
  KEY `FK5E10C6913D0E594` (`materia_id`),
  KEY `FK5E10C6956134460` (`resolucion_id`),
  CONSTRAINT `FK5E10C6956134460` FOREIGN KEY (`resolucion_id`) REFERENCES `resolucion` (`id`),
  CONSTRAINT `FK5E10C6913D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`grupo`
--

/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
LOCK TABLES `grupo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;


--
-- Definition of table `qin`.`grupo_alumno`
--

DROP TABLE IF EXISTS `qin`.`grupo_alumno`;
CREATE TABLE  `qin`.`grupo_alumno` (
  `grupo_id` bigint(20) NOT NULL,
  `alumno_id` bigint(20) NOT NULL,
  UNIQUE KEY `grupo_id` (`grupo_id`,`alumno_id`),
  KEY `FK4193AD9A58A29D94` (`grupo_id`),
  KEY `FK4193AD9AC3184200` (`alumno_id`),
  CONSTRAINT `FK4193AD9AC3184200` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`),
  CONSTRAINT `FK4193AD9A58A29D94` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`grupo_alumno`
--

/*!40000 ALTER TABLE `grupo_alumno` DISABLE KEYS */;
LOCK TABLES `grupo_alumno` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `grupo_alumno` ENABLE KEYS */;


--
-- Definition of table `qin`.`materia`
--

DROP TABLE IF EXISTS `qin`.`materia`;
CREATE TABLE  `qin`.`materia` (
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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`materia`
--

/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
LOCK TABLES `materia` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;


--
-- Definition of table `qin`.`resolucion`
--

DROP TABLE IF EXISTS `qin`.`resolucion`;
CREATE TABLE  `qin`.`resolucion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trabajo_practico_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA099BE5D90D51443` (`trabajo_practico_id`),
  CONSTRAINT `FKA099BE5D90D51443` FOREIGN KEY (`trabajo_practico_id`) REFERENCES `trabajo_practico` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`resolucion`
--

/*!40000 ALTER TABLE `resolucion` DISABLE KEYS */;
LOCK TABLES `resolucion` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `resolucion` ENABLE KEYS */;


--
-- Definition of table `qin`.`respuesta`
--

DROP TABLE IF EXISTS `qin`.`respuesta`;
CREATE TABLE  `qin`.`respuesta` (
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

--
-- Dumping data for table `qin`.`respuesta`
--

/*!40000 ALTER TABLE `respuesta` DISABLE KEYS */;
LOCK TABLES `respuesta` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `respuesta` ENABLE KEYS */;


--
-- Definition of table `qin`.`trabajo_practico`
--

DROP TABLE IF EXISTS `qin`.`trabajo_practico`;
CREATE TABLE  `qin`.`trabajo_practico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `materia_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B78289D13D0E594` (`materia_id`),
  CONSTRAINT `FK4B78289D13D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`trabajo_practico`
--

/*!40000 ALTER TABLE `trabajo_practico` DISABLE KEYS */;
LOCK TABLES `trabajo_practico` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `trabajo_practico` ENABLE KEYS */;


--
-- Definition of table `qin`.`usuario`
--

DROP TABLE IF EXISTS `qin`.`usuario`;
CREATE TABLE  `qin`.`usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `contrasenia_usuario` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `qin`.`usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
LOCK TABLES `usuario` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
