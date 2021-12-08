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

 Date: 21/10/2021 19:19:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for device_state_history
-- ----------------------------
DROP TABLE IF EXISTS `device_state_history`;
CREATE TABLE `device_state_history`  (
  `seq` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '순번',
  `device_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '디바이스 ID',
  `device_state` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '상태 코드\r\nEx) \"start\" -> 광고 화면의 첫 시작을 알림 \r\n     \"resume\" -> 광고 화면이 활성화 되어 광고를 시작 하는 상태\r\n    \"pause\" -> 광고 화면이 무언가에 의해 일부분이 가려진 상태\r\n     (앱 실행중 팝업과 같은 화면이 노출된 상태) \r\n    \"stop\"  -> 광고 화면의 전체가 사라진 상태\r\n     (앱 실해중 홈으로 이동등) \r\n    \"destroy\" -> 광고 APP 이 종료된 상태',
  `content_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '컨텐츠 id',
  `reg_date` datetime(0) NULL DEFAULT NULL COMMENT '생성 날짜',
  PRIMARY KEY (`seq`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '디바이스 상태 히스토리' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
