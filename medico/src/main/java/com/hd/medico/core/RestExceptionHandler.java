package com.hd.medico.core;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hd.medico.model.common.ApplicationConstant;
import com.hd.medico.model.common.ResultJson;

/**
 * @author raj.hirani
 *
 */
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ResultJson(ApplicationConstant.FAILED, ex, error,HttpStatus.BAD_REQUEST));
	}
	
	private ResponseEntity<Object> buildResponseEntity(ResultJson apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
