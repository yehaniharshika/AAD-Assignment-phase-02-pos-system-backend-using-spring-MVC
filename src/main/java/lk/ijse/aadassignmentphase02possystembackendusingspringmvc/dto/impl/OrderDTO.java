package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements OrderStatus {
    private String orderId;
    private String orderDate;
    private String customerId;
    private double total;
    private double discount;
    private double subTotal;
    private double cash;
    private double balance;
}
