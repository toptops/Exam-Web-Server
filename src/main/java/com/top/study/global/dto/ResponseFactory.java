package com.top.study.global.dto;

import java.lang.ref.WeakReference;

import com.top.study.global.constant.ResultType;

public class ResponseFactory {
	private static volatile ResponseFactory instance = null;
	
	public static ResponseFactory getInstance() {
		if(instance == null) {
			synchronized (ResponseFactory.class) {
				if(instance == null) {
					instance = new ResponseFactory();
				}
			}
		}
		
		return instance;
	}
	
	public RestResponse create(String message) {
		return this.createResponse(ResultType.Success, message, null);
	}	
	
	public RestResponse create(String message, Object Content) {
		return this.createResponse(ResultType.Success, message, Content);
	}
	
	public RestResponse create(ResultType resultType, String message, Object Content) {
		return this.createResponse(resultType, message, Content);
	}
	
	private RestResponse createResponse(ResultType resultType, String message, Object Content) {
		RestResponse restResponse = new RestResponse(resultType, message, Content);
		
		return new WeakReference<>(restResponse).get();
	}
}
