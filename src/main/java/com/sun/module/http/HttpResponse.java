package com.sun.module.http;

import java.util.Map;

/**
 * Created by huchaoyang on 2017/7/16.
 */
public class HttpResponse {
	private String statusCode;
	private Map<String,String> Headers;
	private String responseBody;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getHeaders() {
		return Headers;
	}

	public void setHeaders(Map<String, String> headers) {
		Headers = headers;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}



}
