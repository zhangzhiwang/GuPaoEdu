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

 Date: 17/01/2021 23:18:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_id_card
-- ----------------------------
DROP TABLE IF EXISTS `t_id_card`;
CREATE TABLE `t_id_card` (
  `id_card_id` int(11) NOT NULL,
  `id_card_num` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_card_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_id_card
-- ----------------------------
BEGIN;
INSERT INTO `t_id_card` VALUES (1, '130203', 'hebei');
INSERT INTO `t_id_card` VALUES (2, '100000', 'beijing');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
