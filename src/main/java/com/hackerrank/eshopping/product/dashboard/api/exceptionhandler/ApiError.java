package com.hackerrank.eshopping.product.dashboard.api.exceptionhandler;

public class ApiError {

	private int code;
	private String message;

	public static ApiError from(int code, String message) {
		ApiError newObj = new ApiError();
		newObj.code = code;
		newObj.message = message;
		return newObj;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

}
