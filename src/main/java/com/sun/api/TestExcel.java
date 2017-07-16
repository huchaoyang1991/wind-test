package com.sun.api;

import com.sun.base.BaseTestCase;
import com.sun.utils.ExcelData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/15.
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
