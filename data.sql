

USE `beike`;

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO bk_city (name, num) VALUES ("广州", 'GZ');

INSERT INTO bk_school (name, num, admin, password, city_id) 
			VALUES ("中山大学", "SYSU", 'sysuadmin', 'sysyupassword', 1);

INSERT INTO bk_district (name, num, address, deliver_name, deliver_phone, school_id) 
			VALUES ("至善园", 222, "至善园八号222", '小明', '1355555555', 1);
INSERT INTO bk_district (name, num, address, deliver_name, deliver_phone, school_id) 
			VALUES ("至善园", 333, "至善园八号333", '小明', '1355555555', 1);
INSERT INTO bk_district (name, num, address, deliver_name, deliver_phone, school_id) 
			VALUES ("至善园", 444, "至善园八号444", '小明', '1355555555', 1);


INSERT INTO bk_user (wx_name, user_num, password, city_id, school_id, dorm) 
			VALUES ("微信昵称", "1234", '1234', 1, 1, '至善园八号412');
INSERT INTO bk_user (wx_name, user_num, password, city_id, school_id, dorm) 
			VALUES ("微信昵称", "1", '1', 1, 1, '至善园八号412');
INSERT INTO bk_encashment (alipay_account, alipay_name, encashing_amount, phone) 
			VALUES ("支付宝账号1", "支付宝本人", 100, '13555555555');

INSERT INTO bk_announ (title, content) VALUES ('公告标题1', '公告内容1');
INSERT INTO bk_announ (title, content) VALUES ('公告标题2', '公告内容2');
INSERT INTO bk_announ (title, content) VALUES ('公告标题3', '公告内容3');

INSERT INTO bk_banner (title, link, datetime, prior) VALUES ("活动标题1", "http://www.baidu.com", CURDATE(), 1);
INSERT INTO bk_banner (title, link, datetime, prior) VALUES ("活动标题2", "http://www.baidu.com", CURDATE(), 1);
INSERT INTO bk_banner (title, link, datetime, prior) VALUES ("活动标题3", "http://www.baidu.com", CURDATE(), 1);
INSERT INTO bk_banner (title, link, datetime, prior) VALUES ("活动标题4", "http://www.baidu.com", CURDATE(), 1);

INSERT INTO bk_delivery_method (name, price) VALUES ("无配送", 0);
INSERT INTO bk_delivery_method (name, price) VALUES ("配送", 2.5);

INSERT INTO bk_book_category (title) VALUES ("计算机");
INSERT INTO bk_book_category (title) VALUES ("经济类");

INSERT INTO bk_book (book_category_id, title, delivery_method_id, press, author, edition, selling_price, rental_price) 
			VALUES (1, "计算机网络", 2, '电子工业出版社', '谢希仁', '第6版', 37.1, 3);
INSERT INTO bk_book (book_category_id, title, delivery_method_id, press, author, edition, selling_price, rental_price) 
			VALUES (2, "货币战争", 2, '浙江文艺出版社', '（美）库勒', '第1版', 29.1, 3);

INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (1, "11111", 22.5, 4, 1, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (1, "11111", 14.5, 3, 2, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (1, "11111", 17.5, 3.5, 2, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (1, "11111", 14.5, 3, 3, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (1, "11111", 27.5, 4.5, 1, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (2, "11111", 25.5, 4, 1, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (2, "11111", 23.5, 3, 1, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (2, "11111", 28.5, 4.5, 3, 1, CURDATE());
INSERT INTO bk_dealed_book (book_id, dealed_num, selling_price, rental_price, district_id, user_id, datetime) 
			VALUES (2, "11111", 23.5, 3.5, 2, 1, CURDATE());
