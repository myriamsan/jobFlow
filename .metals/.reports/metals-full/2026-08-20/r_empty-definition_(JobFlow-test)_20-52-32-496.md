error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestService/ApplicationServiceTest.java:com/example/jobFlow/entity/Application#setStatut().
file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestService/ApplicationServiceTest.java
empty definition using pc, found symbol in pc: com/example/jobFlow/entity/Application#setStatut().
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 1144
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/test/java/com/example/JobFlow/TestService/ApplicationServiceTest.java
text:
```scala
package com.example.JobFlow.TestService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.jobFlow.exceptions.ApplicationNotFoundException;
import com.example.jobFlow.entity.Application;
import com.example.jobFlow.entity.enums.ApplicationStatus;
import com.example.jobFlow.repository.ApplicationRepository;
import com.example.jobFlow.services.ApplicationService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {

	@Mock 
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService  applicationService; 


    @Test

    void ShouldCreateApplication () {

        //  Arrange 
        Application application = new Application();
        application.setPosteIntitule("DEV FULL STACK");
        application.setAppli@@cationStatust(ApplicationStatus.OFFRE);

        when(applicationRepository.save(any(Application.class)))
            .thenReturn(application);
 
        // Act
        Application res = applicationService.saveOrUpdate(application);
        // Assert
        assertNotNull(res);
        assertEquals("DEV FULL STACK", res.getPosteIntitule());
        verify(applicationRepository, times(1)).save(application);
    }
    
    void ShouldShowExceptionApplicationDontFind () {

       // Arrange
        when(applicationRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ApplicationNotFoundException.class, () -> {
            applicationService.findById(99L);
        });   
    }

    void ShouldDeleteApplication () {
        // Arrange
        Long id = 3L;
        when(applicationRepository.existsById(id)).thenReturn(true);
 
        // Act
        applicationService.deleteById(id);

        // Assert
        verify(applicationRepository, times(1)).deleteById(id);
    }

}


```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/jobFlow/entity/Application#setStatut().