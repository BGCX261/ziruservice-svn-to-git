package cn.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * 令牌环处理类，用来读取和存取ActionInvocation
 * 
 * @author 孙树林
 * 
 */
public class TokenHandler {

	/** 存在session中的令牌属性 */
	public final static String TOKEN_SESSION = "token.session";
	/** 存在request中的令牌属性 */
	public final static String TOKEN_REQUEST = "token";

	/**
	 * 从session中获得ActionInvocation比较token值是否相等如果值相同返回ActionInvocation，否则null
	 * 
	 * @param request
	 * @param token
	 *            令牌环的值
	 * @return ActionInvocation
	 */
	public static ActionInvocation loadActionInvocation(HttpServletRequest request, String token) {
		HttpSession session = request.getSession();
		ActionInvocationContext actionInvocationContext = session.getAttribute(TOKEN_SESSION) != null ? (ActionInvocationContext) session.getAttribute(TOKEN_SESSION) : null;
		if (actionInvocationContext != null && actionInvocationContext.getToken().equals(token)) {
			return actionInvocationContext.getActionInvocation();
		}
		return null;
	}

	/**
	 * 将ActionInvocation保存到session的token.session属性中
	 * 
	 * @param request
	 * @param token
	 * @param actionInvocation
	 */
	public static void saveActionInvocation(HttpServletRequest request, String token, ActionInvocation actionInvocation) {
		HttpSession session = request.getSession();
		ActionInvocationContext actionInvocationContext = new ActionInvocationContext();
		actionInvocationContext.setToken(token);
		actionInvocationContext.setActionInvocation(actionInvocation);
		session.setAttribute(TOKEN_SESSION, actionInvocationContext);
	}
}
