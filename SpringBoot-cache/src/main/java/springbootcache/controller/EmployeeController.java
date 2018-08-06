package springbootcache.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootcache.bean.Employee;
import springbootcache.service.EmployeeService;

import javax.annotation.Resource;

@RestController
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmpById(id);
        return emp;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return employee;
    }

    @GetMapping("/delemp")
    public String deleteEmpById(Integer id) {
        employeeService.deleteEmpById(id);
        return "SUCCESS";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName) {
        Employee emp = employeeService.getEmpByLastName(lastName);
        return emp;
    }
}
