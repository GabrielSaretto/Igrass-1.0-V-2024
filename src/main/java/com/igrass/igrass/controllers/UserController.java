package com.igrass.igrass.controllers;

import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getAllUsers(Model model){
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("userDTO", users);
        return "users/user-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data
        UserDTO theUserDTO = new UserDTO();

        theModel.addAttribute("userDTO", theUserDTO);

        return "users/user-form";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model){
        UserDTO user = userService.getUserById(id);
        if (user != null) {
            model.addAttribute("userDTO", user);
            return "users/user-details";
        } else {
            return "redirect:/user/list";
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
