CREATE DATABASE  IF NOT EXISTS `bdsupreme2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdsupreme2`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 192.168.1.13    Database: bdsupreme2
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
  `conta_cpf` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`conta_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contas`
--

LOCK TABLES `t_contas` WRITE;
/*!40000 ALTER TABLE `t_contas` DISABLE KEYS */;
INSERT INTO `t_contas` VALUES (1,0,0,'ABERTO','21/11/2017','19:34:29',NULL),(2,0,0,'ABERTO','22/11/2017','23:27:15',NULL),(3,0,0,'ABERTO','22/11/2017','23:33:20',NULL),(4,0,0,'ABERTO','22/11/2017','23:33:59',NULL),(5,0,0,'ABERTO','22/11/2017','23:38:40',NULL),(6,0,0,'ABERTO','22/11/2017','23:39:54',NULL),(7,0,0,'ABERTO','22/11/2017','23:40:49',NULL),(8,0,0,'ABERTO','22/11/2017','23:42:29',NULL),(9,0,0,'ABERTO','23/11/2017','12:23:21',NULL),(10,0,0,'FECHADO','23/11/2017','12:31:52',NULL),(11,0,0,'FECHADO','23/11/2017','12:38:04',NULL),(12,0,0,'ABERTO','23/11/2017','13:27:12',NULL),(13,0,0,'ABERTO','23/11/2017','13:41:21',NULL),(14,0,0,'ABERTO','23/11/2017','13:51:40',NULL),(15,0,0,'ABERTO','23/11/2017','13:56:18',NULL),(16,0,0,'FECHADO','23/11/2017','14:03:53',NULL),(17,0,0,'ABERTO','23/11/2017','14:05:00',NULL),(18,0,0,'ABERTO','23/11/2017','14:07:03',NULL),(19,0,0,'ABERTO','23/11/2017','14:11:04',NULL),(20,0,0,'ABERTO','23/11/2017','14:12:09',NULL),(21,0,0,'ABERTO','23/11/2017','14:16:16',NULL),(22,0,0,'ABERTO','23/11/2017','14:19:13',NULL),(23,0,0,'ABERTO','23/11/2017','14:27:13',NULL),(24,0,0,'ABERTO','23/11/2017','14:29:12',NULL),(25,0,0,'ABERTO','23/11/2017','15:00:46',NULL),(26,0,0,'ABERTO','23/11/2017','15:23:17',NULL),(27,0,0,'ABERTO','23/11/2017','15:24:29',NULL),(28,0,0,'ABERTO','23/11/2017','15:26:30',NULL),(29,0,0,'ABERTO','23/11/2017','15:27:21',NULL),(30,0,0,'ABERTO','23/11/2017','15:28:21',NULL),(31,0,0,'ABERTO','23/11/2017','15:28:50',NULL),(32,0,0,'ABERTO','23/11/2017','15:32:03',NULL),(33,0,0,'ABERTO','23/11/2017','15:35:43',NULL),(34,0,0,'ABERTO','23/11/2017','15:39:35',NULL),(35,0,0,'ABERTO','23/11/2017','15:40:39',NULL),(36,0,0,'ABERTO','23/11/2017','15:41:01',NULL),(37,0,0,'ABERTO','23/11/2017','15:49:12',NULL),(38,0,0,'ABERTO','23/11/2017','16:05:19',NULL),(39,0,0,'ABERTO','23/11/2017','16:18:37',NULL),(40,0,0,'ABERTO','23/11/2017','16:35:39',NULL),(41,0,0,'ABERTO','23/11/2017','16:38:21',NULL),(42,0,0,'ABERTO','23/11/2017','16:39:01',NULL),(43,0,0,'ABERTO','23/11/2017','16:40:46',NULL),(44,0,0,'ABERTO','23/11/2017','16:42:11',NULL),(45,0,0,'ABERTO','23/11/2017','16:42:31',NULL),(46,0,0,'ABERTO','23/11/2017','16:42:56',NULL),(47,0,0,'ABERTO','23/11/2017','16:44:06',NULL),(48,0,0,'ABERTO','23/11/2017','16:44:58',NULL),(49,0,0,'ABERTO','23/11/2017','16:45:19',NULL),(50,0,0,'ABERTO','23/11/2017','16:46:11',NULL),(51,0,0,'ABERTO','23/11/2017','16:47:27',NULL),(52,0,0,'ABERTO','23/11/2017','16:48:33',NULL),(53,0,0,'ABERTO','23/11/2017','16:48:58',NULL),(54,0,0,'ABERTO','23/11/2017','16:50:06',NULL),(55,0,0,'ABERTO','23/11/2017','16:51:32',NULL),(56,0,0,'ABERTO','23/11/2017','16:58:20',NULL),(57,0,0,'ABERTO','23/11/2017','16:58:45',NULL),(58,0,0,'ABERTO','23/11/2017','17:00:06',NULL),(59,0,0,'ABERTO','23/11/2017','17:02:39',NULL),(60,0,0,'ABERTO','23/11/2017','17:03:58',NULL),(61,0,0,'ABERTO','23/11/2017','17:07:09',NULL),(62,0,0,'ABERTO','23/11/2017','17:08:02',NULL),(63,0,0,'ABERTO','23/11/2017','17:09:48',NULL),(64,0,0,'ABERTO','23/11/2017','17:32:26',NULL),(65,0,0,'ABERTO','23/11/2017','17:37:58',NULL),(66,0,0,'ABERTO','23/11/2017','17:40:30',NULL),(67,0,0,'ABERTO','23/11/2017','17:42:01',NULL),(68,0,0,'ABERTO','23/11/2017','17:45:30',NULL),(69,0,0,'ABERTO','23/11/2017','17:47:15',NULL),(70,0,0,'ABERTO','23/11/2017','17:48:47',NULL),(71,0,0,'ABERTO','23/11/2017','17:49:21',NULL),(72,0,0,'ABERTO','23/11/2017','17:52:40',NULL),(73,0,0,'ABERTO','23/11/2017','17:53:56',NULL),(74,0,0,'ABERTO','23/11/2017','17:57:18',NULL),(75,0,0,'ABERTO','23/11/2017','17:58:38',NULL),(76,0,0,'ABERTO','23/11/2017','18:00:07',NULL),(77,0,0,'ABERTO','23/11/2017','18:07:12',NULL),(78,0,0,'ABERTO','23/11/2017','18:54:53',NULL),(79,0,0,'ABERTO','23/11/2017','18:55:24',NULL),(80,0,0,'ABERTO','23/11/2017','18:55:40',NULL),(81,0,0,'ABERTO','23/11/2017','18:56:36',NULL),(82,0,0,'ABERTO','23/11/2017','18:57:51',NULL),(83,0,0,'ABERTO','23/11/2017','18:58:11',NULL),(84,0,0,'ABERTO','23/11/2017','19:01:41',NULL),(85,0,0,'ABERTO','23/11/2017','19:09:41',NULL),(86,0,0,'ABERTO','23/11/2017','19:11:22',NULL),(87,0,0,'ABERTO','23/11/2017','19:12:15',NULL),(88,0,0,'ABERTO','23/11/2017','19:46:32',NULL),(89,0,0,'ABERTO','23/11/2017','19:52:52',NULL),(90,0,0,'ABERTO','23/11/2017','19:55:24',NULL),(91,0,0,'ABERTO','23/11/2017','19:56:43',NULL),(92,0,0,'ABERTO','23/11/2017','19:58:52',NULL),(93,0,0,'ABERTO','23/11/2017','20:04:19',NULL),(94,0,0,'ABERTO','23/11/2017','20:07:28',NULL),(95,0,0,'ABERTO','23/11/2017','20:09:44',NULL),(96,0,0,'ABERTO','23/11/2017','20:51:51',NULL),(97,0,0,'ABERTO','23/11/2017','21:33:44',NULL),(98,0,0,'ABERTO','23/11/2017','21:37:49',NULL),(99,0,0,'ABERTO','23/11/2017','21:45:49',NULL),(100,0,0,'ABERTO','23/11/2017','22:23:25',NULL),(101,0,0,'ABERTO','23/11/2017','22:23:50',NULL);
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
INSERT INTO `t_pedido_itens` VALUES (3,1,2,'ABERTO','15','4'),(7,1,1,'FECHADO','15','4');
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedidos`
--

LOCK TABLES `t_pedidos` WRITE;
/*!40000 ALTER TABLE `t_pedidos` DISABLE KEYS */;
INSERT INTO `t_pedidos` VALUES (1,50,4,'15','16');
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pessoas`
--

LOCK TABLES `t_pessoas` WRITE;
/*!40000 ALTER TABLE `t_pessoas` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pessoas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_usuarios`
--

DROP TABLE IF EXISTS `t_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_usuarios` (
  `usuario` varchar(16) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL DEFAULT 'CLIENTE',
  PRIMARY KEY (`usuario`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_usuarios`
--

LOCK TABLES `t_usuarios` WRITE;
/*!40000 ALTER TABLE `t_usuarios` DISABLE KEYS */;
INSERT INTO `t_usuarios` VALUES ('bnoleto','BRUNO','ADMIN'),('cozinha','COZINHEIRO','COZINHA'),('gerencia','GERENTE','CAIXA'),('mesa','FUNCIONARIO','CLIENTE'),('root','ADMIN','ADMIN');
/*!40000 ALTER TABLE `t_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-23 23:05:25
