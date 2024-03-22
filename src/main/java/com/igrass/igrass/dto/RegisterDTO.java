package com.igrass.igrass.dto;

import com.igrass.igrass.enums.UserRole;

public record RegisterDTO(String username, String email, String password, UserRole role) {
}
