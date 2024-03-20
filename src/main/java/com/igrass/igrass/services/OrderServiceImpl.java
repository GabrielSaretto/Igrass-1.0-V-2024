package com.igrass.igrass.services;

import com.igrass.igrass.dao.OrderRepository;
import com.igrass.igrass.dao.UserRepository;
import com.igrass.igrass.dto.GrassCuttingJobDTO;
import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.entity.GrassCuttingJob;
import com.igrass.igrass.entity.Order;
import com.igrass.igrass.entity.User;
import com.igrass.igrass.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GrassCuttingJobService grassCuttingJobService;

    @Override
    public void createOrder(Long userId, Long serviceId) {
        // Check if the user associated with the order exists
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            // Check if the service associated with the order exists
            GrassCuttingJobDTO grassCuttingJob = grassCuttingJobService.getGrassCuttingJobById(serviceId);
            if (grassCuttingJob != null) {
                // Create a new Order entity based on the user and service and save it to the database
                Order order = new Order();
                order.setCustomer(optionalUser.get());
                order.setGrassCuttingJob(new GrassCuttingJob(grassCuttingJob));
                order.setOrderDate(LocalDateTime.now());
                order.setStatus(OrderStatus.PENDING);
                orderRepository.save(order);
            } else {
                throw new RuntimeException("Service with ID " + serviceId + " not found");
            }
        } else {
            throw new RuntimeException("User with ID " + userId + " not found");
        }
    }

    @Override
    public List<OrderDTO> getOrderByCustomer(Long customerId) {
        List<Order> orders = orderRepository.findByCustomer(userRepository.findById(customerId).orElse(null));
        return orders.stream()
                .map(OrderDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByService(Long serviceId) {
        GrassCuttingJobDTO grassCuttingJobDTO = grassCuttingJobService.getGrassCuttingJobById(serviceId);

        if (grassCuttingJobDTO != null) {
            List<Order> orders = orderRepository.findByGrassCuttingJob(new GrassCuttingJob(grassCuttingJobDTO));

            return orders.stream()
                    .map(OrderDTO::new)
                    .collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<OrderDTO> getOrdersByStatus(OrderStatus status) {
        List<Order> order = orderRepository.findByStatus(status);

        if(order != null) {
            return order.stream()
                    .map(OrderDTO::new)
                    .collect(Collectors.toList());
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public OrderDTO updateOrder(OrderDTO newOrderDTO) {
        Order order = new Order(newOrderDTO);
        return new OrderDTO(orderRepository.save(order));
    }

    @Override
    public void cancelOrder(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.setStatus(OrderStatus.CANCELLED);
            orderRepository.save(order);
        }else{
         throw new RuntimeException("Order not found with id: " + orderId);
        }
    }

    @Override
    public void deleteOrderById(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        if(optionalOrder.isPresent()){
            orderRepository.deleteById(orderId);
        }else{
            throw new RuntimeException("Order not found with id: " + orderId);
        }
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }
}
