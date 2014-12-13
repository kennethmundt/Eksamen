CREATE DATABASE  IF NOT EXISTS `dyreklinik` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dyreklinik`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: dyreklinik
-- ------------------------------------------------------
-- Server version	5.6.20-log

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
-- Table structure for table `animals`
--

DROP TABLE IF EXISTS `animals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animals` (
  `idAnimal` int(11) NOT NULL AUTO_INCREMENT,
  `animalName` varchar(45) NOT NULL,
  `birthday` varchar(45) NOT NULL,
  `fk_idAnimalSpecies` int(11) NOT NULL,
  `fk_idCustomer` int(11) NOT NULL,
  PRIMARY KEY (`idAnimal`),
  KEY `fk_idCustomer_idx` (`fk_idCustomer`),
  KEY `fk_idAnimalSpecies_idx` (`fk_idAnimalSpecies`),
  CONSTRAINT `fk_idAnimalSpecies` FOREIGN KEY (`fk_idAnimalSpecies`) REFERENCES `animalspecies` (`idAnimalSpecies`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idCustomer` FOREIGN KEY (`fk_idCustomer`) REFERENCES `customers` (`idCustomer`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals`
--

LOCK TABLES `animals` WRITE;
/*!40000 ALTER TABLE `animals` DISABLE KEYS */;
INSERT INTO `animals` VALUES (21,'Garfield','05-2009',1,73),(22,'Jim','01-2011',1,74),(23,'Piv','06-2013',4,75),(24,'Chevalier','02-2008',2,76),(25,'Svinet','02-2011',3,77),(26,'Grisen','03-2014',3,77),(27,'Bugs1','02-2014',5,78),(28,'Bugs2','02-2014',5,78),(29,'Pip','09-2008',7,79),(30,'Rat','02-2012',8,79),(31,'Piphans','02-2013',7,80),(32,'Hanspip','02-2013',7,80),(33,'Kitty','02-2014',1,81),(34,'Buster','03-2013',2,81),(35,'NoName','02-2011',3,81),(36,'Ddzzz','05-2013',6,82),(37,'Hanne','03-2009',8,82),(38,'John Wayne','14-02-90',4,83);
/*!40000 ALTER TABLE `animals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animalspecies`
--

DROP TABLE IF EXISTS `animalspecies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `animalspecies` (
  `idAnimalSpecies` int(11) NOT NULL AUTO_INCREMENT,
  `speciesName` varchar(45) NOT NULL,
  PRIMARY KEY (`idAnimalSpecies`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animalspecies`
--

LOCK TABLES `animalspecies` WRITE;
/*!40000 ALTER TABLE `animalspecies` DISABLE KEYS */;
INSERT INTO `animalspecies` VALUES (1,'Kat'),(2,'Hund'),(3,'Marsvin'),(4,'Hamster'),(5,'Kanin'),(6,'Ilder'),(7,'Fugl'),(8,'Rotte'),(9,'Mus');
/*!40000 ALTER TABLE `animalspecies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookings` (
  `idBooking` int(11) NOT NULL AUTO_INCREMENT,
  `dateTime` varchar(60) NOT NULL,
  `fk_idTreatment` int(11) NOT NULL,
  `fk_idAnimal` int(11) NOT NULL,
  `fk_idcustomer` int(11) NOT NULL,
  PRIMARY KEY (`idBooking`),
  KEY `fk_idTreatment_idx` (`fk_idTreatment`),
  KEY `fk_idAnimal_idx` (`fk_idAnimal`),
  KEY `fk_customer_idx` (`fk_idcustomer`),
  CONSTRAINT `fk_customer` FOREIGN KEY (`fk_idcustomer`) REFERENCES `customers` (`idCustomer`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_idAnimal` FOREIGN KEY (`fk_idAnimal`) REFERENCES `animals` (`idAnimal`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `fk_idTreatment` FOREIGN KEY (`fk_idTreatment`) REFERENCES `treatments` (`idTreatment`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (9,'16-12-2014 - Eftermiddag :13 - 15.30',26,23,75),(10,'24-12-2014 - Eftermiddag :13 - 15.30',22,25,77),(11,'03-12-2014 - Formiddag :09 - 12.30',23,26,77),(12,'18-12-2014 - Eftermiddag :13 - 15.30',27,27,78),(13,'16-12-2014 - Eftermiddag :13 - 15.30',21,28,78),(14,'18-12-2014 - Formiddag :09 - 12.30',24,30,79),(15,'16-12-2014 - Eftermiddag :13 - 15.30',25,29,79),(16,'19-12-2014 - Eftermiddag :13 - 15.30',24,21,73),(17,'13-12-2014 - Formiddag :09 - 12.30',23,21,73),(18,'21-12-2014 - Formiddag :09 - 12.30',22,21,73),(19,'28-12-2014 - Formiddag :09 - 12.30',23,38,83);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `idCustomer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  PRIMARY KEY (`idCustomer`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `idCustomer_UNIQUE` (`idCustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (73,'Erik Jensen','Lygten 1, 2400','12345678','theone@gmail.com'),(74,'Jannie Jensen','Lygten 2, 2400','22345678','theone1@gmail.com'),(75,'Sara Joensen','Lygten 3, 2400','32345678','theone3@gmail.com'),(76,'Henrik den Syvende','Amalienborg, 1234','42345678','theone4@gmail.com'),(77,'Kim Petersen','Lygten 5, 2400','52345678','theone5@gmail.com'),(78,'Signe Olsen','Lygten 6, 2400','62345678','theone6@gmail.com'),(79,'Jan Jensen','Lygten 7, 2400','72345678','theone7@gmail.com'),(80,'Hanne Nielsen','Lygten 8, 2400','82345678','theone8@gmail.com'),(81,'Hans Hansen','Lygten 9, 2400','92345678','theone9@gmail.com'),(82,'Kim Hansen','Lygten 10, 2400','87654321','theone10@gmail.com'),(83,'Kenneth Mundt','Lygten 40, 2400','60674046','km@kennethmundt.com');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeeaccounts`
--

DROP TABLE IF EXISTS `employeeaccounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employeeaccounts` (
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeeaccounts`
--

LOCK TABLES `employeeaccounts` WRITE;
/*!40000 ALTER TABLE `employeeaccounts` DISABLE KEYS */;
INSERT INTO `employeeaccounts` VALUES ('admin','0DsABx0T3uIJlQKQv7AhVhpBCVz476Q0sM1uubXq+Ur6DrMReeguUTvEeOze1hJa'),('Elvis','NxpnrmJhz9HjPFw8+i4OoDPu4VsM5yuaPDcv2LyGbVNmh+1e/FmqTdcfGeTdnU15'),('Jogvan','5XLONUlyL/RIQL+GwI7/BWri1euofkX1I4zgoiuIDyfqaPP9leJcdWgharFJZnjk'),('Kenneth','Sbhpe5r/evIydWMSRVnUOPtnQoPb1lsElpEF0kkutvS/G9mMOylNynMZWM/I+FcZ'),('Tina','hOozte2WiKxUvfynqd3GzevwambCEkEsH/uh6VNYnFUWIwXvc3qHDVTq8o/EyH59');
/*!40000 ALTER TABLE `employeeaccounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable` (
  `time` varchar(45) NOT NULL,
  `min` varchar(45) NOT NULL,
  PRIMARY KEY (`time`,`min`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES ('Eftermiddag','13 - 15.30'),('Formiddag','09 - 12.30');
/*!40000 ALTER TABLE `timetable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatments`
--

DROP TABLE IF EXISTS `treatments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatments` (
  `idTreatment` int(11) NOT NULL AUTO_INCREMENT,
  `treatmentName` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `comment` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idTreatment`),
  UNIQUE KEY `treatmentName_UNIQUE` (`treatmentName`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatments`
--

LOCK TABLES `treatments` WRITE;
/*!40000 ALTER TABLE `treatments` DISABLE KEYS */;
INSERT INTO `treatments` VALUES (21,'Vaccination',500,'15',''),(22,'Konsultation',400,'15',''),(23,'Operation',1400,'60','Faste i 8-12 timer inden'),(24,'Blodprøve',800,'30','Faste i 8-12 timer inden'),(25,'Klip i narkose',900,'60','Faste i 8-12 timer inden'),(26,'Klip',300,'30',''),(27,'Sundhedstjek',500,'30',''),(28,'Registrering',400,'15','I Dansk Hunderegister'),(29,'Neutralisation',1400,'60','Faste 8-12 timer inden'),(30,'Aflivning',1200,'30','');
/*!40000 ALTER TABLE `treatments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-13 16:17:55
