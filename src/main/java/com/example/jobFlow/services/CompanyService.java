                                                                                                        package com.example.jobFlow.services;

import org.springframework.stereotype.Service;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.entity.Company;
import com.example.jobFlow.repository.CompanyRepository;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findById(Long id) {
        return companyRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Entreprise introuvable avec l'id " + id
        ));
    }

    public Company saveOrUpdate(Company company) {
        return companyRepository.save(company);
    }

    public void deleteById(Long id) {
        if(!companyRepository.existsById(id)) {
             throw new ResourceNotFoundException("Entreprise introuvable avec l'id " + id);
        }
        companyRepository.deleteById(id);
    }

}
