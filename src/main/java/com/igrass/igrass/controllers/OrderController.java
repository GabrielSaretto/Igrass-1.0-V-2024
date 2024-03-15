package com.igrass.igrass.controllers;

import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.dto.UserDTO;
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

    @GetMapping("/{user}")
    public ResponseEntity<List<OrderDTO>> getOrderByCustomer(@RequestBody UserDTO user){
        List<OrderDTO> users = orderService.getOrderByCustomer(user);
        return ResponseEntity.ok(users);
    }

    @PutMapping("/create")
    public ResponseEntity<String> save(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sua ordem foi criada com sucesso");
    }
}
