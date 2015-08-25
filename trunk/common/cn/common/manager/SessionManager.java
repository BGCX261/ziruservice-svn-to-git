package cn.common.manager;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

/**
 * session工具管理类
 * 
 * @author 孙树林
 * 
 */
public class SessionManager {

	public static final String LOGIN_SESSION = "user";
	
	public static final String FUNCTION_KEY = "function";
	
	public static String USER_KEY = "user";

	/**
	 * 保存session属性
	 * 
	 * @param key
	 * @param value
	 */
	public static void setAttr(String key, Object value) {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute(key, value);
	}

	/**
	 * 获得属性
	 * 
	 * @param key
	 * @return
	 */
	public static Object getAttr(String key) {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getSession().getAttribute(key);
	}
	
	/**
	 * 删除属性
	 * 
	 * @param key
	 */
	public static void removeAttr(String key){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute(key);
	}

}
