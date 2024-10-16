package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "orders")
public class OrderEntity implements SuperEntity{
    @Id
    private String orderId;
    private String orderDate;
    private double total;
    private double discount;
    private double subTotal;
    private double cash;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private CustomerEntity customer;

    //Many-to-Many relationship with ItemEntity
    @ManyToMany(fetch =  FetchType.EAGER)
    @JoinTable(
            name = "orderDetails",
            joinColumns = @JoinColumn(name = "orderId"),
            inverseJoinColumns = @JoinColumn(name = "itemCode")
    )
    private List<ItemEntity> items;
}
