package com.top.study.global.constant;

import lombok.Getter;

@Getter
public enum ResultType {
	Success (1),
	NotContents  (2),
	ExceptionError (-1);
	
	private int strResult;
	
	private ResultType(int strResult) {
		this.strResult = strResult;
	}
}
