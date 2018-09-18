/*
 Navicat MySQL Data Transfer

 Source Server         : 54.251.186.84
 Source Server Type    : MySQL
 Source Server Version : 50077
 Source Host           : 54.251.186.84:53306
 Source Schema         : common

 Target Server Type    : MySQL
 Target Server Version : 50077
 File Encoding         : 65001

 Date: 18/09/2018 10:30:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_role_resource`;
CREATE TABLE `t_role_resource`  (
  `id` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT 'id',
  `create_operator_id` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_operator_name` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_operator_id` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_operator_name` datetime NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未删除,1-已删除',
  `remark` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '备注',
  `role_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色ID',
  `resource_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '资源ID',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_resource
-- ----------------------------
INSERT INTO `t_role_resource` VALUES ('1deda21a94064f699329cf4ce8d5d587', '0', 'admin', 1537237377155, NULL, NULL, NULL, '0', NULL, 'role-29a93c6018ca45cc8d3cf4876d92deef', 'resource-667184756bc14201a63f5b19283d4e0f');
INSERT INTO `t_role_resource` VALUES ('ea575c7b143b497d885354cd09c5255d', '0', 'admin', 1537237377155, NULL, NULL, NULL, '0', NULL, 'role-29a93c6018ca45cc8d3cf4876d92deef', 'resource-6eaf53532b564099bb38551c758cc13c');

-- ----------------------------
-- Table structure for t_sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_resource`;
CREATE TABLE `t_sys_resource`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT 'id',
  `create_operator_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_operator_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_operator_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_operator_name` datetime NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未删除,1-已删除',
  `remark` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '备注',
  `resource_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '资源ID',
  `resource_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '资源名称',
  `resource_type` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '资源类型，[menu|button]',
  `url` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '资源路径',
  `permission` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view',
  `parent_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '父编号列表',
  `state` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未锁定,1-已锁定',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_resource
-- ----------------------------
INSERT INTO `t_sys_resource` VALUES ('5b07936ad4294d22897b82141c8db4f8', '0', 'admin', 1537237005373, NULL, NULL, NULL, '0', NULL, 'resource-6eaf53532b564099bb38551c758cc13c', 'index', 'menu', '/index', 'role:*', '0', '0', '0', 0);
INSERT INTO `t_sys_resource` VALUES ('54379810f61949a2a3d7241925baa119', '0', 'admin', 1537237033873, NULL, NULL, NULL, '0', NULL, 'resource-667184756bc14201a63f5b19283d4e0f', 'autt', 'menu', '/auth', 'auth:*', '0', '0', '0', 0);

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT 'id',
  `create_operator_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_operator_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_operator_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_operator_name` datetime NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未删除,1-已删除',
  `remark` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '备注',
  `role_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色ID',
  `role_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色名称',
  `state` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未锁定,1-已锁定',
  `description` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('73777f5a63b0402f9c759f9dd7302202', '0', 'admin', 1537237375378, NULL, NULL, NULL, '0', NULL, 'role-29a93c6018ca45cc8d3cf4876d92deef', 'admin', '0', 'admin');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT 'id',
  `create_operator_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_operator_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_operator_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_operator_name` datetime NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未删除,1-已删除',
  `remark` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '备注',
  `user_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户ID',
  `username` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '盐',
  `state` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未锁定,1-已锁定',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('0', '0', 'admin', NULL, '0', '0000-00-00 00:00:00', NULL, '0', '?????', '0', 'admin', '928bfd2577490322a6e19b793691467e', 'admin', '0');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `id` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL COMMENT 'id',
  `create_operator_id` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `create_operator_name` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '创建人姓名',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '创建时间',
  `update_operator_id` varchar(256) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '更新人ID',
  `update_operator_name` datetime NULL DEFAULT NULL COMMENT '更新人姓名',
  `update_time` bigint(20) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` char(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '0-未删除,1-已删除',
  `remark` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '备注',
  `user_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户ID',
  `role_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY USING BTREE (`id`)
) ENGINE = MyISAM CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
