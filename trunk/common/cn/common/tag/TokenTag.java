package cn.common.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cn.common.action.TokenHandler;
import cn.common.util.UUIDFactory;

/**
 * 生成令牌环标签
 * 
 * @author 孙树林
 * 
 */
public class TokenTag extends TagSupport {

	private static final long serialVersionUID = -8612453515727214008L;

	/**
	 * 生成令牌环
	 * 
	 * @return
	 * @throws JspException
	 */
	@Override
	public int doStartTag() throws JspException {
		JspWriter writer = pageContext.getOut();
		String token = UUIDFactory.createUUID();
		StringBuilder sb = new StringBuilder("<input type='hidden' name='");
		sb.append(TokenHandler.TOKEN_REQUEST);
		sb.append("' value='");
		sb.append(token);
		sb.append("'/>");
		try {
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

}
