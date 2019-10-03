package com.top.study.global.error;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private String errordCode;
	private String message;
	
	public ErrorResponse(String errorCode, String message) {
		this.errordCode = errorCode;
		this.message = message;
	}
}
