package com.exflyer.oddi.app.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentMapper {

	/**
	 * 디바이스 광고 호출 로그 기록
	 * @param params
	 * @return
	 */
	public int insertCallApiLog(Map<String,Object> params);

	/**
	 * 디바이스에 보낼 메인 광고 리스트
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getContentMainList(Map<String,Object> params);

	/**
	 * 디바이스에 보낼 메인 광고 파일 리스트
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getContentMainFileUrl(Map<String,Object> params);

	/**
	 * 디바이스에 보낼 메인 광고 리스트 Mp4
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getContentMainMP4List(Map<String,Object> params);

	
	/**
	 * 디바이스에 보낼 사이드 광고 파일 리스트
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getContentSideList(Map<String,Object> params);

	/**
	 * 디바이스에 보낼 하단 광고 파일 리스트
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getContentBottomList(Map<String,Object> params);

	/**
	 * 디바이스에 보낼 사이드 날씨 정보
	 * @param params
	 * @return
	 */
	public Map<String, Object> getContentWeatherInfo(Map<String,Object> params);

	/**
	 * 컨텐츠 디바이스 정보
	 * @param params
	 * @return
	 */
	public Map<String, Object> getContentDiviceInfo(Map<String,Object> params);

	/**
	 * 컨텐츠 재생 상태 저장
	 * @param params
	 * @return
	 */
	public int insertContentState(Map<String,Object> params);
	
	/**
	 * 컨텐츠 재생 상태 저장 이력
	 * @param params
	 * @return
	 */
	public int insertContentStateHistory(Map<String,Object> params);

	
	/**
	 * 로그 임시
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> selectDeviceContentHistoryList(Map<String,Object> params);
	
}
