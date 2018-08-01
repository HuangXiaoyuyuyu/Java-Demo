package springbootdatamybatis.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springbootdatamybatis.bean.Department;
import springbootdatamybatis.mapper.DepartmentMapper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    @Resource
    private DepartmentMapper departmentMapper;

    @GetMapping("/dept/{id}")
    public Department get(@PathVariable("id") Integer id) {
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }

    //@GetMapping("/dept")
    public Department insert(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/dept")
    public List<Department> getAll() {
        List<Department> list = departmentMapper.getAll();
        return list;
    }

    @DeleteMapping("/dept/{id}")
    public List<Department> delete(@PathVariable("id") Integer id) {
        departmentMapper.deleteDeptById(id);
        return departmentMapper.getAll();
    }
}
