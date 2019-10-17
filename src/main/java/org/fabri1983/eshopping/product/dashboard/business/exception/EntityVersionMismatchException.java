package org.fabri1983.eshopping.product.dashboard.business.exception;

public class EntityVersionMismatchException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntityVersionMismatchException(int code, String message, Throwable cause) {
		super(code, message, cause);
	}

	public EntityVersionMismatchException(int code, String message) {
		super(code, message);
	}
	
	public EntityVersionMismatchException(int code, String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(code, message, cause, enableSuppression, writableStackTrace);
	}

}
