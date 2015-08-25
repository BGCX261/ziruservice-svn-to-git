package cn.ziroom.system.action;

import cn.common.action.GeneralAction;
import cn.ziroom.system.domain.User;
import cn.ziroom.system.service.UserService;

/**
 * 用户登录系统业务处理方法
 * 
 * @author Administrator
 * 
 */
public class LoginAction extends GeneralAction {

	private static final long serialVersionUID = 3129979692398542003L;

	private User user = new User();

	private UserService userService;

	/**
	 * 用户登录系统业务处理方法
	 * 
	 * @throws Exception
	 */
	public void login() throws Exception {
		boolean isLogin = userService.isLogin(user);
		if (isLogin) {
			out("success");
		} else {
			out("loginError");
		}
	}

	/**
	 * 登出系统
	 * 
	 * @throws Exception
	 */
	public void logout() throws Exception {
		if (userService.logout()) {
			out("success");
		} else {
			out("error");
		}
	}

	/**
	 * 用户登录权限
	 * 
	 * @return
	 * @throws Exception
	 */
	public String authority() throws Exception {
		if(userService.authority()) {			
			return SUCCESS;
		} else {
			//return "auterror";
			return SUCCESS;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}