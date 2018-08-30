package org.hxy.DirectProvider;

import org.hxy.DirectProvider.container.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqDirectProviderApplicationTests {

    @Autowired
    Sender sender;

    @Test
    public void contextLoads() throws InterruptedException {
        while (true) {
            Thread.sleep(5000);
            sender.send("Hello-World");
        }

    }

}
