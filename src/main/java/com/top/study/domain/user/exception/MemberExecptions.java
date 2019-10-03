package com.top.study.domain.user.exception;

import com.top.study.global.error.ResultTypes;
import com.top.study.global.error.execption.ExceptionTypes;
import com.top.study.global.error.execption.RootExecption;

public enum MemberExecptions implements ExceptionTypes{
	
	NotFoundMemmber	 	(1001, "Member is not found, Check your Email" , ResultTypes.BadRequest),
	EmptyMember			(1002, "Member does not exist.", ResultTypes.BadRequest),
	MethodNotAllowed	(1003, "Invalid Input Value", ResultTypes.MethodNotAllow),
	InternalServerError (1004, "Server Error", ResultTypes.InternalError),
	AccessDenied		(1005, "Access is Denied", ResultTypes.Forbidden);
	
	private int serialNumber;
	private String message;
	private ResultTypes errorType;
	
	private static final Class< ? extends MemberExecption > EXCEPTION_TYPE = MemberExecption.class;
	
	private MemberExecptions(int serialNumber, String message, ResultTypes errorType) {
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
		return EXCEPTION_TYPE;
	}

	@Override
	public ResultTypes getErrorTypes() {
		// TODO Auto-generated method stub
		return errorType;
	}

}
