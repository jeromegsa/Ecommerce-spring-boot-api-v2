package gsa.webland.ecommercex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import gsa.webland.ecommercex.model.User;
import gsa.webland.ecommercex.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController()
@RequestMapping("/api/users")
@CrossOrigin(origins="*")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User userToUpdate=userService.updateUser(id, user);
        return ResponseEntity.ok(userToUpdate);

    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
}
