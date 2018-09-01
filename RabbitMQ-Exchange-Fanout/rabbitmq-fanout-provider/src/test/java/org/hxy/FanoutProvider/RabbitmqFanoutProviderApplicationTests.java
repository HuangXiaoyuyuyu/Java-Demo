package org.hxy.FanoutProvider;

import org.hxy.FanoutProvider.container.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqFanoutProviderApplicationTests {

    @Autowired
    Sender sender;

    @Test
    public void contextLoads() {
        sender.send("Hello Fanout！");
    }

}
