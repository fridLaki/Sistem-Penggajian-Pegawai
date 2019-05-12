/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.6.16 : Database - penggajianmy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`penggajianmy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `penggajianmy`;

/*Table structure for table `pokokhonor` */

DROP TABLE IF EXISTS `pokokhonor`;

CREATE TABLE `pokokhonor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlah` varchar(255) DEFAULT NULL,
  `pendidikan` varchar(255) DEFAULT NULL,
  `statusKepegawaian` varchar(255) DEFAULT NULL,
  `subStatusKepegawaian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

/*Data for the table `pokokhonor` */

insert  into `pokokhonor`(`id`,`jumlah`,`pendidikan`,`statusKepegawaian`,`subStatusKepegawaian`) values (1,'550000','D1/SMA/Sederajad','Honor Lepas (HL)','Guru Kelas'),(2,'600000','D2','Honor Lepas (HL)','Guru Kelas'),(3,'650000','D3','Honor Lepas (HL)','Guru Kelas'),(4,'700000','S1','Honor Lepas (HL)','Guru Kelas'),(5,'500000','D1/SMA/Sederajad','Honor Lepas (HL)','Tata Usaha'),(6,'500000','D1/SMA/Sederajad','Honor Lepas (HL)','Tenaga Perpustakaan'),(7,'450000','D1/SMA/Sederajad','Honor Lepas (HL)','Satpam'),(8,'400000','D1/SMA/Sederajad','Honor Lepas (HL)','Pegawai Kebersihan'),(9,'800000','D1/SMA/Sederajad','Honor Masa Percobaan (HMP)','Guru Kelas'),(10,'800000','D2','Honor Masa Percobaan (HMP)','Guru Kelas'),(11,'850000','D3','Honor Masa Percobaan (HMP)','Guru Kelas'),(12,'900000','S1','Honor Masa Percobaan (HMP)','Guru Kelas'),(13,'950000','S1 + Akta','Honor Masa Percobaan (HMP)','Guru Kelas'),(14,'800000','D1/SMA/Sederajad','Honor Masa Percobaan (HMP)','Guru Mata Pelajaran'),(15,'800000','D2','Honor Masa Percobaan (HMP)','Guru Mata Pelajaran'),(16,'850000','D3','Honor Masa Percobaan (HMP)','Guru Mata Pelajaran'),(17,'900000','S1','Honor Masa Percobaan (HMP)','Guru Mata Pelajaran'),(18,'950000','S1 + Akta','Honor Masa Percobaan (HMP)','Guru Mata Pelajaran'),(19,'800000','D1/SMA/Sederajad','Honor Masa Percobaan (HMP)','Tata Usaha'),(20,'800000','D1/SMA/Sederajad','Honor Masa Percobaan (HMP)','Tenaga Perpustakaan'),(21,'700000','D1/SMA/Sederajad','Honor Masa Percobaan (HMP)','Satpam'),(22,'700000','D1/SMA/Sederajad','Honor Masa Percobaan (HMP)','Pegawai Kebersihan'),(23,'800000','D1/SMA/Sederajad','Honor Sementara (HS)','Guru Kelas'),(24,'800000','D2','Honor Sementara (HS)','Guru Kelas'),(25,'850000','D3','Honor Sementara (HS)','Guru Kelas'),(26,'900000','S1','Honor Sementara (HS)','Guru Kelas'),(27,'950000','S1 + Akta','Honor Sementara (HS)','Guru Kelas'),(28,'800000','D1/SMA/Sederajad','Honor Sementara (HS)','Guru Mata Pelajaran'),(29,'800000','D2','Honor Sementara (HS)','Guru Mata Pelajaran'),(30,'850000','D3','Honor Sementara (HS)','Guru Mata Pelajaran'),(31,'900000','S1','Honor Sementara (HS)','Guru Mata Pelajaran'),(32,'950000','S1 + Akta','Honor Sementara (HS)','Guru Mata Pelajaran'),(33,'800000','D1/SMA/Sederajad','Honor Sementara (HS)','Tata Usaha'),(34,'800000','D1/SMA/Sederajad','Honor Sementara (HS)','Tenaga Perpustakaan'),(35,'700000','D1/SMA/Sederajad','Honor Sementara (HS)','Satpam'),(36,'700000','D1/SMA/Sederajad','Honor Sementara (HS)','Pegawai Kebersihan'),(37,'950000','S1 + Akta','Honor Masa Percobaan (HMP)','Staf'),(38,'950000','S1 + Akta','Honor Sementara (HS)','Staf'),(39,'1500000','S1 + Akta','Honor Lepas (HL)','Staf'),(40,'1000000','D1/SMA/Sederajad','Honor Lepas (HL)','Staf'),(41,'1000000','S2','Honor Lepas (HL)','Staf'),(42,'750000','D1/SMA/Sederajad','Honor Lepas (HL)','Staf'),(43,'700000','D1/SMA/Sederajad','Honor Lepas (HL)','Pegawai Kebersihan');

