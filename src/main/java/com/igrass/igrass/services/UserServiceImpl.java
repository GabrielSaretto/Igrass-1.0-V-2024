package com.igrass.igrass.services;

import com.igrass.igrass.dao.UserRepository;
import com.igrass.igrass.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(Long theId) {
        Optional<Users> result = userRepository.findById(theId);

        Users theUsers = null;

        if (result.isPresent()){
            theUsers = result.get();
        }
        else {
            throw new RuntimeException("Nao foi encontrado o id: " + theId);
        }

        return theUsers;
    }

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public void deleteById(Long theId) {
        userRepository.deleteById(theId);
    }
}
