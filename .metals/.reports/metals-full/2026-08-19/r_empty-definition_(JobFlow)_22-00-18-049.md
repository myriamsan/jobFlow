error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/ApplicationController.java:_empty_/ApplicationService#saveOrUpdate#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/ApplicationController.java
empty definition using pc, found symbol in pc: _empty_/ApplicationService#saveOrUpdate#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 1848
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/ApplicationController.java
text:
```scala
package com.example.JobFlow.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JobFlow.Entity.Application;
import com.example.JobFlow.Repository.ApplicationRepository;


// Adresse pour le front
@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/applications")

public class ApplicationController {

private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.findAll();
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
        Application applicationCreated = applicationService.saveOrUpdate(application);
        return new ResponseEntity<>(applicationCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Application application = applicationService.findById(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody Application applicationDetails) {
        Application existingApplication = applicationService.findById(id);

        existingApplication.setCompany(applicationDetails.getCompany());
        existingApplication.setLienOffre(applicationDetails.getLienOffre());

        Application updatedApplication = applicationService.saveOrU@@pdate(existingApplication);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/ApplicationService#saveOrUpdate#