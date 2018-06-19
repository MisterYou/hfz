package com.hfz.uaaservice.dao;


import com.hfz.uaaservice.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by fangzhipeng on 2017/5/27.
 */

public interface UserDao  {

	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	@Select("SELECT " +
			"id as id, " +
			"username as username, " +
			"name as name, " +
			"password as password, " +
			"dept_id as deptId, " +
			"email as email, " +
			"mobile as mobile, " +
			"status as status, " +
			"user_id_create as userIdCreate, " +
			"create_date as createDate, " +
			"update_date as updateDate   " +
			"FROM " +
			"sys_user where username = #{username}")
	User findByUsername(@Param("username") String username);
}
