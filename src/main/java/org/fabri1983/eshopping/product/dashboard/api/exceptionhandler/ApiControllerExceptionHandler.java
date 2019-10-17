package org.fabri1983.eshopping.product.dashboard.api.exceptionhandler;

import org.fabri1983.eshopping.product.dashboard.api.exception.ApiUnsupportedEncodingException;
import org.fabri1983.eshopping.product.dashboard.business.exception.BusinessException;
import org.fabri1983.eshopping.product.dashboard.business.exception.DashboardEntityException;
import org.fabri1983.eshopping.product.dashboard.business.exception.EntityIdException;
import org.fabri1983.eshopping.product.dashboard.business.exception.EntityVersionMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ DashboardEntityException.class })
	protected ResponseEntity<ApiError> handle404EntityNotFound(BusinessException cause) {
		ApiError apiError = ApiError.from(cause.getCode(), cause.getMessage());
		return buildResponseEntity(HttpStatus.NOT_FOUND, apiError);
	}
	
	@ExceptionHandler({ EntityIdException.class })
	protected ResponseEntity<ApiError> handle400EntityException(BusinessException cause) {
		ApiError apiError = ApiError.from(cause.getCode(), cause.getMessage());
		return buildResponseEntity(HttpStatus.BAD_REQUEST, apiError);
	}
	
	@ExceptionHandler({ EntityVersionMismatchException.class })
	protected ResponseEntity<ApiError> handle409EntityException(BusinessException cause) {
		ApiError apiError = ApiError.from(cause.getCode(), cause.getMessage());
		return buildResponseEntity(HttpStatus.CONFLICT, apiError);
	}
	
	@ExceptionHandler({ ApiUnsupportedEncodingException.class })
	protected ResponseEntity<ApiError> handle400EncodingException(RuntimeException cause) {
		ApiError apiError = ApiError.from(-1, cause.getMessage());
		return buildResponseEntity(HttpStatus.BAD_REQUEST, apiError);
	}
	
	@ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<ApiError> handleRunTimeException(RuntimeException cause) {
		ApiError apiError = ApiError.from(-1, cause.getMessage());
		return buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, apiError);
    }
	
	private ResponseEntity<ApiError> buildResponseEntity(HttpStatus status, ApiError apiError) {
		return ResponseEntity
				.status(status)
				.body(apiError);
	}
	
}
