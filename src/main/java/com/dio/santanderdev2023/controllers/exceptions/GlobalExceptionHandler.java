package com.dio.santanderdev2023.controllers.exceptions;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String>handleBusinessExeption
	(IllegalArgumentException businessException){
		
		return new ResponseEntity<>(businessException.getMessage()
				,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String>handleNotFoundException
	(NoSuchElementException notFoundExeption){
		
		return new ResponseEntity<>("ID do recurso não encontrado"
				,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String>handleUnexpectedException
	(Throwable unexpectedException){
		var message="erro inesperado do servidor, consulte o log";
		logger.error(message,unexpectedException);
		return new ResponseEntity<>("Excessão inesperada"
				,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
