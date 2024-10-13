package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity implements SuperEntity{
    @Id
    private String  itemCode;
    private String  itemName;
    private String  unitPrice;
    private String  qtyOnHand;
    @ManyToMany(mappedBy = "items",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<OrderEntity> orders;
}
