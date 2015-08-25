package cn.common.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 重复提交拦截器，处理当请求连接重复提交处理方式
 * 
 * @author 孙树林
 * 
 */
public class GeneralTokenInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1279677633785844688L;

	/**
	 * 重复提交拦截器处理方法
	 * 
	 * @param invocation
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		ActionContext actionContext = actionInvocation.getInvocationContext();
		// 获得httpservletrequest
		HttpServletRequest request = (HttpServletRequest) actionContext.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) actionContext.get(ServletActionContext.HTTP_RESPONSE);
		// 获得令牌参数
		String token = request.getParameter(TokenHandler.TOKEN_REQUEST);
		
		if (token != null) {
			// 清除参数列表token
			actionContext.getParameters().remove(TokenHandler.TOKEN_REQUEST);
			ActionInvocation _actionInvocation = TokenHandler.loadActionInvocation(request, token);
			if (_actionInvocation != null) {
				ValueStack stack = _actionInvocation.getStack();
				Map context = stack.getContext();
				request.setAttribute(ServletActionContext.STRUTS_VALUESTACK_KEY, stack);
				ActionContext savedContext = _actionInvocation.getInvocationContext();
				savedContext.getContextMap().put(ServletActionContext.HTTP_REQUEST, request);
				savedContext.getContextMap().put(ServletActionContext.HTTP_RESPONSE, response);
				Result result = _actionInvocation.getResult();
				if ((result != null) && (_actionInvocation.getProxy().getExecuteResult())) {
					synchronized (context) {
						result.execute(_actionInvocation);
					}
				}
				_actionInvocation.getProxy().setExecuteResult(false);
				return _actionInvocation.getResultCode();
			} else {
				TokenHandler.saveActionInvocation(request, token, actionInvocation);
			}
		}
		
		return actionInvocation.invoke();
	}

}
