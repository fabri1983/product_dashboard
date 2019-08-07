package org.fabri1983.eshopping.product.dashboard.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

public class HttpBearerRequestPostProcessor implements RequestPostProcessor {
	
	private String headerName;
	private String headerValue;
	
	private HttpBearerRequestPostProcessor(String token, boolean encode, String headerName) {
		
		this.headerName = headerName;
		
		if (encode) {
			byte[] toEncode;
			try {
				toEncode = token.getBytes("UTF-8");
			}
			catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
			this.headerValue = "Bearer " + new String(Base64.getEncoder().encode(toEncode));
		} else {
			if (token == null || token.isEmpty()) {
				throw new RuntimeException("Http Bearer: token is null or empty.");
			}
			this.headerValue = "Bearer " + token;
		}
	}

	@Override
	public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
		request.addHeader(this.headerName, this.headerValue);
		return request;
	}
	
	public static RequestPostProcessor httpBearer(String token) {
		return new HttpBearerRequestPostProcessor(token, false, "Authorization");
	}
	
	public static RequestPostProcessor httpBearerBase64(String token) {
		return new HttpBearerRequestPostProcessor(token, true, "Authorization");
	}
	
	public static RequestPostProcessor httpBearer(String headerName, String token) {
		return new HttpBearerRequestPostProcessor(token, false, headerName);
	}
	
	public static RequestPostProcessor httpBearerBase64(String headerName, String token) {
		return new HttpBearerRequestPostProcessor(token, true, headerName);
	}
	
}
