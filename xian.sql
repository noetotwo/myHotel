/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.11 : Database - xiaozhi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xiaozhi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `xiaozhi`;

/*Table structure for table `abandoned_client` */

DROP TABLE IF EXISTS `abandoned_client`;

CREATE TABLE `abandoned_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cid` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `card` varchar(18) NOT NULL,
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `vipType` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `RegisterTime` varchar(20) DEFAULT NULL,
  `integral` int(11) NOT NULL,
  `del_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `abandoned_client` */

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminname` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理者账号',
  `password` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理者密码',
  `level` int(1) DEFAULT '1' COMMENT '管理者级别',
  PRIMARY KEY (`adminname`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `admin` */

insert  into `admin`(`adminname`,`password`,`level`) values ('1','1',1),('2','2',2),('8','1',8),('boss','1',9);

/*Table structure for table `change_client` */

DROP TABLE IF EXISTS `change_client`;

CREATE TABLE `change_client` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cid` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `card` varchar(18) NOT NULL,
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `vipType` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `RegisterTime` varchar(20) DEFAULT NULL,
  `integral` int(11) DEFAULT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `change_client` */

/*Table structure for table `client` */

DROP TABLE IF EXISTS `client`;

CREATE TABLE `client` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户ID',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户名字',
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '客户性别',
  `card` varchar(18) NOT NULL COMMENT '客户身份证',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '客户手机号',
  `vipType` varchar(10) NOT NULL DEFAULT '白银' COMMENT '客户vip级别',
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '客户邮箱',
  `RegisterTime` varchar(20) NOT NULL COMMENT '注册时间',
  `integral` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `client_card_uindex` (`card`),
  KEY `vip_type` (`vipType`),
  CONSTRAINT `client_ibfk_1` FOREIGN KEY (`vipType`) REFERENCES `vip_title` (`level`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `client` */

insert  into `client`(`id`,`name`,`sex`,`card`,`phone`,`vipType`,`email`,`RegisterTime`,`integral`) values (3,'贤哲','男','123456789012345678','12345678901','白银','','2022-04-18 12:27:26',0),(4,'吴家聪','男','111111111111111111','11111111111','白银','','2022-04-18 12:44:39',0);

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `name` varchar(10) NOT NULL COMMENT '客户名字',
  `sex` varchar(10) DEFAULT NULL COMMENT '客户性别',
  `card` varchar(18) NOT NULL COMMENT '客户身份证',
  `phone` varchar(11) NOT NULL COMMENT '客户手机号',
  `EnterTime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '入住时间',
  `ExitTime` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '退房时间',
  `suiteNum` int(11) NOT NULL COMMENT '房间号',
  `suiteType` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '房间类型',
  `billingAdmin` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '入住操作员',
  `checkAdmin` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '退房操作员',
  `suitePrice` int(11) NOT NULL COMMENT '房间价格',
  `checkPrice` int(11) DEFAULT NULL COMMENT '实际支付价格',
  `state` varchar(10) NOT NULL COMMENT '订单状态',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Order_id_uindex` (`id`),
  KEY `ClientID` (`name`),
  KEY `suiteID` (`sex`),
  KEY `billingAdmin` (`billingAdmin`),
  KEY `checkAdmin` (`checkAdmin`),
  KEY `card` (`card`),
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`billingAdmin`) REFERENCES `admin` (`adminname`),
  CONSTRAINT `order_ibfk_4` FOREIGN KEY (`checkAdmin`) REFERENCES `admin` (`adminname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `order` */

/*Table structure for table `suite` */

DROP TABLE IF EXISTS `suite`;

CREATE TABLE `suite` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '房间ID',
  `roomNum` int(10) NOT NULL COMMENT '房间号',
  `SType` varchar(10) NOT NULL COMMENT '房间类型',
  `Price` int(10) NOT NULL COMMENT '价格',
  `State` varchar(10) DEFAULT '空房' COMMENT '房间状态',
  `Img` varchar(50) DEFAULT NULL COMMENT '房间图片',
  `Introduce` varchar(255) DEFAULT NULL COMMENT '房间介绍',
  PRIMARY KEY (`id`,`roomNum`),
  KEY `room_num` (`roomNum`) USING BTREE,
  KEY `suite_type` (`SType`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `suite` */

insert  into `suite`(`id`,`roomNum`,`SType`,`Price`,`State`,`Img`,`Introduce`) values (1,201,'普通大床房',120,'空房',NULL,''),(2,202,'普通大床房',120,'空房',NULL,'时尚\r\n                        \r\n                    '),(3,203,'高级双床房',150,'空房',NULL,'时尚\r\n                        \r\n                    \r\n                    '),(4,204,'豪华大床房',200,'空房',NULL,''),(5,205,'豪华大床房',210,'空房',NULL,'豪华\r\n                        '),(6,206,'高级大床房',200,'空房',NULL,'浩荡'),(7,207,'豪华套房',300,'空房',NULL,''),(8,208,'豪华套房',310,'空房',NULL,''),(9,209,'普通双床房',105,'空房',NULL,'朴实\r\n                        '),(10,210,'豪华圆床房',255,'空房',NULL,''),(11,301,'大床钟点房（四小时）',60,'空房',NULL,'忙碌\r\n                        '),(12,302,'大床钟点房（三小时）',50,'空房',NULL,'急促\r\n                        \r\n                    \r\n                    \r\n                    '),(13,888,'速8大床房',888,'空房','',''),(14,509,'豪华大床房',156,'空房',NULL,'test'),(15,508,'高级大床房',136,'空房',NULL,'test');

/*Table structure for table `vip_title` */

DROP TABLE IF EXISTS `vip_title`;

CREATE TABLE `vip_title` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'vipID',
  `level` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'vip级别',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `VIP_title_level_uindex` (`level`),
  UNIQUE KEY `VIP_title_ID_uindex` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `vip_title` */

insert  into `vip_title`(`ID`,`level`) values (3,'白金'),(1,'白银'),(4,'钻石'),(2,'黄金'),(5,'黑金'),(6,'黑金PLUS');

/* Trigger structure for table `client` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Update_lient` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `Update_lient` BEFORE UPDATE ON `client` FOR EACH ROW BEGIN
    INSERT INTO change_client(`Cid`,`name`,`sex`,`card`,`phone`,`vipType`,`email`,`RegisterTime`,`integral`,`update_time`)
    VALUES(old.id,old.name,old.sex,old.card,old.phone,old.vipType,old.email,old.registerTime,old.integral,NOW());
    END */$$


DELIMITER ;

/* Trigger structure for table `client` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `Deletec_lient` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `Deletec_lient` BEFORE DELETE ON `client` FOR EACH ROW BEGIN
    INSERT INTO abandoned_client(`Cid`,`name`,`sex`,`card`,`phone`,`vipType`,`email`,`RegisterTime`,`integral`,`del_time`)
    VALUES(old.id,old.name,old.sex,old.card,old.phone,old.vipType,old.email,old.registerTime,old.integral,NOW());
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
