package cn.common.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * 
 * @author 孙树林
 * 
 */
public class StringUtils {

	public static String COMMA_SYMBOL = "\\,";

	public static String FULl_STOP = "\\.";

	public static String SEMICOLON = "\\;";

	public static String START = "*";

	/**
	 * 字符串内容比较;不区分大小写.
	 * 
	 * @param source
	 * @param target
	 * @return boolean
	 */
	public static boolean equalsign(String source, String target) {
		if (source.equalsIgnoreCase(target)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串内容比较;区分大小写.
	 * 
	 * @param source
	 * @param target
	 * @return boolean
	 */
	public static boolean equalsignIgnoreCase(String source, String target) {
		if (source.equals(target)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 替换字符串中的内容
	 * 
	 * @param source
	 * @param partten
	 * @param str
	 * @return string
	 */
	public static String replace(String source, String partten, String str) {
		StringBuilder sb = new StringBuilder();
		int pos = 0;
		int index = source.indexOf(partten);
		int patLen = partten.length();
		while (index >= 0) {
			sb.append(source.substring(pos, index));
			sb.append(str);
			pos = index + patLen;
			index = source.indexOf(partten, pos);
		}
		sb.append(source.substring(pos));
		return sb.toString();
	}

	/**
	 * 字符串长度
	 * 
	 * @param source
	 * @return int
	 */
	public static int length(String source) {
		return (source == null ? 0 : source.length());
	}

	/**
	 * 字符串开头判断
	 * 
	 * @param source
	 * @param partten
	 * @return
	 */
	public static boolean startswith(String source, String partten) {
		return (source.startsWith(partten));
	}

	/**
	 * 字符串结束判断
	 * 
	 * @param source
	 * @param partten
	 * @return
	 */
	public static boolean endsWith(String source, String partten) {
		return (source.endsWith(partten));
	}

	/**
	 * 查询字符串的位置
	 * 
	 * @param source
	 * @param partten
	 * @return
	 */
	public static int indexOf(String source, String partten) {
		return source.indexOf(partten);
	}

	/**
	 * 检查字符串是否不空！
	 * 
	 * @param source
	 * @return
	 */
	public static boolean isEmpty(String source) {
		return (source != null && !source.matches("^\\s$") && !source.equals("")) ? true : false;
	}

	/**
	 * 验证空的对象
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNull(Object obj) {
		return (obj == null) ? true : false;
	}

	public static boolean isNull(String str) {
		return (str == null || "".equals(str.trim())) ? true : false;
	}

	/**
	 * 字符串分割
	 * 
	 * @param source
	 * @param style
	 * @return
	 */
	public static String[] split(String source, String style) {
		return source == null ? null : source.split(style);
	}

	/**
	 * 字符串匹配
	 * 
	 * @param str
	 * @param partten
	 * @return
	 */
	public static boolean match(String str, String partten) {
		Pattern p = Pattern.compile(partten);
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 分割数组
	 * 
	 * @param strs
	 * @param explod
	 * @return
	 */
	public static String split(List<String> strs, String explod) {
		String str = "";
		for (int i = 0; i < strs.size(); i++) {
			if(i == 0) {
				str = strs.get(i);
			} else {
				str += "," + strs.get(i);
			}
		}
		return str;
	}

	public static void main(String[] args) {
		String tt = "";
		System.out.println("tt=" + StringUtils.isNull(tt));
		tt = "   ";
		System.out.println("tt=" + StringUtils.isNull(tt));
		tt = null;
		System.out.println("tt=" + StringUtils.isNull(tt));
	}

}
