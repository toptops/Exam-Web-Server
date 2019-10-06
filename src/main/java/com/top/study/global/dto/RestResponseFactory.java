package com.top.study.global.dto;

import java.lang.ref.WeakReference;

import com.top.study.global.error.ResultTypes;

public class RestResponseFactory {
	private static volatile RestResponseFactory instance = null;
	
	public static RestResponseFactory getInstance() {
		if(instance == null) {
			synchronized (RestResponseFactory.class) {
				if(instance == null) {
					instance = new RestResponseFactory();
				}
			}
		}
		
		return instance;
	}
	
	public RestResponse create(String message) {
		return this.createResponse(ResultTypes.Success, message, null);
	}	
	
	public RestResponse create(String message, Object Content) {
		return this.createResponse(ResultTypes.Success, message, Content);
	}
	
	public RestResponse create(ResultTypes resultTypes, String message, Object Content) {
		return this.createResponse(resultTypes, message, Content);
	}
	
	private RestResponse createResponse(ResultTypes resultTypes, String message, Object Content) {
		RestResponse restResponse = new RestResponse(resultTypes, message, Content);
		
		return new WeakReference<>(restResponse).get();
	}
}
