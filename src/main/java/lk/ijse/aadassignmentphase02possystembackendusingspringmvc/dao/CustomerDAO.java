package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
    @Query(value = "SELECT c.customerId FROM customer c ORDER BY c.customerId DESC LIMIT 1",nativeQuery = true)
    String getLastCustomerId();
}
