package com.jbk.exceptions;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, Object> methodArgumentNotValid( MethodArgumentNotValidException ex) {
		Map<String, Object> errorMap=new HashMap<>();
		List<FieldError> fieldErrors = ex.getFieldErrors();
		
		for (FieldError fieldError : fieldErrors) {
			errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return errorMap;
		
		
	}
	
	@ExceptionHandler(SupplierAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public Map<String, Object> supplierAlreadyExists(SupplierAlreadyExistsException ex) {
		Map<String, Object> map=new HashMap<>();
		map.put("Timestamp", new Date());
		map.put("Default Message", ex.getMessage());
		return map;
		
	}
	
}
