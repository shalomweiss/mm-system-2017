-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db
-- ------------------------------------------------------
-- Server version	5.7.19

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
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
/*!40000 ALTER TABLE `activities` ENABLE KEYS */;
UNLOCK TABLES;

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
  `academicInstitute` int(11) NOT NULL,
  `average` float DEFAULT NULL,
  `academicDicipline1` varchar(45) DEFAULT NULL,
  `academicDecipline2` varchar(45) DEFAULT NULL,
  `isGraduate` tinyint(4) DEFAULT NULL,
  `resume` varchar(254) DEFAULT NULL,
  `gradeSheet` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `academicId_idx` (`academicInstitute`),
  CONSTRAINT `academicId` FOREIGN KEY (`academicInstitute`) REFERENCES `academicinstitute` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
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

--
-- Table structure for table `mentors`
--

DROP TABLE IF EXISTS `mentors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mentors` (
  `id` int(11) NOT NULL,
  `experience` text,
  `role` varchar(45) DEFAULT NULL,
  `company` int(11) NOT NULL,
  `volunteering` text,
  `workHistory` text,
  PRIMARY KEY (`id`),
  KEY `companyId_idx` (`company`),
  CONSTRAINT `companyId` FOREIGN KEY (`company`) REFERENCES `workplaces` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mentorId` FOREIGN KEY (`id`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mentors`
--

LOCK TABLES `mentors` WRITE;
/*!40000 ALTER TABLE `mentors` DISABLE KEYS */;
INSERT INTO `mentors` VALUES (8,NULL,NULL,5,NULL,NULL),(9,NULL,NULL,3,NULL,NULL),(10,NULL,NULL,6,NULL,NULL);
/*!40000 ALTER TABLE `mentors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pairs`
--

DROP TABLE IF EXISTS `pairs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pairs` (
  `pairId` int(11) NOT NULL AUTO_INCREMENT,
  `mentorId` int(11) NOT NULL,
  `menteeId` int(11) NOT NULL,
  `activeStatus` tinyint(4) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `jointMessage` text,
  `tsofenMessage` text,
  PRIMARY KEY (`pairId`),
  KEY `mentorID_pairs_idx` (`mentorId`),
  KEY `menteeID_pairs_idx` (`menteeId`),
  CONSTRAINT `menteeID_pairs` FOREIGN KEY (`menteeId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mentorID_pairs` FOREIGN KEY (`mentorId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pairs`
--

LOCK TABLES `pairs` WRITE;
/*!40000 ALTER TABLE `pairs` DISABLE KEYS */;
/*!40000 ALTER TABLE `pairs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `userId` int(11) NOT NULL,
  `token` varchar(120) NOT NULL,
  `creationDate` datetime NOT NULL,
  `expirationDate` datetime NOT NULL,
  `deviceId` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`,`token`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (4,'1','2017-09-17 20:00:00','2017-10-17 20:00:00','1');
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `email` varchar(254) NOT NULL,
  `phoneNumber` varchar(25) NOT NULL,
  `password` varchar(45) NOT NULL,
  `gender` tinyint(4) NOT NULL,
  `address` varchar(254) DEFAULT NULL,
  `notes` text,
  `profilePicture` varchar(225) DEFAULT NULL,
  `active` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,1,'m7md','kn3ani','myk22','1234567','qweasd',0,'kaboul','',NULL,1),(5,1,'ayman','fa3our','ayfa','987654','zxcasd',0,'tarshi7a',NULL,NULL,0),(6,1,'maha','bsoul','mahab','21739864','jdsgf',1,'rene',NULL,NULL,0),(7,3,'nagham','ghantous','nghantous','3278569','jkgfbcnry',1,'nazareth',NULL,NULL,1),(8,2,'bill','gates','billie','287365','jkgncrf',0,'kaboul',NULL,NULL,1),(9,2,'mark','zack','brave.heart','45696','urnvcmcoiurn',0,'tamra',NULL,NULL,0),(10,2,'miranda','care','whocares','2345678','xvcvbn',1,'arraba',NULL,NULL,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workplaces`
--

DROP TABLE IF EXISTS `workplaces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `workplaces` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `area` varchar(45) DEFAULT NULL,
  `city` varchar(45) NOT NULL,
  `address` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workplaces`
--

LOCK TABLES `workplaces` WRITE;
/*!40000 ALTER TABLE `workplaces` DISABLE KEYS */;
INSERT INTO `workplaces` VALUES (1,'microsoft',NULL,'haifa',NULL),(2,'intel',NULL,'jerusalem',NULL),(3,'mellanox',NULL,'yokne\'am',NULL),(4,'galeel',NULL,'nazareth',NULL),(5,'facebook',NULL,'tel-aviv',NULL),(6,'google',NULL,'haifa',NULL);
/*!40000 ALTER TABLE `workplaces` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-27 13:54:46
