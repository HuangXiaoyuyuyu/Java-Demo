package ServiceConsumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.hxy.bean.UserAddress;
import org.hxy.service.OrderService;
import org.hxy.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Service
@Component
public class OrderServiceImpl implements OrderService {

    //@Autowired
    //@Reference(loadbalance = "roundrobin")
    @Reference(timeout = 1000)
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    @Override
    public List<UserAddress> initOrder(String userId) {
        return userService.getUserAddressList(userId);
    }

    public List<UserAddress> hello(String userId) {
        return Arrays.asList(new UserAddress(5,"China-测试地址","1","测试","测试","Y"));
    }
}
