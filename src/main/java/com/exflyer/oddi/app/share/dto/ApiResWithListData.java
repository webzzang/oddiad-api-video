package com.exflyer.oddi.app.share.dto;

import com.exflyer.oddi.app.enums.ApiResponseCodes;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ApiResWithListData<T> {
  @ApiModelProperty(value = "코드", position = 1)
  private String code;

  @ApiModelProperty(value = "메세지", position = 2)
  private String message;

  @ApiModelProperty(value = "데이터", position = 3)
  private List<T> data;

  public ApiResWithListData(ApiResponseCodes responseCodeEnums) {
    this.code = responseCodeEnums.getCode();
    this.message = responseCodeEnums.getMessage();
    this.data = new ArrayList<>();
  }

  public ApiResWithListData(ApiResponseCodes responseCodeEnums, List<T> responseDate) {
    this.code = responseCodeEnums.getCode();
    this.message = responseCodeEnums.getMessage();
    this.data = responseDate;
  }

}
