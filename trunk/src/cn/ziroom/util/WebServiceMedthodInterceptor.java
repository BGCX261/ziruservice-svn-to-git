package cn.ziroom.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.gson.Gson;

/**
 * 环绕通知，用来做数据验证及记录日志
 * 
 * @author Administrator
 * 
 */
public class WebServiceMedthodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// 记录日志，将日志记录到日志文件中去
		Object[] o = methodInvocation.getArguments();
		Gson gson = new Gson();
		String json = gson.toJson(o);
		GeneralLog.getInstance().info(methodInvocation.getClass(), methodInvocation.getMethod().getName(), json);
		return methodInvocation.proceed();
	}

}
