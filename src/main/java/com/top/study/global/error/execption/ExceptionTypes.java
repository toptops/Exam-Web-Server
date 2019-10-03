package com.top.study.global.error.execption;

import com.top.study.global.error.ResultTypes;

public interface ExceptionTypes {
	public abstract int serialNumber();
	public abstract String message();
	public abstract Class< ? extends RootExecption > getExceptionClass();
	public abstract ResultTypes getErrorTypes();
}
