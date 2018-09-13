package org.hxy.mybatis.dao;

import org.hxy.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapper {

    public List<Employee> getEmps();
}
