/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : book_manager

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2024-02-01 10:02:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `avatarUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456', 'http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png');
INSERT INTO `admin` VALUES ('2', 'lhy', '123', 'http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png');
INSERT INTO `admin` VALUES ('3', 'admin111', '123', 'http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(60) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `price` double(10,2) NOT NULL,
  `status` int(11) NOT NULL COMMENT '0为可借阅，1为正在借阅',
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('3', '《python入门基础》', 'python入门基础教程内容', '31.44', '0');
INSERT INTO `book` VALUES ('13', '艰难一日', '击毙本拉登', '52.50', '1');
INSERT INTO `book` VALUES ('14', '艰难二体1', '313发发发', '54.00', '0');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('1', '1', '3', '2024-01-30 11:48:59');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `grade` varchar(20) NOT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '男', '高一2班');
INSERT INTO `student` VALUES ('2', '李四', '女', '高一1班');
INSERT INTO `student` VALUES ('3', '王五', '男', '高三3班');
