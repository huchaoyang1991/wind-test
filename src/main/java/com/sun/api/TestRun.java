package com.sun.api;

import wind.test.base.BaseTestCase;
import com.sun.service.UserService;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by huchaoyang on 2017/7/15.
 */
public class TestRun extends BaseTestCase {
	@Resource
	private UserService userService;
	@Test
	public void run(){
		System.out.println(userService.getUserInfo(1).getName());
	}
}
