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
@Table(name = "customer")
public class CustomerEntity implements SuperEntity{
    @Id
    private String customerId;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;
}
