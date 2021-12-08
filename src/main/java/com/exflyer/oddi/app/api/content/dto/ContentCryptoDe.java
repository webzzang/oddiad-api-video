package com.exflyer.oddi.app.api.content.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContentCryptoDe {

	  @NotBlank
	  @ApiModelProperty(value = "복호화 할 데이터", example = "oRxdo3xQuIRWVFzotgO9/Q==", required = true, position = 0)
	  private String value;

	
}
