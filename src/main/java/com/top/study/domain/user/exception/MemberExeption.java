package com.top.study.domain.user.exception;

import com.top.study.global.error.ResultTypes;
import com.top.study.global.error.execption.RootExecption;

public class MemberExeption extends RootExecption{

	private static final long serialVersionUID = 2947936445283152292L;

	public MemberExeption(int serialNumber, String message, ResultTypes resultTypes) {
		super(serialNumber, message, resultTypes);
	}

	public MemberExeption(int serialNumber, String message, ResultTypes resultTypes, Throwable e) {
		super(serialNumber, message, resultTypes, e);
	}
}
