package com.collegeDays.processors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class CollegeModuleProcessor extends  AbstractModuleProcesor {
	
	@Value("${CollegeDaysInternal.CollegeModule.baseurl}")
	private String collegeModuleBaseUrl;
	
	@Value("${CollegeDaysInternal.CollegeModule.port}")
	private String collegeModulePort;
	
	@Value("${CollegeDaysInternal.CollegeModule.protocol}")
	private String collegeModuleProtocol;
	
	@Value("${CollegeDaysInternal.CollegeModule.FQDN}")
	private String collegeModuleFQDN;
	



	@Override
	public String getProtocol() {
		return collegeModuleProtocol;
	}


	@Override
	public String getFQDN() {
		return collegeModuleFQDN;
	}


	@Override
	public String getPort() {
		return collegeModulePort;
	}


	@Override
	public String getBaseUrl() {
		return collegeModuleBaseUrl;
	}


	@Override
	public String serveGET(HttpServletRequest request, String task) {
		// TODO Auto-generated method stub
		return null;
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
