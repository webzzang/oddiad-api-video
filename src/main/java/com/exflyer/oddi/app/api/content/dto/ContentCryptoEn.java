package com.exflyer.oddi.app.api.content.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContentCryptoEn {

	  @NotBlank
	  @ApiModelProperty(value = "암호화 할 데이터", example = "암호화", required = true, position = 0)
	  private String value;

	
}
