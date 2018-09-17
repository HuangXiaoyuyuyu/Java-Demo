import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import myBatisPlus.bean.Employee;
import myBatisPlus.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Test {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

    EmployeeMapper employeeMapper = applicationContext.getBean("employeeMapper",EmployeeMapper.class);


    /**
     * AR 分页复杂操作
     */
    @org.junit.Test
    public void testARPage() {
        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 2),
                new EntityWrapper<Employee>().like("last_name", "a")
        );
        List<Employee> records = page.getRecords();
        for (Employee result : records) {
            System.out.println(result);
        }
    }

    /**
     * AR Delete
     */

    @org.junit.Test
    public void testARDelete() {
        Employee employee = new Employee();
        /*boolean result = employee.deleteById(11);
        System.out.println(result);*/

        boolean result = employee.delete(new EntityWrapper<Employee>()
                .eq("email", "bb@qq.com")
        );
        System.out.println(result);
    }

    /**
     * AR Select
     */

    @org.junit.Test
    public void testARSelect() {
        Employee employee = new Employee();
        /*Employee result = employee.selectById(1);
        System.out.println(result);*/

        //List<Employee> list = employee.selectAll();

        /*List<Employee> list = employee.selectList(new EntityWrapper<Employee>()
                .like("last_name", "a")
        );

        for (Employee result:list) {
            System.out.println(result);
        }*/

        int count = employee.selectCount(new EntityWrapper<Employee>()
                .like("last_name", "a")
        );
        System.out.println(count);
    }

    /**
     *  AR Update
     */

    @org.junit.Test
    public void testARUpdate() {
        Employee employee = new Employee();
        employee.setId(6)
                .setLastName("bb")
                .setEmail("bb@qq.com")
                .setGender(1)
                .setAge(35);
        boolean result = employee.updateById();
        System.out.println("result: " + result);
    }

    /**
     *  AR Insert
     */

    @org.junit.Test
    public void testARInsert() {
        Employee employee = new Employee();
        employee.setLastName("aa")
                .setEmail("aa@qq.com")
                .setGender(1)
                .setAge(35);
        boolean result = employee.insert();
        System.out.println("result: " + result);
    }

    @org.junit.Test
    public void testEnvironment() throws SQLException {
        DataSource source = applicationContext.getBean("dataSource",DataSource.class);
        System.out.println(source);

        Connection connection = source.getConnection();
        System.out.println(connection);
    }

}
