/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.6.45 : Database - graduation
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`graduation` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `graduation`;

/*Table structure for table `autor` */

DROP TABLE IF EXISTS `autor`;

CREATE TABLE `autor` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `abirthday` date DEFAULT NULL,
  `aname` varchar(255) DEFAULT NULL,
  `aaddress` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `autor` */

insert  into `autor`(`aid`,`abirthday`,`aname`,`aaddress`) values (1,'2019-08-29','1231','31123'),(2,'2019-08-14','1231','12313'),(3,'2019-08-21','123123','123123');

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`id`,`category`) values (1,'头条'),(2,'国内'),(3,'国际'),(4,'政治'),(5,'财经'),(6,'体育'),(7,'娱乐'),(8,'军事'),(9,'教育'),(10,'科技'),(11,'NBA'),(12,'股票'),(13,'星座'),(14,'女性'),(15,'健康'),(16,'育儿');

/*Table structure for table `collect` */

DROP TABLE IF EXISTS `collect`;

CREATE TABLE `collect` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

/*Data for the table `collect` */

insert  into `collect`(`c_id`,`nid`,`mid`) values (124,1,2),(125,1,3),(126,3,12),(128,2,13),(130,9,13),(136,34,13);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `ccontent` varchar(255) DEFAULT NULL COMMENT '内容',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nid` int(11) DEFAULT NULL COMMENT '新闻id',
  `mid` int(11) DEFAULT NULL COMMENT '用户id',
  `zan_count` int(11) NOT NULL DEFAULT '0' COMMENT '点赞数',
  `type` int(11) unsigned NOT NULL DEFAULT '0',
  `checkid` int(11) unsigned DEFAULT NULL COMMENT '审核员的id',
  `reason` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `nid` (`nid`),
  KEY `mid` (`mid`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`nid`) REFERENCES `news` (`nid`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`mid`) REFERENCES `manager` (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

insert  into `comments`(`cid`,`ccontent`,`time`,`nid`,`mid`,`zan_count`,`type`,`checkid`,`reason`) values (2,'啊实打实asdklsahdiasjkdhjkashdjksadhkjsa','2019-09-04 15:37:00',1,2,167,1,1,'123'),(3,'阿松大啊啊收到','2019-09-04 19:35:56',2,5,129,0,NULL,NULL),(4,'阿松大','2019-09-04 19:31:24',3,2,112,0,NULL,NULL),(6,'123','2019-09-04 15:36:57',1,1,137,0,NULL,NULL),(7,'啊啊啊asdhashdksjahdjksahdjkashkdjs','2019-09-04 19:33:46',13,13,1,1,1,'1'),(8,'啊啊','2019-09-01 01:07:45',3,13,1,1,1,'11'),(9,'ss','2019-09-01 01:19:38',10,13,0,1,1,'1'),(10,'是是','2019-09-04 15:36:54',1,13,1,1,1,'0'),(11,'你太冷漠\n','2019-09-04 19:35:38',2,13,2,1,NULL,NULL),(12,'好嗯大苏打阿娇阿萨法律框架独立访客','2019-09-04 15:36:46',1,13,1,1,NULL,NULL),(13,'阿松大','2019-09-04 15:36:43',1,13,3,1,NULL,NULL),(14,'撒旦阿松大阿松大','2019-09-03 13:57:55',2,13,1,1,1,'1'),(15,'我会','2019-09-03 13:58:31',2,13,0,2,1,'1'),(16,'我会阿松大啊实打实大苏打实打实打算看到','2019-09-04 19:36:03',2,13,2,1,NULL,NULL),(17,'撒旦','2019-09-03 14:09:48',2,13,1,1,1,'1'),(18,'请问企鹅请求恶趣味我去饿请问恶趣味我去恶趣味恶趣味而且恶趣味请问恶趣味额为全额去问驱蚊器为请问去请问请问请问','2019-09-03 14:11:12',10,13,0,1,NULL,NULL),(19,'按实际的哈手机客户端','2019-09-04 19:23:36',23,13,0,2,1,'1'),(20,'阿萨','2019-09-05 08:56:36',2,13,0,2,1,'1'),(21,'阿萨阿松大','2019-09-05 08:56:42',2,13,0,1,1,'1'),(22,'撒旦','2019-09-05 08:58:44',2,13,0,1,1,'1'),(23,' asda s asd ','2019-09-05 08:59:04',23,13,0,1,1,'阿松大'),(24,'撒旦','2019-09-05 09:03:25',2,13,0,1,1,'1'),(25,'阿松大 ','2019-09-05 09:04:47',2,13,0,1,1,'1'),(26,'撒打算','2019-09-05 09:06:24',2,13,0,1,1,'1'),(27,'撒打算','2019-09-05 09:08:07',2,13,0,1,1,'1'),(28,'123123131','2019-09-10 15:22:46',34,13,0,0,NULL,NULL),(29,'你好的呀','2019-09-11 23:51:54',34,13,1,1,13,''),(30,'你','2019-09-12 09:29:11',34,13,0,0,NULL,NULL);

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `count` int(11) DEFAULT '1',
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

/*Data for the table `history` */

insert  into `history`(`h_id`,`mid`,`nid`,`time`,`count`) values (1,3,2,'2019-09-03 11:27:20',3),(2,13,1,'2019-09-09 14:38:49',4),(3,13,5,'2019-09-09 14:38:51',7),(4,13,18,'2019-09-03 14:45:15',4),(5,13,15,'2019-09-03 14:45:21',2),(6,13,19,'2019-09-03 14:45:23',1),(7,13,2,'2019-09-09 14:38:29',14),(8,13,17,'2019-09-03 23:27:48',1),(9,13,12,'2019-09-03 23:27:57',3),(10,13,6,'2019-09-03 23:34:40',4),(11,13,22,'2019-09-03 23:51:20',1),(12,13,3,'2019-09-03 23:52:04',10),(13,13,7,'2019-09-03 23:52:11',2),(14,13,37,'2019-09-04 16:01:43',19),(15,13,23,'2019-09-04 16:58:10',42),(16,13,30,'2019-09-04 16:58:17',19),(17,13,34,'2019-09-04 16:58:19',46),(18,13,42,'2019-09-04 17:03:25',12),(19,13,13,'2019-09-04 19:29:01',1),(20,13,10,'2019-09-04 19:29:18',2),(21,13,9,'2019-09-05 00:28:05',8),(22,13,104,'2019-09-05 09:09:02',1),(23,13,63,'2019-09-06 11:29:46',5),(24,13,103,'2019-09-06 11:29:58',2),(25,1,181,'2019-09-06 14:58:55',2),(27,1,35,'2019-09-07 13:57:53',1),(28,13,83,'2019-09-09 14:41:24',4),(29,13,53,'2019-09-09 14:41:32',1),(30,13,317,'2019-09-10 10:40:34',3),(31,13,280,'2019-09-10 10:41:28',3),(32,13,342,'2019-09-10 10:42:26',5),(33,13,410,'2019-09-10 11:23:23',7),(34,13,54,'2019-09-10 11:24:30',3),(35,13,162,'2019-09-10 11:24:38',5),(36,13,206,'2019-09-10 11:24:45',4),(37,13,101,'2019-09-10 11:26:04',14),(38,13,52,'2019-09-10 11:26:10',6),(39,13,32,'2019-09-10 11:27:43',4),(40,13,262,'2019-09-10 13:39:58',4),(41,13,102,'2019-09-10 13:42:13',1),(42,13,453,'2019-09-10 13:42:23',4),(43,13,460,'2019-09-10 13:42:34',4),(44,13,48,'2019-09-10 13:56:24',3),(45,13,38,'2019-09-10 14:11:54',8),(46,13,340,'2019-09-10 14:13:45',1),(47,13,137,'2019-09-10 14:13:52',2),(48,13,211,'2019-09-10 14:13:58',2),(49,13,247,'2019-09-10 14:14:07',4),(50,13,352,'2019-09-10 14:44:55',4),(51,13,27,'2019-09-10 15:03:57',1),(52,13,422,'2019-09-10 15:04:20',3),(53,13,431,'2019-09-10 15:04:24',5),(54,13,425,'2019-09-10 15:06:07',2),(55,13,29,'2019-09-10 15:06:11',1),(56,13,357,'2019-09-10 15:06:25',1),(57,13,11,'2019-09-10 15:08:41',2),(58,13,416,'2019-09-10 15:08:52',2),(59,13,396,'2019-09-10 15:08:57',6),(60,13,328,'2019-09-10 15:09:06',1),(61,13,276,'2019-09-10 15:09:18',1),(62,13,477,'2019-09-10 15:09:23',2),(63,13,147,'2019-09-10 15:14:47',2),(64,13,283,'2019-09-10 15:15:12',2),(65,13,386,'2019-09-10 15:15:18',2),(66,13,384,'2019-09-10 15:15:25',1),(67,13,221,'2019-09-10 15:15:30',1),(68,13,43,'2019-09-10 15:15:39',2),(69,13,226,'2019-09-10 15:15:46',1),(70,13,228,'2019-09-10 15:15:49',1),(71,13,47,'2019-09-10 15:15:53',1),(72,13,366,'2019-09-10 15:15:56',1),(73,13,472,'2019-09-10 15:17:30',1),(74,13,270,'2019-09-10 15:24:21',1),(75,13,71,'2019-09-10 15:52:55',1),(76,13,314,'2019-09-10 16:06:30',3),(77,13,338,'2019-09-10 16:06:50',4),(78,13,391,'2019-09-10 16:26:16',2),(79,13,144,'2019-09-11 09:54:24',1),(80,13,526,'2019-09-11 09:58:43',1),(81,13,152,'2019-09-11 09:58:58',1),(82,13,217,'2019-09-11 11:10:28',2),(83,13,377,'2019-09-11 14:38:31',2),(84,13,424,'2019-09-11 14:38:39',5),(85,13,380,'2019-09-11 14:38:44',4),(86,13,73,'2019-09-11 14:39:40',2),(87,13,238,'2019-09-11 14:40:20',1),(88,13,652,'2019-09-11 14:51:15',2),(89,13,315,'2019-09-11 14:51:41',1),(90,1,655,'2019-09-11 15:17:28',1),(91,1,476,'2019-09-11 15:25:29',2),(92,1,224,'2019-09-11 15:30:07',1),(93,1,32,'2019-09-11 15:30:12',5),(94,1,377,'2019-09-11 15:31:45',1),(95,1,5,'2019-09-11 15:31:49',2),(96,1,14,'2019-09-11 15:32:00',1),(97,1,33,'2019-09-11 15:32:33',1),(98,1,472,'2019-09-11 15:34:47',5),(99,1,11,'2019-09-11 15:34:49',1),(100,1,528,'2019-09-11 18:59:59',1),(101,1,470,'2019-09-11 19:06:37',4),(102,1,475,'2019-09-11 19:09:09',4),(103,1,473,'2019-09-11 19:09:24',4),(104,1,480,'2019-09-11 19:09:54',1),(105,1,478,'2019-09-11 19:11:12',1),(106,1,493,'2019-09-11 19:12:22',11),(107,1,471,'2019-09-11 19:19:25',2),(108,1,483,'2019-09-11 19:44:41',1),(109,13,324,'2019-09-11 23:44:31',4),(110,13,429,'2019-09-11 23:44:48',1),(111,13,281,'2019-09-11 23:44:50',3),(112,13,245,'2019-09-14 00:02:48',1),(113,13,310,'2019-09-14 00:06:59',1),(114,1,663,'2019-09-17 10:34:40',1),(115,1,477,'2019-09-17 10:34:55',1),(116,1,660,'2019-09-17 10:35:26',1),(117,1,665,'2019-09-17 14:00:08',1);

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `mid` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `account` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '密码',
  `mname` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '姓名',
  `type` int(1) DEFAULT NULL COMMENT '0普通用户1管理员2超级',
  `sex` int(1) DEFAULT NULL COMMENT '0男 1女',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `img` varchar(255) DEFAULT '/themes/img/ad/a14.jpg' COMMENT '头像',
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`mid`,`account`,`password`,`mname`,`type`,`sex`,`email`,`birthday`,`img`) values (1,'admin','admin','林俊波',1,0,'447527623@qq.com','2019-08-29','/themes/img/ad/a14.jpg'),(2,'admin2','root','林俊龙',1,0,'447527623@qq.com','2019-08-21','/themes/img/ad/a14.jpg'),(3,'admin3','root','撒旦',1,0,'447527623@qq.com','2019-09-05','/themes/img/ad/a14.jpg'),(5,'admin','root1','啊实打实',1,1,'447527623@qq.com','2019-08-23','/themes/img/ad/a14.jpg'),(13,'user','user','林俊波123',0,1,'447527623@qq.com','2019-08-02','/uploads/u=1820523987,3798556096&fm=26&gp=0.jpg'),(15,'uwer','11','111',0,1,'447527623@qq.com','2019-08-09','/themes/img/ad/a14.jpg');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menuid` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `menuname` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menuid`,`menuname`,`icon`,`url`,`pid`) values ('0','系统菜单','icon-sys','-','-1'),('100','用户模块','icon-sys','-','0'),('101','用户信息管理','icon-sys','/views/manager/listManger.html','100'),('102','评论管理','icon-sys','/views/manager/comments.html','100'),('200','管理模块','icon-sys','-','0'),('201','新闻管理','icon-sys','/views/new/newlist.html','200'),('203','评论审核','icon-sys','/views/manager/commentslist.html','200'),('202','新闻添加','icon-sys','/views/new/newadd.html','200');

/*Table structure for table `newcheck` */

DROP TABLE IF EXISTS `newcheck`;

CREATE TABLE `newcheck` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `checknameid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `newcheck` */

