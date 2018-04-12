package org.hxy.springboot;

import org.hxy.springboot.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * SpringBoot的单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootConfigApplicationTests {

    @Resource
    Person person;

    @Test
    public void contextLoads() {
        System.out.println(person);
    }

}
