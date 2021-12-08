package com.exflyer.oddi.app.api.device.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeviceStateReq {

	@NotBlank
	@ApiModelProperty(value = "디바이스 생성시 받은 ID 값", example = "pmpnzd", required = true, position = 0)
	private String device_id;

	@ApiModelProperty(value = "상태정보\"start\" -> 광고 화면의 첫 시작을 알림\n\"resume\" -> 광고 화면이 활성화 되어 광고를 시작 하는 상태\n\"pause\" -> 광고 화면이 무언가에 의해 일부분이 가려진 상태\n (앱 실행중 팝업과 같은 화면이 노출된 상태)\n\"stop\"  -> 광고 화면의 전체가 사라진 상태\n (앱 실해중 홈으로 이동등)\n\"destroy\" -> 광고 APP 이 종료된 상태\n", example = "start", position = 2)
	private String device_state;
	
	@ApiModelProperty(value = "재생 하던 컨텐츠 ID", example = "main1", position = 1)
	private String content_id;

	

}
