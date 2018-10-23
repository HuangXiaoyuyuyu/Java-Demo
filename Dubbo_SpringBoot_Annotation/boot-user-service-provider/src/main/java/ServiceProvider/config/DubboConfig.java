package ServiceProvider.config;

import com.alibaba.dubbo.config.*;
import org.hxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DubboConfig {

    /**
     * <dubbo:application name="boot-user-service-provider"  />
     * @return
     */
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    /**
     *<dubbo:registry protocol="zookeeper" address="127.0.0.1:2181" />
     * @return
     */
    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    /**
     * <dubbo:protocol name="dubbo" port="20882" />
     * @return
     */
    @Bean
    public ProtocolConfig protocolConfig() {
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20883);
        return protocolConfig;
    }

    /**
     * <dubbo:service interface="org.hxy.service.UserService" ref="userService">
     *     <dubbo:method name="getUserAddressList" timeout="1000"></dubbo:method>
     * </dubbo:service>
     * @param userService
     * @return
     */
    @Bean
    public ServiceConfig<UserService> serviceServiceConfig(@Autowired UserService userService) {
        ServiceConfig<UserService> serviceServiceConfig = new ServiceConfig<>();
        serviceServiceConfig.setInterface(UserService.class);
        serviceServiceConfig.setRef(userService);

        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");

        List<MethodConfig> list = new ArrayList<>();
        list.add(methodConfig);

        serviceServiceConfig.setMethods(list);
        return serviceServiceConfig;
    }
}
