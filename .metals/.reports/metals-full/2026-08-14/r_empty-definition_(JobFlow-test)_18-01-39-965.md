error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/UserControllerTest.java:_empty_/nouvelleUser#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/UserControllerTest.java
empty definition using pc, found symbol in pc: _empty_/nouvelleUser#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 2316
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/UserControllerTest.java
text:
```scala
package com.example.JobFlow.TestController;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.JobFlow.Controller.UserController;
import com.example.JobFlow.Entity.User;
import com.example.JobFlow.Entity.Enums.StatutCandidature;
import com.example.JobFlow.Exceptions.UserNotFoundException;
import com.example.JobFlow.Services.UserService;

import tools.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void devraitRetournerUserExistante() throws Exception {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setPosteIntitule("Développeur Java");
        user.setStatut(StatutCandidature.ENVOYEE);

        when(userService.findById(1L)).thenReturn(user);

        // Act & Assert
        mockMvc.perform(get("/api/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.posteIntitule").value("Développeur Java"))
            .andExpect(jsonPath("$.statut").value("ENVOYEE"));
    }

    @Test
    void devraitRetourner404SiUserIntrouvable() throws Exception {
        // Arrange
        when(userService.findById(99L))
            .thenThrow(new UserNotFoundException("User introuvable avec l'id 99"));

        // Act & Assert
        mockMvc.perform(get("/api/users/99"))
            .andExpect(status().isNotFound());
    }

    @Test
    void devraitCreerUneUser() throws Exception {
        // Arrange
        User newUser = new User();
        nouvelle@@User.("Développeur Angular");
        nouvelleUser.setStatut(StatutCandidature.ENVOYEE);

        when(userService.saveOrUpdate(any(User.class)))
            .thenReturn(nouvelleUser);

        // Act & Assert
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nouvelleUser)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.posteIntitule").value("Développeur Angular"));
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/nouvelleUser#