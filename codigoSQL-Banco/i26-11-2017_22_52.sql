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
  `conta_cpf` varchar(11) NOT NULL DEFAULT '---',
  PRIMARY KEY (`conta_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=365 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contas`
--

LOCK TABLES `t_contas` WRITE;
/*!40000 ALTER TABLE `t_contas` DISABLE KEYS */;
INSERT INTO `t_contas` VALUES (262,0,4,'ABERTO','25/11/2017','19:10:56','---'),(263,0,1,'ABERTO','25/11/2017','19:13:54','---'),(264,0,1,'ABERTO','25/11/2017','19:21:53','---'),(265,0,1,'ABERTO','25/11/2017','19:24:33','---'),(266,0,1,'ABERTO','25/11/2017','19:25:49','---'),(267,0,1,'ABERTO','25/11/2017','19:27:46','---'),(268,0,6,'ABERTO','25/11/2017','19:28:46','---'),(269,0,1,'ABERTO','25/11/2017','19:33:18','---'),(270,51.9,5,'FECHADO','25/11/2017','19:39:25','---'),(271,0,4,'FINALIZADO','25/11/2017','19:51:49','5431082361'),(272,0,19,'ABERTO','25/11/2017','20:01:16','---'),(273,0,1,'ABERTO','25/11/2017','20:08:20','---'),(274,0,1,'ABERTO','25/11/2017','20:10:28','---'),(275,0,4,'ABERTO','25/11/2017','20:11:41','---'),(276,0,1,'ABERTO','25/11/2017','20:14:30','---'),(277,0,1,'ABERTO','25/11/2017','20:17:02','---'),(278,0,1,'ABERTO','25/11/2017','20:18:38','---'),(279,0,1,'ABERTO','25/11/2017','20:27:00','---'),(280,0,1,'ABERTO','25/11/2017','20:29:42','---'),(281,0,1,'ABERTO','25/11/2017','21:01:29','---'),(282,0,1,'FECHADO','25/11/2017','21:04:34','---'),(283,96.6,1,'FINALIZADO','25/11/2017','21:19:45','5431082361'),(284,0,9,'ABERTO','25/11/2017','22:05:17','---'),(285,0,1,'ABERTO','25/11/2017','22:16:18','---'),(286,79.3,1,'ABERTO','25/11/2017','22:53:46','---'),(287,13.6,4,'ABERTO','25/11/2017','22:55:34','---'),(288,83.3,4,'ABERTO','25/11/2017','22:56:36','---'),(289,43.6,3,'ABERTO','25/11/2017','23:02:13','---'),(290,126.99999999999999,23,'ABERTO','25/11/2017','23:04:08','---'),(291,17.4,21,'ABERTO','26/11/2017','10:47:02','---'),(292,0,22,'ABERTO','26/11/2017','11:00:31','---'),(293,0,23,'ABERTO','26/11/2017','11:01:26','---'),(294,0,12,'ABERTO','26/11/2017','11:02:22','---'),(295,71.3,1,'FINALIZADO','26/11/2017','11:04:18','---'),(296,63.5,5,'ABERTO','26/11/2017','11:15:21','---'),(297,45.199999999999996,1,'ABERTO','26/11/2017','11:18:32','---'),(298,0,5,'ABERTO','26/11/2017','11:36:25','---'),(299,0,1,'ABERTO','26/11/2017','11:46:41','---'),(300,45.099999999999994,3,'FINALIZADO','26/11/2017','11:52:16','5431082361'),(301,0,5,'ABERTO','26/11/2017','12:24:00','---'),(302,0,1,'ABERTO','26/11/2017','16:27:30','---'),(303,0,9,'ABERTO','26/11/2017','18:00:05','---'),(304,11.8,4,'FECHADO','26/11/2017','18:01:54','---'),(305,0,1,'ABERTO','26/11/2017','18:28:05','---'),(306,0,1,'ABERTO','26/11/2017','18:30:10','---'),(307,0,5,'ABERTO','26/11/2017','18:31:05','---'),(308,0,1,'ABERTO','26/11/2017','18:35:39','---'),(309,51.3,2,'FECHADO','26/11/2017','18:36:19','---'),(310,54.3,22,'FECHADO','26/11/2017','18:41:34','---'),(311,10.9,1,'ABERTO','26/11/2017','18:43:09','---'),(312,0,10,'ABERTO','26/11/2017','18:47:07','---'),(313,0,1,'ABERTO','26/11/2017','18:53:03','---'),(314,0,1,'ABERTO','26/11/2017','19:03:32','---'),(315,0,1,'ABERTO','26/11/2017','19:06:53','---'),(316,0,3,'ABERTO','26/11/2017','19:18:45','---'),(317,0,3,'ABERTO','26/11/2017','19:22:59','---'),(318,0,1,'ABERTO','26/11/2017','19:29:01','---'),(319,0,3,'ABERTO','26/11/2017','19:29:47','---'),(320,50.8,5,'FECHADO','26/11/2017','19:34:44','---'),(321,39.599999999999994,2,'ABERTO','26/11/2017','20:31:20','---'),(322,50.3,1,'ABERTO','26/11/2017','20:35:40','---'),(323,38.8,4,'FECHADO','26/11/2017','20:45:36','---'),(324,0,3,'ABERTO','26/11/2017','20:48:00','---'),(325,30.9,3,'ABERTO','26/11/2017','20:51:03','---'),(326,46.9,1,'ABERTO','26/11/2017','20:51:45','---'),(327,0,1,'ABERTO','26/11/2017','21:01:10','---'),(328,0,1,'ABERTO','26/11/2017','21:01:26','---'),(329,0,1,'ABERTO','26/11/2017','21:02:02','---'),(330,0,1,'ABERTO','26/11/2017','21:02:18','---'),(331,0,3,'ABERTO','26/11/2017','21:11:58','---'),(332,0,1,'ABERTO','26/11/2017','21:12:30','---'),(333,0,1,'ABERTO','26/11/2017','21:13:41','---'),(334,37.3,1,'ABERTO','26/11/2017','21:14:29','---'),(335,0,1,'ABERTO','26/11/2017','21:15:37','---'),(336,0,3,'ABERTO','26/11/2017','21:21:38','---'),(337,0,4,'ABERTO','26/11/2017','21:21:57','---'),(338,76.8,3,'ABERTO','26/11/2017','21:22:34','---'),(339,255.2,1,'ABERTO','26/11/2017','21:24:33','---'),(340,0,1,'ABERTO','26/11/2017','21:27:35','---'),(341,194.3,3,'ABERTO','26/11/2017','21:27:53','---'),(342,207.4,1,'ABERTO','26/11/2017','21:29:31','---'),(343,207.4,1,'ABERTO','26/11/2017','21:30:42','---'),(344,218.20000000000002,1,'ABERTO','26/11/2017','21:31:32','---'),(345,313.9,5,'FECHADO','26/11/2017','21:33:06','5431082361'),(346,0,22,'ABERTO','26/11/2017','21:38:45','---'),(347,0,1,'ABERTO','26/11/2017','21:48:53','---'),(348,0,4,'ABERTO','26/11/2017','21:51:12','---'),(349,3.5,3,'FECHADO','26/11/2017','21:54:03','---'),(350,7.9,1,'FECHADO','26/11/2017','21:57:03','---'),(351,13.9,1,'FECHADO','26/11/2017','21:58:22','---'),(352,13.9,1,'ABERTO','26/11/2017','21:58:38','---'),(353,3.5,6,'FECHADO','26/11/2017','22:11:11','---'),(354,0,6,'ABERTO','26/11/2017','22:11:34','---'),(355,3.5,19,'FECHADO','26/11/2017','22:12:09','---'),(356,0,19,'ABERTO','26/11/2017','22:12:29','---'),(357,5.9,12,'FECHADO','26/11/2017','22:14:30','---'),(358,0,12,'ABERTO','26/11/2017','22:14:45','---'),(359,27.9,4,'FECHADO','26/11/2017','22:21:06','---'),(360,0,4,'ABERTO','26/11/2017','22:21:19','---'),(361,31.599999999999998,2,'FECHADO','26/11/2017','22:26:42','---'),(362,29.9,2,'FECHADO','26/11/2017','22:27:00','---'),(363,0,2,'ABERTO','26/11/2017','22:27:20','---'),(364,7.9,4,'FECHADO','26/11/2017','22:41:10','---');
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
INSERT INTO `t_itens` VALUES (1,'Água Mineral','(500ml)','BEBIDAS',3.5,1),(2,'Frango Grelhado','Porção para 2 pessoas. Acompanha 1 porção de arroz, feijão e salada.','REFEIÇÕES',23.9,1),(3,'X-Salada','Pão, hambúrguer, ovo, queijo, presunto, alface, tomate.','LANCHES',7.9,0),(4,'Pudim','(Fatia 300g)','SOBREMESAS',3.9,1),(5,'Mousse de Uva','Porção de 300g','SOBREMESAS',3.9,0),(6,'Feijoada','Porção para 2 pessoas. Acompanha 1 porção de arroz e salada.','REFEIÇÕES',29.9,1),(7,'Suco de Laranja','(Copo 300ml)','BEBIDAS',3.9,0),(8,'Coca-Cola','(2L)','BEBIDAS',7.9,1),(9,'Lasanha de Frango','Porção para 4 pessoas.','REFEIÇÕES',27.9,1),(10,'X-Picanha','Picanha filetada, pão de hambúrguer, queijo, cream cheese, alface e tomate','LANCHES',13.9,1),(11,'Mousse de Morango','Porção de 300g','SOBREMESAS',3.9,1),(12,'Peixe Assado','Porção para 2 pessoas. Acompanha 1 porção de arroz e salada.','REFEIÇÕES',42.9,1),(13,'Risoto de Camarão','Porção para 2 pessoas. Acompanha 1 porção salada.','REFEIÇÕES',49.9,0),(14,'Fanta Laranja','(600ml)','BEBIDAS',3.7,1),(15,'X-Tudo','Pão, hamb., ovo, queijo, presunto, calabresa, salsicha, bacon, alface e tomate.','LANCHES',14.9,0),(16,'Bolo de Chocolate','(Fatia 300g)','SOBREMESAS',3,1),(17,'Picanha','Porção para 2 pessoas. Acompanha 1 porção de arroz, feijão e salada.','REFEIÇÕES',39.9,1),(18,'Prato da Casa','Prato único acompanhado de arroz, feijão, filé, macarrão e salada.','REFEIÇÕES',21.9,1),(19,'X-Bacon','Pão, bacon, filé, abacaxi, 3 Fatias de queijo, alface, tomate','LANCHES',10.9,0),(20,'Suco de Laranja','(Jarra 600ml)','BEBIDAS',5.9,1);
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
INSERT INTO `t_pedido_itens` VALUES (8,3,2,'CONCLUIDO','25/11/2017','21:01:46'),(4,3,1,'CONCLUIDO','25/11/2017','21:01:46'),(6,3,1,'CONCLUIDO','25/11/2017','21:01:46'),(14,4,1,'CONCLUIDO','25/11/2017','21:04:48'),(5,4,2,'CONCLUIDO','25/11/2017','21:04:48'),(6,4,1,'CONCLUIDO','25/11/2017','21:04:48'),(17,4,1,'CONCLUIDO','25/11/2017','21:04:48'),(8,5,1,'ABERTO','25/11/2017','21:20:03'),(20,5,1,'ABERTO','25/11/2017','21:20:03'),(12,5,1,'ABERTO','25/11/2017','21:20:03'),(17,5,1,'ABERTO','25/11/2017','21:20:03'),(14,6,1,'ABERTO','25/11/2017','22:53:58'),(7,6,2,'ABERTO','25/11/2017','22:53:58'),(9,6,1,'ABERTO','25/11/2017','22:53:58'),(17,6,1,'ABERTO','25/11/2017','22:53:58'),(14,7,1,'ABERTO','25/11/2017','22:55:47'),(7,7,1,'ABERTO','25/11/2017','22:55:47'),(16,7,2,'ABERTO','25/11/2017','22:55:47'),(14,8,1,'ABERTO','25/11/2017','22:56:57'),(20,8,2,'ABERTO','25/11/2017','22:56:57'),(9,8,1,'ABERTO','25/11/2017','22:56:57'),(17,8,1,'ABERTO','25/11/2017','22:56:57'),(7,9,1,'ABERTO','25/11/2017','23:02:22'),(20,9,2,'ABERTO','25/11/2017','23:02:22'),(9,9,1,'ABERTO','25/11/2017','23:02:22'),(14,10,1,'ABERTO','25/11/2017','23:04:17'),(7,10,2,'ABERTO','25/11/2017','23:04:17'),(15,10,1,'ABERTO','25/11/2017','23:04:17'),(14,11,1,'ABERTO','25/11/2017','23:04:58'),(7,11,2,'ABERTO','25/11/2017','23:04:58'),(15,11,1,'ABERTO','25/11/2017','23:04:58'),(2,11,1,'ABERTO','25/11/2017','23:04:58'),(14,12,1,'ABERTO','25/11/2017','23:05:38'),(7,12,2,'ABERTO','25/11/2017','23:05:38'),(15,12,1,'ABERTO','25/11/2017','23:05:38'),(2,12,1,'ABERTO','25/11/2017','23:05:38'),(14,13,1,'ABERTO','26/11/2017','10:47:16'),(7,13,2,'ABERTO','26/11/2017','10:47:16'),(20,13,1,'ABERTO','26/11/2017','10:47:16'),(14,14,1,'ABERTO','26/11/2017','11:04:24'),(7,14,1,'ABERTO','26/11/2017','11:04:24'),(5,15,1,'ABERTO','26/11/2017','11:04:39'),(6,16,2,'ABERTO','26/11/2017','11:05:12'),(14,17,1,'ABERTO','26/11/2017','11:16:04'),(6,17,2,'ABERTO','26/11/2017','11:16:04'),(20,18,1,'ABERTO','26/11/2017','11:18:45'),(9,18,1,'ABERTO','26/11/2017','11:18:45'),(8,19,1,'ABERTO','26/11/2017','11:19:11'),(1,20,1,'ABERTO','26/11/2017','11:23:04'),(1,21,1,'ABERTO','26/11/2017','11:52:46'),(7,21,1,'ABERTO','26/11/2017','11:52:46'),(6,22,1,'ABERTO','26/11/2017','11:52:59'),(11,23,2,'ABERTO','26/11/2017','11:53:16'),(8,24,1,'ABERTO','26/11/2017','18:02:07'),(7,24,1,'ABERTO','26/11/2017','18:02:07'),(8,25,1,'ABERTO','26/11/2017','18:37:30'),(14,25,1,'ABERTO','26/11/2017','18:37:30'),(2,26,1,'ABERTO','26/11/2017','18:37:51'),(3,27,2,'ABERTO','26/11/2017','18:38:16'),(10,28,1,'ABERTO','26/11/2017','18:42:26'),(1,29,2,'ABERTO','26/11/2017','19:35:45'),(6,29,1,'ABERTO','26/11/2017','19:35:45'),(10,30,1,'ABERTO','26/11/2017','19:37:45'),(8,30,1,'ABERTO','26/11/2017','20:31:50'),(4,30,2,'ABERTO','26/11/2017','20:31:50'),(2,30,1,'ABERTO','26/11/2017','20:31:50'),(8,31,1,'ABERTO','26/11/2017','20:36:07'),(14,31,1,'ABERTO','26/11/2017','20:36:07'),(4,31,2,'ABERTO','26/11/2017','20:36:07'),(16,32,1,'ABERTO','26/11/2017','20:37:40'),(9,33,1,'ABERTO','26/11/2017','20:38:44'),(1,34,2,'ABERTO','26/11/2017','20:45:48'),(4,35,1,'ABERTO','26/11/2017','20:46:02'),(9,35,1,'ABERTO','26/11/2017','20:46:02'),(1,36,2,'ABERTO','26/11/2017','20:51:21'),(2,36,1,'ABERTO','26/11/2017','20:51:21'),(1,37,2,'ABERTO','26/11/2017','20:51:59'),(17,37,1,'ABERTO','26/11/2017','20:51:59'),(14,38,2,'ABERTO','26/11/2017','21:14:51'),(6,38,1,'ABERTO','26/11/2017','21:14:51'),(1,39,2,'ABERTO','26/11/2017','21:22:47'),(6,39,1,'ABERTO','26/11/2017','21:22:47'),(17,39,1,'ABERTO','26/11/2017','21:22:47'),(1,40,2,'ABERTO','26/11/2017','21:24:58'),(6,40,1,'ABERTO','26/11/2017','21:24:58'),(17,40,1,'ABERTO','26/11/2017','21:24:58'),(10,41,1,'ABERTO','26/11/2017','21:25:27'),(6,41,1,'ABERTO','26/11/2017','21:25:27'),(2,41,1,'ABERTO','26/11/2017','21:25:27'),(9,41,1,'ABERTO','26/11/2017','21:25:27'),(12,41,1,'ABERTO','26/11/2017','21:25:27'),(17,41,1,'ABERTO','26/11/2017','21:25:27'),(8,42,1,'ABERTO','26/11/2017','21:28:02'),(6,43,1,'ABERTO','26/11/2017','21:28:31'),(2,43,1,'ABERTO','26/11/2017','21:28:31'),(9,43,1,'ABERTO','26/11/2017','21:28:31'),(12,43,1,'ABERTO','26/11/2017','21:28:31'),(17,43,1,'ABERTO','26/11/2017','21:28:31'),(18,43,1,'ABERTO','26/11/2017','21:28:31'),(1,44,1,'ABERTO','26/11/2017','21:29:45'),(8,44,1,'ABERTO','26/11/2017','21:29:45'),(14,44,1,'ABERTO','26/11/2017','21:29:45'),(20,44,1,'ABERTO','26/11/2017','21:29:45'),(6,45,1,'ABERTO','26/11/2017','21:29:54'),(2,45,1,'ABERTO','26/11/2017','21:29:54'),(9,45,1,'ABERTO','26/11/2017','21:29:54'),(12,45,1,'ABERTO','26/11/2017','21:29:54'),(17,45,1,'ABERTO','26/11/2017','21:29:55'),(18,45,1,'ABERTO','26/11/2017','21:29:55'),(1,46,1,'ABERTO','26/11/2017','21:30:48'),(8,46,1,'ABERTO','26/11/2017','21:30:48'),(14,46,1,'ABERTO','26/11/2017','21:30:48'),(20,46,1,'ABERTO','26/11/2017','21:30:48'),(6,47,1,'ABERTO','26/11/2017','21:30:55'),(2,47,1,'ABERTO','26/11/2017','21:30:55'),(9,47,1,'ABERTO','26/11/2017','21:30:55'),(12,47,1,'ABERTO','26/11/2017','21:30:55'),(17,47,1,'ABERTO','26/11/2017','21:30:55'),(18,47,1,'ABERTO','26/11/2017','21:30:55'),(1,48,1,'ABERTO','26/11/2017','21:31:37'),(8,48,1,'ABERTO','26/11/2017','21:31:37'),(14,48,1,'ABERTO','26/11/2017','21:31:37'),(20,48,1,'ABERTO','26/11/2017','21:31:37'),(16,49,1,'ABERTO','26/11/2017','21:31:50'),(11,49,1,'ABERTO','26/11/2017','21:31:50'),(4,49,1,'ABERTO','26/11/2017','21:31:50'),(6,49,1,'ABERTO','26/11/2017','21:31:50'),(2,49,1,'ABERTO','26/11/2017','21:31:50'),(9,49,1,'ABERTO','26/11/2017','21:31:50'),(12,49,1,'ABERTO','26/11/2017','21:31:50'),(17,49,1,'ABERTO','26/11/2017','21:31:50'),(18,49,1,'ABERTO','26/11/2017','21:31:50'),(1,50,1,'ABERTO','26/11/2017','21:33:33'),(8,50,1,'ABERTO','26/11/2017','21:33:33'),(14,50,1,'ABERTO','26/11/2017','21:33:33'),(20,50,1,'ABERTO','26/11/2017','21:33:33'),(16,50,1,'ABERTO','26/11/2017','21:33:33'),(11,50,1,'ABERTO','26/11/2017','21:33:33'),(4,50,1,'ABERTO','26/11/2017','21:33:33'),(6,50,1,'ABERTO','26/11/2017','21:33:33'),(2,50,1,'ABERTO','26/11/2017','21:33:33'),(9,50,2,'ABERTO','26/11/2017','21:33:33'),(12,50,1,'ABERTO','26/11/2017','21:33:33'),(17,50,2,'ABERTO','26/11/2017','21:33:33'),(18,50,2,'ABERTO','26/11/2017','21:33:33'),(16,51,2,'ABERTO','26/11/2017','21:33:48'),(1,52,1,'ABERTO','26/11/2017','21:54:10'),(8,53,1,'ABERTO','26/11/2017','21:57:08'),(10,54,1,'ABERTO','26/11/2017','21:58:25'),(1,55,1,'ABERTO','26/11/2017','22:11:17'),(1,56,1,'ABERTO','26/11/2017','22:12:12'),(20,57,1,'ABERTO','26/11/2017','22:14:36'),(9,58,1,'ABERTO','26/11/2017','22:21:09'),(14,59,1,'ABERTO','26/11/2017','22:26:46'),(9,60,1,'ABERTO','26/11/2017','22:26:51'),(6,61,1,'ABERTO','26/11/2017','22:27:06'),(8,62,1,'ABERTO','26/11/2017','22:41:13');
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
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedidos`
--

LOCK TABLES `t_pedidos` WRITE;
/*!40000 ALTER TABLE `t_pedidos` DISABLE KEYS */;
INSERT INTO `t_pedidos` VALUES (3,49.6,1,'25/11/2017','21:01:46'),(4,81.3,1,'25/11/2017','21:04:48'),(5,96.6,1,'25/11/2017','21:20:03'),(6,79.3,1,'25/11/2017','22:53:58'),(7,13.6,4,'25/11/2017','22:55:47'),(8,83.3,4,'25/11/2017','22:56:57'),(9,43.6,3,'25/11/2017','23:02:22'),(10,26.4,23,'25/11/2017','23:04:17'),(11,50.3,23,'25/11/2017','23:04:58'),(12,50.3,23,'25/11/2017','23:05:38'),(13,17.4,21,'26/11/2017','10:47:16'),(14,7.6,1,'26/11/2017','11:04:24'),(15,3.9,1,'26/11/2017','11:04:39'),(16,59.8,1,'26/11/2017','11:05:12'),(17,63.5,5,'26/11/2017','11:16:04'),(18,33.8,1,'26/11/2017','11:18:45'),(19,7.9,1,'26/11/2017','11:19:11'),(20,3.5,1,'26/11/2017','11:23:04'),(21,7.4,3,'26/11/2017','11:52:46'),(22,29.9,3,'26/11/2017','11:52:59'),(23,7.8,3,'26/11/2017','11:53:16'),(24,11.8,4,'26/11/2017','18:02:07'),(25,11.600000000000001,2,'26/11/2017','18:37:30'),(26,23.9,2,'26/11/2017','18:37:51'),(27,15.8,2,'26/11/2017','18:38:16'),(28,10.9,22,'26/11/2017','18:42:26'),(29,36.9,5,'26/11/2017','19:35:45'),(30,13.9,5,'26/11/2017','19:37:45'),(31,19.400000000000002,1,'26/11/2017','20:36:07'),(32,3,1,'26/11/2017','20:37:40'),(33,27.9,1,'26/11/2017','20:38:44'),(34,7,4,'26/11/2017','20:45:48'),(35,31.799999999999997,4,'26/11/2017','20:46:02'),(36,30.9,3,'26/11/2017','20:51:21'),(37,46.9,1,'26/11/2017','20:51:59'),(38,37.3,1,'26/11/2017','21:14:51'),(39,76.8,3,'26/11/2017','21:22:47'),(40,76.8,1,'26/11/2017','21:24:58'),(41,178.4,1,'26/11/2017','21:25:27'),(42,7.9,3,'26/11/2017','21:28:02'),(43,186.4,3,'26/11/2017','21:28:31'),(44,21,1,'26/11/2017','21:29:45'),(45,186.4,1,'26/11/2017','21:29:54'),(46,21,1,'26/11/2017','21:30:48'),(47,186.4,1,'26/11/2017','21:30:55'),(48,21,1,'26/11/2017','21:31:37'),(49,197.20000000000002,1,'26/11/2017','21:31:50'),(50,307.9,5,'26/11/2017','21:33:33'),(51,6,5,'26/11/2017','21:33:48'),(52,3.5,3,'26/11/2017','21:54:10'),(53,7.9,1,'26/11/2017','21:57:08'),(54,13.9,1,'26/11/2017','21:58:25'),(55,3.5,6,'26/11/2017','22:11:17'),(56,3.5,19,'26/11/2017','22:12:12'),(57,5.9,12,'26/11/2017','22:14:36'),(58,27.9,4,'26/11/2017','22:21:09'),(59,3.7,2,'26/11/2017','22:26:46'),(60,27.9,2,'26/11/2017','22:26:51'),(61,29.9,2,'26/11/2017','22:27:06'),(62,7.9,4,'26/11/2017','22:41:13');
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
INSERT INTO `t_pedidos_contas` VALUES (4,282),(5,283),(6,286),(7,287),(8,288),(9,289),(10,290),(11,290),(12,290),(13,291),(14,295),(15,295),(16,295),(17,296),(18,297),(19,297),(20,297),(21,300),(22,300),(23,300),(24,304),(25,309),(26,309),(27,309),(28,310),(29,320),(30,320),(30,321),(31,322),(32,322),(33,322),(34,323),(35,323),(36,325),(37,326),(38,334),(39,338),(40,339),(41,339),(42,341),(43,341),(44,342),(45,342),(46,343),(47,343),(48,344),(49,344),(50,345),(51,345),(52,349),(53,350),(54,351),(55,353),(56,355),(57,357),(58,359),(59,361),(60,361),(61,362),(62,364);
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

-- Dump completed on 2017-11-26 22:52:36
