package com.vehicle.globalHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.customexecption.BrandNotFoundException;
import com.vehicle.customexecption.IdNotFoundException;
import com.vehicle.customexecption.InvalidBoardException;

@RestControllerAdvice
public class GlobalHandler {

	@ExceptionHandler(BrandNotFoundException.class)
	public ResponseEntity<Object> brandhandler() {
		return new ResponseEntity<>("Brand not available", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidBoardException.class)
	public ResponseEntity<Object> invalidBrand() {
		return new ResponseEntity<>("brand not ava", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IdNotFoundException.class)

	public ResponseEntity<Object> IdNotFoundException() {

		return new ResponseEntity<>("ID not available", HttpStatus.BAD_REQUEST);
	}

}
