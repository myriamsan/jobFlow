package com.example.jobFlow.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.jobFlow.entity.Application;
import com.example.jobFlow.services.ApplicationService;

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
    public ResponseEntity<Application> updateApplication(@PathVariable Long id,
            @RequestBody Application applicationDetails) {
        Application existingApplication = applicationService.findById(id);

        existingApplication.setJobTitle(applicationDetails.getJobTitle());
        existingApplication.setApplicationDate(applicationDetails.getApplicationDate());
        existingApplication.setStatus(applicationDetails.getStatus());
        existingApplication.setNotes(applicationDetails.getNotes());
        existingApplication.setJobOfferLink(applicationDetails.getJobOfferLink());
        existingApplication.setCompany(applicationDetails.getCompany());

        Application updatedApplication = applicationService.saveOrUpdate(existingApplication);
        return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
