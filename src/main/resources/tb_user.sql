/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50631
 Source Host           : localhost
 Source Database       : mybatis_demo

 Target Server Version : 50631
 File Encoding         : utf-8

 Date: 02/07/2018 16:54:57 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `password` varchar(100) NOT NULL,
  `gmt_created` datetime NOT NULL,
  `gmt_modified` datetime NOT NULL,
  `is_del` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `tb_user`
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` VALUES ('1', 'admin', 'admin', '2018-02-07 16:54:00', '2018-02-07 16:54:03', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
