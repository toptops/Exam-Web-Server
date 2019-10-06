package com.top.study.global.error.execption;

import com.top.study.global.error.ResultTypes;

public enum GlobalExecptions implements ExceptionTypes{
	MethodNotAllowed	(1003, "MethodNotAllow", ResultTypes.MethodNotAllow),
	InternalServerError (1004, "Server Error", ResultTypes.InternalError),
	AccessDenied		(1005, "Access is Denied", ResultTypes.Forbidden),
	BadResquest			(1006, "Bad Request", ResultTypes.BadRequest);
	
	private int serialNumber;
	private String message;
	private ResultTypes errorType;
	
	private GlobalExecptions(int serialNumber, String message, ResultTypes errorType) {
		this.serialNumber = serialNumber;
		this.message = message;
		this.errorType = errorType;
	}

	@Override
	public int serialNumber() {
		// TODO Auto-generated method stub
		return serialNumber;
	}

	@Override
	public String message() {
		// TODO Auto-generated method stub
		return message;
	}

	@Override
	public Class<? extends RootExecption> getExceptionClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultTypes getErrorTypes() {
		// TODO Auto-generated method stub
		return errorType;
	}

}
