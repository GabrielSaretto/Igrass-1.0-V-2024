package com.igrass.igrass.controllers;

import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.enums.OrderStatus;
import com.igrass.igrass.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody Long userId, @RequestBody Long serviceId) {
        orderService.createOrder(userId, serviceId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Your order has been created successfully");
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<OrderDTO>> getOrderByCustomer(@PathVariable Long customerId){
        List<OrderDTO> users = orderService.getOrderByCustomer(customerId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<OrderDTO>> getOrdersByService(@PathVariable Long serviceId){
        List<OrderDTO> users = orderService.getOrdersByService(serviceId);
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{status}")
    public ResponseEntity<List<OrderDTO>> getOrdersByStatus(@PathVariable OrderStatus status){
        List<OrderDTO> users = orderService.getOrdersByStatus(status);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateOrder(@RequestBody OrderDTO newOrderDTO){
        OrderDTO updateOrder = orderService.updateOrder(newOrderDTO);
        if (updateOrder != null) {
            return ResponseEntity.ok("Order has been updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/cancelOrder/{orderId}")
    public ResponseEntity<OrderDTO> cancelOrder(@RequestParam Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderDTO> deleteOrderById(@RequestParam Long orderId){
        orderService.deleteOrderById(orderId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteAllOrders")
    public ResponseEntity<OrderDTO> deleteAllOrders(){
        orderService.deleteAllOrders();
        return ResponseEntity.ok().build();
    }
}
