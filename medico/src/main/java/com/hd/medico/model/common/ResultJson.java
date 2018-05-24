package com.hd.medico.model.common;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * @author raj.hirani
 *
 */
public class ResultJson implements Serializable{
	
	int result;
	Object resultObject;
	String resultMessage;
	HttpStatus status;
	
	public ResultJson(int result, Object resultObject, String resultMessage) {
		this.result = result;
		this.resultObject = resultObject;
		this.resultMessage = resultMessage;
	}
	
	public ResultJson(int result, Object resultObject, String resultMessage, HttpStatus status) {
		this.result = result;
		this.resultObject = resultObject;
		this.resultMessage = resultMessage;
		this.status = status;
	}
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Object getResultObject() {
		return resultObject;
	}
	public void setResultObject(Object resultObject) {
		this.resultObject = resultObject;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
