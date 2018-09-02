package org.hxy.TopicProvider.container;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(String msg) {
        amqpTemplate.convertAndSend(exchange,"user.log.debug","user.log.debug....."+msg);
        amqpTemplate.convertAndSend(exchange,"user.log.info","user.log.info....."+msg);
        amqpTemplate.convertAndSend(exchange,"user.log.warn","user.log.warn....."+msg);
        amqpTemplate.convertAndSend(exchange,"user.log.error","user.log.error....."+msg);
    }

}
