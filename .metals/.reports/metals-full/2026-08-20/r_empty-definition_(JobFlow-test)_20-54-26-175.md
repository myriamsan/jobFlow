error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/ApplicationControllerTest.java:com/example/jobFlow/entity/enums/StatutApplication#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/ApplicationControllerTest.java
empty definition using pc, found symbol in pc: com/example/jobFlow/entity/enums/StatutApplication#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 398
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/ApplicationControllerTest.java
text:
```scala
package com.example.JobFlow.TestController;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.jobFlow.exceptions.ApplicationNotFoundException;
import com.example.jobFlow.controller.ApplicationController;
import com.example.jobFlow.entity.Application;
import com.example.jobFlow.entity.enums.@@Application;
import com.example.jobFlow.services.ApplicationService;

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
    private ApplicationService applicationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void devraitRetournerApplicationExistante() throws Exception {
        // Arrange
        Application application = new Application();
        application.setId(1L);
        application.setPosteIntitule("Développeur Java");
        application.setStatut(StatutApplication.ENVOYEE);

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
        Application newApplication = new Application();
        newApplication.setPosteIntitule("Développeur Angular");
        newApplication.setStatut(StatutApplication.ENVOYEE);

        when(applicationService.saveOrUpdate(any(Application.class)))
            .thenReturn(newApplication);

        // Act & Assert
        mockMvc.perform(post("/api/applications")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newApplication)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.posteIntitule").value("Développeur Angular"));
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/jobFlow/entity/enums/StatutApplication#