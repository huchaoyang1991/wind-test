package com.sun.module.http;

import org.apache.http.client.methods.HttpRequestBase;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/16.
 */
public class HttpRequest {
	private String url;
	private HttpRequestBase httpRequestBase;
	private Map<String,String> headers;
	private String requestBody;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpRequestBase getHttpRequestBase() {
		return httpRequestBase;
	}

	public void setHttpRequestBase(HttpRequestBase httpRequestBase) {
		this.httpRequestBase = httpRequestBase;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}


}
