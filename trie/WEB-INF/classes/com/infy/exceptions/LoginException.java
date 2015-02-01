package com.infy.exceptions;
/**
 * 
 * @author anoop_jadon
 *
 */
public class LoginException extends BaseException {

	/**
	 * variable Declaration
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  declaring constructors.
	 */
	public LoginException(String message) {
		super(message);

	}

	public LoginException(String message, Throwable exception) {
		super(message, exception);

	}


	public LoginException(Throwable exception) {
		super(exception);
	}

}
