package com.collegeDays.processors;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;

public class UserModuleProcessor extends AbstractModuleProcesor {
	@Value("${CollegeDaysInternal.UserModule.baseurl}")
	private String userModuleBaseUrl;
	
	@Value("${CollegeDaysInternal.UserModule.port}")
	private String userModulePort;
	
	@Value("${CollegeDaysInternal.UserModule.protocol}")
	private String userModuleProtocol;
	
	@Value("${CollegeDaysInternal.UserModule.FQDN}")
	private String userModuleFQDN;
	

	@Override
	public String getProtocol() {
		return userModuleProtocol;
	}

	@Override
	public String getFQDN() {
		return userModuleFQDN;
	}

	@Override
	public String getPort() {
		return userModulePort;
	}

	@Override
	public String getBaseUrl() {
		return userModuleBaseUrl;
	}

	@Override
	public String serveGET(HttpServletRequest request, String task) {
		URI uri=null;
		try {
			uri = new URI(getUrl(task));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getRestClient().getForObject(uri, request);
	}

	@Override
	public String servePOST(HttpServletRequest request, String task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String servePUT(HttpServletRequest request, String task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String serveDELETE(HttpServletRequest request, String task) {
		// TODO Auto-generated method stub
		return null;
	}

}
