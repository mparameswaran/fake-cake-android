-- MySQL dump 10.13  Distrib 5.5.32, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: fakecake
-- ------------------------------------------------------
-- Server version	5.5.32-0ubuntu0.13.04.1

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
-- Table structure for table `base_cupcake`
--

DROP TABLE IF EXISTS `base_cupcake`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `base_cupcake` (
  `sku` varchar(25) NOT NULL,
  `cupcake` varchar(50) DEFAULT NULL,
  `egg` enum('Yes','No') DEFAULT NULL,
  `size` varchar(15) DEFAULT NULL,
  `weight_gram` int(5) DEFAULT NULL,
  PRIMARY KEY (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `base_cupcake`
--

LOCK TABLES `base_cupcake` WRITE;
/*!40000 ALTER TABLE `base_cupcake` DISABLE KEYS */;
INSERT INTO `base_cupcake` VALUES ('chocbig0','Rich Chocolate','No','Monster',300),('chocbig1','Rich Chocolate','Yes','Monster',300),('chocmin0','Rich Chocolate','No','Mini',25),('chocmin1','Rich Chocolate','Yes','Mini',25),('chocreg0','Rich Chocolate','Yes','Normal',100),('chocreg1','Rich Chocolate','Yes','Normal',100),('vanbig0','Vanilla Pound','No','Monster',300),('vanbig1','Vanilla Pound','Yes','Monster',300),('vanmin0','Vanilla Pound','No','Mini',25),('vanmin1','Vanilla Pound','No','Mini',25),('vanreg0','Vanilla Pound','No','Normal',100),('vanreg1','Vanilla Pound','Yes','Normal',100);
/*!40000 ALTER TABLE `base_cupcake` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cupcake_list`
--

DROP TABLE IF EXISTS `cupcake_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cupcake_list` (
  `sku` varchar(50) NOT NULL,
  `name` varchar(75) DEFAULT NULL,
  `images` int(11) NOT NULL,
  `short_description` varchar(100) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `base_cupcake` varchar(25) NOT NULL,
  `frosting` varchar(25) NOT NULL,
  `decoration` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`sku`),
  KEY `fk_image_ref` (`images`),
  KEY `fk_base_cupcake_ref` (`base_cupcake`),
  KEY `fk_frosting_ref` (`frosting`),
  CONSTRAINT `fk_base_cupcake_ref` FOREIGN KEY (`base_cupcake`) REFERENCES `base_cupcake` (`sku`),
  CONSTRAINT `fk_frosting_ref` FOREIGN KEY (`frosting`) REFERENCES `frosting` (`sku`),
  CONSTRAINT `fk_image_ref` FOREIGN KEY (`images`) REFERENCES `image` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cupcake_list`
--

LOCK TABLES `cupcake_list` WRITE;
/*!40000 ALTER TABLE `cupcake_list` DISABLE KEYS */;
INSERT INTO `cupcake_list` VALUES ('appcin00','Apple Cinnamon',12,'','Flavorful blend of baked apples and cinnamon','vanreg1','bcrm00',NULL),('ccream00','Cookies & Cream',9,'','Cookie bits with rich flavourful cream.','vanreg1','ccrm00',NULL),('choc00','Chocolate',2,'','Dark and handsome, also sinfully good.','chocreg1','bcrm00',NULL),('chochaz00','Chocolate Hazelnut',4,'','Chocolately with a hint of.. no hints just hazelnuts and chocolate.','chocreg1','bcrm00',NULL),('chocmint00','Mint Chocolate Chip',10,'','Minty fresh with bits of chocolate chips','chocreg1','bcrm00',NULL),('chocoffee00','Mocha',6,'','Perfect blend of coffee and chocolate.','chocreg1','bcrm00',NULL),('chocpb00','Chocolate Peanut Butter',3,'','Chocolately, nutty, creamy enough and chunky enough.','chocreg1','bcrm01pb',NULL),('coffee00','Espresso',5,'','Rich, perfect roast. Now you can have your coffee and eat it too.','vanreg1','bcrm00',NULL),('lemerin00','Lemon Meringue',13,'','Creamy sour sweet fresh citrus taste','vanreg1','bcrm00',NULL),('pcolada00','PiÃ±acolada',14,'','Pinapple and coconuts, typical Caribbean flavor','vanreg1','bcrm00',NULL),('pepmint00','Peppermint',15,'','Fresh tingly cool and pepperminty.','vanreg1','bcrm00',NULL),('pumpkin00','Sweet Pumpkin',16,'','Adventurously flavorful reminder of autumn or fall or Halloween','vanreg1','bcrm00',NULL),('straw00','Strawberry',11,'','Seriously strawberriliciously good.','vanreg1','bcrm00',NULL),('strawvanchoc00','Neapolitan',7,'','Chocolate, vanilla and strawberry all together.','vanreg1','bcrm00',NULL),('toffee00','Toffee',8,'','Caramelicious with hints of fresh milk. Only hints.','vanreg1','bcrm00',NULL),('van00','Vanilla',1,'','Not particularly adventurous but simple and elegant. Can\'t go wrong with this one.','vanreg1','bcrm00',NULL);
/*!40000 ALTER TABLE `cupcake_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `frosting`
--

DROP TABLE IF EXISTS `frosting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `frosting` (
  `sku` varchar(25) NOT NULL,
  `frosting` varchar(50) DEFAULT NULL,
  `egg` enum('Yes','No') DEFAULT NULL,
  `nut_type` varchar(25) DEFAULT NULL,
  `contains_nuts` enum('Yes','No') DEFAULT NULL,
  PRIMARY KEY (`sku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `frosting`
--

LOCK TABLES `frosting` WRITE;
/*!40000 ALTER TABLE `frosting` DISABLE KEYS */;
INSERT INTO `frosting` VALUES ('bcrm00','Buttercream','No','N/A','No'),('bcrm01c','Buttercream Praline','No','Cashewnut','Yes'),('bcrm01pb','Buttercream Peanut Butter','No','Peanut','Yes'),('bcrm10','Fluffycream','Yes','N/A','No'),('ccrm00','Cookies & Cream','No','N/A','No'),('parch01c','Parchment','No','Cashewnut','Yes'),('wtricng00','Glaze','No','N/A','No');
/*!40000 ALTER TABLE `frosting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `thumbnail` varchar(200) DEFAULT NULL,
  `normal_one` varchar(200) DEFAULT NULL,
  `normal_two` varchar(200) DEFAULT NULL,
  `normal_three` varchar(200) DEFAULT NULL,
  `normal_four` varchar(200) DEFAULT NULL,
  `normal_five` varchar(200) DEFAULT NULL,
  `large` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'/images/vanilla-thumb.jpg','/images/vanilla.jpg','','','','','/images/vanilla-large.jpg'),(2,'/images/chocolate-thumb.jpg','/images/chocolate.jpg','','','','','/images/chocolate-large.jpg'),(3,'/images/choc-pb-thumb.jpg','/images/choc-pb.jpg','','','','','/images/choc-pb-large.jpg'),(4,'/images/choc-hazel-thumb.jpg','/images/choc-hazel.jpg','','','','','/images/choc-hazel-large.jpg'),(5,'/images/espresso-thumb.jpg','/images/espresso.jpg','','','','','/images/espresso-large.jpg'),(6,'/images/mocha-thumb.jpg','/images/mocha.jpg','','','','','/images/mocha-large.jpg'),(7,'/images/neapolitan-thumb.jpg','/images/neapolitan.jpg','','','','','/images/neapolitan-large.jpg'),(8,'/images/toffee-thumb.jpg','/images/toffee.jpg','','','','','/images/toffee-large.jpg'),(9,'/images/cookies-cream-thumb.jpg','/images/cookies-cream.jpg','','','','','/images/cookies-cream-large.jpg'),(10,'/images/mint-choc-chip-thumb.jpg','/images/mint-choc-chip.jpg','','','','','/images/mint-choc-chip-large.jpg'),(11,'/images/strawberry-thumb.jpg','/images/strawberry.jpg','','','','','/images/strawberry-large.jpg'),(12,'/images/apple-cinnamon-thumb.jpg','/images/apple-cinnamon.jpg','','','','','/images/apple-cinnamon-large.jpg'),(13,'/images/lemon-thumb.jpg','/images/lemon.jpg','','','','','/images/lemon-large.jpg'),(14,'/images/pinacolada-thumb.jpg','/images/pinacolada.jpg','','','','','/images/pinacolada-large.jpg'),(15,'/images/peppermint-thumb.jpg','/images/peppermint.jpg','','','','','/images/peppermint-large.jpg'),(16,'/images/pumpkin-thumb.jpg','/images/pumpkin.jpg','','','','','/images/pumpkin-large.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-11-24 19:31:42
