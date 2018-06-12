package com.hfz.userservice.dao;

import com.hfz.userservice.vo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by youjin on 2018/5/27.
 */

public interface UserDao{

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
			"create_date as createDate," +
			"update_date as updateDate " +

			"FROM " +
			"sys_user where username = #{username}")
	User findByUsername(String username);

	@Insert("INSERT INTO sys_user(" +
			"username," +
			"name," +
			"password," +
			"dept_id," +
			"email," +
			"mobile," +
			"status," +
			"user_id_create," +
			"create_date," +
			"update_date ) VALUES (" +
			"#{username,jdbcType=VARCHAR}," +
			"#{name,jdbcType=VARCHAR}," +
			"#{password,jdbcType=VARCHAR}," +
			"#{deptId,jdbcType=INTEGER}," +
			"#{email,jdbcType=VARCHAR}," +
			"#{mobile,jdbcType=VARCHAR}," +
			"#{status,jdbcType=INTEGER}," +
			"#{userIdCreate,jdbcType=BIGINT}," +
			"#{createDate,jdbcType=TIMESTAMP}," +
			"#{updateDate,jdbcType=TIMESTAMP})")
	void save(User user);
}
