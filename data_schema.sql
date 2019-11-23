-- MySQL dump 10.13  Distrib 5.7.28, for Linux (x86_64)
--
-- Host: localhost    Database: sports
-- ------------------------------------------------------
-- Server version	5.7.28-0ubuntu0.18.04.4

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
-- Table structure for table `comp_player`
--

DROP TABLE IF EXISTS `comp_player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comp_player` (
  `player` int(11) NOT NULL,
  `competition` int(11) NOT NULL,
  PRIMARY KEY (`player`,`competition`),
  KEY `fk_comp_player_1_idx` (`player`),
  KEY `fk_comp_player_2_idx` (`competition`),
  CONSTRAINT `fk_comp` FOREIGN KEY (`competition`) REFERENCES `competition` (`competitionID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_player` FOREIGN KEY (`player`) REFERENCES `player` (`playerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf32;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comp_player`
--

LOCK TABLES `comp_player` WRITE;
/*!40000 ALTER TABLE `comp_player` DISABLE KEYS */;
INSERT INTO `comp_player` VALUES (83,17),(83,18),(84,18),(85,18),(87,17),(89,18),(90,18),(92,17),(94,17),(95,17),(95,18),(98,17),(99,18),(101,17);
/*!40000 ALTER TABLE `comp_player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `competition`
--

DROP TABLE IF EXISTS `competition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `competition` (
  `competitionID` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(45) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`competitionID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `competition`
--

LOCK TABLES `competition` WRITE;
/*!40000 ALTER TABLE `competition` DISABLE KEYS */;
INSERT INTO `competition` VALUES (17,'Berlin','2021-11-10'),(18,'London','2020-12-06'),(19,'Rome','2022-10-09'),(20,'Toronto','2020-10-09'),(22,'Szeged','2023-08-31'),(23,'Melbourne','2020-10-07'),(24,'Tokyo','2021-07-06');
/*!40000 ALTER TABLE `competition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `countryCode` varchar(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`countryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('ARG','Argentina'),('AUS','Australia'),('BEL','Belgium'),('BRA','Brazil'),('CHN','China'),('CRO','Croatia'),('ESP','Spain'),('GBR','Great-Britain'),('GER','Germany'),('HUN','Hungary'),('IND','India'),('JPN','Japan'),('KOR','South Korea'),('POL','Poland'),('PRK','North Korea'),('SLO','Slovenia'),('USA','United States of America');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `matches`
--

DROP TABLE IF EXISTS `matches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matches` (
  `matchID` int(11) NOT NULL AUTO_INCREMENT,
  `player1ID` int(11) NOT NULL,
  `player2ID` int(11) NOT NULL,
  `player1Point` int(11) NOT NULL,
  `player2Point` int(11) NOT NULL,
  `competitionID` int(11) NOT NULL,
  PRIMARY KEY (`matchID`),
  KEY `fk_matches_1_idx` (`player1ID`),
  KEY `fk_matches_1_idx1` (`player2ID`),
  KEY `fk_matches_comp_idx` (`competitionID`),
  CONSTRAINT `fk_matches_comp` FOREIGN KEY (`competitionID`) REFERENCES `competition` (`competitionID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_matches_pl1` FOREIGN KEY (`player1ID`) REFERENCES `player` (`playerID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_matches_pl2` FOREIGN KEY (`player2ID`) REFERENCES `player` (`playerID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matches`
--

LOCK TABLES `matches` WRITE;
/*!40000 ALTER TABLE `matches` DISABLE KEYS */;
/*!40000 ALTER TABLE `matches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `playerID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `birthdate` date NOT NULL,
  `trainerID` int(11) DEFAULT NULL,
  `countryCode` varchar(10) NOT NULL,
  PRIMARY KEY (`playerID`),
  KEY `fk_player_1_idx` (`trainerID`),
  KEY `fk_player_2_idx` (`countryCode`),
  CONSTRAINT `fk_player_country` FOREIGN KEY (`countryCode`) REFERENCES `country` (`countryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_trainer` FOREIGN KEY (`trainerID`) REFERENCES `trainer` (`trainerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (83,'Bagwati Basu','1991-10-11',51,'IND'),(84,'Lovre Ratkovi?','1995-10-09',63,'CRO'),(85,'An?ela Stankovi?','1996-12-03',66,'CRO'),(86,'Olivia Mota','1997-03-02',55,'ESP'),(87,'Szücs Ádám','2000-12-12',64,'HUN'),(88,'Sipos Zoltán','1989-07-06',61,'HUN'),(89,'Daniel G?owacki','2000-08-07',60,'POL'),(90,'Eryk Szyma?ski','1990-10-09',58,'POL'),(91,'Laron O\'Kon','2001-05-04',52,'USA'),(92,'Jeremy Friesen','2002-10-09',53,'USA'),(93,'Forrest Gump','1969-12-31',54,'USA'),(94,'Zhu Zan','2005-10-09',71,'CHN'),(95,'Wu Lingxin','2000-10-09',56,'CHN'),(96,'Yin Yan','1999-10-09',57,'CHN'),(97,'Jia Ruogang','1994-10-09',59,'CHN'),(98,'David Segers','1990-10-09',62,'BEL'),(99,'Arne Dubois','1993-10-09',72,'BEL'),(100,'Erik Frank','1991-10-09',68,'GER'),(101,'Huang Song','1993-10-09',65,'JPN'),(102,'Simone Bergeron','2001-10-30',67,'ESP'),(103,'Mathieu-Antoine Gingras','1994-03-30',69,'BEL');
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trainer`
--

DROP TABLE IF EXISTS `trainer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trainer` (
  `trainerID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 NOT NULL,
  `countryCode` varchar(10) NOT NULL,
  PRIMARY KEY (`trainerID`),
  KEY `fk_trainer_1_idx` (`countryCode`),
  CONSTRAINT `fk_country` FOREIGN KEY (`countryCode`) REFERENCES `country` (`countryCode`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainer`
--

LOCK TABLES `trainer` WRITE;
/*!40000 ALTER TABLE `trainer` DISABLE KEYS */;
INSERT INTO `trainer` VALUES (51,'Dorothy M. McClendon','USA'),(52,'Joann A. Moore','USA'),(53,'William S. Abbott','USA'),(54,'Alonso E. Peterson','GER'),(55,'Jeannine R. Gaydos','GER'),(56,'Peggy R. Emmons','USA'),(57,'Billy M. Militello','ESP'),(58,'Carol B. Cooper','HUN'),(59,'James M. Taylor','HUN'),(60,'Isailo Peci?','CRO'),(61,'Hin Chi Huang','CHN'),(62,'Albert Kroningen','BEL'),(63,'Ivo Milisic','CRO'),(64,'László F?z?','HUN'),(65,'Guambala Inshu','IND'),(66,'Ante Cevic','CRO'),(67,'Marcel Woralkewicz ','POL'),(68,'Entomoto Santo','JPN'),(69,'Milan Perisic','POL'),(71,'Vincenza Koelpin','JPN'),(72,'Zaad Lal Comar','IND');
/*!40000 ALTER TABLE `trainer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-23 16:25:39
