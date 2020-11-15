package com.example.ahmed.exception;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public RestResponseEntityExceptionHandler() {
		super();
	}
	
      // if  a resourseNotfound Exception is thrown this method is called 
	@ExceptionHandler(ResourceNotFoundException.class)
	protected  ResponseEntity<ExceptionDetail> handleResourceNotFoundException
	(ResourceNotFoundException ex, WebRequest request){
		String Uri=((ServletWebRequest)request).getRequest().getRequestURI().toString();
		ExceptionDetail ExceptionDetail=new  ExceptionDetail(ex.getMessage(),request.getDescription(false));
		return new  ResponseEntity<> (ExceptionDetail, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(MissingServletRequestParameterException.class)
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
	MissingServletRequestParameterException ex, HttpHeaders headers, 
	  HttpStatus status, WebRequest request) {
	  
	    
	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}
   




}