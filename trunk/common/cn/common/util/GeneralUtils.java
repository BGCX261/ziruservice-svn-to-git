package cn.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * 通用方法处理类
 * 
 * @author Administrator
 * 
 */
public class GeneralUtils {

	/**
	 * 生成easy-UI datagrid json数据格式
	 * 
	 * @param totalLine
	 * @param list
	 * @return
	 */
	public static String easyUI(int totalLine, List<?> list) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalLine);
		map.put("rows", list);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}

	/**
	 * 生成json数据格式
	 * 
	 * @param o
	 * @return
	 */
	public static String easyUI(Object o) {
		Gson gson = new Gson();
		String json = gson.toJson(o);
		return json;
	}

	public static String merge(String s, String a) {
		return null;
	}
}
