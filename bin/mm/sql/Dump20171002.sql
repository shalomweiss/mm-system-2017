CREATE DATABASE  IF NOT EXISTS `db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: aa16lmxbq1txb0j.coi6zcmnhpte.us-east-2.rds.amazonaws.com    Database: db
-- ------------------------------------------------------
-- Server version	5.6.35-log

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
  `pairId` int(11) NOT NULL,
  `note` varchar(225) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `menteeReport` text,
  `mentorReport` text,
  `menteePrivateReport` text,
  `mentorPrivateReport` text,
  `meetingType` tinyint(4) NOT NULL,
  `subject` varchar(45) NOT NULL,
  `location` varchar(254) NOT NULL,
  `date` date NOT NULL,
  `startingTime` time NOT NULL,
  `endingTime` time NOT NULL,
  `mentorComplete` tinyint(4) DEFAULT NULL,
  `menteeComplete` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`activityId`),
  KEY `menteeID_act_idx` (`menteeId`),
  KEY `mentorID_act_idx` (`mentorId`),
  KEY `pair_ID_idx` (`pairId`),
  CONSTRAINT `menteeID_act` FOREIGN KEY (`menteeId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mentorID_act` FOREIGN KEY (`mentorId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pair_ID` FOREIGN KEY (`pairId`) REFERENCES `pairs` (`pairId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activities`
--

LOCK TABLES `activities` WRITE;
/*!40000 ALTER TABLE `activities` DISABLE KEYS */;
INSERT INTO `activities` VALUES (17,16,1,2,NULL,2,'good','good','meh','kill it with fire',1,'','Class 101','2017-09-18','10:00:00','11:00:00',1,1),(17,16,2,2,NULL,2,'love it','great','bah','why',1,'','Class 209','2017-09-22','14:00:00','16:00:00',1,1);
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
  `graduationStatus` varchar(45) DEFAULT NULL,
  `academicInstitute` int(11) NOT NULL,
  `average` float DEFAULT NULL,
  `academicDicipline1` varchar(45) DEFAULT NULL,
  `academicDicipline2` varchar(45) DEFAULT NULL,
  `signedEULA` tinyint(4) DEFAULT NULL,
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
INSERT INTO `mentees` VALUES (4,2,'0',1,87,'cs',NULL,0,NULL,NULL),(5,4,'0',2,93,'cs',NULL,0,NULL,NULL),(6,3,'0',4,98,'is',NULL,0,NULL,NULL),(13,2,'0',1,99,'cs',NULL,0,NULL,NULL);
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
INSERT INTO `mentors` VALUES (8,NULL,'SE',5,NULL,NULL),(9,NULL,'SE',3,NULL,NULL),(10,NULL,'SE',6,NULL,NULL),(13,'none','SE',2,'yes','none'),(14,'none','SE',2,'yes','none'),(15,'none','SE',2,'yes','none'),(17,'Half blood prince','SE',2,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pairs`
--

LOCK TABLES `pairs` WRITE;
/*!40000 ALTER TABLE `pairs` DISABLE KEYS */;
INSERT INTO `pairs` VALUES (1,8,4,1,NULL,NULL,NULL,NULL),(2,17,16,1,'2017-09-17',NULL,NULL,NULL),(3,8,6,1,'2017-09-17',NULL,NULL,NULL),(4,15,5,0,'2017-09-17','2017-10-01',NULL,NULL);
/*!40000 ALTER TABLE `pairs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `deviceId` varchar(45) NOT NULL,
  `token` varchar(120) NOT NULL,
  `userId` int(11) NOT NULL,
  `creationDate` datetime NOT NULL,
  `expirationDate` datetime NOT NULL,
  PRIMARY KEY (`deviceId`,`token`),
  UNIQUE KEY `token_UNIQUE` (`token`),
  KEY `userId_users_idx` (`userId`),
  CONSTRAINT `userId_users` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES ('1','1',4,'2017-09-17 20:00:00','2017-10-17 20:00:00'),('2','2',16,'2017-09-17 20:00:00','2017-10-17 20:00:00'),('3','3',16,'2017-09-17 20:00:00','2017-10-17 20:00:00'),('4','4',16,'2017-09-17 20:00:00','2017-10-17 20:00:00');
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
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (4,3,'m7md','kn3ani','myk22','1234567','qweasd',0,'kaboul','',NULL,1),(5,3,'ayman','fa3our','ayfa','987654','zxcasd',0,'tarshi7a',NULL,NULL,0),(6,3,'maha','bsoul','mahab','21739864','jdsgf',1,'rene',NULL,NULL,0),(7,1,'nagham','ghantous','nghantous','3278569','jkgfbcnry',1,'nazareth',NULL,NULL,1),(8,2,'bill','gates','billie','287365','jkgncrf',0,'kaboul',NULL,NULL,1),(9,2,'mark','zack','brave.heart','45696','urnvcmcoiurn',0,'tamra',NULL,NULL,0),(10,2,'miranda','care','whocares','2345678','xvcvbn',1,'arraba',NULL,NULL,1),(13,2,'yara','rohana','yara.rohana@gmail.com','125','blabla',1,'Haifa','okay','pic',1),(14,2,'ghada','awady','ghada.rohana@gmail.com','125','blabla',1,'Haifa','okay','pic',1),(15,2,'jimmy','keth','jimmy.keth@gmail.com','125','blabla',1,'Haifa','okay','pic',1),(16,3,'Harry','Potter','test','123','test',0,'London',NULL,NULL,1),(17,2,'Severus','Snape','test2','123','test2',0,'Hogworts',NULL,NULL,1),(30,3,'badie','bido','bido@gmail.com','125','blabla',1,'Haifa','okay','pic',1),(31,3,'rachel','green','rachelgreen@gmail.com','125','blabla',1,'Haifa','okay','pic',1),(32,3,'areen','areen','areen@gmail.com','125','blabla',1,'Haifa','okay','pic',1),(33,3,'8','8','8','8','UW87bWKU',8,'8','5',NULL,1);
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

-- Dump completed on 2017-10-02 13:31:41
