package wind.test.http;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
	private String url;
	private HttpRequestBase httpRequestBase;
	private Map<String, String> headers = new HashMap<String, String>();
	private Map<String, String> requestBody = new HashMap<String, String>();

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

	public Map<String, String> getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Map<String, String> requestBody) {
		this.requestBody = requestBody;
	}

	public void setHeaderValue(String headerName, String headerValue) {
		this.headers.put(headerName, headerValue);
	}

	public String getHeaderValue(String headerName) {
		return this.headers.get(headerName);
	}

	public void addParamValue(String paramName, String paramValue) {
		this.requestBody.put(paramName, paramValue);
	}

	public String getParamValue(String paramName) {
		return this.requestBody.get(paramName);
	}
}