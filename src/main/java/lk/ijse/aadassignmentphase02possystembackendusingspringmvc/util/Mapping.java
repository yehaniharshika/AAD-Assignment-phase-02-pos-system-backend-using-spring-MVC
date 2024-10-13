package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.util;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.CustomerDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.ItemDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.CustomerEntity;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.ItemEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //For Customer Mapping
    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return modelMapper.map(customerDTO,CustomerEntity.class);
    }

    public CustomerDTO toCustomerDTO(CustomerEntity customerEntity){
        return modelMapper.map(customerEntity,CustomerDTO.class);
    }

    public List<CustomerDTO> asCustomerDTOList(List<CustomerEntity> customerEntities){
        return modelMapper.map(customerEntities, List.class);
    }

    //For Item Mapping
    public ItemEntity toItemEntity(ItemDTO itemDTO){
        return modelMapper.map(itemDTO,ItemEntity.class);
    }

    public ItemDTO toItemDTO(ItemEntity itemEntity){
        return modelMapper.map(itemEntity,ItemDTO.class);
    }

    public List<ItemDTO> asItemDTOList(List<ItemEntity> itemEntities){
        return modelMapper.map(itemEntities, List.class);
    }

}
