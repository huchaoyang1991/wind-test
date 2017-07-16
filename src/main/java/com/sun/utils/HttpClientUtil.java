package com.sun.utils;

import com.sun.module.http.HttpRequest;
import com.sun.module.http.HttpResponse;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Administrator on 2017/7/16.
 */
public class HttpClientUtil {
	private static Logger logger=Logger.getLogger(HttpClientUtil.class);
	private CloseableHttpClient httpClient;
	public static HttpResponse doGet(HttpRequest httpRequest){
		HttpClientUtil httpClientUtil=new HttpClientUtil();

		HttpGet httpGet=new HttpGet(httpRequest.getUrl());
		return httpClientUtil.sendRequest(httpGet,httpRequest);
	}

	public static HttpResponse doPost(HttpRequest httpRequest){
		HttpClientUtil httpClientUtil=new HttpClientUtil();

		HttpPost httpPost=new HttpPost(httpRequest.getUrl());
		return httpClientUtil.sendRequest(httpPost,httpRequest);
	}

	public static HttpResponse doPut(HttpRequest httpRequest){
		HttpClientUtil httpClientUtil=new HttpClientUtil();

		HttpPut httpPut=new HttpPut(httpRequest.getUrl());
		return httpClientUtil.sendRequest(httpPut,httpRequest);
	}

	public static HttpResponse doDelete(HttpRequest httpRequest){
		HttpClientUtil httpClientUtil=new HttpClientUtil();

		HttpDelete httpDelete=new HttpDelete(httpRequest.getUrl());
		return httpClientUtil.sendRequest(httpDelete,httpRequest);
	}

	private void init(){
		httpClient=HttpClients.createDefault();
		logger.info("初始化HTTP连接");
	}
	private HttpResponse sendRequest(HttpRequestBase httpRequestBase, HttpRequest httpRequest){
		this.init();
		HttpResponse httpResponse=new HttpResponse();
		String url=httpRequest.getUrl();
		if(httpRequest.getHeaders()!=null) {
			//将请求的headers放入httpRequestBase对象
			Map<String, String> requestHeaders = httpRequest.getHeaders();
			for (String key : requestHeaders.keySet()) {
				logger.info(requestHeaders.get(key));
				httpRequestBase.setHeader(key, requestHeaders.get(key));
			}
		}
		//判断是会为post请求，如果是添加请求参数
		try {
			if(httpRequestBase instanceof HttpEntityEnclosingRequestBase)
				((HttpEntityEnclosingRequestBase) httpRequestBase).setEntity(new StringEntity("post request body"));
			//获取http请求返回的结果信息
			CloseableHttpResponse response=httpClient.execute(httpRequestBase);
			//打印并存入http请求返回的status信息
			logger.info(response.getStatusLine().toString());
			httpResponse.setStatusCode(response.getStatusLine().toString().split(" ")[1]);
			//打印并存入http请求返回的headers信息
			Header[] headers=response.getAllHeaders();
			Map<String,String> responseHeaders=new HashMap<String,String>();
			for(Header header:headers){
				responseHeaders.put(header.getName(),header.getValue());
			}
			httpResponse.setHeadders(responseHeaders);
			//打印并存入htt请求返回的body信息
			HttpEntity entity=response.getEntity();
			String responseBody= EntityUtils.toString(entity);//IOUtils.toString(entity.getContext());
			logger.info(responseBody);
			httpResponse.setResponseBody(responseBody);
			this.close();
		} catch (ClientProtocolException e) {
			logger.error("协议不支持");
			logger.error(e.getMessage());
		}catch (Exception e){
			e.printStackTrace();
		}
		return httpResponse;
	}
	private String formatUrl(String url,Map<String,String> queryParam){
		String result="";
		String param="";
		for(String key : queryParam.keySet()){
			param=param+(key+"="+queryParam.get(key)+"&");
		}
		result=result+(url+"?"+param.substring(0,param.length()-1));
		return result;
	}
	private void close(){
		try {
			httpClient.close();
			logger.info("关闭HTTP连接");
		} catch (IOException e) {
			logger.info("关闭HTTP失败");
			logger.error(e.getMessage());
		}
	}
}
