package com.igrass.igrass.dto;

import com.igrass.igrass.enums.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@ToString
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