CREATE DATABASE  IF NOT EXISTS `bdsupreme2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdsupreme2`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bdsupreme2
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `t_itens`
--

DROP TABLE IF EXISTS `t_itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_itens` (
  `itm_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `itm_nome` varchar(20) NOT NULL,
  `itm_descricao` varchar(100) DEFAULT NULL,
  `itm_valor` double unsigned NOT NULL,
  PRIMARY KEY (`itm_codigo`),
  UNIQUE KEY `itm_codigo_UNIQUE` (`itm_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_itens`
--

LOCK TABLES `t_itens` WRITE;
/*!40000 ALTER TABLE `t_itens` DISABLE KEYS */;
INSERT INTO `t_itens` VALUES (1,'Item0','Descrição do Item 0',50),(2,'Item1','Descrição do Item 1',25),(3,'Item2','Descrição do Item 2',18),(4,'Item3','Descrição do Item 3',14),(5,'Item4','Descrição do Item 4',10),(6,'Item5','Descrição do Item 5',10),(7,'Item6','Descrição do Item 6',8),(8,'Item7','Descrição do Item 7',8),(9,'Item8','Descrição do Item 8',10),(10,'Item9','Descrição do Item 9',5),(11,'Item10','Descrição do Item 10',10),(12,'Item11','Descrição do Item 11',6),(13,'Item12','Descrição do Item 12',14),(14,'Item13','Descrição do Item 13',11),(15,'Item14','Descrição do Item 14',8),(16,'Item15','Descrição do Item 15',5),(17,'Item16','Descrição do Item 16',18),(18,'Item17','Descrição do Item 17',16),(19,'Item18','Descrição do Item 18',14),(20,'Item19','Descrição do Item 19',12);
/*!40000 ALTER TABLE `t_itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mesas`
--

DROP TABLE IF EXISTS `t_mesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_mesas` (
  `mesa_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`mesa_codigo`),
  UNIQUE KEY `mesa_codigo_UNIQUE` (`mesa_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mesas`
--

LOCK TABLES `t_mesas` WRITE;
/*!40000 ALTER TABLE `t_mesas` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_mesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pedido_itens`
--

DROP TABLE IF EXISTS `t_pedido_itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pedido_itens` (
  `cod_itens_pedido` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `itm_codigo` int(10) unsigned NOT NULL,
  `ped_codigo` int(10) unsigned NOT NULL,
  `item_status` varchar(20) NOT NULL DEFAULT 'PEDIDO REALIZADO',
  PRIMARY KEY (`cod_itens_pedido`),
  UNIQUE KEY `cod_itens_pedido_UNIQUE` (`cod_itens_pedido`),
  KEY `itm_codigo_idx` (`itm_codigo`),
  KEY `pedido_codigo_idx` (`ped_codigo`),
  CONSTRAINT `itm_codigo` FOREIGN KEY (`itm_codigo`) REFERENCES `t_itens` (`itm_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pedido_codigo` FOREIGN KEY (`ped_codigo`) REFERENCES `t_pedidos` (`ped_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedido_itens`
--

LOCK TABLES `t_pedido_itens` WRITE;
/*!40000 ALTER TABLE `t_pedido_itens` DISABLE KEYS */;
INSERT INTO `t_pedido_itens` VALUES (1,10,1,'PEDIDO REALIZADO'),(2,9,1,'PEDIDO REALIZADO'),(3,8,2,'PEDIDO REALIZADO'),(4,12,2,'PEDIDO REALIZADO'),(5,20,2,'PEDIDO REALIZADO'),(6,15,2,'PEDIDO REALIZADO'),(7,15,2,'PEDIDO REALIZADO'),(8,5,3,'PEDIDO REALIZADO'),(9,15,3,'PEDIDO REALIZADO'),(10,20,4,'PEDIDO REALIZADO'),(11,19,4,'PEDIDO REALIZADO'),(12,15,4,'PEDIDO REALIZADO'),(13,6,4,'PEDIDO REALIZADO');
/*!40000 ALTER TABLE `t_pedido_itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pedidos`
--

DROP TABLE IF EXISTS `t_pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pedidos` (
  `ped_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ped_valor` double NOT NULL,
  `mesa_codigo` int(10) unsigned NOT NULL,
  `ped_status` varchar(10) NOT NULL DEFAULT 'ABERTO',
  PRIMARY KEY (`ped_codigo`),
  UNIQUE KEY `ped_codigo_UNIQUE` (`ped_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedidos`
--

LOCK TABLES `t_pedidos` WRITE;
/*!40000 ALTER TABLE `t_pedidos` DISABLE KEYS */;
INSERT INTO `t_pedidos` VALUES (1,15,12,'ABERTO'),(2,42,18,'ABERTO'),(3,18,1,'ABERTO'),(4,44,20,'ABERTO');
/*!40000 ALTER TABLE `t_pedidos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-27 20:42:11
