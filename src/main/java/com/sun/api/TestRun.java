package com.sun.api;

import com.sun.base.BaseTestCase;
import com.sun.service.UserService;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/7/15.
 */
public class TestRun extends BaseTestCase {
	@Resource
	private UserService userService;
	@Test
	public void run(){
		System.out.println(userService.getUserInfo(1).getName());
	}
}
