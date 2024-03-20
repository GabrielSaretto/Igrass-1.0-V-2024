package com.igrass.igrass.dao;

import com.igrass.igrass.entity.GrassCuttingJob;
import com.igrass.igrass.entity.Order;
import com.igrass.igrass.entity.User;
import com.igrass.igrass.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(User customer);

    List<Order> findByGrassCuttingJob(GrassCuttingJob service);

    List<Order> findByStatus(OrderStatus status);
}
