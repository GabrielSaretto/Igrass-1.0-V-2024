package com.igrass.igrass.services;

import com.igrass.igrass.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findById(Long theId);

    Users save(Users users);

    void deleteById(Long theId);
}
