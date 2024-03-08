package com.igrass.igrass.controllers;

import com.igrass.igrass.dao.UserRepository;
import com.igrass.igrass.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/list")
    public List<Users> listUsers(){
        List<Users> result = repository.findAll();
        return result;
    }

    @PostMapping("/save")
    public void save(@RequestBody Users theUsers){
        repository.save(theUsers);
    }

    @PutMapping("/update")
    public void update(@RequestBody Users theUsers){
        repository.save(theUsers);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long theId){
        repository.deleteById(theId);
    }

    @DeleteMapping("/all")
    public void delete(){
        repository.deleteAll();
    }
}
