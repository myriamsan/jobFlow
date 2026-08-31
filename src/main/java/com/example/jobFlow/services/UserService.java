package com.example.jobFlow.services;

import org.springframework.stereotype.Service;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.entity.User;
import com.example.jobFlow.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "L'utilisateur introuvable avec l'id " + id));
    }

    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("L'utilisateur introuvable avec l'id " + id);
        }
        userRepository.deleteById(id);
    }

}