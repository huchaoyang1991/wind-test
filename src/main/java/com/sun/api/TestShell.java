package com.sun.api;

import org.testng.annotations.Test;
import wind.test.utils.Shell;

/**
 * Created by huchaoyang on 2017/7/21.
 */
public class TestShell {
	private Shell shell;
	@Test
	public void run(){
		shell=new Shell();
		shell.setIp("192.168.38.150");
		shell.setUsername("root");
		shell.setPassword("root");
		shell.execute("ls");
	}
}
