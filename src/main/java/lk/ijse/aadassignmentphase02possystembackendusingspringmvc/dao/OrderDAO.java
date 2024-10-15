package lk.ijse.aadassignmentphase02possystembackendusingspringmvc.dao;

import lk.ijse.aadassignmentphase02possystembackendusingspringmvc.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity,String> {
    @Query(value = "SELECT o.orderId FROM OrderEntity o ORDER BY o.orderId DESC LIMIT 1")
    String getLastOrderId();
}
