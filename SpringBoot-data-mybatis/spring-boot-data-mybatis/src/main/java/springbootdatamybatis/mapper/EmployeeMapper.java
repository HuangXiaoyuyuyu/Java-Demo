package springbootdatamybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootdatamybatis.bean.Employee;

@Mapper
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public int insertEmp(Employee employee);

}
