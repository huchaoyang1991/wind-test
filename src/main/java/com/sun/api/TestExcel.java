package com.sun.api;

import wind.test.base.BaseTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import wind.test.testNG.ExcelData;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by huchaoyang on 2017/7/15.
 */
public class TestExcel extends BaseTestCase{
	@Test(testName = "测试数据驱动",dataProvider = "data")
	public void run(Map<String,String> data){
		System.out.println(data.get("a"));
	}
	@DataProvider
	public Iterator<Object[]> data(){
		return new ExcelData(this);
	}
}
