package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.OrderStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    List<OrderDTO> getAllOrders();
    OrderStatus getOrder(String orderId);
    void updateOrder(String orderId,OrderDTO orderDTO);
    void deleteOrder(String orderId);

    //method to generate next order ID
    String generateNextOrderId();
}
