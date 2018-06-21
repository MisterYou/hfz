package com.hfz.userservice.controller;

import com.hfz.userservice.annotation.SysLogger;
import com.hfz.userservice.service.RoleService;
import com.hfz.userservice.vo.entity.Result;
import com.hfz.userservice.vo.entity.Role;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youjin
 * @Description: 角色
 * @date 2018-06-20-16:49
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation(value = "新增", notes = "新增角色")
    @PostMapping("/save")
    @SysLogger("save")
    public Result save(@RequestBody Role role){
        //参数判读省略,判读该用户在数据库是否已经存在省略
        return roleService.save(role);
    }

}
