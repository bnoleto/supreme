-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.1.10    Database: bdsupreme2
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `t_contas`
--

DROP TABLE IF EXISTS `t_contas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_contas` (
  `conta_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `conta_valor` double NOT NULL,
  `conta_mesa` int(10) NOT NULL,
  `conta_status` varchar(20) NOT NULL,
  `conta_data` varchar(10) NOT NULL,
  `conta_hora` varchar(8) NOT NULL,
  `conta_cpf` varchar(11) DEFAULT '---',
  PRIMARY KEY (`conta_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=302 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contas`
--

LOCK TABLES `t_contas` WRITE;
/*!40000 ALTER TABLE `t_contas` DISABLE KEYS */;
INSERT INTO `t_contas` VALUES (262,0,4,'ABERTO','25/11/2017','19:10:56','---'),(263,0,1,'ABERTO','25/11/2017','19:13:54','---'),(264,0,1,'ABERTO','25/11/2017','19:21:53','---'),(265,0,1,'ABERTO','25/11/2017','19:24:33','---'),(266,0,1,'ABERTO','25/11/2017','19:25:49','---'),(267,0,1,'ABERTO','25/11/2017','19:27:46','---'),(268,0,6,'ABERTO','25/11/2017','19:28:46','---'),(269,0,1,'ABERTO','25/11/2017','19:33:18','---'),(270,51.9,5,'FECHADO','25/11/2017','19:39:25','---'),(271,0,4,'FINALIZADO','25/11/2017','19:51:49','5431082361'),(272,0,19,'ABERTO','25/11/2017','20:01:16','---'),(273,0,1,'ABERTO','25/11/2017','20:08:20','---'),(274,0,1,'ABERTO','25/11/2017','20:10:28','---'),(275,0,4,'ABERTO','25/11/2017','20:11:41','---'),(276,0,1,'ABERTO','25/11/2017','20:14:30','---'),(277,0,1,'ABERTO','25/11/2017','20:17:02','---'),(278,0,1,'ABERTO','25/11/2017','20:18:38','---'),(279,0,1,'ABERTO','25/11/2017','20:27:00','---'),(280,0,1,'ABERTO','25/11/2017','20:29:42','---'),(281,0,1,'ABERTO','25/11/2017','21:01:29','---'),(282,0,1,'FECHADO','25/11/2017','21:04:34','---'),(283,96.6,1,'FINALIZADO','25/11/2017','21:19:45','5431082361'),(284,0,9,'ABERTO','25/11/2017','22:05:17','---'),(285,0,1,'ABERTO','25/11/2017','22:16:18','---'),(286,79.3,1,'ABERTO','25/11/2017','22:53:46','---'),(287,13.6,4,'ABERTO','25/11/2017','22:55:34','---'),(288,83.3,4,'ABERTO','25/11/2017','22:56:36','---'),(289,43.6,3,'ABERTO','25/11/2017','23:02:13','---'),(290,126.99999999999999,23,'ABERTO','25/11/2017','23:04:08','---'),(291,17.4,21,'ABERTO','26/11/2017','10:47:02','---'),(292,0,22,'ABERTO','26/11/2017','11:00:31','---'),(293,0,23,'ABERTO','26/11/2017','11:01:26','---'),(294,0,12,'ABERTO','26/11/2017','11:02:22','---'),(295,71.3,1,'FINALIZADO','26/11/2017','11:04:18','---'),(296,63.5,5,'ABERTO','26/11/2017','11:15:21','---'),(297,45.199999999999996,1,'ABERTO','26/11/2017','11:18:32','---'),(298,0,5,'ABERTO','26/11/2017','11:36:25','---'),(299,0,1,'ABERTO','26/11/2017','11:46:41','---'),(300,45.099999999999994,3,'FECHADO','26/11/2017','11:52:16','5431082361'),(301,0,5,'ABERTO','26/11/2017','12:24:00','---');
/*!40000 ALTER TABLE `t_contas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_itens`
--

DROP TABLE IF EXISTS `t_itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_itens` (
  `itm_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `itm_nome` varchar(100) NOT NULL,
  `itm_descricao` varchar(200) DEFAULT NULL,
  `itm_tipo` varchar(50) NOT NULL,
  `itm_valor` double unsigned NOT NULL,
  `itm_status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`itm_codigo`),
  UNIQUE KEY `itm_codigo_UNIQUE` (`itm_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_itens`
--

LOCK TABLES `t_itens` WRITE;
/*!40000 ALTER TABLE `t_itens` DISABLE KEYS */;
INSERT INTO `t_itens` VALUES (1,'Água Mineral 500ml','Descrição do Item 0','BEBIDAS',3.5,1),(2,'Frango Grelhado','Descrição do Item 1','REFEIÇÕES',23.9,1),(3,'X-Salada','Descrição do Item 2','LANCHES',7.9,0),(4,'Pudim (Fatia 300g)','Descrição do Item 3','SOBREMESAS',3.9,1),(5,'Mousse de Uva','Descrição do Item 4','SOBREMESAS',3.9,0),(6,'Feijoada','Descrição do Item 5','REFEIÇÕES',29.9,1),(7,'Suco de Laranja (Copo 300ml)','Descrição do Item 6','BEBIDAS',3.9,0),(8,'Coca-Cola 2L','Descrição do Item 7','BEBIDAS',7.9,1),(9,'Lasanha de Frango','Descrição do Item 8','REFEIÇÕES',27.9,1),(10,'X-Picanha','Descrição do Item 9','LANCHES',10.9,1),(11,'Mousse de Morango','Descrição do Item 10','SOBREMESAS',3.9,1),(12,'Peixe Assado','Descrição do Item 11','REFEIÇÕES',42.9,1),(13,'Risoto de Camarão','Descrição do Item 12','REFEIÇÕES',49.9,0),(14,'Fanta Laranja 600ml','Descrição do Item 13','BEBIDAS',3.7,1),(15,'X-Tudo','Descrição do Item 14','LANCHES',14.9,0),(16,'Bolo de Chocolate (Fatia 300g)','Descrição do Item 15','SOBREMESAS',3,1),(17,'Picanha','Descrição do Item 16','REFEIÇÕES',39.9,1),(18,'Prato da Casa','Descrição do Item 17','REFEIÇÕES',21.9,1),(19,'X-Bacon','Descrição do Item 18','LANCHES',10.9,0),(20,'Suco de Laranja (Jarra 600ml)','Descrição do Item 19','BEBIDAS',5.9,1);
/*!40000 ALTER TABLE `t_itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_mesas`
--

DROP TABLE IF EXISTS `t_mesas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_mesas` (
  `mesa_codigo` int(11) NOT NULL,
  `mesa_status` int(1) NOT NULL,
  PRIMARY KEY (`mesa_codigo`),
  UNIQUE KEY `mesa_codigo_UNIQUE` (`mesa_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_mesas`
--

LOCK TABLES `t_mesas` WRITE;
/*!40000 ALTER TABLE `t_mesas` DISABLE KEYS */;
INSERT INTO `t_mesas` VALUES (1,0),(2,0),(3,0),(4,0),(5,0),(6,0),(7,0),(8,0),(9,0),(10,0),(11,0),(12,0),(13,0),(14,0),(15,0),(16,0),(17,0),(18,0),(19,0),(20,0),(21,0),(22,0),(23,0),(24,0);
/*!40000 ALTER TABLE `t_mesas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pedido_itens`
--

DROP TABLE IF EXISTS `t_pedido_itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pedido_itens` (
  `itm_codigo` int(10) unsigned NOT NULL,
  `ped_codigo` int(10) unsigned NOT NULL,
  `itm_qtde` int(4) NOT NULL,
  `ped_status` varchar(20) NOT NULL DEFAULT 'ABERTO',
  `ped_data` varchar(10) NOT NULL,
  `ped_hora` varchar(8) NOT NULL,
  KEY `fk_t_pedido_itens_t_itens_idx` (`itm_codigo`),
  KEY `fk_t_pedido_itens_t_pedidos1_idx` (`ped_codigo`),
  CONSTRAINT `fk_t_pedido_itens_t_itens` FOREIGN KEY (`itm_codigo`) REFERENCES `t_itens` (`itm_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_pedido_itens_t_pedidos1` FOREIGN KEY (`ped_codigo`) REFERENCES `t_pedidos` (`ped_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedido_itens`
--

LOCK TABLES `t_pedido_itens` WRITE;
/*!40000 ALTER TABLE `t_pedido_itens` DISABLE KEYS */;
INSERT INTO `t_pedido_itens` VALUES (8,3,2,'CONCLUIDO','25/11/2017','21:01:46'),(4,3,1,'CONCLUIDO','25/11/2017','21:01:46'),(6,3,1,'CONCLUIDO','25/11/2017','21:01:46'),(14,4,1,'CONCLUIDO','25/11/2017','21:04:48'),(5,4,2,'CONCLUIDO','25/11/2017','21:04:48'),(6,4,1,'CONCLUIDO','25/11/2017','21:04:48'),(17,4,1,'CONCLUIDO','25/11/2017','21:04:48'),(8,5,1,'ABERTO','25/11/2017','21:20:03'),(20,5,1,'ABERTO','25/11/2017','21:20:03'),(12,5,1,'ABERTO','25/11/2017','21:20:03'),(17,5,1,'ABERTO','25/11/2017','21:20:03'),(14,6,1,'ABERTO','25/11/2017','22:53:58'),(7,6,2,'ABERTO','25/11/2017','22:53:58'),(9,6,1,'ABERTO','25/11/2017','22:53:58'),(17,6,1,'ABERTO','25/11/2017','22:53:58'),(14,7,1,'ABERTO','25/11/2017','22:55:47'),(7,7,1,'ABERTO','25/11/2017','22:55:47'),(16,7,2,'ABERTO','25/11/2017','22:55:47'),(14,8,1,'ABERTO','25/11/2017','22:56:57'),(20,8,2,'ABERTO','25/11/2017','22:56:57'),(9,8,1,'ABERTO','25/11/2017','22:56:57'),(17,8,1,'ABERTO','25/11/2017','22:56:57'),(7,9,1,'ABERTO','25/11/2017','23:02:22'),(20,9,2,'ABERTO','25/11/2017','23:02:22'),(9,9,1,'ABERTO','25/11/2017','23:02:22'),(14,10,1,'ABERTO','25/11/2017','23:04:17'),(7,10,2,'ABERTO','25/11/2017','23:04:17'),(15,10,1,'ABERTO','25/11/2017','23:04:17'),(14,11,1,'ABERTO','25/11/2017','23:04:58'),(7,11,2,'ABERTO','25/11/2017','23:04:58'),(15,11,1,'ABERTO','25/11/2017','23:04:58'),(2,11,1,'ABERTO','25/11/2017','23:04:58'),(14,12,1,'ABERTO','25/11/2017','23:05:38'),(7,12,2,'ABERTO','25/11/2017','23:05:38'),(15,12,1,'ABERTO','25/11/2017','23:05:38'),(2,12,1,'ABERTO','25/11/2017','23:05:38'),(14,13,1,'ABERTO','26/11/2017','10:47:16'),(7,13,2,'ABERTO','26/11/2017','10:47:16'),(20,13,1,'ABERTO','26/11/2017','10:47:16'),(14,14,1,'ABERTO','26/11/2017','11:04:24'),(7,14,1,'ABERTO','26/11/2017','11:04:24'),(5,15,1,'ABERTO','26/11/2017','11:04:39'),(6,16,2,'ABERTO','26/11/2017','11:05:12'),(14,17,1,'ABERTO','26/11/2017','11:16:04'),(6,17,2,'ABERTO','26/11/2017','11:16:04'),(20,18,1,'ABERTO','26/11/2017','11:18:45'),(9,18,1,'ABERTO','26/11/2017','11:18:45'),(8,19,1,'ABERTO','26/11/2017','11:19:11'),(1,20,1,'ABERTO','26/11/2017','11:23:04'),(1,21,1,'ABERTO','26/11/2017','11:52:46'),(7,21,1,'ABERTO','26/11/2017','11:52:46'),(6,22,1,'ABERTO','26/11/2017','11:52:59'),(11,23,2,'ABERTO','26/11/2017','11:53:16');
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
  `ped_mesa` int(11) NOT NULL,
  `ped_data` varchar(10) NOT NULL,
  `ped_hora` varchar(8) NOT NULL,
  PRIMARY KEY (`ped_codigo`),
  UNIQUE KEY `ped_codigo_UNIQUE` (`ped_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedidos`
--

LOCK TABLES `t_pedidos` WRITE;
/*!40000 ALTER TABLE `t_pedidos` DISABLE KEYS */;
INSERT INTO `t_pedidos` VALUES (3,49.6,1,'25/11/2017','21:01:46'),(4,81.3,1,'25/11/2017','21:04:48'),(5,96.6,1,'25/11/2017','21:20:03'),(6,79.3,1,'25/11/2017','22:53:58'),(7,13.6,4,'25/11/2017','22:55:47'),(8,83.3,4,'25/11/2017','22:56:57'),(9,43.6,3,'25/11/2017','23:02:22'),(10,26.4,23,'25/11/2017','23:04:17'),(11,50.3,23,'25/11/2017','23:04:58'),(12,50.3,23,'25/11/2017','23:05:38'),(13,17.4,21,'26/11/2017','10:47:16'),(14,7.6,1,'26/11/2017','11:04:24'),(15,3.9,1,'26/11/2017','11:04:39'),(16,59.8,1,'26/11/2017','11:05:12'),(17,63.5,5,'26/11/2017','11:16:04'),(18,33.8,1,'26/11/2017','11:18:45'),(19,7.9,1,'26/11/2017','11:19:11'),(20,3.5,1,'26/11/2017','11:23:04'),(21,7.4,3,'26/11/2017','11:52:46'),(22,29.9,3,'26/11/2017','11:52:59'),(23,7.8,3,'26/11/2017','11:53:16');
/*!40000 ALTER TABLE `t_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pedidos_contas`
--

DROP TABLE IF EXISTS `t_pedidos_contas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pedidos_contas` (
  `ped_codigo` int(10) unsigned NOT NULL,
  `conta_codigo` int(10) unsigned NOT NULL,
  KEY `fk_t_pedidos_contas_t_pedidos1_idx` (`ped_codigo`),
  KEY `fk_t_pedidos_contas_t_contas1_idx` (`conta_codigo`),
  CONSTRAINT `fk_t_pedidos_contas_t_contas1` FOREIGN KEY (`conta_codigo`) REFERENCES `t_contas` (`conta_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_pedidos_contas_t_pedidos1` FOREIGN KEY (`ped_codigo`) REFERENCES `t_pedidos` (`ped_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedidos_contas`
--

LOCK TABLES `t_pedidos_contas` WRITE;
/*!40000 ALTER TABLE `t_pedidos_contas` DISABLE KEYS */;
INSERT INTO `t_pedidos_contas` VALUES (4,282),(5,283),(6,286),(7,287),(8,288),(9,289),(10,290),(11,290),(12,290),(13,291),(14,295),(15,295),(16,295),(17,296),(18,297),(19,297),(20,297),(21,300),(22,300),(23,300);
/*!40000 ALTER TABLE `t_pedidos_contas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pessoas`
--

DROP TABLE IF EXISTS `t_pessoas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pessoas` (
  `pes_codigo` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pes_nome` varchar(100) NOT NULL,
  `pes_cpf` varchar(11) NOT NULL,
  `pes_login` varchar(100) NOT NULL,
  `pes_senha` varchar(100) NOT NULL,
  `pes_tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`pes_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pessoas`
--

LOCK TABLES `t_pessoas` WRITE;
/*!40000 ALTER TABLE `t_pessoas` DISABLE KEYS */;
INSERT INTO `t_pessoas` VALUES (1,'BRUNO','0','bnoleto','0','ADMIN'),(2,'COZINHEIRO','0','cozinha','0','COZINHA'),(3,'GERENTE','0','gerencia','0','CAIXA'),(4,'FUNCIONARIO','0','mesa','0','CLIENTE'),(5,'ADMIN','0','root','0','ADMIN');
/*!40000 ALTER TABLE `t_pessoas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26 13:40:41
