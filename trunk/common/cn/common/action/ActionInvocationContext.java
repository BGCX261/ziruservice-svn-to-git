package cn.common.action;

import java.io.Serializable;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * ActionInvocationContext记录保存在session中ActionInvocation对应的令牌的值
 * 
 * @author 孙树林
 * 
 */
public class ActionInvocationContext implements Serializable {

	private static final long serialVersionUID = 7387803727285274331L;

	/** ActionInvocation */
	private ActionInvocation actionInvocation;
	/** 令牌环的值 */
	private String token;

	public ActionInvocation getActionInvocation() {
		return actionInvocation;
	}

	public void setActionInvocation(ActionInvocation actionInvocation) {
		this.actionInvocation = actionInvocation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
