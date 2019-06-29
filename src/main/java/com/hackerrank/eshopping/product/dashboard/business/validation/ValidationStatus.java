package com.hackerrank.eshopping.product.dashboard.business.validation;

import com.hackerrank.eshopping.product.dashboard.business.exception.BusinessException;
import com.hackerrank.eshopping.product.dashboard.business.exception.DashboardEntityException;
import com.hackerrank.eshopping.product.dashboard.business.exception.EntityIdException;

public enum ValidationStatus {
	
	PRODUCT_ID_ALREADY_EXIST(1001, "Product Id already exists.") {
		@Override
		public BusinessException _throw() {
			throw new EntityIdException(code, message);
		}
		@Override
		public BusinessException _throwWith(Throwable cause) {
			throw new EntityIdException(code, message, cause);
		}
	},
	PRODUCT_DOES_NOT_EXIST(1002, "Product does not exist.") {
		@Override
		public BusinessException _throw() {
			throw new DashboardEntityException(code, message);
		}
		@Override
		public BusinessException _throwWith(Throwable cause) {
			throw new DashboardEntityException(code, message, cause);
		}
	},
	PRODUCT_ID_DOES_NOT_EXIST(1003, "Product Id does not exist.") {
		@Override
		public BusinessException _throw() {
			throw new EntityIdException(code, message);
		}
		@Override
		public BusinessException _throwWith(Throwable cause) {
			throw new EntityIdException(code, message, cause);
		}
	};

	int code;
	String message;
	
	ValidationStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public abstract BusinessException _throw();
	
	public abstract BusinessException _throwWith(Throwable cause);
	
}
