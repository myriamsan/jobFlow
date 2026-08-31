error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/UserControllerTest.java:_empty_/ApplicationService#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/UserControllerTest.java
empty definition using pc, found symbol in pc: _empty_/ApplicationService#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 1202
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/UserControllerTest.java
text:
```scala
package com.example.JobFlow.TestController;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.JobFlow.Controller.ApplicationController;
import com.example.JobFlow.Entity.Application;
import com.example.JobFlow.Entity.Enums.StatutCandidature;
import com.example.JobFlow.Exceptions.ApplicationNotFoundException;
import com.example.JobFlow.Services.ApplicationService;

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

@WebMvcTest(ApplicationController.class)
class ApplicationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private @@ApplicationService applicationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void devraitRetournerApplicationExistante() throws Exception {
        // Arrange
        Application application = new Application();
        application.setId(1L);
        application.setPosteIntitule("Développeur Java");
        application.setStatut(StatutCandidature.ENVOYEE);

        when(applicationService.findById(1L)).thenReturn(application);

        // Act & Assert
        mockMvc.perform(get("/api/applications/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.posteIntitule").value("Développeur Java"))
            .andExpect(jsonPath("$.statut").value("ENVOYEE"));
    }

    @Test
    void devraitRetourner404SiApplicationIntrouvable() throws Exception {
        // Arrange
        when(applicationService.findById(99L))
            .thenThrow(new ApplicationNotFoundException("Application introuvable avec l'id 99"));

        // Act & Assert
        mockMvc.perform(get("/api/applications/99"))
            .andExpect(status().isNotFound());
    }

    @Test
    void devraitCreerUneApplication() throws Exception {
        // Arrange
        Application nouvelleApplication = new Application();
        nouvelleApplication.setPosteIntitule("Développeur Angular");
        nouvelleApplication.setStatut(StatutCandidature.ENVOYEE);

        when(applicationService.saveOrUpdate(any(Application.class)))
            .thenReturn(nouvelleApplication);

        // Act & Assert
        mockMvc.perform(post("/api/applications")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(nouvelleApplication)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.posteIntitule").value("Développeur Angular"));
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/ApplicationService#