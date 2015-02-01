package com.infy.exceptions;
/**
 * 
 * @author anoop_jadon
 *
 */
public class BaseException extends Exception 
{
	// Variable declaration
	private static final long serialVersionUID = 1L;
	
	//constructors
	public BaseException(String message)
	{
		super(message);
	}
	
	public BaseException(Throwable exception)
	{
		super(exception);
	}
	
	public BaseException(String message, Throwable exception)
	{
		super(message,exception);
	}

}