package org.hxy.mybatis.controller;

import org.hxy.mybatis.bean.Employee;
import org.hxy.mybatis.dao.EmployeeMapper;
import org.hxy.mybatis.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/getEmps")
    public String emps(Map<String,Object> map) {
        List<Employee> emps = employeeService.getEmps();
        map.put("allEmps",emps);
        return "list";
    }

//    @Resource
//    private EmployeeMapper employeeMapper;
//
//    @RequestMapping("/getEmps")
//    public String emps(Map<String,Object> map) {
//        List<Employee> emps = employeeMapper.getEmps();
//        map.put("allEmps",emps);
//        return "list";
//    }
}
