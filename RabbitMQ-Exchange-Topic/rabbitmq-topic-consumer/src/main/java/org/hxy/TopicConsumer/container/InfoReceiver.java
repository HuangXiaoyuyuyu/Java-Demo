package org.hxy.TopicConsumer.container;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.info}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.TOPIC),
                key = "*.log.info"
        )
)
public class InfoReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("Info---Receive---> " + msg);
    }

}
