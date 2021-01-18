package com.main.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.main.configuration.Config;

public class Dispatcher extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class[] configClasses = {Config.class}; 
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mapStrings = {"/"};
		return mapStrings;
	}

}
