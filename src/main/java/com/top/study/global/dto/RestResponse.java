package com.top.study.global.dto;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.top.study.global.error.ResultTypes;

import lombok.Getter;

@Getter
public class RestResponse {

	private ResultTypes resultType;
	private String message;
	private Object contents;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private Date createAt;
	
	public RestResponse() {};
	
	public RestResponse(ResultTypes resultTypes, String message, Object contents) {
		this.resultType = resultTypes;
		this.message = message;
		this.contents = contents;
		this.createAt = Calendar.getInstance(Locale.KOREA).getTime();
	}
}
