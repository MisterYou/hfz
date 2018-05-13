package com.hfz.hfzhi.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hi")
    public String home(@RequestParam String name){
        return "hi"+name+",i am from port:1111";
    }

    @Value("${houfazuo}")
    String houfazuo;
    @RequestMapping(value = "/hii")
    public String hi(){
        return houfazuo;
    }
}