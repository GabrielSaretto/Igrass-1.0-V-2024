package com.igrass.igrass.controllers;

import com.igrass.igrass.dto.OrderDTO;
import com.igrass.igrass.dto.UserDTO;
import com.igrass.igrass.services.OrderService;
import com.igrass.igrass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    @GetMapping("home")
    public String home(){
        return "home";
    }

    @GetMapping("/userList")
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

    @GetMapping("/userById{id}")
    public String getUserById(@PathVariable Long id, Model model){
        UserDTO userDTO = userService.getUserById(id);
        List<OrderDTO> orderDTOList = orderService.getOrderByCustomer(id);

        model.addAttribute("userDTO", userDTO);
        model.addAttribute("orderDTOList", orderDTOList);

        return "users/user-details";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("userDTO") UserDTO userDTO){
        userService.createUser(userDTO);
        return "redirect:/user-list";
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> update(@RequestBody UserDTO theUserDTO){
        UserDTO updatedUser = userService.updateUser(theUserDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok("Usuário atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        userService.deleteById(id);
        return ResponseEntity.ok("Usuário excluído com sucesso");
    }

    @DeleteMapping("/deleteAllUser")
    public ResponseEntity<String> deleteAll(){
        userService.deleteAllUsers();
        return ResponseEntity.ok("Todos os usuários foram excluídos com sucesso");
    }

}
