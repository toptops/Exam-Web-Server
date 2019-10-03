package com.top.study.domain.user.exception;

import java.util.Map;

import com.top.study.global.error.ResultTypes;
import com.top.study.global.error.execption.RootExecption;

public class MemberExecption extends RootExecption{

	private static final long serialVersionUID = 2947936445283152292L;

	public MemberExecption(int serialNumber, String message, ResultTypes resultTypes) {
		super(serialNumber, message, resultTypes);
	}
	
	public MemberExecption(int serialNumber, String message, ResultTypes resultTypes, Map<String, Object> errorContent) {
		super(serialNumber, message, resultTypes, errorContent);
	}
	
	public MemberExecption(int serialNumber, String message, ResultTypes resultTypes, Throwable e) {
		super(serialNumber, message, resultTypes, e);
	}

	public MemberExecption(int serialNumber, String message, ResultTypes resultTypes, Map<String, Object> errorContent, Throwable e) {
		super(serialNumber, message, resultTypes, errorContent, e);
	}
}
