package com.hfz.uaaservice.dao;

import com.hfz.uaaservice.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author youjin
 * @Description:
 * @date 2018-06-19-9:21
 */
public interface RoleDao {

    @Select("SELECT" +
            "sr.id as id, " +
            "sr.role_name as roleName, " +
            "sr.role_sign as roleSign, " +
            "sr.remark as remark, " +
            "sr.user_id_create as userIdCreate, " +
            "sr.create_date as createDate, " +
            "sr.update_date as updateDate " +
            "FROM" +
            "sys_role sr " +
            "LEFT JOIN sys_user_role sur ON sr.id = sur.role_id " +
            "LEFT JOIN sys_user su ON sur.user_id = su.id " +
            "WHERE su.username = #{username} ")
    List<Role> findRoleByUsername(@Param("username") String username);
}
