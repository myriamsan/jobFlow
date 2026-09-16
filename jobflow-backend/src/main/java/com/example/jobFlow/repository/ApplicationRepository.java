package com.example.jobFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobFlow.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
