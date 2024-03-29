package com.igrass.igrass.dto;

import com.igrass.igrass.entity.Order;
import com.igrass.igrass.enums.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "userId")
public class UserDTO {

    private Long userId;
    private String username;
    private String password;
    private String email;
    private UserRole role;

    public UserDTO(com.igrass.igrass.entity.User user){
        BeanUtils.copyProperties(user, this);
    }

    public UserDTO() {
    }
}