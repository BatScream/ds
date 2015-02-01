package com.infy.exceptions;
/**
 * 
 * @author anoop_jadon
 *
 */
public class AddPatchException extends BaseException{

	/**
	 * variable Declaration
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  declaring constructors.
	 */
	public AddPatchException(String message) {
		super(message);

	}

	public AddPatchException(String message, Throwable exception) {
		super(message, exception);

	}


	public AddPatchException(Throwable exception) {
		super(exception);
	}
}
