package com.hfz.hfzelasticsearch.vo.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import java.util.Date;

/**
 * Created by youjin on 2018/7/12.
 */
public class SysLog {
    @Max(999999999)
    private Long id;// [id, bigint, 19]
    @Max(999999999)
    private Long userId;//用户id [user_id, bigint, 19]
    @Length(max = 50)
    private String username;//用户名 [username, varchar, 50]
    @Length(max = 50)
    private String operation;//用户操作 [operation, varchar, 50]
    @Max(999999999)
    private Long time;//响应时间 [time, int, 10]
    @Length(max = 200)
    private String method;//请求方法 [method, varchar, 200]
    @Length(max = 5000)
    private String params;//请求参数 [params, varchar, 5000]
    @Length(max = 64)
    private String ip;//IP地址 [ip, varchar, 64]
    private Date createDate;//创建时间 [create_date, datetime, null]
//共[9]个字段


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", operation='" + operation + '\'' +
                ", time=" + time +
                ", method='" + method + '\'' +
                ", params='" + params + '\'' +
                ", ip='" + ip + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
