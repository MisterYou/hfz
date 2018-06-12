package com.hfz.userservice.client.hystrix;



import com.hfz.userservice.client.AuthServiceClient;
import com.hfz.userservice.vo.entity.JWT;
import org.springframework.stereotype.Component;

/**
 * Created by youjin on 2018/5/31.
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        System.out.println("--------opps getToken hystrix---------");
        return null;
    }
}
