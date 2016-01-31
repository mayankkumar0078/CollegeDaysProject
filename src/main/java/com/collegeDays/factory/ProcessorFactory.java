package com.collegeDays.factory;

import java.util.Map;

import com.collegeDays.processors.IModuleProcessor;

public class ProcessorFactory {
	private  Map<ProcessorFactory.Module, IModuleProcessor> processorsMap;

	public Map<ProcessorFactory.Module, IModuleProcessor> getProcessorsMap() {
		return processorsMap;
	}
	
	public void setProcessorsMap(
			Map<ProcessorFactory.Module, IModuleProcessor> processorsMap) {
		this.processorsMap = processorsMap;
	}
	
	

	public enum Module {
		Books, Colleges,user
	}

	public IModuleProcessor getProcessor(ProcessorFactory.Module module) {
		return processorsMap.get(module);
	}

}
