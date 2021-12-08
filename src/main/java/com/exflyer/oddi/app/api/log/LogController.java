package com.exflyer.oddi.app.api.log;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exflyer.oddi.app.api.content.service.ContentService;
import com.exflyer.oddi.app.exceptions.ApiException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "로그뷰 임시", protocols = "http")
@RestController
public class LogController {

	@Autowired
	private ContentService contentService;
	
	/**
	 * 로그뷰 임시용
	 */
	@ApiOperation(value = "로그조회 임시용", notes = "디바이스 컨텐츠 로그")
	@PostMapping(path = "/devicelog", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Map<String, Object> logMail(HttpServletRequest request, @RequestBody Map<String, Object> paramMap)
			throws ApiException, IOException, JSONException, InterruptedException {
		
		Map<String, Object> outMap = new HashMap<String, Object>();
		
		String page = String.valueOf(paramMap.get("page") );
			
		if(page == "" || page == null || page == "null") {
			return paramMap;
		}
		
		if(page == "1") {
			paramMap.put("pageNo", Integer.parseInt(page));
			
		}else {
			paramMap.put("pageNo", (Integer.parseInt(page)-1)*1000);
		}

		List<Map<String, Object>> list = contentService.selectDeviceContentHistoryList(paramMap);
		
		outMap.put("list", list);
		
		return outMap;
	}

}
