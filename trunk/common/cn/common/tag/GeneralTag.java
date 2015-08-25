package cn.common.tag;

import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts2.views.jsp.TagUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class GeneralTag extends TagSupport {

	private static final long serialVersionUID = 8373077395664391953L;

	/**
	 * OGNL值栈
	 * 
	 * @return
	 */
	protected ValueStack getStack() {
		return TagUtils.getStack(pageContext);
	}

	/**
	 * 表达式从值栈中获得值
	 * 
	 * @param value
	 * @return
	 */
	protected Object findValue(String value) {
		return getStack().findValue(value);
	}

	/**
	 * 获得bean
	 * 
	 * @param name
	 * @return
	 */
	protected Object getBean(String name) {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		return context.getBean(name);
	}
}
