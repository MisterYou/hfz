package com.hfz.userservice.controller;

import com.hfz.userservice.annotation.SysLogger;
import com.hfz.userservice.dto.RespDTO;
import com.hfz.userservice.service.UserService;
import com.hfz.userservice.util.BPwdEncoderUtils;
import com.hfz.userservice.vo.entity.Result;
import com.hfz.userservice.vo.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author youjin
 * @Description:
 * @date 2018-06-12-19:19
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    UserService userService;

    @ApiOperation(value = "注册", notes = "username和password为必选项")
    @PostMapping("/registry")
    @SysLogger("registry")
    public Result createUser(@RequestBody User user){
        //参数判读省略,判读该用户在数据库是否已经存在省略
        return userService.createUser(user);
    }

    @ApiOperation(value = "登录", notes = "username和password为必选项")
    @PostMapping("/login")
    @SysLogger("login")
    public Result login(@RequestBody User user){
        //参数判读省略
        return userService.login(user);
    }

    @ApiOperation(value = "根据用户名获取用户", notes = "根据用户名获取用户")
    @PostMapping("/getuserbyname")
    @PreAuthorize("hasRole('USER')")
    @SysLogger("getUserInfo")
    // @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public Result getUserInfo(@RequestBody User user){
        //参数判读省略

        return userService.getUserInfo(user.getUsername());
    }


}
