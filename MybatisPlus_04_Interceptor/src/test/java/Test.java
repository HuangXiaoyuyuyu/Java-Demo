import com.baomidou.mybatisplus.plugins.Page;
import org.hxy.mp.beans.Employee;
import org.hxy.mp.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class Test {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

    EmployeeMapper employeeMapper = applicationContext.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试乐观锁插件
     */

    @org.junit.Test
    public void testOptimistic() {
        Employee employee = new Employee();
        employee.setId(30);
        employee.setLastName("huangxiaoyu");
        employee.setEmail("hxy@qq.com");
        employee.setGender("1");
        employee.setAge(20);
        employee.setVersion(1);
        employeeMapper.updateById(employee);
    }

    /**
     * 测试性能分析插件
     */
    @org.junit.Test
    public void testPerformance() {
        Employee employee = new Employee();
        employee.setLastName("hxyyy");
        employee.setEmail("hxy@qq.com");
        employee.setGender("1");
        employee.setAge(20);
        employeeMapper.insert(employee);
    }

    /**
     * 测试SQL执行分析插件
     */

    @org.junit.Test
    public void testSQLExplain() {
        employeeMapper.delete(null);
    }

    /**
     *测试分页插件
     */

    @org.junit.Test
    public void testPage() {

        Page<Employee> page = new Page<>(5,1);

        List<Employee> employees = employeeMapper.selectPage(page, null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("=============================获取分页的一些相关信息============================");
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("总页数： " + page.getPages());
        System.out.println("是否为第一页: " + page.hasPrevious());
        System.out.println("是否为最后一页: " + page.hasNext());

    }
}
