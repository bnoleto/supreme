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
  `conta_abertura` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `conta_fechamento` timestamp NULL DEFAULT NULL,
  `conta_finalizacao` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`conta_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=447 DEFAULT CHARSET=utf8;
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
  `ped_dataHora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
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
  `ped_dataHora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ped_codigo`),
  UNIQUE KEY `ped_codigo_UNIQUE` (`ped_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_pessoas`
--

LOCK TABLES `t_pessoas` WRITE;
/*!40000 ALTER TABLE `t_pessoas` DISABLE KEYS */;
INSERT INTO `t_pessoas` VALUES (1,'BRUNO','0','bnoleto','0','ADMIN'),(2,'COZINHEIRO','0','cozinha','0','COZINHA'),(3,'CAIXA','0','caixa','0','CAIXA'),(4,'FUNCIONARIO','0','mesa','0','CLIENTE'),(5,'ADMIN','0','root','0','ADMIN'),(8,'sql10207255','0','servidor','0','ADMIN'),(9,'GERENTE','0','gerencia','0','GERENCIA');
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

-- Dump completed on 2017-11-28 23:06:16
