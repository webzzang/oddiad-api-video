/*
 Navicat Premium Data Transfer

 Source Server         : 로컬용 DB
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : ls-407e4b156de499a36a744f356681864a305ab178.cvxedmimklz0.ap-northeast-2.rds.amazonaws.com:3306
 Source Schema         : oddi_ad

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 21/10/2021 19:19:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_info
-- ----------------------------
DROP TABLE IF EXISTS `device_info`;
CREATE TABLE `device_info`  (
  `device_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스 ID',
  `fcm_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '토큰(PUSH 발송용)',
  `device_model` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스 모델명 (ex. TCL tv, Chromecast)',
  `android_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스에 설치된 Android id 값(os 가 재설치 되기 전까지 유니크)',
  `reg_date` datetime(0) NOT NULL COMMENT '생성 날짜',
  `reg_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '생성 id',
  `mod_date` datetime(0) NULL DEFAULT NULL COMMENT '변경 날짜',
  `mod_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '변경 id',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '디바이스 정보' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
