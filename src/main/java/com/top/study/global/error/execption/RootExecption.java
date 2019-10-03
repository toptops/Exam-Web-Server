package com.top.study.global.error.execption;

import com.top.study.global.error.ResultTypes;

import lombok.Getter;

@Getter
public class RootExecption extends RuntimeException{

	private static final long serialVersionUID = -8237437295445801278L;
	
	private int serialNumber;
	private ResultTypes resultTypes;
	private String message;
	
	public RootExecption(int serialNumber, String message, ResultTypes resultTypes, Throwable e) {
		super(message, e);
	}

	public RootExecption(int serialNumber, String message,ResultTypes resultTypes) {
		super(message);
	}
}
