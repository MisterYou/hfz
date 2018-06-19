package com.hfz.uaaservice.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.Max;
import java.util.Date;

/**
 * Created by fangzhipeng on 2017/5/27.
 */
public class Role implements GrantedAuthority {

	@Max(999999999)
	private Long id;// [id, bigint, 19]
	@Length(max = 100)
	private String roleName;//角色名称 [role_name, varchar, 100]
	@Length(max = 100)
	private String roleSign;//角色标识 [role_sign, varchar, 100]
	@Length(max = 100)
	private String remark;//备注 [remark, varchar, 100]
	@Max(999999999)
	private Long userIdCreate;//创建用户id [user_id_create, bigint, 19]
	private Date createDate;//创建时间 [create_date, datetime, null]
	private Date updateDate;//创建时间 [update_date, datetime, null]
//共[7]个字段

	@Override
	public String getAuthority() {
		return roleSign;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleSign() {
		return roleSign;
	}

	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getUserIdCreate() {
		return userIdCreate;
	}

	public void setUserIdCreate(Long userIdCreate) {
		this.userIdCreate = userIdCreate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
