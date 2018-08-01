package springbootdatamybatis.mapper;

import org.apache.ibatis.annotations.*;
import springbootdatamybatis.bean.Department;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    public Department getDeptById(Integer id);

    @Delete("delete from department where id = #{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set department_name = #{departmentName} where id = #{id}")
    public int updateDept(Department department);

    @Select("select * from department")
    public List<Department> getAll();
}
