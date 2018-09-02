package org.hxy.TopicProvider.container;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(String msg) {
        amqpTemplate.convertAndSend(exchange,"order.log.debug","order.log.debug....."+msg);
        amqpTemplate.convertAndSend(exchange,"order.log.info","order.log.info....."+msg);
        amqpTemplate.convertAndSend(exchange,"order.log.warn","order.log.warn....."+msg);
        amqpTemplate.convertAndSend(exchange,"order.log.error","order.log.error....."+msg);
    }

}
