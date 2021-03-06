CREATE DATABASE  IF NOT EXISTS `airline` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `airline`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: airline
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `flightId` int(11) NOT NULL AUTO_INCREMENT,
  `flightNo` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `source` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `departureTime` datetime DEFAULT NULL,
  `arrivalTime` datetime DEFAULT NULL,
  `seatsLeft` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `yearOfManufacture` int(11) DEFAULT NULL,
  PRIMARY KEY (`flightId`),
  UNIQUE KEY `flightNo_UNIQUE` (`flightNo`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='Table for flights';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES (11,'asdfdf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),(12,'asdfdsdf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),(14,'sddf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),(15,'ssadtafddf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),(16,'ssadtddf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),(17,'sadfjy',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),(18,'edfkjbheo',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),(19,'asgf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_passengers`
--

DROP TABLE IF EXISTS `flight_passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_passengers` (
  `flightId` int(11) NOT NULL,
  `passengerId` int(11) NOT NULL,
  KEY `flightId_idx` (`flightId`),
  KEY `passengerId_idx` (`passengerId`),
  CONSTRAINT `flightId` FOREIGN KEY (`flightId`) REFERENCES `flight` (`flightId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `passengerId` FOREIGN KEY (`passengerId`) REFERENCES `passenger` (`passengerId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Relationship table for passengers in a flight.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_passengers`
--

LOCK TABLES `flight_passengers` WRITE;
/*!40000 ALTER TABLE `flight_passengers` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `passengerId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `phone` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`passengerId`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES (12,'XX','YY',11,'famale','123'),(17,'XX','YY',11,'famale','1567'),(18,'XX','YY',11,'famale',NULL),(21,'XX','YY',11,'famale','1235'),(22,'XX','YY',11,'famale','1235234');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `passengerId` int(11) NOT NULL,
  `price` decimal(8,2) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_flight`
--

DROP TABLE IF EXISTS `reservation_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_flight` (
  `flightId` int(11) NOT NULL,
  `reservationId` int(11) NOT NULL,
  KEY `flightd_idx` (`flightId`),
  KEY `reservationId_idx` (`reservationId`),
  CONSTRAINT `flightd` FOREIGN KEY (`flightId`) REFERENCES `flight` (`flightId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reservationId` FOREIGN KEY (`reservationId`) REFERENCES `reservation` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Relationship table for flights in a reservation';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_flight`
--

LOCK TABLES `reservation_flight` WRITE;
/*!40000 ALTER TABLE `reservation_flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-25 16:49:13
