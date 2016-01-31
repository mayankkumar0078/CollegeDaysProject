package com.collegeDays.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.collegeDays.factory.ProcessorFactory;
import com.collegeDays.factory.ProcessorFactory.Module;
import com.collegeDays.processors.BooksModuleProcessor;
import com.collegeDays.processors.CollegeModuleProcessor;
import com.collegeDays.processors.IModuleProcessor;
import com.collegeDays.processors.UserModuleProcessor;
import com.collegeDays.util.RestClient;

@Configuration
//@ComponentScan({"com.collegeDays"})
public class RestClientConfig {
	@Bean
	public RestClient restClient(){
		RestClient restClient=new RestClient();
		restClient.setRestTemplate(getRestTemplate());
		return restClient;
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	@Bean(name="booksModuleProcessor")
	public CollegeModuleProcessor getCollegeModuleProcessor(){
		return new CollegeModuleProcessor();
	}
	
	@Bean(name="collegeModuleProcessor")
	public BooksModuleProcessor getBookModuleProcessor(){
		return new BooksModuleProcessor();
	}
	
	@Bean(name="userModuleProcessor")
	public UserModuleProcessor getUserModuleProcessor(){
		return new UserModuleProcessor();
	}
	@Bean(name="procesorFactory")
	public ProcessorFactory getProcessorFactory(){
		ProcessorFactory processorFacory=new ProcessorFactory();
		processorFacory.setProcessorsMap(getProcessorMap());
		return processorFacory;
	}
	@Bean
	public Map<ProcessorFactory.Module,IModuleProcessor> getProcessorMap(){
		Map<ProcessorFactory.Module,IModuleProcessor> processsorMap=new HashMap<ProcessorFactory.Module,IModuleProcessor>();
		processsorMap.put(Module.Books, getBookModuleProcessor());
		processsorMap.put(Module.Colleges, getCollegeModuleProcessor());
		processsorMap.put(Module.user, getUserModuleProcessor());
		return processsorMap;
	}
}
