package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemDAO extends JpaRepository<ItemEntity,String> {
    @Query(value = "SELECT i.itemCode FROM ItemEntity i ORDER BY i.itemCode DESC LIMIT 1")
    String getLastItemCode();

}
