package SpringBoot_AMQP_RabbitMQ;

import SpringBoot_AMQP_RabbitMQ.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAmqpRabbitmqApplicationTests {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private AmqpAdmin amqpAdmin;

    @Test
    public void create() {
    //    amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
    //    amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqpadmin.haha",null));
    }

    @Test
    public void contextLoads() {
        /*Map<Object,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息~");
        map.put("data",Arrays.asList("helloWorld",123,true));
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);*/
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book().setBookName("三国演义").setAuthor("Oliver"));
    }

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    @Test
    public void sendMessageForAll() {
        rabbitTemplate.convertAndSend("exchange.fanout","atguigu",new Book().setBookName("Oracle").setAuthor("Java"));
    }

    @Test
    public void sendMessageForTopic() {
        rabbitTemplate.convertAndSend("exchange.topic","atguigu",new Book().setBookName("Redis").setAuthor("Docker"));
    }
}
