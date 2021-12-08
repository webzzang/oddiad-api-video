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

 Date: 21/10/2021 19:18:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_broadcasting_call_log
-- ----------------------------
DROP TABLE IF EXISTS `device_broadcasting_call_log`;
CREATE TABLE `device_broadcasting_call_log`  (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '순번',
  `device_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스 ID',
  `position` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'main: 메인, side:사이드, bottom: 하단',
  `broadcasting_cnt` bigint(20) NULL DEFAULT NULL COMMENT '불러온 광고 개수',
  `reg_date` datetime(0) NOT NULL COMMENT '생성 날짜',
  PRIMARY KEY (`seq`, `device_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '디바이스 광고 호출 로그' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
