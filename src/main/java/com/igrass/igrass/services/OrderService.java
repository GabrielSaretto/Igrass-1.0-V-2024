package com.igrass.igrass.services;

import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.entity.Order;
import com.igrass.igrass.entity.User;
import com.igrass.igrass.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    void createOrder(Long userId, Long serviceId);

    List<OrderDTO> getOrderByCustomer(Long customerId);

    List<OrderDTO> getOrdersByService(Long serviceId);

    List<OrderDTO> getOrdersByStatus(OrderStatus status);

    OrderDTO updateOrder(OrderDTO newOrderDTO);

    void cancelOrder(Long orderId);

    void deleteOrderById(Long orderId);

    void deleteAllOrders();
}
