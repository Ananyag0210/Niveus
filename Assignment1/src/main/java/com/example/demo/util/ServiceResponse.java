package com.example.demo.util;

import org.springframework.http.HttpStatus;

public class ServiceResponse<T> {

	private HttpStatus status;
	private String message;
	private T t;
	
	public ServiceResponse(HttpStatus status, String message, T t) {
		super();
		this.status = status;
		this.message = message;
		this.t = t;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	@Override
	public String toString() {
		return "ServiceResponse [status=" + status + ", message=" + message + ", t=" + t + "]";
	}
	
	
}
