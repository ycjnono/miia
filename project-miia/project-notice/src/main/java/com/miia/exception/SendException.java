/**
 * all Copyright 2018 MIIA
 */
package com.miia.exception;

import com.miia.base.exception.BaseException;

/**
 * 通知发送异常
 * 
 * @author yan.changjiang
 * @since miia group for beijing
 * @Copyright 2018 MIIA
 */
public class SendException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1127287947693946332L;

	/**
	 * @param code
	 * @param message
	 * @param throwable
	 */
	public SendException(int code, String message, Throwable throwable) {
		super(code, message, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 * @param throwable
	 */
	public SendException(int code, Throwable throwable) {
		super(code, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param code
	 */
	public SendException(int code) {
		super(code);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param throwable
	 */
	public SendException(String message, Throwable throwable) {
		super(message, throwable);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SendException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param throwable
	 */
	public SendException(Throwable throwable) {
		super(throwable);
		// TODO Auto-generated constructor stub
	}

}
