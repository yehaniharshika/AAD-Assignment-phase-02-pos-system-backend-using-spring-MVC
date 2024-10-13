package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.impl;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao.CustomerDAO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.CustomerStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.CustomerDTO;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.CustomerEntity;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.exception.DataPersistException;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service.CustomerService;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
        return null;
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        return null;
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String customerId) {

    }
}
