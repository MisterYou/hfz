package com.hfz.hfzelasticsearch.dao;


import com.hfz.hfzelasticsearch.vo.entity.Employee;

/**
 * @author youjin
 * @Description:
 * @date 2018-07-24-11:00
 */
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    Employee queryEmployeeById(String id);
}
