-- --------------------------------------------------------
-- 主机:                           192.168.0.5
-- 服务器版本:                        5.7.27 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  10.2.0.5639
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 examination 的数据库结构
CREATE DATABASE IF NOT EXISTS `examination` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `examination`;

-- 导出  表 examination.e_paper 结构
CREATE TABLE IF NOT EXISTS `e_paper` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '试卷名称',
  `data_flag` bit(1) NOT NULL DEFAULT b'1' COMMENT '试卷是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='试卷表';

-- 数据导出被取消选择。

-- 导出  表 examination.e_paper_topic 结构
CREATE TABLE IF NOT EXISTS `e_paper_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paper_id` bigint(20) NOT NULL COMMENT '试卷ID',
  `topic_id` bigint(20) NOT NULL COMMENT '题目ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='试卷与题目的关系表';

-- 数据导出被取消选择。

-- 导出  表 examination.e_topic 结构
CREATE TABLE IF NOT EXISTS `e_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `index` bigint(20) NOT NULL COMMENT '排序',
  `name` varchar(100) NOT NULL COMMENT '题目名称',
  `answer` text NOT NULL COMMENT '题目答案(JSON)',
  `data_flag` bit(1) NOT NULL DEFAULT b'1' COMMENT '答案是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='题目表';

-- 数据导出被取消选择。

-- 导出  表 examination.e_transcript 结构
CREATE TABLE IF NOT EXISTS `e_transcript` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paper_id` bigint(20) DEFAULT NULL COMMENT '试卷ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `answers` text NOT NULL COMMENT '答案数组,英文逗号隔开',
  `fraction` double NOT NULL DEFAULT '0' COMMENT '分数',
  `date` datetime NOT NULL COMMENT '交卷时间',
  `data_flag` bit(1) NOT NULL DEFAULT b'1' COMMENT '是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='成绩单表';

-- 数据导出被取消选择。

-- 导出  表 examination.e_user 结构
CREATE TABLE IF NOT EXISTS `e_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `data_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '用户是否有效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 数据导出被取消选择。

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
