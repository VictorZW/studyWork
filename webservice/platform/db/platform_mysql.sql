-- --------------------------------------------------------
-- 主机:                           192.168.1.16
-- 服务器版本:                        5.1.30-community - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 mcm 的数据库结构
DROP DATABASE IF EXISTS `mcm`;
CREATE DATABASE IF NOT EXISTS `mcm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mcm`;


-- 导出  表 mcm.system_apk_version 结构
DROP TABLE IF EXISTS `system_apk_version`;
CREATE TABLE IF NOT EXISTS `system_apk_version` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VERSION` varchar(64) DEFAULT NULL,
  `URL` varchar(64) DEFAULT NULL,
  `UPDATE_DATE` datetime DEFAULT NULL,
  `VERSIONCODE` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_apk_version 的数据：~0 rows (大约)
DELETE FROM `system_apk_version`;
/*!40000 ALTER TABLE `system_apk_version` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_apk_version` ENABLE KEYS */;


-- 导出  表 mcm.system_dict 结构
DROP TABLE IF EXISTS `system_dict`;
CREATE TABLE IF NOT EXISTS `system_dict` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `VALUE` varchar(64) DEFAULT NULL,
  `NO` varchar(64) NOT NULL,
  `PARENT_NO` varchar(64) DEFAULT NULL,
  `TYPE` varchar(20) DEFAULT NULL,
  `NOTE` varchar(640) DEFAULT NULL,
  `CONTENT` varchar(640) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_dict 的数据：~3 rows (大约)
DELETE FROM `system_dict`;
/*!40000 ALTER TABLE `system_dict` DISABLE KEYS */;
INSERT INTO `system_dict` (`ID`, `VALUE`, `NO`, `PARENT_NO`, `TYPE`, `NOTE`, `CONTENT`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, '公共类别', '1', '0', 'public', NULL, NULL, NULL, NULL, NULL, NULL),
	(2, '系统管理', '2', '0', 'system', NULL, NULL, NULL, NULL, NULL, NULL),
	(3, '业务类别', '3', '0', 'business', NULL, NULL, NULL, NULL, '2016-12-07 09:19:30', NULL);
/*!40000 ALTER TABLE `system_dict` ENABLE KEYS */;


-- 导出  表 mcm.system_logs 结构
DROP TABLE IF EXISTS `system_logs`;
CREATE TABLE IF NOT EXISTS `system_logs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_CODE` varchar(64) DEFAULT NULL COMMENT '用户ID',
  `LOG_TIME` datetime DEFAULT NULL COMMENT '操作时间',
  `LOG_TYPE` varchar(12) DEFAULT NULL COMMENT '日志类型',
  `LOG_INFO` varchar(500) DEFAULT NULL COMMENT '日志内容',
  `LOG_IP` varchar(200) DEFAULT NULL COMMENT 'IP地址',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- 正在导出表  mcm.system_logs 的数据：~78 rows (大约)
