package com.exflyer.oddi.app.api.device.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exflyer.oddi.app.exceptions.ApiException;
import com.exflyer.oddi.app.repository.mapper.DeviceMapper;

@Component
public class DeviceService {

	@Autowired
	private DeviceMapper deviceMapper;

	/**
	 * 디바이스 고유 ID 조회
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int getDeviceIdChk(String device_id) throws ApiException {
		return deviceMapper.getDeviceIdChk(device_id);
	}
	
	/**
	 * 디바이스 토큰 조회
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public String getDeviceToken(String device_id) throws ApiException {
		return deviceMapper.getDeviceToken(device_id);
	}
	
	/**
	 * 디바이스 정보 저장
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertDeviceInfo(Map<String, Object> params) throws ApiException {
		return deviceMapper.insertDeviceInfo(params);
	}
	
	/**
	 * 디바이스 상태 저장
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertDeviceState(Map<String, Object> params) throws ApiException {
		return deviceMapper.insertDeviceState(params);
	}
	
	/**
	 * 디바이스 상태 저장 이력
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertDeviceStateHistory(Map<String, Object> params) throws ApiException {
		return deviceMapper.insertDeviceStateHistory(params);
	}
	
	/**
	 * 디바이스 Exception 발생 로그 저장
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertDeviceExceptionLog(Map<String, Object> params) throws ApiException {
		return deviceMapper.insertDeviceExceptionLog(params);
	}
	
	/**
	 * 디바이스 FCM 수신 저장
	 * @param params
	 * @return
	 * @throws ApiException
	 */
	public int insertDeviceFcmResponsen(Map<String, Object> params) throws ApiException {
		return deviceMapper.insertDeviceFcmResponsen(params);
	}
}
