package cn.ziroom.system.domain;

import cn.common.service.GeneralCriteria;

public class Role extends GeneralCriteria {

	private static final long serialVersionUID = 1678567693053302328L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.role_id
     *
     * @mbggenerated Mon Dec 26 10:31:50 CST 2011
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.role_name
     *
     * @mbggenerated Mon Dec 26 10:31:50 CST 2011
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.fun_code
     *
     * @mbggenerated Mon Dec 26 10:31:50 CST 2011
     */
    private String funCode;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.role_desc
     *
     * @mbggenerated Mon Dec 26 10:31:50 CST 2011
     */
    private String roleDesc;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getFunCode() {
        return funCode;
    }

    public void setFunCode(String funCode) {
        this.funCode = funCode == null ? null : funCode.trim();
    }

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}