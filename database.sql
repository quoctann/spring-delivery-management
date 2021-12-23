-- MySQL dump 10.13  Distrib 8.0.26, for Linux (x86_64)
--
-- Host: localhost    Database: delivery_management
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL,
  `log` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  CONSTRAINT `fk_admin_user` FOREIGN KEY (`admin_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `auction`
--

DROP TABLE IF EXISTS `auction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `auction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` int DEFAULT NULL,
  `shipper_id` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_auction_shipper_idx` (`shipper_id`),
  KEY `fk_auction_order_idx` (`order_id`),
  CONSTRAINT `fk_auction_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`),
  CONSTRAINT `fk_auction_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`shipper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction`
--

LOCK TABLES `auction` WRITE;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
/*!40000 ALTER TABLE `auction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipper_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comment_shipper_idx` (`shipper_id`),
  KEY `fk_comment_customer_idx` (`customer_id`),
  CONSTRAINT `fk_comment_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `fk_comment_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`shipper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,3,2,'Te','2021-12-21 00:00:00'),(2,3,7,'Ok','2021-12-21 00:00:00'),(3,3,2,'Dich vu ok','2021-12-22 09:00:00'),(4,3,7,'Giao hang cham','2021-12-22 10:00:00'),(5,3,2,'On','2021-12-22 12:00:00'),(6,3,7,'Giao hang nhanh','2021-12-22 00:00:00'),(7,3,2,'Dich vu te','2021-12-22 00:00:00');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` int NOT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  CONSTRAINT `fk_customer_user` FOREIGN KEY (`customer_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (2,'123 Le Van Quoi'),(7,NULL),(10,NULL),(11,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shipper_id` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `completed_date` datetime DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `receiver_phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sent_from` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sent_to` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `payment_method` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rate_star` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_shipper_idx` (`shipper_id`),
  KEY `fk_order_customer_idx` (`customer_id`),
  CONSTRAINT `fk_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `fk_order_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`shipper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipper`
--

DROP TABLE IF EXISTS `shipper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shipper` (
  `shipper_id` int NOT NULL,
  `approved_by` int DEFAULT NULL,
  `id_card` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `avg_rating` float DEFAULT '0',
  PRIMARY KEY (`shipper_id`),
  KEY `fk_approved_by_admin_idx` (`approved_by`),
  CONSTRAINT `fk_approved_by_admin` FOREIGN KEY (`approved_by`) REFERENCES `admin` (`admin_id`),
  CONSTRAINT `fk_shipper_user` FOREIGN KEY (`shipper_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipper`
--

LOCK TABLES `shipper` WRITE;
/*!40000 ALTER TABLE `shipper` DISABLE KEYS */;
INSERT INTO `shipper` VALUES (3,NULL,'123456',0),(8,NULL,NULL,NULL),(9,NULL,NULL,NULL);
/*!40000 ALTER TABLE `shipper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `joined_date` date DEFAULT NULL,
  `active` tinyint NOT NULL DEFAULT '1',
  `user_role` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'ROLE_CUSTOMER',
  `avatar` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `last_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$cf14sE1XtR5kpst301HIk.DacAAVETBk.F5romIi/K46fyQqPrgMy','Tran Quoc Tan','admin@mail.com','01234567890','2021-01-01',1,'ROLE_ADMIN','https://res.cloudinary.com/open-edu/image/upload/v1629294770/sample.jpg','Tấn'),(2,'customer','$2a$10$cf14sE1XtR5kpst301HIk.DacAAVETBk.F5romIi/K46fyQqPrgMy','Quoc Tan 2000','customer@mail.com','01234567111','2021-12-21',0,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1629294770/sample.jpg','Tran'),(3,'shipper','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','An','shipper@mail.com','01234567898','2021-12-21',0,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1629294770/sample.jpg','Le Van'),(7,'tantran','$2a$10$frwXswryzgKiCxRcy2tYwuFE74qe0qKyy..ppGtcheMm7K4wEmxsW','Trần','tan@mail.com','0706638940','2021-12-20',1,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1639985372/g2xfmsp10a2txawb0dyd.jpg','Tấn'),(8,'ship1','$2a$10$GeGwC3lijS90qTeyKdiAwOGRnhfeYG5wGmewMVPMUcRoEg4BgiGMW','Lê','ship@mail.com','0706638940','2021-12-20',1,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1639986150/hhzr0061dxhnnpa6sijv.jpg','Ship'),(9,'test0','$2a$10$a0sqPGxUQ3ZNjNAtVPSOZ.ONbP9M2taWYMQGsNODuIRZoXSt8bWlW','Test99','test0@mail.com','0706638940','2021-12-20',1,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1639987020/ym8ccwbxngbqyhlhwhoa.jpg','Test99'),(10,'vjp','$2a$10$cf14sE1XtR5kpst301HIk.DacAAVETBk.F5romIi/K46fyQqPrgMy','Trần','181050127tan@ou.edu.vn','0706638940','2021-12-20',1,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1640001020/hvne4lq3bz3nufnsexp3.jpg','Tấn'),(11,'customerX','$2a$10$JrgCJwmrXDg7B2w8PX4aKuoK6ALZ3Ga5ohmJh/uG3rYT6jDznIose','Quốc','181050127tan@ou.edu.vn','0706638940','2021-12-21',1,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1640059389/swto0zmob2me10yo79ei.png','Tấn');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-22 16:28:20
