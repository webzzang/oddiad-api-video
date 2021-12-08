package com.exflyer.oddi.app.api.device.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DevicePushReq {

	@NotBlank
	@ApiModelProperty(value = "디바이스 생성시 받은 ID 값", example = "pmpnzd", required = true, position = 0)
	private String device_id;

	@ApiModelProperty(value = "액션 코드Ex)  \"device_create\" -> 디바이스 생성 성공으로 다음광고 화면 으로 진행요청  \"finish_app\" -> APP 종료처리  \"restart_app\" -> APP 재시작처리 \"request_main_ad\" -> 메인 광고 리스트 변경알림\"request_side_ad\" -> 오른쪽 배너 광고 리스트 변경알림 \"request_bottom_ad\" -> 하단 배너 광고 리스트 변경알림 \"set_ad_screen_type\" -> 화면 분할을 강제 변경 알림 ", example = "device_create", required = true, position = 1)
	private String action;

	@ApiModelProperty(value = "action 이 \"set_ad_screen_type\" 일때는 필수\nEx) \"divisions_1\" -> 메인광고 full 화면\n\"divisions_2\" -> 메인광고 + 오른쪽 배너 광고 화면 \n\"divisions_3\" -> 메인광고 + 오른쪽 배너 + 하단 배너 광고 화면  ", example = "divisions_3", position = 2)
	private String screen_type;
}
