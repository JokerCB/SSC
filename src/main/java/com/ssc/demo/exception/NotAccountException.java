package com.ssc.demo.exception;

import org.apache.shiro.authc.AuthenticationException;

public class NotAccountException extends AuthenticationException{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -3656195545108687237L;

	/**
     * Creates a new NotAccountException.
     */
    public NotAccountException() {
        super();
    }

    /**
     * Constructs a new NotAccountException.
     *
     * @param message the reason for the exception
     */
    public NotAccountException(String message) {
        super(message);
    }

    /**
     * Constructs a new NotAccountException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public NotAccountException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new NotAccountException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public NotAccountException(String message, Throwable cause) {
        super(message, cause);
    }


}
