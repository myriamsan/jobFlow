error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Services/ApplicationService.java:_empty_/CandidatureNotFoundException#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Services/ApplicationService.java
empty definition using pc, found symbol in pc: _empty_/CandidatureNotFoundException#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 1031
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Services/ApplicationService.java
text:
```scala
package com.example.JobFlow.Services;

import org.springframework.stereotype.Service;

import com.example.JobFlow.Exceptions.ApplicationNotFoundException;
import com.example.JobFlow.Entity.Application;
import com.example.JobFlow.Repository.ApplicationRepository;


import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository ApplicationRepository = null;

    public List<Application> findAll() {
        return ApplicationRepository.findAll();
    }

    public Application findById(Long id) {
        return ApplicationRepository.findById(id)
            .orElseThrow(() -> new ApplicationNotFoundException(
            "Candidature introuvable avec l'id " + id
        ));
    }

    public Application saveOrUpdate(Application Application) {
        return ApplicationRepository.save(Application);
    }

    public void deleteById(Long id) {
        if(!ApplicationRepository.existsById(id)) {
             throw new CandidatureNotFoundException@@("Candidature introuvable));
        }
        ApplicationRepository.deleteById(id);
    }
    
}



```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/CandidatureNotFoundException#