/*
Navicat MySQL Data Transfer

Source Server         : Websql
Source Server Version : 50539
Source Host           : localhost:3306
Source Database       : webstore

Target Server Type    : MYSQL
Target Server Version : 50539
File Encoding         : 65001

Date: 2019-12-31 08:51:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(80) NOT NULL,
  `category_descn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`,`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '剧场动画', '主要播出海内外优秀动画片，给小朋友打造丰富的动画片观看平台');
INSERT INTO `category` VALUES ('2', '新番放送', '动画新番绝大多数开始放送时间在1月（冬季新番）、4月（春季新番）、7月（夏季新番）、10月（秋季新番）这四个月份中。');
INSERT INTO `category` VALUES ('3', '国产动漫', '中国动画起源于20世纪20年代，1926年摄制了中国第一部动画片《大闹画室》，揭开了中国动画史的一页。20世纪40年代，万氏兄弟创作了中国动画第一部长片《铁扇公主》，发行到东南亚和日本地区，受到人们的热烈欢迎，为中国动画走向国际作了很好的铺垫。');
INSERT INTO `category` VALUES ('4', '影视', '影视是以拷贝、磁带、胶片、存储器等为载体，以银幕、屏幕放映为目的，从而实现视觉与听觉综合观赏的艺术形式，是现代艺术的综合形态，包含了电影、电视剧、节目、动画等内容。');
INSERT INTO `category` VALUES ('5', '用户分享', '根据用户喜好分享视频');
