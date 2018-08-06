package springbootcache.mapper;

import org.apache.ibatis.annotations.*;
import springbootcache.bean.Employee;

@Mapper
public interface EmployeeMapper {

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id = #{id}")
    public void updateEmp(Employee employee);

    @Select("select * from employee where id = #{id}")
    public Employee getEmpById(Integer id);

    @Select("select * from employee where lastName = #{lastName}")
    public Employee getEmpByLastName(String lastName);
}
