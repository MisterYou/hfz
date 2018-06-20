package com.hfz.userservice.dao;

import com.hfz.userservice.vo.entity.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author youjin
 * @Description:
 * @date 2018-06-20-16:14
 */
public interface RoleDao {

    @Insert("INSERT INTO sys_role( " +
            "role_name, " +
            "role_sign, " +
            "remark, " +
            "user_id_create, " +
            "create_date, " +
            "update_date ) VALUES ( " +
            "#{roleName,jdbcType=VARCHAR}, " +
            "#{roleSign,jdbcType=VARCHAR}, " +
            "#{remark,jdbcType=VARCHAR}, " +
            "#{userIdCreate,jdbcType=BIGINT}, " +
            "#{createDate,jdbcType=TIMESTAMP}, " +
            "#{updateDate,jdbcType=TIMESTAMP})")
    void save(Role role);

    @Select("SELECT " +
            "sr.id as id, " +
            "sr.role_name as roleName, " +
            "sr.role_sign as roleSign, " +
            "sr.remark as remark, " +
            "sr.user_id_create as userIdCreate, " +
            "sr.create_date as createDate, " +
            "sr.update_date as updateDate " +
            "FROM " +
            "sys_role sr " +
            "LEFT JOIN sys_user_role sur ON sr.id = sur.role_id " +
            "LEFT JOIN sys_user su ON sur.user_id = su.id " +
            "WHERE su.username = #{username} ")
    List<Role> findRoleByUsername(@Param("username") String username);
}
