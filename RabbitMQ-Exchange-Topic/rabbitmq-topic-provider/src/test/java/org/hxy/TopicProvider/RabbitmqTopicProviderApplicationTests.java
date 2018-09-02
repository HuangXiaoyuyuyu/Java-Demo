package org.hxy.TopicProvider;

import org.hxy.TopicProvider.container.OrderSender;
import org.hxy.TopicProvider.container.ProductSender;
import org.hxy.TopicProvider.container.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTopicProviderApplicationTests {

    @Autowired
    UserSender userSender;

    @Autowired
    ProductSender productSender;

    @Autowired
    OrderSender orderSender;

    @Test
    public void contextLoads() {
        userSender.send("UserSender......");
        productSender.send("ProductSender......");
        orderSender.send("OrderSender......");
    }

}
