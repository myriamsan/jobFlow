package com.example.jobFlow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jobFlow.entity.Company;
import com.example.jobFlow.services.CompanyService;

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
    public List<Company> getAllCompanies() {
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

        existingCompany.setName(companyDetails.getName());
        existingCompany.setSector(companyDetails.getSector());
        existingCompany.setCity(companyDetails.getCity());
        existingCompany.setWebsite(companyDetails.getWebsite());

        Company updatedCompany = companyService.saveOrUpdate(existingCompany);
        return new ResponseEntity<>(updatedCompany, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
