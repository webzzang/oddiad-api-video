package com.exflyer.oddi.app.api.device.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DeviceCreateReq {

	  @NotBlank
	  @ApiModelProperty(value = "FCM token", example = "eZL0Ku4CRSOnHhI5yrv_Kx:APA91bHhV5EY2UP_nrTkHIy9Y6BIz1LDm4Ug1ijqEO1jCOnLAez5Cxwsbrv8Jb2HLOUjHQr18HbyJbiU08jixjgZG6qk9WxfTHWgDPc8vW-tgvchaaRDOKTJ4NvCsj-Z-OS61GoCDt_S", required = true, position = 0)
	  private String fcm_token;

	  @ApiModelProperty(value = "디바이스 모델명 (ex. TCL tv, Chromecast)", example = "Chromecast", required = true, position = 1)
	  private String device_model;
	  
	  @ApiModelProperty(value = "디바이스에 설치된 Android id 값(os 가 재설치 되기 전까지 유니크)", example = "a6417eac4330f159", required = true, position = 2)
	  private String android_id;

}
