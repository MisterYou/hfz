package com.hfz.userservice.service;

import com.hfz.userservice.dao.RoleDao;
import com.hfz.userservice.vo.entity.Result;
import com.hfz.userservice.vo.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author youjin
 * @Description:
 * @date 2018-06-20-16:52
 */
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    /**
     * 新增
     * @return
     */
    public Result save(Role role){
        Result result = new Result();
        role.setCreateDate(new Date());
        roleDao.save(role);
        return result;
    }
}
