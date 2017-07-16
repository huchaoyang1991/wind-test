package com.sun.module.http;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/16.
 */
public class HttpResponse {
	private String statusCode;
	private Map<String,String> Headders;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getHeadders() {
		return Headders;
	}

	public void setHeadders(Map<String, String> headders) {
		Headders = headders;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	private String responseBody;

}
