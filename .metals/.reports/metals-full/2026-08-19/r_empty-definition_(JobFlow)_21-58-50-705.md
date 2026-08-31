error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/ApplicationController.java:_empty_/UserService#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/ApplicationController.java
empty definition using pc, found symbol in pc: _empty_/UserService#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 545
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/ApplicationController.java
text:
```scala
package com.example.JobFlow.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JobFlow.Entity.Application;
import com.example.JobFlow.Repository.ApplicationRepository;


// Adresse pour le front
@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/applications")

public class ApplicationController {

private final @@UserService userService;

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

        existingUser.setNom(userDetails.getNom());
        existingUser.setPrenom(userDetails.getPrenom());

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

empty definition using pc, found symbol in pc: _empty_/UserService#