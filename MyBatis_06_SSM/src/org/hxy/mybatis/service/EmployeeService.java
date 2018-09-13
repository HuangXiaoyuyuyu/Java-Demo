package org.hxy.mybatis.service;

import org.hxy.mybatis.bean.Employee;
import org.hxy.mybatis.dao.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    public List<Employee> getEmps() {
        return employeeMapper.getEmps();
    }
}
