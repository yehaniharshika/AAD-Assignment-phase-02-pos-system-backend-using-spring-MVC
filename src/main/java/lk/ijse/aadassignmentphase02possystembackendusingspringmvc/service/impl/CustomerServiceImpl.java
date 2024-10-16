package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.impl;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.customStatusCodes.SelectedErrorStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao.CustomerDAO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.CustomerStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.CustomerDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.CustomerEntity;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.CustomerNotFoundException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.DataPersistException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.CustomerService;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private Mapping customerMapping;
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity savedCustomer = customerDAO.save(customerMapping.toCustomerEntity(customerDTO));
        if (savedCustomer == null){
            throw new DataPersistException("Customer not saved");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customerEntities = customerDAO.findAll();
        //convert entities to DTOs
        return customerMapping.asCustomerDTOList(customerEntities);
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        if (customerDAO.existsById(customerId)){
            CustomerEntity selectedCustomer = customerDAO.getReferenceById(customerId);
            return customerMapping.toCustomerDTO(selectedCustomer);
        }else {
            return new SelectedErrorStatus(2,"selected customer not found");
        }

    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> findCustomer = customerDAO.findById(customerId);
        if (!findCustomer.isPresent()){
            throw new CustomerNotFoundException("customer not found");
        }else {
            findCustomer.get().setName(customerDTO.getName());
            findCustomer.get().setAddress(customerDTO.getAddress());
            findCustomer.get().setContactNumber(customerDTO.getContactNumber());
            findCustomer.get().setEmail(customerDTO.getEmail());
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> findCustomerToDelete = customerDAO.findById(customerId);
        if (!findCustomerToDelete.isPresent()){
            throw new CustomerNotFoundException(customerId+" customer not found");
        }else {
            customerDAO.deleteById(customerId);
        }

    }

    @Override
    public String generateNextCustomerId() {
        try {
            String lastCustomerId = customerDAO.getLastCustomerId();

            if (lastCustomerId != null) {
                int nextId = Integer.parseInt(lastCustomerId.split("-")[1]) + 1;
                return String.format("C00-%03d", nextId);
            } else {
                return "C00-001";
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            throw new RuntimeException("Failed to generate the next customer ID", e);
        }
    }
}
