error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/CompanyController.java:_empty_/ApplicationService#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/CompanyController.java
empty definition using pc, found symbol in pc: _empty_/ApplicationService#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 535
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/CompanyController.java
text:
```scala
package com.example.JobFlow.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JobFlow.Entity.Company;
import com.example.JobFlow.Repository.CompanyRepository;


// Adresse pour le front
@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/companies")

public class CompanyController {

     private final @@ApplicationService applicationService;

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

        Application updatedApplication = applicationService.saveOrUpdate(existingApplication);
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

empty definition using pc, found symbol in pc: _empty_/ApplicationService#