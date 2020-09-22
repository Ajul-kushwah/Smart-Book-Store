-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bookstore
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addbooks`
--

DROP TABLE IF EXISTS `addbooks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addbooks` (
  `bookid` int(11) NOT NULL,
  `bname` varchar(100) DEFAULT NULL,
  `bpublisher` varchar(100) DEFAULT NULL,
  `bauthor` varchar(100) DEFAULT NULL,
  `publishing_dates` date DEFAULT NULL,
  `bstock` int(20) DEFAULT NULL,
  `bprice` int(20) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addbooks`
--

LOCK TABLES `addbooks` WRITE;
/*!40000 ALTER TABLE `addbooks` DISABLE KEYS */;
INSERT INTO `addbooks` VALUES (1,'java','oracle','jeams gossling','2019-10-03',97,450),(2,'exam warrior','government','narendra modi','2019-10-03',14,100),(3,'aptitude','mc graw','abhijit guha','2019-10-03',1000,365),(4,'gandhi','gujraat publication','mahatma gandhi','2019-10-08',10,200);
/*!40000 ALTER TABLE `addbooks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `customerid` int(10) NOT NULL,
  `cname` varchar(100) DEFAULT NULL,
  `mobile_no` decimal(65,0) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `dates` date DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'aniket',9876543210,'student','2007-10-14','kolar road bhopal mp'),(2,'addaa',9998887770,'student','2007-10-14','nadipura'),(3,'raja',8767612121,'student','2007-10-14','ghar me rhta he'),(4,'himesh',8979786711,'businessmen','2007-10-14','bada bazaar vidisha mp'),(5,'gappu',7666781111,'fokkat','2007-10-14','paresaan mohalla'),(7,'nitin',7869098,'student','2019-09-29','keshavnagarbairagar'),(8,'mohit',123321,'student','2019-10-01','chanderi mp'),(9,'nishant gupta',123456,'student','2007-10-14','karond bhopal');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `employeeid` int(10) DEFAULT NULL,
  `ename` varchar(20) DEFAULT NULL,
  `edesignation` varchar(15) DEFAULT NULL,
  `mobile_no` decimal(65,0) DEFAULT NULL,
  `starting_date` date DEFAULT NULL,
  `salary` int(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'babu','helper',1234567890,'2000-01-10',3000,'active','toppura vidisha'),(2,'anil','supervisor',1234567890,'2000-01-10',2000,'active','nadipura'),(3,'as','supervisor',1234567890,'2019-01-10',2500,'active','toppura vidisha');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signup`
--

DROP TABLE IF EXISTS `signup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `signup` (
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `security_question` varchar(50) DEFAULT NULL,
  `answer` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signup`
--

LOCK TABLES `signup` WRITE;
/*!40000 ALTER TABLE `signup` DISABLE KEYS */;
INSERT INTO `signup` VALUES ('ajul','luja','my name is','ajul'),('nitin','jethwani','who i am','student'),('rahul','rahul','what is my id','84630'),('anil','anil','what is your gf name?','hs'),('','1','a','1'),('','p','p','p'),('','','p','p'),('p','aa','p','p'),('karnik agrawal','karnik','my birth date','2000-02-31'),('abhi','abhi','favourite no.','0');
/*!40000 ALTER TABLE `signup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers` (
  `supplierid` int(50) DEFAULT NULL,
  `sname` varchar(50) DEFAULT NULL,
  `agency` varchar(100) DEFAULT NULL,
  `mobile_no` decimal(65,0) DEFAULT NULL,
  `startingdate` date DEFAULT NULL,
  `s_email` varchar(50) DEFAULT NULL,
  `saddress` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers`
--

LOCK TABLES `suppliers` WRITE;
/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` VALUES (1,'suraj','suraj Ltd',9998887770,'2019-10-09','suraj@gmail.com','raisen gate vidisha mp'),(3,'aaa','aaaa',222,'2019-10-06','sssssssssssssssss','ddddddddddddddddddd');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-01 11:54:43
