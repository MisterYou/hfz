package com.hfz.certificate.vo.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author youjin
 * @Description:
 * @date 2018-06-20-16:18
 */
public class UserRoleEntity {
    @NotNull
    @Max(999999999)
    private Long id;// [id, bigint, 19]
    @Max(999999999)
    private Long userId;//用户ID [user_id, bigint, 19]
    @Max(999999999)
    private Long roleId;//角色ID [role_id, bigint, 19]
//共[3]个字段


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
