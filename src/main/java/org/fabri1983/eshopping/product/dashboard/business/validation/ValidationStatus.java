package org.fabri1983.eshopping.product.dashboard.business.validation;

import org.fabri1983.eshopping.product.dashboard.business.exception.BusinessException;
import org.fabri1983.eshopping.product.dashboard.business.exception.DashboardEntityException;
import org.fabri1983.eshopping.product.dashboard.business.exception.EntityIdException;
import org.fabri1983.eshopping.product.dashboard.business.exception.EntityVersionMismatchException;

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
	},
	ENTITY_VERSION_MISMATCH(1004, "Entity version mismatched.") {
		@Override
		public BusinessException _throw() {
			throw new EntityVersionMismatchException(code, message);
		}
		@Override
		public BusinessException _throwWith(Throwable cause) {
			throw new EntityVersionMismatchException(code, message, cause);
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
