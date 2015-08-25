package cn.ziroom.system.service;

import java.util.Arrays;
import java.util.List;

import cn.common.manager.SessionManager;
import cn.common.util.GeneralUtils;
import cn.ziroom.system.domain.Role;
import cn.ziroom.system.domain.User;
import cn.ziroom.system.mapper.RoleMapper;
import cn.ziroom.system.mapper.UserMapper;

/**
 * 系统用户管理业务处理类
 * 
 * @author Administrator
 * 
 */
public class UserService {

	public static String USER_KEY = "user";

	private UserMapper userMapper;

	private RoleMapper roleMapper;

	/**
	 * 同步用户数据访问业务处理方法
	 * 
	 * @param list
	 * @return
	 */
	public String synchroUser(List<User> list) {
		for (User user : list) {
			String code = userMapper.selectByCode(user.getStaffid());
			if (code != null) {
				userMapper.update(user);
			} else {
				userMapper.insert(user);
			}
		}
		return "success";
	}

	/**
	 * 用户登录业务处理方法
	 * 
	 * @param user
	 * @return
	 */
	public boolean isLogin(User user) {
		boolean isLogin = false;
		User loginUser = userMapper.selectByAccount(user);
		if (loginUser != null) {
			isLogin = true;
			SessionManager.setAttr(USER_KEY, loginUser);
		}
		return isLogin;
	}

	/**
	 * 用户查询
	 * 
	 * @param user
	 * @return
	 */
	public String searchUser(User user) {
		return GeneralUtils.easyUI(userMapper.count(user), userMapper.selectList(user));
	}

	/**
	 * 查找用户
	 * 
	 * @param user
	 * @return
	 */
	public User findUser(User user) {
		user = userMapper.selectById(user.getId());
		return user;
	}

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	public void saveUser(User user) {
		userMapper.updateUser(user);
	}

	/**
	 * 登出系统
	 * 
	 */
	public boolean logout() {
		SessionManager.removeAttr(USER_KEY);
		return true;
	}

	/**
	 * 用户权限处理
	 * 
	 * @param staffId
	 * @return
	 */
	public boolean authority() {
		User user = (User) SessionManager.getAttr(USER_KEY);
		// 根据工号查询用户
		if (user != null) {
			Role role = roleMapper.selectByName(user.getStaffRole());
			if (role != null && role.getFunCode() != null && !role.getFunCode().equals("")) {
				List<String> function = Arrays.asList(role.getFunCode().split(","));
				SessionManager.setAttr(SessionManager.FUNCTION_KEY, function);
			} else {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 角色
	 * @param staffrole
	 * @return
	 */
	public List<String> getFunction(String staffrole){
		Role role = roleMapper.selectByName(staffrole);
		List<String> function = Arrays.asList(role.getFunCode().split(","));
		return function;
	}

	/**
	 * 根据编号查询用户
	 * 
	 * @param staffId
	 * @return
	 */
	public User searchUserByStaffId(String staffId) {
		return userMapper.searchUserByStaffId(staffId);
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
}
