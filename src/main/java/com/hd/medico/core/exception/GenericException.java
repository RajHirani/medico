package com.hd.medico.core.exception;

/**
 * @author Raj Hirani
 *
 */
public class GenericException extends Exception{

	public GenericException() {
		super();
	}
	
	public GenericException(Exception exception){
		super(exception);
	}
	
	public GenericException(String message){
		super(message);
	}
	
	public GenericException(String message, Exception exception){
		super(message, exception);
	}
}
