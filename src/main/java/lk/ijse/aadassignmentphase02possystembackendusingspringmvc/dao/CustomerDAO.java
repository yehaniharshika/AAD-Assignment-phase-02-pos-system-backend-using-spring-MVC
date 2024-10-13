package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
}
