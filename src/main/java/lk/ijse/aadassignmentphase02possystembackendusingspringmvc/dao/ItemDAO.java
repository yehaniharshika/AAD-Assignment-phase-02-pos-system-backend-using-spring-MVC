package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<ItemEntity,String> {
}
