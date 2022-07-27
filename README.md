# delayQueue_Redisson

基于SpringBoot 实现了一个延时队列监听机制，可通过@delay 实现自动补偿机制。

其中涉及到的表：
/*
 Navicat Premium Data Transfer

 Source Server         : cheche
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : helen

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 26/07/2022 16:57:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint(0) NOT NULL COMMENT '状态-1正常 2-隐藏',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '更新时间',
  `is_deleted` tinyint(0) NULL DEFAULT 0 COMMENT '是否删除 0 未删除 1 已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES (1, 'helen', 1, '2022-07-25 18:11:22', '2022-07-25 18:11:27', 0);
INSERT INTO `people` VALUES (2, 'leaf', 0, '2022-07-25 18:13:10', '2022-07-25 18:13:15', 0);

SET FOREIGN_KEY_CHECKS = 1;
