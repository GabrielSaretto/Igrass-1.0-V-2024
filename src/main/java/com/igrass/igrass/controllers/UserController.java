package com.igrass.igrass.controllers;

import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserDTO theUserDTO){
        userService.createUser(theUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário criado com sucesso");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody UserDTO theUserDTO){
        UserDTO updatedUser = userService.updateUser(theUserDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok("Usuário atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("Usuário excluído com sucesso");
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll(){
        userService.deleteAllUsers();
        return ResponseEntity.ok("Todos os usuários foram excluídos com sucesso");
    }

}
