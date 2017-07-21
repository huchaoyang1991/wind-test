package wind.test.common;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by huchaoyang on 2017/7/20.
 */
public class CommonUtil {
	private static Logger logger=Logger.getLogger(CommonUtil.class);
	/**
	 * 使用正则表达式获取数字
	 * @param start
	 * @param end
	 * @param source 匹配的源字符串
	 * @return
	 */
	public static String findIntRegex(String source,String start, String end) {
		String str = "";
		Matcher m = Pattern.compile(start + "(\\d+)" + end).matcher(source);
		if (m.find())
			str = m.group(1);

		return str;
	}
	/**
	 * 使用正则表达式获取数字集合
	 * @param start
	 * @param end
	 * @param source 匹配的源字符串
	 * @return
	 */
	public static List<String> findsIntRegex(String source, String start, String end) {
		List<String> list=new ArrayList<String>();
		Matcher m = Pattern.compile(start + "(\\d+)" + end).matcher(source);
		while (m.find()) {
			list.add(m.group(1));
		}
		if (list.size()==0)
			logger.info("未匹配到任何值");
		return list;
	}
	public static String findStrRegex(String source,String start, String end) {
		String str = "";
		Matcher m = Pattern.compile(start + "(.*)" + end).matcher(source);
		if (m.find())
			str = m.group(1);

		return str;
	}

}
