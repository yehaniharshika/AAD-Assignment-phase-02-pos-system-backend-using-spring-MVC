package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.impl;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.customStatusCodes.SelectedErrorStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao.CustomerDAO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao.OrderDAO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.OrderStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.OrderDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.CustomerEntity;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.OrderEntity;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.CustomerNotFoundException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.DataPersistException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.OrderNotFoundException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.OrderService;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CustomerDAO customerDAO;

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
        List<OrderEntity> orderEntities = orderDAO.findAll();
        //convert order entities to DTOs
        return orderMapping.asOrderDTOList(orderEntities);
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
        Optional<OrderEntity> findOrder = orderDAO.findById(orderId);

        if (!findOrder.isPresent()) {
            throw new OrderNotFoundException("Order not found");
        } else {
            OrderEntity orderEntity = findOrder.get();

            //find the customer entity using the customer ID
            Optional<CustomerEntity> customerEntity = customerDAO.findById(orderDTO.getCustomerId());

            if (!customerEntity.isPresent()) {
                throw new CustomerNotFoundException("Customer not found");
            }

            //update order process
            orderEntity.setOrderDate(orderDTO.getOrderDate());
            orderEntity.setCustomer(customerEntity.get());  // Set the CustomerEntity object
            orderEntity.setTotal(orderDTO.getTotal());
            orderEntity.setDiscount(orderDTO.getDiscount());
            orderEntity.setSubTotal(orderDTO.getSubTotal());
            orderEntity.setCash(orderDTO.getCash());
            orderEntity.setBalance(orderDTO.getBalance());

            //save the updated order back to the database
            orderDAO.save(orderEntity);
        }
    }


    @Override
    public void deleteOrder(String orderId) {
        Optional<OrderEntity> findOrderToDelete = orderDAO.findById(orderId);
        if (!findOrderToDelete.isPresent()){
            throw new OrderNotFoundException(orderId+" order not found");
        }else {
            orderDAO.deleteById(orderId);
        }
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
