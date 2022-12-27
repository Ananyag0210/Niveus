package com.example.demo.util;

import org.springframework.http.HttpStatus;

public class Response {
	
	private String status;
	private String message;
	private Object data;
	
	public Response(HttpStatus httpStatus,String message,Object data)
	{
		super();
		if(httpStatus == HttpStatus.OK || httpStatus == HttpStatus.CREATED)
		{
			this.status = "Success";
		}
		else
		{
			this.status = "Error";
		}
		this.data = data;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
	

}
