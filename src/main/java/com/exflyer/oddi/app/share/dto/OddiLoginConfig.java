package com.exflyer.oddi.app.share.dto;

import lombok.Data;

@Data
public class OddiLoginConfig {

  private Integer managerPasswordModDayCount;
  private Integer memberPasswordModDayCount;
  private Integer managerTokenExpiredMin;
  private Integer memberTokenExpiredMin;

}
