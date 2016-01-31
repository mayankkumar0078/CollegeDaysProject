package com.collegeDays.processors;

import javax.servlet.http.HttpServletRequest;
public interface IModuleProcessor {
	String serveGET(HttpServletRequest request,String task);
	String servePOST(HttpServletRequest request,String task);
	String servePUT(HttpServletRequest request,String task);
	String serveDELETE(HttpServletRequest request,String task);
}
