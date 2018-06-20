-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: club
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attendance` (
  `ID_MEMBER` int(11) NOT NULL,
  `ID_TRAIN` int(11) NOT NULL,
  PRIMARY KEY (`ID_MEMBER`,`ID_TRAIN`),
  KEY `FK_ATTENDAN_ATTENDANC_TRAIN` (`ID_TRAIN`),
  CONSTRAINT `FK_ATTENDAN_ATTENDANC_MEMBER` FOREIGN KEY (`ID_MEMBER`) REFERENCES `member` (`ID_MEMBER`),
  CONSTRAINT `FK_ATTENDAN_ATTENDANC_TRAIN` FOREIGN KEY (`ID_TRAIN`) REFERENCES `train` (`ID_TRAIN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `ID_BRANCH` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_BRANCH` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `ADDRESS_BRANCH` varchar(300) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_BRANCH`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'cần  thơ','cần thơ'),(2,'Hcm','hcm');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `club`
--

DROP TABLE IF EXISTS `club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `club` (
  `ID_CLUB` int(11) NOT NULL AUTO_INCREMENT,
  `ID_BRANCH` int(11) NOT NULL,
  `ID_MEMBER` int(11) DEFAULT NULL,
  `NAME_CLUB` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_CLUB`),
  KEY `FK_CLUB_QUANLY_MEMBER` (`ID_MEMBER`),
  KEY `FK_CLUB_RELATIONS_BRANCH` (`ID_BRANCH`),
  CONSTRAINT `FK_CLUB_QUANLY_MEMBER` FOREIGN KEY (`ID_MEMBER`) REFERENCES `member` (`ID_MEMBER`),
  CONSTRAINT `FK_CLUB_RELATIONS_BRANCH` FOREIGN KEY (`ID_BRANCH`) REFERENCES `branch` (`ID_BRANCH`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `club`
--

LOCK TABLES `club` WRITE;
/*!40000 ALTER TABLE `club` DISABLE KEYS */;
INSERT INTO `club` VALUES (1,1,NULL,'văn nghệ');
/*!40000 ALTER TABLE `club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_of_week`
--

DROP TABLE IF EXISTS `date_of_week`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `date_of_week` (
  `ID_DOW` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_DOW` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `VARIABLE_DOW` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DOW`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_of_week`
--

LOCK TABLES `date_of_week` WRITE;
/*!40000 ALTER TABLE `date_of_week` DISABLE KEYS */;
/*!40000 ALTER TABLE `date_of_week` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decision`
--

DROP TABLE IF EXISTS `decision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `decision` (
  `ID_DECISION` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_DECISION` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_DECISION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decision`
--

LOCK TABLES `decision` WRITE;
/*!40000 ALTER TABLE `decision` DISABLE KEYS */;
/*!40000 ALTER TABLE `decision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `join_club`
--

DROP TABLE IF EXISTS `join_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `join_club` (
  `ID_MEMBER` int(11) NOT NULL,
  `ID_CLUB` int(11) NOT NULL,
  `ID_STATUS` int(11) NOT NULL,
  `DATE_JOIN` date DEFAULT NULL,
  PRIMARY KEY (`ID_MEMBER`,`ID_CLUB`,`ID_STATUS`),
  KEY `FK_JOIN_CLU_JOIN_CLUB_CLUB` (`ID_CLUB`),
  KEY `FK_JOIN_CLU_JOIN_CLUB_STATUS` (`ID_STATUS`),
  CONSTRAINT `FK_JOIN_CLU_JOIN_CLUB_CLUB` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`),
  CONSTRAINT `FK_JOIN_CLU_JOIN_CLUB_MEMBER` FOREIGN KEY (`ID_MEMBER`) REFERENCES `member` (`ID_MEMBER`),
  CONSTRAINT `FK_JOIN_CLU_JOIN_CLUB_STATUS` FOREIGN KEY (`ID_STATUS`) REFERENCES `status` (`ID_STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `join_club`
--

LOCK TABLES `join_club` WRITE;
/*!40000 ALTER TABLE `join_club` DISABLE KEYS */;
/*!40000 ALTER TABLE `join_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `ID_MEMBER` int(11) NOT NULL AUTO_INCREMENT,
  `ID_BRANCH` int(11) DEFAULT NULL,
  `NAME_MEMBER` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `BIRTH_DAY_MEMBER` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `SEX_MEMBER` tinyint(1) DEFAULT NULL,
  `PHONE_NUM_MEMBER` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `USER_NAME_MEMBER` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `PASSWORD_MEMBER` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `AVARTAR_MEMBER` varchar(250) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_MEMBER`),
  KEY `FK_MEMBER_RELATIONS_BRANCH` (`ID_BRANCH`),
  CONSTRAINT `FK_MEMBER_RELATIONS_BRANCH` FOREIGN KEY (`ID_BRANCH`) REFERENCES `branch` (`ID_BRANCH`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,1,'nguyen tan duoc',NULL,1,NULL,'ntduoc@gmail.com','$2a$10$JsYqdrFnbwEQPyog6DVe1.DTBBgJY8JpgDXzRAkAVgp5MKCQPyKYG',NULL);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_role`
--

DROP TABLE IF EXISTS `member_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member_role` (
  `ID_ROLE` int(11) NOT NULL,
  `ID_MEMBER` int(11) NOT NULL,
  PRIMARY KEY (`ID_ROLE`,`ID_MEMBER`),
  KEY `FK_MEMBER_R_MEMBER_RO_MEMBER` (`ID_MEMBER`),
  CONSTRAINT `FK_MEMBER_R_MEMBER_RO_MEMBER` FOREIGN KEY (`ID_MEMBER`) REFERENCES `member` (`ID_MEMBER`),
  CONSTRAINT `FK_MEMBER_R_MEMBER_RO_ROLE` FOREIGN KEY (`ID_ROLE`) REFERENCES `role` (`ID_ROLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_role`
--

LOCK TABLES `member_role` WRITE;
/*!40000 ALTER TABLE `member_role` DISABLE KEYS */;
INSERT INTO `member_role` VALUES (1,1),(2,1);
/*!40000 ALTER TABLE `member_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `month`
--

DROP TABLE IF EXISTS `month`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `month` (
  `ID_MONTH` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_MONTH` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_MONTH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `month`
--

LOCK TABLES `month` WRITE;
/*!40000 ALTER TABLE `month` DISABLE KEYS */;
/*!40000 ALTER TABLE `month` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `ID_ROLE` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_ROLE` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `CODE_ROLE` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_ROLE`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'admin','ADMIN'),(2,'otc club','OTC_CLUB'),(3,'otc','OTC'),(4,'member','MEMBER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `ID_SCHEDULE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DOW` int(11) DEFAULT NULL,
  `NAME_SCHEDULE` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `TIME_SCHEDULE` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `LOCATION_SCHEDULE` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_SCHEDULE`),
  KEY `FK_SCHEDULE_RELATIONS_DATE_OF_` (`ID_DOW`),
  CONSTRAINT `FK_SCHEDULE_RELATIONS_DATE_OF_` FOREIGN KEY (`ID_DOW`) REFERENCES `date_of_week` (`ID_DOW`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule_club`
--

DROP TABLE IF EXISTS `schedule_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule_club` (
  `ID_SCHEDULE` int(11) NOT NULL,
  `ID_CLUB` int(11) NOT NULL,
  PRIMARY KEY (`ID_SCHEDULE`,`ID_CLUB`),
  KEY `FK_SCHEDULE_SCHEDULE__CLUB` (`ID_CLUB`),
  CONSTRAINT `FK_SCHEDULE_SCHEDULE__CLUB` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`),
  CONSTRAINT `FK_SCHEDULE_SCHEDULE__SCHEDULE` FOREIGN KEY (`ID_SCHEDULE`) REFERENCES `schedule` (`ID_SCHEDULE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule_club`
--

LOCK TABLES `schedule_club` WRITE;
/*!40000 ALTER TABLE `schedule_club` DISABLE KEYS */;
/*!40000 ALTER TABLE `schedule_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `ID_STATUS` int(11) NOT NULL AUTO_INCREMENT,
  `NAME_STATUS` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_STATUS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summarization`
--

DROP TABLE IF EXISTS `summarization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summarization` (
  `ID_MEMBER` int(11) NOT NULL,
  `ID_MONTH` int(11) NOT NULL,
  `ID_DECISION` int(11) NOT NULL,
  `SCORE` float DEFAULT NULL,
  `CONTAIN` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID_MEMBER`,`ID_MONTH`,`ID_DECISION`),
  KEY `FK_SUMMARIZ_SUMMARIZA_MONTH` (`ID_MONTH`),
  KEY `FK_SUMMARIZ_SUMMARIZA_DECISION` (`ID_DECISION`),
  CONSTRAINT `FK_SUMMARIZ_SUMMARIZA_DECISION` FOREIGN KEY (`ID_DECISION`) REFERENCES `decision` (`ID_DECISION`),
  CONSTRAINT `FK_SUMMARIZ_SUMMARIZA_MEMBER` FOREIGN KEY (`ID_MEMBER`) REFERENCES `member` (`ID_MEMBER`),
  CONSTRAINT `FK_SUMMARIZ_SUMMARIZA_MONTH` FOREIGN KEY (`ID_MONTH`) REFERENCES `month` (`ID_MONTH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summarization`
--

LOCK TABLES `summarization` WRITE;
/*!40000 ALTER TABLE `summarization` DISABLE KEYS */;
/*!40000 ALTER TABLE `summarization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summarization_club`
--

DROP TABLE IF EXISTS `summarization_club`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summarization_club` (
  `ID_MONTH` int(11) NOT NULL,
  `ID_MEMBER` int(11) NOT NULL,
  `ID_CLUB` int(11) NOT NULL,
  `SCORE_CLUB` float DEFAULT NULL,
  PRIMARY KEY (`ID_MONTH`,`ID_MEMBER`,`ID_CLUB`),
  KEY `FK_SUMMARIZ_SUMMARIZA_CLUB` (`ID_CLUB`),
  CONSTRAINT `FK_SUMMARIZ_SUMMARIZA_CLUB` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summarization_club`
--

LOCK TABLES `summarization_club` WRITE;
/*!40000 ALTER TABLE `summarization_club` DISABLE KEYS */;
/*!40000 ALTER TABLE `summarization_club` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `ID_TRAIN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SCHEDULE` int(11) DEFAULT NULL,
  `ID_CLUB` int(11) DEFAULT NULL,
  `DATE_TRAIN` date DEFAULT NULL,
  PRIMARY KEY (`ID_TRAIN`),
  KEY `FK_TRAIN_RELATIONS_CLUB` (`ID_CLUB`),
  KEY `FK_TRAIN_RELATIONS_SCHEDULE` (`ID_SCHEDULE`),
  CONSTRAINT `FK_TRAIN_RELATIONS_CLUB` FOREIGN KEY (`ID_CLUB`) REFERENCES `club` (`ID_CLUB`),
  CONSTRAINT `FK_TRAIN_RELATIONS_SCHEDULE` FOREIGN KEY (`ID_SCHEDULE`) REFERENCES `schedule` (`ID_SCHEDULE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'club'
--

--
-- Dumping routines for database 'club'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-20 15:17:19
