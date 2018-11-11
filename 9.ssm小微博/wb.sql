/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : wb

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-10-26 08:35:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `userid` int(100) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `usersex` varchar(3) DEFAULT NULL,
  `userpassword` varchar(100) DEFAULT NULL,
  `usernichen` varchar(100) DEFAULT NULL,
  `usercreatetime` date DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', '乔峰', 'm', '123', '带音响的男人', '2018-09-10', '0');
INSERT INTO `adminuser` VALUES ('2', '段誉', 'm', '123', '官二代', '2018-09-10', '0');
INSERT INTO `adminuser` VALUES ('3', '范冰冰', 'f', '111', '偷税达人', '2018-01-10', '0');
INSERT INTO `adminuser` VALUES ('4', '库里', 'm', '222', '三分王', '2018-10-01', '0');
INSERT INTO `adminuser` VALUES ('5', '姚明', 'm', '123', '姚主席', '2018-10-01', '0');
INSERT INTO `adminuser` VALUES ('6', '李娜', 'f', '123', '娜姐', '2018-09-10', '0');
INSERT INTO `adminuser` VALUES ('7', '董明珠', 'f', '123', '董阿姨', '2018-08-10', '0');
INSERT INTO `adminuser` VALUES ('8', '任志强', 'm', '123', '大炮', '2018-05-10', '0');
INSERT INTO `adminuser` VALUES ('9', '王天一', 'm', '123', '当代棋王', '2018-07-10', '0');
INSERT INTO `adminuser` VALUES ('10', '陈一发', 'f', '123', '发姐', '2018-02-10', '0');
INSERT INTO `adminuser` VALUES ('11', '马云', 'm', '123', '红顶商人', '2018-10-01', '0');
INSERT INTO `adminuser` VALUES ('16', '1', 'm', '1', '1', '2018-10-15', '0');
INSERT INTO `adminuser` VALUES ('18', '2', 'm', '2', '2', '2018-10-17', '0');
INSERT INTO `adminuser` VALUES ('19', '3', 'm', '3', '3', '2018-10-17', '0');

-- ----------------------------
-- Table structure for composition
-- ----------------------------
DROP TABLE IF EXISTS `composition`;
CREATE TABLE `composition` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `neirong` varchar(4000) DEFAULT NULL,
  `state` int(3) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `createtime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of composition
-- ----------------------------
INSERT INTO `composition` VALUES ('3', '3', '3', '4', '2', '1', '2018-10-10');
INSERT INTO `composition` VALUES ('6', '规范的购房', '丰东股份收到的政府的规定支付', '4', '16', '1', '2018-10-17');
INSERT INTO `composition` VALUES ('7', '爱是飞洒', '阿双方都是', '4', '16', '1', '2018-10-16');
INSERT INTO `composition` VALUES ('8', 'sfsdf', '法定法规 ', '4', '16', '1', '2018-10-17');
INSERT INTO `composition` VALUES ('9', '沙发上', '阿噶的噶', '4', '16', '1', '2018-10-17');
INSERT INTO `composition` VALUES ('10', 'fasf ', 'afsasfas', '4', '16', '1', '2018-10-17');
INSERT INTO `composition` VALUES ('11', 'afdgd', 'gadfdsa', '4', '16', '1', '2018-10-17');
INSERT INTO `composition` VALUES ('13', '三个地方', '飞根深蒂固防控', '4', '16', '1', '2018-10-17');

-- ----------------------------
-- Table structure for fans
-- ----------------------------
DROP TABLE IF EXISTS `fans`;
CREATE TABLE `fans` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `fanuserid` int(100) DEFAULT NULL,
  `fanusername` varchar(100) DEFAULT NULL,
  `userid` int(100) DEFAULT NULL,
  `createtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fans
-- ----------------------------

-- ----------------------------
-- Table structure for logs
-- ----------------------------
DROP TABLE IF EXISTS `logs`;
CREATE TABLE `logs` (
  `id` varchar(100) NOT NULL,
  `caozuo` varchar(2000) DEFAULT NULL,
  `userid` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `createtime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logs
-- ----------------------------
