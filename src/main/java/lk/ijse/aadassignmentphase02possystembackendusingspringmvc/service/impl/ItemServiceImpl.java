package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.impl;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.customStatusCodes.SelectedErrorStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao.ItemDAO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.ItemStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.ItemDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.ItemEntity;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.DataPersistException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.ItemService;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private Mapping itemMapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity savedItem = itemDAO.save(itemMapping.toItemEntity(itemDTO));
        if (savedItem == null){
            throw new DataPersistException("item not saved");
        }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> itemEntities = itemDAO.findAll();
        return itemMapping.asItemDTOList(itemEntities);
    }

    @Override
    public ItemStatus getItem(String itemCode) {
        if (itemDAO.existsById(itemCode)){
            ItemEntity selectedItem = itemDAO.getReferenceById(itemCode);
            return itemMapping.toItemDTO(selectedItem);
        }else {
            return new SelectedErrorStatus(2,"select Item not found");
        }
    }

    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {

    }

    @Override
    public void deleteItem(String itemCode) {

    }
}
