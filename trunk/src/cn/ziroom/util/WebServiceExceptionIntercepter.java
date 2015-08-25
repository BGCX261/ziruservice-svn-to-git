package cn.ziroom.util;

import java.lang.reflect.Method;
import java.net.URL;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.jdbc.BadSqlGrammarException;

import com.google.gson.Gson;

/**
 * webservice异常拦截器
 * 
 * @author Administrator
 * 
 */
public class WebServiceExceptionIntercepter implements ThrowsAdvice {

	public WebServiceExceptionIntercepter() {
		URL url = this.getClass().getClassLoader().getResource("log4j.xml");
		GeneralLog.init(url.getFile());
	}

	/**
	 * BadSqlGrammarException异常处理方法
	 * 
	 * @param sqlException
	 */
	public void afterThrowing(Method method, Object[] params, Object clazz, BadSqlGrammarException badSqlGrammarException) {
		String methodName = method.getName();
		String exceptionMsg = badSqlGrammarException.getMessage();
		Gson gson = new Gson();
		String msg = "\nmethod：" + methodName;
		msg += "\nparams:" + gson.toJson(params);
		msg += "\nexception:" + exceptionMsg;
		GeneralLog.getInstance().error(clazz, msg);
	}

	/**
	 * 异常处理方法
	 * 
	 * @param method
	 * @param params
	 * @param retVal
	 * @param exception
	 */
	public void afterThrowing(Method method, Object[] params,Object clazz, Exception exception) {
		String methodName = method.getName();
		String exceptionMsg = exception.getMessage();
		Gson gson = new Gson();
		String msg = "\nmethod：" + methodName;
		msg += "\nparams:" + gson.toJson(params);
		msg += "\nexception:" + exceptionMsg;
		GeneralLog.getInstance().error(clazz.getClass().getName() + "." + methodName, msg);
	}
}
