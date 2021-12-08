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

 Date: 21/10/2021 19:18:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_exception_log
-- ----------------------------
DROP TABLE IF EXISTS `device_exception_log`;
CREATE TABLE `device_exception_log`  (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '순번',
  `device_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스 ID',
  `content_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '컨텐츠 id',
  `acc_count` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT 'Exception 카운트 / Exception 이 발생하여 APP 재 시작한 카운트 전달 \r\n 카운트는 APP 시작후 5분후 초기화 하며, 5분안에 반복해서 발생시 카운트를 증가 하며, 그 횟수가 3회가 되면 APP 은 그냥 종료 처리함 ',
  `reg_date` datetime(0) NULL DEFAULT NULL COMMENT '생성 날짜',
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '디바에스 APP 에러 로그' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
