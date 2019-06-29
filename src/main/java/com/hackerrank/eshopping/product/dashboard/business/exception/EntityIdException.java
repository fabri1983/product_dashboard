package com.hackerrank.eshopping.product.dashboard.business.exception;

public class EntityIdException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntityIdException(int code, String message, Throwable cause) {
		super(code, message, cause);
	}

	public EntityIdException(int code, String message) {
		super(code, message);
	}
	
	public EntityIdException(int code, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(code, message, cause, enableSuppression, writableStackTrace);
	}

}
