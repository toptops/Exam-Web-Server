package com.top.study.global.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.top.study.global.error.ResultTypes;
import com.top.study.global.error.execption.ExceptionTypes;
import com.top.study.global.error.execption.RootExecption;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private int errordCode;
	private int serialNumber;
	private String message;
	private Object errorContent;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime createAt;
	
	public ErrorResponse(ResultTypes resultTypes, int serialNumber, String message, Object errorContent) {
		this.errordCode = resultTypes.getStatus();
		this.message = message;
		this.errorContent = errorContent;
		this.serialNumber = serialNumber;
		this.createAt = LocalDateTime.now();
	}
}
