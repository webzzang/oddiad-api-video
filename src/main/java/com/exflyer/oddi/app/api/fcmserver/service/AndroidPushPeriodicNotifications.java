package com.exflyer.oddi.app.api.fcmserver.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications{
	
	public static String PeriodicNotificationJson() throws JSONException {
        LocalDate localDate = LocalDate.now();

        String sampleData[] = {
        		"cK8wVqITRJuP0eLoKeVml4:APA91bEWY_OvO38BdA0McyVk7xdeoBiliqcdLKfSM5DI-aGKF-hirxcr8C3PBoowTbLUcKFKUERkz3fk2tQw47QYUKuitbrhaqKydfRxyMEYtzFd23fj4b2apJjY0Pl3s-N9DK_GbQoy"
        		,"fCalK5AmQp2V00nvLH_udO:APA91bFI_0TnHSg7FIr9PBcQBSkMvjxG6IZcPWjkA92KKJ5Y6QD39A0iouCEPhbKBQl7xX2AsiI8lx5ozgSNrT5WnjKOiqQwO7PzJvqq97D7VAFzkx10nuqKBuwfmXXqyUa0yZi8ZcyR"
        	};

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for(int i=0; i<sampleData.length; i++){
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        
        JSONObject notification = new JSONObject();
        notification.put("action","device_create");
        notification.put("push_id","d7f8d7");

        body.put("data", notification);

        System.out.println(body.toString());

        return body.toString();
    }
}