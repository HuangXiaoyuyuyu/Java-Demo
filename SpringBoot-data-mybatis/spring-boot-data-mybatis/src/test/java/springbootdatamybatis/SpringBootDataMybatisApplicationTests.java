package springbootdatamybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataMybatisApplicationTests {

    @Resource
    DataSource dataSource;

    @Test
    public void contextLoads() {
        System.out.println(dataSource);
    }

}
