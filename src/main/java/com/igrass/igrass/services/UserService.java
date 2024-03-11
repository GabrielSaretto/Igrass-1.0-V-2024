package com.igrass.igrass.services;


import com.igrass.igrass.dto.UserDTO;

import java.util.List;

public interface UserService {

    void createUser(UserDTO userDTO);

    UserDTO getUserById(Long userId);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO newUserDTO);

    void deleteById(Long theId);

    void deleteAllUsers();
}
