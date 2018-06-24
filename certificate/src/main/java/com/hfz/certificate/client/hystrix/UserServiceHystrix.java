package com.hfz.certificate.client.hystrix;

import com.hfz.certificate.client.UserServiceClient;
import com.hfz.certificate.dto.RespDTO;
import com.hfz.certificate.vo.entity.User;
import org.springframework.stereotype.Component;


/**
 * Created by youjin on 2017/6/24.
 */
@Component
public class UserServiceHystrix implements UserServiceClient {

    @Override
    public RespDTO<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        return null;
    }
}
