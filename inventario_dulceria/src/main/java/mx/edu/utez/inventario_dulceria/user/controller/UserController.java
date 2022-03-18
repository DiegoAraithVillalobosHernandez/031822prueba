package mx.edu.utez.inventario_dulceria.user.controller;

import mx.edu.utez.inventario_dulceria.user.model.User;
import mx.edu.utez.inventario_dulceria.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = {"*"})
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<Message> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{username}/{password}")
    public ResponseEntity<Message> findByUsername(@PathVariable("username") String username,
                                                  @PathVariable("password") String password){
        return userService.findByUsernameAndPassword(username, password);
    }

    @PostMapping("/")
    public ResponseEntity<Message> save(@RequestBody UserDTO userDTO){
        return userService.save(new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getPhone(),
                userDTO.getRol()
        ));
    }

    @PutMapping("/")
    public ResponseEntity<Message> update(@RequestBody UserDTO userDTO){
        return userService.update(new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getName(),
                userDTO.getSurname(),
                userDTO.getPhone(),
                userDTO.getRol()
        ));
    }
}
