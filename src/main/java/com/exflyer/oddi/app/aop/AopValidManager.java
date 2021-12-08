package com.exflyer.oddi.app.aop;

import com.exflyer.oddi.app.jwt.dto.JwtVerifyResult;
import lombok.Data;

@Data
public class AopValidManager {

  private String id;

  private String name;

  public AopValidManager(JwtVerifyResult jwtVerifyResult) {
    this.id = jwtVerifyResult.getId();
    this.name = jwtVerifyResult.getName();
  }
}
