package SpringBoot_MybatisPlus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("SpringBoot_MybatisPlus.mapper")
public class SpringbootThymeleafMybatisplusShiroJqueryAjaxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootThymeleafMybatisplusShiroJqueryAjaxApplication.class, args);
    }
}
