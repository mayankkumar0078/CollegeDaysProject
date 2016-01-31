package com.collegeDays.processors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;


public class BooksModuleProcessor extends AbstractModuleProcesor {
	@Value("${CollegeDaysInternal.BooksModule.baseurl}")
	private String booksModuleBaseUrl;
	
	@Value("${CollegeDaysInternal.BooksModule.port}")
	private String booksModulePort;
	
	@Value("${CollegeDaysInternal.BooksModule.protocol}")
	private String booksModuleProtocol;
	
	@Value("${CollegeDaysInternal.BooksModule.FQDN}")
	private String booksModuleFQDN;
	

	@Override
	public String getProtocol() {
		return booksModuleProtocol;
	}

	@Override
	public String getFQDN() {
		return booksModuleFQDN;
	}

	@Override
	public String getPort() {
		return booksModulePort;
	}

	@Override
	public String getBaseUrl() {
		return booksModuleBaseUrl;
	}

	@Override
	public String serveGET(HttpServletRequest request, String task) {
		System.out.println("booksModuleBaseUrl "+booksModuleBaseUrl);
		System.out.println("booksModulePort "+booksModulePort);
		System.out.println(getBaseUrl()+"/"+task);
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
