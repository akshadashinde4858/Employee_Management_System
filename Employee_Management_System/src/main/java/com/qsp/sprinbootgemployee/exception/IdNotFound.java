package com.qsp.sprinbootgemployee.exception;

public class IdNotFound extends RuntimeException
{
	private String message;
	
	public IdNotFound(String message) 
	{
		super();
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
}