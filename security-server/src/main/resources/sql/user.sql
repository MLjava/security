/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : 127.0.0.1:3306
 Source Schema         : security

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 03/11/2018 19:53:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `flag` smallint(4) UNSIGNED NULL DEFAULT 0,
  `add_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `lock` smallint(4) UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2018-11-013ff5317f-00a9-4af3-8b7c-3fe6f9f5c5dc', 'admin', '$2a$10$BbIr0x3o2LP.FW/Lbs8Q3.qQOI.supqDHfnyYcJeewFXEJNKm.DHe', '管理员', NULL, '2018-11-02 18:11:52', 0, '2018-11-02 18:11:52', 0);
INSERT INTO `user` VALUES ('2018-11-023ff5317f-00a9-4af3-8b7c-3fe6f9f5cadc', 'common', '$2a$10$BbIr0x3o2LP.FW/Lbs8Q3.qQOI.supqDHfnyYcJeewFXEJNKm.DHe', '普通人', NULL, '2018-11-02 18:11:55', 0, '2018-11-02 18:11:55', 0);

SET FOREIGN_KEY_CHECKS = 1;
