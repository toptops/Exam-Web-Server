package com.top.study.global.config;

import java.util.Collection;

import javax.validation.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public class CustomValidation implements Validator{

	private SpringValidatorAdapter validator;
	
	public CustomValidation() {
		this.validator = new SpringValidatorAdapter(Validation.buildDefaultValidatorFactory().getValidator());
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof Collection) {
			
		} else {
			validator.validate(target, errors);
		}
				
	}

}
