package org.hxy.FanoutConsumer.container;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.push}" , autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT)
        )
)
public class PushReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("PushReveive-------"+msg);
    }

}
