package com.exflyer.oddi.app.api.device.controller;

import com.exflyer.oddi.app.api.device.dto.DeviceCreateReq;
import com.exflyer.oddi.app.api.device.dto.DeviceException;
import com.exflyer.oddi.app.api.device.dto.DeviceFcmRes;
import com.exflyer.oddi.app.api.device.dto.DevicePushReq;
import com.exflyer.oddi.app.api.device.dto.DeviceStateReq;
import com.exflyer.oddi.app.api.device.service.DeviceService;
import com.exflyer.oddi.app.api.fcmserver.controller.NotificationController;
import com.exflyer.oddi.app.api.util.StringUtil;
import com.exflyer.oddi.app.enums.ApiResponseCodes;
import com.exflyer.oddi.app.exceptions.ApiException;
import com.exflyer.oddi.app.share.LocalDateUtils;
import com.exflyer.oddi.app.share.dto.ApiRes;
import com.exflyer.oddi.app.share.dto.ApiResWithSingleData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "디바이스 컨트롤러", protocols = "http")
@Slf4j
@RestController
public class DeviceController {

	@Autowired
	private DeviceService deviceService;

	@Autowired
	private NotificationController notifi;
	
	
	/**
	 * 디바이서 키 생성
	 * 
	 * @param paramMap
	 * 			(fcm_token) FCM token
	 * 			(device_model) 디바이스 모델명 (ex. TCL tv, Chromecast)
	 * 			(android_id) 디바이스에 설치된 Android id 값(os 가 재설치 되기 전까지 유니크)
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "디바이스 키 생성", notes = "디바이스 고유 ID 생성")
	@PostMapping(path = "/device/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResWithSingleData deviceCreate(@Validated @RequestBody DeviceCreateReq deviceCreateReq)
			throws ApiException, IOException, JSONException, InterruptedException {
		
		String device_id = "";
	
		while(true) {
			device_id = StringUtil.RandomGen("3",6).toUpperCase();
			int cnt = deviceService.getDeviceIdChk(device_id);

			if(cnt == 0) {
				break;
			}
		}
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("device_id", device_id);
		paramMap.put("fcm_token", deviceCreateReq.getFcm_token() );
		paramMap.put("device_model", deviceCreateReq.getDevice_model() );
		paramMap.put("android_id", deviceCreateReq.getAndroid_id());
		paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
		
		deviceService.insertDeviceInfo(paramMap);
		
		Map<String, String> rtnMap = new HashMap<String, String>();
		
		rtnMap.put("device_id", device_id);
	
		return new ApiResWithSingleData(ApiResponseCodes.OK, rtnMap);
	}
	
	

	
	/**
	 * 디바이스 상태 수신
	 * 
	 * @param paramMap
	 * 			(device_state) 상태 정보
	 *                       Ex) "start" -> 광고 화면의 첫 시작을 알림                          
	 *                           "resume" -> 광고 화면이 활성화 되어 광고를 시작 하는 상태             
	 *                           "pause" -> 광고 화면이 무언가에 의해 일부분이 가려진 상태               
	 *                            (앱 실행중 팝업과 같은 화면이 노출된 상태)                            
	 *                           "stop"  -> 광고 화면의 전체가 사라진 상태                        
	 *                            (앱 실해중 홈으로 이동등)                                      
	 *                           "destroy" -> 광고 APP 이 종료된 상태"   
	 * 			(content_id) 컨텐츠 ID
	 * 			(device_id) 디바이스 생성시 받은 ID 값
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "디바이스 상태 수신", notes = "디바이스 상태 저장")
	@PostMapping(path = "/device/state", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiRes deviceState(@Validated @RequestBody DeviceStateReq deviceStateReq)
			throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("device_id", deviceStateReq.getDevice_id() );
		paramMap.put("content_id", deviceStateReq.getContent_id() );
		paramMap.put("device_state", deviceStateReq.getDevice_state() );
		paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
		
		//디바이스 상태 저장
		deviceService.insertDeviceState(paramMap);
		
		//디바이스 상태 저장 이력
		deviceService.insertDeviceStateHistory(paramMap);
		
		return new ApiRes(ApiResponseCodes.OK);
	}
	
	/**
	 * 디바이스 Exception 수신
	 * 
	 * @param paramMap
	 * 			(content_id) 재생 하던 컨텐츠 ID
	 * 			(device_id) 디바이스 생성시 받은 ID 값
	 * 			(acc_count) Exception 이 발생하여 APP 재 시작한 카운트 전달 카운트는 APP 시작후 5분후 초기화 하며, 5분안에 반복해서 발생시 카운트를 증가 하며, 그 횟수가 3회가 되면 APP 은 그냥 종료 처리함 
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "디바이스 Exception 수신", notes = "디바이스 Exception 카운트 저장")
	@PostMapping(path = "/device/exception", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiRes deviceException(@Validated @RequestBody DeviceException deviceException)
			throws ApiException, IOException, JSONException, InterruptedException {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("device_id", deviceException.getDevice_id() );
		paramMap.put("acc_count", deviceException.getAcc_count());
		paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
		
		deviceService.insertDeviceExceptionLog(paramMap);
		
		return new ApiRes(ApiResponseCodes.OK);
	}
	
	/**
	 * 디바이스 FCM 수신 체크
	 * 
	 * @param paramMap
	 * 			(push_id) FCM 수신시 전달받은 ID 값
	 * 			(device_id) 디바이스 생성시 받은 ID 값
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "디바이스 FCM 수신 체크", notes = "디바이스 FCM 수신 정보 저장")
	@PostMapping(path = "/device/fcm/response", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiRes deviceFcmResponsen(@Validated @RequestBody DeviceFcmRes deviceFcmRes)
			throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("device_id", deviceFcmRes.getDevice_id() );
		paramMap.put("push_id", deviceFcmRes.getPush_id() );
		paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
		paramMap.put("type","RECEP"); //SEND : FCM 발송, RECEP : 디바이스 FCM 수신
		
		deviceService.insertDeviceFcmResponsen(paramMap);
		
		return new ApiRes(ApiResponseCodes.OK);
	}

	/**
	 * 디바이스 FCM 전송
	 * 
	 * @param paramMap
     *        token : 디바이스 토큰
     *        action : "액션 코드"
     *                   Ex)  "device_create" -> 디바이스 생성 성공으로 다음광고 화면 으로 진행요청  
     *                        "finish_app" -> APP 종료처리  
     *                        "restart_app" -> APP 재시작처리 
     *                        "request_main_ad" -> 메인 광고 리스트 변경알림
     *                        "request_side_ad" -> 오른쪽 배너 광고 리스트 변경알림 
     *                        "request_bottom_ad" -> 하단 배너 광고 리스트 변경알림 
     *                        "set_ad_screen_type" -> 화면 분할을 강제 변경 알림 
     *        push_id : "PUSH 토큰 값 임의 생성"
     *        screen_type : "action이 "set_ad_screen_type" 일때는 필수 
     *                   Ex) "divisions_1" -> 메인광고 full 화면 
     *                        "divisions_2" -> 메인광고 + 오른쪽 배너 광고 화면 
     *                        "divisions_3" -> 메인광고 + 오른쪽 배너 + 하단 배너 광고 화면 
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "디바이스 PUSH", notes = "디바이스 상태 저장")
	@PostMapping(path = "/devicePush", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> devicePush(@Validated @RequestBody DevicePushReq devicePushReq)
			throws ApiException, IOException, JSONException, InterruptedException {
		
		String device_id = String.valueOf(devicePushReq.getDevice_id() );
		String token = deviceService.getDeviceToken(String.valueOf(device_id));
		String push_id = device_id + "_" + LocalDateUtils.krNowByFormatter("yyyyMMddHHmmss");
		Map<String, Object> dataParam = new HashMap<String, Object>();
		
		dataParam.put("action", devicePushReq.getAction());
		dataParam.put("push_id", push_id);
		dataParam.put("screen_type", devicePushReq.getScreen_type());
		
		
		Map<String, Object> outMap = new HashMap<String, Object>();
		outMap.put("token", token);
		outMap.put("data", dataParam);

		Map<String, Object> paramMap = new HashMap<String, Object>();
		//로그 기록
		paramMap.put("device_id", devicePushReq.getDevice_id());
		paramMap.put("action", devicePushReq.getAction());
		paramMap.put("push_id",push_id );
		paramMap.put("screen_type", devicePushReq.getScreen_type());
		paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
		paramMap.put("type","SEND"); //SEND : FCM 발송, RECEP : 디바이스 FCM 수신
		deviceService.insertDeviceFcmResponsen(paramMap);
		
		/*
			{
			  "multicast_id": 382087434365638000,
			  "success": 1,
			  "failure": 0,
			  "canonical_ids": 0,
			  "results": [
			    {
			      "message_id": "0:1635204662133179%adc6b17bf9fd7ecd"
			    }
			  ]
			}
		 */
		
		return notifi.push(outMap);
	}
	
}
