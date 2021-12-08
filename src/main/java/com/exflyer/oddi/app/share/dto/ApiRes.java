package com.exflyer.oddi.app.share.dto;


import com.exflyer.oddi.app.enums.ApiResponseCodes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApiRes {

  @ApiModelProperty(value = "코드", position = 1)
  private String code;

  @ApiModelProperty(value = "메세지", position = 2)
  private String message;

  public ApiRes(ApiResponseCodes ok){
    ApiResponseCodes responseCode = ApiResponseCodes.OK;
    this.code = responseCode.getCode();
    this.message = responseCode.getMessage();
  }

}
