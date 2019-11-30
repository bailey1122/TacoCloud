package tacos.messagingkafka;

import tacos.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);
}
