package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.controller;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.ItemStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.ItemDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.DataPersistException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.ItemNotFoundException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/items")
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
    static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveItem(@RequestBody ItemDTO itemDTO){
        logger.debug("call PostMapping");
        try {
            itemService.saveItem(itemDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems(){
        logger.debug("call GetMapping to get all items");
        return itemService.getAllItems();
    }

    @GetMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemStatus getSelectedItem(@PathVariable("itemCode") String itemCode){
        logger.debug("call GetMapping to select the item");
        return itemService.getItem(itemCode);
    }

    @PutMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateItem(@PathVariable("itemCode") String itemCode,@RequestBody ItemDTO updateItemDTO){
        try {
            if (updateItemDTO == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            itemService.updateItem(itemCode,updateItemDTO);
            return new ResponseEntity<>("Item update successfully",HttpStatus.OK);
        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{itemCode}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteItem(@PathVariable("itemCode") String itemCode){
        try {
            itemService.deleteItem(itemCode);
            return new ResponseEntity<>("deleted successfully",HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
