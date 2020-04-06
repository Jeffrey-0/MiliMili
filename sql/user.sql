/*
Navicat MySQL Data Transfer

Source Server         : Websql
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : webstore

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2019-12-31 08:52:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_selfdescn` varchar(255) DEFAULT NULL,
  `user_speak` int(11) NOT NULL,
  `user_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4397 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('4', '小黄', '123', '我是大东', '0', '13645645654');
INSERT INTO `user` VALUES ('856', '哆啦坤梦', '123', '我是哆啦坤梦', '0', '13699999999');
INSERT INTO `user` VALUES ('1000', '小红', '123', '我是小红', '1', '11111111111');
INSERT INTO `user` VALUES ('1001', '小明', '123', '我是小明', '0', '22222222222');
INSERT INTO `user` VALUES ('1002', '小花', '123', '我是小花', '0', '33333333333');
INSERT INTO `user` VALUES ('1004', '小云', '123', '我是小云', '1', '55555555555');
INSERT INTO `user` VALUES ('1005', '小亮', '123', '我是小亮', '1', '66666666666');
INSERT INTO `user` VALUES ('1006', '小王', '123', '我是小王', '1', '77777777777');
INSERT INTO `user` VALUES ('1007', '绿谷', '123', '我是绿谷', '1', '88888888888');
INSERT INTO `user` VALUES ('1008', '出久', '123', '我是出久', '0', '96999999999');
INSERT INTO `user` VALUES ('1009', '欧尔麦特', '123', '我是欧尔麦特', '1', '1010');
INSERT INTO `user` VALUES ('1010', '小胜', '123', '我是小胜', '1', '2020');
INSERT INTO `user` VALUES ('1011', '郑大炳', '123', '我是坤坤', '1', '3030');
INSERT INTO `user` VALUES ('1012', '正小兵', '123', '我是小兵', '0', '4040');
INSERT INTO `user` VALUES ('1013', '老王', '123', '我是老王', '1', '5050');
INSERT INTO `user` VALUES ('1234', '阿阿斯顿', '111', '阿斯顿', '1', '10086100861');
INSERT INTO `user` VALUES ('4332', '东', '123', '我是帅哥', '1', '6060');
INSERT INTO `user` VALUES ('4396', '厂长', '123', '我是厂长', '0', '7070');
