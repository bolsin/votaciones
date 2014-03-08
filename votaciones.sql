-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.1.0.4545
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para votaciones
DROP DATABASE IF EXISTS `votaciones`;
CREATE DATABASE IF NOT EXISTS `votaciones` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `votaciones`;


-- Volcando estructura para tabla votaciones.censo
DROP TABLE IF EXISTS `censo`;
CREATE TABLE IF NOT EXISTS `censo` (
  `nif` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `votado` varchar(50) DEFAULT 'no',
  PRIMARY KEY (`nif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla votaciones.censo: ~0 rows (aproximadamente)
DELETE FROM `censo`;
/*!40000 ALTER TABLE `censo` DISABLE KEYS */;
/*!40000 ALTER TABLE `censo` ENABLE KEYS */;


-- Volcando estructura para tabla votaciones.partidos
DROP TABLE IF EXISTS `partidos`;
CREATE TABLE IF NOT EXISTS `partidos` (
  `partido` varchar(50) NOT NULL,
  `votos` int(11) DEFAULT '0',
  PRIMARY KEY (`partido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla votaciones.partidos: ~0 rows (aproximadamente)
DELETE FROM `partidos`;
/*!40000 ALTER TABLE `partidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `partidos` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
