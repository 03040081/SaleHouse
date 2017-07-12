/*
Navicat MySQL Data Transfer

Source Server         : 22
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : sellersys

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-07-11 13:25:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `cityId` int(10) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(50) NOT NULL,
  `provinceId` int(10) NOT NULL,
  PRIMARY KEY (`cityId`),
  KEY `provinceId` (`provinceId`),
  CONSTRAINT `CityToRegion` FOREIGN KEY (`cityId`) REFERENCES `region` (`regionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `houseId` int(10) NOT NULL AUTO_INCREMENT,
  `houseName` varchar(50) NOT NULL,
  `houseType` int(10) NOT NULL,
  `houseArea` double(5,0) NOT NULL,
  `housePrice` decimal(5,0) NOT NULL,
  `downPay` decimal(5,0) NOT NULL COMMENT '首付',
  `monthPay` decimal(10,0) NOT NULL COMMENT '月供',
  `buildId` int(10) NOT NULL,
  `state` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`houseId`),
  KEY `buildId` (`buildId`),
  KEY `houseType` (`houseType`),
  CONSTRAINT `HouseToImg` FOREIGN KEY (`houseId`) REFERENCES `houseimg` (`houseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of house
-- ----------------------------

-- ----------------------------
-- Table structure for houseimg
-- ----------------------------
DROP TABLE IF EXISTS `houseimg`;
CREATE TABLE `houseimg` (
  `imgId` int(10) NOT NULL AUTO_INCREMENT,
  `houseId` int(10) NOT NULL,
  `imgUrl` varchar(100) NOT NULL,
  PRIMARY KEY (`imgId`),
  KEY `houseId` (`houseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of houseimg
-- ----------------------------

-- ----------------------------
-- Table structure for housetype
-- ----------------------------
DROP TABLE IF EXISTS `housetype`;
CREATE TABLE `housetype` (
  `htypeId` int(10) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(150) NOT NULL,
  PRIMARY KEY (`htypeId`),
  CONSTRAINT `HouseTypeToHouse` FOREIGN KEY (`htypeId`) REFERENCES `house` (`houseType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of housetype
-- ----------------------------

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `orderId` int(10) NOT NULL,
  `userId` int(10) NOT NULL,
  `buildId` int(10) NOT NULL,
  `orderTime` datetime NOT NULL,
  `state` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`orderId`),
  KEY `userId` (`userId`),
  KEY `buildId` (`buildId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------

-- ----------------------------
-- Table structure for premises
-- ----------------------------
DROP TABLE IF EXISTS `premises`;
CREATE TABLE `premises` (
  `buildId` int(10) NOT NULL AUTO_INCREMENT,
  `buildName` varchar(50) NOT NULL,
  `inOpen` date DEFAULT NULL,
  `inLive` date DEFAULT NULL,
  `households` int(7) DEFAULT NULL COMMENT '规划户数',
  `propertyRight` int(4) DEFAULT NULL COMMENT '产权',
  `propertyCosts` varchar(50) DEFAULT NULL COMMENT '物业费用',
  `buildArea` double(7,0) DEFAULT NULL COMMENT '建筑面积',
  `floorArea` double(7,0) DEFAULT NULL COMMENT '占地面积',
  `buildAddress` varchar(150) DEFAULT NULL COMMENT '楼盘地址',
  `buildType` int(10) NOT NULL COMMENT '建筑类型',
  `developer` varchar(150) DEFAULT NULL COMMENT '开发商',
  `regionId` int(10) NOT NULL,
  PRIMARY KEY (`buildId`),
  KEY `regionId` (`regionId`),
  KEY `buildType` (`buildType`),
  CONSTRAINT `PremisesToImg` FOREIGN KEY (`buildId`) REFERENCES `premisesimg` (`buildId`),
  CONSTRAINT `PremiseToHouse` FOREIGN KEY (`buildId`) REFERENCES `house` (`buildId`),
  CONSTRAINT `PremiseToRoderInfo` FOREIGN KEY (`buildId`) REFERENCES `orderinfo` (`buildId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of premises
-- ----------------------------

-- ----------------------------
-- Table structure for premisesimg
-- ----------------------------
DROP TABLE IF EXISTS `premisesimg`;
CREATE TABLE `premisesimg` (
  `imgId` int(10) NOT NULL AUTO_INCREMENT,
  `buildId` int(10) NOT NULL,
  `imgUrl` varchar(100) NOT NULL,
  PRIMARY KEY (`imgId`),
  KEY `buildId` (`buildId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of premisesimg
-- ----------------------------

-- ----------------------------
-- Table structure for premisetype
-- ----------------------------
DROP TABLE IF EXISTS `premisetype`;
CREATE TABLE `premisetype` (
  `btypeId` int(10) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(150) NOT NULL,
  PRIMARY KEY (`btypeId`),
  CONSTRAINT `PremiseTypeToPremise` FOREIGN KEY (`btypeId`) REFERENCES `premises` (`buildType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of premisetype
-- ----------------------------

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `provinceId` int(10) NOT NULL AUTO_INCREMENT,
  `provinceName` varchar(50) NOT NULL COMMENT '省份',
  PRIMARY KEY (`provinceId`),
  CONSTRAINT `ProvinceToCity` FOREIGN KEY (`provinceId`) REFERENCES `city` (`provinceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of province
-- ----------------------------

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `regionId` int(10) NOT NULL AUTO_INCREMENT,
  `regionName` varchar(150) NOT NULL,
  `cityId` int(10) NOT NULL,
  PRIMARY KEY (`regionId`),
  CONSTRAINT `RegionToPremise` FOREIGN KEY (`regionId`) REFERENCES `premises` (`regionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of region
-- ----------------------------

-- ----------------------------
-- Table structure for roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `roleId` int(10) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(30) NOT NULL,
  PRIMARY KEY (`roleId`),
  CONSTRAINT `RoleToUser` FOREIGN KEY (`roleId`) REFERENCES `userinfo` (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(50) NOT NULL,
  `locked` int(2) NOT NULL DEFAULT '1' COMMENT '是否拉黑，初始为正常用户',
  `faceing` varchar(150) DEFAULT NULL COMMENT '简介',
  `role` int(10) NOT NULL,
  PRIMARY KEY (`userId`),
  KEY `role` (`role`),
  CONSTRAINT `UserToOrderInfo` FOREIGN KEY (`userId`) REFERENCES `orderinfo` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
