/*
 Navicat MySQL Data Transfer

 Source Server         : javacamp
 Source Server Version : 50552
 Source Host           : 127.0.0.1
 Source Database       : Templage

 Target Server Version : 50552
 File Encoding         : utf-8

 Date: 11/28/2016 16:09:17 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('5', 'xiaoming', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-28 17:24:22', '0'), ('6', 'hello', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-28 17:24:47', '0'), ('7', 'userTest', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-28 17:25:41', '0'), ('8', 'lalala', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-28 17:26:09', '0'), ('9', 'tmac', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-28 17:26:13', '0'), ('10', 'kobe', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-28 17:26:24', '0'), ('11', 'admin', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-28 17:27:16', '0'), ('13', 'moto', '11111', '18900001111', '124668179@qq.com', '1', '2016-10-30 18:29:05', '0'), ('16', 'admin111', '11111', '15301588831', '15301588831@189.cn', '1', '2016-10-31 15:02:33', '0'), ('17', 'wx', '11111', '18915521496', '18915521496@189.cn', '1', '2016-10-31 15:02:33', '0'), ('18', 'lyglfw', '111111', '13357861875', '13357861875@189.cn', '1', '2016-11-08 15:23:45', '0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
