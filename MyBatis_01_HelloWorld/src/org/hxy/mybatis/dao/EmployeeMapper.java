package org.hxy.mybatis.dao;

import org.hxy.mybatis.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmployeeById(Integer id);
}
