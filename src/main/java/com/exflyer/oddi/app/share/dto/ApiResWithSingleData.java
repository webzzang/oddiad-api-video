package com.exflyer.oddi.app.share.dto;

import com.exflyer.oddi.app.enums.ApiResponseCodes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApiResWithSingleData<T> {
  @ApiModelProperty(value = "코드", position = 1)
  private String code;

  @ApiModelProperty(value = "메세지", position = 2)
  private String message;

  @ApiModelProperty(value = "데이터", position = 3)
  private Object data;

  public ApiResWithSingleData(ApiResponseCodes responseCodeEnums) {
    this.code = responseCodeEnums.getCode();
    this.message = responseCodeEnums.getMessage();
  }

  public ApiResWithSingleData(ApiResponseCodes responseCodeEnums, Object responseData) {
    this.code = responseCodeEnums.getCode();
    this.message = responseCodeEnums.getMessage();
    this.data = responseData;
  }

}
