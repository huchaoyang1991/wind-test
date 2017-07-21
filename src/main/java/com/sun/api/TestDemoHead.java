package com.sun.api;

import org.testng.annotations.Test;
import wind.test.common.CommonUtil;
import wind.test.http.HttpClientUtil;
import wind.test.http.HttpRequest;
import wind.test.http.HttpResponse;
import wind.test.report.ReporterInfo;

import java.util.Map;

/**
 * Created by huchaoyang on 2017/7/21.
 */
public class TestDemoHead {
	private HttpRequest httpRequest;
	private String token;
	private Map<String,String> responseHeaders;
	@Test
	public void run(){
		httpRequest=new HttpRequest();
		httpRequest.setUrl("http://192.168.38.150/index.php");
		HttpResponse response= HttpClientUtil.doGet(httpRequest);
		//使用正则表达式获取token
		token= CommonUtil.findStrRegex(response.getHeaders().toString(),"csrf_token=","; path");
		ReporterInfo.log(token);
	}
	@Test
	public void run2(){
		httpRequest=new HttpRequest();
		httpRequest.setUrl("http://192.168.38.150/index.php");
		httpRequest.addParamValue("username","sun");
		httpRequest.addParamValue("passowrd","123456");
		httpRequest.addParamValue("backurl","http://192.168.38.150/index.php");
		httpRequest.addParamValue("csrf_token",token);
		HttpResponse response= HttpClientUtil.doPost(httpRequest);
		//ReporterInfo.log(response.getResponseBody());
		responseHeaders=response.getHeaders();

	}
	/*@Test
	public void run3(){
		httpRequest=new HttpRequest();
		httpRequest.setHeaders(responseHeaders);
		httpRequest.setUrl("http://192.168.38.150/index.php?m=u&c=login&a=welcome&_statu=V0dTaGprVGlYZGF2bXM3WlgxMmFicFd1ZEFlYlVvT3UwcWs1RTM1OEtzWGduMUd5RWpOVWVxOE1uUXdpNlc3UHxodHRwOi8vMTkyLjE2OC4zOC4xNTAvaW5kZXgucGhwfA");

		HttpResponse response= HttpClientUtil.doGet(httpRequest);

	}*/
	@Test
	public void run4(){
		httpRequest=new HttpRequest();
		httpRequest.setUrl("http://192.168.38.150/index.php");
		httpRequest.setHeaders(responseHeaders);
		HttpResponse response= HttpClientUtil.doGet(httpRequest);
		ReporterInfo.log(response.getHeaders());
		boolean result=response.getResponseBody().contains("sun");
		ReporterInfo.log(result);

	}
}
