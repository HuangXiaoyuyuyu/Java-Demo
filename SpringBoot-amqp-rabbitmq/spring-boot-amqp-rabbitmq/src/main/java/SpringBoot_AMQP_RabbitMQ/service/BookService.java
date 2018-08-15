package SpringBoot_AMQP_RabbitMQ.service;

import SpringBoot_AMQP_RabbitMQ.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book) {
        System.out.println("收到消息：" + book);
    }

    @RabbitListener(queues = "atguigu")
    public void get(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
