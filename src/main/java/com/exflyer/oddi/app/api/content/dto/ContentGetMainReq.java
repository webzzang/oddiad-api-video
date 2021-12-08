package com.exflyer.oddi.app.api.content.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContentGetMainReq {

	  @NotBlank
	  @ApiModelProperty(value = "디바이스 생성시 받은 ID 값", example = "e6ryyj", required = true, position = 0)
	  private String device_id;

	  @ApiModelProperty(value = "디바이스에서 수집된 위치 정보 (위도) 값이 없으면 \"\" 로 전달처리", example = "", position = 1)
	  private String device_latitude;
	  
	  @ApiModelProperty(value = "디바이스에서 수집된 위치 정보 (경도) 값이 없으면 \"\" 로 전달처리", example = "", position = 2)
	  private String device_longitude;
	  
}
