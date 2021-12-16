package com.exflyer.oddi.app.api.content.controller;

import com.exflyer.oddi.app.api.content.dto.ContentCryptoDe;
import com.exflyer.oddi.app.api.content.dto.ContentCryptoEn;
import com.exflyer.oddi.app.api.content.dto.ContentGetMainReq;
import com.exflyer.oddi.app.api.content.dto.ContentGetSubReq;
import com.exflyer.oddi.app.api.content.dto.ContentStateReq;
import com.exflyer.oddi.app.api.content.service.ContentService;
import com.exflyer.oddi.app.api.util.CryptoUtil;
import com.exflyer.oddi.app.enums.ApiResponseCodes;
import com.exflyer.oddi.app.exceptions.ApiException;
import com.exflyer.oddi.app.share.LocalDateUtils;
import com.exflyer.oddi.app.share.dto.ApiRes;
import com.exflyer.oddi.app.share.dto.ApiResWithSingleData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "컨텐츠 컨트롤러", protocols = "http")
@Slf4j
@RestController
public class ContentController {

	@Autowired
	private ContentService contentService;

	/**
	 * 메인광고
	 *
	 * @param paramMap
	 * 			(device_id)디바이스 생성시 받은 ID 값
	 * 			(device_latitude)디바이스에서 수집된 위치 정보 (위도) 값이 없으면 "" 로 전달처리
	 * 			(device_longitude)디바이스에서 수집된 위치 정보 (경도) 값이 없으면 "" 로 전달처리
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation(value = "모바일 메인광고", notes = "모바일 메인광고")
	@PostMapping(path = "/content/get/main", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResWithSingleData contentMain(@Validated @RequestBody ContentGetMainReq contentGetMainReq)
		throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> rtmParams = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("position", "main");
		paramMap.put("device_id", contentGetMainReq.getDevice_id() );
//		paramMap.put("device_id", "testid");
		paramMap.put("device_latitude",  CryptoUtil.getDecMsg( contentGetMainReq.getDevice_latitude())); //디바이스에서 수집된 위치 정보 (위도)
		paramMap.put("device_longitude", CryptoUtil.getDecMsg( contentGetMainReq.getDevice_longitude())); //디바이스에서 수집된 위치 정보 (경도)


		try {
			//디바이스 정보
			Map<String, Object> deviceInfo =  contentService.getContentDiviceInfo(paramMap);

			//광고 리스트
			List<Map<String, Object>> list = contentService.getContentMainList(paramMap);

			//광고 + URL 맵핑 오브젝트
			List<Map<String, Object>> adList = new ArrayList<Map<String,Object>>();

			List<String> files = new ArrayList<String>();
			String content_urls[];
			for(Map<String, Object> inMap : list) {

				Map<String, Object> outMap = new HashMap<String, Object>();

				List<Map<String, Object>> file_list = contentService.getContentMainFileUrl(inMap);
				files = new ArrayList<String>();
				for(Map<String, Object> fMap : file_list) {
					files.add( String.valueOf(fMap.get("content_url")) );
				}
				content_urls = new String[files.size()];
				for(int i = 0 ; i < files.size(); i++) {
					content_urls[i] = files.get(i);
				}

				outMap.put("content_id", inMap.get("content_id"));
				outMap.put("content_type", inMap.get("content_type"));
				outMap.put("content_url", content_urls);

//				outMap.put("content_ext", inMap.get("content_ext"));
//				, (
//						select substring_index(TRIM(BOTH ' ' FROM e.path), '.', -1) as ext
//						from broadcasting_file e
//						where e.broadcasting_seq = m.seq
//						limit 1
//					)
//					as content_ext

				outMap.put("content_duration", inMap.get("content_duration"));

				adList.add(outMap);
			}

			paramMap.put("broadcasting_cnt", adList.size());
			paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
			paramMap.put("device_id", contentGetMainReq.getDevice_id());
			//컨텐츠 Call 로그
			contentService.insertCallApiLog(paramMap);


			rtmParams.put("ad_screen_type", deviceInfo.get("display_div"));
			rtmParams.put("ad_list", adList);


		} catch (Exception e) {
			return new ApiResWithSingleData(ApiResponseCodes.BAD_REQUEST); //잘못된 요청 입니다.
		}

		return new ApiResWithSingleData(ApiResponseCodes.OK, rtmParams);
	}

	/**
	 * 사이드 광고
	 *
	 * @param paramMap
	 * 			(device_id)디바이스 생성시 받은 ID 값
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation(value = "모바일 사이드(오른쪽) 광고", notes = "모바일 사이드(오른쪽) 광고")
	@PostMapping(path = "/content/get/side", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResWithSingleData contentSide(@Validated @RequestBody ContentGetSubReq contentGetSubReq)
		throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> rtmParams = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("position", "side");
		paramMap.put("device_id", contentGetSubReq.getDevice_id() );

		try {
			//디바이스 정보
			Map<String, Object> deviceInfo =  contentService.getContentDiviceInfo(paramMap);

			//광고 리스트
			List<Map<String, Object>> list = contentService.getContentSideList(paramMap);

			//광고 + URL 맵핑 오브젝트
			List<Map<String, Object>> adList = new ArrayList<Map<String,Object>>();



			if(deviceInfo.get("side_contents_type").equals("weather")) {
				Map<String, Object> outMap = new HashMap<String, Object>();
				outMap = new HashMap<String, Object>();
				outMap.put("content_id", "weather");
				outMap.put("content_type", "weather");
				outMap.put("content_url",  new String[0]);
				outMap.put("content_duration", "10800000");// 3시간( 60초*60분*3시간)

				adList.add(outMap);

			}else {

				List<String> files = new ArrayList<String>();
				String content_urls[];

				for(Map<String, Object> inMap : list) {
					Map<String, Object> outMap = new HashMap<String, Object>();
					outMap.put("content_id", inMap.get("content_id"));
					outMap.put("content_type", inMap.get("content_type"));
					outMap.put("content_duration", inMap.get("content_duration"));

					files = new ArrayList<String>();
					files.add( String.valueOf(inMap.get("content_url")) );

					content_urls = new String[files.size()];
					for(int i = 0 ; i < files.size(); i++) {
						content_urls[i] = files.get(i);
					}

					outMap.put("content_url",  content_urls);
					adList.add(outMap);
				}
			}

			paramMap.put("broadcasting_cnt", adList.size());
			paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
			paramMap.put("device_id", contentGetSubReq.getDevice_id());
			//컨텐츠 Call 로그
			contentService.insertCallApiLog(paramMap);

			rtmParams.put("ad_list", adList);

		} catch (Exception e) {
			return new ApiResWithSingleData(ApiResponseCodes.BAD_REQUEST); //잘못된 요청 입니다.
		}

		return new ApiResWithSingleData(ApiResponseCodes.OK, rtmParams);
	}

	/**
	 * 하단광고
	 *
	 * @param paramMap
	 * 			(device_id)디바이스 생성시 받은 ID 값
	 * @return
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiOperation(value = "모바일 하단 광고", notes = "모바일 하단 광고")
	@PostMapping(path = "/content/get/bottom", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResWithSingleData contentBottom(@Validated @RequestBody ContentGetSubReq contentGetSubReq)
		throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> rtmParams = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("position", "bottom");
		paramMap.put("device_id", contentGetSubReq.getDevice_id() );

		try {

			//광고 리스트
			List<Map<String, Object>> list = contentService.getContentBottomList(paramMap);

			//광고 + URL 맵핑 오브젝트
			List<Map<String, Object>> adList = new ArrayList<Map<String,Object>>();

			List<String> files = new ArrayList<String>();
			String content_urls[];

			for(Map<String, Object> inMap : list) {
				Map<String, Object> outMap = new HashMap<String, Object>();
				outMap.put("content_id", inMap.get("content_id"));
				outMap.put("content_type", inMap.get("content_type"));
				outMap.put("content_duration", inMap.get("content_duration"));

				files = new ArrayList<String>();
				files.add( String.valueOf(inMap.get("content_url")) );

				content_urls = new String[files.size()];
				for(int i = 0 ; i < files.size(); i++) {
					content_urls[i] = files.get(i);
				}

				outMap.put("content_url",  content_urls);
				adList.add(outMap);
			}

			paramMap.put("broadcasting_cnt", adList.size());
			paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
			paramMap.put("device_id", contentGetSubReq.getDevice_id());
			//컨텐츠 Call 로그
			contentService.insertCallApiLog(paramMap);

			rtmParams.put("ad_list", adList);

		} catch (Exception e) {
			return new ApiResWithSingleData(ApiResponseCodes.BAD_REQUEST); //잘못된 요청 입니다.
		}

		return new ApiResWithSingleData(ApiResponseCodes.OK, rtmParams);
	}

	/**
	 * 사이드 광고 날씨 정보
	 *
	 * @param paramMap
	 * 			(device_id)디바이스 생성시 받은 ID 값
	 * @return
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "rawtypes" })
	@ApiOperation(value = "모바일 사이드 날씨", notes = "모바일 사이드 날씨")
	@PostMapping(path = "/content/get/weather", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResWithSingleData contentWeather(@Validated @RequestBody ContentGetSubReq contentGetSubReq)
		throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> rtmParams = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();

		paramMap.put("position", "weather");
		paramMap.put("device_id", contentGetSubReq.getDevice_id() );

		try {

			//사이드 광고 날씨 정보
			rtmParams =  contentService.getContentWeatherInfo(paramMap);

		} catch (Exception e) {
			return new ApiResWithSingleData(ApiResponseCodes.BAD_REQUEST); //잘못된 요청 입니다.
		}

		return new ApiResWithSingleData(ApiResponseCodes.OK, rtmParams);
	}

	/**
	 * 컨텐츠 재생 상태
	 *
	 * @param paramMap
	 * 			(device_id) 디바이스 생성시 받은 ID 값
	 * 			(content_id) 컨텐츠 ID
	 * 			(content_state) 컨텐츠 상태 값 | start -> 컨텐츠의 재생 시작을 알림 / end -> 컨텐츠 재생의 끝을 알림 
	 * 			(content_type) 컨텐츠 타입 값 | image -> 이미지 광고 컨텐츠  / video -> 동영상 광고 컨텐츠
	 * 			(content_screen_position) 재생중인 광고 영역 값
	 *								Ex) "screen_pos_main" -> 메인화면 광고중 
	 *								     "screen_pos_side" ->  우측화면 광고중
	 *								     "screen_pos_bottom" ->  하단영역 광고중
	 * 			(content_screen_type) 재생중인 광고 영역 타입
	 *							Ex) "divisions_1" -> 메인광고 full 화면 
	 *							     "divisions_2" -> 메인광고 + 오른쪽 배너 광고 화면 
	 *							     "divisions_3" -> 메인광고 + 오른쪽 배너 + 하단 배너 광고 화면 
	 * @return
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@ApiOperation(value = "컨텐츠 재생 상태", notes = "모바일 컨탠츠 광고 상태")
	@PostMapping(path = "/content/state", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiRes contentState(@Validated @RequestBody ContentStateReq contentStateReq)
		throws ApiException, IOException, JSONException, InterruptedException {


		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("device_id", contentStateReq.getDevice_id() );
		paramMap.put("content_id", contentStateReq.getContent_id() );
		paramMap.put("content_state", contentStateReq.getContent_state() );
		paramMap.put("content_type", contentStateReq.getContent_type() );
		paramMap.put("content_screen_position", contentStateReq.getContent_screen_position() );
		paramMap.put("content_screen_type", contentStateReq.getContent_screen_type() );
		paramMap.put("sysdate",LocalDateUtils.krNowByFormatter("yyyy-MM-dd HH:mm:ss") ); //로컬 서버 타임
		paramMap.put("content_ts",contentStateReq.getContent_ts() );

		try {
			//컨텐츠 재생 상태 저장
			contentService.insertContentState(paramMap);
			//컨텐츠 재생 상태 저장 이력
			contentService.insertContentStateHistory(paramMap);
		} catch (Exception e) {
			return new ApiRes(ApiResponseCodes.BAD_REQUEST); //잘못된 요청 입니다.
		}

		return new ApiRes(ApiResponseCodes.OK);
	}

	/**
	 * 암호화
	 *
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "rawtypes" })
	@ApiOperation(value = "암호화 테스트", notes = "텍스트 암호화")
	@PostMapping(path = "/cryptoen", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResWithSingleData cryptoen(@Validated @RequestBody ContentCryptoEn contentCryptoEn)
		throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> rtmParams = new HashMap<String, Object>();

		try {
			rtmParams.put("value", CryptoUtil.getEncMsg(contentCryptoEn.getValue()) );
		} catch (Exception e) {
			return new ApiResWithSingleData(ApiResponseCodes.BAD_REQUEST); //잘못된 요청 입니다.
		}

		return new ApiResWithSingleData(ApiResponseCodes.OK, rtmParams);
	}

	/**
	 * 복호화
	 *
	 * @throws ApiException
	 * @throws IOException
	 * @throws JSONException
	 * @throws InterruptedException
	 */
	@SuppressWarnings({ "rawtypes" })
	@ApiOperation(value = "복호화 테스트", notes = "텍스트 복호화")
	@PostMapping(path = "/cryptode", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiResWithSingleData cryptode(@Validated @RequestBody ContentCryptoDe contentCryptoDe)
		throws ApiException, IOException, JSONException, InterruptedException {

		Map<String, Object> rtmParams = new HashMap<String, Object>();

		try {
			rtmParams.put("value", CryptoUtil.getDecMsg(contentCryptoDe.getValue()) );
		} catch (Exception e) {
			return new ApiResWithSingleData(ApiResponseCodes.BAD_REQUEST); //잘못된 요청 입니다.
		}

		return new ApiResWithSingleData(ApiResponseCodes.OK, rtmParams);
	}

}
