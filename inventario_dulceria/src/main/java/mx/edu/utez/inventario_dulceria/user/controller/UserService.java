package mx.edu.utez.inventario_dulceria.user.controller;

import mx.edu.utez.inventario_dulceria.user.model.User;
import mx.edu.utez.inventario_dulceria.user.model.UserRepository;
import mx.edu.utez.inventario_dulceria.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("OK", false, userRepository.findAll()),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByUsernameAndPassword(String username, String password){
        if (userRepository.existsByUsername(username)) {
            if (userRepository.existsByUsernameAndPassword(username, password)) {
                return new ResponseEntity<>(new Message("OK", false, userRepository.findByUsername(username)),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(new Message("El usuario o contraseña son incorrectos", true, null),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Credenciales no registradas", true, null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(User user){
        Optional<User> userExists = userRepository.findByUsername(user.getUsername());
        if (userExists.isPresent()){
            return new ResponseEntity<>(new Message("Ese nombre de usuario ya se encuentra registrado", true, null),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("Registro exitoso", false, userRepository.saveAndFlush(user)),
                HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(User user){
        if (userRepository.existsByUsername(user.getUsername())){
            return new ResponseEntity<>(new Message("Actualizacion exitoso", false, userRepository.saveAndFlush(user)),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("Usuario inexistente", true, null),
                HttpStatus.BAD_REQUEST);
    }


}
