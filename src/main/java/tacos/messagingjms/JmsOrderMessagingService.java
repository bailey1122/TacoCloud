//package tacos.messagingjms;
//
//import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.core.MessageCreator;
//import org.springframework.jms.core.MessagePostProcessor;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import tacos.Order;
//import tacos.messaging.OrderMessagingService;
//
//import javax.jms.Destination;
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.Session;
//
//@Service
//public class JmsOrderMessagingService implements OrderMessagingService {
//
//    private JmsTemplate jms;
////    private Destination orderQueue;
//
//    @Autowired
////    public JmsOrderMessagingService(JmsTemplate jms, Destination orderQueue) {
//    public JmsOrderMessagingService(JmsTemplate jms) {
//        this.jms = jms;
////        this.orderQueue = orderQueue;
//    }
//
//    @GetMapping("/convertAndSend/order")
//    public void sendOrder(Order order) {
////        Order order = new buildOrder();
//        jms.convertAndSend("tacocloud.order.queue", order,
//                this::addOrderSource);
//    }
//
//    private Message addOrderSource(Message message) throws JMSException {
//        message.setStringProperty("X_ORDER_SOURCE", "WEB");
//        return message;
//    }
//
////    @Override
////    public void sendOrder(Order order) {
////        jms.convertAndSend("tacocloud.order.queue", order,
////                message -> {
////                    message.setStringProperty("X_ORDER_SOURCE", "WEB");
////                    return message;
////                });
//
////        jms.convertAndSend("tacocloud.order.queue", order, new MessagePostProcessor() {
////            @Override
////            public Message postProcessMessage(Message message) throws JMSException {
////                message.setStringProperty("X_ORDER_SOURCE", "WEB");
////                return message;
////            }
////        });
//
////        jms.send("tacocloud.order.queue", session -> session.createObjectMessage(order));
//
////        jms.send(orderQueue, session -> session.createObjectMessage(order));
//
//
////        jms.send(new MessageCreator() {
////            @Override
////            public Message createMessage(Session session) throws JMSException {
////                return session.createObjectMessage(order);
////            }
////        });
////    }
//
////    @Bean
////    public Destination orderQueue() {
////        return new ActiveMQQueue("tacocloud.order.queue");
////    }
//
//}
