package com.example.JobFlow.controller;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.controller.ApplicationController;
import com.example.jobFlow.entity.Application;
import com.example.jobFlow.entity.enums.ApplicationStatus;
import com.example.jobFlow.services.ApplicationService;

import tools.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

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
                application.setJobTitle("Développeur Java");
                application.setStatus(ApplicationStatus.SENT);

                when(applicationService.findById(1L)).thenReturn(application);

                // Act & Assert
                mockMvc.perform(get("/api/applications/1"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.jobTitle").value("Développeur Java"))
                                .andExpect(jsonPath("$.status").value("SENT"));

        }

        @Test
        void devraitRetourner404SiApplicationIntrouvable() throws Exception {
                // Arrange
                when(applicationService.findById(99L))
                                .thenThrow(new ResourceNotFoundException("Application introuvable avec l'id 99"));

                // Act & Assert
                mockMvc.perform(get("/api/applications/99"))
                                .andExpect(status().isNotFound());
        }

        @Test
        void devraitCreerUneApplication() throws Exception {
                // Arrange
                Application newApplication = new Application();
                newApplication.setJobTitle("Développeur Angular");
                newApplication.setStatus(ApplicationStatus.SENT);

                when(applicationService.saveOrUpdate(any(Application.class)))
                                .thenReturn(newApplication);

                // Act & Assert
                mockMvc.perform(post("/api/applications")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(newApplication)))
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.jobTitle").value("Développeur Angular"));
        }
}
