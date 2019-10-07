package com.top.study.global.error;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.top.study.global.dto.ErrorResponse;
import com.top.study.global.dto.ErrorResponseFactory;
import com.top.study.global.error.execption.GlobalExecptions;
import com.top.study.global.error.execption.RootExecption;

@ControllerAdvice
public class GlobalExceptionController {
	private static final Logger logger = LogManager.getLogger(GlobalExceptionController.class);
	private final ErrorResponseFactory errorResponseFactory = ErrorResponseFactory.getInstance(); 
	
	@ExceptionHandler(RootExecption.class)
	protected ResponseEntity<ErrorResponse> rootExecption(RootExecption e) { 
		logger.error("HttpRequestMethodNotSupported Exception : ", e);
		
		final ErrorResponse errorResopnse = errorResponseFactory.create(e);
		return new ResponseEntity<>(errorResopnse, HttpStatus.valueOf(errorResopnse.getErrordCode()));
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) { 
		logger.error("HttpRequestMethodNotSupported Exception", e);
		
		final ErrorResponse errorResopnse = errorResponseFactory.create(GlobalExecptions.MethodNotAllowed, "");
		return new ResponseEntity<>(errorResopnse, HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	protected ResponseEntity<ErrorResponse> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e, HttpServletRequest reqeust) { 
		logger.error("MethodArgumentTypeMismatch Exception : ", e);
		
		Map<String, Object> errorContent = new HashMap<>();
		errorContent.put("BadParameter Data", e.getValue());
		
		final ErrorResponse errorResopnse = errorResponseFactory.create(GlobalExecptions.BadResquest, errorContent);
		return new ResponseEntity<>(errorResopnse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<ErrorResponse> accessDeniedExeption(AccessDeniedException e) { 
		logger.error("AccessDenied Exception : ", e);
		
		final ErrorResponse errorResopnse = errorResponseFactory.create(GlobalExecptions.AccessDenied, "");
		return new ResponseEntity<>(errorResopnse, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponse> basicException(Exception e) { 
		logger.error("Basic Exception : ", e);
		
		final ErrorResponse errorResopnse = errorResponseFactory.create(GlobalExecptions.InternalServerError, "");
		return new ResponseEntity<>(errorResopnse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
