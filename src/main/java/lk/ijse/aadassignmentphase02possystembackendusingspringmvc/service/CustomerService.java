package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.service;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.CustomerStatus;
import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> getAllCustomers();

    CustomerStatus getCustomer(String customerId);

    void updateCustomer(String customerId, CustomerDTO customerDTO);

    void deleteCustomer(String customerId);

    //method to generate next customer ID
    String generateNextCustomerId();
}