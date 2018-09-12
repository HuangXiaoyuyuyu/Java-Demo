package org.hxy.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.hxy.mybatis.bean.Employee;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmpsTestInnerParameter(Employee employee);

    //携带了哪个字段查询条件就带上这个字段的值
    public List<Employee> getEmpsByConditionIf(Employee employee);

    public List<Employee> getEmpsByConditionTrim(Employee employee);

    public List<Employee> getEmpsByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    public List<Employee> getEmpsByConditionForeach(@Param("ids") List<Integer> ids);

    public void addEmps(@Param("emps") List<Employee> employees);
}
