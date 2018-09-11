package org.hxy.mybatis.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.hxy.mybatis.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //多条记录封装一个map：Map<Integer,Employee> : 键是记录的主键，值是封装的javaBean
    //告诉mybatis封装这个map的时候使用哪个属性作为map的key
    @MapKey("email")
    public Map<String,Employee> getEmpByLastNameLikeReturnMap(String lastName);

    //返回一条记录的map；key就是列名，值就是对应的值
    public Map<String,Object> getEmpByIdReturnMap(Integer id);

    public List<Employee> getEmpsByLastNameLike(String lastName);

    public Employee getEmployeeByMap(Map<String,Object> map);

    public Employee getEmployeeById(Integer id);

    public Employee getEmployeeByIdAndByName(@Param("id") Integer id, @Param("lastName") String name);

    public void addEmployee(Employee employee);

    public boolean updateEmployee(Employee employee);

    public void deleteEmployeeById(Integer id);
}
