package tacos.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tacos.Order;
import tacos.TacoCloudApplication;
import tacos.messaging.KitchenUI;

//@Profile("kafka-listener")
@Component
//@Service
@Slf4j
public class OrderListener {

    private KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }

    @RabbitListener(queues = TacoCloudApplication.DEFAULT_PARSING_QUEUE)
    public void receiveOrder(Order order) {
        ui.displayOrder(order);
    }

//    @RabbitListener(queues = TacoCloudApplication.DEFAULT_PARSING_QUEUE)
//    public void receiveOrder(final Message message) {
//        ui.show(message.toString());
//
//    }

//    @JmsListener(destination = "tacocloud.order.queue")
//    public void receiveOrder(Order order) {
//        ui.displayOrder(order);
//    }

//    @KafkaListener(topics="tacocloud", groupId = "group_json")
//    public void handle(Order order) {
//
//
//        ui.displayOrder(order);
//    }

//    @KafkaListener(topics="tacocloud.orders.topic")
//    public void handle(Order order, Message<Order> message) {
//        MessageHeaders headers = message.getHeaders();
//        log.info("Received from partition {} with timestamp {}",
//                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID));
//                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP);
//        ui.displayOrder(order);
//    }
}

















