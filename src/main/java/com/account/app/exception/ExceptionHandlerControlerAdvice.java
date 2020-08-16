package com.account.app.exception;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.account.app.model.ExceptionResponse;



@ControllerAdvice
public class ExceptionHandlerControlerAdvice {

	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleAccountNotFound(
			final AccountNotFoundException accountNotFoundException, final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(accountNotFoundException.getMessage());
		error.setRequestedUri(request.getRequestURI());

		return error;

	}

	@ExceptionHandler(AccountServiceException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleAccountServiceException(
			final AccountServiceException accountServiceException, final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(accountServiceException.getMessage());
		error.setRequestedUri(request.getRequestURI());

		return error;
	}
	
	@ExceptionHandler(AccountExsistedException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleAccountExsistedException(
			final AccountExsistedException accountExsistedException, final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(accountExsistedException.getMessage());
		error.setRequestedUri(request.getRequestURI());

		return error;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleCustomerNotFoundException(
			final CustomerNotFoundException exception, final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.setRequestedUri(request.getRequestURI());

		return error;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public @ResponseBody ExceptionResponse handleValidationExceptions(
	  MethodArgumentNotValidException ex,final HttpServletRequest request) {
		
		ExceptionResponse error = new ExceptionResponse();
		
		error.setRequestedUri(request.getRequestURI());
	   
		List<ObjectError> errors=ex.getBindingResult().getAllErrors();
		Iterator<ObjectError> it=errors.iterator();
		String errMsg="";
		while(it.hasNext()) {
			
		 ObjectError err=it.next();
		String  errMs1g=((FieldError) err).getField()+" -"+err.getDefaultMessage();
		 errMsg=errMs1g+",";
		 
		}
		error.setErrorMessage(errMsg);
	    return error;
	}
}
