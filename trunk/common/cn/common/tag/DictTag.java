package cn.common.tag;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

/**
 * 数据字典标签资源，根据类型获得数据字典内容
 * 
 * @author Administrator
 * 
 */
public class DictTag extends GeneralTag {

	private static final long serialVersionUID = -5033715105434978086L;

	private String dictType;

	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		Map<String, String> maps = (Map<String, String>) pageContext.getServletContext().getAttribute("dict");
		try {
			JspWriter writer = pageContext.getOut();
			writer.write(maps.get(dictType));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

}
