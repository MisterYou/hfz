package com.hfz.hfzhi.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam String name){
        return "hi"+name+",i am from port:"+port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }


    @Value("${houfazuo}")
    String houfazuo;
    @RequestMapping(value = "/hii")
    public String hi(){
        return houfazuo;
    }
}
