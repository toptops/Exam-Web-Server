package com.top.study.global.util;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class OtherMethod {
	
	public static Properties setJPAHibernateProperties(String path) {
		Resource resource = null;
		Properties prop = null;
		try {
			resource = new ClassPathResource(path);
			prop = PropertiesLoaderUtils.loadProperties(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}

}
