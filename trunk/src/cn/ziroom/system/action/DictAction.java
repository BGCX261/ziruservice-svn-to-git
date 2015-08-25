package cn.ziroom.system.action;

import cn.common.action.GeneralAction;
import cn.common.resource.DictBuilder;

public class DictAction extends GeneralAction {

	private static final long serialVersionUID = 8130122498948138462L;
	
	public static String getValue(String type, String code) {
		String rtnParam = DictBuilder.getValue(type, code);
		return rtnParam;
	}

	public static String getValue(String type) {
		String json = DictBuilder.getJson(type);
		return json;
	}

	public static String getValue() {
		return "success";
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

}
