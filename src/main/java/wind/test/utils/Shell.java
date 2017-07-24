package wind.test.utils;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by huchaoyang on 2017/7/20.
 */
public class Shell {
	private static Logger logger = Logger.getLogger(Shell.class);
	private String ip;//远程主机的IP地址
	private String username;//远程主机的用户名
	private String password;//远程主机的密码
	private int port;//远程主机端口
	public static final int DEFAULT_SSH_PORT = 22;
	private ArrayList<String> stdout;//保存输出的内容

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ArrayList<String> getStdout() {
		return stdout;
	}

	public Shell() {
		stdout = new ArrayList<String>();
	}

	public Shell(final String ip, final String username, final String password) {
		this.ip = ip;
		this.username = username;
		this.password = password;
		stdout = new ArrayList<String>();
	}

	public int execute(final String command) {
		int returnCode = 0;
		JSch jsch = new JSch();
		Session session = null;

		try {
			//创建session并且打开连接，因为创建session之后要主动打开连接
			if (port == 0)
				session = jsch.getSession(username, ip, DEFAULT_SSH_PORT);
			else
				session = jsch.getSession(username, ip, port);

			session.setPassword(password);

			//关闭主机密钥检查，否则会导致连接失败，重要！！！
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);

			logger.info("连接服务器" + session.getHost());

			session.connect();
			//打开通道，设置通道类型，和执行的命令
			Channel channel = session.openChannel("exec");
			ChannelExec channelExec = (ChannelExec) channel;
			channelExec.setCommand(command);

			channelExec.setInputStream(null);
			BufferedReader input = new BufferedReader(new InputStreamReader((channelExec.getInputStream())));
			channelExec.connect();
			logger.info("The remote command is:" + command);
			//接受远程服务器执行命令的结果

			String line = null;
			logger.info("stdout信息开始打印");
			while ((line = input.readLine()) != null) {
				stdout.add(line);
				logger.info(line);
			}
			logger.info("stdout信息打印结束");
			input.close();

			//得到returnCode
			if (channelExec.isClosed())
				returnCode = channelExec.getExitStatus();

			//关闭通道
			channelExec.disconnect();
			//关闭session
			session.disconnect();

		} catch (JSchException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnCode;
	}
}
