package com.hfz.userservice.service;

import com.hfz.userservice.client.AuthServiceClient;
import com.hfz.userservice.dao.UserDao;
import com.hfz.userservice.dto.LoginDTO;
import com.hfz.userservice.dto.RespDTO;
import com.hfz.userservice.vo.entity.JWT;
import com.hfz.userservice.vo.entity.Result;
import com.hfz.userservice.vo.entity.User;
import com.hfz.userservice.exception.CommonException;
import com.hfz.userservice.exception.ErrorCode;
import com.hfz.userservice.util.BPwdEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by youjin on 2018/6/12.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    AuthServiceClient authServiceClient;

    public Result createUser(User user) {
        Result result = new Result();
        user.setPassword(BPwdEncoderUtils.BCryptPassword(user.getPassword()));
        user.setCreateDate(new Date());
        user.setStatus(1);
        userDao.save(user);
        result.setStatus(Result.Status.SUCCESS.code());
        result.setContent("操作成功");
        return result;
    }

    public Result getUserInfo(String username) {
        Result result = new Result();

        User user = userDao.findByUsername(username);

        return result.setContent(user);
    }

    public Result login(User user) {
        Result result = new Result();
        User user1 = userDao.findByUsername(user.getUsername());

        if (null == user1) {
            throw new CommonException(ErrorCode.USER_NOT_FOUND);
        }
        if (!BPwdEncoderUtils.matches(user.getPassword(), user1.getPassword())) {
            throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
        }

        JWT jwt = authServiceClient.getToken("Basic dWFhLXNlcnZpY2U6OTUyNzEzMTQ=", "password", user.getUsername(), user.getPassword());
        // 获得用户菜单
        if (null == jwt) {
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUser(user1);
        loginDTO.setToken(jwt.getAccess_token());
        return result.setContent(loginDTO);
    }
}
