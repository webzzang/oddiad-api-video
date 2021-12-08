package com.exflyer.oddi.app.api.fcmserver.controller;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.exflyer.oddi.app.api.fcmserver.service.AndroidPushNotificationsService;

import io.swagger.annotations.Api;

/***
 * Notification(PUSH) 전송 컨트롤러
 */
@Api(tags = "디바이스 Notification 모듈", protocols = "http")
@RestController
public class NotificationController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AndroidPushNotificationsService androidPushNotificationsService;

     /**
     * 디바이스에 푸쉬 전송
     * @param paramMap
     *        token : 디바이스 토큰
     *        data :
     *              {
     *                 action : APP 제어를 위한 action 값                                               
     *                           Ex)  "device_create" -> 디바이스 생성 성공으로 다음광고 화면 으로 진행요청              
     *                                "finish_app" -> APP 종료처리                                     
     *                                "restart_app" -> APP 재시작처리                                   
     *                                "request_main_ad" -> 메인 광고 리스트 변경알림                          
     *                                "request_side_ad" -> 오른쪽 배너 광고 리스트 변경알림                      
     *                                "request_bottom_ad" -> 하단 배너 광고 리스트 변경알림                     
     *                                "set_ad_screen_type" -> 화면 분할을 강제 변경 알림                      
     *                ,push_id : 전송확인용 FCM ID
     *                ,screen_type: action이 "set_ad_screen_type" 일때는 필수                
     *                              Ex) "divisions_1" -> 메인광고 full 화면                  
     *                                   "divisions_2" -> 메인광고 + 오른쪽 배너 광고 화면          
     *                                   "divisions_3" -> 메인광고 + 오른쪽 배너 + 하단 배너 광고 화면  
     * @return
     * @throws JSONException
     * @throws InterruptedException
     */
    public ResponseEntity<String> push(Map<String, Object> paramMap) throws JSONException, InterruptedException  {
        JSONObject notifications = new JSONObject();

        notifications.put("to", paramMap.get("token"));
        notifications.put("data", paramMap.get("data"));

        HttpEntity<String> request = new HttpEntity<>(notifications.toString());

        CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try{
            String firebaseResponse = pushNotification.get();
            return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
        }
        catch (InterruptedException e){
            logger.debug("got interrupted!");
            throw new InterruptedException();
        }
        catch (ExecutionException e){
            logger.debug("execution error!");
        }

        return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
    }
}