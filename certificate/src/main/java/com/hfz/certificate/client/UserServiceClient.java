package com.hfz.certificate.client;


import com.hfz.certificate.client.hystrix.UserServiceHystrix;
import com.hfz.certificate.dto.RespDTO;
import com.hfz.certificate.vo.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;



/**
 * Created by youjin on 2018/6/24.
 */

@FeignClient(value = "user-service",fallback = UserServiceHystrix.class )
public interface UserServiceClient {

    @PostMapping(value = "/user/{username}")
    RespDTO<User> getUser(@RequestHeader(value = "Authorization") String token, @PathVariable("username") String username);
}



