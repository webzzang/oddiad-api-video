package com.exflyer.oddi.app.api.fcmserver.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exflyer.oddi.app.exceptions.ApiException;
import com.exflyer.oddi.app.repository.mapper.DeviceMapper;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class AndroidPushNotificationsService {

//	private static final String firebase_server_key = "AAAA733XyL8:APA91bEp4QgHrsLrnrf_sro8zLstcqs4pRwZPZmmb9zmdvO9IbUm6PvjyM0nPAN7DFMf0tKDU5oJ11OjLDooYnZ1Zo-0j9AY6hu61k9su5GVrU_77n2ANfhy1QvCy-DK0ZvMHEa9j913";
	private static final String firebase_server_key = "AAAAODH_mII:APA91bFraq0weIwTtnj86TcWwKLPgR3Ab9FUNl-5KnvXR2L5zl1gRXQz8qbGanXDd9C_okqP1f_StPC6f8UX4bNTLtw5X5TbrhZYzIKa0Ds6UU4LmnT8uIvPjd6_S5beb5lqmEdtUwpg";
	
	private static final String firebase_api_url = "https://fcm.googleapis.com/fcm/send";

	@Async
	public CompletableFuture<String> send(HttpEntity<String> entity) {

		RestTemplate restTemplate = new RestTemplate();

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + firebase_server_key));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; UTF-8 "));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}

}
