import org.hxy.mp.mapper.EmployeeMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");

    EmployeeMapper employeeMapper = applicationContext.getBean("employeeMapper",EmployeeMapper.class);

    /**
     * 测试自定义全局操作
     */
    @org.junit.Test
    public void testMySqlInjector() {
        Integer result = employeeMapper.deleteAll();
        System.out.println(result);
    }

}
