package com.example.JobFlow.controller;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.controller.UserController;
import com.example.jobFlow.entity.User;
import com.example.jobFlow.services.UserService;

import tools.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

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
        user.setEmail("myrmregs@tfjyjf.com");
        user.setPassword("gdfhfghfgjghk");

        when(userService.findById(1L)).thenReturn(user);

        // Act & Assert
        mockMvc.perform(get("/api/users/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.email").value("myrmregs@tfjyjf.com"))
            .andExpect(jsonPath("$.password").doesNotExist());
    }

    @Test
    void devraitRetourner404SiUserIntrouvable() throws Exception {
        // Arrange
        when(userService.findById(99L))
            .thenThrow(new ResourceNotFoundException("User introuvable avec l'id 99"));

        // Act & Assert
        mockMvc.perform(get("/api/users/99"))
            .andExpect(status().isNotFound());
    }

    @Test
    void devraitCreerUneUser() throws Exception {
        // Arrange
        User newUser = new User();
        newUser.setEmail("mdxcgvhbj@tfjyjf.com");
        newUser.setPassword("sdfghjnbv");

        when(userService.saveOrUpdate(any(User.class)))
            .thenReturn(newUser);

        // Act & Assert
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.email").value("mdxcgvhbj@tfjyjf.com"));
    }
}
