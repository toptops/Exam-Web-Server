package com.top.study.global.dto;

import com.top.study.global.constant.ResultType;

import lombok.Getter;

@Getter
public class RestResponse {

	private ResultType resultType;
	private String message;
	private Object contents;
	
	public RestResponse() {};
	
	public RestResponse(ResultType resultType, String message, Object contents) {
		this.resultType = resultType;
		this.message = message;
		this.contents = contents;
	}
}
