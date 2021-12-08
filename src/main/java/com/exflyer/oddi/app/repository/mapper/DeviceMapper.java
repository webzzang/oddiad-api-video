package com.exflyer.oddi.app.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceMapper {

	/**
	 * 디바이스 고유 ID 조회
	 * @param device_id
	 * @return
	 */
	public int getDeviceIdChk(@Param("device_id") String device_id);
	
	/**
	 * 디바이스 토큰 조회
	 * @param device_id
	 * @return
	 */
	public String getDeviceToken(@Param("device_id") String device_id);
	
	/**
	 * 디바이스 정보 저장
	 * @param params
	 * @return
	 */
	public int insertDeviceInfo(Map<String,Object> params);


	/**
	 * 디바이스 상태 저장
	 * @param params
	 * @return
	 */
	public int insertDeviceState(Map<String,Object> params);

	/**
	 * 디바이스 상태 저장 이력
	 * @param params
	 * @return
	 */
	public int insertDeviceStateHistory(Map<String,Object> params);

	
	/**
	 * 디바이스 Exception 발생 로그 저장
	 * @param params
	 * @return
	 */
	public int insertDeviceExceptionLog(Map<String,Object> params);

	/**
	 * 디바이스 FCM 송수신 저장
	 * @param params
	 * @return
	 */
	public int insertDeviceFcmResponsen(Map<String,Object> params);

}
