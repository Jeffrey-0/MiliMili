/*
Navicat MySQL Data Transfer

Source Server         : Websql
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : webstore

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2019-12-31 08:51:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(2) NOT NULL AUTO_INCREMENT,
  `admin_username` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'sa', 'admin');
INSERT INTO `admin` VALUES ('6', '小绿', 'admin');
INSERT INTO `admin` VALUES ('7', '小辉', 'admin');
