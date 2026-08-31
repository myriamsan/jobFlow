package com.example.JobFlow.controller;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.controller.CompanyController;
import com.example.jobFlow.entity.Company;
import com.example.jobFlow.services.CompanyService;

import tools.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CompanyController.class)
class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CompanyService companyService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void devraitRetournerCompanyExistante() throws Exception {
        // Arrange
        Company company = new Company();
        company.setId(1L);
        company.setSector("Finance");
        company.setWebsite("www.gjghk.com");

        when(companyService.findById(1L)).thenReturn(company);

        // Act & Assert
        mockMvc.perform(get("/api/companies/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.website").value("www.gjghk.com"))
            .andExpect(jsonPath("$.sector").value("Finance"));
    }

    @Test
    void devraitRetourner404SiCompanyIntrouvable() throws Exception {
        // Arrange
        when(companyService.findById(99L))
            .thenThrow(new ResourceNotFoundException("Company introuvable avec l'id 99"));

        // Act & Assert
        mockMvc.perform(get("/api/companys/99"))
            .andExpect(status().isNotFound());
    }

    @Test
    void devraitCreerUneCompany() throws Exception {
        // Arrange
        Company newCompany = new Company();
        newCompany.setSector("Santé");
        newCompany.setWebsite("www.sdfghjnbv.com");

        when(companyService.saveOrUpdate(any(Company.class)))
            .thenReturn(newCompany);

        // Act & Assert
        mockMvc.perform(post("/api/companies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newCompany)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.website").value("www.sdfghjnbv.com"));
    }
}
