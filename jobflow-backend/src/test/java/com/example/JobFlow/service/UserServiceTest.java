package com.example.JobFlow.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.jobFlow.exceptions.ResourceNotFoundException;
import com.example.jobFlow.entity.User;
import com.example.jobFlow.repository.UserRepository;
import com.example.jobFlow.services.UserService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock 
    private UserRepository userRepository;

    @InjectMocks
    private UserService  userService; 


    @Test

    void ShouldCreateUser () {

        //  Arrange 
        User user = new User();
        user.setLastName("mimi");
        user.setEmail("mimi@gmail.com");;

        when(userRepository.save(any(User.class)))
            .thenReturn(user);
 
        // Act
        User res = userService.saveOrUpdate(user);
        // Assert
        assertNotNull(res);
        assertEquals("mimi@gmail.com", res.getEmail());
        verify(userRepository, times(1)).save(user);
    }
    
    void ShouldShowExceptionUserDontFind () {

       // Arrange
        when(userRepository.findById(99L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            userService.findById(99L);
        });   
    }

    void ShouldDeleteUser () {
        // Arrange
        Long id = 3L;
        when(userRepository.existsById(id)).thenReturn(true);
 
        // Act
        userService.deleteById(id);

        // Assert
        verify(userRepository, times(1)).deleteById(id);
    }

}

