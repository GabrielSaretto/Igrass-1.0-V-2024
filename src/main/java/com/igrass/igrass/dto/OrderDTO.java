package com.igrass.igrass.dto;

import com.igrass.igrass.entity.GrassCuttingJob;
import com.igrass.igrass.entity.Order;
import com.igrass.igrass.entity.User;
import com.igrass.igrass.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class OrderDTO {

    private Long orderId;
    private User customer;
    private GrassCuttingJob grassCuttingJob;
    private LocalDateTime orderDate;
    private OrderStatus status;

    public OrderDTO(com.igrass.igrass.entity.Order order){
        BeanUtils.copyProperties(order, this);
    }

    public OrderDTO(){
    }

}
