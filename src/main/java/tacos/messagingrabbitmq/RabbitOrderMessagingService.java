package tacos.messagingrabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tacos.Order;
import tacos.TacoCloudApplication;
import tacos.messaging.OrderMessagingService;

@Service
public class RabbitOrderMessagingService
        implements OrderMessagingService {

    private RabbitTemplate rabbit;

    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    @Override
    public void sendOrder(Order order) {
        MessageConverter converter = rabbit.getMessageConverter();
        MessageProperties props = new MessageProperties();
        props.setHeader("X_ORDER_SOURCE", "WEB");
        Message message = converter.toMessage(order, props);
        rabbit.send(TacoCloudApplication.EXCHANGE_NAME, TacoCloudApplication.ROUTING_KEY, message);
    }


//    @Scheduled(fixedDelay = 3000L)
//    public void sendHi() {
//        rabbit.convertAndSend(TacoCloudApplication.EXCHANGE_NAME, TacoCloudApplication.ROUTING_KEY, "hi");
//
//    }


    //    public void sendOrder(Order order) {
//        rabbit.convertAndSend("tacocloud.order", order);
//    }

//    public void sendOrder(Order order) {
//        rabbit.convertAndSend("tacocloud.order.queue", order,
//                new MessagePostProcessor() {
//                    @Override
//                    public Message postProcessMessage(Message message) throws AmqpException {
//                        MessageProperties props = message.getMessageProperties();
//                        props.setHeader("X_ORDER_SOURCE", "WEB");
//                        return message;
//                    }
//                });
//    }
}
