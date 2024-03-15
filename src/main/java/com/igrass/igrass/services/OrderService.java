package com.igrass.igrass.services;

import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OrderService {

    void createOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderByCustomer(UserDTO customer);

    List<OrderDTO> getOrdersByService();

    List<OrderDTO> getOrdersByStatus();

    OrderDTO updateOrder(UserDTO newUserDTO);

    void cancelOrder();

    void deleteOrder();

    void deleteAllOrders();
}
