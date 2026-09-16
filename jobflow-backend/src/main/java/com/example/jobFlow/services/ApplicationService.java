package com.example.jobFlow.services;

import org.springframework.stereotype.Service;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.entity.Application;
import com.example.jobFlow.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> findAll() {
        return applicationRepository.findAll();
    }

    public Application findById(Long id) {
        return applicationRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
            "Candidature introuvable avec l'id " + id
        ));
    }

    public Application saveOrUpdate(Application application) {
        return applicationRepository.save(application);
    }

    public void deleteById(Long id) {
        if(!applicationRepository.existsById(id)) {
             throw new ResourceNotFoundException("Candidature introuvable avec l'id " + id);
        }
        applicationRepository.deleteById(id);
    }

}
