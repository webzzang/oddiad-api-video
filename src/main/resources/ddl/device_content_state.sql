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

 Date: 25/10/2021 10:16:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_content_state
-- ----------------------------
DROP TABLE IF EXISTS `device_content_state`;
CREATE TABLE `device_content_state`  (
  `device_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스 ID',
  `content_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '컨텐츠 id',
  `content_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '컨텐츠 상태 값\r\nEx) \"start\" -> 컨텐츠의 재생 시작을 알림\r\n     \"end\" -> 컨텐츠 재생의 끝을 알림',
  `content_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '컨텐츠 타입 값 \r\nEx) \"image\" -> 이미지 광고 컨텐츠 \r\n     \"video\" -> 동영상 광고 컨텐츠\r\n',
  `content_screen_position` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '재생중인 광고 영역 값 \r\nEx) \"screen_pos_main\" -> 메인화면 광고중 \r\n     \"screen_pos_side\" ->  우측화면 광고중\r\n     \"screen_pos_bottom\" ->  하단영역 광고중',
  `content_screen_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '재생중인 광고 스크린 타입\r\nEx) \"divisions_1\" -> 메인광고 full 화면 \r\n     \"divisions_2\" -> 메인광고 + 오른쪽 배너 광고 화면 \r\n     \"divisions_3\" -> 메인광고 + 오른쪽 배너 + 하단 배너 광고 화면 ',
  `mod_date` datetime(0) NULL DEFAULT NULL COMMENT '변경 날짜',
  PRIMARY KEY (`device_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '컨텐츠(재생) 상태' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
