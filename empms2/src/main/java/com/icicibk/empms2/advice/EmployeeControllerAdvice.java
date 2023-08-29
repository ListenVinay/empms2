package com.icicibk.empms2.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.icicibk.empms2.exceptions.IdNotFoundException;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(IdNotFoundException e){
		Map<String,String> map = new HashMap<>();
		map.put("exception", e.getMessage());
		map.put("status", "404");
		return new ResponseEntity(map,HttpStatus.NOT_FOUND) ;
	}
}
