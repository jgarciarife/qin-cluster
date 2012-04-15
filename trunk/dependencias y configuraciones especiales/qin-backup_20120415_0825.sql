/*
SQLyog Ultimate v8.53 
MySQL - 5.1.61-0ubuntu0.11.10.1 : Database - qin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qin` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `qin`;

/*Table structure for table `alumno` */

DROP TABLE IF EXISTS `alumno`;

CREATE TABLE `alumno` (
  `padron` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `padron` (`padron`),
  KEY `FKABAED504EF37BA43` (`id`),
  CONSTRAINT `FKABAED504EF37BA43` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumno` */

insert  into `alumno`(`padron`,`id`) values ('80183',1),('80184',2);

/*Table structure for table `alumno_materia` */

DROP TABLE IF EXISTS `alumno_materia`;

CREATE TABLE `alumno_materia` (
  `alumno_id` bigint(20) NOT NULL,
  `materia_id` bigint(20) NOT NULL,
  UNIQUE KEY `alumno_id` (`alumno_id`,`materia_id`),
  KEY `FK1DCACFAA13D0E594` (`materia_id`),
  KEY `FK1DCACFAAC3184200` (`alumno_id`),
  CONSTRAINT `FK1DCACFAA13D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`),
  CONSTRAINT `FK1DCACFAAC3184200` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `alumno_materia` */

/*Table structure for table `consigna` */

DROP TABLE IF EXISTS `consigna`;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `consigna` */

insert  into `consigna`(`id`,`consigna`,`orden`,`puntaje`,`trabajo_practico_id`) values (1,'Una consigna',0,2,1),(2,'Dos consigna',1,2,1),(3,'Tres consigna',2,2,1),(4,'Cuatro consigna',3,2,1),(5,'Cinco consigna',4,2,1),(6,'hola',0,10,2);

/*Table structure for table `correccion` */

DROP TABLE IF EXISTS `correccion`;

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

/*Data for the table `correccion` */

/*Table structure for table `dictamen` */

DROP TABLE IF EXISTS `dictamen`;

CREATE TABLE `dictamen` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dictamen` varchar(255) NOT NULL,
  `puntaje` double NOT NULL,
  `resolucion_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `resolucion_id` (`resolucion_id`),
  KEY `FKF5E3FE8B56134460` (`resolucion_id`),
  CONSTRAINT `FKF5E3FE8B56134460` FOREIGN KEY (`resolucion_id`) REFERENCES `resolucion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `dictamen` */

insert  into `dictamen`(`id`,`dictamen`,`puntaje`,`resolucion_id`) values (1,'Todo Ok',2,1),(2,'Todo Ok',2,2),(3,'Todo Ok',2,3),(4,'Todo Ok',3,4),(5,'Todo Ok',10,5),(6,'Todo Ok',9.65,6),(7,'Todo Ok',3,7),(8,'Todo Ok',10,8);

/*Table structure for table `docente` */

DROP TABLE IF EXISTS `docente`;

CREATE TABLE `docente` (
  `matricula` varchar(255) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula` (`matricula`),
  KEY `FK6CFBBE12EF37BA43` (`id`),
  CONSTRAINT `FK6CFBBE12EF37BA43` FOREIGN KEY (`id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `docente` */

/*Table structure for table `grupo` */

DROP TABLE IF EXISTS `grupo`;

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

/*Data for the table `grupo` */

insert  into `grupo`(`id`,`materia_id`,`resolucion_id`) values (1,NULL,10);

/*Table structure for table `grupo_alumno` */

DROP TABLE IF EXISTS `grupo_alumno`;

CREATE TABLE `grupo_alumno` (
  `grupo_id` bigint(20) NOT NULL,
  `alumno_id` bigint(20) NOT NULL,
  UNIQUE KEY `grupo_id` (`grupo_id`,`alumno_id`),
  KEY `FK4193AD9A58A29D94` (`grupo_id`),
  KEY `FK4193AD9AC3184200` (`alumno_id`),
  CONSTRAINT `FK4193AD9A58A29D94` FOREIGN KEY (`grupo_id`) REFERENCES `grupo` (`id`),
  CONSTRAINT `FK4193AD9AC3184200` FOREIGN KEY (`alumno_id`) REFERENCES `alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `grupo_alumno` */

insert  into `grupo_alumno`(`grupo_id`,`alumno_id`) values (1,1),(1,2);

/*Table structure for table `materia` */

DROP TABLE IF EXISTS `materia`;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `materia` */

insert  into `materia`(`id`,`anio`,`carrera`,`codigo`,`cuatrimestre`,`nombre`,`docente_id`) values (1,2010,'75','75.25',1,'Calidad',NULL);

/*Table structure for table `resolucion` */

DROP TABLE IF EXISTS `resolucion`;

CREATE TABLE `resolucion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `trabajo_practico_id` bigint(20) DEFAULT NULL,
  `codigo_resolucion_compartida` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA099BE5D90D51443` (`trabajo_practico_id`),
  CONSTRAINT `FKA099BE5D90D51443` FOREIGN KEY (`trabajo_practico_id`) REFERENCES `trabajo_practico` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `resolucion` */

insert  into `resolucion`(`id`,`trabajo_practico_id`,`codigo_resolucion_compartida`) values (1,1,''),(2,2,''),(3,3,''),(4,4,''),(5,5,''),(6,6,''),(7,7,''),(8,8,''),(10,1,'636'),(11,2,'423'),(12,2,'120'),(13,3,'574'),(14,4,'250'),(15,5,'146'),(16,8,'517'),(17,1,'922');

/*Table structure for table `respuesta` */

DROP TABLE IF EXISTS `respuesta`;

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `respuesta` */

insert  into `respuesta`(`id`,`respuesta`,`consigna_id`,`resolucion_id`) values (1,'hola eh gato !!!\r\n\r\nlaskasdasd ',6,11),(2,'Test 1',1,10),(3,'',2,10),(4,'',3,10),(5,'',4,10),(6,'',5,10);

/*Table structure for table `trabajo_practico` */

DROP TABLE IF EXISTS `trabajo_practico`;

CREATE TABLE `trabajo_practico` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(255) NOT NULL,
  `materia_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B78289D13D0E594` (`materia_id`),
  CONSTRAINT `FK4B78289D13D0E594` FOREIGN KEY (`materia_id`) REFERENCES `materia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `trabajo_practico` */

insert  into `trabajo_practico`(`id`,`titulo`,`materia_id`) values (1,'Un titulo',1),(2,'TP',1),(3,'TP 3',1),(4,'TP 4',1),(5,'TP 5',1),(6,'TP 6',1),(7,'TP 7',1),(8,'TP 8',1);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `contrasenia_usuario` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `nombre_usuario` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_usuario` (`nombre_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `usuario` */

insert  into `usuario`(`id`,`apellido`,`contrasenia_usuario`,`nombre`,`nombre_usuario`) values (1,'Barrabino','diego','Diego','diego'),(2,'moreyra','123','martin','martomj');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
