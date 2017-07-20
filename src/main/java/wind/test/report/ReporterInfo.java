package wind.test.report;

import org.testng.Assert;

/**
 * Created by huchaoyang on 2017/7/18.
 */
public class ReporterInfo {
	private static void logInfo(String msg, Object message) {
		String log = "<" + msg + ">==>>" + message + "<<==<" + msg + ">";
		System.out.println(log);
	}

	public static void log(boolean condition) {
		Assert.assertTrue(condition);
	}

	public static void log(Object message, boolean condition) {
		if (condition == true)
			log(message);
		else

			Assert.assertTrue(condition, (String) message);
	}

	public static void log(Object message) {
		String msg = "INFO";
		logInfo(msg, message);
	}

	public static void start(Object message) {
		String msg = "开始";
		logInfo(msg, message);

	}

	public static void end(String message) {
		String msg = "结束";
		logInfo(msg, message);

	}
}
