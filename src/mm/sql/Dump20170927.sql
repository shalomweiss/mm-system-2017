Update SQL file

new db SQL file with updates
Unknown
authored9/27/2017 @ 3:36 PM
commit:3b2dff
parent:2c64a7
1 added
Name
Full Path
bin/mm/sql
/Dump20170927.sql
File History: bin/mm/sql/Dump20170927.sql
Diff ViewFile View
Update SQL file
3 minutes ago by Unknown
3b2dff
ADDED bin/mm/sql/Dump20170927.sql
End of History
@@ -0,0 +1,280 @@
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64) 
-- 
-- Host: 127.0.0.1    Database: db 
-- ------------------------------------------------------ 
-- Server version  5.7.19 
 
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
-- Table structure for table `academicinstitute` 
-- 
 
DROP TABLE IF EXISTS `academicinstitute`; 
/*!40101 SET @saved_cs_client     = @@character_set_client */; 
/*!40101 SET character_set_client = utf8 */; 
CREATE TABLE `academicinstitute` ( 
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(45) NOT NULL, 
  `area` varchar(45) DEFAULT NULL, 
  `city` varchar(45) NOT NULL, 
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8; 
/*!40101 SET character_set_client = @saved_cs_client */; 
 
-- 
-- Dumping data for table `academicinstitute` 
-- 
 
LOCK TABLES `academicinstitute` WRITE; 
/*!40000 ALTER TABLE `academicinstitute` DISABLE KEYS */; 
INSERT INTO `academicinstitute` VALUES (1,'haifa university','TSAFON','HAIFA'),(2,'TECHNION','tsafon','haifa'),(3,'tau','merkaz','tel-aviv'),(4,'hebrew university',NULL,'jerusalem'); 
/*!40000 ALTER TABLE `academicinstitute` ENABLE KEYS */; 
UNLOCK TABLES; 
 
-- 
-- Table structure for table `activities` 
-- 
 
DROP TABLE IF EXISTS `activities`; 
/*!40101 SET @saved_cs_client     = @@character_set_client */; 
/*!40101 SET character_set_client = utf8 */; 
CREATE TABLE `activities` ( 
  `mentorId` int(11) NOT NULL, 
  `menteeId` int(11) NOT NULL, 
  `activityId` int(11) NOT NULL AUTO_INCREMENT, 
  `note` varchar(225) DEFAULT NULL, 
  `status` int(11) NOT NULL, 
  `menteeReport` text, 
  `mentorReport` text, 
  `meetingType` tinyint(4) NOT NULL, 
  `subject` varchar(45) NOT NULL, 
  `location` varchar(254) NOT NULL, 
  `date` date NOT NULL, 
  `startingTime` time NOT NULL, 
  `endingTime` time NOT NULL, 
  PRIMARY KEY (`activityId`), 
  KEY `menteeID_act_idx` (`menteeId`), 
  KEY `mentorID_act_idx` (`mentorId`), 
  CONSTRAINT `menteeID_act` FOREIGN KEY (`menteeId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION, 
  CONSTRAINT `mentorID_act` FOREIGN KEY (`mentorId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 
/*!40101 SET character_set_client = @saved_cs_client */; 
 
-- 
-- Dumping data for table `activities` 