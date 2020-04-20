package com.mindtree.CMS.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.mindtree.CMS.model.ApiErrorResponse;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	private ResponseEntity<Object> buildResponseEntity(ApiErrorResponse response, HttpStatus httpStatus) {

		return ResponseEntity.status(httpStatus).header("status", String.valueOf(httpStatus)).body(response);
	}

	@ExceptionHandler(CartBusinessException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public final ResponseEntity<Object> handleBatchServiceExceptions(CartBusinessException ex, WebRequest request) {
		ApiErrorResponse response = new ApiErrorResponse();

		response.setCause(ex.getLocalizedMessage());
		response.setMessage(ex.getMessage());
		response.setHttpStatus(HttpStatus.CONFLICT);
		response.setHttpStatusCode(100);
		response.setError(true);

		return buildResponseEntity(response, HttpStatus.CONFLICT);

	}

}