DELETE FROM `system_logs`;
/*!40000 ALTER TABLE `system_logs` DISABLE KEYS */;
INSERT INTO `system_logs` (`ID`, `USER_CODE`, `LOG_TIME`, `LOG_TYPE`, `LOG_INFO`, `LOG_IP`) VALUES
	(1, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(2, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(3, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(4, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(5, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(6, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(7, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(8, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(9, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(10, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(11, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(12, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(13, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(14, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(15, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(16, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(17, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(18, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(19, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(20, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(21, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(22, 'admin', NULL, '电脑端登陆', '用户名密码登陆', '127.0.0.1'),
	(23, 'admin', '2016-12-05 16:16:13', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(24, 'admin', '2016-12-05 16:45:29', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(25, 'admin', '2016-12-06 11:13:56', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(26, 'admin', '2016-12-06 11:23:27', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(27, 'admin', '2016-12-06 11:29:04', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(28, 'admin', '2016-12-06 11:31:12', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(29, 'admin', '2016-12-06 14:52:43', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(30, 'admin', '2016-12-06 15:01:23', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(31, 'admin', '2016-12-06 16:10:10', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(32, 'admin', '2016-12-06 17:08:20', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(33, 'admin', '2016-12-06 17:18:21', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(34, 'admin', '2016-12-07 08:39:01', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(35, 'admin', '2016-12-07 09:10:30', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(36, 'admin', '2016-12-07 09:59:36', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(37, 'admin', '2016-12-07 10:02:42', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(38, 'admin', '2016-12-07 10:22:36', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(39, 'admin', '2016-12-07 11:06:00', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(40, 'admin', '2016-12-07 11:22:55', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(41, 'admin', '2016-12-07 11:27:50', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(42, 'admin', '2016-12-07 11:38:39', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(43, 'admin', '2016-12-07 11:56:32', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(44, 'admin', '2016-12-07 12:00:18', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(45, 'admin', '2016-12-07 12:55:23', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(46, 'admin', '2016-12-07 13:00:16', '电脑端登陆', '该用户不存在', '0:0:0:0:0:0:0:1'),
	(47, 'admin', '2016-12-07 13:01:33', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(48, 'admin', '2016-12-07 13:07:00', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(49, 'admin', '2016-12-07 13:10:31', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(50, 'admin', '2016-12-07 13:14:43', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(51, 'admin', '2016-12-07 13:23:20', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(52, 'admin', '2016-12-07 13:31:38', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(53, 'admin', '2016-12-07 13:50:25', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(54, 'admin', '2016-12-07 13:57:24', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(55, 'admin', '2016-12-07 14:05:24', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(56, 'admin', '2016-12-07 14:28:22', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(57, 'admin', '2016-12-07 14:53:42', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(58, 'admin', '2016-12-07 15:27:50', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(59, 'admin', '2016-12-07 15:52:19', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(60, 'admin', '2016-12-07 15:54:04', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(61, 'admin', '2016-12-07 16:02:27', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(62, 'admin', '2016-12-07 16:04:56', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(63, 'admin', '2016-12-07 17:04:04', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(64, 'admin', '2016-12-08 08:31:12', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(65, 'admin', '2016-12-08 09:27:10', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(66, 'admin', '2016-12-08 09:34:31', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(67, 'admin', '2016-12-08 09:44:53', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(68, 'admin', '2016-12-08 09:49:39', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(69, 'admin', '2016-12-08 10:48:27', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(70, 'admin', '2016-12-08 10:50:26', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(71, 'admin', '2016-12-08 10:54:04', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(72, 'admin', '2016-12-08 11:21:03', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(73, 'admin', '2016-12-08 13:40:37', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(74, 'admin', '2016-12-08 14:02:34', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(75, 'admin', '2016-12-08 15:14:41', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(76, 'admin', '2016-12-09 08:29:13', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(77, 'admin', '2016-12-09 09:27:07', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1'),
	(78, 'admin', '2016-12-09 09:59:08', '电脑端登陆', '用户名密码登陆', '0:0:0:0:0:0:0:1');
/*!40000 ALTER TABLE `system_logs` ENABLE KEYS */;


-- 导出  表 mcm.system_menu 结构
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE IF NOT EXISTS `system_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `NAME` varchar(60) DEFAULT NULL COMMENT '菜单名称',
  `URL` varchar(128) DEFAULT NULL COMMENT '菜单',
  `PARENT_ID` varchar(64) DEFAULT NULL COMMENT '父节点',
  `TYPE` varchar(12) DEFAULT NULL COMMENT '类型',
  `PERMISSION` varchar(128) DEFAULT NULL COMMENT '权限',
  `STATUS` varchar(12) NOT NULL COMMENT '状态',
  `IMG_URL` varchar(256) DEFAULT NULL COMMENT '图片保存路径',
  `ORDER_ID` decimal(8,2) DEFAULT NULL COMMENT '排序序号',
  `MENU_CODE` varchar(64) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- 正在导出表  mcm.system_menu 的数据：~10 rows (大约)
DELETE FROM `system_menu`;
/*!40000 ALTER TABLE `system_menu` DISABLE KEYS */;
INSERT INTO `system_menu` (`ID`, `NAME`, `URL`, `PARENT_ID`, `TYPE`, `PERMISSION`, `STATUS`, `IMG_URL`, `ORDER_ID`, `MENU_CODE`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, '部门管理', '/pages/platform/jsp/org/org.jsp', 'M0000039', NULL, NULL, '0', NULL, 10.30, 'M0000042', NULL, NULL, NULL, 'admin'),
	(2, '消息管理', '/pages/platform/jsp/message/message.jsp', 'M0000039', NULL, NULL, '0', NULL, 10.60, 'M0000045', NULL, NULL, NULL, 'admin'),
	(3, '系统管理', NULL, '0', NULL, NULL, '0', 'pages/platform/images/icon (10).png', 10.00, 'M0000039', NULL, NULL, NULL, 'admin'),
	(4, '首页', '/pages/platform/jsp/home/main.jsp', 'M0000001', NULL, NULL, '0', NULL, 1.10, 'M0000002', NULL, NULL, NULL, 'zhouh'),
	(5, '人员管理', '/pages/platform/jsp/user/index.jsp', 'M0000039', NULL, NULL, '0', NULL, 10.10, 'M0000040', NULL, NULL, NULL, 'admin'),
	(6, '角色管理', '/pages/platform/jsp/role/index.jsp', 'M0000039', NULL, NULL, '0', NULL, 10.20, 'M0000041', NULL, NULL, NULL, 'admin'),
	(7, '菜单管理', '/pages/platform/jsp/menu/menu.jsp', 'M0000039', NULL, NULL, '0', NULL, 10.40, 'M0000043', NULL, NULL, NULL, 'admin'),
	(8, '日志管理', '/pages/platform/jsp/log/log.jsp', 'M0000039', NULL, NULL, '0', NULL, 10.70, 'M0000046', NULL, NULL, NULL, 'admin'),
	(9, '首页', NULL, '0', NULL, NULL, '0', 'pages/platform/images/icon (1).png', 1.00, 'M0000001', NULL, NULL, NULL, 'zhouh'),
	(10, '字典管理', '/pages/platform/jsp/dict/dict.jsp', 'M0000039', NULL, NULL, '0', NULL, 10.50, 'M0000044', NULL, NULL, NULL, 'admin');
/*!40000 ALTER TABLE `system_menu` ENABLE KEYS */;


-- 导出  表 mcm.system_message 结构
DROP TABLE IF EXISTS `system_message`;
CREATE TABLE IF NOT EXISTS `system_message` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(640) DEFAULT NULL COMMENT '消息标题',
  `TYPE` varchar(12) DEFAULT NULL COMMENT '消息类型,此处需关联dict表,分为:检修通知、紧急处缺通知、评论回复通知、审核通知四种类型.',
  `SENDER` varchar(128) DEFAULT NULL COMMENT '发送人',
  `RECIPIENT` varchar(128) DEFAULT NULL COMMENT '接收人',
  `CONTENT` varchar(512) DEFAULT NULL COMMENT '消息内容',
  `TIMES` datetime DEFAULT NULL COMMENT '时间',
  `MESSAGE_CODE` varchar(64) DEFAULT NULL COMMENT '消息编码',
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `STATUS` char(1) DEFAULT NULL COMMENT '消息状态  0:未读 1:已读',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_message 的数据：~1 rows (大约)
DELETE FROM `system_message`;
/*!40000 ALTER TABLE `system_message` DISABLE KEYS */;
INSERT INTO `system_message` (`ID`, `TITLE`, `TYPE`, `SENDER`, `RECIPIENT`, `CONTENT`, `TIMES`, `MESSAGE_CODE`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`, `STATUS`) VALUES
	(1, 'TESTE', 'HEHE', 'ADMIN', 'DDD', 'ZHEGE', '2016-12-07 12:53:07', '2', NULL, NULL, NULL, 'admin', NULL);
/*!40000 ALTER TABLE `system_message` ENABLE KEYS */;


-- 导出  表 mcm.system_org 结构
DROP TABLE IF EXISTS `system_org`;
CREATE TABLE IF NOT EXISTS `system_org` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ORG_CODE` varchar(64) DEFAULT NULL,
  `ORG_NAME` varchar(64) DEFAULT NULL,
  `PARENT_ID` varchar(64) DEFAULT NULL,
  `DEL_FLAG` varchar(12) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_org 的数据：~4 rows (大约)
DELETE FROM `system_org`;
/*!40000 ALTER TABLE `system_org` DISABLE KEYS */;
INSERT INTO `system_org` (`ID`, `ORG_CODE`, `ORG_NAME`, `PARENT_ID`, `DEL_FLAG`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, 'ORG00110', '技术服务部', 'ORG00001', '0', NULL, 'admin', NULL, 'admin'),
	(2, 'ORG00001', '创德软件', '0', '0', NULL, NULL, NULL, NULL),
	(3, 'ORG00111', '新增节点', 'ORG00001', '1', NULL, 'admin', NULL, 'admin'),
	(4, 'ORG00002', '技术中心', 'ORG00001', '0', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `system_org` ENABLE KEYS */;


-- 导出  表 mcm.system_resource 结构
DROP TABLE IF EXISTS `system_resource`;
CREATE TABLE IF NOT EXISTS `system_resource` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(200) DEFAULT NULL COMMENT '权限名称',
  `URL` varchar(200) DEFAULT NULL,
  `MENU_CODE` varchar(64) DEFAULT NULL COMMENT '关联菜单',
  `TYPE` varchar(100) DEFAULT NULL COMMENT 'url 或者是 button',
  `PERMISSION` varchar(200) DEFAULT NULL COMMENT '权限字符串',
  `SHOW_IN_FRONT` varchar(100) DEFAULT NULL COMMENT '是否展示在前台',
  `PIC_NAME` varchar(200) DEFAULT NULL COMMENT '菜单图标名称（图片名称）',
  `RES_CODE` varchar(64) DEFAULT NULL COMMENT '资源编编码 保证命名能见名知意 知道是那些权限',
  `RES_TYPE` varchar(12) DEFAULT NULL COMMENT '资源类型(0为系统资源，1为业务资源)',
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_resource 的数据：~21 rows (大约)
DELETE FROM `system_resource`;
/*!40000 ALTER TABLE `system_resource` DISABLE KEYS */;
INSERT INTO `system_resource` (`ID`, `NAME`, `URL`, `MENU_CODE`, `TYPE`, `PERMISSION`, `SHOW_IN_FRONT`, `PIC_NAME`, `RES_CODE`, `RES_TYPE`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, '人员管理查询', NULL, 'M0000040', 'button', 'UserController:queryUserNeed', NULL, NULL, 'SYSTEM:USER:queryUserNeed', NULL, NULL, NULL, NULL, NULL),
	(2, '菜单管理添加根节点', NULL, 'M0000043', 'button', 'MenusController:insertParent', NULL, NULL, 'SYSTEM:MENU:insertParent', NULL, NULL, NULL, NULL, NULL),
	(3, '字典管理字典查询', NULL, 'M0000044', 'button', 'DictController:querydict', NULL, NULL, 'SYSTEM:DICT:querydict', NULL, NULL, NULL, NULL, NULL),
	(4, '角色管理当前角色下人员查询', NULL, 'M0000041', 'button', 'RoleController:queryRoleUserPage', NULL, NULL, 'SYSTEM:ROLE:queryRoleUserPage', NULL, NULL, NULL, NULL, NULL),
	(5, '菜单管理菜单查询', NULL, 'M0000043', 'button', 'MenusController:selMenuTree', NULL, NULL, 'SYSTEM:MENU:selMenuTree', NULL, NULL, NULL, NULL, NULL),
	(6, '角色管理菜单权限查询', NULL, 'M0000041', 'button', 'RoleController:selectMenuTree', NULL, NULL, 'SYSTEM:ROLE:selectMenuTree', NULL, NULL, NULL, NULL, NULL),
	(7, '消息管理消息查询', NULL, 'M0000045', 'button', 'MessageController:querymessage', NULL, NULL, 'SYSTEM:MESSAGE:querymessage', NULL, NULL, NULL, NULL, NULL),
	(8, '菜单管理添加子节点', NULL, 'M0000043', 'button', 'MenusController:insertChild', NULL, NULL, 'SYSTEM:MENU:insertChild', NULL, NULL, NULL, NULL, NULL),
	(9, '角色菜单新增角色', NULL, 'M0000041', 'button', 'RoleController:insert', NULL, NULL, 'SYSTEM:ROLE:insert', NULL, NULL, NULL, NULL, NULL),
	(10, '日志管理日志查询', NULL, 'M0000046', 'button', 'LogController:sellogs', NULL, NULL, 'SYSTEM:LOG:sellogs', NULL, NULL, NULL, NULL, NULL),
	(11, '部门管理部门人员查询', NULL, 'M0000042', 'button', 'OrgController:selUser', NULL, NULL, 'SYSTEM:ORG:selUser', NULL, NULL, NULL, NULL, NULL),
	(12, '部门管理当前部门下人员查询', NULL, 'M0000042', 'button', 'OrgController:selOrgUser', NULL, NULL, 'SYSTEM:ORG:selOrgUser', NULL, NULL, NULL, NULL, NULL),
	(13, '字典管理新增字典', NULL, 'M0000044', 'button', 'DictController:addDict', NULL, NULL, 'SYSTEM:DICT:addDict', NULL, NULL, NULL, NULL, NULL),
	(14, '人员管理修改', NULL, 'M0000040', 'button', 'UserController:delete', NULL, NULL, 'SYSTEM:USER:delete', NULL, NULL, NULL, NULL, NULL),
	(15, '人员管理重置密码', NULL, 'M0000040', 'button', 'UserController:resetPassWord', NULL, NULL, 'SYSTEM:USER:resetPassWord', NULL, NULL, NULL, NULL, NULL),
	(16, '人员管理删除', NULL, 'M0000040', 'button', 'UserController:update', NULL, NULL, 'SYSTEM:USER:update', NULL, NULL, NULL, NULL, NULL),
	(17, '角色管理角色查询', NULL, 'M0000041', 'button', 'RoleController:queryRoleNeed', NULL, NULL, 'SYSTEM:ROLE:queryRoleNeed', NULL, NULL, NULL, NULL, NULL),
	(18, '角色管理当前角色下人员分配查询', NULL, 'M0000041', 'button', 'RoleController:queryRoleUserNOTIN', NULL, NULL, 'SYSTEM:ROLE:queryRoleUserNOTIN', NULL, NULL, NULL, NULL, NULL),
	(19, '字典管理新增类别', NULL, 'M0000044', 'button', 'DictController:addDictType', NULL, NULL, 'SYSTEM:DICT:addDictType', NULL, NULL, NULL, NULL, NULL),
	(20, '人员管理添加', NULL, 'M0000040', 'button', 'UserController:insert', NULL, NULL, 'SYSTEM:USER:insert', NULL, NULL, NULL, NULL, NULL),
	(21, '部门管理部门查询', NULL, 'M0000042', 'button', 'OrgController:selOrgTree', NULL, NULL, 'SYSTEM:ORG:selOrgTree', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `system_resource` ENABLE KEYS */;


-- 导出  表 mcm.system_role 结构
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE IF NOT EXISTS `system_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_CODE` varchar(10) DEFAULT NULL,
  `ROLE_NAME` varchar(100) NOT NULL,
  `ROLE_DESC` varchar(640) DEFAULT NULL,
  `DEL_FLAG` varchar(12) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_role 的数据：~5 rows (大约)
DELETE FROM `system_role`;
/*!40000 ALTER TABLE `system_role` DISABLE KEYS */;
INSERT INTO `system_role` (`ID`, `ROLE_CODE`, `ROLE_NAME`, `ROLE_DESC`, `DEL_FLAG`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, 'R0000009', '管理员', NULL, '0', NULL, NULL, NULL, NULL),
	(2, 'R0000111', '测试角色', '测试数据', '0', NULL, NULL, NULL, NULL),
	(3, 'R0000110', 'kiover', 'kiover1', '1', NULL, NULL, NULL, NULL),
	(4, 'R0000112', '测试', 'asS', '0', NULL, NULL, NULL, NULL),
	(5, 'R0000113', 'CESHI', 'AS', '0', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `system_role` ENABLE KEYS */;


-- 导出  表 mcm.system_role_menu 结构
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE IF NOT EXISTS `system_role_menu` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `MENU_CODE` varchar(64) DEFAULT NULL,
  `ROLE_CODE` varchar(64) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_role_menu 的数据：~10 rows (大约)
DELETE FROM `system_role_menu`;
/*!40000 ALTER TABLE `system_role_menu` DISABLE KEYS */;
INSERT INTO `system_role_menu` (`ID`, `MENU_CODE`, `ROLE_CODE`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, 'M0000042', 'R0000009', NULL, NULL, NULL, NULL),
	(2, 'M0000044', 'R0000009', NULL, NULL, NULL, NULL),
	(3, 'M0000045', 'R0000009', NULL, NULL, NULL, NULL),
	(4, 'M0000043', 'R0000009', NULL, NULL, NULL, NULL),
	(5, 'M0000046', 'R0000009', NULL, NULL, NULL, NULL),
	(6, 'M0000039', 'R0000009', NULL, NULL, NULL, NULL),
	(7, 'M0000001', 'R0000009', NULL, NULL, NULL, NULL),
	(8, 'M0000002', 'R0000009', NULL, NULL, NULL, NULL),
	(9, 'M0000041', 'R0000009', NULL, NULL, NULL, NULL),
	(10, 'M0000040', 'R0000009', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `system_role_menu` ENABLE KEYS */;


-- 导出  表 mcm.system_role_resource 结构
DROP TABLE IF EXISTS `system_role_resource`;
CREATE TABLE IF NOT EXISTS `system_role_resource` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STATUS` varchar(12) DEFAULT '1' COMMENT '0：生效  1：无效',
  `ROLE_CODE` varchar(64) DEFAULT NULL COMMENT '角色编码',
  `RES_CODE` varchar(64) DEFAULT NULL COMMENT '资源编码',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_role_resource 的数据：~21 rows (大约)
DELETE FROM `system_role_resource`;
/*!40000 ALTER TABLE `system_role_resource` DISABLE KEYS */;
INSERT INTO `system_role_resource` (`ID`, `STATUS`, `ROLE_CODE`, `RES_CODE`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, '0', 'R0000009', 'SYSTEM:USER:update', NULL, NULL, NULL, NULL),
	(2, '0', 'R0000009', 'SYSTEM:ROLE:queryRoleUserNOTIN', NULL, NULL, NULL, NULL),
	(3, '0', 'R0000009', 'SYSTEM:ORG:selUser', NULL, NULL, NULL, NULL),
	(4, '0', 'R0000009', 'SYSTEM:USER:resetPassWord', NULL, NULL, NULL, NULL),
	(5, '0', 'R0000009', 'SYSTEM:ROLE:queryRoleUserPage', NULL, NULL, NULL, NULL),
	(6, '0', 'R0000009', 'SYSTEM:ROLE:queryRoleNeed', NULL, NULL, NULL, NULL),
	(7, '0', 'R0000009', 'SYSTEM:MENU:selMenuTree', NULL, NULL, NULL, NULL),
	(8, '0', 'R0000009', 'SYSTEM:ORG:selOrgTree', NULL, NULL, NULL, NULL),
	(9, '0', 'R0000009', 'SYSTEM:USER:queryUserNeed', NULL, NULL, NULL, NULL),
	(10, '0', 'R0000009', 'SYSTEM:MESSAGE:querymessage', NULL, NULL, NULL, NULL),
	(11, '0', 'R0000009', 'SYSTEM:MENU:insertParent', NULL, NULL, NULL, NULL),
	(12, '0', 'R0000009', 'SYSTEM:ROLE:insert', NULL, NULL, NULL, NULL),
	(13, '0', 'R0000009', 'SYSTEM:ROLE:selectMenuTree', NULL, NULL, NULL, NULL),
	(14, '0', 'R0000009', 'SYSTEM:MENU:insertChild', NULL, NULL, NULL, NULL),
	(15, '0', 'R0000009', 'SYSTEM:DICT:addDict', NULL, NULL, NULL, NULL),
	(16, '0', 'R0000009', 'SYSTEM:DICT:querydict', NULL, NULL, NULL, NULL),
	(17, '0', 'R0000009', 'SYSTEM:DICT:addDictType', NULL, NULL, NULL, NULL),
	(18, '0', 'R0000009', 'SYSTEM:ORG:selOrgUser', NULL, NULL, NULL, NULL),
	(19, '0', 'R0000009', 'SYSTEM:USER:delete', NULL, NULL, NULL, NULL),
	(20, '0', 'R0000009', 'SYSTEM:USER:insert', NULL, NULL, NULL, NULL),
	(21, '0', 'R0000009', 'SYSTEM:LOG:sellogs', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `system_role_resource` ENABLE KEYS */;


-- 导出  表 mcm.system_role_user 结构
DROP TABLE IF EXISTS `system_role_user`;
CREATE TABLE IF NOT EXISTS `system_role_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_CODE` varchar(64) DEFAULT NULL,
  `USER_CODE` varchar(64) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_role_user 的数据：~1 rows (大约)
DELETE FROM `system_role_user`;
/*!40000 ALTER TABLE `system_role_user` DISABLE KEYS */;
INSERT INTO `system_role_user` (`ID`, `ROLE_CODE`, `USER_CODE`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, 'R0000009', 'admin', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `system_role_user` ENABLE KEYS */;


-- 导出  表 mcm.system_user 结构
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE IF NOT EXISTS `system_user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_CODE` varchar(64) DEFAULT NULL,
  `USER_NAME` varchar(64) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `DEL_FLAG` varchar(12) DEFAULT NULL,
  `STATUS` varchar(12) DEFAULT NULL,
  `JOB_NUM` varchar(64) DEFAULT NULL,
  `CELL_PHONE` varchar(64) DEFAULT NULL,
  `ICON` varchar(128) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_user 的数据：~3 rows (大约)
DELETE FROM `system_user`;
/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` (`ID`, `USER_CODE`, `USER_NAME`, `PASSWORD`, `DEL_FLAG`, `STATUS`, `JOB_NUM`, `CELL_PHONE`, `ICON`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, 'kiover', '测试3', '123', '1', '1', '12345', '123909773', NULL, NULL, 'admin', NULL, 'admin'),
	(2, 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', '0', '1', '000000', NULL, NULL, NULL, NULL, NULL, NULL),
	(3, 'FA', 'FA', 'FA', '1', '1', '0003', '1234', NULL, NULL, 'admin', NULL, 'admin');
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;


-- 导出  表 mcm.system_user_org 结构
DROP TABLE IF EXISTS `system_user_org`;
CREATE TABLE IF NOT EXISTS `system_user_org` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_CODE` varchar(64) DEFAULT NULL COMMENT '用户编码',
  `ORG_CODE` varchar(64) DEFAULT NULL COMMENT '部门编码',
  `UPDATE_TIME` datetime DEFAULT NULL,
  `UPDATE_USER` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_user_org 的数据：~4 rows (大约)
DELETE FROM `system_user_org`;
/*!40000 ALTER TABLE `system_user_org` DISABLE KEYS */;
INSERT INTO `system_user_org` (`ID`, `USER_CODE`, `ORG_CODE`, `UPDATE_TIME`, `UPDATE_USER`, `CREATE_TIME`, `CREATE_USER`) VALUES
	(1, 'admin', 'ORG00110', NULL, NULL, NULL, NULL),
	(2, 'FA', 'ORG00110', NULL, NULL, NULL, NULL),
	(3, 'kiover', 'ORG00110', NULL, NULL, NULL, NULL),
	(4, NULL, 'ORG00002', NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `system_user_org` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- 导出  表 mcm.system_file 结构
DROP TABLE IF EXISTS `system_file`;
CREATE TABLE IF NOT EXISTS `system_file` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  FILE_NAME   VARCHAR(64) DEFAULT NULL,
  FILE_CODE   VARCHAR(64) DEFAULT NULL,
  FILE_DEC    VARCHAR(400) DEFAULT NULL,
  FILE_SIZE   INTEGER DEFAULT NULL,
  FILE_TYPE   VARCHAR(10) DEFAULT NULL,
  STATUS      VARCHAR(6) default '0',
  IS_DEL      CHAR(1) default '0',
  FILE_URL    VARCHAR(200) DEFAULT NULL,
  CATEGORY    VARCHAR(2) DEFAULT NULL,
  CREATE_TIME DATE,
  UPDATE_TIME DATE,
  CREATE_USER VARCHAR(64),
  UPDATE_USER VARCHAR(64),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  mcm.system_file 的数据：~0 rows (大约)
DELETE FROM `system_file`;
/*!40000 ALTER TABLE `system_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_file` ENABLE KEYS */;
