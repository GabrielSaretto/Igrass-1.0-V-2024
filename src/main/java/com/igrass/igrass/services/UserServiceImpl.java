package com.igrass.igrass.services;

import com.igrass.igrass.dao.UserRepository;
import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return new UserDTO(userRepository.findById(userId).get());
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserDTO::new).toList();
    }

    @Override
    public UserDTO updateUser(UserDTO newUser) {
        User user = new User(newUser);
        return new UserDTO(userRepository.save(user));
    }

    @Override
    public void deleteById(Long theId) {
        User user = userRepository.findById(theId).get();
        userRepository.delete(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

}
