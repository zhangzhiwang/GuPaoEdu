/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : 65001

 Date: 17/01/2021 23:18:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_person
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `person_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `id_card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`person_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_person
-- ----------------------------
BEGIN;
INSERT INTO `t_person` VALUES (1, 'zhangsan', 18, 1);
INSERT INTO `t_person` VALUES (2, 'lisi', 19, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
