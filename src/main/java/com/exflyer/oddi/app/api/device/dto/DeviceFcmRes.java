package com.exflyer.oddi.app.api.device.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeviceFcmRes {

	@NotBlank
	@ApiModelProperty(value = "디바이스 생성시 받은 ID 값", example = "pmpnzd", required = true, position = 0)
	private String device_id;

	@ApiModelProperty(value = "FCM 수신시 전달받은 ID 값", example = "pmpnzd_20211025085204", position = 1)
	private String push_id;
}
