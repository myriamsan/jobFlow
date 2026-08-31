error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/CompanyController.java:com/example/JobFlow/Entity/Company#getLienOffre#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Controller/CompanyController.java
empty definition using pc, found symbol in pc: com/example/JobFlow/Entity/Company#getLienOffre#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 1611
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
import com.example.JobFlow.Services.CompanyService;


// Adresse pour le front
@CrossOrigin(origins = "http://localhost:4200")
@RestController 
@RequestMapping("/api/companies")

public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanys() {
        return companyService.findAll();
    }

    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company companyCreated = companyService.saveOrUpdate(company);
        return new ResponseEntity<>(companyCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        Company company = companyService.findById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company companyDetails) {
        Company existingCompany = companyService.findById(id);

        existingCompany.setCompany(companyDetails.getCompany());
        existingCompany.setSecteur(companyDetails.getLienOffre@@());

        Company updatedCompany = companyService.saveOrUpdate(existingCompany);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: com/example/JobFlow/Entity/Company#getLienOffre#