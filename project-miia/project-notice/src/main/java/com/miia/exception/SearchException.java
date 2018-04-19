/**
 * all Copyright 2018 MIIA
 */
package com.miia.exception;

import com.miia.base.exception.BaseException;

/**
 * 检索异常
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public class SearchException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -828362922453649545L;

	/**
	 * @param code
	 * @param message
	 * @param throwable
	 */
	public SearchException(int code, String message, Throwable throwable) {
		super(code, message, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param throwable
	 */
	public SearchException(int code, Throwable throwable) {
		super(code, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 */
	public SearchException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param throwable
	 */
	public SearchException(String message, Throwable throwable) {
		super(message, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SearchException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param throwable
	 */
	public SearchException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

}
