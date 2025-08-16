package com.example.DDDProject;

import com.example.DDDProject.application.UserService;
import com.example.DDDProject.domain.entities.User;
import com.example.DDDProject.domain.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    void createUser_Success() {
        // Arrange
        String username = "testuser";
        String password = "testpass";
        User user = new User(username, password);
        User savedUser = new User(1L, username, password);
        
        when(userRepository.existsByUsername(username)).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // Act
        User result = userService.createUser(username, password);

        // Assert
        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertEquals(password, result.getPassword());
        assertEquals(1L, result.getId());
        
        verify(userRepository).existsByUsername(username);
        verify(userRepository).save(any(User.class));
    }

    @Test
    void createUser_UserExists_ThrowsException() {
        // Arrange
        String username = "existinguser";
        String password = "testpass";
        
        when(userRepository.existsByUsername(username)).thenReturn(true);

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(username, password);
        });
        
        verify(userRepository).existsByUsername(username);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void getUserById_UserExists_ReturnsUser() {
        // Arrange
        Long userId = 1L;
        User user = new User(userId, "testuser", "testpass");
        
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Act
        User result = userService.getUserById(userId);

        // Assert
        assertNotNull(result);
        assertEquals(user, result);
        verify(userRepository).findById(userId);
    }

    @Test
    void getUserById_UserNotExists_ReturnsNull() {
        // Arrange
        Long userId = 999L;
        
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act
        User result = userService.getUserById(userId);

        // Assert
        assertNull(result);
        verify(userRepository).findById(userId);
    }
}
