package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private String  itemCode;
    private String  itemName;
    private String  unitPrice;
    private String  qtyOnHand;
}
