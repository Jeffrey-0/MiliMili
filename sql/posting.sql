/*
Navicat MySQL Data Transfer

Source Server         : Websql
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : webstore

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2019-12-31 08:51:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for posting
-- ----------------------------
DROP TABLE IF EXISTS `posting`;
CREATE TABLE `posting` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_title` varchar(100) NOT NULL,
  `post_uid` int(11) NOT NULL,
  `post_name` varchar(100) NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `post_uid` (`post_uid`),
  CONSTRAINT `post_uid` FOREIGN KEY (`post_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of posting
-- ----------------------------
INSERT INTO `posting` VALUES ('1', '求出新番', '4396', '厂长');
INSERT INTO `posting` VALUES ('2', '什么时候才有全职猎人', '4332', '东');
INSERT INTO `posting` VALUES ('3', '火影忍者什么时候出后续更新？', '856', '哆啦坤梦');
INSERT INTO `posting` VALUES ('4', '求链接', '1000', '小红');
INSERT INTO `posting` VALUES ('6', '这里有动漫的大部分链接', '1002', '小花');
INSERT INTO `posting` VALUES ('8', '最近超级火的番有哪些？', '1004', '小云');
INSERT INTO `posting` VALUES ('9', '有什么时候比较少时间看的电影吗？', '1005', '小亮');
INSERT INTO `posting` VALUES ('10', '求出新番', '1006', '小王');
INSERT INTO `posting` VALUES ('11', '什么时候才有全职猎人', '1007', '绿谷');
INSERT INTO `posting` VALUES ('12', '火影忍者什么时候出后续更新？', '1008', '出久');
INSERT INTO `posting` VALUES ('13', '求链接', '1009', '欧尔麦特');
INSERT INTO `posting` VALUES ('14', '这里有动漫的大部分链接', '1010', '小胜');
INSERT INTO `posting` VALUES ('15', '圣诞节礼包', '1011', '郑大炳');
INSERT INTO `posting` VALUES ('16', '求出新番', '1000', '小红');
INSERT INTO `posting` VALUES ('17', '什么时候才有全职猎人', '1001', '小明');
INSERT INTO `posting` VALUES ('18', '火影忍者什么时候出后续更新？', '1002', '小花');
INSERT INTO `posting` VALUES ('20', '这里有动漫的大部分链接', '1004', '小云');
INSERT INTO `posting` VALUES ('21', '圣诞节礼包', '1005', '小亮');
INSERT INTO `posting` VALUES ('22', '最近超级火的番有哪些？', '1006', '小王');
INSERT INTO `posting` VALUES ('23', '有什么时候比较少时间看的电影吗？', '1007', '绿谷');
INSERT INTO `posting` VALUES ('24', '求链接', '1008', '出久');
INSERT INTO `posting` VALUES ('25', '这里有动漫的大部分链接', '1009', '欧尔麦特');
