package com.hfz.uaaservice.service;


import com.hfz.uaaservice.dao.RoleDao;
import com.hfz.uaaservice.dao.UserDao;
import com.hfz.uaaservice.entity.Role;
import com.hfz.uaaservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fangzhipeng on 2017/5/10.
 */
@Service
public class UserServiceDetail implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    @Autowired
    private RoleDao roleDao;

    /**
     * 根据用户名查询对应角色
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<Role> roles = roleDao.findRoleByUsername(username);
        user.setAuthorities(roles);
        return user;
    }
}
