/*
 Navicat Premium Data Transfer

 Source Server         : 개발DB
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : ls-a2834d111b7d0d1385ca4360b6718cf409b75eff.cvxedmimklz0.ap-northeast-2.rds.amazonaws.com:3306
 Source Schema         : oddi_ad

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 26/10/2021 08:36:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_fcm_history
-- ----------------------------
DROP TABLE IF EXISTS `device_fcm_history`;
CREATE TABLE `device_fcm_history`  (
  `seq` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '순번',
  `device_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스 ID',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT 'SEND : FCM 발송, RECEP : 디바이스 FCM 수신',
  `push_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT 'FCM 수신시 전달받은 ID 값',
  `action` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '액션 코드',
  `screen_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '스크린 타입 \r\n\"action이 \"set_ad_screen_type\" 일때는 필수 \r\n      Ex) \"divisions_1\" -> 메인광고 full 화면 \r\n           \"divisions_2\" -> 메인광고 + 오른쪽 배너 광고 화면 \r\n           \"divisions_3\" -> 메인광고 + 오른쪽 배너 + 하단 배너 광고 화면 ',
  `reg_date` datetime(0) NULL DEFAULT NULL COMMENT '생성 날짜',
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '안드로이드 FCM 수신 체크 이력' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
