CREATE DATABASE  IF NOT EXISTS `dyreklinik` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dyreklinik`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: dyreklinik
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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animals`
--

LOCK TABLES `animals` WRITE;
/*!40000 ALTER TABLE `animals` DISABLE KEYS */;
INSERT INTO `animals` VALUES (2,'nu','John jr.',1,27),(3,'midz','i morgen',1,28),(4,'en kat mere','i overmorgen',1,28),(5,'Bruce Lee Jr.','tomorrow',1,31),(7,'Midzen','i dag',1,47),(8,'hamster','lørdag',1,48),(9,'midzen','søndag',1,49),(11,'hans pilgaard','1900',1,50),(13,'Hut','2000',1,59),(14,'jim','876',1,60),(15,'John','i morgen',1,61);
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animalspecies`
--

LOCK TABLES `animalspecies` WRITE;
/*!40000 ALTER TABLE `animalspecies` DISABLE KEYS */;
INSERT INTO `animalspecies` VALUES (1,'Kat');
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
  `dateTime` varchar(32) NOT NULL,
  `fk_idTreatment` int(11) NOT NULL,
  `fk_idAnimal` int(11) NOT NULL,
  PRIMARY KEY (`idBooking`),
  UNIQUE KEY `dateTime_UNIQUE` (`dateTime`),
  KEY `fk_idTreatment_idx` (`fk_idTreatment`),
  KEY `fk_idAnimal_idx` (`fk_idAnimal`),
  CONSTRAINT `fk_idAnimal` FOREIGN KEY (`fk_idAnimal`) REFERENCES `animals` (`idAnimal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idTreatment` FOREIGN KEY (`fk_idTreatment`) REFERENCES `treatments` (`idTreatment`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (2,'2014-08-12',1,2),(3,'11-12-2014 - 09 :45',7,15);
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
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (2,'Tina','Very close 17','99999999','Tina@awesome.dk'),(6,'Elvis Saronjic','Tæt på 15, 2650 Hvidore','26375263','elvis@theman.com'),(7,'gerg','vkuyv','10101010','uyvlyb'),(9,'ohuih','goiug','2','iugiougu'),(10,'lvyb','uyvluyv','3','vyvlyuv'),(11,'jc','tkcvl','4','lvyuv'),(12,'lbib','ilbiub','5','iulbiub'),(13,'hkclghæ','uyvvtcuvyl','6','yuvubæ'),(14,'ækjblbj','bhkblk','7','jijækb'),(15,'kjlvvb','vlkvj','8','vhvl'),(16,'lhvuv','vvuvuyv','9','uyvuviuluvi'),(17,'lkjblkj','kjvkjlvh','10','lkjvhv'),(18,'lgliug','uigigiu','11','lgigiugi'),(19,'blvi','vvuivlui','13','vuivuiæv'),(20,'lhvl','ljkv','14','vklvkjv'),(21,'jkbkj','bkjb','16','kbkjbkj'),(22,'lkh','æjklj','17','kggl'),(23,'kjblkb','bkjæb','18','æjkbjkb'),(24,'jklb','bæjkbkb','19','ækjbjkbæ'),(25,'ljkjl','kljhkjlh','24','kjhljkhkjhjkl'),(26,'hjkhh','jhlkjhjklh','20','kjlhljkhl'),(27,'John Wayne','Lige her','21','JohnWayne@superAwesome.com'),(28,'kgndlgn','gonrgon','23','oingoinrogin'),(31,'Bruce Lee','China','25','BrugeLee@isawesome.com'),(32,'Crazy Person','Hestevej 14, Hvidovre','27','HorseLover@itsTrue.com'),(33,'hgef','bjhbkhvj','28','jhvhjvkhv'),(34,'ub','tciyvyubuiænioømop','29','cytkvuylbiuænioø'),(35,'ukuyvlibæoøpøioubivyut','rtctykvyulbiæniobilvu','30','ckyvulybuinoibi'),(36,'vytcluiæb','tycvt5d','31','ljutfyt'),(37,',jvckhjv','jkcgkhvljhv','32','kclhclhv'),(39,'kdkskb','skyldb','34','knbgucns'),(40,'bjksfhv','jdlkglh','35','æjbkdklgb'),(41,'sbvybruibsb','fjsdkjfshguisfsijfshso','36','nfuifnoe'),(42,'John Mogens','Lige her 17','37','jegerawesome@forreal.com'),(43,'kbluiu','iuæblvæiu','38','vuivuiæbi'),(44,'hvlvl','vulvvy','39','vuyvulv'),(45,'lhv','lvvuyvluy','40','vuylvluyvuyv'),(46,'kgchgckgckhg','ckghckghck','41','gckhgcghc'),(47,'vyuv','uyvukyv','42','vuvkuvk'),(48,'llvlyuvv','yuvuvæiv','43','ivæiviuv'),(49,'blhvlhv','lhvlvhvlh','44','lvlhvvj'),(50,'vvæuilbui','uibiulb','45','ilbluibliub'),(54,'kenneth','lige her','46','genrogno'),(55,'tina','tæt på','47','oignoirn'),(56,'nilubyv','yulvlyvluyvuyvylvlyv','48','iævivæ'),(57,'lbyvæiu','yvuvæiyv','49','æuivæiuvuiæv'),(59,'ji','jioij','12365478','kop@oijo.do'),(60,'yui','VimmersVej','78978954','woeiru@iop.com'),(61,'John','lige her','66666666','john@wayne.com');
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
INSERT INTO `employeeaccounts` VALUES ('Elvis','NxpnrmJhz9HjPFw8+i4OoDPu4VsM5yuaPDcv2LyGbVNmh+1e/FmqTdcfGeTdnU15'),('Jogvan','5XLONUlyL/RIQL+GwI7/BWri1euofkX1I4zgoiuIDyfqaPP9leJcdWgharFJZnjk'),('Kenneth','Sbhpe5r/evIydWMSRVnUOPtnQoPb1lsElpEF0kkutvS/G9mMOylNynMZWM/I+FcZ'),('Tina','hOozte2WiKxUvfynqd3GzevwambCEkEsH/uh6VNYnFUWIwXvc3qHDVTq8o/EyH59');
/*!40000 ALTER TABLE `employeeaccounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timetable`
--

DROP TABLE IF EXISTS `timetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timetable` (
  `time` varchar(6) NOT NULL,
  `min` varchar(6) NOT NULL,
  PRIMARY KEY (`time`,`min`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timetable`
--

LOCK TABLES `timetable` WRITE;
/*!40000 ALTER TABLE `timetable` DISABLE KEYS */;
INSERT INTO `timetable` VALUES ('09','00'),('09','15'),('09','30'),('09','45'),('10','00'),('10','15'),('10','30'),('11','00'),('11','15'),('11','30'),('11','45'),('13','00'),('13','15'),('13','30'),('13','45'),('14','00'),('14','15'),('14','30'),('14','45'),('15','00'),('15','15'),('15','30'),('15','45'),('16','00');
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
  PRIMARY KEY (`idTreatment`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatments`
--

LOCK TABLES `treatments` WRITE;
/*!40000 ALTER TABLE `treatments` DISABLE KEYS */;
INSERT INTO `treatments` VALUES (1,'Vacniation',750,'Hej','En time'),(5,'Test',123,'uioiuo','oiu'),(6,'Test22',456,'jfewio','we4'),(7,'peuhui',654,'456','12364'),(9,'elvis',123,'jio','jio'),(13,'iuygyu',987,'654','jio'),(14,'uio',789,'89','jio');
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

-- Dump completed on 2014-12-01 20:05:28
