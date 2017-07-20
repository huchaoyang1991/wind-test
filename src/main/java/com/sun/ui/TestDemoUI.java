package com.sun.ui;

import wind.test.webUI.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/7/18.
 */
public class TestDemoUI extends WebDriverUtil{
	private WebDriver webDriver;
	@BeforeClass
	public void beforClass(){
		webDriver=super.getWebDriver(CHROME_DRIVER);
	}
	@Test(description = "UI自动化测试")
	public void main(){
		webDriver.get("http://www.baidu.com");
		webDriver.findElement(By.id("kw")).sendKeys("火影忍者");
		webDriver.findElement(By.id("su")).click();
	}
	@AfterClass
	public void afterClass(){
		super.closeWebDriver();
	}
}