insert  into `newcheck`(`cid`,`nid`,`state`,`reason`,`checknameid`) values (1,1,0,NULL,1),(2,2,2,'涉黄',2),(3,3,1,NULL,NULL),(4,5,2,NULL,NULL);

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `nid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` text COMMENT '内容',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '分类',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  `src` varchar(255) DEFAULT NULL COMMENT '来源',
  `pic` varchar(255) DEFAULT NULL COMMENT '图片',
  `state` int(11) DEFAULT '0' COMMENT '0未审核1审过2没过',
  `reason` varchar(255) DEFAULT NULL COMMENT '审核理由',
  `usernameid` int(11) DEFAULT NULL COMMENT '审核人id',
  `autor` int(11) DEFAULT NULL,
  PRIMARY KEY (`nid`),
  KEY `type` (`type`),
  CONSTRAINT `news_ibfk_1` FOREIGN KEY (`type`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=686 DEFAULT CHARSET=utf8;

/*Data for the table `news` */


/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `notice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`n_id`,`mid`,`time`,`notice`) values (1,2,'2019-09-11 14:00:49','系统将于2019/9/12 9.00-12.00进行系统升级'),(2,2,'2019-09-11 14:11:14','系统将于2019/9/13 9.00-12.00进行系统升级'),(3,2,'2019-09-11 14:11:23','系统将于2019/9/14 9.00-12.00进行系统升级');

/*Table structure for table `reply` */

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL COMMENT '评论id',
  `rnameid` int(11) DEFAULT NULL COMMENT 'id',
  `rcontent` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reply` */

/*Table structure for table `tuijian` */

DROP TABLE IF EXISTS `tuijian`;

CREATE TABLE `tuijian` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `nid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=latin1;

/*Data for the table `tuijian` */

insert  into `tuijian`(`tid`,`nid`,`mid`,`time`,`state`) values (165,431,13,'2019-09-11 14:42:34',0),(166,425,13,'2019-09-11 14:47:14',0),(167,448,13,'2019-09-11 14:47:22',0),(168,29,13,'2019-09-11 14:49:25',0),(169,315,13,'2019-09-11 14:51:16',0),(170,324,13,'2019-09-11 14:51:42',0),(171,224,1,'2019-09-11 15:17:29',0),(172,272,1,'2019-09-11 15:25:30',0),(173,62,1,'2019-09-11 15:30:10',0),(174,422,1,'2019-09-11 15:30:13',0),(175,377,1,'2019-09-11 15:30:18',0),(176,32,1,'2019-09-11 15:31:45',0),(177,101,1,'2019-09-11 15:31:50',0),(178,26,1,'2019-09-11 15:32:01',0),(179,424,1,'2019-09-11 15:32:29',0),(180,228,1,'2019-09-11 15:32:34',0),(181,472,1,'2019-09-11 15:34:15',0),(182,38,1,'2019-09-11 15:34:47',0),(183,9,1,'2019-09-11 15:34:50',0),(184,299,1,'2019-09-11 17:31:05',0),(185,528,1,'2019-09-11 19:00:01',0),(186,478,1,'2019-09-11 19:06:38',0),(187,432,1,'2019-09-11 19:09:10',0),(188,262,1,'2019-09-11 19:09:25',0),(189,650,1,'2019-09-11 19:09:55',0),(190,270,1,'2019-09-11 19:11:13',0),(191,362,1,'2019-09-11 19:11:27',0),(192,404,1,'2019-09-11 19:12:23',0),(193,245,1,'2019-09-11 19:13:29',0),(194,12,1,'2019-09-11 19:16:40',0),(195,433,1,'2019-09-11 19:19:17',0),(196,447,1,'2019-09-11 19:19:26',0),(197,419,1,'2019-09-11 19:20:56',0),(198,5,1,'2019-09-11 19:44:42',0),(199,63,1,'2019-09-11 19:44:54',0),(200,464,1,'2019-09-11 19:45:20',0),(201,42,1,'2019-09-11 19:50:38',0),(202,281,13,'2019-09-11 23:44:32',0),(203,429,13,'2019-09-11 23:44:45',0),(204,652,13,'2019-09-11 23:44:49',0),(205,456,13,'2019-09-11 23:45:27',0),(206,317,13,'2019-09-11 23:45:39',0),(207,3,13,'2019-09-11 23:47:41',0),(208,280,13,'2019-09-11 23:51:29',0),(209,101,13,'2019-09-11 23:51:49',0),(210,34,13,'2019-09-11 23:52:15',0),(211,5,13,'2019-09-11 23:53:24',0),(212,410,13,'2019-09-11 23:54:02',0),(213,11,13,'2019-09-11 23:54:06',0),(214,12,13,'2019-09-12 09:26:39',0),(215,245,13,'2019-09-12 09:28:02',0),(216,493,13,'2019-09-14 00:02:50',0),(217,15,13,'2019-09-14 00:02:54',0),(218,43,13,'2019-09-14 00:03:03',0),(219,214,13,'2019-09-14 00:07:00',0),(220,391,13,'2019-09-17 10:02:34',0),(221,494,13,'2019-09-17 10:02:51',0),(222,226,13,'2019-09-17 10:22:31',0),(223,455,1,'2019-09-17 10:34:41',0),(224,218,1,'2019-09-17 10:34:51',0),(225,526,1,'2019-09-17 10:34:56',0),(226,360,1,'2019-09-17 10:35:26',0),(227,209,13,'2019-09-17 13:53:59',0),(228,352,13,'2019-09-17 13:54:31',0),(229,53,1,'2019-09-17 14:00:09',0);

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL COMMENT '上传用户',
  `src` varchar(255) COLLATE utf8_persian_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_persian_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `zan_count` int(11) DEFAULT NULL,
  `history` int(11) DEFAULT NULL COMMENT '浏览次数',
  `state` int(11) DEFAULT NULL,
  `reason` varchar(255) COLLATE utf8_persian_ci DEFAULT NULL,
  `usernameid` int(11) DEFAULT NULL COMMENT '审核人',
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_persian_ci;

/*Data for the table `video` */

insert  into `video`(`vid`,`mid`,`src`,`title`,`type`,`time`,`zan_count`,`history`,`state`,`reason`,`usernameid`) values (1,13,'/video/6pmmovpag-mobile.mp4','广东发生当街捅人',1,'2019-09-10 17:43:31',0,0,1,NULL,NULL),(2,3,'/video/mda-jhwnuzchviw7cxba.mp4','真人版绝地求生',1,'2019-09-04 19:10:51',0,0,1,NULL,NULL),(3,4,'/video/6pmmovpag-mobile.mp4','真人版绝地求生',1,'2019-09-10 17:40:23',NULL,NULL,1,NULL,NULL);

/*Table structure for table `zan_count` */

DROP TABLE IF EXISTS `zan_count`;

CREATE TABLE `zan_count` (
  `z_id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  PRIMARY KEY (`z_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=latin1;

/*Data for the table `zan_count` */

insert  into `zan_count`(`z_id`,`cid`,`mid`,`nid`) values (42,3,13,2),(44,11,13,2),(55,17,13,2),(56,14,13,2),(57,29,13,34);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;