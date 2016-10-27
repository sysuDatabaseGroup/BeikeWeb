/*
 Navicat MySQL Data Transfer
 
 Source Server         : root
 Source Server Version : 50627
 Source Host           : localhost
 Source Database       : beike

 Target Server Version : 50627
 File Encoding         : utf-8

 Date: 10/01/2016 11:20:49 AM
*/

DROP DATABASE IF EXISTS `beike`;
CREATE DATABASE `beike`;
USE `beike`;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bk_ANNOUN`
-- ----------------------------
DROP TABLE IF EXISTS `bk_ANNOUN`;
CREATE TABLE `bk_ANNOUN` (
  `announID` int(11) NOT NULL AUTO_INCREMENT,
  `announContent` text NOT NULL,
  PRIMARY KEY (`announID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_BANNER`
-- ----------------------------
DROP TABLE IF EXISTS `bk_BANNER`;
CREATE TABLE `bk_BANNER` (
  `bannerID` int(11) NOT NULL AUTO_INCREMENT,
  `bannerPic` varchar(200) NOT NULL,
  `bannerTitle` varchar(30) NOT NULL,
  `link` varchar(255) NOT NULL,
  `datetime` date NOT NULL,
  `prior` int(3) NOT NULL,
  PRIMARY KEY (`bannerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_BOOK`
-- ----------------------------
DROP TABLE IF EXISTS `bk_BOOK`;
CREATE TABLE `bk_BOOK` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT,
  `bookClassID` int(11) NOT NULL,
  `bookNum` varchar(20) NOT NULL,
  `sellPrice` double(5,0) NOT NULL,
  `borrowPrice` double(5,0) NOT NULL,
  `districtID` int(11) NOT NULL,
  `userID` int(11) NOT NULL,
  `datetime` date NOT NULL,
  `isSell` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`bookID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_BOOKCLASS`
-- ----------------------------
DROP TABLE IF EXISTS `bk_BOOKCLASS`;
CREATE TABLE `bk_BOOKCLASS` (
  `bookClassID` int(11) NOT NULL AUTO_INCREMENT,
  `classID` int(11) NOT NULL,
  `bookClassName` varchar(50) NOT NULL,
  `bookClassImg` varchar(100) NOT NULL,
  `methodID` int(11) NOT NULL,
  `company` varchar(30) NOT NULL,
  `author` varchar(10) NOT NULL,
  `version` varchar(10) NOT NULL,
  `sellPrice` double(5,0) NOT NULL,
  `borrowPrice` double(5,0) NOT NULL,
  PRIMARY KEY (`bookClassID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_BORROW`
-- ----------------------------
DROP TABLE IF EXISTS `bk_BORROW`;
CREATE TABLE `bk_BORROW` (
  `borrowID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `methodID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `num` int(3) NOT NULL,
  `datetime` date NOT NULL,
  `takeBookNum` varchar(30) NOT NULL,
  `isTake` int(1) NOT NULL DEFAULT '0',
  `isBack` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`borrowID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_CITY`
-- ----------------------------
DROP TABLE IF EXISTS `bk_CITY`;
CREATE TABLE `bk_CITY` (
  `cityID` int(11) NOT NULL AUTO_INCREMENT,
  `cityName` varchar(10) NOT NULL,
  `cityNum` varchar(10) NOT NULL,
  PRIMARY KEY (`cityID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_CLASS`
-- ----------------------------
DROP TABLE IF EXISTS `bk_CLASS`;
CREATE TABLE `bk_CLASS` (
  `classID` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(10) NOT NULL,
  `classImg` varchar(100) NOT NULL,
  PRIMARY KEY (`classID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_DISTRICT`
-- ----------------------------
DROP TABLE IF EXISTS `bk_DISTRICT`;
CREATE TABLE `bk_DISTRICT` (
  `districtID` int(11) NOT NULL AUTO_INCREMENT,
  `districtName` varchar(10) NOT NULL,
  `districtNum` int(3) NOT NULL,
  `address` varchar(50) NOT NULL,
  `deliverName` varchar(10) NOT NULL,
  `deliverPhone` varchar(20) NOT NULL,
  `schoolID` int(11) NOT NULL,
  PRIMARY KEY (`districtID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_METHOD`
-- ----------------------------
DROP TABLE IF EXISTS `bk_METHOD`;
CREATE TABLE `bk_METHOD` (
  `methodID` int(11) NOT NULL AUTO_INCREMENT,
  `methodName` varchar(10) NOT NULL,
  `price` int(2) NOT NULL,
  PRIMARY KEY (`methodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_MONEY`
-- ----------------------------
DROP TABLE IF EXISTS `bk_MONEY`;
CREATE TABLE `bk_MONEY` (
  `moneyID` int(11) NOT NULL AUTO_INCREMENT,
  `alipayAccount` varchar(30) NOT NULL,
  `alipayName` varchar(30) NOT NULL,
  `moneyNum` int(3) NOT NULL,
  `phone` varchar(20) NOT NULL,
  PRIMARY KEY (`moneyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_SCHOOL`
-- ----------------------------
DROP TABLE IF EXISTS `bk_SCHOOL`;
CREATE TABLE `bk_SCHOOL` (
  `schoolID` int(11) NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(10) NOT NULL,
  `schoolNum` varchar(10) NOT NULL,
  `schoolAdmin` varchar(20) DEFAULT NULL,
  `schoolPassword` varchar(20) DEFAULT NULL,
  `cityID` int(11) NOT NULL,
  PRIMARY KEY (`schoolID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_SELL`
-- ----------------------------
DROP TABLE IF EXISTS `bk_SELL`;
CREATE TABLE `bk_SELL` (
  `sellID` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) NOT NULL,
  `methodID` int(11) NOT NULL,
  `bookID` int(11) NOT NULL,
  `num` int(3) NOT NULL,
  `datetime` date NOT NULL,
  `takeBookNum` varchar(20) NOT NULL,
  `isMoney` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`sellID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_USER`
-- ----------------------------
DROP TABLE IF EXISTS `bk_USER`;
CREATE TABLE `bk_USER` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `wx_photo` varchar(255) DEFAULT NULL,
  `wx_name` varchar(50) DEFAULT NULL,
  `userNum` varchar(20) NOT NULL,
  `cityID` int(11) DEFAULT NULL,
  `schoolID` int(11) DEFAULT NULL,
  `dorm` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_ADMIN`
-- ----------------------------
DROP TABLE IF EXISTS `bk_ADMIN`;
CREATE TABLE `bk_ADMIN` (
  `adminID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `districtAddr` varchar(255) NOT NULL,
  `type` int(2) NOT NULL,
    PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_BILL`
-- ----------------------------
DROP TABLE IF EXISTS `bk_BILL`;
CREATE TABLE `bk_BILL` (
  `billID` int(11) NOT NULL AUTO_INCREMENT,
  `info` text NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`billID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
