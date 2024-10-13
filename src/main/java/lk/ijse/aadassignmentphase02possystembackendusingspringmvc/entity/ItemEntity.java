package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item")
public class ItemEntity {
    @Id
    private String  itemCode;
    private String  itemName;
    private String  unitPrice;
    private String  qtyOnHand;
    @ManyToMany(mappedBy = "items")
    private List<OrderEntity> orders;
}
