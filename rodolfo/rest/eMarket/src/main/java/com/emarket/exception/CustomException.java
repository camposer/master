package com.emarket.exception;


public class CustomException extends Exception {
	private static final long serialVersionUID = 3026393903863754932L;
	
	public CustomException() {
		this(null);
	}
	
	public CustomException(String mensaje) {
		super(mensaje);
	}
	
}
