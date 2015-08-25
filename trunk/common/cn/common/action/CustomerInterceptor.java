package cn.common.action;

import cn.common.manager.SessionManager;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器，判断判断用户权限及用户登录有效性
 * @author Administrator
 *
 */
public class CustomerInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 4003710638158178024L;

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Object o = SessionManager.getAttr("user");
		if(o != null) {
			return actionInvocation.invoke();
		} else {
			return "login";
		}
	}

}
