package com.exflyer.oddi.app.enums;

import lombok.Getter;

public enum ApiResponseCodes {

  OK(200, "200", "SUCCESS"),
  NOT_DUPLICATE(200, "000", "중복 되지 않은 정보 입니다."),
  BAD_REQUEST(400, "001", "잘못된 요청 입니다."),
  NOT_FOUND(404, "002", "정보를 찾을 수 없습니다."),
  TOKEN_EXPIRED(401, "003", "토큰이 만료 되었습니다."),
  AUTHENTIFICATION(401, "004", "인증 정보가 잘못 되었습니다."),
  MISS_MATCH(400, "005", "정보가 일치 하지 않습니다."),
  DUPLICATE(400, "007", "중복된 정보 입니다."),
  FORBIDDEN(403, "008", "접근 권한이 없습니다."),
  NEED_TO_PASSWORD_CHANGED(200, "009", "비밀번호 변경이 필요 합니다."),
  PASSWORD_CHANGE_DAY_OVER(200, "010", "비밀번호 변경 주기가 지났습니다."),
  EXPIRED_REQ_TIME(400, "010", "요청 시간이 초과 되었습니다."),

  INTERNAL(500, "999", "관리자에게 문의 하세요")
  ;


  @Getter
  private final int status;

  @Getter
  private final String code;

  @Getter
  private final String message;


  ApiResponseCodes(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;

  }
}
