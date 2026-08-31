error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/CompanyControllerTest.java:_empty_/Company#setSecteur#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/CompanyControllerTest.java
empty definition using pc, found symbol in pc: _empty_/Company#setSecteur#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 1401
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestController/CompanyControllerTest.java
text:
```scala
package com.example.JobFlow.TestController;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.JobFlow.Controller.CompanyController;
import com.example.JobFlow.Entity.Company;
import com.example.JobFlow.Exceptions.CompanyNotFoundException;
import com.example.JobFlow.Services.CompanyService;

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
        company.setSecteur@@("Finance");
        company.setWebsite("www.gjghk.com");

        when(companyService.findById(1L)).thenReturn(company);

        // Act & Assert
        mockMvc.perform(get("/api/companies/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.website").value("Développeur Java"))
            .andExpect(jsonPath("$.statut").value("ENVOYEE"));
    }

    @Test
    void devraitRetourner404SiCompanyIntrouvable() throws Exception {
        // Arrange
        when(companyService.findById(99L))
            .thenThrow(new CompanyNotFoundException("Company introuvable avec l'id 99"));

        // Act & Assert
        mockMvc.perform(get("/api/companys/99"))
            .andExpect(status().isNotFound());
    }

    @Test
    void devraitCreerUneCompany() throws Exception {
        // Arrange
        Company newCompany = new Company();
        newCompany.setSecteur("Santé");
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

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Company#setSecteur#