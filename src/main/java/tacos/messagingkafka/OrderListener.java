package tacos.messagingkafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tacos.Order;

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

    @KafkaListener(topics="tacocloud", groupId = "group_json")
    public void handle(Order order) {


        ui.displayOrder(order);
    }

//    @KafkaListener(topics="tacocloud.orders.topic")
//    public void handle(Order order, Message<Order> message) {
//        MessageHeaders headers = message.getHeaders();
//        log.info("Received from partition {} with timestamp {}",
//                headers.get(KafkaHeaders.RECEIVED_PARTITION_ID));
//                headers.get(KafkaHeaders.RECEIVED_TIMESTAMP);
//        ui.displayOrder(order);
//    }
}

















