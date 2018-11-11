/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-26 08:36:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('39', '发撒', '大师傅');
INSERT INTO `user` VALUES ('40', '发撒', '大师傅');
INSERT INTO `user` VALUES ('41', '噶的噶', '大师傅');
INSERT INTO `user` VALUES ('42', '对方回复回复', '都是固定格式');
INSERT INTO `user` VALUES ('43', '1', '1');

-- ----------------------------
-- Table structure for zhang_wu
-- ----------------------------
DROP TABLE IF EXISTS `zhang_wu`;
CREATE TABLE `zhang_wu` (
  `zwid` int(11) NOT NULL AUTO_INCREMENT,
  `flname` varchar(200) DEFAULT NULL,
  `money` double DEFAULT NULL,
  `zhangHu` varchar(100) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`zwid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhang_wu
-- ----------------------------
INSERT INTO `zhang_wu` VALUES ('8', 'fs', '0', 'sdfs', '2018-10-13', 'sdfs');
INSERT INTO `zhang_wu` VALUES ('9', '其他支出', '1560', '现金', '2016-10-29', '丢钱了');
INSERT INTO `zhang_wu` VALUES ('10', '交通支出', '2300', '交通银行', '2016-10-29', '油价还在涨啊');
INSERT INTO `zhang_wu` VALUES ('11', '吃饭支出', '1000', '工商银行', '2016-10-29', '又吃饭');
INSERT INTO `zhang_wu` VALUES ('12', '工资收入', '1000', '现金', '2016-10-30', '开资');
INSERT INTO `zhang_wu` VALUES ('13', '交通支出', '2000', '现金', '2016-10-30', '机票好贵');
INSERT INTO `zhang_wu` VALUES ('14', '工资收入', '5000', '现金', '2016-10-30', '又开资了');
