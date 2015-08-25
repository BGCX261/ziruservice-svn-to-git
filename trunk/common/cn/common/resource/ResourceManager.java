package cn.common.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceManager {

	public static ResourceManager resource;

	public static ResourceManager getInstance() {
		return resource;
	}

	private static Properties properties;

	/**
	 * 初始化资源
	 * 
	 * @param path
	 * @throws IOException
	 */
	public static void init() throws IOException {
		resource = new ResourceManager();
	}

	private ResourceManager() throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("config.properties");
		properties = new Properties();
		properties.load(inputStream);
	}

	public static String getString(String key) {
		return properties.getProperty(key);
	}

	public static String getString(String key, String defaultValue) {
		String value = properties.getProperty(key);
		if (value != null && !value.trim().equals("")) {
			return value;
		}
		return defaultValue;
	}

	public static String getString(String key, String[] params) {
		String result = "";
		String source = properties.getProperty(key);
		String[] sources = new String[params.length + 1];
		int ind = 0;
		for (int i = 1; i < (params.length + 1); i++) {
			int index = source.indexOf("%" + i);
			if (index > 0) {
				sources[i - 1] = source.substring(ind, index);
				if (i < 10) {
					sources[i] = source.substring(index + 2);
					ind = index + 2;
				} else {
					sources[i] = source.substring(index + 3);
					ind = index + 3;
				}
			}
		}
		for (int i = 0; i < sources.length; i++) {
			if (i < (sources.length - 1)) {
				result += sources[i] + params[i];
			} else {
				result += sources[i];
			}
		}
		return result;
	}

	public static int getInt(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}

	public static int getInt(String key, int defaultValue) {
		String value = properties.getProperty(key);
		if (value != null && !value.trim().equals("") && isDigit(value)) {
			return Integer.parseInt(value);
		}
		return defaultValue;
	}

	public static long getLong(String key) {
		return Long.parseLong(properties.getProperty(key));
	}

	public static long getLong(String key, long defaultValue) {
		String value = properties.getProperty(key);
		if (value != null && !value.trim().equals("") && isDigit(value)) {
			return Long.parseLong(value);
		}
		return defaultValue;
	}

	private static boolean isDigit(String value) {

		for (int i = 0, j = value.length(); i < j; i++) {
			if (!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
