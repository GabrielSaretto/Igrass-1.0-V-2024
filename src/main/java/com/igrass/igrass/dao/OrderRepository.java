package com.igrass.igrass.dao;

import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<OrderDTO> findByCustomer(UserDTO customer);
}
