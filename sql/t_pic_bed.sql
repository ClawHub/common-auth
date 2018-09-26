/*
 Navicat Premium Data Transfer

 Source Server         : 192.144.192.190
 Source Server Type    : MySQL
 Source Server Version : 50077
 Source Host           : 192.144.192.190:53306
 Source Schema         : common

 Target Server Type    : MySQL
 Target Server Version : 50077
 File Encoding         : 65001

 Date: 26/09/2018 14:37:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_pic_bed
-- ----------------------------
DROP TABLE IF EXISTS `t_pic_bed`;
CREATE TABLE `t_pic_bed`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图片路径',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
