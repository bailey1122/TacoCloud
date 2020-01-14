package tacos.messagingrabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import tacos.Order;
import tacos.TacoCloudApplication;

@Component
public class RabbitOrderReceiver {
    private RabbitTemplate rabbit;
//    private MessageConverter converter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
//        this.converter = rabbit.getMessageConverter();
    }

    public Order receiveOrder() {
        return (Order) rabbit.receiveAndConvert(TacoCloudApplication.DEFAULT_PARSING_QUEUE);
//        return rabbit.receiveAndConvert("tacocloud.order.queue",
//                new ParameterizedTypeReference<Order>() {});
    }

//    public Order receiveOrder() {
//        Message message = rabbit.receive("tacocloud.orders", 30000);
//        return message != null
//                ? (Order) converter.fromMessage(message)
//                : null;
//    }
}
