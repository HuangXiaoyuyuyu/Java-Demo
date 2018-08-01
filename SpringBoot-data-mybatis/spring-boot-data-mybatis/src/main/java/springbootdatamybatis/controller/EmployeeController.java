package springbootdatamybatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootdatamybatis.bean.Employee;
import springbootdatamybatis.mapper.EmployeeMapper;

import javax.annotation.Resource;

@RestController
public class EmployeeController {

    @Resource
    private EmployeeMapper employeeMapper;

    @GetMapping("/emp/{id}")
    public Employee get(@PathVariable("id") Integer id) {
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
}
