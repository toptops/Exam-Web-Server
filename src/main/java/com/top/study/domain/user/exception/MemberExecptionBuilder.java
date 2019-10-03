package com.top.study.domain.user.exception;

import java.lang.reflect.Constructor;
import java.util.Map;

import com.top.study.global.error.ResultTypes;
import com.top.study.global.error.execption.ExceptionTypes;
import com.top.study.global.error.execption.RootExecption;

public class MemberExecptionBuilder {

	private Class < ? extends RootExecption> exceptionType;
	private int serialNumber;
	private String message;
	private ResultTypes errorType;
	private Map<String, Object> errorContent;
	private Throwable execptionCause;
	
	
	public MemberExecptionBuilder(Class< ? extends RootExecption> exceptionType) {
		this.exceptionType = exceptionType;
	}
	
	public static MemberExecptionBuilder newBuilder(ExceptionTypes type) {
		MemberExecptionBuilder builder = new MemberExecptionBuilder(type.getExceptionClass());
		
		builder.serialNumber = type.serialNumber();
		builder.message = type.message();
		builder.errorType = type.getErrorTypes();
		
		return builder;
	}
	
	public MemberExecption build() {
		Class< ? > param[] = new Class< ? >[] {
			int.class,
			String.class,
			ResultTypes.class,
			Map.class,
			Throwable.class
		};
		
		Constructor< ? extends RootExecption> constructor = null;
		try {
			constructor = exceptionType.getDeclaredConstructor(param);
			Object[] args = {serialNumber, message, errorType, errorContent, execptionCause};
			return (MemberExecption) constructor.newInstance(args);
		} catch (Exception e) {
			System.out.println("error ");
			System.out.println(e);
			return null;
		}
	}
	
	public MemberExecptionBuilder execptionCause(Throwable e) {
		this.execptionCause = e;
		
		return this;
	}
	
	public MemberExecptionBuilder errorContent(Map<String, Object> errorContent) {
		this.errorContent = errorContent;
		
		return this;
	}
	
	public MemberExecptionBuilder errorType(ResultTypes errorType) {
		this.errorType = errorType;
		
		return this;
	}
}
