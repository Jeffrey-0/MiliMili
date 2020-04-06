/*
Navicat MySQL Data Transfer

Source Server         : Websql
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : webstore

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2019-12-31 08:51:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `post_stprey_id` int(11) NOT NULL,
  `post_from_uid` int(11) NOT NULL,
  `post_to_uid` int(11) DEFAULT NULL,
  `post_content` varchar(100) NOT NULL,
  `post_date` datetime NOT NULL,
  `post_from_name` varchar(100) NOT NULL,
  `post_to_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `post_id` (`post_id`),
  KEY `post_to_uid` (`post_from_uid`),
  CONSTRAINT `post_from_uid` FOREIGN KEY (`post_from_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `post_id` FOREIGN KEY (`post_id`) REFERENCES `posting` (`post_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `post_to_uid` FOREIGN KEY (`post_from_uid`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', '1', '4332', null, '我也想知道', '2019-12-12 12:26:05', '东', null);
INSERT INTO `post` VALUES ('2', '1', '1', '856', '4332', '什么时候出', '2019-12-12 12:26:25', '哆啦坤梦', '东');
INSERT INTO `post` VALUES ('3', '1', '1', '4396', '4332', '有链接吗？', '2019-12-12 12:26:48', '厂长', '东');
INSERT INTO `post` VALUES ('4', '1', '2', '4396', null, '楼主求链接', '2019-12-12 12:27:33', '厂长', null);
INSERT INTO `post` VALUES ('5', '2', '1', '856', null, '同问', '2019-12-12 12:28:01', '哆啦坤梦', null);
INSERT INTO `post` VALUES ('6', '1', '3', '856', null, '有哪位大佬链接共享一下呗！！', '2019-12-15 21:05:40', '哆啦坤梦', null);
INSERT INTO `post` VALUES ('7', '1', '3', '4396', '856', '我什么都要', '2019-12-15 22:07:10', '厂长', '哆啦坤梦');
INSERT INTO `post` VALUES ('8', '1', '2', '856', '4396', '什么链接多有，来我这里看吧', '2019-12-15 23:50:16', '哆啦坤梦', '厂长');
INSERT INTO `post` VALUES ('9', '1', '1', '4396', '4332', '我想要他下一部的链接', '2019-12-16 12:18:11', '厂长', '东');
INSERT INTO `post` VALUES ('10', '1', '1', '4396', '4332', '还有吗？', '2019-12-16 12:19:15', '厂长', '东');
INSERT INTO `post` VALUES ('11', '1', '2', '4396', '4396', '我也想知道', '2019-12-16 12:24:23', '厂长', '厂长');
INSERT INTO `post` VALUES ('12', '1', '3', '4396', '856', '什么时候出', '2019-12-16 12:26:36', '厂长', '哆啦坤梦');
INSERT INTO `post` VALUES ('16', '2', '1', '4396', '856', '有链接吗？', '2019-12-16 14:17:06', '厂长', '哆啦坤梦');
INSERT INTO `post` VALUES ('17', '2', '2', '4396', null, '楼主求链接', '2019-12-16 14:17:22', '厂长', null);
INSERT INTO `post` VALUES ('18', '2', '2', '4396', '4396', '同问', '2019-12-16 14:17:33', '厂长', '厂长');
INSERT INTO `post` VALUES ('19', '4', '1', '4396', null, '有哪位大佬链接共享一下呗！！', '2019-12-16 14:17:51', '厂长', null);
INSERT INTO `post` VALUES ('20', '4', '2', '4396', null, '我什么都要', '2019-12-16 14:18:06', '厂长', null);
INSERT INTO `post` VALUES ('21', '1', '1', '4396', '4332', '什么链接多有，来我这里看吧', '2019-12-17 10:32:04', '厂长', '东');
INSERT INTO `post` VALUES ('22', '1', '1', '4396', '4332', '什么时候出新番呀？', '2019-12-17 10:42:54', '厂长', '东');
