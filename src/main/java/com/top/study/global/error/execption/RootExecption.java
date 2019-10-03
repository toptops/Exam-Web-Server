package com.top.study.global.error.execption;

import java.util.Map;

import com.top.study.global.error.ResultTypes;

import lombok.Getter;

@Getter
public class RootExecption extends RuntimeException{

	private static final long serialVersionUID = -8237437295445801278L;
	
	private int serialNumber;
	private ResultTypes errorType;
	private String message;
	private Map<String, Object> errorContent;
	

	public RootExecption(int serialNumber, String message, ResultTypes errorType) {
		this(serialNumber, message, errorType, null, null);
	}
	
	public RootExecption(int serialNumber, String message, ResultTypes errorType, Map<String, Object> errorContent) {
		this(serialNumber, message, errorType, errorContent, null);
	}
	
	public RootExecption(int serialNumber, String message, ResultTypes errorType, Throwable e) {
		this(serialNumber, message, errorType, null, e);
	}
	
	public RootExecption(int serialNumber, String message, ResultTypes errorType, Map<String, Object> errorContent, Throwable e) {
		super(message, e);
		
		if(serialNumber < 0 || serialNumber > 9999) {
			throw new IllegalArgumentException("SerialNumber is out of rage... (number : " + serialNumber + ")");
		}
		
		this.serialNumber = serialNumber;
		this.message = message;
		this.errorType = errorType;
		this.errorContent = errorContent;
	}

}
