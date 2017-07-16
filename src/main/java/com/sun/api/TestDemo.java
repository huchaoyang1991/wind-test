package com.sun.api;

import com.sun.base.BaseTestCase;
import com.sun.module.http.HttpRequest;
import com.sun.module.http.HttpResponse;
import com.sun.utils.HttpClientUtil;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/16.
 */
public class TestDemo extends BaseTestCase{

	private HttpRequest httpRequest;
	@Test
	public void run(){
		httpRequest=new HttpRequest();
		httpRequest.setUrl("http://localhost:9090/test");
		Map headers=new HashMap<>();
		headers.put("a","a");
		headers.put("1","1");
		httpRequest.setHeaders(headers);
		HttpResponse response=HttpClientUtil.doGet(httpRequest);
		super.logger.info(response.getStatusCode());
	}
}
