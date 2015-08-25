package cn.ziroom.util;

import java.util.List;

import javax.servlet.jsp.JspException;

import cn.common.manager.SessionManager;
import cn.common.tag.GeneralTag;

/**
 * 功能全新标签库
 * 
 * @author Administrator
 * 
 */
public class FunctionTag extends GeneralTag {

	private static final long serialVersionUID = 2474853621512421921L;

	private String funCode;

	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		List<String> funList = (List<String>) pageContext.getSession().getAttribute(SessionManager.FUNCTION_KEY);
		if(funList != null && funList.contains(funCode)) {
			return (EVAL_BODY_INCLUDE);
		} else {
			return (SKIP_BODY);
		}
	}

	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}
}
