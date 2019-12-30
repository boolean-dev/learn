/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : master

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 30/12/2019 18:34:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名字',
  `age` mediumint(9) NOT NULL DEFAULT 0 COMMENT '年龄',
  `sex` tinyint(4) NOT NULL DEFAULT 0 COMMENT '性别：0无，1男，2女',
  `create_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 398790076873572353 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表0' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