/*Table structure for table `tabelgapokcapegpegawai` */

DROP TABLE IF EXISTS `tabelgapokcapegpegawai`;

CREATE TABLE `tabelgapokcapegpegawai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `golongan` varchar(255) DEFAULT NULL,
  `jumlah` varchar(255) DEFAULT NULL,
  `masaKerjaGolongan` varchar(255) DEFAULT NULL,
  `subGolongan` varchar(255) DEFAULT NULL,
  `statusKepegawaian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=277 DEFAULT CHARSET=latin1;

/*Data for the table `tabelgapokcapegpegawai` */

insert  into `tabelgapokcapegpegawai`(`id`,`golongan`,`jumlah`,`masaKerjaGolongan`,`subGolongan`,`statusKepegawaian`) values (1,'I','780900','0 - 1','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(2,'I','800200','2 - 3','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(3,'I','844200','3 - 4','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(4,'I','879900','3 - 4','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(5,'I','917100','3 - 4','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(6,'I','819800','4 - 5','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(7,'I','865000','5 - 6','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(8,'I','901500','5 - 6','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(9,'I','939700','5 - 6','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(10,'I','839900','6 - 7','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(11,'I','886100','7 - 8','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(12,'I','923700','7 - 8','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(13,'I','962700','7 - 8','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(14,'I','860500','8 - 9','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(15,'I','907900','9 - 10','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(16,'I','946400','9 - 10','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(17,'I','986400','9 - 10','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(18,'I','881600','10 - 11','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(19,'I','930200','11 - 12','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(20,'I','969600','11 - 12','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(21,'I','1010600','11 - 12','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(22,'I','903300','12 - 13','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(23,'I','953000','13 - 14','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(24,'I','993400','13 - 14','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(25,'I','1035400','13 - 14','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(26,'I','925000','14 - 15','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(27,'I','976500','15 - 16','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(28,'I','1017800','15 - 16','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(29,'I','1060800','15 - 16','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(30,'I','948200','16 - 17','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(31,'I','1000400','17 - 18','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(32,'I','1042800','17 - 18','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(33,'I','1086900','17 - 18','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(34,'I','971400','18 - 19','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(35,'I','1025000','19 - 20','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(36,'I','1068300','19 - 20','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(37,'I','1113500','19 - 20','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(38,'I','995300','20 - 21','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(39,'I','1050100','21 - 22','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(40,'I','1094600','21 - 22','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(41,'I','1140800','21 - 22','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(42,'I','1019700','22 - 23','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(43,'I','1075900','23 - 24','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(44,'I','1121500','23 - 24','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(45,'I','1168900','23 - 24','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(46,'I','1044800','24 - 25','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(47,'I','1102300','25 - 26','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(48,'I','1149000','25 - 26','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(49,'I','1197500','25 - 26','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(50,'I','1070400','26 - 27','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(51,'I','1129400','27 - 28','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(52,'I','1177200','27 - 28','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(53,'I','1227000','27 - 28','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(54,'II','991400','0 - 1','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(55,'II','1003600','1 - 2','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(56,'II','1028200','3 - 4','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(57,'II','1071800','3 - 4','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(58,'II','1117000','3 - 4','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(59,'II','1164300','3 - 4','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(64,'II','1053500','5 - 6','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(65,'II','1098000','5 - 6','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(66,'II','1144500','5 - 6','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(67,'II','1192900','5 - 6','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(68,'II','1079300','7 - 8','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(69,'II','1125000','7 - 8','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(70,'II','1172600','7 - 8','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(71,'II','1222200','7 - 8','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(72,'II','1105900','9 - 10','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(73,'II','1152600','9 - 10','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(74,'II','1201400','9 - 10','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(75,'II','1252200','9 - 10','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(76,'II','1133000','11 - 12','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(77,'II','1180900','11 - 12','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(78,'II','1230900','11 - 12','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(79,'II','1282900','11 - 12','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(80,'II','1160800','13 - 14','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(81,'II','1209900','13 - 14','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(82,'II','1261100','13 - 14','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(83,'II','1314500','13 - 14','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(84,'II','1189300','15 - 16','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(85,'II','1239600','15 - 16','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(86,'II','1292100','15 - 16','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(87,'II','1346700','15 - 16','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(88,'II','1218500','17 - 18','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(89,'II','1270100','17 - 18','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(90,'II','1323800','17 - 18','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(91,'II','1379800','17 - 18','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(92,'II','1248400','19 - 20','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(93,'II','1301200','19 - 20','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(94,'II','1356300','19 - 20','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(95,'II','1413600','19 - 20','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(96,'II','1279100','21 - 22','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(97,'II','1333100','21 - 22','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(98,'II','1389500','21 - 22','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(99,'II','1448300','21 - 22','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(100,'II','1310500','23 - 24','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(101,'II','1365900','23 - 24','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(102,'II','1423600','23 - 24','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(103,'II','1483900','23 - 24','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(104,'II','1342600','25 - 26','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(105,'II','1399500','25 - 26','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(106,'II','1458600','25 - 26','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(107,'II','1520300','25 - 26','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(108,'II','1375600','27 - 28','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(109,'II','1433800','27 - 28','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(110,'II','1494400','27 - 28','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(111,'II','1557700','27 - 28','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(112,'II','1409400','29 - 30','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(113,'II','1469000','29 - 30','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(114,'II','1531100','29 - 30','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(115,'II','1595900','29 - 30','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(116,'II','1444000','31 - 32','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(117,'II','1505000','31 - 32','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(118,'II','1568700','31 - 32','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(119,'II','1635100','31 - 32','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(120,'II','1479400','33','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(121,'II','1542000','33','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(122,'II','1607200','33','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(123,'II','1675200','33','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(124,'III','1243300','0 - 1','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(125,'III','1296000','0 - 1','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(126,'III','1350800','0 - 1','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(127,'III','1407900','0 - 1','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(128,'III','1273900','2 - 3','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(129,'III','1327700','2 - 3','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(130,'III','1383900','2 - 3','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(131,'III','1442500','2 - 3','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(132,'III','1305100','4 - 5','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(133,'III','1360300','4 - 5','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(134,'III','1417900','4 - 5','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(135,'III','1477900','4 - 5','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(136,'III','1337200','6 - 7','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(137,'III','1393700','6 - 7','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(138,'III','1452700','6 - 7','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(139,'III','1514200','6 - 7','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(140,'III','1370000','8 - 9','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(141,'III','1428000','8 - 9','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(142,'III','1488400','8 - 9','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(143,'III','1551400','8 - 9','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(144,'III','1403700','10 - 11','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(145,'III','1463100','10 - 11','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(146,'III','1524900','10 - 11','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(147,'III','1589400','10 - 11','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(148,'III','1438100','12 - 13','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(149,'III','1498900','12 - 13','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(150,'III','1562300','12 - 13','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(151,'III','1628500','12 - 13','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(152,'III','1473400','14 - 15','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(153,'III','1535700','14 - 15','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(154,'III','1600700','14 - 15','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(155,'III','1668400','14 - 15','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(156,'III','1509600','16 - 17','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(157,'III','1573400','16 - 17','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(158,'III','1640000','16 - 17','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(159,'III','1709300','16 - 17','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(160,'III','1546600','18 - 19','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(161,'III','1612100','18 - 19','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(162,'III','1680300','18 - 19','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(163,'III','1751300','18 - 19','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(164,'III','1584600','20 - 21','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(165,'III','1651700','20 - 21','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(166,'III','1721500','20 - 21','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(167,'III','1794400','20 - 21','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(168,'III','1623500','22 - 23','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(169,'III','1692200','22 - 23','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(170,'III','1763800','22 - 23','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(171,'III','1838400','22 - 23','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(172,'III','1663400','24 - 25','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(173,'III','1733800','24 - 25','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(174,'III','1807000','24 - 25','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(175,'III','1883500','24 - 25','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(176,'III','1704200','26 - 27','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(177,'III','1776300','26 - 27','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(178,'III','1851400','26 - 27','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(179,'III','1929700','26 - 27','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(180,'III','1746100','28 - 29','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(181,'III','1819900','28 - 29','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(182,'III','1896900','28 - 29','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(183,'III','1977100','28 - 29','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(184,'III','1788900','30 - 31','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(185,'III','1864600','30 - 31','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(186,'III','1943500','30 - 31','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(187,'III','2025600','30 - 31','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(188,'III','1832800','32 - 33','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(189,'III','1910400','32 - 33','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(190,'III','1991200','32 - 33','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(191,'III','2075400','32 - 33','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(192,'IV','1467500','0 - 1','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(193,'IV','1529500','0 - 1','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(194,'IV','1594200','0 - 1','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(195,'IV','1661700','0 - 1','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(196,'IV','1732000','0 - 1','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(197,'IV','1503500','2 - 3','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(198,'IV','1567100','2 - 3','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(199,'IV','1633400','2 - 3','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(200,'IV','1702400','2 - 3','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(201,'IV','1774500','2 - 3','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(202,'IV','1540400','4 - 5','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(203,'IV','1605600','4 - 5','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(204,'IV','1673500','4 - 5','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(205,'IV','1744300','4 - 5','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(206,'IV','1818100','4 - 5','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(207,'IV','1578200','6 - 7','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(208,'IV','1645000','6 - 7','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(209,'IV','1714500','6 - 7','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(210,'IV','1787100','6 - 7','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(211,'IV','1862700','6 - 7','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(212,'IV','1617000','8 - 9','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(213,'IV','1685400','8 - 9','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(214,'IV','1756700','8 - 9','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(215,'IV','1830900','8 - 9','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(216,'IV','1908400','8 - 9','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(217,'IV','1656600','10 - 11','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(218,'IV','1726700','10 - 11','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(219,'IV','1799800','10 - 11','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(220,'IV','1875900','10 - 11','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(221,'IV','1955300','10 - 11','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(222,'IV','1697300','12 - 13','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(223,'IV','1769100','12 - 13','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(224,'IV','1844000','12 - 13','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(225,'IV','1921900','12 - 13','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(226,'IV','2003300','12 - 13','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(227,'IV','1739000','14 - 15','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(228,'IV','1812500','14 - 15','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(229,'IV','1889200','14 - 15','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(230,'IV','1969200','14 - 15','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(231,'IV','2052400','14 - 15','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(232,'IV','1781700','16 - 17','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(233,'IV','1857100','16 - 17','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(234,'IV','1935600','16 - 17','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(235,'IV','2017400','16 - 17','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(236,'IV','2102800','16 - 17','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(237,'IV','1825400','18 - 19','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(238,'IV','1902600','18 - 19','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(239,'IV','1983100','18 - 19','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(240,'IV','2067000','18 - 19','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(241,'IV','2154400','18 - 19','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(242,'IV','1870300','20 - 21','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(243,'IV','1949300','20 - 21','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(244,'IV','2031800','20 - 21','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(245,'IV','2117800','20 - 21','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(246,'IV','2207300','20 - 21','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(247,'IV','1916100','22 - 23','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(248,'IV','1997200','22 - 23','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(249,'IV','2081600','22 - 23','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(250,'IV','2169700','22 - 23','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(251,'IV','2261500','22 - 23','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(252,'IV','1963200','24 - 25','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(253,'IV','2046200','24 - 25','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(254,'IV','2132800','24 - 25','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(255,'IV','2223000','24 - 25','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(256,'IV','2317100','24 - 25','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(257,'IV','2011400','26 - 27','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(258,'IV','2096400','26 - 27','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(259,'IV','2185100','26 - 27','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(260,'IV','2277600','26 - 27','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(261,'IV','2373900','26 - 27','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(262,'IV','2060800','28 - 29','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(263,'IV','2147900','28 - 29','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(264,'IV','2238800','28 - 29','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(265,'IV','2333500','28 - 29','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(266,'IV','2432200','28 - 29','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(267,'IV','2111400','30 - 31','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(268,'IV','2200700','30 - 31','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(269,'IV','2293800','30 - 31','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(270,'IV','2390800','30 - 31','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(271,'IV','2491900','30 - 31','e','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(272,'IV','2163200','32 - 33','a','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(273,'IV','2254700','32 - 33','b','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(274,'IV','2350000','32 - 33','c','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(275,'IV','2449400','32 - 33','d','Calon Pegawai (CP)/Pegawai Tetap (PT)'),(276,'IV','2523100','32 - 33','e','Calon Pegawai (CP)/Pegawai Tetap (PT)');

/*Table structure for table `tabeltunjanganjabatan` */

DROP TABLE IF EXISTS `tabeltunjanganjabatan`;

CREATE TABLE `tabeltunjanganjabatan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `golongan` varchar(255) DEFAULT NULL,
  `jumlahRombengan` varchar(255) DEFAULT NULL,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `jabatan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK101C221DD180B02B` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=latin1;

/*Data for the table `tabeltunjanganjabatan` */

insert  into `tabeltunjanganjabatan`(`id`,`golongan`,`jumlahRombengan`,`jumlahTunjangan`,`jabatan`) values (2,'II','2 - 6','245000','Kepala TK'),(3,'II','7 - 10','305000','Kepala TK'),(4,'II','11 - 14','365000','Kepala TK'),(5,'II','15 - 18','425000','Kepala TK'),(6,'II','19 - 22','485000','Kepala TK'),(122,'II','23 - Lebih','545000','Kepala TK'),(123,'III','2 - 6','265000','Kepala TK'),(124,'III','7 - 10','325000','Kepala TK'),(125,'III','11 - 14','390000','Kepala TK'),(126,'III','15 - 18','450000','Kepala TK'),(127,'III','19 - 22','510000','Kepala TK'),(128,'III','23 - Lebih','570000','Kepala TK'),(129,'IV','2 - 6','305000','Kepala TK'),(130,'IV','7 - 10','365000','Kepala TK'),(131,'IV','11 - 14','425000','Kepala TK'),(132,'IV','15 - 18','485000','Kepala TK'),(133,'IV','19 - 22','545000','Kepala TK'),(134,'IV','23 - Lebih','605000','Kepala TK'),(135,'II','2 - 6','245000','Kepala SD'),(136,'II','7 - 10','305000','Kepala SD'),(137,'II','11 - 14','365000','Kepala SD'),(138,'II','15 - 18','425000','Kepala SD'),(139,'II','19 - 22','845000','Kepala SD'),(140,'II','23 - Lebih','545000','Kepala SD'),(141,'III','2 - 6','265000','Kepala SD'),(142,'III','7 - 10','325000','Kepala SD'),(143,'III','11 - 14','390000','Kepala SD'),(144,'III','15 - 18','450000','Kepala SD'),(145,'III','19 - 22','510000','Kepala SD'),(146,'III','23 - Lebih','570000','Kepala SD'),(147,'IV','2 - 6','305000','Kepala SD'),(148,'IV','7 - 10','365000','Kepala SD'),(149,'IV','11 - 14','425000','Kepala SD'),(150,'IV','15 - 18','485000','Kepala SD'),(151,'IV','19 - 22','545000','Kepala SD'),(152,'IV','23 - Lebih','605000','Kepala SD'),(153,'II','2 - 6','260000','Kepala SMP'),(154,'II','7 - 10','320000','Kepala SMP'),(155,'II','11 - 14','380000','Kepala SMP'),(156,'II','15 - 18','440000','Kepala SMP'),(157,'II','19 - 22','505000','Kepala SMP'),(158,'II','23 - Lebih','565000','Kepala SMP'),(159,'III','2 - 6','285000','Kepala SMP'),(160,'III','7 - 10','345000','Kepala SMP'),(161,'III','11 - 14','405000','Kepala SMP'),(162,'III','15 - 18','465000','Kepala SMP'),(163,'III','19 - 22','525000','Kepala SMP'),(164,'III','23 - Lebih','590000','Kepala SMP'),(165,'IV','2 - 6','320000','Kepala SMP'),(166,'IV','7 - 10','380000','Kepala SMP'),(167,'IV','11 - 14','440000','Kepala SMP'),(168,'IV','15 - 18','505000','Kepala SMP'),(169,'IV','19 - 22','565000','Kepala SMP'),(170,'IV','23 - Lebih','625000','Kepala SMP'),(171,'III','2 - 6','315000','Kepala SMA/K'),(172,'III','7 - 10','375000','Kepala SMA/K'),(173,'III','11 - 14','435000','Kepala SMA/K'),(174,'III','15 - 18','495000','Kepala SMA/K'),(175,'III','19 - 22','555000','Kepala SMA/K'),(176,'III','23 - Lebih','620000','Kepala SMA/K'),(177,'IV','2 - 6','350000','Kepala SMA/K'),(178,'IV','7 - 10','410000','Kepala SMA/K'),(179,'IV','11 - 14','470000','Kepala SMA/K'),(180,'IV','15 - 18','495000','Kepala SMA/K'),(181,'IV','19 - 22','595000','Kepala SMA/K'),(182,'IV','23 - Lebih','655000','Kepala SMA/K');

/*Table structure for table `tunjanganekstraor` */

DROP TABLE IF EXISTS `tunjanganekstraor`;

CREATE TABLE `tunjanganekstraor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganekstraor` */

/*Table structure for table `tunjanganekstrapasti` */

DROP TABLE IF EXISTS `tunjanganekstrapasti`;

CREATE TABLE `tunjanganekstrapasti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganekstrapasti` */

/*Table structure for table `tunjanganekstraprapmr` */

DROP TABLE IF EXISTS `tunjanganekstraprapmr`;

CREATE TABLE `tunjanganekstraprapmr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganekstraprapmr` */

/*Table structure for table `tunjanganekstraseni` */

DROP TABLE IF EXISTS `tunjanganekstraseni`;

CREATE TABLE `tunjanganekstraseni` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganekstraseni` */

/*Table structure for table `tunjanganekstrauks` */

DROP TABLE IF EXISTS `tunjanganekstrauks`;

CREATE TABLE `tunjanganekstrauks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganekstrauks` */

/*Table structure for table `tunjanganfungsional` */

DROP TABLE IF EXISTS `tunjanganfungsional`;

CREATE TABLE `tunjanganfungsional` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `golongan` varchar(255) DEFAULT NULL,
  `jabatan` varchar(255) DEFAULT NULL,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganfungsional` */

insert  into `tunjanganfungsional`(`id`,`golongan`,`jabatan`,`jumlahTunjangan`) values (1,'II','Guru','95000'),(2,'III','Guru','135000'),(3,'IV','Guru','170000'),(4,'II','Tata Usaha','95000'),(5,'II','Petugas Perpustakaan','95000'),(6,'III','Tata Usaha','100000'),(7,'III','Petugas Perpustakaan','100000'),(8,'I','Satpam','80000'),(9,'II','Satpam','85000'),(10,'III','Satpam','90000'),(11,'I','Pegawai Kebersihan','75000'),(12,'II','Pegawai Kebersihan','80000'),(13,'II','Staf','110000'),(14,'III','Staf','135000');

/*Table structure for table `tunjanganjammengajar` */

DROP TABLE IF EXISTS `tunjanganjammengajar`;

CREATE TABLE `tunjanganjammengajar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `statusKepegawaian` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  `jumlahRombonganBelajar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganjammengajar` */

insert  into `tunjanganjammengajar`(`id`,`jumlahTunjangan`,`statusKepegawaian`,`unitKerja`,`jumlahRombonganBelajar`) values (1,'10000','Honor Lepas (HL)','TK','-'),(2,'10000','Honor Lepas (HL)','SD','-'),(3,'15000','Honor Lepas (HL)','SMP','-'),(4,'20000','Honor Lepas (HL)','SMA','-'),(5,'20000','Honor Lepas (HL)','SMK','-'),(6,'6600','Honor Masa Percobaan (HMP)','TK','-'),(7,'6600','Honor Masa Percobaan (HMP)','SD','-'),(8,'8250','Honor Masa Percobaan (HMP)','SMP','-'),(9,'11000','Honor Masa Percobaan (HMP)','SMA','-'),(10,'11000','Honor Masa Percobaan (HMP)','SMK','-'),(11,'6600','Honor Sementara (HS)','TK','-'),(12,'6600','Honor Sementara (HS)','SD','-'),(13,'8250','Honor Masa Percobaan (HMP)','SMP','-'),(14,'11000','Honor Sementara (HS)','SMA','-'),(15,'11000','Honor Sementara (HS)','SMK','-'),(16,'6600','Calon Pegawai (CP)/Pegawai Tetap (PT)','TK','-'),(17,'6600','Calon Pegawai (CP)/Pegawai Tetap (PT)','SD','-'),(18,'8250','Calon Pegawai (CP)/Pegawai Tetap (PT)','SMP','-'),(19,'11000','Calon Pegawai (CP)/Pegawai Tetap (PT)','SMA','-'),(20,'11000','Calon Pegawai (CP)/Pegawai Tetap (PT)','SMK','-'),(21,'71500','Calon Pegawai (CP)/Pegawai Tetap (PT)','TK','1'),(22,'126500','Calon Pegawai (CP)/Pegawai Tetap (PT)','TK','2'),(23,'82000','Calon Pegawai (CP)/Pegawai Tetap (PT)','SD','1'),(24,'137500','Calon Pegawai (CP)/Pegawai Tetap (PT)','SD','2');

/*Table structure for table `tunjangankeluarga` */

DROP TABLE IF EXISTS `tunjangankeluarga`;

CREATE TABLE `tunjangankeluarga` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `anak` varchar(255) DEFAULT NULL,
  `istri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `tunjangankeluarga` */

insert  into `tunjangankeluarga`(`id`,`anak`,`istri`) values (7,'2','10');

/*Table structure for table `tunjangankhusus` */

DROP TABLE IF EXISTS `tunjangankhusus`;

CREATE TABLE `tunjangankhusus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `golongan` varchar(255) DEFAULT NULL,
  `jabatan` varchar(255) DEFAULT NULL,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjangankhusus` */

/*Table structure for table `tunjangankurikulerbp` */

DROP TABLE IF EXISTS `tunjangankurikulerbp`;

CREATE TABLE `tunjangankurikulerbp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjangankurikulerbp` */

/*Table structure for table `tunjangankurikulerkomputer` */

DROP TABLE IF EXISTS `tunjangankurikulerkomputer`;

CREATE TABLE `tunjangankurikulerkomputer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjangankurikulerkomputer` */

/*Table structure for table `tunjangankurikulerpembinaosis` */

DROP TABLE IF EXISTS `tunjangankurikulerpembinaosis`;

CREATE TABLE `tunjangankurikulerpembinaosis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjangankurikulerpembinaosis` */

/*Table structure for table `tunjangankurikulerpraktikum` */

DROP TABLE IF EXISTS `tunjangankurikulerpraktikum`;

CREATE TABLE `tunjangankurikulerpraktikum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjangankurikulerpraktikum` */

/*Table structure for table `tunjanganpangan` */

DROP TABLE IF EXISTS `tunjanganpangan`;

CREATE TABLE `tunjanganpangan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganpangan` */

insert  into `tunjanganpangan`(`id`,`jumlahTunjangan`) values (1,'25000'),(2,'25000'),(3,'25000'),(4,'25000'),(5,'25000'),(6,'25000'),(7,'25000');

/*Table structure for table `tunjanganstaffkurikulumekstrakurikuluer` */

DROP TABLE IF EXISTS `tunjanganstaffkurikulumekstrakurikuluer`;

CREATE TABLE `tunjanganstaffkurikulumekstrakurikuluer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jenisTunjangan` varchar(255) DEFAULT NULL,
  `jumlahJam` varchar(255) DEFAULT NULL,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganstaffkurikulumekstrakurikuluer` */

insert  into `tunjanganstaffkurikulumekstrakurikuluer`(`id`,`jenisTunjangan`,`jumlahJam`,`jumlahTunjangan`,`unitKerja`) values (1,'Tunjangan Staf Kasi Kurikulum','6','8250','SMP'),(2,'Tunjangan Staf Kasi Kurikulum','6','11000','SMA'),(3,'Tunjangan Staf Kasi Kurikulum','6','11000','SMK'),(4,'Tunjangan Staf Kasi Kesiswaan','6','8250','SMP'),(5,'Tunjangan Staf Kasi Kesiswaan','6','11000','SMA'),(6,'Tunjangan Staf Kasi Kesiswaan','6','11000','SMK'),(7,'Tunjangan Staf Kasi Humas','6','8250','SMP'),(8,'Tunjangan Staf Kasi Humas','6','11000','SMA'),(9,'Tunjangan Staf Kasi Humas','6','11000','SMK'),(10,'Tunjangan Staf Kasi Sarana/Prasarana','6','8250','SMP'),(11,'Tunjangan Staf Kasi Sarana/Prasarana','6','11000','SMA'),(12,'Tunjangan Staf Kasi Sarana/Prasarana','6','11000','SMK'),(13,'Tunjangan Staf Wali Kelas','3','8250','SMP'),(14,'Tunjangan Staf Wali Kelas','3','11000','SMA'),(15,'Tunjangan Staf Wali Kelas','3','11000','SMK'),(16,'Tunjangan Kurikuler Pembina OSIS','3','8250','SMP'),(17,'Tunjangan Kurikuler Pembina OSIS','3','11000','SMA'),(18,'Tunjangan Kurikuler Pembina OSIS','3','11000','SMK'),(19,'Tunjangan Kurikuler BP','3','8250','SMP'),(20,'Tunjangan Kurikuler BP','3','11000','SMA'),(21,'Tunjangan Kurikuler BP','3','11000','SMK'),(22,'Tunjangan Kurikulum Praktikum','4','0','-'),(23,'Tunjangan Ekstra OR','3','0','-'),(24,'Tunjangan Ekstra Seni','3','0','-'),(25,'Tunjangan Ekstra Pra/PMR','3','0','-'),(26,'Tunjangan UKS','3','0','-'),(27,'Tunjangan Pasti','3','0','-');

/*Table structure for table `tunjanganstafkasihumas` */

DROP TABLE IF EXISTS `tunjanganstafkasihumas`;

CREATE TABLE `tunjanganstafkasihumas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganstafkasihumas` */

/*Table structure for table `tunjanganstafkasikesiswaan` */

DROP TABLE IF EXISTS `tunjanganstafkasikesiswaan`;

CREATE TABLE `tunjanganstafkasikesiswaan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganstafkasikesiswaan` */

/*Table structure for table `tunjanganstafkasikurikulum` */

DROP TABLE IF EXISTS `tunjanganstafkasikurikulum`;

CREATE TABLE `tunjanganstafkasikurikulum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganstafkasikurikulum` */

/*Table structure for table `tunjanganstafkasisaranaprasarana` */

DROP TABLE IF EXISTS `tunjanganstafkasisaranaprasarana`;

CREATE TABLE `tunjanganstafkasisaranaprasarana` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlah` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganstafkasisaranaprasarana` */

/*Table structure for table `tunjanganstafkasiwalikelas` */

DROP TABLE IF EXISTS `tunjanganstafkasiwalikelas`;

CREATE TABLE `tunjanganstafkasiwalikelas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlahTunjangan` varchar(255) DEFAULT NULL,
  `unitKerja` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganstafkasiwalikelas` */

/*Table structure for table `tunjanganyayasan` */

DROP TABLE IF EXISTS `tunjanganyayasan`;

CREATE TABLE `tunjanganyayasan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `besarTunjangan` varchar(255) DEFAULT NULL,
  `golongan` varchar(255) DEFAULT NULL,
  `jabatan` varchar(255) DEFAULT NULL,
  `jenisTunjangan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

/*Data for the table `tunjanganyayasan` */

insert  into `tunjanganyayasan`(`id`,`besarTunjangan`,`golongan`,`jabatan`,`jenisTunjangan`) values (1,'110000','II','Staf','Fungsional'),(2,'275000','II','Staf','Khusus'),(3,'135000','III','Staf','Fungsional'),(4,'285000','III','Staf','Khusus'),(5,'110000','II','Kepala Bidang','Fungsional'),(6,'325000','II','Kepala Bidang','Khusus'),(7,'150000','II','Kepala Bidang','Jabatan'),(8,'80000','I','Satpam','Fungsional'),(9,'195000','I','Satpam','Khusus'),(10,'85000','II','Satpam','Fungsional'),(11,'205000','II','Satpam','Khusus'),(12,'90000','III','Satpam','Fungsional'),(13,'210000','III','Satpam','Khusus'),(14,'80000','I','Pegawai Kebersihan','Fungsional'),(15,'195000','I','Pegawai Kebersihan','Khusus'),(16,'85000','II','Pegawai Kebersihan','Khusus'),(17,'205000','III','Pegawai Kebersihan','Khusus');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
