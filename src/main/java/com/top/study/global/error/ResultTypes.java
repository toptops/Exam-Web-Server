package com.top.study.global.error;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public enum ResultTypes {
	Success 		("200", 200),
	BadRequest		("400", 400),
	Forbidden 		("403", 403),
	MethodNotAllow  ("405", 405),
	InternalError 	("500", 500);
	
	
	private static final Map<Integer, ResultTypes> STATUS;
	private static final Map<String, ResultTypes> CODE;
	
	
	static {
		STATUS = new HashMap<>();
		CODE = new HashMap<>();
		
		for (ResultTypes type : ResultTypes.values()) {
			STATUS.put(type.getStatus(), type);
			CODE.put(type.getCode(), type);
		}
	}
	
	private String code;
	private int status;
	
	private ResultTypes(String code, int status) {
		this.code = code;
		this.status = status;
	}
	
	public int httpStatus() {
		return status;
	}
	
	public String resultCode() {
		return this.code;
	}
}
