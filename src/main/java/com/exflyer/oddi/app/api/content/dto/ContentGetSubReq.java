package com.exflyer.oddi.app.api.content.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContentGetSubReq {

	  @NotBlank
	  @ApiModelProperty(value = "디바이스 생성시 받은 ID 값", example = "e6ryyj", required = true, position = 0)
	  private String device_id;

}
