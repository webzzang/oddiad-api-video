package com.exflyer.oddi.app.api.device.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DeviceException {

	@NotBlank
	@ApiModelProperty(value = "디바이스 생성시 받은 ID 값", example = "pmpnzd", required = true, position = 0)
	private String device_id;

	@ApiModelProperty(value = "Exception 이 발생하여 APP 재 시작한 카운트 전달 카운트는 APP 시작후 5분후 초기화 하며, 5분안에 반복해서 발생시 카운트를 증가 하며, 그 횟수가 3회가 되면 APP 은 그냥 종료 처리함 ", example = "1", position = 3)
	private String acc_count;

}
