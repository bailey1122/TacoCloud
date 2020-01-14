//package tacos.messagingjms;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.jms.support.converter.MessageConverter;
//
//import org.springframework.stereotype.Component;
//import tacos.Order;
//
//import javax.jms.Message;
//
//@Component()
//public class JmsOrderReceiver implements OrderReceiver {
//
//    JmsTemplate jms;
////    private MessageConverter converter;
//
//    @Autowired
//    public JmsOrderReceiver(JmsTemplate jms) {
////    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter) {
//        this.jms = jms;
////        this.converter = converter;
//    }
//
//    public Order receiveOrder() {
//        return (Order) jms.receiveAndConvert("tacocloud.order.queue");
////        Message message = jms.receive("tacocloud.order.queue");
////        return (Order) converter.fromMessage(message);
//    }
//}
