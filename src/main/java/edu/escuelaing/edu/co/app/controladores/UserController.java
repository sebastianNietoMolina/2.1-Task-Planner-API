package edu.escuelaing.edu.co.app.controladores;

import edu.escuelaing.edu.co.app.excepciones.UserException;
import edu.escuelaing.edu.co.app.modelo.User;
import edu.escuelaing.edu.co.app.servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    @Qualifier("UserServiceImpl")
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(userService.getById(id), HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path =  "/create", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody User user){
        try {
            userService.create(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user){
        try {
            userService.update(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
            userService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
