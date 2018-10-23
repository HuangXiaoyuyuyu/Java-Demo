package ServiceProvider;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ImportResource;

/**
 * Dubbo配置与SpringBoot整合的三种方式
 * 1.导入dubbo-starter,在appliaction.yml配置属性，使用@Service【暴露服务】，使用@Reference【引用服务】
 * 2.保留dubbo.xml配置文件：
 *          导入dubbo-starter,使用@ImportResource导入dubbo配置即可
 * 3.使用注解API的方式：
 *          将每一个组件手动创建到容器中，让dubbo来扫描其他组件
 */
//@EnableDubbo
@SpringBootApplication
@DubboComponentScan(basePackages = "ServiceProvider")
@EnableHystrix
//@ImportResource("provider.xml")
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }
}
