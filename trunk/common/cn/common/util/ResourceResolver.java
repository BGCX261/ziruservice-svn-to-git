package cn.common.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 自动加载classpath路径下的文件
 * 
 * @author 孙树林
 * 
 */
public class ResourceResolver {

	/** 文件前缀 */
	public static final String FILE_URL_PREFIX = "file:";
	/** jar文件 */
	public static final String URL_PROTOCOL_JAR = "jar";
	/** 指定的claspath */
	public static final String CLASSPATH_URL_PREFIX = "classpath:";

	public static final String CLASSPATH_ALL_URL_PREFIX = "classpath*:";

	/**
	 * ClassLoader定位资源,从classpath下查找匹配的资源
	 * 
	 * @param partten
	 * @return
	 * @throws IOException
	 */
	public List<URL> findAllClassPathResources(String partten) throws IOException {
		List<URL> results = new ArrayList<URL>();
		URL url = ResourceResolver.class.getClassLoader().getResource("");
		File file = new File(url.getPath());
		findPathMatchingResources(results, file, partten);
		return results;
	}

	/**
	 * ClassLoader定位资源,从classpath下指定的路径查找匹配的资源
	 * 
	 * @param partten
	 * @return
	 * @throws IOException
	 */
	public List<URL> findClassPathResources(String partten) throws IOException {
		List<URL> results = new ArrayList<URL>();
		// 如果是以classpath*开头搜索所有文件
		if (partten.startsWith(CLASSPATH_ALL_URL_PREFIX)) {
			partten = partten.substring(CLASSPATH_ALL_URL_PREFIX.length());
			results = findAllClassPathResources(partten);
		} else if (partten.startsWith(CLASSPATH_URL_PREFIX)) {
			URL url = ResourceResolver.class.getClassLoader().getResource("");
			File file = new File(url.getPath());
			partten = partten.substring(CLASSPATH_URL_PREFIX.length());
			doFindResources(results, file, partten);
		}
		return results;
	}

	/**
	 * 资源匹配查找
	 * 
	 * @param results
	 * @param file
	 * @param partten
	 * @throws MalformedURLException
	 */
	protected void doFindResources(List<URL> results, File file, String partten) throws MalformedURLException {
		int end = partten.lastIndexOf("/");
		if (partten.substring(0, end).indexOf("**") != -1) {
			partten = partten.substring(partten.indexOf("*") + 2);
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				if (f.isDirectory()) {
					doFindResources(results, f, partten);
				}
			}
		} else {
			addPathMatchingResources(results, file, partten);
		}
	}

	/**
	 * 文件目录中加入匹配的资源
	 * 
	 * @param results
	 * @param file
	 * @param partten
	 * @throws MalformedURLException
	 */
	protected void addPathMatchingResources(List<URL> results, File file, String partten) throws MalformedURLException {
		partten = partten.substring(partten.lastIndexOf("/") + 1);
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			File dir = files[i];
			if (!dir.isDirectory()) {
				if (StringUtils.match(dir.getName(), handlerMatch(partten))) {
					results.add(new URL(FILE_URL_PREFIX + dir.getAbsolutePath()));
				}
			}
		}
	}

	/**
	 * 各级文件目录查找匹配文件
	 * 
	 * @param results
	 * @param file
	 * @param partten
	 * @throws MalformedURLException
	 */
	protected void findPathMatchingResources(List<URL> results, File file, String partten) throws MalformedURLException {
		int end = partten.lastIndexOf("/");
		if (partten.substring(0, end).indexOf("**") != -1) {
			partten = partten.substring(partten.indexOf("*") + 2);
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File dir = files[i];
				if (dir.isDirectory()) {
					findPathMatchingResources(results, dir, partten);
				}
			}
		} else {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				File f = files[i];
				if (f.isDirectory()) {
					findPathMatchingResources(results, f, partten);
				} else {
					if (StringUtils.match(f.getName(), handlerMatch(partten.substring(partten.indexOf("/") + 1)))) {
						results.add(new URL(FILE_URL_PREFIX + f.getAbsolutePath()));
					}
				}
			}
		}
	}

	/**
	 * 字符串处理
	 * 
	 * @param partten
	 * @return
	 */
	protected String handlerMatch(String partten) {
		String newPartten = "";
		// 如果以*开头
		if (!partten.startsWith("*")) {
			newPartten = "^";
		}
		newPartten += partten.replace("*", "(.)*");
		// 以*结束
		if (!partten.endsWith("*")) {
			newPartten += "$";
		}
		return newPartten;
	}

	public static void main(String[] args) throws IOException {
		ResourceResolver resolver = new ResourceResolver();
		List<URL> results = resolver.findClassPathResources("classpath*:/**/struts-*.xml");
		for (URL url : results) {
			System.out.println(url.getProtocol() + ":" + url.getPath());
		}
	}
}
