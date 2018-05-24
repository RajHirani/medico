package com.hd.medico.core.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hd.medico.model.common.ApplicationConstant;
import com.hd.medico.model.common.ResultJson;

/**
 * @author raj.hirani
 *
 */
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ResultJson(ApplicationConstant.FAILED, ex, error, HttpStatus.BAD_REQUEST));
	}

	@ExceptionHandler(GenericException.class)
	public final ResponseEntity<ResultJson> handleAllExceptions(Exception ex, WebRequest request) {
		ResultJson errorDetails = new ResultJson(ApplicationConstant.FAILED, request.getDescription(false),
				ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * @param apiError
	 * @return
	 */
	private ResponseEntity<Object> buildResponseEntity(ResultJson apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}