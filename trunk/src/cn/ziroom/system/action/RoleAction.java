package cn.ziroom.system.action;

import cn.common.action.GeneralAction;
import cn.ziroom.system.domain.Role;
import cn.ziroom.system.service.RoleService;

public class RoleAction extends GeneralAction {

	private static final long serialVersionUID = -5317937237256417793L;

	private Role role = new Role();

	private RoleService roleService;

	/**
	 * 角色列表查询
	 * 
	 * @throws Exception
	 */
	public void searchRole() throws Exception {
		page(role);
		String json = roleService.searchRole(role);
		out(json);
	}

	/**
	 * 查找角色
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findRole() throws Exception {
		role = roleService.findRole(role);
		return SUCCESS;
	}

	/**
	 * 功能树
	 * 
	 * @throws Exception
	 */
	public void funcTree() throws Exception {
		String json = roleService.getFunTree(role);
		out(json);
	}

	/**
	 * 保存角色
	 * 
	 * @throws Exception
	 */
	public void saveRole() throws Exception {
		String r = roleService.saveRole(role);
		out(r);
	}
	
	/**
	 * 删除
	 * @throws Exception
	 */
	public void delRole() throws Exception {
		roleService.delRole(role);
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
