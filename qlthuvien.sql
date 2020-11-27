-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: qlthuvien
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docgia` (
  `id` int NOT NULL,
  `name` varchar(200) NOT NULL,
  `gioitinh` varchar(45) NOT NULL,
  `ns` varchar(30) NOT NULL,
  `doituong` varchar(80) NOT NULL,
  `bophan` varchar(100) NOT NULL,
  `hanthe` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `diachi` varchar(100) NOT NULL,
  `sdt` int NOT NULL,
  `hanthe2` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES (1,'Nguyễn Hoàng Phúc','Nam','2000-10-08','Sinh viên','Công nghệ thông tin','2020-10-02','abc@gmail.com','321/2 Trần Hưng Đạo',908729721,'2021-10-03'),(2,'Nguyễn Thị Trang','Nữ','2000-10-02','Sinh viên','Công nghệ thông tin','2020-09-01','abc@gmail.com','321/54 Trần Hưng Đạo',987656898,'2021-03-03'),(3,'Nguyễn Văn An','Nam','1987-09-01','Giảng viên','Xây dựng','2020-10-04','xyz@gmail.com','532/57 Hai Bà Trưng',908327959,'2021-10-03');
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `muonsach`
--

DROP TABLE IF EXISTS `muonsach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muonsach` (
  `IdDocGia` int NOT NULL,
  `TenSach` varchar(100) NOT NULL,
  `NgayMuon` varchar(30) NOT NULL,
  PRIMARY KEY (`IdDocGia`,`TenSach`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muonsach`
--

LOCK TABLES `muonsach` WRITE;
/*!40000 ALTER TABLE `muonsach` DISABLE KEYS */;
/*!40000 ALTER TABLE `muonsach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sach` (
  `MaSach` int NOT NULL AUTO_INCREMENT,
  `TenSach` varchar(100) NOT NULL,
  `TacGia` varchar(100) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  `NamXuatBan` int NOT NULL,
  `NoiXuatBan` varchar(100) NOT NULL,
  `DanhMuc` varchar(100) NOT NULL,
  `NgayNhapSach` varchar(20) NOT NULL,
  `ViTriSach` varchar(150) NOT NULL,
  PRIMARY KEY (`MaSach`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES (1,'Tôi thấy hoa vàng trên cỏ xanh','Nguyễn Nhật Ánh','...',2009,'TP.HCM','tiểu thuyết','2020-01-01','khu A'),(2,'Lão Hạc','Nam Cao','...',1943,'Việt Nam','truyện ngắn','2020-02-01','khu B'),(3,'Thơ thơ','Xuân Diệu','...',1945,'Việt Nam','Thơ','2013-03-04','khu C'),(4,'Con chim xanh biếc bay về','Nguyễn Nhật Ánh','...',2020,'Việt Nam','tiểu thuyết','2020-03-03','Khu A'),(5,'Nhà giả kim','Paulo Coelho','...',2013,'Brazil','tiểu thuyết','2020-04-11','khu B'),(6,'Suối nguồn','Ayn Rand','...',2018,'Mỹ','tiểu thuyết','2014-12-02','khu C');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tacgia`
--

DROP TABLE IF EXISTS `tacgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tacgia` (
  `MaTacGia` int NOT NULL,
  `TenTacGia` varchar(45) NOT NULL,
  PRIMARY KEY (`MaTacGia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tacgia`
--

LOCK TABLES `tacgia` WRITE;
/*!40000 ALTER TABLE `tacgia` DISABLE KEYS */;
INSERT INTO `tacgia` VALUES (1,'Nguyễn Nhật Ánh'),(2,'Nam Cao'),(3,'Xuân Diệu'),(4,'Paulo Coelho'),(5,'Ayn Rand');
/*!40000 ALTER TABLE `tacgia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-27 22:11:40
