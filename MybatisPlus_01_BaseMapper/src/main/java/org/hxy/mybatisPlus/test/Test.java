package org.hxy.mybatisPlus.test;

import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.hxy.mybatisPlus.bean.Employee;
import org.hxy.mybatisPlus.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
    EmployeeMapper employeeMapper = (EmployeeMapper) applicationContext.getBean("employeeMapper");

    /**
     * 条件构造器 删除操作
     */
    @org.junit.Test
    public void testEntityWrapperDelete() {
        employeeMapper.delete(new EntityWrapper<Employee>()
                        .eq("last_name","Tom")
                        .eq("age",41)
        );
    }

    /**
     * 条件构造器 修改操作
     */
    @org.junit.Test
    public void testEntityWrapperUpdate() {
        Employee employee = new Employee();
        employee.setLastName("苍老师").setAge(50).setGender(0).setEmail("cal@qq.com");

        employeeMapper.update(employee,
                new EntityWrapper<Employee>()
                .eq("last_name","Tom")
                .eq("age",42)
        );
    }

    /**
     * 条件构造器 查询操作
     */

    @org.junit.Test
    public void testEntityWrapperSelect() {
        //分页查询 tbl_employee表中，年龄在 18~50之间性别为男且姓名为xx的所有用户
        /*List<Employee> employees = employeeMapper.selectPage(new Page<>(1, 4),
                new EntityWrapper<Employee>()
                        .between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("last_name", "Tom")
        );*/

        List<Employee> employees = employeeMapper.selectPage(new Page<>(1, 4),
                Condition.create().between("age", 18, 50)
                        .eq("gender", 1)
                        .eq("last_name", "Tom")
        );
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        //查询性别为1，根据age排序，简单分页
        /*List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
                .eq("gender", 1)
                .orderBy("age")
                //.orderDesc(Arrays.asList("age"))
                .last("desc limit 1,3")
        );

        for (Employee employee : employees) {
            System.out.println(employee);
        }*/
    }

    /**
     * 通用删除操作
     */

    @org.junit.Test
    public void testCommonDelete() {
        //deleteById
        Integer result = employeeMapper.deleteById(5);
        System.out.println(result);

        //deleteByMap
        /*Map<String,Object> map = new HashMap<>();
        map.put("last_name","AW");
        Integer result = employeeMapper.deleteByMap(map);
        System.out.println(result);*/

        //deleteBatchIds
        /*Integer result = employeeMapper.deleteBatchIds(Arrays.asList(15, 16, 17, 18, 19));
        System.out.println(result);*/
    }

    /**
     * 通用查询操作
     */

    @org.junit.Test
    public void testCommonSelect() {
        //通过id进行查询
       /* Employee employee = employeeMapper.selectById(5);
        System.out.println(employee);*/

       //通过多个列进行查询
        /*Employee employee = new Employee();
        employee.setLastName("MyBatisPlus");
        Employee result = employeeMapper.selectOne(employee);
        System.out.println("result: " + result);*/
        //通过多个列进行查询 查询结果大于1 报错  本身预期只有一个结果
        /*Employee employee = new Employee();
        employee.setLastName("MP");
        Employee result = employeeMapper.selectOne(employee);
        System.out.println("result: " + result);*/

        //通过多个id进行查询
        /*List<Employee> employees = employeeMapper.selectBatchIds(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        for (Employee employee:employees) {
            System.out.println(employee);
        }*/

        //通过map封装条件查询
        /*Map<String,Object> map = new HashMap<>();
        map.put("last_name","MP");//key 为数据库表列明  可以同时查出多个值 区分selectOne()
        List<Employee> employees = employeeMapper.selectByMap(map);
        for (Employee employee:employees) {
            System.out.println(employee);
        }*/

        //selectPage
        List<Employee> employees = employeeMapper.selectPage(new Page<>(2, 3), null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }


    /**
     * 通用更新操作
     */

    @org.junit.Test
    public void testCommonUpdate() {
        Employee employee = new Employee();
        //employee.setId(5).setLastName("MyBatisPlus").setEmail("MyBatisPlus@qq.com").setGender(0).setAge(33);
        employee.setId(6).setLastName("Oracle").setEmail("Oracle@qq.com").setGender(0)/*.setAge(33)*/;
        //Integer result = employeeMapper.updateById(employee);
        Integer result = employeeMapper.updateAllColumnById(employee);
        System.out.println(result);
    }


    /**
     * 通用插入操作
     */

    @org.junit.Test
    public void testCommonInsert() {
        Employee employee = new Employee();
        employee.setLastName("MP")/*.setEmail("MP@qq.com").setGender(1)*/.setAge(20).setSalary(100.0);
        //int result = employeeMapper.insert(employee);
        Integer result = employeeMapper.insertAllColumn(employee);
        System.out.println("result" + result);

        Integer key = employee.getId();
        System.out.println("key: " + key);
    }


    @org.junit.Test
    public void test() throws SQLException {
        DataSource source = (DataSource) applicationContext.getBean("dataSource",DataSource.class);
        System.out.println(source);

        Connection connection = source.getConnection();
        System.out.println(connection);
    }
}
