package org.hxy.springboot.controller;

import org.hxy.springboot.dao.DepartmentDao;
import org.hxy.springboot.dao.EmployeeDao;
import org.hxy.springboot.entities.Department;
import org.hxy.springboot.entities.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Resource
    private EmployeeDao employeeDao;

    @Resource
    private DepartmentDao departmentDao;

    //查询所有员工
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "emp/list";
    }

    //跳转到添加页面
    @GetMapping("/emp")
    public String toAdd(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
    //    System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //跳转到编辑页面
    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //更新
    @PutMapping("/emp")
    public String update(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
