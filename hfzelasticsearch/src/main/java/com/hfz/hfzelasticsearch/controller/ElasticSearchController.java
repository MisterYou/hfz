package com.hfz.hfzelasticsearch.controller;


import com.google.gson.Gson;
import com.hfz.hfzelasticsearch.dao.EmployeeRepository;
import com.hfz.hfzelasticsearch.vo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youjin
 * @Description:
 * @date 2018-07-24-11:01
 */
@RestController
@RequestMapping("/es")
public class ElasticSearchController {
    @Autowired
    private EmployeeRepository er;

    //增加
    @RequestMapping("/add")
    public String add(){

        Employee employee=new Employee();
        employee.setId("1");
        employee.setFirstName("xuxu");
        employee.setLastName("zh");
        employee.setAge(26);
        employee.setAbout("i am in peking");
        er.save(employee);

        System.out.println("add a obj");

        return "success";
    }

    //删除
    @RequestMapping("/delete")
    public String delete(){
        Employee employee = new Employee();
        er.delete("1");
        return "success";
    }

    //局部更新
    @RequestMapping("/update")
    public String update(){

        Employee employee=er.queryEmployeeById("1");
        employee.setFirstName("哈哈");
        er.save(employee);

        System.err.println("update a obj");

        return "success";
    }

    //查询
    @RequestMapping("/query")
    public Employee query(){

        Employee accountInfo=er.queryEmployeeById("1");
        System.out.println(new Gson().toJson(accountInfo));

        return accountInfo;
    }

}
