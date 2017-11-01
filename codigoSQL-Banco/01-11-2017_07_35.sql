-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bdsupreme2
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
  `conta_valor` double unsigned NOT NULL,
  `conta_mesa` int(10) unsigned NOT NULL,
  `conta_status` varchar(20) NOT NULL,
  PRIMARY KEY (`conta_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_contas`
--

LOCK TABLES `t_contas` WRITE;
/*!40000 ALTER TABLE `t_contas` DISABLE KEYS */;
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
-- Table structure for table `t_pedido_itens`
--

DROP TABLE IF EXISTS `t_pedido_itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pedido_itens` (
  `itm_codigo` int(10) unsigned NOT NULL,
  `ped_codigo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`itm_codigo`,`ped_codigo`),
  KEY `fk_t_pedidos_has_t_itens_t_itens1_idx` (`ped_codigo`),
  KEY `fk_t_pedidos_has_t_itens_t_pedidos1_idx` (`itm_codigo`),
  CONSTRAINT `fk_t_pedidos_has_t_itens_t_itens1` FOREIGN KEY (`ped_codigo`) REFERENCES `t_itens` (`itm_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_pedidos_has_t_itens_t_pedidos1` FOREIGN KEY (`itm_codigo`) REFERENCES `t_pedidos` (`ped_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedido_itens`
--

LOCK TABLES `t_pedido_itens` WRITE;
/*!40000 ALTER TABLE `t_pedido_itens` DISABLE KEYS */;
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
  `ped_status` varchar(10) NOT NULL DEFAULT 'ABERTO',
  `ped_mesa` int(11) NOT NULL,
  PRIMARY KEY (`ped_codigo`),
  UNIQUE KEY `ped_codigo_UNIQUE` (`ped_codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pedidos`
--

LOCK TABLES `t_pedidos` WRITE;
/*!40000 ALTER TABLE `t_pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_pedidos_contas`
--

DROP TABLE IF EXISTS `t_pedidos_contas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_pedidos_contas` (
  `t_pedidos_ped_codigo` int(10) unsigned NOT NULL,
  `t_contas_conta_codigo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`t_pedidos_ped_codigo`,`t_contas_conta_codigo`),
  KEY `fk_t_pedidos_has_t_contas_t_contas1_idx` (`t_contas_conta_codigo`),
  KEY `fk_t_pedidos_has_t_contas_t_pedidos1_idx` (`t_pedidos_ped_codigo`),
  CONSTRAINT `fk_t_pedidos_has_t_contas_t_contas1` FOREIGN KEY (`t_contas_conta_codigo`) REFERENCES `t_contas` (`conta_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_t_pedidos_has_t_contas_t_pedidos1` FOREIGN KEY (`t_pedidos_ped_codigo`) REFERENCES `t_pedidos` (`ped_codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-01  7:36:42
