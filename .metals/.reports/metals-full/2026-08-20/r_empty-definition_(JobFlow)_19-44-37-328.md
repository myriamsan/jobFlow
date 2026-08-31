error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/controller/UserController.java:com/example/JobFlow/entity/User#setPrenom#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/controller/UserController.java
empty definition using pc, found symbol in pc: com/example/JobFlow/entity/User#setPrenom#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 1438
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/controller/UserController.java
text:
```scala
package com.example.JobFlow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JobFlow.entity.User;
import com.example.JobFlow.services.UserService;


// Adresse pour le front
@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/users")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User userCreated = userService.saveOrUpdate(user);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User existingUser = userService.findById(id);

        existingUser.setLastName(userDetails.getLastName());
        existingUser.setFirstN@@ame(userDetails.getFirstName());

        User updatedUser = userService.saveOrUpdate(existingUser);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/JobFlow/entity/User#setPrenom#