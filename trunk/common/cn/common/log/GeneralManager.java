package cn.common.log;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * 预处理器，只要在同一个线程获得GeneralManager是一样的
 * 
 * @author 孙树林
 * 
 */
public class GeneralManager {

	private static ThreadLocal<GeneralManager> local = new ThreadLocal<GeneralManager>();
	private HttpServletRequest request;
	private List<SqlLog> sql = new ArrayList<SqlLog>();

	public GeneralManager() {
		super();
	}

	public GeneralManager(HttpServletRequest request) {
		super();
		this.request = request;
	}

	/**
	 * 将自身保存到线程安全的对象中
	 * 
	 * @param manager
	 */
	public static void setCurrentManager(GeneralManager manager) {
		local.set(manager);
	}

	/**
	 * 从线程中取得自身,只要在一个请求过程中,取得的内容都是一样的
	 * 
	 * @return
	 */
	public static GeneralManager getCurrentManager() {
		if (local.get() == null) {
			GeneralManager manager = new GeneralManager();
			setCurrentManager(manager);
			// return manager;
		}
		return local.get();
	}

	/**
	 * 处理请求内容前需要做的工作
	 * 
	 */
	public void preProcess() {
		GeneralLog.getInstance().info(request.getRequestURI(), "Request Startup");
	}

	/**
	 * 处理出现异常时的工作
	 * 
	 * @param e
	 */
	public void processException(Exception e) {
		GeneralLog.getInstance().error(request.getRequestURI(), e, "Request Error");
	}

	/**
	 * 处理系统操作日志的工作
	 * 
	 * @param e
	 */
	public void processLog(String msg) {
		GeneralLog.getInstance().info(request.getRequestURI(), msg);
	}

	/**
	 * 处理请求内容后需要做的工作
	 * 
	 */
	public void postProcess() {
		GeneralLog.getInstance().info(request.getRequestURI(), "Request Stop");
	}

	/**
	 * mybatis sql info
	 * 
	 * @param sql
	 */
	public void sqlMapper(String sql) {
		GeneralLog.getInstance().info("MyBatis:", sql);
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 访问Action
	 * 
	 * @return
	 */
	public String getAction() {
		String url = request.getRequestURI();
		String action = url.substring(url.lastIndexOf("/") + 1);
		return action;
	}

	/**
	 * 访问Action
	 * 
	 * @return
	 */
	public String getURL() {
		String url = request.getRequestURL().toString();
		String action = url.substring(url.lastIndexOf("/") + 1);
		return action;
	}

	/**
	 * 获得IP地址
	 * 
	 * @return
	 */
	public String getIP() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 添加SQL
	 * 
	 * @param sql
	 */
	public void addSql(SqlLog sql) {
		this.sql.add(sql);
	}
	
	/**
	 * 
	 */
	public void processSql() {
		for (SqlLog sqlLog : sql) {
			if (sqlLog.getSql() != null && !sqlLog.getSql().equals("")) {				
				GeneralLog.getInstance().info("MyBatis SQL：", sqlLog.getSql());
			}
			if (sqlLog.getParameter() != null && !sqlLog.getParameter().equals("")) {
				GeneralLog.getInstance().info("MyBatis Parameter：：", sqlLog.getParameter());
			}
		}
	}
}
