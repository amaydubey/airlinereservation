CREATE DATABASE  IF NOT EXISTS `airline` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `airline`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: airline
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
  `flightNo` varchar(255) NOT NULL,
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
  PRIMARY KEY (`flightNo`),
  UNIQUE KEY `flightNo_UNIQUE` (`flightNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table for flights';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('AA123',120,'AA','BB','2017-03-12 09:00:00','2017-03-12 10:00:00',10,'EE',100,'II','HH',1997),('asdfdf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),('asdfdsdf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),('asgf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),('edfkjbheo',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),('sadfjy',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),('sddf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),('ssadtafddf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997),('ssadtddf',120,'AA','BB','2017-04-09 10:00:00','2017-04-10 11:00:00',10,'EE',80,'II','HH',1997);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_passengers`
--

DROP TABLE IF EXISTS `flight_passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight_passengers` (
  `flightNo` varchar(255) NOT NULL,
  `passengerId` int(11) NOT NULL,
  KEY `flightId_idx` (`flightNo`),
  KEY `passengerId_idx` (`passengerId`),
  CONSTRAINT `flightId` FOREIGN KEY (`flightNo`) REFERENCES `flight` (`flightNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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
INSERT INTO `passenger` VALUES (12,'XX','YY',11,'famale','123'),(17,'XX','YY',11,'male','1231212'),(18,'XX','YY',11,'famale',NULL),(21,'XX','YY',11,'famale','1235'),(22,'XX','YY',11,'famale','1235234');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `passenger_reservation`
--

DROP TABLE IF EXISTS `passenger_reservation`;
/*!50001 DROP VIEW IF EXISTS `passenger_reservation`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `passenger_reservation` AS SELECT 
 1 AS `passengerId`,
 1 AS `firstName`,
 1 AS `lastName`,
 1 AS `age`,
 1 AS `gender`,
 1 AS `phone`,
 1 AS `orderId`,
 1 AS `price`,
 1 AS `flightNo`,
 1 AS `flight_price`,
 1 AS `source`,
 1 AS `destination`,
 1 AS `departureTime`,
 1 AS `arrivalTime`,
 1 AS `seatsLeft`,
 1 AS `description`,
 1 AS `capacity`,
 1 AS `manufacturer`,
 1 AS `model`,
 1 AS `yearOfManufacture`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `passengerid`
--

DROP TABLE IF EXISTS `passengerid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passengerid` (
  `passenger_passengerId` varchar(255) DEFAULT NULL,
  `orderId` varchar(255) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengerid`
--

LOCK TABLES `passengerid` WRITE;
/*!40000 ALTER TABLE `passengerid` DISABLE KEYS */;
/*!40000 ALTER TABLE `passengerid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plane`
--

DROP TABLE IF EXISTS `plane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plane` (
  `planeId` int(11) NOT NULL AUTO_INCREMENT,
  `capacity` int(11) NOT NULL,
  `model` varchar(255) NOT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`planeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table for planes';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plane`
--

LOCK TABLES `plane` WRITE;
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
/*!40000 ALTER TABLE `plane` ENABLE KEYS */;
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
  `price` int(11) NOT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FK_dpk41oy30iktawfe5o0vnnjaj` (`passengerId`),
  CONSTRAINT `FK_dpk41oy30iktawfe5o0vnnjaj` FOREIGN KEY (`passengerId`) REFERENCES `passenger` (`passengerId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (5,12,240),(6,12,240),(7,12,240),(8,12,240),(9,12,240),(10,12,240),(11,12,240),(12,12,240),(13,17,240);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_flight`
--

DROP TABLE IF EXISTS `reservation_flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_flight` (
  `flightId` varchar(255) NOT NULL,
  `reservationId` int(11) NOT NULL,
  KEY `flightd_idx` (`flightId`),
  KEY `reservationId_idx` (`reservationId`),
  CONSTRAINT `flightNo` FOREIGN KEY (`flightId`) REFERENCES `flight` (`flightNo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `reservationId` FOREIGN KEY (`reservationId`) REFERENCES `reservation` (`orderId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Relationship table for flights in a reservation';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_flight`
--

LOCK TABLES `reservation_flight` WRITE;
/*!40000 ALTER TABLE `reservation_flight` DISABLE KEYS */;
INSERT INTO `reservation_flight` VALUES ('asdfdf',5),('asdfdsdf',5),('asdfdf',6),('asdfdsdf',6),('asdfdf',7),('asdfdsdf',7),('asdfdf',8),('asdfdsdf',8),('asdfdf',9),('asdfdsdf',9),('asdfdf',10),('asdfdsdf',10),('asdfdf',11),('asdfdsdf',11),('asdfdf',12),('asdfdsdf',12),('asdfdf',13),('asdfdsdf',13);
/*!40000 ALTER TABLE `reservation_flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `passenger_reservation`
--

/*!50001 DROP VIEW IF EXISTS `passenger_reservation`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `passenger_reservation` AS select `passenger`.`passengerId` AS `passengerId`,`passenger`.`firstName` AS `firstName`,`passenger`.`lastName` AS `lastName`,`passenger`.`age` AS `age`,`passenger`.`gender` AS `gender`,`passenger`.`phone` AS `phone`,`reservation`.`orderId` AS `orderId`,`reservation`.`price` AS `price`,`flight`.`flightNo` AS `flightNo`,`flight`.`price` AS `flight_price`,`flight`.`source` AS `source`,`flight`.`destination` AS `destination`,`flight`.`departureTime` AS `departureTime`,`flight`.`arrivalTime` AS `arrivalTime`,`flight`.`seatsLeft` AS `seatsLeft`,`flight`.`description` AS `description`,`flight`.`capacity` AS `capacity`,`flight`.`manufacturer` AS `manufacturer`,`flight`.`model` AS `model`,`flight`.`yearOfManufacture` AS `yearOfManufacture` from (((`passenger` left join `reservation` on((`passenger`.`passengerId` = `reservation`.`passengerId`))) left join `reservation_flight` on((`reservation`.`orderId` = `reservation_flight`.`reservationId`))) left join `flight` on((`flight`.`flightNo` = `reservation_flight`.`flightId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-26 19:31:23
