package com.collegeDays.util;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

	@Autowired(required=true)
	private RestTemplate restTemplate;

	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getForObject(URI uri, Object request) {
		return restTemplate.getForObject(uri, String.class);
	}

	public String postForObject(URI uri, Object request, Object responseType) {
		return restTemplate.postForObject(uri, request, String.class);
	}

	public void putForObject(URI uri, Object request) {
		restTemplate.put(uri, request);
	}

	public void delete(URI uri) {
		restTemplate.delete(uri);
	}
}
