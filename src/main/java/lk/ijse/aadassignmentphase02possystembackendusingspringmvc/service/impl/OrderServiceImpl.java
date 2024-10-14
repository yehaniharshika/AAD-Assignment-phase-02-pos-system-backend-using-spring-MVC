package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.impl;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.customStatusCodes.SelectedErrorStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao.OrderDAO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.OrderStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.OrderDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.OrderEntity;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.DataPersistException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.OrderService;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private Mapping orderMapping;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity savedOrder = orderDAO.save(orderMapping.toOrderEntity(orderDTO));
        if (savedOrder == null){
            throw new DataPersistException("Order not saved");
        }

    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public OrderStatus getOrder(String orderId) {
        if (orderDAO.existsById(orderId)){
            OrderEntity selectedOrder = orderDAO.getReferenceById(orderId);
            return orderMapping.toOrderDTO(selectedOrder); // No need for casting
        } else {
            return new SelectedErrorStatus(2, "Selected order not found");
        }
    }


    @Override
    public void updateOrder(String orderId, OrderDTO orderDTO) {

    }

    @Override
    public void deleteOrder(String orderId) {

    }

    @Override
    public String generateNextOrderId() {
        String lastOrderId = orderDAO.getLastOrderId();

        if (lastOrderId != null){
            int nextOId = Integer.parseInt(lastOrderId.split("-")[1])+1;
            return String.format("O00-%03d", nextOId);
        }else {
            return "O00-001";
        }
    }
}
