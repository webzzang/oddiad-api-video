package com.exflyer.oddi.app.api.content.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContentStateReq {

	  @NotBlank
	  @ApiModelProperty(value = "디바이스 생성시 받은 ID 값", example = "e6ryyj", required = true, position = 0)
	  private String device_id;

	  @ApiModelProperty(value = "컨텐츠 ID", example = "main1", position = 1)
	  private String content_id;
	  
	  @ApiModelProperty(value = "컨텐츠 상태 값 \n start -> 컨텐츠의 재생 시작을 알림 \n end -> 컨텐츠 재생의 끝을 알림 ", example = "start", position = 2)
	  private String content_state;
	  
	  @ApiModelProperty(value = "컨텐츠 타입 값 \n image -> 이미지 광고 컨텐츠 \n video -> 동영상 광고 컨텐츠", example = "video", position = 3)
	  private String content_type;

	  @ApiModelProperty(value = "재생중인 광고 영역 값\nEx) \"screen_pos_main\" -> 메인화면 광고중\n\"screen_pos_side\" ->  우측화면 광고중\n\"screen_pos_bottom\" ->  하단영역 광고중", example = "screen_pos_main", position = 4)
	  private String content_screen_position;
	  
	  @ApiModelProperty(value = "재생중인 광고 영역 타입\nEx) \"divisions_1\" -> 메인광고 full 화면\n\"divisions_2\" -> 메인광고 + 오른쪽 배너 광고 화면\n\"divisions_3\" -> 메인광고 + 오른쪽 배너 + 하단 배너 광고 화면", example = " divisions_3", position = 5)
	  private String content_screen_type;
	  
	  @ApiModelProperty(value = "타임 스템프", example = "1446994800000", position = 6)
	  private String content_ts;
	  
}
