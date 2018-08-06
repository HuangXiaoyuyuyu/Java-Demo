package springbootcache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

@Configuration
public class MyCacheConfig {

    @Bean
    public KeyGenerator keyGenerator() {
        KeyGenerator generator = new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + '[' + Arrays.asList(objects) + ']';
            }
        };
        return generator;
    }

}
