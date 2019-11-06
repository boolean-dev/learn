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


-- Dumping database structure for dbuser0
CREATE DATABASE IF NOT EXISTS `dbuser0` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dbuser0`;

-- Dumping structure for table dbuser0.tb_user_0
CREATE TABLE IF NOT EXISTS `tb_user_0` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `age` mediumint(9) NOT NULL DEFAULT '0' COMMENT '年龄',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别：0无，1男，2女',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=398790076873572353 DEFAULT CHARSET=utf8 COMMENT='用户表0';

-- Dumping data for table dbuser0.tb_user_0: ~5 rows (大约)
/*!40000 ALTER TABLE `tb_user_0` DISABLE KEYS */;
INSERT INTO `tb_user_0` (`id`, `name`, `age`, `sex`, `create_time`, `update_time`) VALUES
	(398783788726878208, '鄢剑涛', 12, 0, '2019-11-06 10:24:24', '2019-11-06 10:24:24'),
	(398790059962138624, '鄢剑涛', 14, 0, '2019-11-06 10:49:19', '2019-11-06 10:49:19'),
	(398790063053340672, '鄢剑涛', 14, 0, '2019-11-06 10:49:20', '2019-11-06 10:49:20'),
	(398790065880301568, '鄢剑涛', 14, 0, '2019-11-06 10:49:21', '2019-11-06 10:49:21'),
	(398790076873572352, '鄢剑涛', 14, 0, '2019-11-06 10:49:23', '2019-11-06 10:49:23');
/*!40000 ALTER TABLE `tb_user_0` ENABLE KEYS */;

-- Dumping structure for table dbuser0.tb_user_1
CREATE TABLE IF NOT EXISTS `tb_user_1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '名字',
  `age` mediumint(9) NOT NULL DEFAULT '0' COMMENT '年龄',
  `sex` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别：0无，1男，2女',
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=398790103641620481 DEFAULT CHARSET=utf8;

-- Dumping data for table dbuser0.tb_user_1: ~3 rows (大约)
/*!40000 ALTER TABLE `tb_user_1` DISABLE KEYS */;
INSERT INTO `tb_user_1` (`id`, `name`, `age`, `sex`, `create_time`, `update_time`) VALUES
	(398790094946828288, '鄢剑涛', 15, 0, '2019-11-06 10:49:28', '2019-11-06 10:49:28'),
	(398790099690586112, '鄢剑涛', 15, 0, '2019-11-06 10:49:29', '2019-11-06 10:49:29'),
	(398790103641620480, '鄢剑涛', 15, 0, '2019-11-06 10:49:30', '2019-11-06 10:49:30');
/*!40000 ALTER TABLE `tb_user_1` ENABLE KEYS */;

-- Dumping structure for table dbuser0.tb_user_info
CREATE TABLE IF NOT EXISTS `tb_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `info` varchar(50) NOT NULL DEFAULT '' COMMENT '用户简介',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- Dumping data for table dbuser0.tb_user_info: ~0 rows (大约)
/*!40000 ALTER TABLE `tb_user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
