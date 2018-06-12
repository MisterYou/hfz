package com.hfz.userservice.dto;


import com.hfz.userservice.vo.entity.User;

/**
 * Created by youjin on 2018/7/10.
 */
public class LoginDTO {
    private User user;
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
