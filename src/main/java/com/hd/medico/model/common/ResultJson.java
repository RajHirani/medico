package com.hd.medico.model.common;

import java.io.Serializable;

public class ResultJson implements Serializable{
	
	int result;
	Object resultObject;
	String resultMessage;
	
	public ResultJson(int result, Object resultObject, String resultMessage) {
		this.result = result;
		this.resultObject = resultObject;
		this.resultMessage = resultMessage;
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
}
