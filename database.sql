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
INSERT INTO `admin` VALUES (1,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `auction`
--

LOCK TABLES `auction` WRITE;
/*!40000 ALTER TABLE `auction` DISABLE KEYS */;
INSERT INTO `auction` VALUES (1,1,3,5000),(2,1,8,10000),(3,11,16,25000),(4,10,16,50000),(5,7,3,60000),(6,12,16,20000),(7,13,16,20000);
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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,3,2,'Dich vu te','2021-12-21 00:00:00'),(2,3,7,'Ok','2021-12-21 00:00:00'),(3,3,2,'Dich vu ok','2021-12-22 09:00:00'),(4,3,7,'Giao hang cham','2021-12-22 10:00:00'),(5,3,2,'On','2021-12-22 12:00:00'),(6,3,7,'Giao hang nhanh','2021-12-22 00:00:00'),(7,3,2,'Dich vu te','2021-12-22 00:00:00'),(26,3,2,'Khong OK','2021-12-26 00:00:00'),(27,3,7,'Giao hang khong can than','2021-12-27 00:00:00'),(28,3,7,'Thai do tot','2021-12-27 00:00:00'),(29,9,2,'Thai do khong tot','2021-12-28 00:00:00'),(30,16,15,'Shipper nay tot','2021-12-28 00:00:00'),(31,16,2,'Shipper ship nhanh','2021-12-28 00:00:00');
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
INSERT INTO `customer` VALUES (2,'123 Le Van Quoi'),(7,'10 Le Lai'),(10,'9 Nguyen Trai'),(11,'8 Le Cong Tru'),(15,'123 Nguyen Kiem');
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
  `created_date` date DEFAULT NULL,
  `completed_date` datetime DEFAULT NULL,
  `status` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `receiver_phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sent_from` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sent_to` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `payment_method` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `type` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `transaction_id` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `rate_star` int DEFAULT NULL,
  `price` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_shipper_idx` (`shipper_id`),
  KEY `fk_order_customer_idx` (`customer_id`),
  CONSTRAINT `fk_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `fk_order_shipper` FOREIGN KEY (`shipper_id`) REFERENCES `shipper` (`shipper_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,8,2,'2021-10-10',NULL,'FAILED','Do an cho cun','0123456789',' 123 Lê Lai',' 99 Nguyễn Trãi','CASH',' 1',NULL,NULL,10000),(2,3,2,'2021-12-12',NULL,'FAILED','Quan ao','0123456789','123 Lê Lai','99 Nguyễn Trãi','CASH','2','',3,198512235),(3,3,2,'2020-10-10',NULL,'FAILED','Van phong pham','0123456789','123 Lê Lai','99 Nguyễn Trãi','CASH','3','',1,1341313456),(4,3,2,'2020-10-10',NULL,'SUCCESS','Thuoc','0123456789','123 Lê Lai','99 Nguyễn Trãi','CASH','1','',1,546556),(5,3,2,'2020-10-11',NULL,'SUCCESS','Thuc pham','0123456789','123 Lê Lai','99 Nguyễn Trãi','CASH','1','',NULL,100000),(6,3,2,'2020-10-11',NULL,'SUCCESS','Banh keo','0123456789','123 Lê Lai','99 Nguyễn Trãi','CASH','1','',NULL,215000),(7,NULL,2,'2020-10-11',NULL,'PENDING','Giay to','0708889991','1 Le Lai','2 Le Lai','CASH','1',NULL,NULL,NULL),(8,NULL,2,'2020-10-10',NULL,'PENDING','My pham','0706638940','1 Nguyen Trai','2 Le Lai','CASH','1',NULL,NULL,NULL),(9,NULL,2,'2020-10-10',NULL,'PENDING','Vat lieu xay dung','0708889991','1 Le Lai','2 Le Lai','CASH','2',NULL,NULL,NULL),(10,16,15,'2021-12-27',NULL,'SUCCESS',' 200 hop sua','0708889991',' 1 Le Lai',' 2 Le Lai','CASH',' 3',NULL,5,50000),(11,16,15,'2021-12-28',NULL,'SUCCESS',' Van phong pham','0706638940',' 1 Le Lai',' 2 Le Lai','CASH',' 2',NULL,5,25000),(12,16,15,'2021-12-28',NULL,'SUCCESS',' Thuc pham chuc nang','0708889991',' 1 Le Lai',' 2 Le Lai','CASH',' 2',NULL,5,20000),(13,16,NULL,'2021-12-28',NULL,'SUCCESS',' Gao','0708889991',' 1 Le Lai',' 2 Le Lai','CASH',' 3',NULL,1,20000);
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
INSERT INTO `shipper` VALUES (3,NULL,'1234567',0),(8,1,'999888',0),(9,1,'123',0),(14,NULL,'123456',0),(16,NULL,'123',4),(17,NULL,NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','$2a$10$cf14sE1XtR5kpst301HIk.DacAAVETBk.F5romIi/K46fyQqPrgMy','Tan','admin@mail.com','01234567890','2021-01-01',1,'ROLE_ADMIN','https://res.cloudinary.com/open-edu/image/upload/v1629294770/sample.jpg','Tran Quoc'),(2,'customer','$2a$10$cf14sE1XtR5kpst301HIk.DacAAVETBk.F5romIi/K46fyQqPrgMy','Chien','customer@mail.com','01234567111','2021-12-21',0,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1629294770/sample.jpg','Tran Van'),(3,'shipper','$2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO','An','shipper@mail.com','01234567','2021-12-21',1,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1629294770/sample.jpg','Le Van'),(7,'customer2','$2a$10$frwXswryzgKiCxRcy2tYwuFE74qe0qKyy..ppGtcheMm7K4wEmxsW','Tuan','tan@mail.com','0706638940','2021-12-20',1,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1639985372/g2xfmsp10a2txawb0dyd.jpg','Nguyen Van'),(8,'shipper2','$2a$10$GeGwC3lijS90qTeyKdiAwOGRnhfeYG5wGmewMVPMUcRoEg4BgiGMW','Thuong','shipedited@mail.com','0706638941','2021-12-20',1,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1639986150/hhzr0061dxhnnpa6sijv.jpg','Do Van'),(9,'shipper3','$2a$10$a0sqPGxUQ3ZNjNAtVPSOZ.ONbP9M2taWYMQGsNODuIRZoXSt8bWlW','Dao','test@mail.com','0706638940','2021-12-20',0,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1639987020/ym8ccwbxngbqyhlhwhoa.jpg','Ly Van'),(10,'customer3','$2a$10$cf14sE1XtR5kpst301HIk.DacAAVETBk.F5romIi/K46fyQqPrgMy','Sy','181050127tan@ou.edu.vn','0706638940','2021-12-20',1,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1640001020/hvne4lq3bz3nufnsexp3.jpg','Ngo Van'),(11,'customer4','$2a$10$JrgCJwmrXDg7B2w8PX4aKuoK6ALZ3Ga5ohmJh/uG3rYT6jDznIose','Quoc','181050127tan@ou.edu.vn','0706638940','2021-12-21',1,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1640059389/swto0zmob2me10yo79ei.png','Dinh Van'),(14,'shipper4','$2a$10$J3GN9T6hAcmPKCf9oGCGx.ZneosClqIeJneME5yb9jdZYv3z/yp1a','Tai','181050127tan@ou.edu.com','0706638940','2021-12-28',1,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1640662401/hu8ip6fgrtpqg7simswm.png','Huynh Van'),(15,'customerx','$2a$10$KVJg0MORTAQe.3Hy5xVa..XS6mqu3REDMdOz5qWVaB8Jv0TLxfT/C','Tri','customerxxx@mail.com','0706638940','2021-12-28',0,'ROLE_CUSTOMER','https://res.cloudinary.com/open-edu/image/upload/v1640663212/px8spvf0fdbn3mg1koac.jpg','Ngo Van'),(16,'shipperx','$2a$10$97Z7DUGtGTaGQDMNhMDlgu3LSX43SZXyGKQcLgnz.3/2c51s9oY4e','Han','shipx@mail.com','0706638940','2021-12-28',1,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1640663429/lgmjhumf1ab9s5lfaceu.png','Ly Gia'),(17,'shipper5','$2a$10$qETDZPnOuA6LOBg7ucbKLuzzMShDy6OmK0dIXZq5c8AnEu54Q1Tq6','Ky','181050126tan@ou.edu.vn','0706638940','2021-12-28',1,'ROLE_SHIPPER','https://res.cloudinary.com/open-edu/image/upload/v1640666659/q092heye6x2b47tojcv7.png','Ly Nha');
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

-- Dump completed on 2021-12-28 12:56:46
