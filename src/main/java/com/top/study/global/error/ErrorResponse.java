package com.top.study.global.error;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private String errordCode;
	private int serialNumber;
	private String message;
	private Object errorContent;
	
	public ErrorResponse(String errorCode, int serialNumber, String message, Object errorContent) {
		this.errordCode = errorCode;
		this.message = message;
		this.errorContent = errorContent;
		this.serialNumber = serialNumber;
	}
	
	public static ErrorResponse take(final String errorCode, final int serialNumber, final String message, final Object errorContent) {
		return new ErrorResponse(errorCode, serialNumber, message, errorContent);
	}
}
