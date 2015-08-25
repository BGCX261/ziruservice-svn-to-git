package cn.ziroom.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import cn.ziroom.system.domain.User;
import cn.ziroom.system.service.UserService;

/**
 * 系统对接HR用户接口类
 * 
 * @author Administrator
 * 
 */
@WebService(serviceName = "userInterface")
public class UserInterface {

	private UserService userService;

	/**
	 * 同步用户接口访问数据
	 * 
	 * @param list
	 * @param operator
	 * @return
	 */
	@WebMethod
	public String synchroUser(List<User> list) {
		return userService.synchroUser(list);
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
