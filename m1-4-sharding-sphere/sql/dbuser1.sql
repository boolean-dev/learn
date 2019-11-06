-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.24-log - MySQL Community Server (GPL)
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for dbuser1
CREATE DATABASE IF NOT EXISTS `dbuser1` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbuser1`;

-- Dumping structure for table dbuser1.tb_user_0
CREATE TABLE IF NOT EXISTS `tb_user_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `age` mediumint(9) NOT NULL DEFAULT '0' COMMENT '年龄',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别：0无，1男，2女',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=398790078781980674 DEFAULT CHARSET=utf8;

-- Dumping data for table dbuser1.tb_user_0: ~5 rows (大约)
/*!40000 ALTER TABLE `tb_user_0` DISABLE KEYS */;
INSERT INTO `tb_user_0` (`id`, `name`, `age`, `sex`, `create_time`, `update_time`) VALUES
	(398790057592356865, '鄢剑涛', 14, 0, '2019-11-06 10:49:19', '2019-11-06 10:49:19'),
	(398790061551779841, '鄢剑涛', 14, 0, '2019-11-06 10:49:20', '2019-11-06 10:49:20'),
	(398790064584261633, '鄢剑涛', 14, 0, '2019-11-06 10:49:21', '2019-11-06 10:49:21'),
	(398790072368889857, '鄢剑涛', 14, 0, '2019-11-06 10:49:22', '2019-11-06 10:49:22'),
	(398790078781980673, '鄢剑涛', 14, 0, '2019-11-06 10:49:24', '2019-11-06 10:49:24');
/*!40000 ALTER TABLE `tb_user_0` ENABLE KEYS */;

-- Dumping structure for table dbuser1.tb_user_1
CREATE TABLE IF NOT EXISTS `tb_user_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `age` mediumint(9) NOT NULL DEFAULT '0' COMMENT '年龄',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别：0无，1男，2女',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=398790101754183682 DEFAULT CHARSET=utf8;

-- Dumping data for table dbuser1.tb_user_1: ~4 rows (大约)
/*!40000 ALTER TABLE `tb_user_1` DISABLE KEYS */;
INSERT INTO `tb_user_1` (`id`, `name`, `age`, `sex`, `create_time`, `update_time`) VALUES
	(398783774571102209, '鄢剑涛', 11, 0, '2019-11-06 10:24:21', '2019-11-06 10:24:21'),
	(398783803876704257, '鄢剑涛', 13, 0, '2019-11-06 10:24:28', '2019-11-06 10:24:28'),
	(398790097765400577, '鄢剑涛', 15, 0, '2019-11-06 10:49:28', '2019-11-06 10:49:28'),
	(398790101754183681, '鄢剑涛', 15, 0, '2019-11-06 10:49:29', '2019-11-06 10:49:29');
/*!40000 ALTER TABLE `tb_user_1` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
