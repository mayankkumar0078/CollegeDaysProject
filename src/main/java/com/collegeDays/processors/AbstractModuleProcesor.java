package com.collegeDays.processors;

import org.springframework.beans.factory.annotation.Autowired;

import com.collegeDays.util.RestClient;

public abstract class AbstractModuleProcesor implements IModuleProcessor {

	@Autowired(required = true)
	private RestClient restClient;

	public StringBuilder getCompleteBaseUrl() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getProtocol()).append("://")
				.append(this.getFQDN()).append(":").append(this.getPort())
				.append("/").append(getBaseUrl());
		return stringBuilder;
	}
	
	protected String getUrl(String task){
		StringBuilder baseUrl=getCompleteBaseUrl();
		String []params=task.split(" ");
		for(String param:params){
			baseUrl.append("/");
			baseUrl.append(param);
		}
		
		return baseUrl.toString();
		
	}
	
	protected RestClient getRestClient() {
		return restClient;
	}


	public abstract String getProtocol();

	public abstract String getFQDN();

	public abstract String getPort();

	public abstract String getBaseUrl();
}
