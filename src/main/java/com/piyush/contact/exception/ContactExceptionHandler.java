package com.piyush.contact.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.piyush.contact.constants.ResponseMessages;
import com.piyush.contact.model.ResponseError;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * This is global level REST API exception handler This class will handle if any
 * exception is thrown for any request This Response error format will be common
 * for all the request
 * 
 * @author PIYUSH ANJIKAR
 *
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ContactExceptionHandler {

	/**
	 * Entity request by user is not present then EntityNotFoundException will be
	 * thrown and this method handles the EntityNotFoundException and return the
	 * response with appropriate message
	 * 
	 * @param EntityNotFoundException
	 * @return ResponseError
	 *
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseError handleEntityNotFoundException(EntityNotFoundException exception) {
		log.error("EntityNotFoundException : ", exception);
		ResponseError responseError = new ResponseError(HttpStatus.NOT_FOUND, exception.getMessage());
		return responseError;
	}

	/**
	 * Entity request by user is already present then DuplicateEntityException will
	 * be thrown and this method handles the exception and return the response with
	 * appropriate message
	 * 
	 * @param DuplicateEntityException
	 * @return ResponseError
	 * 
	 */
	@ExceptionHandler(DuplicateEntityException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ResponseError handleDuplicateEntityFoundException(DuplicateEntityException exception) {
		log.error("DuplicateEntityException  : ", exception);
		ResponseError responseError = new ResponseError(HttpStatus.CONFLICT, exception.getMessage());
		return responseError;
	}

	/**
	 * 
	 * Exception to be thrown when validation on an argument annotated with @Valid
	 * fails This method handle such exception and return the response in
	 * appropriate format
	 * 
	 * @param MethodArgumentNotValidException
	 * @return ResponseError
	 * 
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseError handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		log.error("MethodArgumentNotValidException  : ", exception);
		List<String> errors = new ArrayList<String>();
		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		ResponseError responseError = new ResponseError(HttpStatus.BAD_REQUEST, errors);
		return responseError;
	}

	/**
	 * This method handles the internal server errors
	 * 
	 * @param Exception
	 * @return ResponseError
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseError handleInternalServerError(Exception exception) {
		log.error("Internal Server Error  : ", exception);
		ResponseError responseError = new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR,
				ResponseMessages.INTERNAL_SERVER_ERROR);
		return responseError;
	}
}
