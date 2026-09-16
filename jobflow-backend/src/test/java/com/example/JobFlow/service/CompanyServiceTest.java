package com.example.JobFlow.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.entity.Company;
import com.example.jobFlow.repository.CompanyRepository;
import com.example.jobFlow.services.CompanyService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

	@Mock 
    private CompanyRepository companyRepository;

    @InjectMocks
    private CompanyService  companyService; 


    @Test

    void ShouldCreateCompany () {

        //  Arrange 
        Company company = new Company();
        company.setSector("COMMERCE");   
        company.setWebsite("www.sophgyvh.com");;

        when(companyRepository.save(any(Company.class)))
            .thenReturn(company);
 
        // Act
        Company res = companyService.saveOrUpdate(company);
        
        // Assert
        assertNotNull(res);
        assertEquals("www.sophgyvh.com", res.getWebsite());
        verify(companyRepository, times(1)).save(company);
    }
    
    void ShouldShowExceptionCompanyDontFind () {

       // Arrange
        when(companyRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            companyService.findById(99L);
        });   
    }

    void ShouldDeleteCompany () {
        // Arrange
        Long id = 3L;
        when(companyRepository.existsById(id)).thenReturn(true);
 
        // Act
        companyService.deleteById(id);

        // Assert
        verify(companyRepository, times(1)).deleteById(id);
    }

}

