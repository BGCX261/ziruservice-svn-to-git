package cn.ziroom.system.action;

import cn.common.action.GeneralAction;
import cn.ziroom.system.domain.User;
import cn.ziroom.system.service.UserService;

/**
 * 用户请求处理类
 * 
 * @author Administrator
 * 
 */
public class UserAction extends GeneralAction {

	private static final long serialVersionUID = 2268875019103291359L;

	private User user = new User();

	private UserService userService;

	/**
	 * 用户列表
	 * 
	 * @throws Exception
	 */
	public void searchUser() throws Exception {
		page(user);
		String json = userService.searchUser(user);
		out(json);
	}

	/**
	 * 查找用户
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findUser() throws Exception {
		user = userService.findUser(user);
		return SUCCESS;
	}

	/**
	 * 保存用户
	 * 
	 * @throws Exception
	 */
	public void saveUser() throws Exception {
		userService.saveUser(user);
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
