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

-- 正在导出表  examination.e_paper 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `e_paper` DISABLE KEYS */;
INSERT INTO `e_paper` (`id`, `name`, `data_flag`) VALUES
	(1, 'Java 基础', b'1'),
	(2, 'Linux操作命令', b'1');
/*!40000 ALTER TABLE `e_paper` ENABLE KEYS */;

-- 导出  表 examination.e_paper_topic 结构
CREATE TABLE IF NOT EXISTS `e_paper_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `paper_id` bigint(20) NOT NULL COMMENT '试卷ID',
  `topic_id` bigint(20) NOT NULL COMMENT '题目ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='试卷与题目的关系表';

-- 正在导出表  examination.e_paper_topic 的数据：~17 rows (大约)
/*!40000 ALTER TABLE `e_paper_topic` DISABLE KEYS */;
INSERT INTO `e_paper_topic` (`id`, `paper_id`, `topic_id`) VALUES
	(1, 1, 1),
	(2, 1, 2),
	(3, 1, 3),
	(4, 1, 4),
	(5, 1, 5),
	(6, 1, 6),
	(7, 1, 7),
	(8, 1, 8),
	(9, 1, 9),
	(10, 1, 10),
	(11, 2, 11),
	(12, 2, 12),
	(13, 2, 13),
	(14, 2, 14),
	(15, 2, 15),
	(16, 2, 16),
	(17, 2, 17),
	(18, 2, 18),
	(19, 2, 19),
	(20, 2, 20);
/*!40000 ALTER TABLE `e_paper_topic` ENABLE KEYS */;

-- 导出  表 examination.e_topic 结构
CREATE TABLE IF NOT EXISTS `e_topic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `index` bigint(20) NOT NULL COMMENT '排序',
  `name` varchar(100) NOT NULL COMMENT '题目名称',
  `answer` text NOT NULL COMMENT '题目答案(JSON)',
  `data_flag` bit(1) NOT NULL DEFAULT b'1' COMMENT '答案是否有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='题目表';

-- 正在导出表  examination.e_topic 的数据：~18 rows (大约)
/*!40000 ALTER TABLE `e_topic` DISABLE KEYS */;
INSERT INTO `e_topic` (`id`, `index`, `name`, `answer`, `data_flag`) VALUES
	(1, 1, '下列说法正确的是？', '[{"name":"JAVA程序的main方法必须写在类里面","number":"A","correct":true},{"name":"JAVA程序中可以有多个main方法","number":"B","correct":false},{"name":"JAVA程序中类名必须与文件名一样","number":"C","correct":false},{"name":"JAVA程序的main方法中如果只有一条语句，可以不用{}(大括号)括起来","number":"D","correct":false}]', b'1'),
	(2, 2, '变量命名规范说法正确的是？', '[{"name":"变量由字母、下划线、数字、$符号随意组成","number":"A","correct":false},{"name":"变量不能以数字作为开头","number":"B","correct":true},{"name":"A和a在JAVA中是同一个变量","number":"C","correct":false},{"name":"不同类型的变量可以起相同的名字","number":"D","correct":false}]', b'1'),
	(3, 3, '下列JavaDoc注释正确的是？', '[{"name":"/*我爱北京天安门*/","number":"A","correct":false},{"name":"//我爱北京天安门*/","number":"B","correct":false},{"name":"/**我爱北京天安门*/","number":"C","correct":true},{"name":"/*我爱北京天安门**/","number":"D","correct":false}]', b'1'),
	(4, 4, '为一个boolean类型变量赋值时,可以使用(  )方式', '[{"name":"boolean = 1;","number":"A","correct":false},{"name":"boolean a = (9 >= 10);","number":"B","correct":true},{"name":"boolean a = \\"真\\";","number":"C","correct":false},{"name":"boolean a = = false;","number":"D","correct":false}]', b'1'),
	(5, 5, '以下不是合法的标识符', '[{"name":"STRING","number":"A","correct":false},{"name":"x3x;","number":"B","correct":false},{"name":"void","number":"C","correct":true},{"name":"de$f","number":"D","correct":false}]', b'1'),
	(6, 6, '表达式(11+3*8)/4%3的值是', '[{"name":"31","number":"A","correct":false},{"name":"0","number":"B","correct":false},{"name":"1","number":"C","correct":false},{"name":"2","number":"D","correct":true}]', b'1'),
	(7, 7, '(  )表达式不可作为循环条件', '[{"name":"i++;","number":"A","correct":true},{"name":"i>5;","number":"B","correct":false},{"name":"bEqual = str.equals(\\"q\\");","number":"C","correct":false},{"name":"count = = i;","number":"D","correct":false}]', b'1'),
	(8, 8, ' 整型数据类型中，需要内存空间最少的是', '[{"name":"short","number":"A","correct":false},{"name":"long","number":"B","correct":false},{"name":"int","number":"C","correct":false},{"name":"byte","number":"D","correct":true}]', b'1'),
	(9, 9, 'double数据类型的默认值是多少？', '[{"name":"0","number":"A","correct":false},{"name":"0.0","number":"B","correct":false},{"name":"null","number":"C","correct":false},{"name":"0.0d","number":"D","correct":true}]', b'1'),
	(10, 10, '若a = 8，则表达式 a >>> 2 的值是多少？', '[{"name":"1","number":"A","correct":false},{"name":"4","number":"B","correct":true},{"name":"3","number":"C","correct":false},{"name":"2","number":"D","correct":false}]', b'1'),
	(11, 1, '在重新启动Linux系统的同时把内存中的信息写入硬盘，应使用（）命令实现', '[{"name":"#shutdown -r now","number":"A","correct":true},{"name":"#halt","number":"B","correct":false},{"name":"#reboot","number":"C","correct":false},{"name":"#init3","number":"D","correct":false}]', b'1'),
	(12, 2, 'Linux操作系统内核创始人是', '[{"name":"Bill Gates","number":"A","correct":false},{"name":"Richard Stallman","number":"B","correct":false},{"name":"Linus Torvalds","number":"C","correct":true},{"name":"Dennis M· Ritchie、Ken Thompson","number":"D","correct":false}]', b'1'),
	(13, 3, '什么是交换空间', '[{"name":"用于交换的内存空间","number":"A","correct":false},{"name":"比内存大的空间","number":"B","correct":false},{"name":"用于交换的磁盘空间","number":"C","correct":true},{"name":"比内存小的空间","number":"D","correct":false}]', b'1'),
	(14, 4, '创建交换文件的命令是', '[{"name":"mkfs","number":"A","correct":false},{"name":"dd","number":"B","correct":true},{"name":"touch","number":"C","correct":false},{"name":"vi","number":"D","correct":false}]', b'1'),
	(15, 5, '删除交换空间之前必须关闭交换空间，关闭该使用哪个命令', '[{"name":"swapquit","number":"A","correct":false},{"name":"swapon","number":"B","correct":false},{"name":"swapoff","number":"C","correct":true},{"name":"rm","number":"D","correct":false}]', b'1'),
	(16, 6, '查看有多少个交换分区或交换文件在使用的方法', '[{"name":"cat /proc/swaps","number":"A","correct":true},{"name":"swapon","number":"B","correct":false},{"name":"swaps","number":"C","correct":false},{"name":"df","number":"D","correct":false}]', b'1'),
	(17, 7, '以下哪种产品不是LINUX发行版', '[{"name":"MANDRAKE","number":"A","correct":false},{"name":"REDHAT","number":"B","correct":false},{"name":"BSD","number":"C","correct":true},{"name":"DEBIAN","number":"D","correct":false}]', b'1'),
	(18, 8, '格式化交换空间的命令是', '[{"name":"mkfs","number":"A","correct":false},{"name":"mkswap","number":"B","correct":true},{"name":"mke2fs","number":"C","correct":false},{"name":"fdisk","number":"D","correct":false}]', b'1'),
	(19, 9, 'var主要适用于', '[{"name":"各种服务的配置文件","number":"A","correct":false},{"name":"引导记录","number":"B","correct":false},{"name":"各种可执行文件","number":"C","correct":false},{"name":"日志记录文件","number":"D","correct":true}]', b'1'),
	(20, 10, '查看交换空间的使用情况该使用哪个命令', '[{"name":"df","number":"A","correct":false},{"name":"swapon","number":"B","correct":false},{"name":"free","number":"C","correct":true},{"name":"fdisk","number":"D","correct":false}]', b'1');
