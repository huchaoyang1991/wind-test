package com.sun.api;

import org.testng.annotations.Test;
import wind.test.http.HttpClientUtil;
import wind.test.http.HttpRequest;
import wind.test.http.HttpResponse;
import wind.test.report.ReporterInfo;

/**
 * Created by huchaoyang on 2017/7/16.
 */
public class TestDemo{
	private HttpRequest httpRequest;
	@Test
	public void run(){
		httpRequest=new HttpRequest();
		httpRequest.setUrl("http://192.168.38.150/index.php");
		//httpRequest.setHeaderValue("Content-Type","text/html;charset=UTF-8");
		httpRequest.addParamValue("username","sun");
		httpRequest.addParamValue("password","123456");
		httpRequest.addParamValue("backurl","http://192.168.38.150/index.php");
		httpRequest.addParamValue("csrf_token","deb43ca5aaa862e8");


		HttpResponse response=HttpClientUtil.doPost(httpRequest);
		//ReporterInfo.log(response.getResponseBody());

		httpRequest=new HttpRequest();
		httpRequest.setUrl("http://192.168.38.150/index.php?m=u&c=login&a=welcome&_statu=V0dTaGprVGlYZGF2bXM3WlgxMmFicFd1ZEFlYlVvT3UwcWs1RTM1OEtzWGduMUd5RWpOVWVxcWtiY2QlMkIyJTJCbVB8aHR0cDovLzE5Mi4xNjguMzguMTUwL2luZGV4LnBocHw");


		HttpResponse response2=HttpClientUtil.doGet(httpRequest);
		//ReporterInfo.log(response2.getResponseBody());
		ReporterInfo.log(response.getHeaders());


	}
}
