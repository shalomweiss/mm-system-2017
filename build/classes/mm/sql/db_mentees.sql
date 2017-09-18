CREATE DATABASE  IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `mentees`
--

DROP TABLE IF EXISTS `mentees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentees` (
  `id` int(11) NOT NULL,
  `remainingSemesters` float DEFAULT NULL,
  `graduationStatus` tinyint(4) DEFAULT NULL,
  `academicInstitute` int(11) DEFAULT NULL,
  `average` float DEFAULT NULL,
  `academicDicipline1` varchar(45) DEFAULT NULL,
  `academicDicipline2` varchar(45) DEFAULT NULL,
  `isGuarantee` tinyint(4) DEFAULT NULL,
  `resume` varchar(254) DEFAULT NULL,
  `gradeSheet` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `academicId_idx` (`academicInstitute`),
  CONSTRAINT `academicId` FOREIGN KEY (`academicInstitute`) REFERENCES `academicInstitute` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `menteeId` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentees`
--

LOCK TABLES `mentees` WRITE;
/*!40000 ALTER TABLE `mentees` DISABLE KEYS */;
INSERT INTO `mentees` VALUES (4,2,0,1,87,'cs',NULL,0,NULL,NULL),(5,4,0,2,93,'cs',NULL,0,NULL,NULL),(6,3,0,4,98,'is',NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `mentees` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-17 15:39:43
