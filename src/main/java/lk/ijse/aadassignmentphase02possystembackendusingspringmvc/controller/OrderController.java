package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.controller;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.OrderStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.OrderDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.DataPersistException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.OrderNotFoundException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/orders")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    static Logger logger = LoggerFactory.getLogger(OrderController.class);


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO){
        try {
            orderService.saveOrder(orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/generate-next-order-id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> generateNextOrderId(){
        try {
            String nextOrderId = orderService.generateNextOrderId();
            Map<String, String> orderResponse = new HashMap<>();
            orderResponse.put("orderId",nextOrderId);
            return new ResponseEntity<>(orderResponse,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderStatus getSelectedOrder(@PathVariable("orderId") String orderId){
        return orderService.getOrder(orderId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @PutMapping(value = "/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateOrder(@PathVariable("orderId") String orderId,@RequestBody OrderDTO updateOrderDTO){
        try {
            if (updateOrderDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            orderService.updateOrder(orderId,updateOrderDTO);
            return new ResponseEntity<>("order updated successfully",HttpStatus.OK);
        }catch (OrderNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{orderId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") String orderId){
        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (OrderNotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
