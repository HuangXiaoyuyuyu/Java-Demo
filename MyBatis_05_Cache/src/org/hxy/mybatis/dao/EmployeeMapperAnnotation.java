package org.hxy.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import org.hxy.mybatis.bean.Employee;

public interface EmployeeMapperAnnotation {

    @Select("select * from tb1_employee where id = #{id}")
    public Employee getEmployeeById(Integer id);
}
