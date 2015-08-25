/*
 * 类说明：
 * 作者：孙树林
 * 创建日期：2011-1-8
 */
package cn.common.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts2.views.jsp.TagUtils;

import cn.common.exception.GeneralException;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author 孙树林
 * 
 */
public class ErrorTag extends TagSupport {

	private static final long serialVersionUID = 2097329915666128590L;

	/**
	 * @return
	 * @throws JspException
	 *             作者：孙树林 创建日期:2010-12-29
	 */
	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = pageContext.getOut();
		try {
			ValueStack stack = TagUtils.getStack(pageContext);
			Object obj = stack.findValue("ex");
			GeneralException exception = (GeneralException) obj;
			writer.print("错误信息：<br>");
			writer.print(exception.getMessage() + "<br>");
			StackTraceElement[] elements = exception.getStackTrace();
			writer.print("详细内容：<br>");
			for (StackTraceElement element : elements) {
				writer.println(element.getClassName() + "." + element.getMethodName() + "(" + element.getFileName() + ": " + element.getLineNumber() + ")<br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}
}
