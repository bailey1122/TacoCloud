package tacos.data;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.Order;
import tacos.User;

import java.util.Date;
import java.util.List;

public interface OrderRepository
            extends CrudRepository<Order, Long> { // spring data jpa

    List<Order> findByUserOrderByPlacedAtDesc(
            User user, Pageable pageable);

//    Order save(Order order);

//    List<Order> findByDeliveryZip(String deliveryZip);

//    List<Order> readOrdersByDeliveryZipAAndPlacedAtBetween(String deliveryZip,
//                                                           Date startDate, Date endDate);

//    @Query("Order o where o.deliveryCity='Seattle'")
//    List<Order> readOrdersDeliveredInSeattle();
}
