package demo.model;

import java.io.Serializable;

public class CommonResponse implements Serializable{

	String code;
	String type;
	String message;
	
	CommonResponseBody response;
	
	
	
	public CommonResponse(String code, String type, String message, 
			CommonResponseBody  response) {
		super();
		this.code = code;
		this.type = type;
		this.message = message;
		this.response = response;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public CommonResponseBody getResponse() {
		return response;
	}

	public void setResponse(CommonResponseBody response) {
		this.response = response;
	}

	
	
	
}
