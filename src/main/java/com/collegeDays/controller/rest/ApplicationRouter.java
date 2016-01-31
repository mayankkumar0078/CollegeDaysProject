package com.collegeDays.controller.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collegeDays.factory.ProcessorFactory;
import com.collegeDays.factory.ProcessorFactory.Module;

@RestController
@EnableAutoConfiguration
@ComponentScan
@Transactional
@RequestMapping(value = "/rest/api/{module}/{task}")
public class ApplicationRouter implements ApplicationContextAware {

	ApplicationContext appContext;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getServe(@PathVariable("module") String module,
			@PathVariable("task") String task, HttpServletRequest request,
			HttpServletResponse response) {
		return appContext.getBean("procesorFactory", ProcessorFactory.class)
				.getProcessor(Module.valueOf(module)).serveGET(request, task);

	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String postServe(
			@PathVariable("module") String module,
			@PathVariable("task") String task, HttpServletRequest request,
			HttpServletResponse response) {
		appContext.getBean("procesorFactory", ProcessorFactory.class)
				.getProcessor(Module.valueOf(module)).servePOST(request, task);
		return "login";
	}

	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody String putServe(@PathVariable("module") String module,
			@PathVariable("task") String task, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(module);
		appContext.getBean("procesorFactory", ProcessorFactory.class)
				.getProcessor(Module.valueOf(module)).servePUT(request, task);
		return "login";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody String deleteServe(
			@PathVariable("module") String module,
			@PathVariable("task") String task, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(module);
		appContext.getBean("procesorFactory", ProcessorFactory.class)
				.getProcessor(Module.valueOf(module))
				.serveDELETE(request, task);
		return "login";
	}

	@Override
	public void setApplicationContext(ApplicationContext appContext)
			throws BeansException {
		this.appContext = appContext;

	}
}
