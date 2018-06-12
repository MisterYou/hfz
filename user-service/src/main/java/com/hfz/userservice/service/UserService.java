package com.hfz.userservice.service;

import com.hfz.userservice.client.AuthServiceClient;
import com.hfz.userservice.dao.UserDao;
import com.hfz.userservice.dto.LoginDTO;
import com.hfz.userservice.dto.RespDTO;
import com.hfz.userservice.vo.entity.JWT;
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

    public void createUser(User user){
        user.setPassword(BPwdEncoderUtils.BCryptPassword(user.getPassword()));
        user.setCreateDate(new Date());
        user.setStatus(1);
        userDao.save(user);
    }

    public User getUserInfo(String username){
        return userDao.findByUsername(username);
    }
    public RespDTO login(String username , String password){
       User user= userDao.findByUsername(username);
       if(null==user){
           throw new CommonException(ErrorCode.USER_NOT_FOUND);
       }
       if(!BPwdEncoderUtils.matches(password,user.getPassword())){
           throw new CommonException(ErrorCode.USER_PASSWORD_ERROR);
       }

        JWT jwt = authServiceClient.getToken("Basic dWFhLXNlcnZpY2U6MTIzNDU2", "password", username, password);
        // 获得用户菜单
        if(null==jwt){
            throw new CommonException(ErrorCode.GET_TOKEN_FAIL);
        }
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setUser(user);
        loginDTO.setToken(jwt.getAccess_token());
        return RespDTO.onSuc(loginDTO);
    }
}
