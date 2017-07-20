package com.sun.api;

import wind.test.http.HttpRequest;
import wind.test.http.HttpResponse;
import wind.test.http.HttpClientUtil;
import org.testng.annotations.Test;

/**
 * Created by huchaoyang on 2017/7/16.
 */
public class TestDemo{
	private HttpRequest httpRequest;
	@Test
	public void run(){
		httpRequest=new HttpRequest();
		httpRequest.setUrl("http://www.baidu.com");
		httpRequest.setHeaderValue("Content-Type","text/html;charset=UTF-8");
		//httpRequest.addParamValue("latlon","121.51256561279296875000,31.23718833923339843750");
		HttpResponse response=HttpClientUtil.doGet(httpRequest);


	}
}