/*!40000 ALTER TABLE `e_topic` ENABLE KEYS */;

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

-- 正在导出表  examination.e_transcript 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `e_transcript` DISABLE KEYS */;
INSERT INTO `e_transcript` (`id`, `paper_id`, `user_id`, `answers`, `fraction`, `date`, `data_flag`) VALUES
	(4, 1, 1, 'B,B,no-answer,D,B,C,B,D,no-answer,undefined', 20, '2019-10-23 20:25:16', b'1'),
	(5, 2, 1, 'no-answer,B,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,undefined', 0, '2019-10-23 20:25:17', b'1'),
	(6, 2, 1, 'no-answer,B,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,undefined', 0, '2019-10-23 20:25:17', b'1'),
	(7, 1, 1, 'B,C,no-answer,B,C,C,C,D,B,C', 30, '2019-10-24 10:12:04', b'1'),
	(8, 2, 1, 'A,B,C,no-answer,C,C,C,C,C,C', 50, '2019-10-24 10:13:59', b'1'),
	(9, 2, 1, 'no-answer,C,undefined,undefined,undefined,undefined,undefined,undefined,undefined,no-answer', 10, '2019-10-24 10:16:24', b'1'),
	(10, 1, 1, 'no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,C', 0, '2019-10-24 19:45:27', b'1'),
	(11, 1, 1, 'B,no-answer,C,B,C,no-answer,no-answer,no-answer,no-answer,undefined', 30, '2019-10-24 19:50:03', b'1'),
	(12, 1, 1, 'B,C,C,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,undefined', 10, '2019-10-24 20:40:18', b'1'),
	(13, 1, 1, 'B,no-answer,C,C,C,D,C,B,A,C', 30, '2019-10-29 08:39:58', b'1'),
	(14, 1, 1, 'no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,undefined', 0, '2019-11-04 11:14:28', b'1'),
	(15, 2, 1, 'B,no-answer,B,no-answer,no-answer,no-answer,no-answer,no-answer,no-answer,undefined', 0, '2019-11-04 11:15:05', b'1');
/*!40000 ALTER TABLE `e_transcript` ENABLE KEYS */;

-- 导出  表 examination.e_user 结构
CREATE TABLE IF NOT EXISTS `e_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `data_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '用户是否有效',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  examination.e_user 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `e_user` DISABLE KEYS */;
INSERT INTO `e_user` (`id`, `username`, `password`, `data_flag`) VALUES
	(1, 'test1', '123456', b'1');
/*!40000 ALTER TABLE `e_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
