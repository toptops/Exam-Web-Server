package com.top.study.global.dto;

import java.lang.ref.WeakReference;

import com.top.study.global.error.ResultTypes;
import com.top.study.global.error.execption.ExceptionTypes;
import com.top.study.global.error.execption.RootExecption;

public class ErrorResponseFactory {
	private static volatile ErrorResponseFactory instance = null;
	
	public static ErrorResponseFactory getInstance() {
		if(instance == null) {
			synchronized (RestResponseFactory.class) {
				if(instance == null) {
					instance = new ErrorResponseFactory();
				}
			}
		}
		
		return instance;
	}
	
	public ErrorResponse create(final RootExecption rootExecption) {
		return this.createErrorResponse(rootExecption.getErrorType(), rootExecption.getSerialNumber(), rootExecption.getMessage(), rootExecption.getErrorContent());
	}
	
	public ErrorResponse create(final ExceptionTypes exceptionTypes, final Object errorContent) {
		return this.createErrorResponse(exceptionTypes.getErrorTypes(), exceptionTypes.serialNumber(), exceptionTypes.message(), errorContent);
	}
	
	private ErrorResponse createErrorResponse(final ResultTypes resultTypes, final int serialNumber, final String message, final Object errorContent) {
		ErrorResponse errorResponse = new ErrorResponse(resultTypes, serialNumber, message, errorContent);
		
		return new WeakReference<>(errorResponse).get();
	}
}
