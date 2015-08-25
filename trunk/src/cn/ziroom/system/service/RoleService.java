package cn.ziroom.system.service;

import java.util.Arrays;
import java.util.List;

import cn.common.util.GeneralUtils;
import cn.ziroom.system.domain.Function;
import cn.ziroom.system.domain.Role;
import cn.ziroom.system.mapper.FunctionMapper;
import cn.ziroom.system.mapper.RoleMapper;

/**
 * 角色列表
 * 
 * @author Administrator
 * 
 */
public class RoleService {

	private RoleMapper roleMapper;

	private FunctionMapper functionMapper;

	/**
	 * 查询角色
	 * 
	 * @param role
	 * @return
	 */
	public String searchRole(Role role) {
		return GeneralUtils.easyUI(roleMapper.count(role), roleMapper.selectList(role));
	}

	/**
	 * 查找角色
	 * 
	 * @param role
	 * @return
	 */
	public Role findRole(Role role) {
		if (role.getRoleId() != null) {
			role = roleMapper.selectById(role.getRoleId());
		}
		return role;
	}

	/**
	 * 功能树
	 * 
	 * @param role
	 * @return
	 */
	public String getFunTree(Role role) {
		List<String> funCode = null;
		if (role.getRoleId() != null) {
			Role r = roleMapper.selectById(role.getRoleId());
			String content = r.getFunCode();
			if (!content.equals("")) {
				funCode = Arrays.asList(content.split(","));
			}
		}
		List<Function> functionList = functionMapper.selectList();
		for (Function f : functionList) {
			f.setId(f.getFunctionId());
			f.setText(f.getFunctionCode() + "|" + f.getFunctionName());
			if (funCode != null && funCode.contains(f.getFunctionCode())) {
				f.setChecked(true);
			}
			addNode(f, funCode);
		}
		return GeneralUtils.easyUI(functionList);
	}

	/**
	 * 增加节点
	 * 
	 * @param sort
	 */
	private void addNode(Function function, List<String> funCode) {
		List<Function> functionList = functionMapper.selectNodeList(function.getFunctionId());
		for (Function f : functionList) {
			f.setId(f.getFunctionId());
			f.setText(f.getFunctionCode() + "|" + f.getFunctionName());
			if (funCode != null && funCode.contains(f.getFunctionCode())) {
				f.setChecked(true);
			}
			addNode(f, funCode);
			function.getChildren().add(f);
		}
	}

	/**
	 * 保存角色
	 * 
	 * @param role
	 */
	public String saveRole(Role role) {
		if (role.getRoleId() != null) {
			roleMapper.update(role);
		} else {
			Role r = roleMapper.selectByName(role.getRoleName());
			if(r != null) {
				return "角色已存在！";
			}
			roleMapper.insert(role);
		}
		return "success";
	}
	
	/**
	 * 删除角色
	 * @param role
	 */
	public void delRole(Role role) {
		roleMapper.deleteById(role.getRoleId());
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	public void setFunctionMapper(FunctionMapper functionMapper) {
		this.functionMapper = functionMapper;
	}
}
