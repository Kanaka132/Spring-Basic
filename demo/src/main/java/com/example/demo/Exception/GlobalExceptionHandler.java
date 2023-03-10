package com.example.demo.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.Exception.*;





@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
	        String message = e.getMessage();
	        ApiResponse apiResponse = new ApiResponse(message, false);
	        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	    }

	  @ExceptionHandler(ResourceAlreadyExistsException.class)
	    public ResponseEntity<ApiResponse> resourceAlreadyExistsExceptionHandler(ResourceAlreadyExistsException e){
	        String message = e.getMessage();
	        ApiResponse apiResponse = new ApiResponse(message, false);
	        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.BAD_REQUEST);
	    }
}
