package com.exflyer.oddi.app.api.content.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exflyer.oddi.app.exceptions.ApiException;
import com.exflyer.oddi.app.repository.mapper.ContentMapper;

@Component
public class ContentService {

	@Autowired
	private ContentMapper contentMapper;

	/**
	 * 디바이스 광고 호출 로그 기록
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertCallApiLog(Map<String, Object> params) throws ApiException {
		return contentMapper.insertCallApiLog(params);
	}
	
	/**
	 * 디바이스에 보낼 메인 광고 리스트
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("rawtypes")
	public List getContentMainList(Map<String, Object> params) throws ApiException {
		return contentMapper.getContentMainList(params);
	}
	
	/**
	 * 디바이스에 보낼 메인 광고 파일 리스트
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("rawtypes")
	public List getContentMainFileUrl(Map<String, Object> params) throws ApiException {
		return contentMapper.getContentMainFileUrl(params);
	}
	
	/**
	 * 디바이스에 보낼 메인 광고 파일 리스트 MP4
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("rawtypes")
	public List getContentMainMP4List(Map<String, Object> params) throws ApiException {
		return contentMapper.getContentMainMP4List(params);
	}
	
	/**
	 * 디바이스에 보낼 사이드 광고 파일 리스트
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("rawtypes")
	public List getContentSideList(Map<String, Object> params) throws ApiException {
		return contentMapper.getContentSideList(params);
	}
	
	/**
	 * 디바이스에 보낼 하단 광고 파일 리스트
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	@SuppressWarnings("rawtypes")
	public List getContentBottomList(Map<String, Object> params) throws ApiException {
		return contentMapper.getContentBottomList(params);
	}
	
	/**
	 * 디바이스에 보낼 사이드 날씨 정보
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public Map<String, Object> getContentWeatherInfo(Map<String, Object> params) throws ApiException {
		return contentMapper.getContentWeatherInfo(params);
	}
	
	/**
	 * 컨텐츠 디바이스 정보
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public Map<String, Object> getContentDiviceInfo(Map<String, Object> params) throws ApiException {
		return contentMapper.getContentDiviceInfo(params);
	}
	
	/**
	 * 컨텐츠 재생 상태 저장
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertContentState(Map<String, Object> params) throws ApiException {
		return contentMapper.insertContentState(params);
	}
	
	/**
	 * 컨텐츠 재생 상태 저장 이력
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertContentStateHistory(Map<String, Object> params) throws ApiException {
		return contentMapper.insertContentStateHistory(params);
	}

	
	public List<Map<String, Object>> selectDeviceContentHistoryList(Map<String, Object> params) {
		return contentMapper.selectDeviceContentHistoryList(params);
	}
	
	
	
	
//	public int getDeviceIdChk(String device_id) throws ApiException {
//		return contentMapper.getDeviceIdChk(device_id);
//	}
//	
//	public int insertDeviceInfo(Map<String, String> params) throws ApiException {
//		return contentMapper.insertDeviceInfo(params);
//	}
}
