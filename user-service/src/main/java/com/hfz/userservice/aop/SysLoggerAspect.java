package com.hfz.userservice.aop;

import com.alibaba.fastjson.JSON;

import com.hfz.userservice.annotation.SysLogger;
import com.hfz.userservice.vo.entity.SysLog;
import com.hfz.userservice.service.LoggerService;
import com.hfz.userservice.util.HttpUtils;
import com.hfz.userservice.util.UserUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by youjin on 2018/7/12.
 */
@Aspect
@Component
public class SysLoggerAspect {
    @Autowired
    private LoggerService loggerService;

    @Pointcut("@annotation(com.hfz.userservice.annotation.SysLogger)")
    public void loggerPointCut() {

    }

    @Before("loggerPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog sysLog = new SysLog();
        SysLogger sysLogger = method.getAnnotation(SysLogger.class);
        if(sysLogger != null){
            //注解上的描述
            sysLog.setOperation(sysLogger.value());
        }
        //请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        //请求的参数
        Object[] args = joinPoint.getArgs();
        String params="";
        for(Object o:args){
            params+=JSON.toJSONString(o);
        }
        if(!StringUtils.isEmpty(params)) {
            sysLog.setParams(params);
        }
        //设置IP地址
        sysLog.setIp(HttpUtils.getIpAddress());
        //用户名
        String username = UserUtils.getCurrentPrinciple();
        if(!StringUtils.isEmpty(username)) {
            sysLog.setUsername(username);
        }
        sysLog.setCreateDate(new Date());
        //保存系统日志
        loggerService.log(sysLog);
    }

}

