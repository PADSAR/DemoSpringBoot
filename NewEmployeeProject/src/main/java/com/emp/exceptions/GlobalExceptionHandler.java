package com.emp.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DuplicateEmpIdException.class)
	public ResponseEntity<ExceptionResponce>handlerDuplicateEmpIdException(DuplicateEmpIdException e){
		ExceptionResponce  error = new ExceptionResponce("Duplicate Id",e.getMessage(),LocalDateTime.now());
		return new  ResponseEntity<ExceptionResponce>(error,HttpStatus.CONFLICT);
	}
}
