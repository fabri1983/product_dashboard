package org.fabri1983.eshopping.product.dashboard.business.exception;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	int code;
	
	public BusinessException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public BusinessException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public BusinessException(int code, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
}
