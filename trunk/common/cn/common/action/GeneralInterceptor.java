package cn.common.action;

import java.io.File;
import java.net.URL;

import org.apache.struts2.ServletActionContext;

import cn.common.exception.GeneralException;
import cn.common.log.GeneralLog;
import cn.common.log.GeneralManager;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * struts2拦截器类，用来处理日志，异常等内容
 * 
 * @author 孙树林
 * 
 */
public class GeneralInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = -3802649958215518533L;

	/** 异常处理 */
	private final String RESULT_ERROR_PAGE = "errorPage";

	@Override
	public void init() {
		// 加载日志文件
		URL url = GeneralInterceptor.class.getClassLoader().getResource("");
		File logfile = new File(url.getPath() + "/log4j.xml");
		GeneralLog.init(logfile.getPath());
	}

	/**
	 * 程序拦截器，用来处理权限，日志等
	 * 
	 * @param actionInvocation
	 * @return
	 * @throws Exception
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		GeneralManager generalManager = new GeneralManager(ServletActionContext.getRequest());
		// 管理类保存线程中，是在整个请求中保存唯一管理类
		GeneralManager.setCurrentManager(generalManager);
		// 开始请求处理
		generalManager.preProcess();
		String invoke = null;
		try {
			invoke = actionInvocation.invoke();
			if(invoke != null) {
				return invoke;
			} else {
				ServletActionContext.getResponse().getWriter().write("sucess");
			}
			return null;
		} catch (Exception e) {
			GeneralException exception = new GeneralException(e);
			ValueStack stack = actionInvocation.getStack();
			stack.set("ex", exception);
			generalManager.processException(exception);
			e.printStackTrace();
			return RESULT_ERROR_PAGE;
		} finally {
			// 输出sql
			generalManager.processSql();
			// 请求处理结束
			generalManager.postProcess();
		}
	}

}
