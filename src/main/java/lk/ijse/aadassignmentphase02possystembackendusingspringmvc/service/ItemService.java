package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.ItemStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    List<ItemDTO> getAllItems();
    ItemStatus getItem(String itemCode);
    void updateItem(String itemCode,ItemDTO itemDTO);
    void deleteItem(String itemCode);


}
