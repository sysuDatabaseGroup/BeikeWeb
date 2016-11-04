

DROP DATABASE IF EXISTS `beike`;
CREATE DATABASE `beike`;
USE `beike`;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  公告表
-- ----------------------------
DROP TABLE IF EXISTS `bk_announ`; 
CREATE TABLE `bk_announ` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL, 
  `content` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  活动表
-- ----------------------------
DROP TABLE IF EXISTS `bk_banner`;
CREATE TABLE `bk_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pic_path` varchar(200) NOT NULL DEFAULT '/images/banner/default.png',
  `title` varchar(30) NOT NULL,
  `link` varchar(255) NOT NULL,
  `datetime` date NOT NULL,
  `prior` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
--  书类表
-- ----------------------------
DROP TABLE IF EXISTS `bk_book_category`;  -- 旧表名：Class
CREATE TABLE `bk_book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10) NOT NULL, 
  `icon_path` varchar(100) NOT NULL DEFAULT '/images/bookCategory/default.png', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  书表
-- ----------------------------
DROP TABLE IF EXISTS `bk_book`;   -- 旧表名：BookClass
CREATE TABLE `bk_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `book_category_id` int(11) NOT NULL, 
  `title` varchar(50) NOT NULL, 
  `cover_path` varchar(100) NOT NULL DEFAULT '/images/book/default.png', 
  `delivery_method_id` int(11) NOT NULL, -- ?????????????
  `press` varchar(30) NOT NULL,  
  `author` varchar(10) NOT NULL,
  `edition` varchar(10) NOT NULL, 
  `selling_price` double(5,1) NOT NULL, 
  `rental_price` double(5,1) NOT NULL, 
  PRIMARY KEY (`id`),
  FOREIGN KEY (book_category_id) REFERENCES bk_book_category(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (delivery_method_id) REFERENCES bk_delivery_method(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CHECK(selling_price >= 0),
  CHECK(rental_price >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  待售书表
-- ----------------------------
DROP TABLE IF EXISTS `bk_dealed_book`;  -- 旧表名：Book
CREATE TABLE `bk_dealed_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `book_id` int(11) NOT NULL,   
  `dealed_num` varchar(20) NOT NULL,   -- 城市编号+学校编号+仓库编号+用户编号+书编号
  `selling_price` double(5,1) NOT NULL, 
  `rental_price` double(5,1) NOT NULL, 
  `district_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `datetime` date NOT NULL,
  `selled_datetime` date DEFAULT '1970-10-10',
  `selled` int(1) DEFAULT '0', 
  `rented` int(1) DEFAULT '0',  -- 
  `encashed` int(1) DEFAULT '0',  -- 
  PRIMARY KEY (`id`),
  FOREIGN KEY (book_id) REFERENCES bk_book(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (district_id) REFERENCES bk_district(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (user_id) REFERENCES bk_user(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CHECK(selling_price >= 0),
  CHECK(rental_price >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  城市表
-- ----------------------------
DROP TABLE IF EXISTS `bk_city`;
CREATE TABLE `bk_city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `num` varchar(10) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  仓库表
-- ----------------------------
DROP TABLE IF EXISTS `bk_district`;
CREATE TABLE `bk_district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `num` int(3) NOT NULL, -- 仓库编号
  `address` varchar(50) NOT NULL,
  `deliver_name` varchar(10) NOT NULL,
  `deliver_phone` varchar(20) NOT NULL,
  `school_id` int(11) NOT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  FOREIGN KEY (school_id) REFERENCES bk_school(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  配送方式表
-- ----------------------------
DROP TABLE IF EXISTS `bk_delivery_method`; -- 旧表名：Method
CREATE TABLE `bk_delivery_method` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `name` varchar(10) NOT NULL, 
  `price` int(2) NOT NULL, 
  PRIMARY KEY (`id`),
  CHECK(price >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  提现表
-- ----------------------------
DROP TABLE IF EXISTS `bk_encashment`;  -- 旧表名：Money
CREATE TABLE `bk_encashment` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `user_id` int(11) NOT NULL,
  `alipay_account` varchar(30) NOT NULL,
  `alipay_name` varchar(30) NOT NULL,
  `encashing_amount` double NOT NULL,  
  `phone` varchar(20) NOT NULL,
  `encashed` int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CHECK(encashing_amount >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  学校表
-- ----------------------------
DROP TABLE IF EXISTS `bk_school`;
CREATE TABLE `bk_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `num` varchar(10) NOT NULL,
  `admin` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status` int(1) NOT NULL DEFAULT 0,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (city_id) REFERENCES bk_city(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  UNIQUE(admin)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  售书表
-- ----------------------------
DROP TABLE IF EXISTS `bk_selling_order`;  -- 旧表名：sell
CREATE TABLE `bk_selling_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `user_id` int(11) NOT NULL,
  `delivery_method_id` int(11) NOT NULL,  
  `dealed_book_id` text NOT NULL,  
  `amount` int(3) NOT NULL, -- amount
  `datetime` date NOT NULL,
  `taking_book_num` varchar(20) NOT NULL, 
  `payed` int(11) DEFAULT '0', 
  PRIMARY KEY (`id`),
  FOREIGN KEY (user_id) REFERENCES bk_user(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (delivery_method_id) REFERENCES bk_delivery_method(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CHECK(amount >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  租书表
-- ----------------------------
DROP TABLE IF EXISTS `bk_renting_order`;  -- 旧表名：Borrow
CREATE TABLE `bk_renting_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `user_id` int(11) NOT NULL,
  `delivery_method_id` int(11) NOT NULL,   
  `dealed_book_id` text NOT NULL,  
  `amount` int(3) NOT NULL,  
  `datetime` date NOT NULL,
  `taking_book_num` varchar(30) NOT NULL, 
  `took` int(1) NOT NULL DEFAULT '0', 
  `returned` int(1) NOT NULL DEFAULT '0', 
  PRIMARY KEY (`id`),
  FOREIGN KEY (user_id) REFERENCES bk_user(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (delivery_method_id) REFERENCES bk_delivery_method(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CHECK(amount >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  用户表
-- ----------------------------
DROP TABLE IF EXISTS `bk_user`;
CREATE TABLE `bk_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wx_photo` varchar(255) DEFAULT '/images/user/default.png',
  `wx_name` varchar(50) DEFAULT NULL,
  `user_num` varchar(20) NOT NULL,
  `password` varchar(50) DEFAULT NULL, -- 临时
  `withdrawal_amount` double(5,1) DEFAULT 0, -- 
  `city_id` int(11) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `dorm` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (city_id) REFERENCES bk_city(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  FOREIGN KEY (school_id) REFERENCES bk_school(id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  UNIQUE(user_num),
  CHECK(withdrawal_amount >= 0)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `bk_ADMIN`
-- ----------------------------
DROP TABLE IF EXISTS `bk_admin`;
CREATE TABLE `bk_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `districtAddr` varchar(255) NOT NULL,
  `type` int(2) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

