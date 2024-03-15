package com.igrass.igrass.services;

import com.igrass.igrass.dao.OrderRepository;
import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.entity.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO);
        orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDTO> getOrderByCustomer(UserDTO customer) {
        return orderRepository.findByCustomer(customer);
    }

    @Override
    public List<OrderDTO> getOrdersByService() {
        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByStatus() {
        return null;
    }

    @Override
    public OrderDTO updateOrder(UserDTO newUserDTO) {
        return null;
    }

    @Override
    public void cancelOrder() {

    }

    @Override
    public void deleteOrder() {

    }

    @Override
    public void deleteAllOrders() {

    }
}
