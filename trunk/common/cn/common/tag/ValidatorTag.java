package cn.common.tag;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts2.dispatcher.Dispatcher;
import org.json.JSONObject;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.common.util.ValidatorSaxHandler;

import com.opensymphony.xwork2.config.RuntimeConfiguration;
import com.opensymphony.xwork2.config.entities.ActionConfig;

/**
 * 基于struts2验证标签，通过struts2配置文件自动生成客户验证程序，验证程序基于JQuery实现
 * 
 * @author 孙树林
 * 
 */
public class ValidatorTag extends TagSupport {

	private static final long serialVersionUID = 4694691907461777512L;

	/** 请求 */
	private String actionName;

	/** 命名空间 */
	private String nameSpace;

	/** 表单ID使用formID作为js方法名 */
	private String formId;

	@Override
	public int doStartTag() throws JspException {
		Dispatcher dispatcher = Dispatcher.getInstance();
		RuntimeConfiguration config = dispatcher.getConfigurationManager().getConfiguration().getRuntimeConfiguration();
		// 命名空间、请求action处理
		nameSpace = (nameSpace == null || nameSpace.equals("")) ? "" : nameSpace;
		actionName = (actionName == null || actionName.equals("")) ? "execute" : actionName;
		ActionConfig actionConfig = config.getActionConfig(nameSpace, actionName);
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(pageContext.getServletContext());
		if (actionConfig != null) {
			String methodName = actionConfig.getMethodName();
			String springName = actionConfig.getClassName();
			String clazz = context.getBean(springName).getClass().getName().replace(".", "/");
			// 根据方法名成获得对应的验证文件
			if (methodName != null && !methodName.equals("execute")) {
				clazz = clazz + "-" + actionName + "-validation.xml";
			} else {
				clazz = clazz + "-validation.xml";
			}
			URL url = ValidatorTag.class.getClassLoader().getResource(clazz);
			File file = new File(url.getPath());
			JspWriter writer = pageContext.getOut();
			try {
				writer.write(createXMLToJson(file));
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return EVAL_PAGE;
	}

	@SuppressWarnings("rawtypes")
	private String createXMLToJson(File file) throws Exception {
		// 解析XML文件
		ValidatorSaxHandler handler = new ValidatorSaxHandler(file);
		handler.parser();
		Map map = handler.getSaxMaps();
		JSONObject json = new JSONObject(map);
		StringBuilder sb = new StringBuilder("<script type=\"text/javascript\">\n");
		sb.append("	function ");
		sb.append(formId);
		sb.append("() {\n");
		sb.append("		var json = ");
		sb.append(json.toString());
		sb.append(";\n");
		sb.append("\n	return ");
		sb.append("$(\"#");
		sb.append(formId);
		sb.append("\").validator(json);\n}\n");
		sb.append("</script>\n");
		return sb.toString();
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

}
