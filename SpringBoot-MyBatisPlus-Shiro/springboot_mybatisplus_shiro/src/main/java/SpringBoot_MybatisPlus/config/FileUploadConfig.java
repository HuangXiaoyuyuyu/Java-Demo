package SpringBoot_MybatisPlus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileUploadConfig {

    @Bean
    public CommonsMultipartResolver resolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSize(104857600);   //上传文件大小上限
        resolver.setMaxInMemorySize(10240);
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

}
