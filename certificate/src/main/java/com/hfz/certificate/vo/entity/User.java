package com.hfz.certificate.vo.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by youjin on 2018/6/12.
 */

public class User implements Serializable {
	@Max(999999999)
	private Long id;// [id, bigint, 19]
	@NotNull(message="用户名不能为空")
	@Length(max = 50)
	private String username;//用户名 [username, varchar, 50]
	@Length(max = 100)
	private String name;// [name, varchar, 100]
	@NotNull(message="密码不能为空")
	@Length(max = 50)
	private String password;//密码 [password, varchar, 50]
	@Max(999999999)
	private Long deptId;// [dept_id, int, 10]
	@Length(max = 100)
	private String email;//邮箱 [email, varchar, 100]
	@Length(max = 100)
	private String mobile;//手机号 [mobile, varchar, 100]
	@Max(999)
	private Integer status;//状态 0:禁用，1:正常 [status, tinyint, 3]
	@Max(999999999)
	private Long userIdCreate;//创建用户id [user_id_create, bigint, 19]
	private Date createDate;//创建时间 [create_date, datetime, null]
	private Date updateDate;//修改时间 [update_date, datetime, null]
//共[11]个字段


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", deptId=" + deptId +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", status=" + status +
				", userIdCreate=" + userIdCreate +
				", createDate=" + createDate +
				", updateDate=" + updateDate +
				'}';
	}
}
